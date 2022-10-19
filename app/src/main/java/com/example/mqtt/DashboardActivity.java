package com.example.mqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class DashboardActivity extends AppCompatActivity {

    SwitchMaterial closetOne, closetTwo, closetThree, closetFour;
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);




        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), "tcp://192.168.100.190:1883",clientId);

        initialize();


        closetOne = findViewById(R.id.switchCloset1);
        closetTwo = findViewById(R.id.switchCloset2);
        closetThree = findViewById(R.id.switchCloset3);
        closetFour = findViewById(R.id.switchCloset4);

        //for Closet One

        closetOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(closetOne.isChecked()){
                    String topic = "CLOSET1";
                    String message = "OPEN";
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                        Toast.makeText(DashboardActivity.this,"Closet 1 Opened",Toast.LENGTH_SHORT).show();
                    } catch ( MqttException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        //closet Two

        closetTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(closetOne.isChecked()){
                    String topic = "CLOSET2";
                    String message = "OPEN";
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                        Toast.makeText(DashboardActivity.this,"Closet 2 Opened",Toast.LENGTH_SHORT).show();
                    } catch ( MqttException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        //closet Three

        closetThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(closetOne.isChecked()){
                    String topic = "CLOSET3";
                    String message = "OPEN";
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                        Toast.makeText(DashboardActivity.this,"Closet 3 Opened",Toast.LENGTH_SHORT).show();
                    } catch ( MqttException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        // Closet Four

        closetFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(closetOne.isChecked()){
                    String topic = "CLOSET4";
                    String message = "OPEN";
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                        Toast.makeText(DashboardActivity.this,"Closet 4 Opened",Toast.LENGTH_SHORT).show();
                    } catch ( MqttException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }


    private void initialize() {
        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(DashboardActivity.this,"connected!!",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(DashboardActivity.this,"connection failed!!",Toast.LENGTH_LONG).show();
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(View v){

        try {
            IMqttToken token = client.disconnect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(DashboardActivity.this,"Broker Disconnected!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(DashboardActivity.this,"Failed to Disconnect!",Toast.LENGTH_LONG).show();
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
