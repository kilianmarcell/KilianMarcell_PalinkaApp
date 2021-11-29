package hu.petrik.palinkaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAdatFelvetelMain, btnPalinkaKeresese, btnPalinkaListazasa;
    private TextView txtVListaz;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        txtVListaz.setMovementMethod(new ScrollingMovementMethod());

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

        btnPalinkaListazasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor listaz = adatbazis.listaz();
                if (listaz.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "Nincs bejegyzés az adatbázisban!", Toast.LENGTH_SHORT).show();
                } else {
                    StringBuilder textLista = new StringBuilder();
                    while (listaz.moveToNext()) {
                        textLista.append("ID: ").append(listaz.getInt(0));
                        textLista.append(System.lineSeparator());
                        textLista.append("Főző: ").append(listaz.getString(1));
                        textLista.append(System.lineSeparator());
                        textLista.append("Gyümölcs: ").append(listaz.getString(2));
                        textLista.append(System.lineSeparator());
                        textLista.append("Alkoholtartam: ").append(listaz.getInt(3));
                        textLista.append(System.lineSeparator());
                        textLista.append(System.lineSeparator());
                    }
                    txtVListaz.setText(textLista.toString());
                }
            }
        });
    }

    public void init() {
        btnAdatFelvetelMain = findViewById(R.id.btnAdatFelvetelMain);
        btnPalinkaKeresese = findViewById(R.id.btnPalinkaKeresese);
        btnPalinkaListazasa = findViewById(R.id.btnPalinkaListazasa);
        txtVListaz = findViewById(R.id.txtVListaz);
        adatbazis = new DBHelper(this);
    }
}