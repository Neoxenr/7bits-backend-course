package com.sevenbits.roguelikegame.implementations.entities;

import com.sevenbits.roguelikegame.implementations.containers.Inventory;

/**
 * Interface for Player which extends IEntity interface
 */
public interface IPlayer extends IEntity {
    /**
     * @return Inventory - player's inventory
     */
    Inventory getInventory();
}
