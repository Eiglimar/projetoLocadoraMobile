package locadora.usjt.com.br.locadoraoficial;

/**
 * Created by Eiglimar on 12/11/15.
 */
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
public class VeiculosPorCidadeAdapter extends BaseAdapter  {
    private List<ResponseVeiculosPorCidade.AutomovelTOEntity> mVeiculoCidadeitem;
    private Context mContext;
    private LayoutInflater inflater;

    public VeiculosPorCidadeAdapter(Context mContext, List<ResponseVeiculosPorCidade.AutomovelTOEntity> mVeiculoCidadeitem) {
        this.inflater = inflater;
        this.mContext = mContext;
        this.mVeiculoCidadeitem = mVeiculoCidadeitem;
    }

    @Override
    public int getCount() {
        return mVeiculoCidadeitem.size();
    }

    @Override
    public Object getItem(int position) {
        return mVeiculoCidadeitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.each_list_item, parent, false);
        ResponseVeiculosPorCidade.AutomovelTOEntity item = (ResponseVeiculosPorCidade.AutomovelTOEntity) getItem(position);

        ImageView fotoveiculoCidade = (ImageView)rowView.findViewById(R.id.fotoveiculoCidade);
        TextView fabricante = (TextView) rowView.findViewById(R.id.fabricante);
        TextView modelo = (TextView) rowView.findViewById(R.id.modelo);

        String imageUrl = item.getImagem();
        Picasso.with(mContext).load(imageUrl).into(fotoveiculoCidade);
        fabricante.setText(item.getFabricante());
        modelo.setText(item.getModelo());
        return rowView;
    }
}

