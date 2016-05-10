package br.com.schelb.fernando.pdvendteste.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.schelb.fernando.pdvendteste.Objects.ItemMenu;
import br.com.schelb.fernando.pdvendteste.R;

public class ProductsAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<ItemMenu> listItens;


    public ProductsAdapter(Context context, List<ItemMenu> listItens){
        this.context = context;
        this.listItens = listItens;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public Object getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {

            grid = new View(context);
            grid = inflater.inflate(R.layout.layout_item, null);
            TextView tvTitle = (TextView) grid.findViewById(R.id.tv_title);
            TextView tvDescr = (TextView) grid.findViewById(R.id.tv_descr);
            tvTitle.setText(listItens.get(position).getTitle());
            tvDescr.setText(listItens.get(position).getDescr());
        } else {
            grid = (View) view;
        }

        return grid;

    }

}
