package FlightControl.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import FlightControl.domain.Airplane;
import FlightControl.domain.Airport;
import FlightControl.domain.Flight;

public class FlightControl {
    private HashMap<String, Airplane> airplanes;
    private ArrayList<Flight> flights;
    private HashMap<String, Airport> airports;

    public FlightControl() {
        airplanes = new HashMap<>();
        flights = new ArrayList<>();
        airports = new HashMap<>();
    }

    public void addAirplane(String id, int capacity){
        Airplane plane = new Airplane(id, capacity);
        airplanes.put(id, plane);
    }    

    public void addFlight(Airplane plane, 
                            String departureAirportId, String arrivalAirportId){

        airports.putIfAbsent(departureAirportId, new Airport(departureAirportId));
        airports.putIfAbsent(arrivalAirportId, new Airport(arrivalAirportId));

        Flight flight = new Flight(plane, 
                                    airports.get(departureAirportId), 
                                    airports.get(arrivalAirportId));
        flights.add(flight);
    }

    public Collection<Airplane> getAirplanes(){
        return airplanes.values();
    }

    public Collection<Flight> getFlights(){
        return flights;
    }

    public Airplane getAirplane(String id){
        return airplanes.get(id);
    }
}
