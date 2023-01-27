package drunkblood.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import drunkblood.util.JsonBuilder;
import drunkblood.ModelEditor;
import drunkblood.model.Station;
import drunkblood.util.DataHolder;
import kong.unirest.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class DistanceHandler implements HttpHandler {
    private static final String API_DISTANCE = "/api/v1/distance/";
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if("GET".equals(exchange.getRequestMethod())){
            handleGetResponse(exchange);
        }
        errorNotFound(exchange);
    }

    private void handleGetResponse(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        String requestPath = requestURI.getPath();

        if(requestPath.startsWith(API_DISTANCE)){
            String data = requestPath.substring(API_DISTANCE.length());
            if(!data.isEmpty()){
                String[] splitData = data.split("/");
                if(splitData.length == 2){
                    String source = splitData[0];
                    String destination = splitData[1];
                    handleDataResponse(exchange, source, destination);
                    return;
                }
            }
            errorBadReqeust(exchange);
        }
        errorNotFound(exchange);
    }

    private void handleDataResponse(HttpExchange exchange, String source, String destination) throws IOException {
        if(!DataHolder.stationMap.containsKey(source)
        || !DataHolder.stationMap.containsKey(destination)){
            errorBadReqeust(exchange);
            return;
        }
        Station sourceStation = DataHolder.stationMap.get(source);
        Station destinationStation = DataHolder.stationMap.get(destination);
        int distance = ModelEditor.calculateStationDistance(sourceStation, destinationStation);
        JSONObject responseData = JsonBuilder.buildDistanceResponse(
                sourceStation.getName(),
                destinationStation.getName(),
                distance,
                "km"
        );

        String data = responseData.toString();

        exchange.sendResponseHeaders(200, data.length());
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(data.getBytes(StandardCharsets.UTF_8));
        responseBody.flush();
        responseBody.close();
    }

    private void errorBadReqeust(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(400, 0);
    }

    private void errorNotFound(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(404, 0);
    }

}
