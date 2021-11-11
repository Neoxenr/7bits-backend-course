package com.sevenbits.roguelikegame.implementations.entities;

/**
 * IEntity implementation
 */
public class Enemy implements IEntity {
    private int x, y;

    /**
     * @param x - player's position at x axis
     * @param y - player's position at y axis
     */
    public Enemy(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return int - current enemy's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return int - current enemy's position at y axis
     */
    public int getY() {
        return this.y;
    }


    /**
     * @param x - new entity's position at x axis
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @param y - new entity's position at y axis
     */
    public void setY(final int y) {
        this.y = y;
    }
}
