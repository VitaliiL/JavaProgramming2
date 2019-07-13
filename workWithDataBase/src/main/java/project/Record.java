package project;

import java.sql.Timestamp;


public class Record {
    private long id;
    private Timestamp postDate;
    private String postMessage;

    public Record(long id, Timestamp postDate, String postMessage) {
        this.id = id;
        this.postDate = postDate;
        this.postMessage = postMessage;
    }
}
