package drunkblood;


import com.sun.net.httpserver.HttpServer;
import drunkblood.server.DistanceHandler;
import drunkblood.util.DataHolder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.ParseException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        // load csv data
        DataHolder.loadData();

        // setup server
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        server.setExecutor(threadPoolExecutor);
        server.createContext("/api/v1/distance/", new DistanceHandler());
        server.start();
    }

}
