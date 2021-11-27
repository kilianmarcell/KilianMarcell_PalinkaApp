package hu.petrik.palinkaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdatFelvetelActivity extends AppCompatActivity {

    private EditText eTFozoAdatFelvetel, eTGyumolcsAdatFelvetel, eTAlkoholTartalomAdatFelvetel;
    private Button btnFelvetelAdatFelvetel, btnVisszaAdatFelvetel;
    private String fozoAdat = eTFozoAdatFelvetel.getText().toString();
    private String gyumolcsAdat = eTFozoAdatFelvetel.getText().toString();
    private String alkoholTartalomAdat = eTFozoAdatFelvetel.getText().toString();
    private boolean kivantetoltve = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adat_felvetel);

        init();

        btnFelvetelAdatFelvetel.setOnClickListener(view -> {
            if (!(fozoAdat == "" && gyumolcsAdat == "" && alkoholTartalomAdat == "")) {
                kivantetoltve = true;
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
    }
}