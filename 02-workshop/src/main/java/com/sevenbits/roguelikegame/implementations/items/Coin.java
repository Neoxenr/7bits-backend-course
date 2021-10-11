package com.sevenbits.roguelikegame.implementations.items;

/**
 * IItem implementation
 */
public class Coin implements IItem {
    private final int x, y;

    private boolean isTaken;

    /**
     * @param x - coin's position at x axis
     * @param y - coin's position at y axis
     */
    public Coin(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.isTaken = false;
    }

    /**
     * @return int - current coin's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return int - current coin's position at y axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * @return boolean - true if coin has taken and false if coin hasn't taken
     */
    public boolean isActive() {
        return this.isTaken;
    }

    /**
     * @param flag - selection of coin
     */
    public void setActive(final boolean flag) {
        this.isTaken = flag;
    }
}
