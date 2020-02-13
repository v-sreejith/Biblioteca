package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItemException;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Inventory
public class Inventory<T extends LibraryItem> {
    private final List<T> items;
    private final List<T> availableItems;
    private final List<T> issuedItems;

    public Inventory(List<T> items) {
        this.items = items;
        availableItems = new ArrayList<>(items);
        this.issuedItems = new ArrayList<>();
    }

    public List<T> getAvailableItems() {
        return availableItems;
    }

    public List<T> getIssuedItems() {
        return issuedItems;
    }

    public void checkout(T item) throws InvalidItemException {
        if (!availableItems.contains(item)) {
            throw new InvalidItemException();
        }
        availableItems.remove(item);
        issuedItems.add(item);
    }

    public void receive(T item) throws InvalidItemException {
        if (!items.contains(item) || availableItems.contains(item)) {
            throw new InvalidItemException();
        }
        issuedItems.remove(item);
        availableItems.add(item);
    }
}
