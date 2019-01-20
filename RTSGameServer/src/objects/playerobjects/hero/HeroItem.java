package objects.playerobjects.hero;

public enum HeroItem {
    NOTHING(HeroSlots.NULL, 0, ""),
    STONE_CHESTPLATE(HeroSlots.CHEST, 1, "Stone Chestplate"),
    STONE_HELMET(HeroSlots.HEAD, 2, "Stone Helmet");


    private int slot;
    private int id;
    private String itemname;

    HeroItem(int slot, int id, String itemname) {
        this.slot = slot;
        this.id = id;
        this.itemname = itemname;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    @Override
    public String toString() {
        return "HeroItem{" +
                "slot=" + slot +
                ", id=" + id +
                ", itemname='" + itemname + '\'' +
                '}';
    }


}