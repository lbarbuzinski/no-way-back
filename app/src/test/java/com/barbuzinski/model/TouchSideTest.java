package com.barbuzinski.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.barbuzinski.android.DrawableGridFactory;
import com.barbuzinski.android.MetricsFactory;
import com.barbuzinski.android.PaintFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TouchSideTest {

    private static final int WIDTH_PIXELS = 500;
    private static final int HEIGHT_PIXELS = 1000;

    @Mock
    private Context context;

    @Mock
    private MotionEvent event;

    @Mock
    private Drawable drawableGrid;

    @Mock
    private DrawableGridFactory drawableGridFactory;

    @Mock
    private MetricsFactory metricsFactory;

    @Mock
    private PaintFactory paintFactory;

    private PavementGrid grid;

    @Before
    public void setUp() {
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.widthPixels = WIDTH_PIXELS;
        metrics.heightPixels = HEIGHT_PIXELS;

        when(metricsFactory.create(context)).thenReturn(metrics);
        when(drawableGridFactory.create(any())).thenReturn(drawableGrid);

        grid = new RectangularGrid(context, drawableGridFactory, metricsFactory, paintFactory);
    }

    @Test
    public void shouldDetermineUpLeft() {
        //given
        when(event.getX()).thenReturn(0f);
        when(event.getY()).thenReturn(0f);

        //then
        assertSame(TouchSide.UP_LEFT, TouchSide.determine(grid.vehicle, event));
    }

    @Test
    public void shouldDetermineDownRight() {
        //given
        when(event.getX()).thenReturn((float) WIDTH_PIXELS);
        when(event.getY()).thenReturn((float) HEIGHT_PIXELS);

        //then
        assertSame(TouchSide.DOWN_RIGHT, TouchSide.determine(grid.vehicle, event));
    }
}