package com.sevenbits.roguelikegame.implementations.items;

/**
 * IItem implementation
 */
public class Weapon implements IItem {
    private final int x, y;

    private boolean isTaken;

    /**
     * @param x - weapon's position at x axis
     * @param y - weapon's position at y axis
     */
    public Weapon(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.isTaken = false;
    }

    /**
     * @return int - current weapon's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return int - current weapon's position at y axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * @return boolean - true if weapon has taken and false if weapon hasn't taken
     */
    public boolean isActive() {
        return this.isTaken;
    }

    /**
     * @param flag - selection of weapon
     */
    public void setActive(final boolean flag) {
        this.isTaken = flag;
    }
}
