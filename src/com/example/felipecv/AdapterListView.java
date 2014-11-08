/**
 * 
 */
package com.example.felipecv;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Felipe
 *Essa classe serve para personalizar uma lista com um icone seguido de um texto
 */
public class AdapterListView extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<ListViewCV> elements;

    public AdapterListView(Context context, ArrayList<ListViewCV> elements) {
        //Itens que preencheram o listview
        this.elements = elements;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     *Retorna a quantidade de elementos da lista
     * @return
     */
    public int getCount() {
        return elements.size();
    }

    /**
     *Retorna o elemento de acordo com a posição na tela
     *
     * @param position
     * @return
     */
    public ListViewCV getItem(int position) {
        return elements.get(position);
    }

    /**
     * @param position
     * @return
     */
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        //Pega o elemento de acordo com a posição.
    	ListViewCV item = elements.get(position);

        view = mInflater.inflate(R.layout.item_listview, null);

        TextView text=(TextView) view.findViewById(R.id.text);
        text.setText("\t"+item.getText());
        text.setTypeface(null, Typeface.BOLD);
        text.setGravity(Gravity.CENTER);
        
        ((ImageView) view.findViewById(R.id.imageview)).setImageResource(item.getIconeRid());

        return view;
    }
}

