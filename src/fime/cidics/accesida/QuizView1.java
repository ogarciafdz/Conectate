package fime.cidics.accesida;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class QuizView1 extends SurfaceView {
	private Bitmap background, pointer, button, pantalla, right, wrong;
	private String[][] preg = new String[][] {
			{ "¿Cuáles de las siguientes son las ITS más comunes?", "Gonorrea",
					"Candidiasis", "VIH/Sida", "Todas las anteriores", "4" },
			{ "¿Cómo se transmiten las ITS?", "Por mosquitos",
					"Por usar la misma ropa", "Por usar baños públicos",
					"Por contacto sexual entre las personas", "4" },
			{ "Qué significa Sida?", "Infección de la bolsa escrotal",
					"Síndrome de Inmuno Deficiencia Adquirida",
					"Enfermedad de la menopausia",
					"Virus de Inmunodeficiencia Humano", "2" },
			{
					"¿Por cuales de los siguientes líquidos corporales se transmite el VIH?",
					"Sangre", "Semen y fluidos vaginales", "Leche materna",
					"Todas las anteriores", "4" },
			{ "¿El virus  de  VIH es el  culpable de qué  infección?", "Sida",
					"Gonorrea", "Candidiasis", "Alitosis", "1" },
			{ "¿Cómo prevenir la infección por el VIH?",
					"No tocando a personas que viven con VIH",
					"Teniendo relaciones sexuales con condón",
					"Teniendo abstinencia sexual", "Sólo B y C", "4" },
			{
					"Es necesario revisar la fecha de caducidad del paquete del condón y sólo usar aquellos que están dentro de la fecha de uso recomendada",
					"Cierto", "Falso", " ", " ", "1" },
			{
					"Para abrir el paquete del condón puedes usar los dientes, tijeras o algo con filo",
					"Cierto", "Falso", " ", " ", "2" },
			{
					"Hay que dejar un poco de aire en la punta del condón para que sea más cómodo",
					"Cierto", "Falso", " ", " ", "1" },
			{
					"Para poner el condón hay que colocarlo en la punta del pene y deslizarlo hasta la base del pene",
					"Cierto", "Falso", " ", " ", "1" },
			{ "Acabado de eyacular no es necesario retirar el condón",
					"Cierto", "Falso", " ", " ", "2" },
			{
					"Da lo mismo envolver o no en papel higiénico  el condón después de usarlo y antes de desecharlo",
					"Cierto", "Falso", " ", " ", "2" } };
	private String verdad;
	private boolean cierto, resp;
	Paint text = new Paint();
	private SurfaceHolder holder;
	private QuizLoopThread1 quizLoopThread;
	int x = 0, espera = 0, i = 0;
	int xSpeed = 10, yBack = 0;

	public QuizView1(Context context) {
		super(context);
		quizLoopThread = new QuizLoopThread1(this);
		holder = getHolder();

		holder.addCallback(new SurfaceHolder.Callback() {
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				boolean retry = true;
				quizLoopThread.setRunning(false);

				while (retry) {
					try {
						quizLoopThread.join();
						retry = false;
					} catch (InterruptedException e) {
					}
				}
			}

			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				quizLoopThread.setRunning(true);
				quizLoopThread.start();
			}

			@Override
			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
			}
		});
		background = BitmapFactory.decodeResource(getResources(),
				R.drawable.backgroundq);
		pointer = BitmapFactory.decodeResource(getResources(),
				R.drawable.pointer);
		button = BitmapFactory
				.decodeResource(getResources(), R.drawable.button);
		pantalla = BitmapFactory.decodeResource(getResources(),
				R.drawable.pantalla);
		right = BitmapFactory.decodeResource(getResources(), R.drawable.right);
		wrong = BitmapFactory.decodeResource(getResources(), R.drawable.wrong);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		try {
			String tmp = preg[i + 1][0];

			canvas.drawBitmap(background, 0, yBack, null);

			if (yBack > -100) {
				yBack -= 5;
				System.out.println(yBack);
			} else if (resp == false) {
				text.setTextSize(30);
				text.setColor(Color.YELLOW);
				canvas.drawBitmap(pantalla, 100, 50, null);
				canvas.drawText(preg[i][0], 150, 150, text);
				text.setTextSize(25);
				text.setColor(Color.WHITE);
				canvas.drawBitmap(button, 0, 300, null);
				canvas.drawText("A", 40, 360, text);
				canvas.drawText(preg[i][1], 150, 360, text);
				canvas.drawBitmap(button, 0, 410, null);
				canvas.drawText("B", 40, 470, text);
				canvas.drawText(preg[i][2], 150, 470, text);
				canvas.drawBitmap(button, 530, 300, null);
				canvas.drawText("C", 570, 360, text);
				canvas.drawText(preg[i][3], 680, 360, text);
				canvas.drawBitmap(button, 530, 410, null);
				canvas.drawText("D", 570, 470, text);
				canvas.drawText(preg[i][4], 680, 470, text);
				verdad = preg[i][5];
			}

			if (x >= getWidth() - pointer.getWidth()) {
				xSpeed = -10;
			}

			if (x == 0) {
				xSpeed = 10;
			}
			x = x + xSpeed;
			canvas.drawBitmap(pointer, x, 515, null);

			if (resp == true) {
				if (espera <= 45) {
					if (cierto == true) {
						canvas.drawBitmap(right, 377, 150, null);
					} else {
						canvas.drawBitmap(wrong, 377, 150, null);
					}
					espera++;
				} else {
					espera = 0;
					resp = false;
					cierto = false;
					i++;
				}
			}
		} catch (Exception e) {
			QuizLoopThread1.running = false;
			Context con = getContext();
			Intent intent = new Intent(con, MainActivity.class);
			con.startActivity(intent);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		synchronized (getHolder()) {
			if (event.getX() < 500 && event.getY() > 300 && event.getY() < 400) {
				if (verdad == "1")
					cierto = true;
				resp = true;
			}
			if (event.getX() < 500 && event.getY() > 410 && event.getY() < 510) {
				if (verdad == "2")
					cierto = true;
				resp = true;
			}
			if (event.getX() > 500 && event.getY() > 300 && event.getY() < 400) {
				if (verdad == "3")
					cierto = true;
				resp = true;
			}
			if (event.getX() > 500 && event.getY() > 410 && event.getY() < 510) {
				if (verdad == "4")
					cierto = true;
				resp = true;
			}
		}
		return true;
	}
}