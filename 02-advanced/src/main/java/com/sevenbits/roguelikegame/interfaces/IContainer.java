package com.sevenbits.roguelikegame.interfaces;

/**
 * Interface with 2 virtual methods
 */
public interface IContainer {
    /**
     * Putting new item to container
     * @param item - item which is need to put in container
     */
    void putItem(IItem item);

    /**
     * Getting item from container
     * @param index - cell's number in chest
     * @return IItem - item in container
     */
    IItem takeItem(int index);

    /**
     * Getting container's size
     * @return int - container's size
     */
    int getSize();
}
