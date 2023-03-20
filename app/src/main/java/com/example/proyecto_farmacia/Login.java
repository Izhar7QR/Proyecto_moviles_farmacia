package com.example.proyecto_farmacia;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


public class Login extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    Button loginButton;
    Button signUpButton;
    ImageView logoImageView;
    FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // Referencias a los elementos del layout
        logoImageView = findViewById(R.id.logoImageView);
        editTextEmail = findViewById(R.id.editTextTextPersonName);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Configuración de los botones


        loginButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                // Obtener las credenciales introduces
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                // Validar que se hayan introducido ambos campos
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Por favor, introduce tus credenciales", Toast.LENGTH_SHORT).show();
                } else {
                    // Enviar las credenciales al servidor (aquí se omite el envío para simplificar el ejemplo)
                    // Si el servidor devuelve un código de éxito, iniciar sesión
                    Toast.makeText(Login.this, "Bienvenido, " + email, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad de registro
                Intent intent = new Intent(Login.this, SingUp.class);
                startActivity(intent);
            }
        });


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }

    }


}
