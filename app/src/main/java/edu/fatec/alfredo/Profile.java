package edu.fatec.alfredo;


import java.io.Serializable;

public class Profile implements Serializable{

    private String name;
    private String local_gps;
    private String local_wifi;
    private boolean wifi;
    private boolean gps;
    private boolean data3G;
    private boolean vibrate;
    private boolean silence;
    private boolean ringtone;


    public Profile() {
    }

    public Profile(String name, boolean wifi, boolean gps, boolean data3G, boolean vibrate, boolean silence, boolean ringtone) {
        this.name = name;
        this.wifi = wifi;
        this.gps = gps;
        this.data3G = data3G;
        this.vibrate = vibrate;
        this.silence = silence;
        this.ringtone = ringtone;
    }

    public Profile(String name, String local_gps, String local_wifi, boolean wifi, boolean gps, boolean data3G, boolean vibrate, boolean silence, boolean ringtone) {
        this.name = name;
        this.local_gps = local_gps;
        this.local_wifi = local_wifi;
        this.wifi = wifi;
        this.gps = gps;
        this.data3G = data3G;
        this.vibrate = vibrate;
        this.silence = silence;
        this.ringtone = ringtone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean getGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean getData3G() {
        return data3G;
    }

    public void setData3G(boolean data3G) {
        this.data3G = data3G;
    }

    public boolean getVibrate() {
        return vibrate;
    }

    public void setVibrate(boolean vibrate) {
        this.vibrate = vibrate;
    }

    public boolean getSilence() {
        return silence;
    }

    public void setSilence(boolean silence) {
        this.silence = silence;
    }

    public boolean getRingtone() { return ringtone; }

    public void setRingtone(boolean ringtone) { this.ringtone = ringtone; }

    public String getLocal_gps() {return local_gps;    }

    public void setLocal_gps(String local_gps) {this.local_gps = local_gps;}

    public String getLocal_wifi() {return local_wifi;}

    public void setLocal_wifi(String local_wifi) {this.local_wifi = local_wifi;}
}
