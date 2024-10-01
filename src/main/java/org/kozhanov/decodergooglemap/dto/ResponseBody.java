package org.kozhanov.decodergooglemap.dto;

public class ResponseBody {
    private double[] startPoint;
    private double[] endPoint;
    private String startAddress;
    private String endAddress;
private double distance;

    public ResponseBody(double[] startPoint, double[] endPoint, String startAddress, String endAddress, double distance) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.distance = distance;
    }

    public double[] getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(double[] startPoint) {
        this.startPoint = startPoint;
    }

    public double[] getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(double[] endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
