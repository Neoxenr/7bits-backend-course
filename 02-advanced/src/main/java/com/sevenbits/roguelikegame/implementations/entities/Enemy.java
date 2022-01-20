package com.sevenbits.roguelikegame.implementations.entities;

import com.sevenbits.roguelikegame.interfaces.IEntity;

public class Enemy implements IEntity {
    private int x, y;

    private int health;

    private boolean isAlive;

    /**
     * Enemy initializing
     *
     * @param x      - enemy position at x axis
     * @param y      - enemy position at y axis
     * @param health - enemy health
     */
    public Enemy(final int x, final int y, final int health) {
        this.x = x;
        this.y = y;
        this.isAlive = true;
        this.health = health;
    }

    /**
     * Setting new enemy position at x axis
     *
     * @param x - new entities position at x axis
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Getting enemy position at x axis
     *
     * @return int - enemy position at x axis
     */
    public int getX() {
        return x;
    }

    /**
     * Setting new enemy position at y axis
     *
     * @param y - new entities position at y axis
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Getting enemy position at y axis
     *
     * @return int - enemy position at y axis
     */
    public int getY() {
        return y;
    }

    /**
     * Setting enemy health
     *
     * @param health - enemy health
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     * Getting enemy health
     *
     * @return int - enemy health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Setting new enemy alive value
     *
     * @param flag - new enemy alive value
     */
    public void setAlive(final boolean flag) {
        this.isAlive = flag;
    }

    /**
     * Getting enemy alive value
     *
     * @return boolean - enemy alive value
     */
    public boolean isAlive() {
        return isAlive;
    }
}
