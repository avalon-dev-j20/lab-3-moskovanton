package colorPicker;

import java.awt.Dimension;
import javax.swing.WindowConstants;


public class ColorPicker {
    public static void main(String[] args) {
        MainFrame f = new MainFrame();
        f.setMinimumSize(new Dimension(470, 240));
        f.setBounds(200,300,470,240);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }
}
