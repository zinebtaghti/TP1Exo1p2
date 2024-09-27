package com.example.tp1exo1p2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button count,toast;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.count);
        toast = findViewById(R.id.toast);
        text = findViewById(R.id.text);
        toast.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         Toast.makeText(MainActivity.this, "Hello Toast!", Toast.LENGTH_LONG).show();
                                     }
                                 }
        );
        count.setOnClickListener(new View.OnClickListener() {
                                     private int i=0;
                                     @Override
                                     public void onClick(View view) {
                                         i++;
                                         text.setText(String.valueOf(i));

                                     }
                                 }
        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}