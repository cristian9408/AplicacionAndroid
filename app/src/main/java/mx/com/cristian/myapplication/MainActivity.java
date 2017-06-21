package mx.com.cristian.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvCorreo;
    private TextView tvDescrip;
    private DatePicker tvPicker;
    private Button tvEjecutar;
    private Button tvCalendario;
    String nombreR, telefonoR, correoR,descripcionR, diaR, mesR ,anioR, fechaC;
    Integer anioA;
    Integer mesA;
    Integer diaA;
    Boolean bandera=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bundle b=this.getIntent().getExtras();
        Intent intent = this.getIntent();
        if (intent != null) {
            nombreR = intent.getStringExtra("tvNombreR");
            telefonoR = intent.getStringExtra("tvTelefonoR");
            correoR = intent.getStringExtra("tvCorreoR");
            descripcionR = intent.getStringExtra("tvDescripR");
            mesR = intent.getStringExtra("mesR");
            diaR = intent.getStringExtra("diaR");
            anioR = intent.getStringExtra("anioR");


            fechaC = diaR;
            System.out.println(fechaC);
            if(fechaC==null){
                System.out.println("No Cambio bandera");
            }else{
                bandera=true;
                System.out.println("Cambio bandera");
            }

            tvNombre = (TextView) findViewById(R.id.tvNombre);
            tvPicker = (DatePicker) findViewById(R.id.tvPicker);
            tvTelefono = (TextView) findViewById(R.id.tvTelefono);
            tvCorreo = (TextView) findViewById(R.id.tvCorreo);
            tvDescrip = (TextView) findViewById(R.id.tvDescrip);
            tvEjecutar = (Button) findViewById(R.id.send);
            tvCalendario = (Button) findViewById(R.id.btnGet);

            System.out.println(nombreR);
            System.out.println(telefonoR);
            System.out.println(correoR);
            System.out.println(descripcionR);
            System.out.println(diaR + "/" + mesR + "/" + anioR);

            tvNombre.setText(nombreR);
            tvTelefono.setText(telefonoR);
            tvCorreo.setText(correoR);
            tvDescrip.setText(descripcionR);
            if(bandera){
                tvPicker.updateDate(Integer.parseInt(anioR), Integer.parseInt(mesR), Integer.parseInt(diaR));
            }

        }
        tvEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatos();
            }
        });


        tvCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cacharFecha();
            }
        });


    }

    public void cacharFecha(){
        System.out.println(tvPicker + " " + tvPicker.getMonth());
        diaA   = tvPicker.getDayOfMonth();
        anioA  = tvPicker.getYear();
        mesA   = tvPicker.getMonth()+1;
    }


    public void enviarDatos() {

        String nombre, telefono,correo,descripcion, mesE,diaE,anioE;
        nombre  = tvNombre.getText().toString();
        telefono=tvTelefono.getText().toString();
        correo  =tvCorreo.getText().toString();
        descripcion=tvDescrip.getText().toString();
        mesE    =mesA.toString();
        diaE    =diaA.toString();
        anioE   =anioA.toString();
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        //intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());

      //  intent.putExtra("variable_integer", objeto.getId());

        i.putExtra("tvNombre",nombre);
        i.putExtra("tvTelefono",telefono);
        i.putExtra("tvCorreo",  correo);
        i.putExtra("tvDescrip", descripcion);
        i.putExtra("mes",      mesE);
        i.putExtra("dia",      diaE);
        i.putExtra("anio",     anioE);
        startActivity(i);
    }





}
