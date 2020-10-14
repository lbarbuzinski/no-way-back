package com.barbuzinski.model.vehicle;

import com.barbuzinski.model.GridData;
import com.barbuzinski.model.vehicle.animation.VehicleAnimationFactory;
import com.barbuzinski.model.vehicle.state.VehicleStateFactory;

import static org.junit.Assert.*;

public class VehicleFactoryTest {

    private VehicleFactory vehicleFactory = new VehicleFactory(new VehicleStateFactory(new VehicleAnimationFactory(new GridData())))

}