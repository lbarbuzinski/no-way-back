package com.barbuzinski.android;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import static java.util.Optional.ofNullable;

public class DrawablesRepository {

    private Resources resources;

    public DrawablesRepository(Resources resources) {
        this.resources = resources;
    }

    public Drawable getDrawable(Integer drawableId) {
        return ofNullable(drawableId).map(id -> resources.getDrawable(id, null)).orElse(null);
    }
}
