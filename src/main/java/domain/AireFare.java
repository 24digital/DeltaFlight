package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utility.States;
import dao.Query;

/**
 * Created by Marion on 9/15/2014.
 */
@Component
public class AireFare {


    @Autowired
    Float calculateFare(States travel){

    return 0.0f;};
}
