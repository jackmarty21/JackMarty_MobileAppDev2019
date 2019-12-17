package com.example.martyfinalpart1;

public class BurritoClass {

    private String burritoLocation;
    private String locationURL;

    private void setLocationInfo(Integer location){
        switch (location){
            case 0: //popular
                burritoLocation="Illegal Pete's";
                locationURL="https://www.illegalpetes.com/";
                break;
            case 1: //cycling
                burritoLocation="Chipotle";
                locationURL="https://www.chipotle.com/";
                break;
            case 2: //hipster
                burritoLocation="Bartaco";
                locationURL="https://bartaco.com/";
                break;
            default:
                burritoLocation="none";
                locationURL="https://www.google.com/search?q=mexican+food&oq=mexican+food&aqs=chrome..69i57j0l7.3607j0j4&sourceid=chrome&ie=UTF-8";
        }
    }

    public String getBurritoLocation(){
        return burritoLocation;
    }

    public String getLocationURL(){
        return locationURL;
    }

    public void setBurritoLocation(Integer location){
        setLocationInfo(location);
    }

    public void setLocationURL(Integer location){
        setLocationInfo(location);
    }
}
