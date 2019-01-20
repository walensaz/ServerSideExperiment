package objects.playerobjects;

import java.util.Collection;
import java.util.LinkedList;

public class Inventory extends LinkedList<Item> {

    public Inventory() {
        super();
    }

    public Inventory(Collection<Item> collection) { super(collection); }

    public synchronized boolean addItem(Item item) {
        return super.add(item);
    }

    public synchronized Item removeItem(int index) {
        return super.remove(index);
    }

    public synchronized boolean removeItem(Object o) {
        return super.remove(o);
    }

}
