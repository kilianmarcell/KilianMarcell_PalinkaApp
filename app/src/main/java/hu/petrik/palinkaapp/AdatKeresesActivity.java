package hu.petrik.palinkaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdatKeresesActivity extends AppCompatActivity {

    private EditText fozoKeres, gyumolcsKeres;
    private Button keresKeres, visszaKeres;
    private TextView textViewKeres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adat_kereses);

        init();


    }

    public void init() {
        fozoKeres = findViewById(R.id.fozoKeres);
        gyumolcsKeres = findViewById(R.id.gyumolcsKeres);
        keresKeres = findViewById(R.id.keresKeres);
        visszaKeres = findViewById(R.id.visszaKeres);
        textViewKeres = findViewById(R.id.textViewKeres);
    }
}