package com.systemdesign.elevator;

import java.util.*;

import static com.systemdesign.elevator.Direction.DOWN;
import static com.systemdesign.elevator.Direction.UP;
import static com.systemdesign.elevator.State.Idle;
import static com.systemdesign.elevator.State.Moving;

public class Elevator {

    private State currentState = State.Idle;
    private Direction currentDirection = UP;
    private int currentFloor = 0;

    private TreeSet<InternalRequest> upRequestToProcess = new TreeSet<>((o1, o2) ->
            o1.getDestFloor() - o2.getDestFloor());
    private TreeSet<InternalRequest> downRequestToProcess = new TreeSet<>((o1, o2) ->
            o2.getDestFloor() - o1.getDestFloor());
    private Map<Integer, ExternalRequest> pendingRequests = new HashMap<>();


    public void start() {
        while (true) {
            while (!upRequestToProcess.isEmpty()) {
                updateStatus(UP);
                moveTo(++currentFloor, upRequestToProcess);
            }
            while (!downRequestToProcess.isEmpty()) {
                updateStatus(DOWN);
                moveTo(--currentFloor, downRequestToProcess);
            }
            if (!pendingRequests.isEmpty()) {
                ExternalRequest exReq = getEarliestPendingRequest();
                if (currentFloor > exReq.getSourceFloor()) {
                    updateStatus(DOWN);
                    moveTo(--currentFloor);
                } else if (currentFloor < exReq.getSourceFloor()) {
                    updateStatus(UP);
                    moveTo(++currentFloor);
                } else {
                    InternalRequest inReq = exReq.getInternalRequest();
                    pendingRequests.remove(exReq.getSourceFloor());
                    if (exReq.getDirection().isUp()) {
                        updateStatus(UP);
                        upRequestToProcess.add(inReq);
                    } else {
                        updateStatus(DOWN);
                        downRequestToProcess.add(inReq);
                    }
                }
                continue;
            }
            currentState = Idle;
        }
    }

    private void updateStatus(Direction direction) {
        currentState = Moving;
        currentDirection = direction;
    }

    private ExternalRequest getEarliestPendingRequest() {
        return pendingRequests.entrySet().stream().sorted((e1, e2) ->
                        e1.getValue().getSubmitTime() - e2.getValue().getSubmitTime() > 0 ? 1 : -1
                )
                .findFirst()
                .get()
                .getValue();
    }


    private void moveTo(int floor) {
        moveTo(floor, null);
    }

    private void moveTo(int floor, TreeSet<InternalRequest> requestToProcess) {
        try {
            Thread.sleep(2000);
            System.out.println("reached the floor #" + floor);
            currentFloor = floor;
            if (requestToProcess != null && !requestToProcess.isEmpty() &&
                    requestToProcess.first().getDestFloor() == currentFloor) {
                requestToProcess.pollFirst();
                System.out.println("Please exit");
            }
            addRequestInSameDirection(floor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addRequestInSameDirection(int floor) {
        ExternalRequest externalRequest = pendingRequests.get(floor);
        if (externalRequest != null) {
            Direction direction = externalRequest.getDirection();
            if (currentDirection.equals(direction)) {
                pendingRequests.remove(floor);
                System.out.println("Door opened at #" + floor + ", Please enter.");
                InternalRequest inReq = externalRequest.getInternalRequest();
                if (direction.isUp()) {
                    upRequestToProcess.add(inReq);
                } else {
                    downRequestToProcess.add(inReq);
                }
            }
        }
    }

    public void submitExternalRequest(ExternalRequest externalRequest) {
        pendingRequests.put(externalRequest.getSourceFloor(), externalRequest);
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        Thread thread = new Thread(elevator::start);
        thread.start();
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter 1: UP, 2: DOWN");
            int upOrDown = keyboard.nextInt();
            ExternalRequest exReq = new ExternalRequest();
            exReq.setDirection(upOrDown == 1 ? UP : DOWN);
            System.out.println("Please enter current floor");
            int currentFloor = keyboard.nextInt();
            exReq.setSourceFloor(currentFloor);
            System.out.println("Please enter destination floor:");
            int floor = keyboard.nextInt();
            InternalRequest inReq = new InternalRequest();
            inReq.setDestFloor(floor);
            inReq.setSourceFloor(currentFloor);
            exReq.setInternalRequest(inReq);
            elevator.submitExternalRequest(exReq);
        }

    }


}
