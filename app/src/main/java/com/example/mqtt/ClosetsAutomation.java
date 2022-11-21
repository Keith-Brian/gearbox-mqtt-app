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

public class ClosetsAutomation extends AppCompatActivity {

    SwitchMaterial closetOne, closetTwo, closetThree, closetFour, closetMaster;
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), "tcp://test.mosquitto.org:1883",clientId);

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
                    String topic = "Lock";
                    String message = "1";
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                        Toast.makeText(ClosetsAutomation.this,"Closet 1 Opened",Toast.LENGTH_SHORT).show();
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
                    String topic = "Lock";
                    String message = "2";
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                        Toast.makeText(ClosetsAutomation.this,"Closet 2 Opened",Toast.LENGTH_SHORT).show();
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
                    String topic = "Lock";
                    String message = "3";
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                        Toast.makeText(ClosetsAutomation.this,"Closet 3 Opened",Toast.LENGTH_SHORT).show();
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
                    String topic = "Lock";
                    String message = "4";
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                        Toast.makeText(ClosetsAutomation.this,"Closet 4 Opened",Toast.LENGTH_SHORT).show();
                    } catch ( MqttException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        //



    }


    private void initialize() {
        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(ClosetsAutomation.this,"Broker Connected!",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(ClosetsAutomation.this,"Broker Connection Failed!",Toast.LENGTH_LONG).show();
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
                    Toast.makeText(ClosetsAutomation.this,"Broker Disconnected!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ClosetsAutomation.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(ClosetsAutomation.this,"Failed to Disconnect!",Toast.LENGTH_LONG).show();
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
