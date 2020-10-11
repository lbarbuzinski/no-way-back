package com.barbuzinski.utils;

import android.graphics.Canvas;

public abstract class Animation {

    protected Progress progress;

    private Animation(Progress progress) {
        this.progress = progress;
    }

    public Animation() {
        this(Progress.FROZEN);
    }

    public Animation(int progressTimeMillis, ProgressCompletedCallback callback) {
        this(new Progress(progressTimeMillis, callback));
    }

    public abstract void draw(Canvas canvas);
}
