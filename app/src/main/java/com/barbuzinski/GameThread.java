package com.barbuzinski;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    private final SurfaceHolder surfaceHolder;
    private GameView gameView;

    private boolean running;
    public static Canvas canvas;

    public GameThread(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;

    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int counter = 0;
        while (running) {
            canvas = null;
            if (gameView.needsToBeRedrawn()) {
                try {
                    canvas = this.surfaceHolder.lockCanvas();
                    synchronized (surfaceHolder) {
                        this.gameView.draw(canvas);
                        counter++;
                        if (System.currentTimeMillis() - start > 10000) {
                            System.out.println(counter);
                            return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (canvas != null) {
                        try {
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
