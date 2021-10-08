package com.sevenbits.roguelikegame.implementations.entities;

import com.sevenbits.roguelikegame.implementations.containers.Inventory;

/**
 * IEntity implementation
 */
public class Player implements IPlayer {
    private int x, y;

    private final Inventory inventory;

    /**
     * @param x                 - player's position at x axis
     * @param y                 - player's position at y axis
     * @param inventoryCapacity - player's inventory size
     */
    public Player(final int x, final int y, final int inventoryCapacity) {
        this.x = x;
        this.y = y;
        this.inventory = new Inventory(inventoryCapacity);
    }

    /**
     * @return int - current player's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return int - current player's position at x axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * @param x - new player's position at x axis
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @param y new player's position at y axis
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * @return Inventory - current player's inventory
     */
    public Inventory getInventory() {
        return this.inventory;
    }
}
