package com.barbuzinski.model.cell;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.barbuzinski.android.DrawablesRepository;
import com.barbuzinski.model.GridData;
import com.barbuzinski.utils.StaticPosition;

public class CellState {

    private final GridData gridData;
    private final DrawablesRepository drawablesRepository;
    private final CellAnimationFactory cellAnimationFactory;

    private int x;
    private int y;
    private StaticPosition centerPosition;

    private CellStage stage;
    private CellAnimation animation;

    protected CellState(GridData gridData, CellAnimationFactory cellAnimationFactory, DrawablesRepository drawablesRepository, int x, int y, CellStage stage) {
        this.gridData = gridData;
        this.cellAnimationFactory = cellAnimationFactory;
        this.x = x;
        this.y = y;
        this.stage = stage;
        this.drawablesRepository = drawablesRepository;
        this.centerPosition = new StaticPosition(computeX(), computeY());

        Drawable drawable = drawablesRepository.getDrawable(stage.getDrawableId());
        this.animation = cellAnimationFactory.create(
                stage,
                stage,
                centerPosition,
                drawable,
                drawable);
    }

    public StaticPosition getPosition() {
        return centerPosition;
    }

    public void onRanOver() {
        CellStage oldStage = stage;
        this.stage = stage.onRanOver();
        this.animation = cellAnimationFactory.create(
                oldStage,
                stage,
                centerPosition,
                drawablesRepository.getDrawable(oldStage.getDrawableId()),
                drawablesRepository.getDrawable(stage.getDrawableId()));
    }

    private int computeX() {
        return (getX() - getY() + gridData.getWidthCellsIso()) * gridData.getCellWidthPixels() / 2;
    }

    private int computeY() {
        return (getX() + getY() - gridData.getWidthCellsIso() + 2) * gridData.getCellHeightPixels() / 2;
    }

    public void draw(Canvas canvas) {
        animation.draw(canvas);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellStage getStage() {
        return stage;
    }

}
