package fime.cidics.accesida;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class Sesion6 extends Sesion {
	private ViewFlipper f;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sesion6);
		f = (ViewFlipper) findViewById(R.id.viewFlipper1);
	}

	public void anterior(View v) {
		ant(f);
	}

	public void siguiente(View v) {
		sig(f,"sesion6");
	}
}
