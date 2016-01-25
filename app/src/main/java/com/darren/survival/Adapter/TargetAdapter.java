package com.darren.survival.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.darren.survival.R;
import com.darren.survival.elements.model.Good;

import java.util.List;

/**
 * Created by Darren on 2016/1/12 0012.
 */
public class TargetAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Good> targets;

    private int selectedPosition = -1;//选中项的position，未选中时默认为-1

    public TargetAdapter(Context context, List<Good> targets) {
        inflater = LayoutInflater.from(context);
        this.targets = targets;
    }

    @Override
    public int getCount() {
        return targets == null ? 0 : targets.size();
    }

    @Override
    public Object getItem(int position) {
        return targets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtTarget;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.target_list, null);
        }
        txtTarget = (TextView)convertView.findViewById(R.id.txtTarget);
        txtTarget.setText(((Good)getItem(position)).getName());

        //设置选中效果
        if(selectedPosition == position) {
            convertView.setBackgroundColor(Color.DKGRAY);
        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }

        return convertView;
    }
}
