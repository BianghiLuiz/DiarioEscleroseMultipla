package br.com.visual.EscleroseMultipla.Activitys;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.visual.EscleroseMultipla.BancoDeDados.BDSQLiteHelper;
import br.com.visual.EscleroseMultipla.BancoDeDados.Livro;
import br.com.visual.EscleroseMultipla.BancoDeDados.LivroAdapter;
import br.com.visual.EscleroseMultipla.R;


public class Remedios extends AppCompatActivity {

    private BDSQLiteHelper bd;
    ArrayList<Livro> listaLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bd = new BDSQLiteHelper(this);
        setContentView(R.layout.activity_remedios);

        Intent incoming = getIntent();
        final String date3 = incoming.getStringExtra("date");
        //datetime.setText(date3);

        FloatingActionButton fabricar = findViewById(R.id.fabricar);
        fabricar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Remedios.this, AddRemediosActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView remedio = (ListView) findViewById(R.id.lvRemedio);
        listaLivros = bd.getAllLivros();
        LivroAdapter adapter = new LivroAdapter(this, listaLivros);
        remedio.setAdapter(adapter);

        remedio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(Remedios.this, EditLivroActivity.class);
                intent.putExtra("ID", listaLivros.get(position).getId());
                startActivity(intent);
            }
        });
    }

    //MWTODO PARA DEIXA TELA FULLSCREEN
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }


}
