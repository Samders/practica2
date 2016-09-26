package com.alberthneerans.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double n1,n2,res;
    EditText eNumero1, eNumero2;
    RadioButton rSuma, rResta, rMultiplicacion, rDivision;
   TextView tRespuesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tRespuesta=(TextView)findViewById(R.id.tRespuesta);
        eNumero1 = (EditText) findViewById(R.id.eNumero1);
        eNumero2 = (EditText) findViewById(R.id.eNumero2);


    }
    public void onRadioButtonClicked(View view) {
        double calculo=0;
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rSuma:
                if (checked)
                    calculo=n1+n2;
                res=calculo;

                break;
            case R.id.rResta:
                if (checked)
                    calculo = n1-n2;
                res=calculo;

                break;
            case R.id.rMultiplicacion:
                if (checked)
                    calculo = n1*n2;
                res=calculo;

                break;
            case R.id.rDivision:
                if (checked)
                   calculo = n1/n2;
                res=calculo;

                break;
        }
    }

    public void onButtonClicked(View view) {
        n1= Double.parseDouble(eNumero1.getText().toString());
        n2= Double.parseDouble(eNumero2.getText().toString());

        tRespuesta.setText("Resultado de la operacion seleccionada: " + res );

    }

}
