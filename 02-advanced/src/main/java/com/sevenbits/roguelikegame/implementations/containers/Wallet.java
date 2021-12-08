package com.sevenbits.roguelikegame.implementations.containers;

import com.sevenbits.roguelikegame.implementations.items.Coin;
import com.sevenbits.roguelikegame.interfaces.IContainer;
import com.sevenbits.roguelikegame.interfaces.IItem;

import java.util.ArrayList;
import java.util.List;

public class Wallet implements IContainer {
    private final List<IItem> wallet;

    /**
     * Wallet initializing
     */
    public Wallet() {
        wallet = new ArrayList<>();
    }

    /**
     * Putting coins to wallet
     * @param item - item which is need to put in container
     * @throws ArrayIndexOutOfBoundsException if cell's number more than wallet's size or less than 0
     * @throws ClassFormatError               if item's type isn't Coin
     */
    public void putItem(final IItem item) throws ClassFormatError {
        if (!(item instanceof Coin)) {
            throw new ClassFormatError();
        }
        wallet.add(item);
    }

    /**
     * Getting coins from wallet
     * @param index - cell's number in chest
     * @return IItem - coin from wallet
     * @throws ArrayIndexOutOfBoundsException if cell's number more than wallet's size or less than 0
     * @throws ClassFormatError               if item's type isn't Coin
     */
    public IItem takeItem(final int index) throws ArrayIndexOutOfBoundsException {
        return wallet.get(index);
    }

    /**
     * Getting wallet's size
     * @return int - wallet's size
     */
    public int getSize() {
        return wallet.size();
    }
}
