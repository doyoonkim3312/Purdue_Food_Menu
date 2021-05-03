package com.yoonlab.purduefoodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yoonlab.purduefoodmenu.credentials.Client;
import com.yoonlab.purduefoodmenu.credentials.User;
import com.yoonlab.purduefoodmenu.credentials.UserDB;

public class LoginActivity extends AppCompatActivity {
    // DB session
    private final UserDB userDB = new UserDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        System.out.println(userDB.getUserArrayList().size());

        EditText userFirstNameEdit = findViewById(R.id.userFirstName);
        EditText userPasswordEdit = findViewById(R.id.userPassword);

        try {
            Intent intent = getIntent();
            String newUserFirstName = intent.getExtras().getString("firstName");
            String newUserLastName = intent.getExtras().getString("lastName");
            String newUserPassword = intent.getExtras().getString("pw");
            userDB.adduNewUser(new Client(newUserFirstName, newUserLastName, newUserPassword));
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Unable to load database",
                    Toast.LENGTH_SHORT).show();
        }


        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(userDB.getUserArrayList().size());
                // This codes are simple idea of how database is work in this application.
                // When actual database is linked, this codes will be redesigned.
                if (userValidation(userFirstNameEdit.getText().toString(), userPasswordEdit
                        .getText().toString())) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Credential",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean userValidation(String firstName, String password) {
        boolean result = false;
        for (User user: userDB.getUserArrayList()) {
            if (user.getfName().equals(firstName)) {
                if (user.getPassword().equals(password)) {
                    result = true;
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        System.out.println(result);
        return result;
    }
}