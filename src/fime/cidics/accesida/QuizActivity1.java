package fime.cidics.accesida;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class QuizActivity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(new QuizView1(this));
	}

}
