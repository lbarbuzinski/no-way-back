package com.barbuzinski;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.barbuzinski.android.MetricsFactory;
import com.barbuzinski.model.Level;
import com.barbuzinski.model.LogicalGridFactory;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread thread;
    private Level grid;

    @Inject
    public GameView(@ActivityContext Context context, MetricsFactory metricsFactory, LogicalGridFactory gridFactory) {
        super(context);
        DisplayMetrics metrics = metricsFactory.create(getContext());
        grid = new Level(
                metrics,
                gridFactory);
        getHolder().addCallback(this);

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
