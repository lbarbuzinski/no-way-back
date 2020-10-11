package com.barbuzinski.utils;

import static com.barbuzinski.utils.ProgressCompletedCallback.EMPTY_CALLBACK;

public class Progress {

    public static final float DONE = 1.0f;

    public static final Progress FROZEN = new Progress() {
        @Override
        public boolean done() {
            return true;
        }

        @Override
        public float progress() {
            return DONE;
        }
    };

    private long startedAt;
    private long intervalMillis;
    private boolean done;
    private ProgressCompletedCallback callback = EMPTY_CALLBACK;

    private Progress() {}

    public Progress(long intervalMillis, ProgressCompletedCallback callback) {
        this.intervalMillis = intervalMillis;
        this.callback = callback;
        this.startedAt = System.currentTimeMillis();
    }

    public float progress() {
        if (done)
            return DONE;

        float progress = (float) (System.currentTimeMillis() - startedAt) / intervalMillis;
        if (progress >= DONE) {
            done = true;
            callback.completed();
            return DONE;
        } else
            return progress;
    }

    public boolean done() {
        return done;
    }

}
