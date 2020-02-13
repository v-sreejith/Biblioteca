package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItemException;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Library
public class Library<T extends LibraryItem> {
    private final List<T> items;
    private final List<T> availableItems;
    private final List<T> issuedItems;

    public Library(List<T> items) {
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

    public void checkoutItems(T item) throws InvalidItemException {
        if (availableItems.contains(item)) {
            availableItems.remove(item);
            issuedItems.add(item);
        } else throw new InvalidItemException();
    }

    public void receiveItem(T item) throws InvalidItemException {
        if (items.contains(item) && !availableItems.contains(item)) {
            issuedItems.remove(item);
            availableItems.add(item);
        } else throw new InvalidItemException();
    }
}
