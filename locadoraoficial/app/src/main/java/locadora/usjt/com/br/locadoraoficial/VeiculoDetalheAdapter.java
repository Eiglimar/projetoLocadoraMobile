package locadora.usjt.com.br.locadoraoficial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
/**
 * Created by Eiglimar on 12/11/15.
 */
public class VeiculoDetalheAdapter extends BaseAdapter {
    private List<ResponseVeiculoDetalhe.AutomovelTOEntity> mVeiculoitem;
    private Context mContext;
    private LayoutInflater inflater;

    public VeiculoDetalheAdapter(Context mContext, List<ResponseVeiculoDetalhe.AutomovelTOEntity> mVeiculoitem) {
        this.inflater = inflater;
        this.mContext = mContext;
        this.mVeiculoitem = mVeiculoitem;
    }

    @Override
    public int getCount() {
        return mVeiculoitem.size();
    }

    @Override
    public Object getItem(int position) {
        return mVeiculoitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.detalhes_veiculo, parent, false);
        ResponseVeiculoDetalhe.AutomovelTOEntity item = (ResponseVeiculoDetalhe.AutomovelTOEntity) getItem(position);

        TextView kmControlado = (TextView) rowView.findViewById(R.id.kmcontrolado);
        TextView kmLivre = (TextView) rowView.findViewById(R.id.kmlivre);

        kmControlado.setText(item.getKmControlado());
        kmLivre.setText(item.getKmLivre());
        return rowView;
    }
}


