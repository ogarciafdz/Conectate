package fime.cidics.accesida;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Sesion3 extends Sesion {

	private ViewFlipper f;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sesion3);
		f = (ViewFlipper) this.findViewById(R.id.flipper);
	}
	
	public void anterior(View v) {
		ant(f);
	}

	public void siguiente(View v) {
		sig(f,"sesion3");
	}
}
