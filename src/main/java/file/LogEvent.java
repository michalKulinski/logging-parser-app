package file;

public class LogEvent {

    private String id;
    private String state;
    private Long timestamp;
    private String type;
    private String host;

    public LogEvent(String id, String state, Long timestamp, String type, String host) {
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
        this.type = type;
        this.host = host;
    }

    public String getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public String getHost() {
        return host;
    }

}
