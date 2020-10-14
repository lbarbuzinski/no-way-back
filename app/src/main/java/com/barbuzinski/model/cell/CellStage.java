package com.barbuzinski.model.cell;

import com.barbuzinski.R;

public enum CellStage {

    FIXED(R.drawable.ic_cell_fixed),
    DOUBLE(R.drawable.ic_cell_double),
    SINGLE(R.drawable.ic_cell_single),
    EMPTY(null);

    private Integer drawableId;

    CellStage(Integer drawableId) {
        this.drawableId = drawableId;
    }

    public CellStage onRanOver() {
        switch (this) {
            case FIXED: return FIXED;
            case DOUBLE: return SINGLE;
            case SINGLE: return EMPTY;
            default: throw new IllegalStateException("Cannot run over cell of stage: " + this);
        }
    }

    public Integer getDrawableId() {
        return drawableId;
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }
}
