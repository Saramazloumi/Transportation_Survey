package com.midterm.lasalle.midtermexam_saramazloumi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import model.Client;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    int textViewTotal[] = {R.id.textViewTB, R.id.textViewTP};
    int textViewPercentage [] = {R.id.textViewPB, R.id.textViewPP};
    TextView listOfTotal [] = new TextView[2];
    TextView listOfPercentage[] = new TextView[2];
    Button btnReturn;
    int bus, metro, privateT, taxi;
    int clientBus, clientMetro, clientPrivate, clientTaxi;
    double totalClient;
    ArrayList<Client> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initialize();
         list = (ArrayList<Client>) getIntent().getExtras().getSerializable("key");
        for(int i = 0; i < listOfTotal.length; i++){
            listOfTotal[i] = findViewById(textViewTotal[i]);
            listOfPercentage [i] = findViewById(textViewPercentage[i]);
        }
        getTotal();
        getPercentage();
    }

    private void initialize() {
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
    }

    public void getTotal(){
        for(int i = 0 ; i < list.size(); i++){
            int transportType = list.get(i).getTransportType();

            switch (transportType){

                case 1:
                  clientBus += list.get(i).getCounter();
                  bus += list.get(i).getKmNumber();
                    break;

                case 2:
                    clientMetro += list.get(i).getCounter();
                    metro += list.get(i).getKmNumber();
                    break;

                case 3:
                    clientPrivate += list.get(i).getCounter();
                    privateT += list.get(i).getKmNumber();
                    break;
                case 4:
                    clientTaxi += list.get(i).getCounter();
                    taxi += list.get(i).getKmNumber();
                    break;
            }

            int totalCBM = clientBus + clientMetro;
            int totalKmBM = bus + metro;
            int totalCPT = clientPrivate + clientTaxi;
            int totalKmPT = privateT + taxi;

            listOfTotal[0].setText(String.valueOf(totalCBM + " / " + totalKmBM));
            listOfTotal[1].setText(String.valueOf(totalCPT + " / " + totalKmPT));

        }

    }

    public void getPercentage(){

        totalClient = clientBus + clientMetro + clientPrivate + clientTaxi;
        double percentageBus = clientBus / totalClient * 100;
        double percentageMetro = clientMetro / totalClient * 100;
        double percentagePrivate = clientPrivate / totalClient * 100;
        double percentageTaxi = clientTaxi / totalClient * 100;
        listOfPercentage[0].setText(String.valueOf(Math.round(percentageBus) + "%" + " / " + Math.round(percentageMetro) + "%"));
        listOfPercentage[1].setText(String.valueOf(Math.round(percentagePrivate) + "%" + " / " + Math.round(percentageTaxi) + "%"));
    }

    @Override
    public void onClick(View v) {
        finish();

    }
}
