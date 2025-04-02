package com.example.scrollview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(this);
        textView.setText("bubel 3TD");
        textView.setTextSize(20);
        linearLayout.addView(textView);

        for (int i = 1; i <= 20; i++) {
            Button button = new Button(this);
            button.setText("Przycisk " + i);
            linearLayout.addView(button);
        }

        scrollView.addView(linearLayout);

        setContentView(scrollView);
    }
}