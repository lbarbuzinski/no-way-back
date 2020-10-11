package com.barbuzinski.utils.animation;

import android.graphics.Canvas;

import com.barbuzinski.utils.Progress;
import com.barbuzinski.utils.ProgressCompletedCallback;

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
