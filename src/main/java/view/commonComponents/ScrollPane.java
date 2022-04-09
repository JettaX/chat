package view.commonComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ScrollPane extends JScrollPane {

    public ScrollPane(Component view) {
        super(view);
        getVerticalScrollBar().setUI(new CustomScrollBar());
        setBorder(BorderFactory.createEmptyBorder());

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
            }
        });
    }
}
