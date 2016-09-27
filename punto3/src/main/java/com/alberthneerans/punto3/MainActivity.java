package com.alberthneerans.punto3;

import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
    private double lado,lad,bas,base,altura,radio,are=10;
    private View contenedorTriangulo;
    private View contenedorCirculo;
    private View contenedorCuadrado;
    private View contenedorRectangulo;
    RadioButton rb_triangulo,rb_circulo,rb_cuadrado,rb_rectangulo;
    TextView tRespuesta;
    EditText et_baser, et_altura, et_radio, et_ladoc, et_baset, et_lador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb_triangulo=(RadioButton)findViewById(R.id.rb_triangulo);
        rb_circulo=(RadioButton)findViewById(R.id.rb_circulo);
        rb_cuadrado=(RadioButton)findViewById(R.id.rb_cuadrado);
        rb_rectangulo=(RadioButton)findViewById(R.id.rb_rectangulo);

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
                    contenedorTriangulo.setVisibility( VISIBLE );
                    contenedorCirculo.setVisibility( View.GONE);
                    contenedorCuadrado.setVisibility(View.GONE);
                    contenedorRectangulo.setVisibility(View.GONE);
                    are=(base*altura)/2;
                    String resultado = String.valueOf(are);
                    tRespuesta.setText("esta es el area de la figura seleccionada" +resultado);
                }
                break;

            case R.id.rb_circulo:
                if (checked) {
                    contenedorCirculo.setVisibility( VISIBLE);
                    contenedorTriangulo.setVisibility( View.GONE );
                    contenedorCuadrado.setVisibility(View.GONE);
                    contenedorRectangulo.setVisibility(View.GONE);
                    are=3.1416*radio*radio;
                    String resultado = String.valueOf(are);
                    tRespuesta.setText("esta es el area de la figura seleccionada"+ resultado);
                }
                break;
            case R.id.rb_cuadrado:
                if (checked) {
                    contenedorCuadrado.setVisibility(VISIBLE);
                    contenedorCirculo.setVisibility( View.GONE);
                    contenedorTriangulo.setVisibility( View.GONE );
                    contenedorRectangulo.setVisibility(View.GONE);
                     are=lado*lado;
                    String resultado = String.valueOf(are);
                    tRespuesta.setText("esta es el area de la figura seleccionada" +resultado);
                }
                break;

            case R.id.rb_rectangulo:
                if (checked) {
                    contenedorRectangulo.setVisibility(VISIBLE);
                    contenedorCuadrado.setVisibility(View.GONE);
                    contenedorCirculo.setVisibility( View.GONE);
                    contenedorTriangulo.setVisibility( View.GONE );
                    are=bas*lad;
                    String resultado = String.valueOf(are);
                    tRespuesta.setText("esta es el area de la figura seleccionada"+ resultado);
                }
                break;
        }
    }
    public void onButtonClicked(View view) {
         lado= Double.parseDouble(et_ladoc.getText().toString());
         altura= Double.parseDouble(et_altura.getText().toString());
         lad= Double.parseDouble(et_lador.getText().toString());
         base= Double.parseDouble(et_baset.getText().toString());
         bas= Double.parseDouble(et_baser.getText().toString());
        radio=Double.parseDouble(et_radio.getText().toString());


    }
}
