package com.sevenbits.roguelikegame.implementations;

import com.sevenbits.roguelikegame.interfaces.IEntity;
import com.sevenbits.roguelikegame.interfaces.IPlayer;

public class Fight {
    /**
     * Fight with player and him enemy
     * @param player - player
     * @param enemy - player's enemy
     */
    public void fight(final IPlayer player, final IEntity enemy) {
        int playerHit = 20;
        final int enemyHit = 10;

        final int staminaCost = 5;

        final int startStamina = player.getStamina();
        final int startHealth = player.getHealth();

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            if (player.getStamina() > 0) {
                player.setStamina(player.getStamina() - staminaCost);
            } else {
                playerHit = 5;
            }

            enemy.setHealth(enemy.getHealth() - playerHit);

            System.out.println("Player has attacked enemy");

            System.out.printf("Enemy health = %d\n", enemy.getHealth());
            System.out.printf("Spent stamina = %d \n",
                    startStamina - player.getStamina());

            player.setHealth(player.getHealth() - enemyHit);

            System.out.printf("Spent health = %d \n\n", startHealth - player.getHealth());

            System.out.println("Enemy has attacked player");
            System.out.printf("Player health = %d\n\n", player.getHealth());
        }

        System.out.println("Result of fight:");
        System.out.println(player.getHealth() > enemy.getHealth() ? "Player win" : "Enemy win");
        System.out.printf("Player health = %d\nEnemy health = %d\n", player.getHealth(), enemy.getHealth());

        enemy.setAlive(enemy.getHealth() > 0);

        player.setAlive(player.getHealth() > 0);
    }
}
