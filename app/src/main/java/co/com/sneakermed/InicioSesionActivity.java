package co.com.sneakermed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InicioSesionActivity extends AppCompatActivity {

    EditText textNombre;
    EditText textContrasena;
    Button btnIniciaSesion;
    Button btnCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        textNombre = findViewById(R.id.nombre);
        textContrasena = findViewById(R.id.contrasena);
        btnIniciaSesion = findViewById(R.id.iniciaSesion);
        btnCrearCuenta = findViewById(R.id.crearCuenta);

        btnIniciaSesion.setOnClickListener(view -> iniciosesion());

        btnCrearCuenta.setOnClickListener(view -> registro());

    }
    public void iniciosesion(){
        if (validarCampos()) return;
        //TODO:validar contraseña y usuario
        //TODO: crear un Home activity y redireccionar a el
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private boolean validarCampos() {
        if(textNombre.getText().toString().trim().isEmpty()){
            mostrarMesaje("Usuario requerido");
            textNombre.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            return true;
        }
        if(textContrasena.getText().toString().trim().isEmpty()){
            mostrarMesaje("Contraseña requerida");
            textContrasena.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            return true;
        }
        return false;
    }

    private  void mostrarMesaje(String mensaje) {
        Toast toast = Toast.makeText(this,mensaje,Toast.LENGTH_LONG);
        toast.show();
    }


    public void registro(){
        Intent intent = new Intent(this, registro.class);
        startActivity(intent);
    }
}