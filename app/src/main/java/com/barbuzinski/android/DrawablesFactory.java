package com.barbuzinski.android;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

import androidx.core.content.res.ResourcesCompat;

import com.barbuzinski.R;

public class DrawablesFactory {

    public Drawable createDefaultGrid(Resources res, DisplayMetrics metrics) {
        Drawable drawableGrid = ResourcesCompat.getDrawable(res, R.drawable.ic_grid2, null);

        //TODO read height and width from image
        drawableGrid.setBounds(0, 0, metrics.widthPixels, metrics.widthPixels / 2);
        return drawableGrid;
    }

    public Drawable createDrawableCell(Resources res) {
        return ResourcesCompat.getDrawable(res, R.drawable.ic_cell2, null);
    }
}
