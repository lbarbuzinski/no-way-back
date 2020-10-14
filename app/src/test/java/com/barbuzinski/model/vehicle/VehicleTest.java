package com.barbuzinski.model.vehicle;

import com.barbuzinski.model.AbstractGameViewTest;
import com.barbuzinski.model.cell.Cell;
import com.barbuzinski.model.cell.CellFactory;
import com.barbuzinski.model.cell.CellStateFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.barbuzinski.model.cell.CellStage.SINGLE;
import static com.barbuzinski.model.vehicle.state.VehicleStateEnum.DESTROYING;
import static com.barbuzinski.model.vehicle.state.VehicleStateEnum.IDLE;
import static com.barbuzinski.model.vehicle.state.VehicleStateEnum.RIDING;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class VehicleTest extends AbstractGameViewTest {

    @Mock
    private CellFactory cellFactory;

    @Mock
    private CellStateFactory cellStateFactory;

    private Cell singleCell;

    @Before
    public void setUp() {
        singleCell = new Cell(cellFactory, cellStateFactory,1, 1, SINGLE);
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
        new Cell(1, 2, SINGLE).setTop(singleCell);
        Vehicle v = new Vehicle(singleCell);
        v.downLeft();

        assertEquals(RIDING, v.getState());
    }

}
