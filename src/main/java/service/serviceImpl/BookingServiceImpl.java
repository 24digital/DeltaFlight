package service.serviceImpl;

import entities.State;
import org.springframework.stereotype.Service;
import service.BookingService;
import utility.States;

import java.io.IOException;

/**
 * Created by Marion on 9/15/2014.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public States scheduleFlight(State destination, State departure) throws IOException {
        return null;
    }

    @Override
    public String getFlightInformation() throws IOException {
        return null;
    }

    @Override
    public int getZone(State state) throws IOException {
        return 0;
    }

    @Override
    public Float getCost(State state) throws IOException {
        return null;
    }

    @Override
    public State getState(String code) throws IOException {
        return null;
    }
}
