package br.com.schelb.fernando.pdvendteste.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.schelb.fernando.pdvendteste.Objects.ItemMenu;
import br.com.schelb.fernando.pdvendteste.R;

/**
 * Created by FernandoiMac on 09/05/16.
 */
public class AdapterViewPager extends PagerAdapter {

    private Context context;
    List<GridView> gridViewList;


    public AdapterViewPager(Context context, List<GridView> gridViewList) {
        this.context = context;
        this.gridViewList = gridViewList;
    }

    @Override
    public int getCount() {
        return gridViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {

        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(lp);
        container.addView(ll);

        GridView gridView = gridViewList.get(position);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"Pressionou a posição: "+id, Toast.LENGTH_SHORT).show();


            }
        });
        ll.addView(gridView);

        return ll;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
