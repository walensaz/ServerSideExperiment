package objects.playerobjects;


import java.io.Serializable;
import java.util.Date;

public class VIP implements Serializable {

    private static final long serialVersionUID = -942038562193532152L;

    private int level;
    private long points;
    private Date time;

    public VIP() {
        level = 0;
        points = 1;
        //TODO: Set to the date VIP status expires
        time = new Date();
    }

    public VIP(int level, long points, Date time) {
        this.level = level;
        this.points = points;
        this.time = time;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "VIP{" +
                "level=" + level +
                ", points=" + points +
                ", time=" + time +
                '}';
    }
}
