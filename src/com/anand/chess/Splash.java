package com.anand.chess;


import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

public class Splash extends Activity implements TextToSpeech.OnInitListener
{
	TextToSpeech mTts;

	String welcome1="Welcome to voice operated chess.";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		mTts = new TextToSpeech(this, this);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(4000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent intent1 = new Intent(Splash.this,Menu.class);
					startActivity(intent1);
				}

			}
		};
		timer.start();



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
			say(welcome1);
		}
	}



	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
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
