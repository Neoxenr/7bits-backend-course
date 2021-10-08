package com.sevenbits.roguelikegame.implementations.containers;

import com.sevenbits.roguelikegame.implementations.items.IItem;

/**
 * IContainer implementation
 */
public class Inventory implements IContainer {
    private final IItem[] items;

    /**
     * @param capacity - inventories size
     */
    public Inventory(final int capacity) {
        items = new IItem[capacity];
    }

    /**
     * @param item      - item which is need to put in inventory
     * @param cellIndex - cell's number in inventory
     * @throws ArrayIndexOutOfBoundsException - if cell's number more than chest's size or less than 0
     */
    public void putItem(final IItem item, final int cellIndex) throws ArrayIndexOutOfBoundsException {
        if (cellIndex > items.length || cellIndex < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        items[cellIndex] = item;
    }

    /**
     * @param cellIndex - cell's number in inventory
     * @return IItem - item the inventory
     * @throws ArrayIndexOutOfBoundsException - if cell's number more than chest's size or less than 0
     */
    public IItem takeItem(final int cellIndex) throws ArrayIndexOutOfBoundsException {
        if (cellIndex > items.length || cellIndex < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[cellIndex];
    }
}
