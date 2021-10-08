package com.sevenbits.roguelikegame.implementations.containers;

import com.sevenbits.roguelikegame.implementations.items.IItem;

/**
 * IContainer implementation
 */
public class Chest implements IContainer {
    private final int x, y;

    private final IItem[] items;

    /**
     * @param x        - chest's position at x axis
     * @param y        - chest's position at y axis
     * @param capacity - chest's size
     */
    public Chest(final int x, final int y, final int capacity) {
        this.x = x;
        this.y = y;
        items = new IItem[capacity];
    }

    /**
     * @return int - current chest's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return int - current chest's position at x axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * @param item      - item which is need to put in chest
     * @param cellIndex - cell's number in chest
     * @throws ArrayIndexOutOfBoundsException - if cell's number more than chest's size or less than 0
     */
    public void putItem(final IItem item, final int cellIndex) throws ArrayIndexOutOfBoundsException {
        if (cellIndex > items.length || cellIndex < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        items[cellIndex] = item;
    }

    /**
     * @param cellIndex - cell's number in chest
     * @return IItem - item in the chest
     * @throws ArrayIndexOutOfBoundsException - if cell's number more than chest's size or less than 0
     */
    public IItem takeItem(final int cellIndex) throws ArrayIndexOutOfBoundsException {
        if (cellIndex > items.length || cellIndex < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[cellIndex];
    }
}
