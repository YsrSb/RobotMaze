package org.emp.gl.robotstate;

public class Haut  extends State{
    public Haut(MyRobot r) {
        super(r);
    }

    @Override
    public void goRight() {
        robot.changeState(new Droite(robot));
    }

    @Override
    public void goleft() {

        robot.changeState(new Gauche(robot));
    }

    @Override
    public void goUp() {

    }

    @Override
    public void goDown() {

    }
    @Override
    public void move() {
        robot.setLast_x(robot.position_x);
        robot.setLast_y(robot.position_y);
        robot.setOrientation(robot.STATE_UP);

        robot.setPosition_y(robot.getPosition_y()+1);

    }
}
