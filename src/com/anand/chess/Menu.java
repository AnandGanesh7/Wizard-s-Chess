package com.anand.chess;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu extends Activity implements TextToSpeech.OnInitListener
{

	ImageView ivscreen1;
	TextToSpeech mTts;
	TextView tv1,tv2,tv3,tv4,tv5,tv6;
	//String instruct="Please touch and hold the screen. or shake the device";
	String instruct="Hold down your finger on the screen Ore . Shake the device to give your choice.";
	private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		mTts = new TextToSpeech(this, this);
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
		mAccel = 0.00f;
		mAccelCurrent = SensorManager.GRAVITY_EARTH;
		mAccelLast = SensorManager.GRAVITY_EARTH;
		ivscreen1=(ImageView) findViewById(R.id.imageViewStartMenu);
		tv1 = (TextView) findViewById(R.id.textView1);
		tv2 = (TextView) findViewById(R.id.textView2);
		tv3 = (TextView) findViewById(R.id.textView3);
		tv4 = (TextView) findViewById(R.id.textView4);
		tv5 = (TextView) findViewById(R.id.textView5);
		tv6 = (TextView) findViewById(R.id.textView6);
		Typeface tf = Typeface.createFromAsset(getAssets(), "OldLondonAlternate.ttf");
		tv1.setTypeface(tf);
		tv2.setTypeface(tf);
		tv3.setTypeface(tf);
		tv4.setTypeface(tf);
		tv5.setTypeface(tf);
		tv6.setTypeface(tf);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					say(instruct);
				}

			}
		};
		timer.start();

		ivscreen1.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				startVoiceRecognitionActivity();
				return false;
			}

		});  
	}


	/**
	 * Fire an intent to start the speech recognition activity.
	 */
	private void startVoiceRecognitionActivity() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say your choice");
		startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
	}
	/**
	 * Handle the results from the recognition activity.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		int i,count;
		if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
			// Fill the list view with the strings the recognizer thought it could have heard
			ArrayList<String> matches = data.getStringArrayListExtra(
					RecognizerIntent.EXTRA_RESULTS);
			for(i=0,count=0;i<matches.size() && count==0;i++)
			{

				if(matches.get(i).substring(0).contains("three") || matches.get(i).substring(0).contains("Three") || matches.get(i).substring(0).contains("3")|| matches.get(i).substring(0).contains("instructions")|| matches.get(i).substring(0).contains("Instructions")|| matches.get(i).substring(0).contains("instruction"))
				{
					Intent inst=new Intent(Menu.this,Instructions.class);
					startActivity(inst);	
					count++;
				}
				else if(matches.get(i).substring(0).contains("five") || matches.get(i).substring(0).contains("Five") || matches.get(i).substring(0).contains("5")|| matches.get(i).substring(0).contains("exit")|| matches.get(i).substring(0).contains("Exit"))
				{	
					count++;
					finish();
				}
				else if(matches.get(i).substring(0).contains("One") ||matches.get(i).substring(0).contains("one") || matches.get(i).substring(0).contains("1")|| matches.get(i).substring(0).contains("single")|| matches.get(i).substring(0).contains("Single"))
				{
					Intent oneplayer=new Intent(Menu.this,MainActivity.class);
					oneplayer.putExtra("mode", 1);
					startActivity(oneplayer);	
					count++;
				}
				else if(matches.get(i).substring(0).contains("two") || matches.get(i).substring(0).contains("Two") || matches.get(i).substring(0).contains("2"))
				{
					Intent twoplayer=new Intent(Menu.this,MainActivity.class);
					twoplayer.putExtra("mode", 2);
					startActivity(twoplayer);	
					count++;
				}
				else if(matches.get(i).substring(0).contains("about") || matches.get(i).substring(0).contains("About") || matches.get(i).substring(0).contains("4")|| matches.get(i).substring(0).contains("four")|| matches.get(i).substring(0).contains("Four"))
				{
					Intent about1=new Intent(Menu.this,Aboutus.class);
					startActivity(about1);	
					count++;
				}
			}
			if(count==0)
			{
				say("Invalid choice . Please give a valid input.");
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}



	@Override
	public void onInit(int status) {
		// status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR.
		if (status == TextToSpeech.SUCCESS) 
		{
			int result = mTts.setLanguage(Locale.UK);
			if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) 
			{
				result= mTts.setLanguage(Locale.ENGLISH);
			}
			else if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) 
			{
				result=mTts.setLanguage(Locale.US);
			}
			else if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) 
			{
				mTts.setLanguage(Locale.CANADA);
			}
		}
	}


	/* put this into your activity class */
	private SensorManager mSensorManager;
	private float mAccel=0; // acceleration apart from gravity
	private float mAccelCurrent; // current acceleration including gravity
	private float mAccelLast; // last acceleration including gravity

	private final SensorEventListener mSensorListener = new SensorEventListener() {

		public void onSensorChanged(SensorEvent se) {
			float x = se.values[0];
			float y = se.values[1];
			float z = se.values[2]; 
			mAccelLast = mAccelCurrent;
			mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
			float delta = mAccelCurrent - mAccelLast;
			mAccel = mAccel * 0.9f + delta; // perform low-cut filter
			if(mAccelCurrent-mAccelLast>5)
				startVoiceRecognitionActivity();
		}

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
	};
	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		mSensorManager.unregisterListener(mSensorListener);
		super.onPause();
	}

	@Override
	public void onDestroy() {
		// Don't forget to shutdown!
		if (mTts != null) {
			mTts.stop();
			mTts.shutdown();
		}

		super.onDestroy();
	}
	private void say(String text)
	{
		mTts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}
}
