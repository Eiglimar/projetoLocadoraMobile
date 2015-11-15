package locadora.usjt.com.br.locadoraoficial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerCidade;
    String cidade;
    Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        cidade = "";
        spinnerCidade = (Spinner) findViewById(R.id.spiCidades);
        spinnerCidade.setOnItemSelectedListener(new CidadeSelecionado());
        btnConsultar = (Button) findViewById(R.id.btnConsultar);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarVeiculos(v);
            }
        });
    }

    private class CidadeSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            cidade = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    //será chamado quando o usuário clicar em enviar
    public void consultarVeiculos(View view) {
        consultar(view);
    }


    public void consultar(View view){
        String pCidade = this.cidade.equals("Escolha a cidade")?"":cidade;

        Intent intent = new Intent(getApplicationContext(), ListagemVeiculosPorCidade.class);
        intent.putExtra("cidade",pCidade);
        startActivity(intent);
    }
}
