package dev.me.exercises;

import dev.me.exercises.Request.Priority;
import java.time.Instant;
import java.util.Comparator;
import java.util.PriorityQueue;

class Request<T> {
    enum Priority {
        HIGH(0),
        NORMAL(1),
        LOW(2);

        private final Integer value;

        Priority(Integer value) {
            this.value = value;
        }

        Integer value() {
            return this.value;
        }
    }

    private T payload;
    private Instant createdOn;
    private Priority priority;

    public Request(T payload, Instant createdOn, Priority priority) {
        this.payload = payload;
        this.createdOn = createdOn;
        this.priority = priority;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Request{" +
                "payload='" + payload + '\'' +
                ", createdOn=" + createdOn +
                ", priority=" + priority +
                '}';
    }
}

class Payload {
    private String content;

    public Payload(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "content='" + content + '\'' +
                '}';
    }
}

public class PriorityQueue2 {
    public static void main(String[] args) {
        Comparator<Request<Payload>> comparator = Comparator
                .comparing(Request<Payload>::getPriority)
                .thenComparing(Request::getCreatedOn);


        var queue = new PriorityQueue<Request<Payload>>(comparator);

        var now = Instant.now();

        queue.add(buildRequest("payload1", now, Priority.LOW));
        queue.add(buildRequest("payload2", now.plusSeconds(1), Priority.LOW));
        queue.add(buildRequest("payload3", now.plusSeconds(2), Priority.NORMAL));
        queue.add(buildRequest("payload4", now.plusSeconds(3), Priority.NORMAL));
        queue.add(buildRequest("payload5", now.plusSeconds(4), Priority.HIGH));
        queue.add(buildRequest("payload6", now, Priority.HIGH));

        var max = queue.size();
        for(int i=0; i<max;i++) {
            System.out.println(queue.poll());
        }
    }

    public static Request<Payload> buildRequest(String payload, Instant createdOn, Priority priority) {
        return new Request(new Payload(payload), createdOn, priority);
    }
}
