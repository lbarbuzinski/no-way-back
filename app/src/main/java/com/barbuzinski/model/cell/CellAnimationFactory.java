package com.barbuzinski.model.cell;

import android.graphics.drawable.Drawable;

import com.barbuzinski.model.GridData;
import com.barbuzinski.utils.StaticPosition;

import javax.inject.Inject;

public class CellAnimationFactory {

    private final GridData gridData;

    @Inject
    public CellAnimationFactory(GridData gridData) {
        this.gridData = gridData;
    }

    public CellAnimation create(CellStage currentStage, CellStage destStage, StaticPosition position, Drawable currentDrawableCell, Drawable destDrawableCell) {
        return new CellAnimation(gridData, currentStage, destStage, position, currentDrawableCell, destDrawableCell);
    }
}
