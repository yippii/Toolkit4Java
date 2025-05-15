package com.litszwaiboris.Toolkit;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Main {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Boris' Toolkit");
        JPanel panel = new JPanel();
        frame.setBounds(10, 10, 600, 800);
        frame.setResizable(false);
        panel.setLayout(new GridLayout(2, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton launchpad = new JButton("Delete Launchpad Application");
        launchpad.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter launchpad application name", null);
            if (name != null) {try {Methods.del_launchpad_apps(name);} catch (IOException ex) {throw new RuntimeException(ex);}}});

        JButton reset_launchpad = new JButton("Reset Launchpad Layout");
        reset_launchpad.addActionListener(e -> {
                try {Methods.reset_launchpad();} catch (IOException ex) {throw new RuntimeException(ex);}
        });
        JButton desktop_icons = new JButton("Enable/Disable Desktop Icons");
        desktop_icons.addActionListener(e -> {
                try {Methods.desktop_icons();} catch (InterruptedException | IOException ex) {throw new RuntimeException(ex);}
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));
        launchpad.setPreferredSize(new Dimension(200, 100));
        reset_launchpad.setPreferredSize(new Dimension(200, 100));
        desktop_icons.setPreferredSize(new Dimension(200, 100));
        exit.setPreferredSize(new Dimension(200, 100));
        panel.add(launchpad);
        panel.add(reset_launchpad);
        panel.add(desktop_icons);
        panel.add(exit);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Methods.MacCheck();
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}