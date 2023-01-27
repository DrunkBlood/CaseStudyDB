package drunkblood;

import kong.unirest.json.JSONObject;

public class JsonBuilder {
    public static JSONObject buildDistanceResponse(String source, String dest, int distance, String unit) {
        return new JSONObject()
                .put("from", source)
                .put("to", dest)
                .put("distance", distance)
                .put("unit", unit);
    }
}
