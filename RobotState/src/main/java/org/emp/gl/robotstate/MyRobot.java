package org.emp.gl.robotstate;
import org.emp.gl.RobotActions.RobotActions;
import org.emp.gl.timer.service.TimerChangeListener;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;


public class MyRobot implements RobotActions  {
    private static MyRobot Instance = null;
    public MyRobot(){};
    public static MyRobot getInstance(){
        if(Instance==null)
            Instance = new MyRobot();
        return Instance;
    }
    State state=new Bas(this);
    int position_x=1;
    int position_y=1;
    int Last_x;
    int Last_y;
    String Orientation;
    final static  public String STATE_RIGHT="State is right";
    final static  public String STATE_LEFT="State is left";
    final static  public String STATE_UP="State is up";
    final static  public String STATE_DOWN="State is down";

    public int getLast_x() {
        return Last_x;
    }

    public void setLast_x(int last_x) {
        Last_x = last_x;
    }

    public int getLast_y() {
        return Last_y;
    }

    public void setLast_y(int last_y) {
        Last_y = last_y;
    }

    public PropertyChangeSupport pce=new PropertyChangeSupport(this);

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public void changeState(State newState){
        state= newState;
    }

    @Override
    public void goRight() {
        state.goRight();
    }

    @Override
    public void goleft() {
        state.goleft();
    }

    @Override
    public void goUp() {
        state.goUp();
    }

    @Override
    public void goDown() {
        state.goDown();
    }

    @Override
    public void move() {
        state.move();
    }

    public void up() {
    }
    public void down() {
    }
    public void left() {
    }
    public void right() {
    }

    public String getOrientation() {
        return Orientation;
    }

    public void setOrientation(String orientation) {
        this.Orientation = orientation;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {

            case TimerChangeListener.SECONDE_PROP:
                state.move();
                pce.firePropertyChange(this.Orientation,null,null);
                break;


            default:
                break;

        }
    }
}
