package org.bitstorm.gameoflife.statepkg;

import java.awt.*;

public class stopState implements GameOfLifeStates {


    @Override
    public void doAction(final startstopContext context) {
        context.getcontrols().start2();
        context.setState(new startState());

    }
}
