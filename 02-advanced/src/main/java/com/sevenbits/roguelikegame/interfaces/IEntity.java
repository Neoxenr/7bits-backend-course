package com.sevenbits.roguelikegame.interfaces;

/**
 * Interface with 4 virtual methods
 */
public interface IEntity {
    /**
     * Setting entity's position at x axis
     * @param x - new entity's position at x axis
     */
    void setX(int x);

    /**
     * @return int - current entity's position at x axis
     */
    int getX();

    /**
     * Setting entity's position at y axis
     * @param y - new entity's position at y axis
     */
    void setY(int y);

    /**
     * @return int - current entity's position at y axis
     */
    int getY();

    /**
     * Setting entity's new health
     * @param health - entity's new health
     */
    void setHealth(int health);

    /**
     * Getting entity's health
     * @return int - entity's health
     */
    int getHealth();

    /**
     * Setting entity's new alive value
     * @param flag - entity's new alive value
     */
    void setAlive(boolean flag);

    /**
     * Getting isAlive value
     * @return boolean - true if entity is alive and false else if
     */
    boolean isAlive();
}
