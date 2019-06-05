package colorpicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Color Picker Demo");

        JPanel generalPanel = new JPanel();
        JPanel panel = new JPanel(new GridLayout(3,0));
        JPanel colorpanel = new JPanel();
        generalPanel.setBorder(new EmptyBorder(20,20,20,20));



        JSlider red = new JSlider(0,255, 125);
        JSlider green = new JSlider(0,255, 125);
        JSlider blue = new JSlider(0,255, 125);

        red.setMinorTickSpacing(10);
        red.setPaintTicks(true);
        red.setPaintLabels(true);
        green.setMinorTickSpacing(10);
        green.setPaintTicks(true);
        green.setPaintLabels(true);
        blue.setMinorTickSpacing(10);
        blue.setPaintTicks(true);
        blue.setPaintLabels(true);

        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put( 0 , new JLabel("0") );
        labelTable.put(255, new JLabel("255") );

        red.setLabelTable (labelTable);
        green.setLabelTable (labelTable);
        blue.setLabelTable (labelTable);

        colorpanel.setBackground(new Color(125,125,125));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(generalPanel, BorderLayout.CENTER);
        generalPanel.setLayout(new GridLayout(1,2));
        generalPanel.add(colorpanel);
        generalPanel.add(panel);

        panel.add(new JLabel("Red: ",   JLabel.TRAILING));
        panel.add(red);
        panel.add(new JLabel("Green: ",  JLabel.TRAILING)) ;
        panel.add(green);
        panel.add(new JLabel("Blue: ", JLabel.TRAILING));
        panel.add(blue);

        red.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            Color currentColor = colorpanel.getBackground();
            colorpanel.setBackground( new Color (source.getValue(), currentColor.getGreen(),currentColor.getBlue()));
        });
        green.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            Color currentColor = colorpanel.getBackground();
            colorpanel.setBackground( new Color (currentColor.getRed(), source.getValue(),currentColor.getBlue()));
        });
        blue.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            Color currentColor = colorpanel.getBackground();
            colorpanel.setBackground( new Color (currentColor.getRed(), currentColor.getGreen(), source.getValue()));
        });

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                colorpanel.setToolTipText((Integer.toHexString(colorpanel.getBackground().getRGB())).toUpperCase());
            }
        };
        colorpanel.addMouseListener(ma);
    }




}
