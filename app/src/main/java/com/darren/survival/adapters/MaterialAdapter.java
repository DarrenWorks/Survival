package com.darren.survival.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.darren.survival.R;
import com.darren.survival.elements.model.Good;
import com.darren.survival.utls.Material;
import com.darren.survival.utls.Recipe;

import java.util.List;

/**
 * Created by Darren on 2016/1/12 0012.
 */
public class MaterialAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Material> materials;

    public MaterialAdapter(Context context, Recipe recipe) {
        inflater = LayoutInflater.from(context);
        materials = recipe.getMaterials();
    }
    @Override
    public int getCount() {
        return materials == null ? 0 : materials.size();
    }

    @Override
    public Object getItem(int position) {
        return materials == null ? null : materials.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(Recipe recipe) {
        materials = recipe.getMaterials();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtNumber;
        TextView txtMaterial;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.material_list, null);
        }
        txtNumber = (TextView)convertView.findViewById(R.id.txtNumber);
        txtMaterial = (TextView)convertView.findViewById(R.id.txtMaterial);

        txtNumber.setText(String.format("%d. ", position + 1));
        String strMaterial = "";
        for(Good material : materials.get(position).getMaterial()) {
            strMaterial += String.format("%s(%d)or", material.getName(), materials.get(position).getAmount());
        }
        strMaterial = strMaterial.substring(0, strMaterial.length() - 1);

        txtMaterial.setText(strMaterial);
        return convertView;
    }
}
