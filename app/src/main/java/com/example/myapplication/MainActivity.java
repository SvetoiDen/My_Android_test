package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    BDHelper dbHelper;

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
    }

    public void get_result(View v) {
        CheckBox checkBox = (((CheckBox) v));
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        TextView text_result = findViewById(R.id.text_result);

        try {
            if (checkBox == findViewById(R.id._2_)) {
                float n1 = Float.parseFloat(num1.getText().toString());
                float n2 = Float.parseFloat(num2.getText().toString());

                int res = (int) (n1 + n2);
                text_result.setText(String.valueOf(res));
            } else if (checkBox == findViewById(R.id._1_)) {
                float n1 = Float.parseFloat(num1.getText().toString());
                float n2 = Float.parseFloat(num2.getText().toString());

                int res = (int) (n1 - n2);
                text_result.setText(String.valueOf(res));
            } else if (checkBox == findViewById(R.id._4_)) {
                float n1 = Float.parseFloat(num1.getText().toString());
                float n2 = Float.parseFloat(num2.getText().toString());

                int res = (int) (n1 * n2);
                text_result.setText(String.valueOf(res));
            } else if (checkBox == findViewById(R.id._3_)) {
                float n1 = Float.parseFloat(num1.getText().toString());
                float n2 = Float.parseFloat(num2.getText().toString());

                float res = n1 / n2;
                text_result.setText(String.format("%.3f", res));
            }
        } catch (NumberFormatException e) {
            Log.e("error", String.valueOf(e));
            Toast tost = Toast.makeText(this, "Вы не ввели данные!", Toast.LENGTH_SHORT);
            tost.show();
        }

        checkBox.toggle();
    }
}