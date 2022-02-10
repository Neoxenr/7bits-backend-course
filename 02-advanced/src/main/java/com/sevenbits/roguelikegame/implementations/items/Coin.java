package com.sevenbits.roguelikegame.implementations.items;

import com.sevenbits.roguelikegame.interfaces.ICoin;

/**
 * IItem implementation
 */
public class Coin implements ICoin {
    private final int x, y;

    private final int nominal;

    private boolean isTaken;

    /**
     * Coin initializing
     *
     * @param x - coin's position at x axis
     * @param y - coin's position at y axis
     */
    public Coin(final int x, final int y, final int nominal) {
        this.x = x;
        this.y = y;
        this.nominal = nominal;
        this.isTaken = false;
    }

    public int getNominal() {
        return nominal;
    }

    /**
     * Getting coin's position at x axis
     *
     * @return int - current coin's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getting coin's position at y axis
     *
     * @return int - current coin's position at y axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setting coin's new isTaken value
     *
     * @param flag - coin's new isTaken value
     */
    public void setActive(final boolean flag) {
        this.isTaken = flag;
    }

    /**
     * Getting coin's isTaken value
     *
     * @return boolean - true if coin has taken and false if coin hasn't taken
     */
    public boolean isActive() {
        return this.isTaken;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
