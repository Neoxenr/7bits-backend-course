package com.sevenbits.roguelikegame.implementations.containers;

import com.sevenbits.roguelikegame.implementations.items.IItem;

/**
 * Interface with 2 virtual methods
 */
public interface IContainer {
    /**
     * @param item      - item which is need to put in container
     * @param cellIndex - cell's number in chest
     */
    void putItem(IItem item, int cellIndex);

    /**
     * @param cellIndex - cell's number in chest
     * @return IItem - item in container
     */
    IItem takeItem(int cellIndex);
}
