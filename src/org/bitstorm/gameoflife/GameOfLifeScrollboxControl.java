package org.bitstorm.gameoflife;

import java.util.HashMap;
import org.bitstorm.gameoflife.commandpkg.GameOfLifeCommand;

public class GameOfLifeScrollboxControl {

    GameOfLifeCommand speedCommand;
    GameOfLifeCommand zoomCommand;


    public GameOfLifeScrollboxControl(GameOfLifeCommand speedC,GameOfLifeCommand zoomC){
        speedCommand = speedC;
        zoomCommand = zoomC;

    }

    public void speedCommand(String args){
        speedCommand.execute(args);
    }

    public void zoomCommand(String args){
        zoomCommand.execute(args);
    }


}



