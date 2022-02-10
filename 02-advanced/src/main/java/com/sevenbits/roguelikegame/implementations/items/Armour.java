package com.sevenbits.roguelikegame.implementations.items;

import com.sevenbits.roguelikegame.interfaces.IArmour;

/**
 * IItem implementation
 */
public class Armour implements IArmour {
    private final int x, y;

    private final int strength;

    private boolean isTaken;

    /**
     * Armour initializing
     *
     * @param x - armour's position at x axis
     * @param y = armour's position at y axis
     */
    public Armour(final int x, final int y, final int strength) {
        this.x = x;
        this.y = y;
        this.strength = strength;
        this.isTaken = false;
    }

    public int getStrength() {
        return strength;
    }

    /**
     * Getting armour's position at x axis
     *
     * @return int - current armour's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getting armour's position at y axis
     *
     * @return int - current armour's position at y axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setting armour's new isTaken value
     *
     * @param flag - armour's new isTaken value
     */
    public void setActive(final boolean flag) {
        this.isTaken = flag;
    }

    /**
     * Getting armour's isTaken value
     *
     * @return boolean - true if armour has taken and false if armour hasn't taken
     */
    public boolean isActive() {
        return this.isTaken;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
