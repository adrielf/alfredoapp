package edu.fatec.alfredo;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public class WifiActivity extends Activity{
    WifiManipulator wifi = new WifiManipulator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        TextView result = (TextView) findViewById(R.id.value);

        List<ScanResult> results = wifi.getConections(this);

        if(results!=null){

            StringBuilder info = new StringBuilder();

            for(ScanResult connection: results){
                result.setText(info.append("\n").append(connection.SSID).append("\n").append("ID: ").append(connection.BSSID).append("\n").append(String.valueOf(connection.level)).append("\n"));
            }

        } else {
            result.setText("Sem conexões");
        }

    }

}

class WifiManipulator {

    WifiManager wifiManager;

    public List<ScanResult> getConections(Context context){
        wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        wifiManager.startScan();
        List<android.net.wifi.ScanResult> connections = wifiManager.getScanResults();
        return connections;

    }

}


//switch on and off the Wifi
//wifi.setWifiEnabled(parameter);

