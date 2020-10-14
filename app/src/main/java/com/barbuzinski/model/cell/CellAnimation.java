package com.barbuzinski.model.cell;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.barbuzinski.model.GridData;
import com.barbuzinski.utils.Animation;
import com.barbuzinski.utils.StaticPosition;

public class CellAnimation extends Animation {

    private static final long CELL_ANIMATION_TIME_MILLIS = 200;

    private final GridData gridData;

    private CellStage currentStage;
    private CellStage destStage;
    private StaticPosition position;
    private Drawable currentDrawableCell;
    private Drawable destDrawableCell;

    protected CellAnimation(GridData gridData, CellStage currentStage, CellStage destStage, StaticPosition position, Drawable currentDrawableCell, Drawable destDrawableCell) {
        super(CELL_ANIMATION_TIME_MILLIS, () -> {});
        this.gridData = gridData;
        this.currentStage = currentStage;
        this.destStage = destStage;
        this.position = position;
        this.currentDrawableCell = currentDrawableCell;
        this.destDrawableCell = destDrawableCell;
    }

    @Override
    public void draw(Canvas canvas) {
        if (currentStage.isEmpty())
            return;

        int x = position.getX() - gridData.getCellWidthPixels() / 2;
        int y = position.getY() - gridData.getCellHeightPixels() / 2;

        currentDrawableCell.setBounds(
                x,
                y,
                x + gridData.getCellWidthPixels(),
                y + gridData.getCellWidthPixels());

        float progress = this.progress.progress();

        switch (destStage) {
            case FIXED:
                currentDrawableCell.setAlpha(255);
                currentDrawableCell.draw(canvas); break;
            case EMPTY:
                currentDrawableCell.setAlpha((int) ((1 - progress) * 255));
                currentDrawableCell.draw(canvas); break;
            case SINGLE:
                destDrawableCell.setBounds(
                        x,
                        y,
                        x + gridData.getCellWidthPixels(),
                        y + gridData.getCellWidthPixels());
                currentDrawableCell.setAlpha((int) ((1 - progress) * 255));
                currentDrawableCell.draw(canvas);
                destDrawableCell.setAlpha((int) (progress * 255));
                destDrawableCell.draw(canvas); break;
            case DOUBLE:
                destDrawableCell.setBounds(
                        x,
                        y,
                        x + gridData.getCellWidthPixels(),
                        y + gridData.getCellWidthPixels());
                destDrawableCell.setAlpha(255);
                destDrawableCell.draw(canvas); break;

        }
    }

}
