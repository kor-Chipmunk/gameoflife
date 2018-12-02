package org.bitstorm.gameoflife.statepkg;

import org.bitstorm.gameoflife.GameOfLifeControls;
import org.bitstorm.gameoflife.GameOfLife;

import java.awt.*;
import java.util.Vector;

public class startstopContext {
    private GameOfLifeStates state;

    private GameOfLife mylife;
    public startstopContext(GameOfLife lifemain){

        state = new stopState();
        mylife = lifemain;
    }

    public void setState(GameOfLifeStates state){
        this.state = state;
    }

    public GameOfLifeStates getState(){
        return state;
    }
    public GameOfLife getcontrols(){
        return mylife;
    }


}

