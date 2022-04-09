package view.components.chatsView.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CustomDot extends BasicRadioButtonUI {
    private final String imagePath;

    public CustomDot(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public Icon getDefaultIcon() {
        BufferedImage master;
        try {
            master = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
            try {
                master = ImageIO.read(new File("src/main/resources/Images/default_icon.png"));
            } catch (Exception x) {
                x.printStackTrace();
                return new ImageIcon();
            }
        }
        int diameter = Math.min(master.getWidth(), master.getHeight());
        BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = mask.createGraphics();
        applyQualityRenderingHints(g2d);
        g2d.fillOval(0, 0, diameter - 1, diameter - 1);
        g2d.dispose();

        BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = masked.createGraphics();
        applyQualityRenderingHints(g2d);
        int x = (diameter - master.getWidth()) / 2;
        int y = (diameter - master.getHeight()) / 2;
        g2d.drawImage(master, x, y, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2d.drawImage(mask, 0, 0, null);

        Image image = masked.getScaledInstance(60, 60, Image.SCALE_FAST);
        return new ImageIcon(image);
    }

    public static void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_RESOLUTION_VARIANT, RenderingHints.VALUE_RESOLUTION_VARIANT_SIZE_FIT);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
    }
}
