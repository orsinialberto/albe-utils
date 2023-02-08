package org.example.model;

public class Subscription {

    private String id;

    private Boolean subscribe;

    public Subscription(String id, Boolean subscribe) {
        this.id = id;
        this.subscribe = subscribe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        this.subscribe = subscribe;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id='" + id + '\'' +
                ", subscribe=" + subscribe +
                '}';
    }
}
