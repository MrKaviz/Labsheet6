package com.example.labsheet6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnOk;
    private EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = findViewById(R.id.okButton);
        txtName = findViewById(R.id.name);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ReadingCollectionsActivity.class);
                Toast.makeText(getApplicationContext(),"Welcome "+txtName.getText()+"\nPlease enter what you need.",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}