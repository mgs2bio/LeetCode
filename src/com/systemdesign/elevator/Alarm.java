package com.systemdesign.elevator;

public interface Alarm {

    int age = 0;

    default String turnAlarmOn() {
        return "Turning the alarm on.";
    }

    default String turnAlarmOff() {
        return "Turning the alarm off.";
    }
}
