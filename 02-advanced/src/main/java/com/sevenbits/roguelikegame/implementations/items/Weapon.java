package com.sevenbits.roguelikegame.implementations.items;

import com.sevenbits.roguelikegame.interfaces.IItem;

/**
 * IItem implementation
 */
public class Weapon implements IItem {
    private final int x, y;

    private boolean isTaken;

    /**
     * Weapon initializing
     * @param x - weapon's position at x axis
     * @param y - weapon's position at y axis
     */
    public Weapon(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.isTaken = false;
    }

    /**
     * Getting weapon's position at x axis
     * @return int - current weapon's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getting weapon's position at y axis
     * @return int - current weapon's position at y axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setting weapon's new isTaken value
     * @param flag - weapon's new isTaken value
     */
    public void setActive(final boolean flag) {
        this.isTaken = flag;
    }

    /**
     * Getting weapon's isTaken value
     * @return boolean - true if weapon has taken and false if weapon hasn't taken
     */
    public boolean isActive() {
        return this.isTaken;
    }
}
