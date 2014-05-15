package fime.cidics.accesida;

import android.graphics.Canvas;

public class QuizLoopThread1 extends Thread {
	static final long FPS = 30;
	private QuizView1 view;
	public static boolean running = false;

	public QuizLoopThread1(QuizView1 view) {
		this.view = view;
	}

	public void setRunning(boolean run) {
		running = run;
	}

	@Override
	public void run() {
		long ticksPS = 1000 / FPS;
		long startTime;
		long sleepTime;

		try {
			while (running) {
				Canvas c = null;
				startTime = System.currentTimeMillis();

				try {
					c = view.getHolder().lockCanvas();

					synchronized (view.getHolder()) {
						view.onDraw(c);
					}
				} finally {
					if (c != null) {
						view.getHolder().unlockCanvasAndPost(c);
					}
				}
				sleepTime = ticksPS - (System.currentTimeMillis() - startTime);

				try {
					if (sleepTime > 0)
						sleep(sleepTime);
					
					else
						sleep(10);
				} catch (Exception e) {
				}
			}
		} finally {
		}
	}
}