package org.bitstorm.gameoflife.commandpkg;

import org.bitstorm.gameoflife.GameOfLifeControls;

import java.util.HashMap;


public class speedCommand implements GameOfLifeCommand {



    private static final HashMap<String,Integer> speedMap = new HashMap<String,Integer>();



    GameOfLifeControls controls;

    public speedCommand(GameOfLifeControls controls){
        this.controls=controls;
        speedMap.put("Slow",new Integer(1000));
        speedMap.put("Fast",new Integer(100));
        speedMap.put("Hyper",new Integer(10));
        speedMap.put("Ultra",new Integer(1));

    }
    public void execute(String args){
        controls.speedChanged(speedMap.get(args));
    }
}