package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {

	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle Nextone) {
		// TODO Auto-generated method stub
		super.onCreate(Nextone);
		setContentView(R.layout.splash_activity);

		// below plays the first sound of the screen
		ourSong = MediaPlayer.create(Splash.this, R.raw.splash_sound);

		// preference from the song
		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());

		boolean music = getPrefs.getBoolean("checkbox", true);// gets it from
																// the key from
																// xml
																// preference
		if (music == true) {
			ourSong.start();
		}
		//#57 tutorial
		// below starts the initial start page of the apple
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1000); // sleeps for 5 seconds
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingPoint = new Intent(
							"com.example.helloworld.MENU");

					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();

	}

	// kill the first page
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
