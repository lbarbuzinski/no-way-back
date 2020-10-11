package com.barbuzinski;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.barbuzinski.android.DrawablesFactory;
import com.barbuzinski.android.MetricsFactory;
import com.barbuzinski.model.CustomGrid;
import com.barbuzinski.model.LogicalGridFactory;
import com.barbuzinski.model.PavementGrid;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MetricsFactory metricsFactory = new MetricsFactory();
    private DrawablesFactory drawableGridFactory = new DrawablesFactory();
    private LogicalGridFactory gridFactory = new LogicalGridFactory();

    private GameThread thread;
    private PavementGrid grid;
    private Paint paint;

    public GameView(Context context) {
        super(context);
        DisplayMetrics metrics = metricsFactory.create(getContext());
        grid = new CustomGrid(
                metrics,
                gridFactory,
                drawableGridFactory.createDrawableCell(getContext().getResources()));
        getHolder().addCallback(this);

        paint = new Paint();
        paint.setColor(Color.rgb(0, 0, 250));

        thread = new GameThread(getHolder(), this);
        setFocusable(true);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        this.setOnTouchListener((v, event) -> {
            grid.onPavementTouched(event);
            return false;
        });
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            grid.draw(canvas);
        }
    }

    public boolean needsToBeRedrawn() {
        return grid.needsToBeRedrawn();
    }
}
