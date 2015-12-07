package com.lxj.eventtest;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import de.greenrobot.event.EventBus;

public class SecondActivity extends Activity {
	TextView txv2;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		btn = (Button)super.findViewById(R.id.btn1);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EventBus.getDefault().post(new Event("EventBus success"));
			}
			
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
}
