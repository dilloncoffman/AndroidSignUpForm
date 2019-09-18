package edu.temple.signupform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    TextView welcomeMessage;
    Button saveBtn;
    EditText nameInput;
    EditText emailInput;
    EditText passInput;
    EditText confirmPassInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeMessage = findViewById(R.id.welcomeMessage);
        saveBtn = findViewById(R.id.saveBtn);
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passInput = findViewById(R.id.passwordInput);
        confirmPassInput = findViewById(R.id.confirmPassInput);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make sure every field has data entered
                if (nameInput.length() == 0 || emailInput.length() == 0 || passInput.length() == 0 || confirmPassInput.length() == 0) {
                    // if any field is empty display a Toast
                    Toast.makeText(FormActivity.this , "Some field(s) may be empty. Make sure to fill in all fields before clicking 'Save'.", Toast.LENGTH_SHORT).show();
                } else if (!(passInput.getText().toString().equals(confirmPassInput.getText().toString()))) {
                    // display a toast letting the user know passwords don't match
                    Toast.makeText(FormActivity.this , "Passwords do not match. Please be sure your password and password confirmation fields match.", Toast.LENGTH_SHORT).show();
                } else {
                    // all fields are complete and passwords match, display the user’s name inside a message
                    welcomeMessage.setText("Welcome, "+nameInput.getText()+", to the SignUpForm App!");
                    welcomeMessage.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
