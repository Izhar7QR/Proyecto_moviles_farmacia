package com.example.proyecto_farmacia;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SingUp extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        // Obtenemos los elementos de la interfaz de usuario
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Registramos al usuario
                registrarUsuario(username, password);

                // Volvemos a la actividad anterior
                finish();
            }
        });
    }
    private void registrarUsuario(String nombreDeUsuario, String contrasenia) {
        // Aquí puedes agregar la lógica para guardar la información del usuario en tu base de datos
        // Puedes usar SQLite o cualquier otro servicio de base de datos que prefieras

        // En este ejemplo, simplemente mostramos un mensaje de éxito
        Toast.makeText(getApplicationContext(), "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
    }
}