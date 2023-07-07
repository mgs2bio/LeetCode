package com.systemdesign.elevator;

public enum Direction {

    UP("going up"),
    DOWN("going down");

    public final String value1;

    private Direction(String value1) {
        this.value1 = value1;
    }

    public boolean isUp() {
        return this.equals(UP);
    }
}
