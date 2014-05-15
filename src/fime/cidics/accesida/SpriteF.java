package fime.cidics.accesida;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class SpriteF {
	private static final int MAX_SPEED = 10;
	private GameViewF gameView;
	private Bitmap bmp;
	private int x = 0;
	private int y = 1;
	private int xSpeed;
	private int ySpeed;
	private int currentFrame = 0;
	private int width;
	private int height;
	private int i = 0;
	static boolean over = false;

	public SpriteF(GameViewF gameView, Bitmap bmp) {
		this.gameView = gameView;
		this.width = bmp.getWidth();
		this.height = bmp.getHeight() / 3;
		this.bmp = bmp;

		Random rnd = new Random();
		x = rnd.nextInt(gameView.getWidth() - width);
		xSpeed = rnd.nextInt(MAX_SPEED * 2) - MAX_SPEED;
		ySpeed = rnd.nextInt(MAX_SPEED * 2) - MAX_SPEED;
		if(ySpeed < 0)
			ySpeed *= -1;
	}

	private void update() {
		if (x >= gameView.getWidth() - width - xSpeed || x + xSpeed <= 0) {
			xSpeed = -xSpeed;
		}
		x = x + xSpeed;
		if (y >= gameView.getHeight() - height - ySpeed || y + ySpeed <= 0) {
			ySpeed = -ySpeed;
			over = true;
		}
		y = y + ySpeed;
		if (i == 10) {
			currentFrame = ++currentFrame % 3;
			i = 0;
		}
		i++;
	}

	public void onDraw(Canvas canvas) {
		update();
		int srcY = currentFrame * width;
		Rect src = new Rect(0, srcY, width, srcY + height);
		Rect dst = new Rect(x, y, x + width, y + height);
		canvas.drawBitmap(bmp, src, dst, null);
	}

	public boolean isCollision(float x2, float y2) {
		return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
	}
}