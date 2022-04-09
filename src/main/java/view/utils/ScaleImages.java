package view.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScaleImages {

    public ImageIcon getNewImage(String path, int width, int height) throws IOException {
        BufferedImage master = ImageIO.read(new File(path));
        Image image = master.getScaledInstance(width, height, Image.SCALE_FAST);
        return new ImageIcon(image);
    }
}
