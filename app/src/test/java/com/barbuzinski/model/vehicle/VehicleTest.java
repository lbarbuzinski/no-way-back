package com.barbuzinski.model.vehicle;

import com.barbuzinski.model.AbstractGameViewTest;
import com.barbuzinski.model.Cell;
import com.barbuzinski.model.Grid;

import org.junit.Before;
import org.junit.Test;

import static com.barbuzinski.model.vehicle.state.VehicleStateEnum.DESTROYING;
import static com.barbuzinski.model.vehicle.state.VehicleStateEnum.IDLE;
import static com.barbuzinski.model.vehicle.state.VehicleStateEnum.RIDING;
import static org.junit.Assert.assertEquals;

public class VehicleTest extends AbstractGameViewTest {

    private Cell singleCell;

    @Before
    public void setUp() {
        singleCell = new Cell(1, 1, Grid.SINGLE);
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
        new Cell(1, 2, Grid.SINGLE).setTop(singleCell);
        Vehicle v = new Vehicle(singleCell);
        v.downLeft();

        assertEquals(RIDING, v.getState());
    }

}
