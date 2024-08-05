package IconScale;

import Interfaces.IIconScale;

import javax.swing.*;
import java.awt.*;

public class IconScale implements IIconScale {
    @Override
    public ImageIcon scaleIcon(String nameIcon, int width, int height) {
        return new ImageIcon(new ImageIcon(getClass().getResource("/icon/" + nameIcon)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}
