package hu.petrik.palinkaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdatFelvetelActivity extends AppCompatActivity {

    private EditText eTFozoAdatFelvetel, eTGyumolcsAdatFelvetel, eTAlkoholTartalomAdatFelvetel;
    private Button btnFelvetelAdatFelvetel, btnVisszaAdatFelvetel;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adat_felvetel);

        init();

        btnFelvetelAdatFelvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fozo = eTFozoAdatFelvetel.getText().toString().trim();
                String gyumolcs = eTGyumolcsAdatFelvetel.getText().toString().trim();
                String alkohol = eTAlkoholTartalomAdatFelvetel.getText().toString().trim();

                if (fozo.isEmpty() || gyumolcs.isEmpty() || alkohol.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
                } else {
                    if (adatbazis.adatFelvetel(fozo, gyumolcs, Integer.parseInt(alkohol))) {
                        Toast.makeText(getApplicationContext(), "Sikeres rögzítés!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Sikertelen rögzítés!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnVisszaAdatFelvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdatFelvetelActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init() {
        eTFozoAdatFelvetel = findViewById(R.id.eTFozoAdatFelvetel);
        eTGyumolcsAdatFelvetel = findViewById(R.id.eTGyumolcsAdatFelvetel);
        eTAlkoholTartalomAdatFelvetel = findViewById(R.id.eTAlkoholTartalomAdatFelvetel);
        btnFelvetelAdatFelvetel = findViewById(R.id.btnFelvetelAdatFelvetel);
        btnVisszaAdatFelvetel = findViewById(R.id.btnVisszaAdatFelvetel);
        adatbazis = new DBHelper(this);
    }
}