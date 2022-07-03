package com.example.divicalendarfeasibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Calendar;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.testView);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    Stock stock = YahooFinance.get("NVDA");


                    BigDecimal price = stock.getQuote().getPrice();
                    BigDecimal diviYield = stock.getDividend().getAnnualYield();
                    txtView.setText(diviYield.toString());


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}