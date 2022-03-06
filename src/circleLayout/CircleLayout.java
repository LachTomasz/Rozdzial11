package circleLayout;

import java.awt.*;

/**
 * Ramka zawierająca komponenty ułożone w kółko
 * @author Tomek
 *
 */
public class CircleLayout implements LayoutManager {

    private int minWidth = 0;
    private int minHeight = 0;
    private int preferredWidth = 0;
    private int preferredHeight = 0;
    private boolean sizesSet = false;
    private int maxComponentWidth = 0;
    private int maxComponentHeight = 0;

    public void addLayoutComponent (String name, Component comp) {

        //metoda przesłaniająca, za zadanie ma nic nierobić poza przesłonięciem metody
    }

    public void removeLayoutComponent (Component comp) {

        //metoda przesłaniająca, za zadanie ma tylko przesłonić inna metode
    }

    public void setSizes(Container parent) {

        if (sizesSet) return;
        int n = parent.getComponentCount();

        preferredWidth = 0;
        preferredHeight = 0;
        minWidth = 0;
        minHeight = 0;
        maxComponentWidth = 0;
        maxComponentHeight = 0;

        //Obliczanie maksymalnych szerokości i wysokości komponentów
        //oraz ustawianie preferowanego rozmiaru na sumę rozmiarów komponentów
        for (int i = 0; i < n; i++) {

            Component c = parent.getComponent(i);
            if (c.isValid()) {

                Dimension d = c.getPreferredSize();
                maxComponentWidth = Math.max(maxComponentWidth,  d.width);
                maxComponentHeight = Math.max(maxComponentHeight,  d.height);
                preferredWidth += d.width;
                preferredHeight += d.height;
            }
        }

        minWidth = preferredWidth / 2;
        minHeight = preferredHeight / 2;
        sizesSet = true;

    }

    public Dimension preferredLayoutSize(Container parent) {

        setSizes(parent);
        Insets insets = parent.getInsets();
        int width = preferredWidth + insets.left + insets.right;
        int height = preferredHeight + insets.top + insets.bottom;
        return new Dimension(width, height);
    }

    public Dimension minimumLayoutSize(Container parent) {
        setSizes(parent);
        Insets insets = parent.getInsets();
        int Width = minWidth + insets.left + insets.right;
        int height = minHeight + insets.top + insets.bottom;
        return new Dimension(Width, height);
    }

    public void layoutContainer(Container parent) {

        setSizes(parent);

        //Obliczanie środka okręgu
        Insets insets = parent.getInsets();
        int containerWidth = parent.getSize().width - insets.left - insets.right;
        int containerHeight = parent.getSize().height - insets.top - insets.bottom;
        int xcenter = insets.left + containerWidth / 2;
        int ycenter = insets.top + containerHeight / 2;

        //Obliczanie promienia okręgu
        int xradius = (containerWidth - maxComponentWidth) / 2;
        int yradius = (containerHeight - maxComponentHeight) / 2;
        int radius = Math.min(xradius,  yradius);

        //Układanie komponentów na okręgu
        int n = parent.getComponentCount();
        for (int i = 0; i < n; i++) {

            Component c = parent.getComponent(i);
            if(c.isVisible()) {

                double angle = 2 * Math.PI * i /n;

                //Środek komponentu
                int x = xcenter + (int) (Math.cos(angle) * radius);
                int y = ycenter + (int) (Math.sin(angle) * radius);

                //Przesunięcie komponentu, aby jego środek znajdował się w punkcie (x,y),
                //a jego rozmiar był rozmiarem preferowanym
                Dimension d = c.getPreferredSize();
                c.setBounds(x - d.width / 2, y - d.height / 2, d.width, d.height);
            }
        }
    }
}
