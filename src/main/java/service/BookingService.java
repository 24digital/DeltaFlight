package service;

import entities.State;
import utility.States;

import java.io.IOException;

/**
 * Created by Marion on 9/15/2014.
 */
public interface BookingService {
    States scheduleFlight(State destination, State departure) throws IOException;
    String getFlightInformation()throws IOException;
    int getZone(State state) throws IOException;
    Float getCost(State state)throws IOException;
    State getState(String code)throws IOException;

}
