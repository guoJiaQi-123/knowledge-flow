package com.dataStructure.dataStructure.priorityqueue;

import java.util.Objects;

public class Entry implements Priority {

    String value;
    int priority;

    public Entry(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "value='" + value + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return priority == entry.priority && Objects.equals(value, entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, priority);
    }
}
