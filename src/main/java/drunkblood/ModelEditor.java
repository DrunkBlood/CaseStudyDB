package drunkblood;

public class ModelEditor {
    public static int calculateStationDistance(Station source, Station dest){
        double lat = (source.getWidth() + dest.getWidth()) / 2 * Math.PI / 180;
        double dx = 111.3f * Math.cos(lat) *  (source.getLength() -  dest.getLength());
        double dy = 111.3f * (source.getWidth() - dest.getWidth());
        double distance = Math.sqrt(dx * dx + dy * dy);
        return (int) distance;
    }
}
