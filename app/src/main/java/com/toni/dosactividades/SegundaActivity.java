package com.toni.dosactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.toni.dosactividades.extra.REPLY";

    TextView txtMensajeReci;
    EditText editTextResponder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtMensajeReci = findViewById(R.id.txtMensajeReci);
        editTextResponder = findViewById(R.id.editTextResponder);

        Intent intent = getIntent();

        String mensaje = intent.getStringExtra("Mensaje");

        txtMensajeReci.setText(mensaje);
    }

    public void enviarRespuesta(View view) {
        String respuesta = editTextResponder.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_REPLY, respuesta);
        setResult(RESULT_OK, intent);
        finish();
    }
}