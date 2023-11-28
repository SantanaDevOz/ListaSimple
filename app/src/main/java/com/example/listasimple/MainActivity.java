package com.example.listasimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Nodo inicio=null;
    private Nodo ultimo=null;

    public class Nodo
    {
       public int dato;
       public Nodo siguiente;

       public Nodo(int valor)
       {
           dato = valor;
           siguiente=null;
       }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText Numero = findViewById(R.id.Numero);
        final TextView Txtv_Ver = findViewById(R.id.Txtv_Ver);
        Button Btn_Agregar = findViewById(R.id.Btn_Agregar);

        Btn_Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor = Integer.parseInt(Numero.getText().toString());
                Nodo nuevoNodo = new Nodo(valor);
                if (inicio==null)
                {
                    inicio=nuevoNodo;
                    ultimo=nuevoNodo;
                }
                else
                {
                ultimo.siguiente=nuevoNodo;
                ultimo=nuevoNodo;
                }
                Numero.setText("");
                actualizarSalida();
            }
        });

    }
    private void actualizarSalida(){
        StringBuilder resultado = new StringBuilder();
        Nodo imp=inicio;
        while (imp!=null)
        {
            resultado.append(imp.dato).append(" ,");
            imp=imp.siguiente;
        }
        TextView Txtv_Ver = findViewById(R.id.Txtv_Ver);
        Txtv_Ver.setText(resultado);
    }
}