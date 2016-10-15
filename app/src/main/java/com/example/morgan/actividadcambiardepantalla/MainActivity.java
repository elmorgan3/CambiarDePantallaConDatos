package com.example.morgan.actividadcambiardepantalla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Declaramos un objeto de tipo button, que el boton de la pantalla
    Button buttonCambio;

    //Declaro los objetos de tipo editText que contendran los datos del usuario
    EditText editTextNombre, editTextApellido, editTextEdad;

    //declaramos el checkbox
    CheckBox checkBoxPermiso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hacemos un casting o relacionamos los objetos que
        // hemos creado con las view de las activitys
        editTextNombre = (EditText)findViewById(R.id.editTextNombre);
        editTextApellido = (EditText)findViewById(R.id.editTextApellido);
        editTextEdad = (EditText)findViewById(R.id.editTextEdad);
        checkBoxPermiso = (CheckBox)findViewById(R.id.checkBoxPermiso);
        buttonCambio = (Button)findViewById(R.id.buttonAceptar);



        //Creamos el evento OnClickListener, para que el boton este a la escucha
        buttonCambio.setOnClickListener(new View.OnClickListener()
        {
            //Creamos la funcion onClick, que activara cuando pulsen el boton
            public void onClick(View v)
            {
                //El Bundle es como un armario con diferentes cajones en el que podemos guardar cosas
                //Declaramos un objeto de tipo Bundle y lo instanciamos
                Bundle b = new Bundle();

                //Metemos en un cajon del bundle un dato, le pones de id "Nombre"
                //decimos que sera el editTextNombre
                b.putString("Nombre", editTextNombre.getText().toString());

                //Hacemos lo mismo con los otros
                b.putString("Apellido", editTextApellido.getText().toString());
                b.putString("Edad", editTextEdad.getText().toString());

                //Aqui enviaremos el valor del checkBox
                b.putBoolean("Permiso", checkBoxPermiso.isChecked());

                //Creamos un objeto del tipo Intent, que sirve para ir de una activity a otra
                //diciendo primero donde estamos y despues de la coma, donde queremos ir
                Intent intencion = new Intent(MainActivity.this, MainActivity2.class);

                //Le añadimos al Intent que lleve con sigo el Bundle que lleva los datos que hemos guardado
                intencion.putExtras(b);

                //Activamos el Intent
                startActivity(intencion);

            }
        });
    }
}
