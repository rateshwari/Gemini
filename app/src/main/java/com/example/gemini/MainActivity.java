package com.example.gemini;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button actionButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // You can enable this if you need edge-to-edge
        setContentView(R.layout.activity_main);

        // Initialize views
        userInput = findViewById(R.id.user_input);
        actionButton = findViewById(R.id.action_button);
        resultText = findViewById(R.id.result_text);

        // It's good practice to set the initial text for the button if not set in XML
        actionButton.setText("Count Words");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set OnClickListener for the button
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = userInput.getText().toString().trim();
                int wordCount = 0;

                if (!inputText.isEmpty()) {
                    // Split the string by spaces.
                    // The regular expression "\\s+" matches one or more whitespace characters.
                    String[] words = inputText.split("\\s+");
                    wordCount = words.length;
                }

                resultText.setText("Word count: " + wordCount);
            }
        });
    }
}