package com.barbuzinski.model;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

import org.junit.Before;
import org.mockito.Mock;

public class AbstractGameViewTest {

    static final int WIDTH_PIXELS = 500;
    static final int HEIGHT_PIXELS = 1000;

    protected Level level;

    @Mock
    private Drawable drawableCell;

    private LogicalGridFactory logicalGridFactory = new LogicalGridFactory();

    @Before
    public void setUpAbstractGameViewTest() {
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.widthPixels = WIDTH_PIXELS;
        metrics.heightPixels = HEIGHT_PIXELS;

        level = new Level(metrics, logicalGridFactory, drawableCell);
    }
}
