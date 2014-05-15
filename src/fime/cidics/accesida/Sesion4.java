package fime.cidics.accesida;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;


public class Sesion4 extends Sesion implements OnClickListener{

	Button empatia;
	Button afectividad;
	Button autoestima;
	Button autorre;
	ViewFlipper VF;

	private ViewFlipper f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sesion4);
		f = (ViewFlipper) findViewById(R.id.viewFlipper1);
		
		empatia = (Button) findViewById(R.id.button2);
		afectividad = (Button) findViewById(R.id.button3);
		autoestima = (Button) findViewById(R.id.button1);
		autorre = (Button) findViewById(R.id.button4);
		
		VF = (ViewFlipper) findViewById(R.id.viewFlipper2);

		empatia.setOnClickListener(this);
		afectividad.setOnClickListener(this);
		autoestima.setOnClickListener(this);
		autorre.setOnClickListener(this);

	}

	public void anterior(View v) {
		ant(f);
	}

	public void siguiente(View v) {
		sig(f,"sesion4");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button2:
			VF.setDisplayedChild(1);
			break;
		case R.id.button3:
			VF.setDisplayedChild(2);
			break;
		case R.id.button1:
			VF.setDisplayedChild(3);
			break;
		case R.id.button4:
			VF.setDisplayedChild(4);
			break;

		default:
			break;
		}		
	}

}