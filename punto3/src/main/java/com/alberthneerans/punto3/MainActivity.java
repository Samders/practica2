package com.alberthneerans.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double lado,base,altura,radio,bas,lad,are,area;
    private View contenedorTriangulo;
    private View contenedorCirculo;
    private View contenedorCuadrado;
    private View contenedorRectangulo;
    TextView tRespuesta;
    EditText et_baser,et_altura,et_radio,et_ladoc,et_baset,et_lador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contenedorTriangulo = findViewById(R.id.ll_contenedor_triangulo);
        contenedorCirculo = findViewById(R.id.ll_contenedor_circulo);
        contenedorCuadrado = findViewById(R.id.ll_contenedor_cuadrado);
        contenedorRectangulo = findViewById(R.id.ll_contenedor_rectangulo);
        et_radio=(EditText)findViewById(R.id.et_radio);
        et_baser=(EditText) findViewById(R.id.et_baser);
        et_altura=(EditText) findViewById(R.id.et_altura);
        et_baset= (EditText) findViewById(R.id.et_baset);
        et_lador = (EditText) findViewById(R.id.et_lador);
        et_ladoc=(EditText) findViewById(R.id.et_ladoc);
        tRespuesta = (TextView) findViewById(R.id.tRespuesta);
    }

    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_triangulo:
                if (checked) {
                    mostrarParticular(true);

                    are=(base*altura)/2;
                    area=are;

                }
                break;

            case R.id.rb_circulo:
                if (checked) {
                    mostrarParticular(false);

                    are=3.1416*radio*radio;
                    area=are;
                }
                break;
            case R.id.rb_cuadrado:
                if (checked) {
                    mostrarParticular(false);
                    are=lado*lado;
                    area=are;
                }
                break;

            case R.id.rb_rectangulo:
                if (checked) {
                    mostrarParticular(false);
                    are=(bas*lad)/2;
                    area=are;
                }
                break;
        }
    }

    private void mostrarParticular(boolean b) {
        contenedorTriangulo.setVisibility(b ? View.VISIBLE : View.GONE);
        contenedorCirculo.setVisibility(b ? View.GONE : View.VISIBLE);
        contenedorCuadrado.setVisibility(b ? View.GONE : View.GONE);
        contenedorRectangulo.setVisibility(b ? View.GONE : View.VISIBLE);
    }

    public void onButtonClicked(View view) {
        lado= Double.parseDouble(et_ladoc.getText().toString());
        altura= Double.parseDouble(et_altura.getText().toString());
        lad= Double.parseDouble(et_lador.getText().toString());
        base= Double.parseDouble(et_baset.getText().toString());
        bas= Double.parseDouble(et_baser.getText().toString());

        radio= Double.parseDouble(et_radio.getText().toString());

        tRespuesta.setText("el area de la figura seleccionada es: " + area  );

    }
}
