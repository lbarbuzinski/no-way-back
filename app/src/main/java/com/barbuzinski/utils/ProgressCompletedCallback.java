package com.barbuzinski.utils;

public interface ProgressCompletedCallback {

    ProgressCompletedCallback EMPTY_CALLBACK = () -> {};

    void completed();
}
