package hu.petrik.palinkaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnAdatFelvetelMain, btnPalinkaKeresese, btnPalinkaListazasa;
    private TextView txtVListaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnAdatFelvetelMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdatFelvetelActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnPalinkaKeresese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdatKeresesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init() {
        btnAdatFelvetelMain = findViewById(R.id.btnAdatFelvetelMain);
        btnPalinkaKeresese = findViewById(R.id.btnPalinkaKeresese);
        btnPalinkaListazasa = findViewById(R.id.btnPalinkaListazasa);
        txtVListaz = findViewById(R.id.txtVListaz);
    }
}