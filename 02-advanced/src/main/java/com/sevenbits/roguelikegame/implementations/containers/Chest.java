package com.sevenbits.roguelikegame.implementations.containers;

import com.sevenbits.roguelikegame.interfaces.IChest;
import com.sevenbits.roguelikegame.interfaces.IItem;

import java.util.ArrayList;
import java.util.List;

/**
 * IContainer implementation
 */
public class Chest implements IChest {
    private final int x, y;

    private final String kind;

    private final List<IItem> items;

    /**
     * Chest initializing
     *
     * @param x - chest's position at x axis
     * @param y - chest's position at y axis
     */
    public Chest(final int x, final int y, final String kind) {
        this.x = x;
        this.y = y;
        this.kind = kind;
        items = new ArrayList<>();
    }

    public String getKind() {
        return kind;
    }

    /**
     * Getting chest's position at x axis
     *
     * @return int - current chest's position at x axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getting chest's position at y axis
     *
     * @return int - current chest's position at x axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * Putting item to chest
     *
     * @param item - item which is need to put in chest
     * @throws ArrayIndexOutOfBoundsException - if cell's number more than chest's size or less than 0
     */
    public void putItem(final IItem item) {
        items.add(item);
    }

    /**
     * Getting item from chest
     *
     * @return IItem - item in the chest
     * @throws ArrayIndexOutOfBoundsException - if cell's number more than chest's size or less than 0
     */
    public IItem takeItem(final int index) throws ArrayIndexOutOfBoundsException {
        return items.get(index);
    }

    /**
     * Getting chest's size
     *
     * @return int - chest's size
     */
    public int getSize() {
        return items.size();
    }
}
