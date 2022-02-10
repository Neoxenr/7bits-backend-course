package com.sevenbits.roguelikegame.implementations.containers;

import com.sevenbits.roguelikegame.implementations.items.Coin;
import com.sevenbits.roguelikegame.interfaces.IInventory;
import com.sevenbits.roguelikegame.interfaces.IItem;

import java.util.ArrayList;
import java.util.List;

/**
 * IContainer implementation
 */
public class Inventory implements IInventory {
    private final List<IItem> items;

    private final int level;

    /**
     * Inventory initializing
     */
    public Inventory(final int level) {
        this.level = level;
        items = new ArrayList<>();
    }

    public int getLevel() {
        return level;
    }

    /**
     * Putting item to inventory
     *
     * @param item - item which is need to put in inventory
     * @throws ArrayIndexOutOfBoundsException - if cell's number more than chest's size or less than 0
     */
    public void putItem(final IItem item) throws ArrayIndexOutOfBoundsException, ClassFormatError {
        if (item instanceof Coin) {
            throw new ClassFormatError();
        }
        items.add(item);
    }

    /**
     * Getting item from inventory
     *
     * @param index - cell's number in inventory
     * @return IItem - item the inventory
     * @throws ArrayIndexOutOfBoundsException - if cell's number more than chest's size or less than 0
     */
    public IItem takeItem(final int index) throws ArrayIndexOutOfBoundsException {
        return items.get(index);
    }

    /**
     * Getting inventory's size
     *
     * @return int - inventory's size
     */
    public int getSize() {
        return items.size();
    }

    /**
     * Return inventory's content
     * @return String - inventory's content
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (IItem item : items) {
            stringBuilder.append("\t").append(item).append("\n");
        }

        return stringBuilder.toString();
    }
}
