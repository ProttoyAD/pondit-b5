package com.pondit.io.examples.is.bytearrayinputstream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ByteArrayInputStreamExample {
    public static void main(String[] args) throws IOException {
        openNewJFrame();
        openNewJFrame();
        openNewJFrame();
    }

    private static void openNewJFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1200, 700);
        frame.setVisible(true);
        frame.setLayout(null);

        JPanel panel = new MyImagePanel();
        frame.setContentPane(panel);
        panel.setSize(500, 350);

        panel.repaint();
        frame.repaint();
    }
}

class MyImagePanel extends JPanel{
    public void paintComponent(Graphics g){
        var file = new File(System.getProperty("user.home") + "\\Pictures\\UC-d2eb1e56-b84e-4081-9a6f-8da0d1d7632b.jpg");
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0, 0, 500, 350,  this);
        }
    }
}