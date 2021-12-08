package com.sevenbits.roguelikegame.interfaces;

/**
 * Interface with 4 virtual methods
 */
public interface IItem {
    /**
     * Getting item's position at x axis
     * @return int - current item's position at x axis
     */
    int getX();

    /**
     * Getting item's position at y axis
     * @return int - current item's position at y axis
     */
    int getY();

    /**
     * Setting item's new isTaken value
     * @param flag - item's new isTaken value
     */
    void setActive(boolean flag);

    /**
     * Getting item's isTaken value
     * @return boolean - true if item has taken and false if item hasn't taken
     */
    boolean isActive();
}
