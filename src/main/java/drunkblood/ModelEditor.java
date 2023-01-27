package drunkblood;

import drunkblood.model.Station;

public class ModelEditor {
    public static int calculateStationDistance(Station source, Station destination){
        double lat = (source.getWidth() + destination.getWidth()) / 2 * Math.PI / 180;
        double dx = 111.3f * Math.cos(lat) *  (source.getLength() -  destination.getLength());
        double dy = 111.3f * (source.getWidth() - destination.getWidth());
        double distance = Math.sqrt(dx * dx + dy * dy);
        return (int) distance;
    }
}
