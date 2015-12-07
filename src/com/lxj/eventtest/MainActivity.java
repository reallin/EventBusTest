package com.lxj.eventtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

public class MainActivity extends Activity {
	Button btn;
	TextView txv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		EventBus.getDefault().register(this);
		btn = (Button)super.findViewById(R.id.btn);
		txv = (TextView)super.findViewById(R.id.txv1);
		
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(MainActivity.this,  
                        SecondActivity.class);  
                startActivity(intent);
			}
			
		});
	}
	public void onEventMainThread(Event event) {

		String msg = "onEventMainThread收到了消息：" + event.getMsg();
		Log.d("harvic", msg);
		txv.setText(msg);
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	} 
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
}
