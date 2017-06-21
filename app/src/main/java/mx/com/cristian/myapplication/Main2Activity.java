package mx.com.cristian.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private TextView tvNombre2;
    private TextView tvTelefono2;
    private TextView tvCorreo2;
    private TextView tvFecha2;
    private TextView tvDescript2;
    private Button   tvEditar;

    String nombre, telefono, correo,descripcion, dia, mes ,anio, fechaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvNombre2   = (TextView) findViewById(R.id.tvNombre2);
        tvTelefono2 = (TextView) findViewById(R.id.tvTelefono2);
        tvCorreo2   = (TextView) findViewById(R.id.tvCorreo2);
        tvDescript2 = (TextView) findViewById(R.id.tvDescrip2);
        tvFecha2    = (TextView) findViewById(R.id.tvFecha2);
        tvEditar    = (Button)   findViewById(R.id.tvEditar);

        Bundle bundle=this.getIntent().getExtras();
        nombre= bundle.getString("tvNombre");
        telefono= bundle.getString("tvTelefono");
        correo= bundle.getString("tvCorreo");
        descripcion= bundle.getString("tvDescrip");
        mes= bundle.getString("mes");
        dia= bundle.getString("dia");
        anio= bundle.getString("anio");
        fechaC=(dia + "/"+ mes + "/" + anio);

        System.out.println(nombre);
        System.out.println(telefono);
        System.out.println(correo);
        System.out.println(descripcion);
        System.out.println(dia + "/"+ mes + "/" + anio);




        tvNombre2.setText(nombre);
        tvTelefono2.setText(telefono);
        tvCorreo2.setText(correo);
        tvDescript2.setText(descripcion);
        tvFecha2.setText(fechaC);


        tvEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                reEnviarDatos();
            }
        });

    }



    public void reEnviarDatos() {
        String nombre, telefono,correo,descripcion, mesE,diaE,anioE;
        nombre=  tvNombre2.getText().toString();
        telefono=tvTelefono2.getText().toString();
        correo=  tvCorreo2.getText().toString();
        descripcion=tvDescript2.getText().toString();
        mesE= mes.toString();
        diaE= dia.toString();
        anioE=anio.toString();
        Intent i = new Intent(Main2Activity.this, MainActivity.class);
        //intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());

        //  intent.putExtra("variable_integer", objeto.getId());

        i.putExtra("tvNombreR",   nombre);
        i.putExtra("tvTelefonoR", telefono);
        i.putExtra("tvCorreoR",   correo);
        i.putExtra("tvDescripR",  descripcion);
        i.putExtra("mesR",        mesE);
        i.putExtra("diaR",        diaE);
        i.putExtra("anioR",       anioE);
        startActivity(i);
    }



    }

