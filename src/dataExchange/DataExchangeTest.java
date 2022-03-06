package dataExchange;

import java.awt.*;
import javax.swing.*;

/**
 * @author Tomek
 *
 */
public class DataExchangeTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame frame = new DataExchangeFrame();
            frame.setTitle("DataExchangeTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}