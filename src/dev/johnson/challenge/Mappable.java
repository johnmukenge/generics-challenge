package dev.johnson.challenge;

import java.util.Arrays;

public interface Mappable {
    void render();

    static double[] stringToLatLon(String location) {
        var splits = location.split(",");
        double lat = Double.valueOf(splits[0]);
        double lon = Double.valueOf(splits[1]);
        return new double[]{lat, lon};
    }
}

abstract class Point implements Mappable {
    private double[] location = new double[2];// lon and lat

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }
    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + locations() + ")");
    }

    private String locations(){
        return Arrays.toString(location);
    }
}

abstract class Line implements Mappable {
    private double [][] locations;
    public Line(String... location) {
        this.locations = new double[location.length][];
        int index = 0;
        for (String s : location) {
            this.locations[index++] = Mappable.stringToLatLon(s);
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }

    private String locations(){
        return Arrays.deepToString(locations);
    }
}
