package org.kozhanov.decodergooglemap.dto;

import java.util.Arrays;

public class RequestParam {
    private double[] startPos;
    private double[] endPos;

    public double[] getStartPos() {
        return startPos;
    }

    public void setStartPos(double[] startPos) {
        this.startPos = startPos;
    }

    public double[] getEndPos() {
        return endPos;
    }

    public void setEndPos(double[] endPos) {
        this.endPos = endPos;
    }

    @Override
    public String toString() {
        return "RequestParam{" +
                "startPos=" + Arrays.toString(startPos) +
                ", endPos=" + Arrays.toString(endPos) +
                '}';
    }
}
