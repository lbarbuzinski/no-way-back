package com.barbuzinski;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.barbuzinski.android.DrawableGridFactory;
import com.barbuzinski.android.MetricsFactory;
import com.barbuzinski.android.PaintFactory;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(new GameView(this, new DrawableGridFactory(), new MetricsFactory(), new PaintFactory()));
    }

}