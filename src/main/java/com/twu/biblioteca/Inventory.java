package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItemException;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Inventory
public class Inventory<T extends LibraryItem> {
    private final List<T> items;
    private final List<T> availableItems;

    public Inventory(List<T> items) {
        this.items = items;
        availableItems = new ArrayList<>(items);
    }

    public List<T> getAvailableItems() {
        return availableItems;
    }

    public void checkout(T item) throws InvalidItemException {
        if (!availableItems.contains(item)) {
            throw new InvalidItemException();
        }
        availableItems.remove(item);
    }

    public void receive(T item) throws InvalidItemException {
        if (!items.contains(item) || availableItems.contains(item)) {
            throw new InvalidItemException();
        }
        availableItems.add(item);
    }
}
