package com.darren.survival.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.darren.survival.elements.model.Good;
import com.darren.survival.widget.UseGoodViewWidget;

import java.util.List;

/**
 * Created by Darren on 2016/1/19 0019.
 */
public class ChooseAdapter extends BaseAdapter {
    private Context context;
    private List<Good> choices;

    private int selectedPosition = -1;

    public ChooseAdapter(Context context, List<Good> choices) {
        this.context = context;
        this.choices = choices;
    }

    @Override
    public int getCount() {
        return choices == null ? 0 : choices.size();
    }

    @Override
    public Object getItem(int position) {
        return choices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public void setData(List<Good> choices) {
        this.choices = choices;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UseGoodViewWidget item;
        if (convertView == null) {
            item = new UseGoodViewWidget(context, null);
        } else {
            item = (UseGoodViewWidget) convertView;
        }
        item.setMassage(choices.get(position));

        item.setTextBold(selectedPosition == position);
        return item;
    }
}
