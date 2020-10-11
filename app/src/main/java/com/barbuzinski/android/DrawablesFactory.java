package com.barbuzinski.android;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import com.barbuzinski.R;

public class DrawablesFactory {

    public Drawable createDrawableCell(Resources res) {
        return ResourcesCompat.getDrawable(res, R.drawable.ic_cell2, null);
    }
}
