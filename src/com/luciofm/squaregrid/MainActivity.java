package com.luciofm.squaregrid;

import java.util.Random;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	SquareGridLayout grid;
	Random rnd = new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		grid = (SquareGridLayout) findViewById(R.id.grid);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
			grid.getLayoutTransition().enableTransitionType(
					LayoutTransition.CHANGING);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_add) {
			View v = new View(this);
			int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256),
					rnd.nextInt(256));
			v.setBackgroundColor(color);
			grid.addView(v, 0);
		} else if (item.getItemId() == R.id.action_remove) {
			if (grid.getChildCount() > 0)
				grid.removeViewAt(0);
		} else if (item.getItemId() == R.id.action_add_column) {
			grid.setColumnCount(grid.getColumnCount() + 1);
		} else if (item.getItemId() == R.id.action_remove_column) {
			if (grid.getColumnCount() > 1)
				grid.setColumnCount(grid.getColumnCount() - 1);
		}

		return super.onOptionsItemSelected(item);
	}
}
