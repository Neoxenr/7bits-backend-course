package com.sevenbits.roguelikegame;

import com.sevenbits.roguelikegame.implementations.Fight;
import com.sevenbits.roguelikegame.implementations.containers.Chest;
import com.sevenbits.roguelikegame.implementations.entities.Enemy;
import com.sevenbits.roguelikegame.implementations.entities.Player;
import com.sevenbits.roguelikegame.implementations.items.Armour;
import com.sevenbits.roguelikegame.implementations.items.Coin;
import com.sevenbits.roguelikegame.implementations.items.Weapon;
import com.sevenbits.roguelikegame.interfaces.IArmour;
import com.sevenbits.roguelikegame.interfaces.IChest;
import com.sevenbits.roguelikegame.interfaces.IContainer;
import com.sevenbits.roguelikegame.interfaces.IEntity;
import com.sevenbits.roguelikegame.interfaces.IInventory;
import com.sevenbits.roguelikegame.interfaces.IPlayer;
import com.sevenbits.roguelikegame.interfaces.IWeapon;

/**
 * Main application entry point
 */
public final class Main {
    /**
     * Entry point for application
     *
     * @param args - console arguments
     */
    public static void main(final String[] args) {
        final int playerX = 5;
        final int playerY = 14;

        final int playerHealth = 100;
        final int playerStamina = 100;

        IPlayer player = new Player(playerX, playerY, playerHealth, playerStamina);
        IInventory inventory = player.getInventory();

        System.out.println(player);

        final int weaponX = 23;
        final int weaponY = 43;

        final int weaponWear = 50;
        final String weaponKind = "Sword";

        IWeapon weapon = new Weapon(weaponX, weaponY, weaponWear, weaponKind);

        final int chestX = 15;
        final int chestY = 32;

        final String chestKind = "Diamond";

        IChest chest = new Chest(chestX, chestY, chestKind);
        chest.putItem(weapon);

        player.setX(chest.getX());
        player.setY(chest.getY());

        System.out.println("Item " + chest.takeItem(0) + " has picked\n");
        inventory.putItem(chest.takeItem(0));

        weapon.setActive(true);

        final int firstEnemyX = 5;
        final int firstEnemyY = 14;

        final int firstEnemyHealth = 80;

        IEntity firstEnemy = new Enemy(firstEnemyX, firstEnemyY, firstEnemyHealth);

        player.setX(firstEnemy.getX());
        player.setY(firstEnemy.getY());

        Fight fight = new Fight();
        fight.fight(player, firstEnemy);

        if (player.isAlive()) {
            IContainer wallet = player.getWallet();
            wallet.putItem(new Coin(firstEnemy.getX(), firstEnemy.getY(), 1));
            wallet.putItem(new Coin(firstEnemy.getX(), firstEnemy.getY(), 2));
            wallet.putItem(new Coin(firstEnemy.getX(), firstEnemy.getY(), 1));
            System.out.printf("Coins are received = %d\n\n", wallet.getSize());
        }

        final int armourX = 20;
        final int armourY = 15;

        final int armourStrength = 50;

        IArmour armour = new Armour(armourX, armourY, armourStrength);

        player.setX(armour.getX());
        player.setY(armour.getY());

        System.out.println("Item " + armour + " has picked\n");
        inventory.putItem(armour);

        armour.setActive(true);

        final int secondEnemyX = 24;
        final int secondEnemyY = 52;

        final int secondEnemyHealth = 300;

        IEntity secondEnemy = new Enemy(secondEnemyX, secondEnemyY, secondEnemyHealth);

        player.setX(secondEnemy.getX());
        player.setY(secondEnemy.getY());

        fight.fight(player, secondEnemy);

        if (!player.isAlive()) {
            System.out.println(player);
        }
    }

    private Main() {
    }
}
