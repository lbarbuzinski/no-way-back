package com.barbuzinski.utils.position;

public class StaticPosition implements Position {

    private int x;
    private int y;

    public StaticPosition() {

    }

    public StaticPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public StaticPosition getScreenPosition() {
        return this;
    }
}
