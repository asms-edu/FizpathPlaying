package com.here.fizpathplaying;

import android.app.Activity;
import android.content.res.Resources;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class AppSensor extends Activity implements SensorEventListener{
	 private static final int TYPE_ACCELEROMETER = 0;
	private SensorManager sensorManager;
	 double ax,ay,az;   // these are the acceleration in x,y and z axis
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mainscreen);
	        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
	        sensorManager.registerListener(this, sensorManager.getDefaultSensor(AppSensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	   }
	   public void onAccuracyChanged(AppSensor arg0, int arg1) {
	   }

	   @Override
	   public void onSensorChanged(SensorEvent event) {
	        if (event.sensor.getType()==AppSensor.TYPE_ACCELEROMETER){
	            ax=event.values[0];
	                    ay=event.values[1];
	                    az=event.values[2];
	            }
	        //R.string.valuex = (int) az;
	        Resources res = getResources();
	        String.format(res.getString(R.string.valuex), az);
	        System.out.println(az);
	   }
	@Override
	public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	}