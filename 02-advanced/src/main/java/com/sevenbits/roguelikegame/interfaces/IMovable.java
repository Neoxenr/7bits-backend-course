package com.sevenbits.roguelikegame.interfaces;

public interface IMovable extends IFixed {
    /**
     * Set new position at X axis
     *
     * @param x - new position at X axis
     */
    void setX(int x);

    /**
     * Set new position at Y axis
     *
     * @param y - new position at Y axis
     */
    void setY(int y);
}
