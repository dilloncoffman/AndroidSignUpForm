package edu.temple.signupform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    Button saveBtn;
    EditText nameInput;
    EditText emailInput;
    EditText passInput;
    EditText confirmPassInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    Toast.makeText(FormActivity.this , "Some field(s) is/are empty. Make sure to fill in all inputs.", Toast.LENGTH_SHORT).show();
                }
                // if password fields don't match
                if (!(passInput.getText().toString().equals(confirmPassInput.getText().toString()))) {
                    // display a toast letting the user know they don't match
                    Toast.makeText(FormActivity.this , "Passwords do not match. Please be sure your password and password confirmation match.", Toast.LENGTH_SHORT).show();
                }
                // if all fields are complete and passwords match, display the user’s name inside a message
            }
        });
    }
}
