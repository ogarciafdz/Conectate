package fime.cidics.accesida;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Sesion5 extends Sesion implements OnClickListener{

	private ViewFlipper f;
	private ViewFlipper vf;
	private Button b1;
	private Button b2;
	private Button b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sesion5);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sesion5, menu);
		f = (ViewFlipper) this.findViewById(R.id.flipper);
		vf = (ViewFlipper) this.findViewById(R.id.viewFlipper2);
		b1 = (Button) this.findViewById(R.id.button5_3_1);
		b2 = (Button) this.findViewById(R.id.button5_3_2);
		b3 = (Button) this.findViewById(R.id.button5_3_3);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		return true;
	}

	public void anterior(View v) {
		ant(f);
	}

	public void siguiente(View v) {
		sig(f,"sesion5");
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button5_3_1:
			vf.setDisplayedChild(3);
			break;
		case R.id.button5_3_2:
			vf.setDisplayedChild(1);
			break;
		case R.id.button5_3_3:
			vf.setDisplayedChild(2);
			break;
		default:
			break;
		}
	}

}
