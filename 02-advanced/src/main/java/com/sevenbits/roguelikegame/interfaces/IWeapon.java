package com.sevenbits.roguelikegame.interfaces;

public interface IWeapon extends IItem {
    /**
     * Return current weapon's wear
     *
     * @return int - current weapon's wear
     */
    int getWear();

    /**
     * Return weapon's kind
     *
     * @return String - weapon's kind
     */
    String getKind();
}
