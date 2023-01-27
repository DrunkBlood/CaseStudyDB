package drunkblood;

import java.util.Objects;

public class Station {

    private final String ds100;
    private final String name;

    private final float length;

    private final float width;

    public Station(String ds100, String name, float length, float width){
        this.ds100 = ds100;
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public String getDs100(){
        return ds100;
    }

    public String getName() {
        return name;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Float.compare(station.length, length) == 0 && Float.compare(station.width, width) == 0 && ds100.equals(station.ds100) && Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ds100, name, length, width);
    }
}
