package br.com.visual.EscleroseMultipla.Sintomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.visual.EscleroseMultipla.Activitys.TelaInicialActivity;
import br.com.visual.EscleroseMultipla.R;

public class Humor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humor);
    }

    public void onClickRetornar(View view) {
        Intent intent = new Intent(this, TelaInicialActivity.class);
        startActivity(intent);
    }
}
