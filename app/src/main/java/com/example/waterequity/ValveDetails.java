package com.example.waterequity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;

public class ValveDetails extends AppCompatActivity {

    TextView heading2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_valve_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        heading2 = findViewById(R.id.heading2);

        int valveId = getIntent().getIntExtra("VALVE_ID", -1);

        if (valveId == -1) {
            // Load data dynamically for the specific valve
            heading2.setText("No Valve");
        }
        else
        {
            heading2.setText("Valve " + valveId);
        }
    }
}