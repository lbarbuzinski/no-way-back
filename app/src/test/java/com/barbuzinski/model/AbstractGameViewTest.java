package com.barbuzinski.model;

import android.util.DisplayMetrics;

import com.barbuzinski.android.DrawablesRepository;

import org.junit.Before;
import org.mockito.Mock;

public class AbstractGameViewTest {

    static final int WIDTH_PIXELS = 500;
    static final int HEIGHT_PIXELS = 1000;

    protected Level level;

    @Mock
    private DrawablesRepository drawablesRepository;

    private LogicalGridFactory logicalGridFactory = new LogicalGridFactory(drawablesRepository);

    @Before
    public void setUpAbstractGameViewTest() {
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.widthPixels = WIDTH_PIXELS;
        metrics.heightPixels = HEIGHT_PIXELS;

        level = new Level(metrics, logicalGridFactory);
    }
}
