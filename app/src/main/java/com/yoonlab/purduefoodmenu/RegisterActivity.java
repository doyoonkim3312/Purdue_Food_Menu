package com.yoonlab.purduefoodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.yoonlab.purduefoodmenu.credentials.Client;
import com.yoonlab.purduefoodmenu.credentials.UserDB;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText firstNameEdit = findViewById(R.id.firstNameTextField);
        EditText lastNameEdit = findViewById(R.id.lastNameTextField);
        EditText passwordEdit = findViewById(R.id.passwordTextField);

        findViewById(R.id.createButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEdit.getText().toString();
                String lastName = lastNameEdit.getText().toString();
                String password = passwordEdit.getText().toString();


                Intent returnIntent = new Intent(getApplicationContext(), LoginActivity.class);
                returnIntent.putExtra("firstName", firstName);
                returnIntent.putExtra("lastName", lastName);
                returnIntent.putExtra("pw", password);
                startActivity(returnIntent);
            }
        });
    }
}