package com.example.disen.tourguide;

/**
 * Created by disen on 6/19/2017.
 */

public class MyArrayList {
    private String name;
    private String description;
    private String location;
    private int image;
    private String webpage_url;
    private String lat_lon;
    private int sound;
    private int play_icon;
    public MyArrayList(){

    }

    public MyArrayList(String name, String description, String location, int sight){
        this.name = name;
        this.description = description;
        this.location = location;
        this.image = sight;
    }
    public MyArrayList(String name, String location, int sight){
        this.name = name;
        this.description = description;
        this.location = location;
        this.image = sight;
    }
    public MyArrayList(String english, String french, String pronounciation, int image, int sound, int play_icon){
        this.name = english;
        this.description = french;
        this.location = pronounciation;
        this.image = image;
        this.sound = sound;
        this.play_icon = play_icon;
    }

    public MyArrayList(String name, String description, String location, int sight, String webpage_url, String lat_lon){
        this.name = name;
        this.description = description;
        this.location = location;
        this.image = sight;
        this.webpage_url = webpage_url;
        this.lat_lon = lat_lon;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
    public int getPlay_icon(){
        return play_icon;
    }
    public String getLocation(){
        return location;
    }
    public int getImage(){
        return image;
    }
    public String getWebpage_url(){
        return webpage_url;
    }
    public String getLat_lon(){
        return lat_lon;
    }
    public int getSound(){
        return sound;
    }

}
