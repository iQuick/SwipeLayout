package me.imli.swipelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btn_swipe_back).setOnClickListener(this);
		findViewById(R.id.btn_swipe_switch).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_swipe_back:
			Intent intent1 = new Intent(MainActivity.this, SwipeBackActivity.class);
			startActivity(intent1);
			break;
		case R.id.btn_swipe_switch:
			Intent intent2 = new Intent(MainActivity.this, SwipeSwitchActivity.class);
			startActivity(intent2);
			break;

		default:
			break;
		}
	}
}
