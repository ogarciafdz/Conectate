package fime.cidics.accesida;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainGame extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_index);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	
	public void startFacil(View v) {
        Intent intent = new Intent(MainGame.this, Facil.class);
        startActivity(intent);
    }
	
	public void startInter(View v) {
        Intent intent = new Intent(MainGame.this, Inter.class);
        startActivity(intent);
    }

	public void startDificil(View v) {
        Intent intent = new Intent(MainGame.this, Dificil.class);
        startActivity(intent);
    }

}
