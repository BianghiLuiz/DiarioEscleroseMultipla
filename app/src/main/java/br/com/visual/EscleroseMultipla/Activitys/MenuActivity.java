package br.com.visual.EscleroseMultipla.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.visual.EscleroseMultipla.R;
import br.com.visual.EscleroseMultipla.Sintomas.Humor;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickDia(View view) {
        Intent intent = new Intent(this, CheckListActivity.class);
        startActivity(intent);

    }

    public void onClickOrientacao(View view) {
        Intent intent = new Intent(this, Orientacoes.class);
        startActivity(intent);
    }

    public void onClickMedicamento(View view) {

        Intent intent = new Intent(this, Remedios.class);
        startActivity(intent);

    }

    public void onClickHumor(View view) {

        Intent intent = new Intent(this, Humor.class);
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
