package com.barbuzinski.android;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import com.barbuzinski.R;

public class DrawableGridFactory {

    public Drawable create(Resources res) {
        return ResourcesCompat.getDrawable(res, R.drawable.ic_grid2, null);
    }
}
