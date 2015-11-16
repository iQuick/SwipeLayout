package me.imli.swipelayout;

import me.imli.swipelayout.sb.SwipeBackLayout;
import me.imli.swipelayout.sb.SwipeBackLayout.OnSwipeBackListener;
import me.imli.swipelayout.sb.SwipeLayout;
import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SwipeBackActivity extends Activity{

	SwipeBackLayout sb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_back);
		

		sb = (SwipeBackLayout) findViewById(R.id.pl);
		sb.setOnSwipeBackListener(new OnSwipeBackListener() {
			
			@Override
			public void onBack() {
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
					sb.setDirection(SwipeLayout.DIRECTION_LEFT);
					break;
				case 2:
					sb.setDirection(SwipeLayout.DIRECTION_TOP);
					break;
				case 3:
					sb.setDirection(SwipeLayout.DIRECTION_RIGHT);
					break;
				case 4:
					sb.setDirection(SwipeLayout.DIRECTION_BUTTOM);
					break;
				case 5:
					sb.setDirection(SwipeLayout.DIRECTION_LEFT | SwipeLayout.DIRECTION_RIGHT);
					break;
				case 6:
					sb.setDirection(SwipeLayout.DIRECTION_TOP | SwipeLayout.DIRECTION_BUTTOM);
					break;

				default:
					break;
				}
			}
		});
	}
	
	
}
