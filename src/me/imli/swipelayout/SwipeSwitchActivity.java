package me.imli.swipelayout;

import me.imli.swipelayout.sb.SwipeLayout;
import me.imli.swipelayout.sb.SwipeSwitchLayout;
import me.imli.swipelayout.sb.SwipeSwitchLayout.OnSwipeSwitchListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SwipeSwitchActivity extends Activity {

	SwipeSwitchLayout sb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_switch);

		sb = (SwipeSwitchLayout) findViewById(R.id.pl);
		sb.setOnSwipeSwitchListener(new OnSwipeSwitchListener() {
			
			@Override
			public void onPrevious() {
				// 上一个
				Intent intent = new Intent(SwipeSwitchActivity.this, SwipeSwitchActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.push_f_right_in, R.anim.push_f_right_out);
				finish();
			}
			
			
			@Override
			public void onNext() {
				// 下一个
				Intent intent = new Intent(SwipeSwitchActivity.this, SwipeSwitchActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.push_f_left_in, R.anim.push_f_left_out);
				finish();
			}
		});
		
		RadioGroup group = (RadioGroup) findViewById(R.id.rg);
		for (int i = 0; i < group.getChildCount(); i++) {
			RadioButton btn = (RadioButton) group.getChildAt(i);
			btn.setId(i+1);
		}
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
			
				switch (checkedId) {
				case 1:
					sb.setDirection(SwipeLayout.DIRECTION_HORIZONTAL);
					break;
				case 2:
					sb.setDirection(SwipeLayout.DIRECTION_VERTICAL);
					break;

				default:
					break;
				}
			}
		});
	}
	
}
