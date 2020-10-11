package com.barbuzinski.model.vehicle;

import android.util.DisplayMetrics;

import com.barbuzinski.model.Cell;
import com.barbuzinski.model.GridSizeData;
import com.barbuzinski.model.LogicalGrid;

import org.junit.BeforeClass;
import org.junit.Test;

import static com.barbuzinski.model.vehicle.state.VehicleStateEnum.DESTROYING;
import static com.barbuzinski.model.vehicle.state.VehicleStateEnum.IDLE;
import static com.barbuzinski.model.vehicle.state.VehicleStateEnum.RIDING;
import static org.junit.Assert.assertEquals;

public class VehicleTest {

    private Cell singleCell = new Cell(1, 1, LogicalGrid.SINGLE);

    @BeforeClass
    public static void setUpClass() {
        GridSizeData.init(new DisplayMetrics());
    }

    @Test
    public void newVehicleShouldHaveIdleState() {
        Vehicle v = new Vehicle(singleCell);
        assertEquals(IDLE, v.getState());
    }

    @Test
    public void shouldBeDestroying() {
        Vehicle v = new Vehicle(singleCell);
        v.upLeft();

        assertEquals(DESTROYING, v.getState());
    }

    @Test
    public void shouldDrive() {
        new Cell(1, 2, LogicalGrid.SINGLE).setTop(singleCell);
        Vehicle v = new Vehicle(singleCell);
        v.downLeft();

        assertEquals(RIDING, v.getState());
    }

}
