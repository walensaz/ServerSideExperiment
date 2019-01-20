package objects.playerobjects;

import java.io.Serializable;

public enum Rank implements Serializable {
    PLAYER(0),
    MOD(1),
    ADMIN(2),
    DEV(3);

    private static final long serialVersionUID = -942038562193532152L;

    private int rights;

    Rank(int rights) {
        this.rights = rights;
    }

    public int getRank(){
        return rights;
    }
}
