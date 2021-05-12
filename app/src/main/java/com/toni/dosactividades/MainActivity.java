package com.toni.dosactividades;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "MainActivity";
    public static final int TEXTO_RESPUESTA = 1;

    EditText editTextMensaje;
    TextView txtTextoRespuesta;
    TextView txtRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMensaje = findViewById(R.id.editTextMensaje);
        txtTextoRespuesta = findViewById(R.id.txtTextoRespuesta);
        txtRespuesta = findViewById(R.id.txtRespuesta);


    }

    public void abrirSegundaActividad(View view){
        Log.d(LOG_TAG, "Button clicked!");
        //Log.d("MainActivity", "Button clicked!");
        String mensaje = editTextMensaje.getText().toString();

        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("Mensaje", mensaje);
        startActivityForResult(intent, TEXTO_RESPUESTA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXTO_RESPUESTA){
            if(resultCode == RESULT_OK){
                String respuesta = data.getStringExtra(SegundaActivity.EXTRA_REPLY);
                txtTextoRespuesta.setVisibility(View.VISIBLE);
                txtRespuesta.setVisibility(View.VISIBLE);
                txtTextoRespuesta.setText(respuesta);
                editTextMensaje.setText("");
            }
        }
    }
}