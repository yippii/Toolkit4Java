package com.litszwaiboris.Toolkit;

import java.io.*;
import java.util.*;
import javax.swing.*;

import org.apache.commons.lang3.*;

public class Methods {

    static String[] choices = { "Yes", "No" };

    public static void MacCheck() throws NullPointerException {
        if (!SystemUtils.IS_OS_MAC) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "This OS does not support Mac OS X Toolkit. Aborting...");
            System.exit(0);
        }
    }

    private static void command(String arg) throws IOException {
        String[] command = {"bash", "-c", arg};
        Process a = new ProcessBuilder(command).start();
        String line;
        BufferedReader is = new BufferedReader(new InputStreamReader(a.getInputStream()));
        while ((line = is.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void del_launchpad_apps(String appName) throws IOException {
        int confirm = JOptionPane.showOptionDialog(JOptionPane.getRootFrame(), "Confirm to proceed?", null, JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE, null, choices, null);
        if (Objects.equals(confirm, 0)) {
            command("sqlite3 $(getconf DARWIN_USER_DIR)com.apple.dock.launchpad/db/db \"DELETE FROM apps WHERE title='" + appName + "'" + '\"');
            command("killall Dock");
            System.out.println("Completed.");
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Aborted.");
        }
    }

    public static void reset_launchpad() throws IOException {
        int confirm = JOptionPane.showOptionDialog(JOptionPane.getRootFrame(), "Confirm to proceed?", null, JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE, null, choices, null);
        if (Objects.equals(confirm, 0)) {
            command("defaults write com.apple.dock ResetLaunchPad -bool true");
            command("killall Dock");
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Completed.");
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Aborted.");
        }
    }

    public static void desktop_icons() throws IOException, InterruptedException {
        String[] choice = {"Enable", "Disable"};
        int eORd = JOptionPane.showOptionDialog(JOptionPane.getRootFrame(), "Enable/Disable Desktop Icons?", "Desktop Icons", JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE, null, choice, null);
        if (Objects.equals(eORd,0)) {
            int confirm = JOptionPane.showOptionDialog(JOptionPane.getRootFrame(), "Confirm to proceed?", null, JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE, null, choices, null);
            if (Objects.equals(confirm, 0)) {
                command("defaults write com.apple.Finder CreateDesktop true");
                command("killall Finder");
                command("Killall Dock");
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Completed.");
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Aborted.");
            }
        }
        else if (Objects.equals(eORd,1)) {
            int confirm = JOptionPane.showOptionDialog(JOptionPane.getRootFrame(), "Confirm to proceed?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, null);
            if (Objects.equals(confirm, 0)) {
                command("defaults write com.apple.Finder CreateDesktop false");
                command("killall Finder");
                command("Killall Dock");
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Completed.");
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Aborted.");
            }
        }
    }
}