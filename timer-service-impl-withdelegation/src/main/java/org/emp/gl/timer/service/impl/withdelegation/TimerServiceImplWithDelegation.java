/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service.impl.withdelegation;

import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;



public class TimerServiceImplWithDelegation  extends TimerTask
        implements TimerService {

    int dixiemeDeSeconde;

    int secondes;



    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();

        LocalTime localTime = LocalTime.now();

        secondes = localTime.getSecond();

        dixiemeDeSeconde = localTime.getNano() / 100000000;
        timer.scheduleAtFixedRate(this, 100, 100);
    }

    @Override
    public void run() {
        timeChanged();
    }

    PropertyChangeSupport PCS = new PropertyChangeSupport(this);

    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
        //listeners.add(pl);
        PCS.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        //listeners.remove(pl);
        PCS.removePropertyChangeListener(pl);
    }



    @Override
    public int getSecondes() {
        return secondes;
    }




    private void timeChanged() {
        updateDixiemeDeSecode();
    }

    protected void updateDixiemeDeSecode() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;
        PCS.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, oldValue,dixiemeDeSeconde);

        if (dixiemeDeSeconde == 0) {
            updateSecode();
        }
    }

    protected void updateSecode() {
        int oldValue = secondes;
        secondes = secondes + 1;


        PCS.firePropertyChange(TimerChangeListener.SECONDE_PROP, oldValue,secondes);



    }





}

