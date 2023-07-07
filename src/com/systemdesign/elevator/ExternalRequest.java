package com.systemdesign.elevator;

import java.time.Instant;

public class ExternalRequest {
    private Direction direction;

    private InternalRequest internalRequest;

    private long submitTime = System.currentTimeMillis();

    public long getSubmitTime() {
        return submitTime;
    }

    private int sourceFloor;

    public InternalRequest getInternalRequest() {
        return internalRequest;
    }

    public void setInternalRequest(InternalRequest internalRequest) {
        this.internalRequest = internalRequest;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
