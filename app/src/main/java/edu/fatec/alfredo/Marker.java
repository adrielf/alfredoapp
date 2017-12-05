package edu.fatec.alfredo;


public class Marker {

    private Double lat;
    private Double lon;
    private String name;

    public Marker(Double l, Double lo, String name){
        lat = l;
        lon = lo;
        name = name;
    }

    public Double getLat(){
        return lat;
    }

    public Double getLon(){
        return lon;
    }

    public String getName() { return name; }
}