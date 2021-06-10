package org.emp.gl.Launcher;

import org.emp.gl.core.Lookup.Lookup;
import org.emp.gl.gui.Maze;
import org.emp.gl.robotstate.MyRobot;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        Maze maze = new Maze();
        Lookup.getInstance().register(MyRobot.class,new MyRobot());
        maze.initializeWindow();
    }

}
