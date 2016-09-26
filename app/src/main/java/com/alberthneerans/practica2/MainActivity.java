package com.alberthneerans.practica2;



import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String contrasena, usuario, hobbies, rcontrasena,lugarNac, sexo, email;
    private static String fecha;

    TextView tRespuesta;
    EditText eUsuario, eContrasena, erContrasena, eCorreo;
    RadioButton rMasculino, rFemenino;
    CheckBox chCine, chMusica, chVideojuegos, chFutbol;
    Spinner lugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tRespuesta = (TextView) findViewById(R.id.tRespuesta);
        eUsuario = (EditText) findViewById(R.id.eUsuario);
        eContrasena=(EditText) findViewById(R.id.eContrasena);
        erContrasena=(EditText) findViewById(R.id.erContrasena);
        eCorreo=(EditText) findViewById(R.id.eCorreo);
        lugar=(Spinner) findViewById(R.id.lNacimiento);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Ciudades, android.R.layout.simple_spinner_item);

        lugar.setAdapter(adapter);
        lugar.setOnItemSelectedListener(this);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rFemenino:
                if (checked)
                    sexo = "Femenino";
                    break;
            case R.id.rMasculino:
                if (checked)
                    sexo = "Masculino";
                    break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.chcine:
                if (checked)
                    hobbies = "Cine";
                // Put some meat on the sandwich

                break;
            case R.id.chmusica:
                if (checked)
                   hobbies = "Musica";
                // Cheese me

                break;
            // TODO: Veggie sandwich
            case R.id.chfutbol:
                if (checked)
                    hobbies = "Futbol";
                // Put some meat on the sandwich

                break;
            case R.id.chvideojuegos:
                if (checked)
                    hobbies = "Videojuegos";
                // Cheese me

                break;

        }
    }

    public void onButtonClicked(View view){
        usuario=eUsuario.getText().toString();
        contrasena=eContrasena.getText().toString();
        rcontrasena=erContrasena.getText().toString();
        email=eCorreo.getText().toString();
        if(contrasena.equals(rcontrasena)) {
            tRespuesta.setText("Usuario: "+usuario+" Contraseña: "+contrasena+" Mail "+email+" Sexo: "+sexo+" fecha nac: "+fecha+" Lugar Nac: "+lugarNac+" Hobbies: "+hobbies);
        }else
            Toast.makeText(getApplicationContext(), "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      //lugarNac=view.get;
        //falta
        lugarNac= String.valueOf(parent.getItemAtPosition(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
     //falta
    }

    public  static class DatePickerFragment extends DialogFragment implements  DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            fecha = String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day);
            Log.d("date", fecha);
        }
    }

}
