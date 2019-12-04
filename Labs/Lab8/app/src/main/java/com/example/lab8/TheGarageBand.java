package com.example.lab8;

public class TheGarageBand {

    private String bandName;
    private String bandURL;


    private void setBandInfo (Integer genre) {

        switch (genre) {

            case 0:
                bandName = "Greensky Bluegrass";
                bandURL = "https://www.greenskybluegrass.com/#!/";
                break;

            case 1:
                bandName = "The Grateful Dead";
                bandURL = "https://www.dead.net/";
                break;

            case 2:
                bandName = "Led Zeppelin";
                bandURL = "https://lz50.ledzeppelin.com/?ref=https://www.google.com/";
                break;

            case 3:
                bandName = "Metallica";
                bandURL = "https://www.metallica.com/";
                 break;

            case 4:
                bandName = "Kendrick Lamar";
                bandURL = "http://www.kendricklamar.com/";
                break;

            default:
                bandName = "None";
                bandURL = "https://www.google.com/search?q=music+genres&oq=music+genres&aqs=chrome..69i57j0l5.4996j0j4&sourceid=chrome&ie=UTF-8";

        }

    }

    public String getBandName() {
        return bandName;
    }

    public String getBandURL() {
        return bandURL;
    }

    public void setBandName(Integer genre) {setBandInfo(genre);}

}
