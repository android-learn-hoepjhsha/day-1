package com.example.a250709_sample1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        ImageView imageView = findViewById(R.id.flag_image_view);
        TextView textView = findViewById(R.id.greeting_view);
        Button btnVN = findViewById(R.id.vietnam_button);
        Button btnRU = findViewById(R.id.russia_button);

        btnVN.setOnClickListener(v -> {
            imageView.setImageResource(R.drawable.vietnam_flag);
            textView.setText(R.string.vietnamese_greeting);
        });

        btnRU.setOnClickListener(v -> {
            imageView.setImageResource(R.drawable.russia_flag);
            textView.setText(R.string.russian_greeting);
        });
    }
}