package org.bitstorm.gameoflife.commandpkg;

import org.bitstorm.gameoflife.GameOfLifeControls;

import java.util.HashMap;


public class zoomCommand implements GameOfLifeCommand {



    private static final HashMap<String,Integer> zoomMap = new HashMap<String,Integer>();

    GameOfLifeControls controls;

    public zoomCommand(GameOfLifeControls controls){
        this.controls=controls;
        zoomMap.put("Big",new Integer(11));
        zoomMap.put("Medium",new Integer(7));
        zoomMap.put("Small",new Integer(3));


    }
    public void execute(String args){
        controls.zoomChanged(zoomMap.get(args));
    }
}