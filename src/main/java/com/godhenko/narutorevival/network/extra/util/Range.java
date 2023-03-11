package com.godhenko.narutorevival.network.extra.util;

public class Range {
    private final int from;
    private final int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    /**
     * @return True if value is in range, false if not. From is inclusive, to is exclusive
     */
    public boolean isIn(int value) {
        return value >= from && value < to;
    }

    @Override
    public String toString() {
        return "Range{from=" + from + ",to=" + to + "}";
    }
}
