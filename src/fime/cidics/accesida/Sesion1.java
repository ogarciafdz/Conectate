package fime.cidics.accesida;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Sesion1 extends Sesion {

	private ViewFlipper f;
	private Button bVirus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sesion1);
		f = (ViewFlipper) this.findViewById(R.id.flipper);
		bVirus = (Button) this.findViewById(R.id.btn_1_10_1);
	}
	
	public void launchVirus(View v){
		Intent in = new Intent(this, MainGame.class);
		startActivity(in);
		finish();
	}

	public void anterior(View v) {
		ant(f);
	}

	public void siguiente(View v) {
		sig(f, "sesion1");
	}
}