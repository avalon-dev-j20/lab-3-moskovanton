package colorPicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Color Picker");

        JPanel mainPanel = new JPanel();
        JPanel sliderPanel = new JPanel(new GridLayout(3, 1));
        
        JPanel colorPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
       
        JSlider red = new JSlider(0, 255, 125);
        JSlider green = new JSlider(0, 255, 125);
        JSlider blue = new JSlider(0, 255, 125);
        
        
        red.setMajorTickSpacing(255);
        red.setMinorTickSpacing(17);
        red.setPaintTicks(true);
        red.setPaintLabels(true);
        
        green.setMajorTickSpacing(255);
        green.setMinorTickSpacing(17);
        green.setPaintTicks(true);
        green.setPaintLabels(true);
        blue.setMajorTickSpacing(255);
        blue.setMinorTickSpacing(17);
        blue.setPaintTicks(true);
        blue.setPaintLabels(true);

        colorPanel.setBackground(new Color(125, 125, 125));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new GridLayout(1, 2));
        mainPanel.add(colorPanel);
        mainPanel.add(sliderPanel);
        
        sliderPanel.add(new JLabel("Red:     ", JLabel.TRAILING));
        sliderPanel.add(red);
        sliderPanel.add(new JLabel("Green: ", JLabel.TRAILING)) ;
        sliderPanel.add(green);
        sliderPanel.add(new JLabel("Blue:    ", JLabel.TRAILING));
        sliderPanel.add(blue);

        red.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            Color currentColor = colorPanel.getBackground();
            colorPanel.setBackground(new Color(source.getValue(), currentColor.getGreen(), currentColor.getBlue()));
        });
        green.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            Color currentColor = colorPanel.getBackground();
            colorPanel.setBackground(new Color(currentColor.getRed(), source.getValue(), currentColor.getBlue()));
        });
        blue.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            Color currentColor = colorPanel.getBackground();
            colorPanel.setBackground(new Color(currentColor.getRed(), currentColor.getGreen(), source.getValue()));
        });

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String c = (Integer.toHexString(colorPanel.getBackground().getRGB()).toUpperCase());
                colorPanel.setToolTipText("#" + c.substring(2, c.length()));
            }
        };
        colorPanel.addMouseListener(ma);
    }
}
