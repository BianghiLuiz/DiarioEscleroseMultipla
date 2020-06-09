package br.com.visual.EscleroseMultipla.Sintomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.visual.EscleroseMultipla.Activitys.Sintomas;
import br.com.visual.EscleroseMultipla.Activitys.TelaInicialActivity;
import br.com.visual.EscleroseMultipla.R;

public class Sexuais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexuais);
    }

    public void onClickRetornar(View view) {
        Intent intent = new Intent(this, TelaInicialActivity.class);
        startActivity(intent);
    }
}
