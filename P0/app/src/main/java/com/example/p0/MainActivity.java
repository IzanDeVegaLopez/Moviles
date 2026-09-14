package com.example.p0;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SurfaceView surface = findViewById(R.id.ma_surface_view);
        surface.setZOrderOnTop(true);
    }
    /** Called when the users taps the send button */
    public void sendMessage(View view){
        //Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    SurfaceHolder sh = null;
    private Canvas get_canvas(){
        if (sh == null) {
            SurfaceView sv = findViewById(R.id.ma_surface_view);
            Log.d("DRAW", "SurfaceView: " + sv);

            sh = sv.getHolder();
        }

        Log.d("DRAW", "Surface valid: " +
                sh.getSurface().isValid());

        Canvas canvas = sh.lockCanvas();

        Log.d("DRAW", "Canvas: " + canvas);

        if (canvas != null) {
            Log.d("DRAW", "Size: " +
                    canvas.getWidth() + "x" + canvas.getHeight());
        }

        return canvas;
    }
    public void clearCanvas(View view){
        Log.d("CLEAR", "clearCanvas called");
        var can = get_canvas();
        if (can == null) {
            Log.d("DRAW", "Canvas is NULL!");
            return;
        }
        can.drawColor(Color.WHITE);
        sh.unlockCanvasAndPost(can);
    }
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public void paintCanvas(View view){
        Log.d("DRAW", "paintCanvas CALLED");
        var can = get_canvas();
        if (can == null) {
            Log.d("DRAW", "Canvas is NULL!");
            return;
        }
        can.drawColor(Color.WHITE);
        paint.setColor(Color.BLACK);
        //can.drawRect(0, 0, 500, 500, paint);
        can.drawCircle(100,100,50, paint);
        sh.unlockCanvasAndPost(can);
    }
}