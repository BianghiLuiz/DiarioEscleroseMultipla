package br.com.visual.EscleroseMultipla.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.visual.EscleroseMultipla.BancoDeDados.BDSQLiteHelper;
import br.com.visual.EscleroseMultipla.BancoDeDados.Livro;
import br.com.visual.EscleroseMultipla.R;

public class EditLivroActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_livro);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        bd = new BDSQLiteHelper(this);
        final Livro livro = bd.getLivro(id);

        final EditText nome = (EditText) findViewById(R.id.edNome);
        final String Definirnome = nome.getText().toString();
        final EditText autor = (EditText) findViewById(R.id.edAutor);

        nome.setText(livro.getTitulo());
        autor.setText(livro.getAutor());


        Button alterar = (Button) findViewById(R.id.btnEditLivro);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( Definirnome.isEmpty() ){
                    livro.setTitulo(nome.getText().toString());
                    livro.setAutor(autor.getText().toString());
                    bd.updateLivro(livro);
                    Toast.makeText(getBaseContext(), "Lembrete alterado com sucesso.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(),"Erro ao alterar as informações dos lembretes.", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(EditLivroActivity.this, ListAnotacoesActivity.class);
                startActivity(intent);

            }
        });

        Button remover = (Button) findViewById(R.id.btnDeleteLivro);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Definirnome.isEmpty()){
                    bd.deleteLivro(livro);
                    Toast.makeText(getBaseContext(), "Lembrete removido com sucesso", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getBaseContext(),"Erro ao excluir o lembrete.", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(EditLivroActivity.this, ListAnotacoesActivity.class);
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
