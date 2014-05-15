package fime.cidics.accesida;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Dificil extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(new GameViewD(this));
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		android.os.Debug.stopMethodTracing();
	}
}