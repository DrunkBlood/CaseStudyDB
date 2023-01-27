package drunkblood.model.bean;

import com.opencsv.bean.CsvBindByPosition;

public class StationBean {
    @CsvBindByPosition(position = 0)
    private String EVA_NR;

    @CsvBindByPosition(position = 1)
    private String DS100;

    @CsvBindByPosition(position = 2)
    private String IFOPT;

    @CsvBindByPosition(position = 3)
    private String NAME;

    @CsvBindByPosition(position = 4)
    private String Verkehr;

    @CsvBindByPosition(position = 5)
    private String Laenge;

    @CsvBindByPosition(position = 6)
    private String Breite;

    @CsvBindByPosition(position = 7)
    private String Betreiber_Name;

    @CsvBindByPosition(position = 8)
    private String Betreiber_Nr;

    @CsvBindByPosition(position = 9)
    private String Status;

    public String getEVA_NR() {
        return EVA_NR;
    }

    public String getDS100() {
        return DS100;
    }

    public String getIFOPT() {
        return IFOPT;
    }

    public String getNAME() {
        return NAME;
    }

    public String getVerkehr() {
        return Verkehr;
    }

    public String getLaenge() {
        return Laenge;
    }

    public String getBreite() {
        return Breite;
    }

    public String getBetreiber_Name() {
        return Betreiber_Name;
    }

    public String getBetreiber_Nr() {
        return Betreiber_Nr;
    }

    public String getStatus() {
        return Status;
    }
}
