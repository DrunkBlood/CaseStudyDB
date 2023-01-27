package drunkblood.util;

import kong.unirest.json.JSONObject;

public class JsonBuilder {
    public static JSONObject buildDistanceResponse(String source, String destination, int distance, String unit) {
        return new JSONObject()
                .put("from", source)
                .put("to", destination)
                .put("distance", distance)
                .put("unit", unit);
    }
}
