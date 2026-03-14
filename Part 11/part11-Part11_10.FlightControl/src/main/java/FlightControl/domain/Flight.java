package FlightControl.domain;

public class Flight {
    private Airplane airplane;
    private Airport departureAirport;
    private Airport arrivalAirport;
    
    public Flight(Airplane airplane, Airport departureAirport, Airport arrivalAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public String toString(){
        return airplane.toString() + " (" + departureAirport + "-" + arrivalAirport + ")";
    }
}
