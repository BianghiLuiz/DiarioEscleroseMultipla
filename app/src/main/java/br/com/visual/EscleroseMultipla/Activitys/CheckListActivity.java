package br.com.visual.EscleroseMultipla.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import br.com.visual.EscleroseMultipla.R;

public class CheckListActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox sms;
    private CheckBox email;
    private CheckBox fone;
    private CheckBox fone4;
    private CheckBox fone5;
    private CheckBox fone6;
    private CheckBox fone7;
    private CheckBox fone9;
    private CheckBox fone10;
    private CheckBox fone3;
    private CheckBox fone2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);

        sms = (CheckBox) findViewById(R.id.cheSMS);
        email = (CheckBox) findViewById(R.id.cheEmail);
        fone = (CheckBox) findViewById(R.id.cheFone);
        fone2 = (CheckBox) findViewById(R.id.cheFone2);
        fone3 = (CheckBox) findViewById(R.id.cheFone3);
        fone4 = (CheckBox) findViewById(R.id.cheFone4);
        fone5 = (CheckBox) findViewById(R.id.cheFone5);
        fone6 = (CheckBox) findViewById(R.id.cheFone6);
        fone7 = (CheckBox) findViewById(R.id.cheFone7);
        fone10 = (CheckBox) findViewById(R.id.cheFone10);
        fone9 = (CheckBox) findViewById(R.id.cheFone9);
        Button btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String mensagem = "Atividades gravadas com sucesso. ";
//        if (sms.isChecked()) {
//        }
//        if (email.isChecked())
//
//        if (fone.isChecked())
//
//        if (fone2.isChecked())
//
//        if (fone3.isChecked())
//            mensagem += "Menstruação" + mensagem2;
//        if (fone4.isChecked())
//            mensagem += "Estresse mental" + mensagem2;
//        if (fone5.isChecked())
//            mensagem += "Tomar sol" + mensagem2;
//        if (fone6.isChecked())
//            mensagem += "Roupa pesadas ou quentes" + mensagem2;
//        if (fone7.isChecked())
//            mensagem += "Alimentos quentes ou picantes" + mensagem2;
//        if (fone9.isChecked())
//            mensagem += "Secador de Cabelo" + mensagem2;
//        if (fone10.isChecked())
//            mensagem += "Temperatura ambiente > 30°C" + mensagem2;

        AlertDialog.Builder dlg = new AlertDialog.Builder(CheckListActivity.this);
        dlg.setMessage(mensagem);
        dlg.setNeutralButton("OK", null);
        dlg.show();

    }


    public void onClickRetornar(View view) {
        Intent intent = new Intent(this, TelaInicialActivity.class);
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
