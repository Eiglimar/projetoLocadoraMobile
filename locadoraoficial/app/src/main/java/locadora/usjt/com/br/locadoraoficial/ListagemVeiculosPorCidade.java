package locadora.usjt.com.br.locadoraoficial;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import android.app.AlertDialog;

public class ListagemVeiculosPorCidade extends AppCompatActivity {

    ListView listview;
    ResponseVeiculosPorCidade responseObj;
    VeiculosPorCidadeAdapter adapter;
    Gson gson;
    AsyncHttpClient client;
    String cidade = "";
    String url = "http://192.168.1.2:8080/Rest/automovel/listarDispPorCidade/";
    String modelo = "";
    String fabricante = "";
    ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_veiculos_por_cidade);
        Bundle bundle = getIntent().getExtras();
        if(getIntent().getStringExtra("cidade") != null){
            cidade = bundle.getString("cidade");
        }
        url = url+cidade;
        listview = (ListView)findViewById(R.id.veiculosList);
        client = new AsyncHttpClient();
        client.get(ListagemVeiculosPorCidade.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responsestr = new String(responseBody);
                gson = new Gson();
                responseObj = gson.fromJson(responsestr, ResponseVeiculosPorCidade.class);
                if(responseObj != null)
                {
                    adapter = new VeiculosPorCidadeAdapter(ListagemVeiculosPorCidade.this, responseObj.getAutomovelTO());
                    listview.setAdapter(adapter);
                }
                else
                {
                    AlertDialog alerta;
                    //Cria o gerador do AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListagemVeiculosPorCidade.this);

                    //define o titulo
                    builder.setTitle("Titulo");

                    // define a mensagem
                    builder.setMessage("Não existem veículos disponíveis nesta cidade");

                    //define um botão como positivo
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            //Toast.makeText(ListagemVeiculosPorCidade.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    //cria o AlertDialog
                    alerta = builder.create();
                    //Exibe
                    alerta.show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}