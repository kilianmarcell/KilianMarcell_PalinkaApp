package hu.petrik.palinkaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdatKeresesActivity extends AppCompatActivity {

    private EditText fozoKeres, gyumolcsKeres;
    private Button keresKeres, visszaKeres;
    private TextView textViewKeres;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adat_kereses);

        init();

        keresKeres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fozoSzoveg = fozoKeres.getText().toString().trim();
                String gyumolcsSzoveg = gyumolcsKeres.getText().toString().trim();

                if (fozoSzoveg.isEmpty() || gyumolcsSzoveg.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor keres = adatbazis.keres(fozoSzoveg, gyumolcsSzoveg);
                    if (keres.getCount() == 0) {
                        Toast.makeText(getApplicationContext(), "Nincs ilyen pálinka!", Toast.LENGTH_SHORT).show();
                    } else {
                        StringBuilder textLista = new StringBuilder();
                        while (keres.moveToNext()) {
                            textLista.append("Alkohol: ").append(keres.getInt(3) + "%");
                        }
                        textViewKeres.setText(textLista.toString());
                    }
                }
            }
        });

        visszaKeres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdatKeresesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init() {
        fozoKeres = findViewById(R.id.fozoKeres);
        gyumolcsKeres = findViewById(R.id.gyumolcsKeres);
        keresKeres = findViewById(R.id.keresKeres);
        visszaKeres = findViewById(R.id.visszaKeres);
        textViewKeres = findViewById(R.id.textViewKeres);
        adatbazis = new DBHelper(this);
    }
}