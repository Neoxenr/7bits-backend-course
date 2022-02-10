package com.sevenbits.roguelikegame.interfaces;

public interface IChest extends IContainer, IFixed {
    /**
     * Return chest's kind
     *
     * @return String - chest's kind
     */
    String getKind();
}
