package drunkblood;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHolder {

    public static final Map<String, Station> stationMap = new HashMap<>();
    public static void loadData() throws FileNotFoundException, ParseException {
        List<StationBean> stations = new CsvToBeanBuilder<StationBean>(new FileReader("D_Bahnhof_2020_alle.CSV"))
                .withType(StationBean.class)
                .withSeparator(';')
                .build().parse();
        // remove header
        stations.remove(0);
        for(StationBean bean : stations){
            Station station = parseBeanToStation(bean);
            stationMap.put(station.getDs100(), station);
        }
    }

    private static Station parseBeanToStation(StationBean stationBean) throws ParseException {
        float length = Float.parseFloat(stationBean.getLaenge().replace(",", "."));
        float width = Float.parseFloat(stationBean.getBreite().replace(",", "."));
        return new Station(
                stationBean.getDS100(),
                stationBean.getNAME(),
                length,
                width);
    }
}
