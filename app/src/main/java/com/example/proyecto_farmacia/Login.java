package com.example.proyecto_farmacia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button loginButton;
    private Button signUpButton;
    private ImageView logoImageView;
    private ImageButton googleSignInButton;

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
        googleSignInButton = findViewById(R.id.googleSignInButton);

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

        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar sesión con Google (aquí se omite la implementación para simplificar el ejemplo)
            }
        });
    }
}


