package com.example.task1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    public void LoginFragmentOne(View view) {
        EditText email = findViewById(R.id.editTextEmail);
        String emailText = email.getText().toString();
        EditText password = findViewById(R.id.editTextPass);
        String passText = password.getText().toString();

        Toast.makeText(MainActivity.this, "the email is" + emailText, Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this, "the password is" + passText, Toast.LENGTH_LONG).show();

        mAuth.signInWithEmailAndPassword(emailText, passText)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Yes to sing in", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Yes to sing in!!!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void RegFunc(View view) {
        EditText pass = findViewById(R.id.editTextNewPass);
        String emailText = pass.getText().toString();
        EditText email = findViewById(R.id.editTextnewEmail);
        String passText = email.getText().toString();

        Toast.makeText(MainActivity.this, "new the password is" + emailText, Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this, "new the email is" + passText, Toast.LENGTH_LONG).show();

        mAuth.createUserWithEmailAndPassword(emailText, passText)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Yes to reg", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Yes to reg!!!!", Toast.LENGTH_LONG).show();
                        }
                        // ...
                    }
                });
    }
}


//    public void loginFunc(View view) {
//        Toast.makeText(this, "dfdafdasf", Toast.LENGTH_LONG).show();
//
//    }
//
//    public void RegFunc(View view){
//
//    }
