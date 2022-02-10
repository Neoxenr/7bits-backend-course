package com.sevenbits.roguelikegame.interfaces;

public interface IWallet extends IContainer {
    /**
     * Return current wallet's level
     *
     * @return int - current wallet's level
     */
    int getLevel();
}
