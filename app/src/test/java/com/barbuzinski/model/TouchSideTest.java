package com.barbuzinski.model;

import android.view.MotionEvent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TouchSideTest extends AbstractGameViewTest {

    @Mock
    private MotionEvent event;

    @Test
    public void shouldDetermineUpLeft() {
        //given
        when(event.getX()).thenReturn(0f);
        when(event.getY()).thenReturn(0f);

        //then
        assertSame(TouchSide.UP_LEFT, TouchSide.determine(level.vehicle, event));
    }

    @Test
    public void shouldDetermineDownRight() {
        //given
        when(event.getX()).thenReturn((float) WIDTH_PIXELS);
        when(event.getY()).thenReturn((float) HEIGHT_PIXELS);

        //then
        assertSame(TouchSide.DOWN_RIGHT, TouchSide.determine(level.vehicle, event));
    }
}