package org.kozhanov.decodergooglemap.repository;

public interface DecoderRepo {
    public String getPoint(double lat, double lng);
    public double getDistance(double[] startPos, double[] endPos);
}
