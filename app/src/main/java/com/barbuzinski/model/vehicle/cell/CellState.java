package com.barbuzinski.model.vehicle.cell;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.barbuzinski.android.DrawablesRepository;
import com.barbuzinski.model.GridData;
import com.barbuzinski.utils.StaticPosition;

public class CellState {

    private int x;
    private int y;
    private StaticPosition centerPosition;

    private CellStage stage;
    private DrawablesRepository drawablesRepository;
    private CellAnimation animation;

    protected CellState(int x, int y, CellStage stage, DrawablesRepository drawablesRepository) {
        this.x = x;
        this.y = y;
        this.stage = stage;
        this.drawablesRepository = drawablesRepository;
        this.centerPosition = new StaticPosition(computeX(), computeY());

        Drawable drawable = drawablesRepository.getDrawable(stage.getDrawableId());
        this.animation = new CellAnimation(
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
        this.animation = new CellAnimation(
                oldStage,
                stage,
                centerPosition,
                drawablesRepository.getDrawable(oldStage.getDrawableId()),
                drawablesRepository.getDrawable(stage.getDrawableId()));
    }

    private int computeX() {
        return (getX() - getY() + GridData.getWidthCellsIso()) * GridData.getCellWidthPixels() / 2;
    }

    private int computeY() {
        return (getX() + getY() - GridData.getWidthCellsIso() + 2) * GridData.getCellHeightPixels() / 2;
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
