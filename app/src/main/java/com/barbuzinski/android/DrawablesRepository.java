package com.barbuzinski.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ActivityContext;

import static java.util.Optional.ofNullable;

public class DrawablesRepository {

    private final Resources resources;

    @Inject
    public DrawablesRepository(@ActivityContext Context context) {
        this.resources = context.getResources();
    }

    public Drawable getDrawable(Integer drawableId) {
        return ofNullable(drawableId).map(id -> resources.getDrawable(id, null)).orElse(null);
    }
}
