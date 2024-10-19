package com.example.waterequity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button Valve1;
    Button Valve2;
    Button Valve3;
    Button Valve4;
    Button NetPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the buttons
        Valve1 = findViewById(R.id.v1);
        Valve2 = findViewById(R.id.v2);
        Valve3 = findViewById(R.id.v3);
        Valve4 = findViewById(R.id.v4);
        NetPage = findViewById(R.id.NetPage);

        // Set Listener for Network page button
        NetPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent netP = new Intent(MainActivity.this, Network.class);
                startActivity(netP);
            }
        });
        // Set the same click listener for all buttons
        View.OnClickListener valveClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valveId = -1; // Default value

                // Use if-else block instead of switch
                if (v.getId() == R.id.v1) {
                    valveId = 1; // Set valve ID for Valve 1
                } else if (v.getId() == R.id.v2) {
                    valveId = 2; // Set valve ID for Valve 2
                } else if (v.getId() == R.id.v3) {
                    valveId = 3; // Set valve ID for Valve 3
                } else if (v.getId() == R.id.v4) {
                    valveId = 4; // Set valve ID for Valve 4
                }

                // Pass the valve ID to the detail activity using an Intent
                Intent intent = new Intent(MainActivity.this, ValveDetails.class);
                intent.putExtra("VALVE_ID", valveId); // Pass the valve ID
                startActivity(intent);
            }
        };

        // Attach the listener to each button
        Valve1.setOnClickListener(valveClickListener);
        Valve2.setOnClickListener(valveClickListener);
        Valve3.setOnClickListener(valveClickListener);
        Valve4.setOnClickListener(valveClickListener);
    }
}

