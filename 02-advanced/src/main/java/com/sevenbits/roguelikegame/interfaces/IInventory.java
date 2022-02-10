package com.sevenbits.roguelikegame.interfaces;

public interface IInventory extends IContainer {
    /**
     * Return current inventory's level
     *
     * @return int - current inventory's level
     */
    int getLevel();
}
