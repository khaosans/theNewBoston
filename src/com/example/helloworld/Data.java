package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {

	Button start, startFor;
	EditText sendET;
	TextView gotAnswer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		intialize();

	}

	private void intialize() {
		// TODO Auto-generated method stub
		start = (Button) findViewById(R.id.bSA);
		startFor = (Button) findViewById(R.id.bSAFR);
		sendET = (EditText) findViewById(R.id.etSend);
		gotAnswer = (TextView) findViewById(R.id.tvGot);
		start.setOnClickListener(this);
		startFor.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSA:
			// edit text convert to string
			String bread = sendET.getText().toString();
			// pass items in bundles/basket
			Bundle basket = new Bundle();// create new bundle object
			basket.putString("key", bread); // pass the string file name key
			// intent of this class and opens the opened class
			Intent a = new Intent(Data.this, OpenedClass.class);
			a.putExtras(basket);
			startActivity(a);
			
			break;
		case R.id.bSAFR:
			Intent i = new Intent(Data.this,OpenedClass.class);
			startActivityForResult(i,0);
			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle basket = data.getExtras();
			String s = basket.getString("answer");
			gotAnswer.setText(s);
		}
	}

}
