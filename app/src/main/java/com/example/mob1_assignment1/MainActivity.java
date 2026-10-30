package com.example.mob1_assignment1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button countButton;
    private Button zeroButton;

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

        mShowCount = findViewById(R.id.show_count);
        countButton = findViewById(R.id.count_button);
        zeroButton = findViewById(R.id.zero_button);

        zeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
    }

    public void showToast(View view) {
        Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {
        mCount++;
        mShowCount.setText(String.valueOf(mCount));

        if (mCount % 2 == 0) {
            countButton.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
        } else {
            countButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        }

        zeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
    }

    public void showZero(View view) {
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));

        zeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
    }
}