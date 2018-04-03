package com.frangoudes.sensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        /*
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        */

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

        /*
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
        */
    }

    /**
     * Called when the user clicks the Get Sensors button
     */
    public void getSensors(View view) {

        SensorManager mgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = mgr.getSensorList(Sensor.TYPE_ALL);
        Log.d("Sensors", "Name, Type, Vendor, Version");

        for (Sensor sensor : sensors) {
            Log.d("Sensors", sensor.getName() + ", " +
                    sensor.getStringType() + ", " +
                    sensor.getVendor() + ", " +
                    sensor.getVersion());
        }

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Sensors: Name, Type, Vendor, Version\n");

        for (Sensor sensor : sensors) {
            textView.append(sensor.getName()+", " +
                    sensor.getStringType()+", " +
                    sensor.getVendor()+", " +
                    sensor.getVersion()+ "\n");
        }
    }
}
