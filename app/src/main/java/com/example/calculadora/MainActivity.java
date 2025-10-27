package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaración de variables
    EditText txtNumero;
    Spinner spnOpciones;
    Button btnConvertir;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtNumero = findViewById(R.id.txtNumero);
        spnOpciones = findViewById(R.id.spnOpciones);
        btnConvertir = findViewById(R.id.btnConvertir);
        lblResultado = findViewById(R.id.lblResultado);

        // Llenamos el Spinner con las opciones
        String[] opciones = {"Decimal a Hexadecimal", "Hexadecimal a Decimal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spnOpciones.setAdapter(adapter);
    }
    public void convertirNumero(View view) {
        String numeroTexto = txtNumero.getText().toString().trim();
        String opcion = spnOpciones.getSelectedItem().toString();

        if (numeroTexto.isEmpty()) {
            Toast.makeText(this, "Ingrese un número", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            if (opcion.equals("Decimal a Hexadecimal")) {
                int decimal = Integer.parseInt(numeroTexto);
                String resultado = Integer.toHexString(decimal).toUpperCase();
                lblResultado.setText("Resultado: " + resultado);
            } else if (opcion.equals("Hexadecimal a Decimal")) {
                int decimal = Integer.parseInt(numeroTexto, 16);
                lblResultado.setText("Resultado: " + decimal);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número no válido", Toast.LENGTH_SHORT).show();
        }
    }


}