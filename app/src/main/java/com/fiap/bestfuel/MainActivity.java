package com.fiap.bestfuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView gasPercentTextView;
    private SeekBar gasSeekBar;
    private TextView etanolPercentTextView;
    private SeekBar etanolSeekBar2;
    private ImageView optImageView;
    private TextView resultTextView;
    private double gasPrice;
    private double ethanolPrice;
    private double result;

    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gasPercentTextView = findViewById(R.id.gasPercentTextView);
        gasSeekBar = findViewById(R.id.gasSeekBar);
        etanolPercentTextView = findViewById(R.id.etanolPercentTextView);
        etanolSeekBar2 = findViewById(R.id.etanolSeekBar2);
        optImageView = findViewById(R.id.optImageView);
        resultTextView = findViewById(R.id.resultTextView);

        bestFuel();
        gasSeekBar.setOnSeekBarChangeListener(observer);
        etanolSeekBar2.setOnSeekBarChangeListener(observer);
        gasPrice = 4;
        ethanolPrice = 4;

    }

    private SeekBar.OnSeekBarChangeListener observer =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    if (seekBar.getId() == R.id.gasSeekBar){
                        gasPrice = progress / 100.;
                    }
                    else{
                        ethanolPrice = progress / 100.;
                    }
                    bestFuel();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    private void bestFuel(){
        result = ethanolPrice/gasPrice;
        gasPercentTextView.setText(currencyFormat.format(gasPrice));
        etanolPercentTextView.setText(currencyFormat.format(ethanolPrice));

        if(result>=0.7){
            optImageView.setImageResource(R.drawable.gas);
            resultTextView.setText(getString(R.string.resultText , getString(R.string.gas)));
        }else{
            optImageView.setImageResource(R.drawable.ethanol);
            resultTextView.setText(getString(R.string.resultText , getString(R.string.ethanol)));

        }
    }
}
