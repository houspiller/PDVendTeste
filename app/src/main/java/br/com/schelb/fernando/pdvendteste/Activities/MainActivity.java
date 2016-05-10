package br.com.schelb.fernando.pdvendteste.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.viewpagerindicator.PageIndicator;

import java.util.ArrayList;
import java.util.List;

import br.com.schelb.fernando.pdvendteste.Adapters.AdapterViewPager;
import br.com.schelb.fernando.pdvendteste.Adapters.ProductsAdapter;
import br.com.schelb.fernando.pdvendteste.Objects.ItemMenu;
import br.com.schelb.fernando.pdvendteste.R;

public class MainActivity extends AppCompatActivity {

    public PageIndicator mIndicator;
    String[] item_titles = {"Cafés","Cafés Especiais", "Capuccinos", "Sanduiches", "Sucos Naturais", "Açaí com Banana","","","","","","","","","",""};
    String[] item_descr = {"Máquina ou Expresso", "Quentes e Frios", "350ml ou 500ml", "Naturais, Quentes ou Frios", "350ml ou 500ml", "Tigela com 500g ou 750g","","","","","","","","","",""};
    double[] item_price = {2.5,3.0,4.0,5.0,6.0,7.49,0,0,0,0,0,0,0,0,0,0};

    String[] item_titles2 = {"Saladas","Refrigerantes","","","","","","","","","","","","","",""};
    String[] item_descr2 = {"500g", "350ml ou 500ml","","","","","","","","","","","","","",""};
    double[] item_price2 = {2.5,3.0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<GridView> gridViewList = new ArrayList<>();

        addGridViewListCreator(gridViewList, listItensCreator(item_titles,item_descr, item_price));
        addGridViewListCreator(gridViewList, listItensCreator(item_titles2,item_descr2,item_price2));

        ViewPager viewPager = (ViewPager) findViewById(R.id.vpager);
        viewPager.setAdapter(new AdapterViewPager(this, gridViewList));

        mIndicator = (PageIndicator) findViewById(R.id.pagerIndicator);
        mIndicator.setViewPager(viewPager);

    }


    private List<ItemMenu> listItensCreator(String[] itemTitles,String[] itemDescr, double[] item_price){
        List<ItemMenu> listItens = new ArrayList<>();



        for (int i=0; i < itemTitles.length;i++ ){

            ItemMenu item = new ItemMenu(itemTitles[i],itemDescr[i],item_price[i]);
            listItens.add(item);

        }

        return listItens;
    }

    private void addGridViewListCreator(List<GridView> gridViewList ,List<ItemMenu> listItens){

        GridView gv = new GridView(this);
        gv.setHorizontalSpacing(1);
        gv.setVerticalSpacing(1);
        gv.setNumColumns(2);
        gv.setAdapter(new ProductsAdapter(this,listItens));

        gridViewList.add(gv);
    }

}
