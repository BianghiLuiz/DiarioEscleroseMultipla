package br.com.visual.EscleroseMultipla.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.visual.EscleroseMultipla.R;
import br.com.visual.EscleroseMultipla.Sintomas.Cognitivos;
import br.com.visual.EscleroseMultipla.Sintomas.Fadiga;
import br.com.visual.EscleroseMultipla.Sintomas.Intestinais;
import br.com.visual.EscleroseMultipla.Sintomas.Motores;
import br.com.visual.EscleroseMultipla.Sintomas.Sensoriais;
import br.com.visual.EscleroseMultipla.Sintomas.Sexuais;
import br.com.visual.EscleroseMultipla.Sintomas.Urinarios;
import br.com.visual.EscleroseMultipla.Sintomas.Visuais;

public class Sintomas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);
    }

    public void onClickSensoriais(View view) {
        Intent intent = new Intent(this, Sensoriais.class);
        startActivity(intent);
    }

    public void onClickVisuais(View view){
        Intent intent = new Intent (this, Visuais.class);
        startActivity(intent);
    }

    public void onClickMotores(View view){
        Intent intent = new Intent (this, Motores.class);
        startActivity(intent);
    }

    public void onClickUrinarios(View view) {
        Intent intent = new Intent(this, Urinarios.class);
        startActivity(intent);
    }

    public void onClickIntestinais(View view){
        Intent intent = new Intent (this, Intestinais.class);
        startActivity(intent);
    }

    public void onClickSexuais(View view){
        Intent intent = new Intent (this, Sexuais.class);
        startActivity(intent);
    }
    public void onClickCognitivos(View view) {
        Intent intent = new Intent(this, Cognitivos.class);
        startActivity(intent);
    }

    public void onClickFadiga(View view){
        Intent intent = new Intent (this, Fadiga.class);
        startActivity(intent);
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
