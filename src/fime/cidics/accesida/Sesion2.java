package fime.cidics.accesida;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.ViewFlipper;

public class Sesion2 extends Sesion {
	private ViewFlipper f;
	private VideoView vv;
	private String SrcPath = "/mnt/sdcard/ciclo menstrual.mpg.mp4";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sesion2);
		f = (ViewFlipper) findViewById(R.id.viewFlipper1);
		
		vv = (VideoView) findViewById(R.id.myvideoview);
		vv.setVideoURI(Uri.parse(SrcPath));
		vv.setMediaController(new MediaController(this));
		vv.requestFocus();
	}

	public void anterior(View v) {
		ant(f);
	}

	public void siguiente(View v) {
		sig(f, "sesion2");
	}
}
