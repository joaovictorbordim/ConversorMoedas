package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mapeamento de elementos
        this.mViewHolder.v_real = findViewById(R.id.v_real);
        this.mViewHolder.v_dolar = findViewById(R.id.v_dolar);
        this.mViewHolder.v_euro = findViewById(R.id.v_euro);
        this.mViewHolder.b_calcular = findViewById(R.id.b_calcular);

        //OnClick
        this.mViewHolder.b_calcular.setOnClickListener(this::onClick);

        this.clearValue();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.b_calcular){
            String value = this.mViewHolder.v_real.getText().toString();
            if ("".equals(value)) {
                //Mensagem ao usuário.
                Toast.makeText(this, "Informe um Valor!", Toast.LENGTH_LONG).show();
            }else {
                Double real = Double.valueOf(value);
                this.mViewHolder.v_dolar.setText(String.format("%.2f", (real /4)));
                this.mViewHolder.v_euro.setText(String.format("%.2f", (real/5)));
            }

        }
    }

    private void clearValue() {
        this.mViewHolder.v_dolar.setText("");
        this.mViewHolder.v_euro.setText("");
    }

    private static class ViewHolder {
        EditText v_real;
        TextView v_dolar;
        TextView v_euro;
        Button b_calcular;

    }

}