package com.example.pythonwithandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    EditText Et1,Et2;
    Button Btn;
    TextView Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et1 = findViewById(R.id.et1);
        Et2 = findViewById(R.id.et2);
        Btn = findViewById(R.id.btn);
        Tv = findViewById(R.id.tv);

        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        Python py = Python.getInstance();
        final PyObject pyobj = py.getModule("script");

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PyObject object = pyobj.callAttr("main",Et1.getText().toString(),Et2.getText().toString());
                Tv.setText(object.toString());
            }
        });

    }
}