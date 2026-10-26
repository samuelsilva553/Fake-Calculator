package com.samucaa.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvDisplay;
    private String currentInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setBackgroundColor(0xFF1C1C1E);
        mainLayout.setPadding(30, 30, 30, 30);

        tvDisplay = new TextView(this);
        tvDisplay.setTextColor(0xFFFFFFFF);
        tvDisplay.setTextSize(80);
        tvDisplay.setGravity(android.view.Gravity.END);
        tvDisplay.setText("0");
        mainLayout.addView(tvDisplay, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f));

        String[] botoes = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"};
        
        for (String texto : botoes) {
            Button btn = new Button(this);
            btn.setText(texto);
            btn.setTextSize(24);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    processarClique(texto);
                }
            });
            mainLayout.addView(btn);
        }

        setContentView(mainLayout);
    }

    private void processarClique(String texto) {
        if (texto.equals("C")) {
            currentInput = "";
            tvDisplay.setText("0");
            return;
        }

        if (texto.equals("=")) {
            if (currentInput.equals("7+7")) {
                tvDisplay.setText("14");
                Toast.makeText(this, "Senha correta! Desbloqueado.", Toast.LENGTH_LONG).show();
            } else {
                tvDisplay.setText("Erro");
                currentInput = "";
            }
            return;
        }

        currentInput += texto;
        tvDisplay.setText(currentInput);
    }
}
