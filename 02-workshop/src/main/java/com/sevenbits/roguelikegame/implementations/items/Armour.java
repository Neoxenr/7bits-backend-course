package com.sevenbits.roguelikegame.implementations.items;

/**
 * IItem implementation
 */
public class Armour implements IItem {
    private final int x, y;

    private boolean isTaken;

    /**
     * @param x - armour's position at x axis
     * @param y = armour's position at y axis
     */
    public Armour(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.isTaken = false;
    }

    /**
     * @return int - current armour's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return int - current armour's position at y axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * @return boolean - true if armour has taken and false if armour hasn't taken
     */
    public boolean isActive() {
        return this.isTaken;
    }

    /**
     * @param flag - selection of armour
     */
    public void setActive(final boolean flag) {
        this.isTaken = flag;
    }
}
