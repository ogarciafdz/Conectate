package fime.cidics.accesida;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Sesion7 extends Sesion implements OnClickListener {

	private ViewFlipper f;
	private Button b7_3_1, b7_3_2, b7_3_3, b7_3_4, b7_3_5, b7_3_6;
	private Button b_ant, b_sig;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sesion7);
		f = (ViewFlipper) this.findViewById(R.id.flipper);
		b7_3_1 = (Button) findViewById(R.id.button7_3_1);
		b7_3_2 = (Button) findViewById(R.id.button7_3_2);
		b7_3_3 = (Button) findViewById(R.id.button7_3_3);
		b7_3_4 = (Button) findViewById(R.id.button7_3_4);
		b7_3_5 = (Button) findViewById(R.id.button7_3_5);
		b7_3_6 = (Button) findViewById(R.id.button7_3_6);

		b_sig = (Button) this.findViewById(R.id.btn_siguiente);
		b_ant = (Button) this.findViewById(R.id.btn_anterior);

		b7_3_1.setOnClickListener(this);
		b7_3_2.setOnClickListener(this);
		b7_3_3.setOnClickListener(this);
		b7_3_4.setOnClickListener(this);
		b7_3_5.setOnClickListener(this);
		b7_3_6.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sesion7, menu);
		return true;
	}

	public void anterior(View v) {
		ant(f);
		derp();
	}

	public void siguiente(View v) {
		sig(f,"sesion7");
		derp();
	}

	public void valores(View v) {
		f.setDisplayedChild(3);
		derp();
	}

	private void derp() {
		int i = f.getDisplayedChild();
		if (i > 3) {
			b_ant.setVisibility(View.GONE);
			b_sig.setVisibility(View.GONE);
		}
		if (i < 3) {
			b_ant.setVisibility(View.VISIBLE);
			b_sig.setVisibility(View.VISIBLE);
		}
		if (i == 3) {
			b_ant.setVisibility(View.VISIBLE);
			b_sig.setVisibility(View.GONE);
		}
		if (i == 9) {
			b_ant.setVisibility(View.GONE);
			b_sig.setVisibility(View.VISIBLE);
		}
		if (i > 9) {
			b_ant.setVisibility(View.VISIBLE);
			b_sig.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button7_3_1:
			f.setDisplayedChild(4);
			derp();
			break;
		case R.id.button7_3_2:
			f.setDisplayedChild(5);
			derp();
			break;
		case R.id.button7_3_3:
			f.setDisplayedChild(6);
			derp();
			break;
		case R.id.button7_3_4:
			f.setDisplayedChild(7);
			derp();
			break;
		case R.id.button7_3_5:
			f.setDisplayedChild(8);
			derp();
			break;
		case R.id.button7_3_6:
			f.setDisplayedChild(9);
			derp();
			break;
		default:
			break;
		}
	}
}