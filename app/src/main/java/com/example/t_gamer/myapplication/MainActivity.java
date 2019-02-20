package com.example.t_gamer.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public SeekBar seekBar;
    public TextView txtPercent;
    public TextView txtGorjeta;
    public TextView txtTotal;
    public EditText fieldTotal;
    public int progresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progresso = 0;
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        fieldTotal = (EditText)findViewById(R.id.fieldTotal);
        txtPercent = findViewById(R.id.txtView);
        txtGorjeta = findViewById(R.id.txtGorjeta);
        txtTotal = findViewById(R.id.txtTotal);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtPercent.setText(String.valueOf(progress) + "%");
                progresso = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                double pagamento = Double.parseDouble(fieldTotal.getText().toString());

                // Gorjeta
                double gorjeta = (pagamento * progresso) / 100;
                txtGorjeta.setText("$" + gorjeta);

                // Total pagamento
                double total = pagamento + gorjeta;
                txtTotal.setText("$" + total);
            }
        });

    }
}
















