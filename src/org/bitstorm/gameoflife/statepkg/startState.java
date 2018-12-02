package org.bitstorm.gameoflife.statepkg;

import java.awt.*;

public class startState implements GameOfLifeStates {

    @Override
    public void doAction(final startstopContext context) {
        context.getcontrols().stop();
        context.setState(new stopState());
    }
}
