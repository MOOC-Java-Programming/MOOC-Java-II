package FlightControl.domain;

public class Airport {
    private String id;

    public Airport(String id) {
        this.id = id;
    }

    public String getid() {
        return id;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
