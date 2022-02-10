package com.sevenbits.roguelikegame.implementations.items;

import com.sevenbits.roguelikegame.interfaces.IWeapon;

/**
 * IItem implementation
 */
public class Weapon implements IWeapon {
    private final int x, y;

    private boolean isTaken;

    private final int wear;

    private final String kind;

    /**
     * Weapon initializing
     *
     * @param x - weapon's position at x axis
     * @param y - weapon's position at y axis
     */
    public Weapon(final int x, final int y, final int wear, final String kind) {
        this.x = x;
        this.y = y;
        this.wear = wear;
        this.kind = kind;
        this.isTaken = false;
    }

    public int getWear() {
        return wear;
    }

    public String getKind() {
        return kind;
    }

    /**
     * Get weapon's position at x axis
     *
     * @return int - current weapon's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get weapon's position at y axis
     *
     * @return int - current weapon's position at y axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * Set weapon's new isTaken value
     *
     * @param flag - weapon's new isTaken value
     */
    public void setActive(final boolean flag) {
        this.isTaken = flag;
    }

    /**
     * Get weapon's isTaken value
     *
     * @return boolean - true if weapon has taken and false if weapon hasn't taken
     */
    public boolean isActive() {
        return this.isTaken;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
