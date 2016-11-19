package com.example.morgan.actividadcambiardepantalla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Creamos los objetos que iran relacionados con los view de la activity
        TextView textViewNombre = (TextView)findViewById(R.id.textViewNombre);
        TextView textViewApellido = (TextView)findViewById(R.id.textViewApellido);
        TextView textViewEdad = (TextView)findViewById(R.id.textViewEdad);
        TextView textViewPermiso = (TextView)findViewById(R.id.textViewPermiso);

        //Creamos un bundle y preguntamos si el intent de la llamada lleva algo
        //en el intent
        Bundle b = getIntent().getExtras();

        //Decimos que en la variable de textViewNombre ponga el texto que hay
        // en el cajon llamado "Nombre"
        textViewNombre.setText("Nombre: " + b.getString("Nombre"));

        //Hacemos lo mismo con los otros
        textViewApellido.setText("Apellido: " + b.getString("Apellido"));
        textViewEdad.setText("Edad: " + b.getString("Edad"));

        //Hacemos un if para saber si el valor que trae Permiso es true o false
        // y dependiendo de ellos ponemos un texto u otro
        if (b.getBoolean("Permiso")== true)
        {
            textViewPermiso.setText("Da permiso");
        }
        else if(b.getBoolean("Permiso")== false)
        {
            textViewPermiso.setText("No da permiso");
        }
    }
}
