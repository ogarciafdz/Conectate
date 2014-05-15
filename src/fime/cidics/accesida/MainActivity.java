package fime.cidics.accesida;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements OnItemClickListener {
	private DrawerLayout mDrawer;
	private ProgressBar progBar;
	private ListView mDrawerOptions;
	private static final String[] values = { "\tNivel 1", "\tNivel 2",
			"\tNivel 3", "\tNivel 4", "\tNivel 5", "\tNivel 6", "\tNivel 7",
			"\tNivel 8" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		mDrawerOptions = (ListView) findViewById(R.id.left_drawer);
		mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerOptions
				.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1,
						android.R.id.text1, values));
		mDrawerOptions.setOnItemClickListener(this);

		progBar = (ProgressBar) findViewById(R.id.progressBar1);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int i, long arg3) {
		// Toast.makeText(this, "Pulsado " + values[i],
		// Toast.LENGTH_SHORT).show();
		mDrawer.closeDrawers();
		Class cambio = null;
		switch (i) {
		case 0:

			cambio = Sesion1.class;
			break;
		case 1:
			if (checkLast(2)) {
				cambio = Sesion2.class;
				break;
			} else {
				break;
			}
		case 2:
			if (checkLast(3)) {
				cambio = Sesion3.class;
				break;
			} else {
				break;
			}
		case 3:
			if (checkLast(4)) {
				cambio = Sesion4.class;
				break;
			} else {
				break;
			}
		case 4:
			if (checkLast(5)) {
				cambio = Sesion5.class;
				break;
			} else {
				break;
			}
		case 5:
			if (checkLast(6)) {
				cambio = Sesion6.class;
				break;
			} else {
				break;
			}
		case 6:
			if (checkLast(7)) {
				cambio = Sesion7.class;
				break;
			} else {
				break;
			}
		case 7:
			if (checkLast(8)) {
				cambio = Sesion8.class;
				break;
			} else {
				break;
			}
		}
		if (cambio != null) {
			Intent in = new Intent(this, cambio);
			startActivity(in);
		} else {
			dialogRestrict(Integer.toString(i));
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (mDrawer.isDrawerOpen(mDrawerOptions)) {
				mDrawer.closeDrawers();
			} else {
				mDrawer.openDrawer(mDrawerOptions);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void checkProgress() {
		float progress = 0;
		SharedPreferences sp = getSharedPreferences("progress", 0);
		String sesion;
		for (int i = 1; i < 9; i++) {
			sesion = "sesion" + Integer.toString(i);
			boolean value = sp.getBoolean(sesion, false);
			if (value) {
				progress++;
			}
		}
		progress = (100f / 8f) * progress;
		int prog = Math.round(progress);
		progBar.setProgress(prog);
	}

	protected void onResume() {
		super.onResume();
		checkProgress();
	}

	private boolean checkLast(int i) {
		SharedPreferences sp = getSharedPreferences("progress", 0);
		i = i - 1;
		String iS = Integer.toString(i);
		String str = "sesion" + iS;
		boolean value = sp.getBoolean(str, false);
		if (value) {
			return true;
		}
		return false;
	}

	private void dialogRestrict(String str) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(
				"Para desbloquear este nivel necesitas terminar el nivel ")
				.setTitle("Bloqueado")
				.setCancelable(false)
				.setNeutralButton("Aceptar",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();
	}
}