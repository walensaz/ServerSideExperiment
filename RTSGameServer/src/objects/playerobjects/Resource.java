package objects.playerobjects;

import java.io.Serializable;

public class Resource implements Serializable {

    private static final long serialVersionUID = -942038562193532152L;

    public static final int FOOD = 0, WOOD = 1, STONE = 2, SILVER = 3, GOLD = 4;

    private long amount;

    public Resource( long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "amount=" + amount +
                '}';
    }
}
