package com.sevenbits.roguelikegame;

import com.sevenbits.roguelikegame.implementations.containers.Chest;
import com.sevenbits.roguelikegame.implementations.containers.IContainer;
import com.sevenbits.roguelikegame.implementations.entities.Enemy;
import com.sevenbits.roguelikegame.implementations.entities.IEntity;
import com.sevenbits.roguelikegame.implementations.entities.IPlayer;
import com.sevenbits.roguelikegame.implementations.entities.Player;
import com.sevenbits.roguelikegame.implementations.items.Armour;
import com.sevenbits.roguelikegame.implementations.items.Coin;
import com.sevenbits.roguelikegame.implementations.items.IItem;
import com.sevenbits.roguelikegame.implementations.items.Weapon;

/**
 * Main application entry point
 */
public final class Main {
    /**
     * Main function for application
     *
     * @param args - console arguments
     */
    public static void main(final String[] args) {
        final int enemyX = 3, enemyY = 10;
        IEntity enemy = new Enemy(enemyX, enemyY);

        System.out.printf("Current enemy position: %d, %d\n\n", enemy.getX(), enemy.getY());

        final int playerX = 5, playerY = 14, inventoryCapacity = 3;
        IPlayer player = new Player(playerX, playerY, inventoryCapacity);

        System.out.printf("Current player position: %d, %d\n\n", player.getX(), player.getY());

        final int weaponX = 23, weaponY = 43;
        final int armourX = 4, armourY = 3;
        final int coinX = 12, coinY = 17;

        IItem weapon = new Weapon(weaponX, weaponY);
        IItem armour = new Armour(armourX, armourY);
        IItem coin = new Coin(coinX, coinY);

        System.out.printf("Current weapon position: %d, %d\n\n", weapon.getX(), weapon.getY());
        System.out.printf("Current armour position: %d, %d\n\n", armour.getX(), armour.getY());
        System.out.printf("Current coin position: %d, %d\n\n", coin.getX(), coin.getY());

        final int chestX = 15, chestY = 32;
        final int chestCapacity = 3;

        Chest chest = new Chest(chestX, chestY, chestCapacity);

        System.out.printf("Current chest position: %d, %d\n\n", chest.getX(), chest.getY());

        chest.putItem(weapon, 0);
        chest.putItem(armour, 1);
        chest.putItem(coin, 2);

        player.setX(chestX);
        player.setY(chestY);

        System.out.printf("Current player position: %d, %d\n\n", player.getX(), player.getY());

        IContainer inventory = player.getInventory();

        inventory.putItem(chest.takeItem(0), 2);
        inventory.putItem(chest.takeItem(1), 0);
        inventory.putItem(chest.takeItem(2), 1);

        enemy.setX(player.getX());
        enemy.setY(player.getY());

        System.out.printf("Current enemy position: %d, %d\n\n", enemy.getX(), enemy.getY());
    }

    private Main() {
    }
}
