package fime.cidics.accesida;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ViewFlipper;

public class Sesion extends Activity {
	private double lastTime = 0;

	public void ant(ViewFlipper vf) {
		if (lastTime + 500 < System.currentTimeMillis()) {
			int displayedChild = vf.getDisplayedChild();
			if (displayedChild != 0) {
				vf.setInAnimation(inFromLeftAnimation());
				vf.setOutAnimation(outToRightAnimation());
				vf.showPrevious();
				lastTime = System.currentTimeMillis();
			}
		}
	}

	public void sig(ViewFlipper vf, String sesion) {
		if (lastTime + 500 < System.currentTimeMillis()) {
			int displayedChild = vf.getDisplayedChild();
			int childCount = vf.getChildCount();
			if (displayedChild != childCount - 1) {
				vf.setInAnimation(inFromRightAnimation());
				vf.setOutAnimation(outToLeftAnimation());
				vf.showNext();
				lastTime = System.currentTimeMillis();
			}
		}
		int actual = vf.getDisplayedChild();
		int total = vf.getChildCount() - 1;
		if (actual >= total) {
			saveProgress(sesion, true);
			dialogFin();
		}
		Log.d("MSG", "" + actual + "" + total);
	}

	protected Animation inFromRightAnimation() {
		Animation inFromRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromRight.setDuration(500);
		inFromRight.setInterpolator(new AccelerateInterpolator());
		return inFromRight;
	}

	protected Animation outToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(500);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;
	}

	protected Animation inFromLeftAnimation() {
		Animation inFromLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromLeft.setDuration(500);
		inFromLeft.setInterpolator(new AccelerateInterpolator());
		return inFromLeft;
	}

	protected Animation outToRightAnimation() {
		Animation outtoRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoRight.setDuration(500);
		outtoRight.setInterpolator(new AccelerateInterpolator());
		return outtoRight;
	}

	protected void saveProgress(String sesion, boolean save) {
		SharedPreferences sharedPreferences = getApplicationContext()
				.getSharedPreferences("progress", 0);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putBoolean(sesion, save);
		editor.commit();
	}

	protected void dialogFin() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(
				"¿Deseas realizar el quiz de la unidad o volver al menu principal?")
				.setTitle("Fin")
				.setNegativeButton("Menu principal",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								finish();
							}
						})
				.setPositiveButton("Quiz",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Intent intent = new Intent(Sesion.this,
										QuizActivity1.class);
								startActivity(intent);
								finish();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();
	}
}
