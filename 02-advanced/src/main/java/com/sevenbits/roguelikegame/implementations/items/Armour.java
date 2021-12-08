package com.sevenbits.roguelikegame.implementations.items;

import com.sevenbits.roguelikegame.interfaces.IItem;

/**
 * IItem implementation
 */
public class Armour implements IItem {
    private final int x, y;

    private boolean isTaken;

    /**
     * Armour initializing
     * @param x - armour's position at x axis
     * @param y = armour's position at y axis
     */
    public Armour(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.isTaken = false;
    }

    /**
     * Getting armour's position at x axis
     * @return int - current armour's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getting armour's position at y axis
     * @return int - current armour's position at y axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setting armour's new isTaken value
     * @param flag - armour's new isTaken value
     */
    public void setActive(final boolean flag) {
        this.isTaken = flag;
    }

    /**
     * Getting armour's isTaken value
     * @return boolean - true if armour has taken and false if armour hasn't taken
     */
    public boolean isActive() {
        return this.isTaken;
    }
}
