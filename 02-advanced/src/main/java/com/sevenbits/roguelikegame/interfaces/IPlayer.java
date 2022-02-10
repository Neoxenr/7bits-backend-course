package com.sevenbits.roguelikegame.interfaces;

public interface IPlayer extends IEntity, IMovable {
    /**
     * Return current stamina's value
     *
     * @return int - current stamina's value
     */
    int getStamina();

    /**
     * Set new stamina's value
     *
     * @param stamina - new stamina's value
     */
    void setStamina(int stamina);

    /**
     * Return current player's inventory
     *
     * @return IInventory - current player's inventory
     */
    IInventory getInventory();

    /**
     * Return current player's wallet
     *
     * @return IWallet - current player's wallet
     */
    IWallet getWallet();
}
