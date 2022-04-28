package com.example.hdk_19dh110339;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    TextView tvLogo, tvDescripsionLogo,tvSignInWithFB,tvSignInWithGG;
    EditText edtEmail, edtPassword;
    Button btnForget, btnSignIn, btnSignUp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        tvLogo = findViewById(R.id.tvLogo);
        tvDescripsionLogo = findViewById(R.id.tvDecripsionLogo);
        tvSignInWithFB = findViewById(R.id.tvSignInWithFB);
        tvSignInWithGG = findViewById(R.id.tvSignInWithGoogle);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnForget = findViewById(R.id.btnForgetPass);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        firebaseAuth = FirebaseAuth.getInstance();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                if (email.isEmpty() && password.isEmpty()){
                    Toast.makeText(SignIn.this, "Fill out the information completely!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignIn.this, "Successfully Sign In ", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignIn.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignIn.this, "Sign In Fail ", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });




        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

}