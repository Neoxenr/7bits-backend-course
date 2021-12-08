package com.sevenbits.roguelikegame.implementations.entities;

import com.sevenbits.roguelikegame.implementations.containers.Inventory;
import com.sevenbits.roguelikegame.implementations.containers.Wallet;
import com.sevenbits.roguelikegame.interfaces.IEntity;

/**
 * IEntity implementation
 */
public class Player implements IEntity {
    private int x, y;

    private int health;

    private int stamina;

    private final Wallet wallet;

    private final Inventory inventory;

    private boolean isAlive;

    private final int fullCapacity = 100;

    /**
     * Player initializing
     * @param x - player's position at x axis
     * @param y - player's position at y axis
     */
    public Player(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.isAlive = true;
        this.inventory = new Inventory();
        this.wallet = new Wallet();
        this.health = fullCapacity;
        this.stamina = fullCapacity;
    }

    /**
     * Setting player's new position at x axis
     * @param x - player's new position at x axis
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Getting player's position at x axis
     * @return int - current player's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * Setting player's new position at y axis
     * @param y - player's new position at y axis
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Getting player's position at y axis
     * @return int - current player's position at x axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setting player's new alive value
     * @param flag - player's new alive value
     */
    public void setAlive(final boolean flag) {
        this.isAlive = flag;
    }

    /**
     * Getting player's alive value
     * @return boolean - player's alive value
     */
    public boolean isAlive() {
        return this.isAlive;
    }

    /**
     * Setting player's new health
     * @param health - player's new health
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     * Getting player's health
     * @return int - player's health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Setting player's new stamina
     * @param stamina - player's new stamina
     */
    public void setStamina(final int stamina) {
        this.stamina = stamina;
    }

    /**
     * Getting player's stamina
     * @return int - player's stamina
     */
    public int getStamina() {
        return this.stamina;
    }

    /**
     * Player's attacking
     * @param enemy - enemy which is will be attacked
     */
    public void attack(final Enemy enemy) {
        final int playerHit = 15;
        final int enemyHit = 10;

        final int staminaCost = 5;

        while (health > 0 && enemy.getHealth() > 0) {
            if (stamina > 0) {
                stamina -= staminaCost;

                enemy.setHealth(enemy.getHealth() - playerHit);

                System.out.println("Player has attacked enemy");

                System.out.printf("Enemy health: %d\n", enemy.getHealth());
                System.out.printf("Spent stamina: %d " +
                        "\nSpent health: %d\n\n", fullCapacity - stamina, fullCapacity - health);
            }

            health -= enemyHit;

            System.out.println("Enemy has attacked player");

            System.out.printf("Player health: %d\n\n", health);
        }

        System.out.println("Result of fight");
        System.out.printf("Player health: %d\nEnemy health: %d\n\n", health, enemy.getHealth());

        enemy.setAlive(enemy.getHealth() > 0);

        isAlive = health > 0;
    }

    /**
     * Getting player's inventory
     * @return Inventory - current player's inventory
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Getting player's wallet
     * @return Wallet - current player's wallet
     */
    public Wallet getWallet() {
        return this.wallet;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Player info\n").append("Health: ").append(health).append('\n').
                append("Stamina: ").append(stamina).append('\n').
                append("Count of things in inventory: ").append(inventory.getSize()).append('\n').
                append("Count of coins in wallet: ").append(wallet.getSize()).append('\n');
        return stringBuilder.toString();
    }
}
