import com.navi.model.Branch;
import com.navi.model.Vehicle;
import com.navi.model.comparator.VehicleComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class CarRentalTest {

    static Vehicle vehicle;

    static Branch branch;
    @BeforeAll
    static void setup() {
        vehicle = new Vehicle("CAR", "SAMPLE_CAR", "100");
        branch = new Branch();
        branch.getVehicleTypes().put("CAR", new PriorityQueue<>(new VehicleComparator()));
    }

    @DisplayName("add Vehicle To Branch successful")
    @Test
    void addVehicleToBranch_Success() {
        Assertions.assertTrue(branch.addVehicleToBranch(vehicle));
        Assertions.assertEquals(1, branch.getVehicleTypes().size());
        Assertions.assertEquals(1, branch.getTotalCars());
    }


}
