package com.midterm.lasalle.midtermexam_saramazloumi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import model.Client;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextClientNumber, editTextNbKm, editTextAdminPass;
    RadioGroup rbGroup;
    Button btnSave, btnNew, btnEnd, btnLoad, btnGo;
    ArrayList<Client> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initialize();
    }

    private void initialize() {
        editTextClientNumber = findViewById(R.id.editTextClientNumber);
        editTextNbKm = findViewById(R.id.editTextNbKm);
        editTextAdminPass = findViewById(R.id.editTextAdminPass);
        rbGroup = findViewById(R.id.rbGroup);
        btnSave = findViewById(R.id.btnSave);
        btnNew = findViewById(R.id.btnNew);
        btnEnd = findViewById(R.id.btnEnd);
        btnGo = findViewById(R.id.btnGo);
        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnNew.setOnClickListener(this);
        btnEnd.setOnClickListener(this);
        btnGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnSave:

                int ClientN = Integer.valueOf(editTextClientNumber.getText().toString());
                int TransportType = 0;
                int NmKm = Integer.valueOf(editTextNbKm.getText().toString());
                int rbId = rbGroup.getCheckedRadioButtonId();
                int counter = 0;

                switch (rbId){
                    case R.id.rbBus:
                        TransportType = 1;
                        counter ++;
                        break;

                    case R.id.rbMetro:
                        TransportType = 2;
                        counter ++;
                        break;

                    case R.id.rbPrivateTransport:
                        TransportType = 3;
                        counter ++;
                        break;

                    case R.id.rbTaxi:
                        TransportType = 4;
                        counter ++;
                        break;
                }

                list.add(new Client(ClientN, NmKm, TransportType, counter));
                Toast.makeText(this, "Data saved successfully", Toast.LENGTH_LONG).show();
                clearText();
                break;

            case R.id.btnNew:
                clearText();
                break;

            case R.id.btnLoad:
                int cNumber=0, transType=0, NKm=0, count = 0;
                ArrayList<Client> listOfClient = new ArrayList<>();
                for (int i = 0; i < list.size(); i ++){
                    cNumber = list.get(i).getClientNumber();
                    transType = list.get(i).getTransportType();
                    NKm = list.get(i).getKmNumber();
                    count = list.get(i).getCounter();
                }
                listOfClient.add(new Client(cNumber,NKm,transType, count));
                Toast.makeText(this,"Data Loaded successfully", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnEnd:
                finish();
                break;

            case R.id.btnGo:
                String pass = editTextAdminPass.getText().toString().toLowerCase();
                if((!editTextAdminPass.getText().toString().toLowerCase().equals("")) &&  pass.equals("trans")){
                    Intent intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("key", list);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Password Not Valid", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public void clearText(){
        editTextClientNumber.setText(null);
        rbGroup.clearCheck();
        editTextNbKm.setText(null);
        editTextAdminPass.setText(null);
        editTextClientNumber.requestFocus();
    }

}
