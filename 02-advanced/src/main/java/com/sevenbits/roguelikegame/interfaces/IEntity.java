package com.sevenbits.roguelikegame.interfaces;

/**
 * Interface with 4 virtual methods
 */
public interface IEntity extends IMovable {
    /**
     * Setting entity's new health
     *
     * @param health - entity's new health
     */
    void setHealth(int health);

    /**
     * Getting entity's health
     *
     * @return int - entity's health
     */
    int getHealth();

    /**
     * Setting entity's new alive value
     *
     * @param flag - entity's new alive value
     */
    void setAlive(boolean flag);

    /**
     * Getting isAlive value
     *
     * @return boolean - true if entity is alive and false else if
     */
    boolean isAlive();
}
