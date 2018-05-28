package com.example.user.materialpractica;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<Persona> personas;
    private AdaptadorPersona adapter;
    private LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.lstOpciones);
        personas = new ArrayList<>();
        Persona p = new Persona(1,"111","hola","mundo",1);
        p.guardar();
        Persona g = new Persona(1,"111","cilio","mundo",1);
        g.guardar();
        Persona h = new Persona(1,"111","jose","mundo",1);
        h.guardar();

        personas = Datos.obtener();
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorPersona(personas);

        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);

        adapter.notifyDataSetChanged();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(MainActivity.this,registrar.class);
                startActivity(n);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
