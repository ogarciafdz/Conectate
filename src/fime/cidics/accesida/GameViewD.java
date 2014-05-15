package fime.cidics.accesida;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameViewD extends SurfaceView {
	private GameLoopThreadD gameLoopThreadD;
	private List<SpriteD> sprites = new ArrayList<SpriteD>();
	private List<TempSpriteD> temps = new ArrayList<TempSpriteD>();
	private long lastClick;
	private Bitmap background, bmpBlood;
	private int i = 0;

	public GameViewD(Context context) {
		super(context);
		gameLoopThreadD = new GameLoopThreadD(this);

		getHolder().addCallback(new SurfaceHolder.Callback() {
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				boolean retry = true;
				gameLoopThreadD.setRunning(false);
				while (retry) {
					try {
						gameLoopThreadD.join();
						retry = false;
					} catch (InterruptedException e) {
					}
				}
			}

			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				createSprites();
				gameLoopThreadD.setRunning(true);
				gameLoopThreadD.start();
			}

			@Override
			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
			}
		});

		background = BitmapFactory.decodeResource(getResources(),
				R.drawable.background);
		bmpBlood = BitmapFactory.decodeResource(getResources(),
				R.drawable.blood1);
	}

	private void createSprites() {
		sprites.add(createSprite(R.drawable.virus4));
		sprites.add(createSprite(R.drawable.virus3));
		sprites.add(createSprite(R.drawable.virus2));
		sprites.add(createSprite(R.drawable.virus1));
		sprites.add(createSprite(R.drawable.virus4));
		sprites.add(createSprite(R.drawable.virus3));
		sprites.add(createSprite(R.drawable.virus2));
		sprites.add(createSprite(R.drawable.virus1));
		sprites.add(createSprite(R.drawable.virus4));
		sprites.add(createSprite(R.drawable.virus3));
		sprites.add(createSprite(R.drawable.virus2));
		sprites.add(createSprite(R.drawable.virus1));
	}

	private SpriteD createSprite(int resouce) {
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), resouce);
		return new SpriteD(this, bmp);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		try {
			sprites.get(0);
			canvas.drawBitmap(background, 0, 0, null);
			Bitmap wrong = BitmapFactory.decodeResource(getResources(),
					R.drawable.wrong);
			if (SpriteD.over) {
				canvas.drawBitmap(wrong, 165, 362, null);
				for (SpriteD j : sprites) {
					sprites.remove(j);
				}
				SpriteD.over = false;
			} else {
				for (int i = temps.size() - 1; i >= 0; i--) {
					temps.get(i).onDraw(canvas);
				}
				for (SpriteD sprite : sprites) {
					sprite.onDraw(canvas);
				}
			}
		} catch (Exception e) {
			if (i > 120) {
				GameLoopThreadD.running = false;
//				Context con = getContext();
//				Intent intent = new Intent(con, MainActivity.class);
//				con.startActivity(intent);
			}
			i++;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (System.currentTimeMillis() - lastClick > 100) {
			lastClick = System.currentTimeMillis();
			float x = event.getX();
			float y = event.getY();
			synchronized (getHolder()) {
				for (int i = sprites.size() - 1; i >= 0; i--) {
					SpriteD sprite = sprites.get(i);
					if (sprite.isCollision(x, y)) {
						sprites.remove(sprite);
						temps.add(new TempSpriteD(temps, this, x, y, bmpBlood));
						break;
					}
				}
			}
		}
		return true;
	}
}