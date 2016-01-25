package com.darren.survival.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.darren.survival.R;
import com.darren.survival.elements.model.Good;

import java.util.List;

/**
 * Created by Darren on 2015/12/20 0020.
 */
public class BackpackAdapter extends BaseAdapter {
    private LayoutInflater inflater = null;
    private List<Good> backpack = null;

    public BackpackAdapter(Context context, List<Good> backpack) {
        inflater = LayoutInflater.from(context);
        this.backpack = backpack;
    }

    public void setData(List<Good> goods) {
        this.backpack = goods;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return backpack == null ? 0 : backpack.size();
    }

    @Override
    public Object getItem(int position) {
        return backpack.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView goodName = null;
        TextView goodCount = null;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.backpack_view,null);
        }
        goodName = (TextView)convertView.findViewById(R.id.txtGoodName);
        goodCount = (TextView)convertView.findViewById(R.id.txtGoodCount);
        Good good = backpack.get(position);
        String[] strNames = good.getClass().getName().split("\\.");
        String strName = strNames[strNames.length - 1];
        String strCount = good.getCOUNT() + "";
        goodName.setText(strName);
        goodCount.setText(strCount);

        return convertView;
    }
}
