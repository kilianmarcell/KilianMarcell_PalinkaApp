package hu.petrik.palinkaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAdatFelvetelMain, btnPalinkaKeresese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        btnAdatFelvetelMain = findViewById(R.id.btnAdatFelvetelMain);
        btnPalinkaKeresese = findViewById(R.id.btnPalinkaKeresese);
    }
}