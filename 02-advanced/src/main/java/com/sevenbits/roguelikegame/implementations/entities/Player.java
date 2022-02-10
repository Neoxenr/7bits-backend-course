package com.sevenbits.roguelikegame.implementations.entities;

import com.sevenbits.roguelikegame.implementations.containers.Inventory;
import com.sevenbits.roguelikegame.implementations.containers.Wallet;
import com.sevenbits.roguelikegame.interfaces.IInventory;
import com.sevenbits.roguelikegame.interfaces.IPlayer;
import com.sevenbits.roguelikegame.interfaces.IWallet;

/**
 * IEntity implementation
 */
public class Player implements IPlayer {
    private int x, y;

    private int health;

    private int stamina;

    private final Wallet wallet;

    private final Inventory inventory;

    private boolean isAlive;

    /**
     * Player initializing
     *
     * @param x - player's position at x axis
     * @param y - player's position at y axis
     */
    public Player(final int x, final int y, final int health, final int stamina) {
        this.x = x;
        this.y = y;
        this.isAlive = true;
        this.inventory = new Inventory(1);
        this.wallet = new Wallet(1);
        this.health = health;
        this.stamina = stamina;
    }

    /**
     * Setting player's new position at x axis
     *
     * @param x - player's new position at x axis
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Getting player's position at x axis
     *
     * @return int - current player's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * Setting player's new position at y axis
     *
     * @param y - player's new position at y axis
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Getting player's position at y axis
     *
     * @return int - current player's position at x axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setting player's new alive value
     *
     * @param flag - player's new alive value
     */
    public void setAlive(final boolean flag) {
        this.isAlive = flag;
    }

    /**
     * Getting player's alive value
     *
     * @return boolean - player's alive value
     */
    public boolean isAlive() {
        return this.isAlive;
    }

    /**
     * Setting player's new health
     *
     * @param health - player's new health
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     * Getting player's health
     *
     * @return int - player's health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Setting player's new stamina
     *
     * @param stamina - player's new stamina
     */
    public void setStamina(final int stamina) {
        this.stamina = stamina;
    }

    /**
     * Getting player's stamina
     *
     * @return int - player's stamina
     */
    public int getStamina() {
        return this.stamina;
    }

    /**
     * Getting player's inventory
     *
     * @return Inventory - current player's inventory
     */
    public IInventory getInventory() {
        return this.inventory;
    }

    /**
     * Getting player's wallet
     *
     * @return Wallet - current player's wallet
     */
    public IWallet getWallet() {
        return this.wallet;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Player info:\n").append("Health = ").append(health).append('\n').
                append("Stamina = ").append(stamina).append('\n').
                append("Count of things in inventory = ").append(inventory.getSize()).append(":\n").
                append(inventory).
                append("Count of coins in wallet = ").append(wallet.getSize()).append('\n');

        return stringBuilder.toString();
    }
}
