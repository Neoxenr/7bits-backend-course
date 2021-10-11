package com.sevenbits.roguelikegame.implementations.entities;

/**
 * Interface with 4 virtual methods
 */
public interface IEntity {
    /**
     * @return int - current entity's position at x axis
     */
    int getX();

    /**
     * @return int - current entity's position at y axis
     */
    int getY();

    /**
     * @param x - new entity's position at x axis
     */
    void setX(int x);

    /**
     * @param y - new entity's position at y axis
     */
    void setY(int y);
}
