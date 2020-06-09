package br.com.visual.EscleroseMultipla.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.visual.EscleroseMultipla.BancoDeDados.BDSQLiteHelper;
import br.com.visual.EscleroseMultipla.BancoDeDados.Livro;
import br.com.visual.EscleroseMultipla.R;

public class AddAnotacoesActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;
    private TextView thedate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_anotacoes);
        thedate = (TextView) findViewById(R.id.date);
        bd = new BDSQLiteHelper(this);

        Intent incoming = getIntent();
        final String date = incoming.getStringExtra("date");
        thedate.setText(date);

        final EditText nome = (EditText) findViewById(R.id.edtNome);
        final String Definirnome = nome.getText().toString();
        final EditText autor = (EditText) findViewById(R.id.edtAutor);
        //final EditText ano = (EditText) findViewById(R.id.edtAno);
        Button adicionar = (Button) findViewById(R.id.btnAddLivro2);
        Button voltar = (Button) findViewById(R.id.btnAddLivro);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( Definirnome.isEmpty()) {
                    Livro livro = new Livro();
                    livro.setTitulo(nome.getText().toString());
                    livro.setAutor(autor.getText().toString());
                    //livro.setAno(Integer.parseInt(ano.getText().toString()));

                    bd.addLivro(livro);

                    Toast.makeText(getBaseContext(),"Lembrete inserido com sucesso.", Toast.LENGTH_SHORT).show();

                } else{
                    Toast.makeText(getBaseContext(),"Favor preencher os campos obrigatórios", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(AddAnotacoesActivity.this, ListAnotacoesActivity.class);
                intent.putExtra("date",date);
                startActivity(intent);

            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddAnotacoesActivity.this, TelaInicialActivity.class);
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
