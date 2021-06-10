package org.emp.gl.gui;

import org.emp.gl.core.Lookup.Lookup;
import org.emp.gl.robotstate.MyRobot;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;




public class Maze implements PropertyChangeListener { // see java naming conventions https://www.geeksforgeeks.org/java-naming-conventions/
    public static MyRobot robot= Lookup.getInstance().getService(MyRobot.class);
    static char[][] puzzle = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, };


    public void initializeWindow() {
        JFrame mainFrame = new JFrame("Maze Solver");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(puzzle.length, puzzle[0].length));// avoid null layouts
        //mainFrame.setSize(1920, 1080); //use preferred size and let layout manager set the size
        mainFrame.setLocationRelativeTo(null);

        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle[0].length; col++) {
                JLabel label = makeLabel(puzzle[row][col]);
                mainFrame.add(label);
            }
        }
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private JLabel makeLabel(char c) {

        JLabel label= new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(40, 40));
        switch(c) {
            case 1:
                label.setBackground(Color.BLUE);
                break;
                case 2:
                label.setBackground(Color.GREEN);
                break;
            default:
                label.setBackground(Color.WHITE);
                break;

        }
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        return label;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {

            case MyRobot.STATE_DOWN:
                puzzle[robot.getLast_x()][robot.getLast_y()]=0;
                puzzle[robot.getPosition_x()][robot.getPosition_y()]=2;
                makeLabel(puzzle[robot.getPosition_x()][robot.getPosition_y()]);

                break;

            default:
                break;

        }
    }
}