package com.example.googlesignin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Weather extends AppCompatActivity {
    private EditText citynameEditText;
    private Button searchWeatherButton;
    private TextView weatherTextView;
    private TextView tempTextView;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        backButton = (Button) findViewById(R.id.button2);
        citynameEditText = (EditText) findViewById(R.id.myedit);
        searchWeatherButton = (Button) findViewById(R.id.searchweather);
        searchWeatherButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                WeatherRepository.getInstance().updateWeather(citynameEditText.getText().toString());
                Log.d("Button", "Success");
            }
        });

        WeatherViewModel viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);

        viewModel.getWeather().observe(this, new Observer<Weather1>() {
            @Override
            public void onChanged(Weather1 weather) {
                ((TextView) findViewById(R.id.weather)).setText(WeatherRepository.getInstance().getWeather().getValue().getMain());

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Weather.this,CourseActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        viewModel.getTemp().observe(this, new Observer<Temp>() {
            @Override
            public void onChanged(Temp temp) {
                ((TextView) findViewById(R.id.temp)).setText(""+WeatherRepository.getInstance().getTemp().getValue().getTemp());
            }
        });
        weatherTextView = (TextView) findViewById(R.id.weather);
        tempTextView = (TextView) findViewById(R.id.temp);


    }

    public void updateWeather(View view) {
        /*viewModel.updateWeather(editText.getText().toString());*/
    }
}
