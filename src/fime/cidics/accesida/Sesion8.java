package fime.cidics.accesida;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Sesion8 extends Sesion implements OnClickListener {
	private Button b8_2_1, b8_2_2, b8_3_1, b8_3_2, b8_3_3, b8_4_1, b8_4_2,
			b8_4_3, b8_4_4, b8_4_5;
	private Button b_ant, b_sig;
	private ViewFlipper f, vf8_3_1, vf8_4_1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sesion8);
		f = (ViewFlipper) this.findViewById(R.id.flipper);
		vf8_3_1 = (ViewFlipper) this.findViewById(R.id.viewFlipper8_3_1);
		vf8_4_1 = (ViewFlipper) this.findViewById(R.id.viewFlipper8_4_1);

		b8_2_1 = (Button) findViewById(R.id.btn_8_2_1);
		b8_2_2 = (Button) findViewById(R.id.btn_8_2_2);

		b8_3_1 = (Button) findViewById(R.id.btn_8_3_1);
		b8_3_2 = (Button) findViewById(R.id.btn_8_3_2);
		b8_3_3 = (Button) findViewById(R.id.btn_8_3_3);

		b8_4_1 = (Button) findViewById(R.id.btn_8_4_1);
		b8_4_2 = (Button) findViewById(R.id.btn_8_4_2);
		b8_4_3 = (Button) findViewById(R.id.btn_8_4_3);
		b8_4_4 = (Button) findViewById(R.id.btn_8_4_4);
		b8_4_5 = (Button) findViewById(R.id.btn_8_4_5);

		b_ant = (Button) findViewById(R.id.btn_anterior);
		b_sig = (Button) findViewById(R.id.btn_siguiente);

		b8_2_1.setOnClickListener(this);
		b8_2_2.setOnClickListener(this);

		b8_3_1.setOnClickListener(this);
		b8_3_2.setOnClickListener(this);
		b8_3_3.setOnClickListener(this);

		b8_4_1.setOnClickListener(this);
		b8_4_2.setOnClickListener(this);
		b8_4_3.setOnClickListener(this);
		b8_4_4.setOnClickListener(this);
		b8_4_5.setOnClickListener(this);
	}

	public void anterior(View v) {
		ant(f);
		setVisibleButton();
	}

	public void siguiente(View v) {
		sig(f,"sesion8");
		setVisibleButton();
	}

	public void setEA(View v) {
		f.setDisplayedChild(3);
		setVisibleButton();
	}

	private void setVisibleButton() {
		if(f.getDisplayedChild()<4){
			b_ant.setVisibility(View.VISIBLE);
			b_sig.setVisibility(View.VISIBLE);
		}
		if(f.getDisplayedChild()==3){
			b_ant.setVisibility(View.VISIBLE);
			b_sig.setVisibility(View.GONE);
		}
		if (f.getDisplayedChild() > 4) {
			b_ant.setVisibility(View.GONE);
			b_sig.setVisibility(View.GONE);
		}
		if(f.getDisplayedChild() >= 6){
			b_ant.setVisibility(View.VISIBLE);
			b_sig.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_8_2_1:
			f.setDisplayedChild(2);
			setVisibleButton();
			break;
		case R.id.btn_8_2_2:
			f.setDisplayedChild(3);
			setVisibleButton();
			break;
		case R.id.btn_8_3_1:
			vf8_3_1.setDisplayedChild(0);
			setVisibleButton();
			break;
		case R.id.btn_8_3_2:
			vf8_3_1.setDisplayedChild(1);
			setVisibleButton();
			break;
		case R.id.btn_8_3_3:
			vf8_3_1.setDisplayedChild(2);
			setVisibleButton();
			break;
		case R.id.btn_8_4_1:
			f.setDisplayedChild(4);
			setVisibleButton();
			break;
		case R.id.btn_8_4_2:
			f.setDisplayedChild(5);
			setVisibleButton();
			break;
		case R.id.btn_8_4_3:
			f.setDisplayedChild(6);
			setVisibleButton();
			break;
		case R.id.btn_8_4_4:
			vf8_4_1.setDisplayedChild(0);
			setVisibleButton();
			break;
		case R.id.btn_8_4_5:
			vf8_4_1.setDisplayedChild(1);
			setVisibleButton();
			break;
		default:
			break;
		}
	}
}