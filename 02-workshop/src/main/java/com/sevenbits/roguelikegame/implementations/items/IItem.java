package com.sevenbits.roguelikegame.implementations.items;

/**
 * Interface with 4 virtual methods
 */
public interface IItem {
    /**
     * @return int - current item's position at x axis
     */
    int getX();

    /**
     * @return int - current item's position at y axis
     */
    int getY();

    /**
     * @return boolean - true if item has taken and false if item hasn't taken
     */
    boolean isActive();

    /**
     * @param flag - selection of item
     */
    void setActive(boolean flag);
}
