package com.sevenbits.roguelikegame;

import com.sevenbits.roguelikegame.implementations.containers.Chest;
import com.sevenbits.roguelikegame.implementations.containers.Inventory;
import com.sevenbits.roguelikegame.implementations.containers.Wallet;
import com.sevenbits.roguelikegame.implementations.entities.Enemy;
import com.sevenbits.roguelikegame.implementations.entities.Player;
import com.sevenbits.roguelikegame.implementations.items.Armour;
import com.sevenbits.roguelikegame.implementations.items.Coin;
import com.sevenbits.roguelikegame.implementations.items.Weapon;

/**
 * Main application entry point
 */
public final class Main {
    /**
     * Main function for app
     *
     * @param args - console arguments
     */
    public static void main(final String[] args) {
        final int playerX = 5;
        final int playerY = 14;

        Player player = new Player(playerX, playerY);
        Inventory inventory = player.getInventory();

        System.out.println(player);

        final int weaponX = 23;
        final int weaponY = 43;

        Weapon weapon = new Weapon(weaponX, weaponY);

        final int chestX = 15;
        final int chestY = 32;

        Chest chest = new Chest(chestX, chestY);
        chest.putItem(weapon);

        player.setX(chest.getX());
        player.setY(chest.getY());

        inventory.putItem(chest.takeItem(0));

        weapon.setActive(true);

        final int firstEnemyX = 5;
        final int firstEnemyY = 14;

        final int firstEnemyHealth = 80;

        Enemy firstEnemy = new Enemy(firstEnemyX, firstEnemyY, firstEnemyHealth);

        player.setX(firstEnemy.getX());
        player.setY(firstEnemy.getY());

        player.attack(firstEnemy);

        if (player.isAlive()) {
            Wallet wallet = player.getWallet();
            wallet.putItem(new Coin(firstEnemy.getX(), firstEnemy.getY()));
            wallet.putItem(new Coin(firstEnemy.getX(), firstEnemy.getY()));
            wallet.putItem(new Coin(firstEnemy.getX(), firstEnemy.getY()));
        }

        final int armourX = 20;
        final int armourY = 15;

        Armour armour = new Armour(armourX, armourY);

        player.setX(armour.getX());
        player.setY(armour.getY());

        inventory.putItem(armour);

        armour.setActive(true);

        final int secondEnemyX = 24;
        final int secondEnemyY = 52;

        final int secondEnemyHealth = 200;

        Enemy secondEnemy = new Enemy(secondEnemyX, secondEnemyY, secondEnemyHealth);

        player.setX(secondEnemy.getX());
        player.setY(secondEnemy.getY());

        player.attack(secondEnemy);

        if (!player.isAlive()) {
            System.out.println(player);
        }
    }

    private Main() {
    }
}
