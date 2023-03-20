package com.example.proyecto_farmacia;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
    ProgressDialog progressDialog;




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

        progressDialog = new ProgressDialog(this);
        // Initialize Firebase Auth
        //mAuth = FirebaseAuth.getInstance();
        FirebaseAuth.getInstance().signOut();


        // Configuración de los botones
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loguearUsuario();
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

        mAuth = FirebaseAuth.getInstance();
/*
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
        }*/

    }// FIN On Create

    public void loguearUsuario() {
        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = editTextEmail.getText().toString().trim();
        final String password  = editTextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            progressDialog.setMessage("Realizando inicio de sesión con " + email + "...");
            progressDialog.show();

            //Loguear usuario
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //Comprueba que se ha logueado correctamente y si es así hace una serie de tareas
                            if(task.isSuccessful()){

                                Log.d(TAG, "signInWithEmail:success");

                                Toast.makeText(Login.this,"Bienvenido: "+ email,Toast.LENGTH_LONG).show();
                                //FirebaseUser user = mAuth.getCurrentUser();

                                // Para pasar de una actividad a otra
                                Intent intencion = new Intent(Login.this, MainActivity.class);
                                intencion.putExtra(MainActivity.stringUser, email);
                                startActivity(intencion);
                                // FIN para pasar de una actividad a otra


                            }else{

                                Toast.makeText(Login.this,"No se pudo iniciar sesión con las credenciales aportadas",Toast.LENGTH_LONG).show();
                            }
                            progressDialog.dismiss();
                        }
                    });
        }
    } // FIN Loguear Usuario

}
