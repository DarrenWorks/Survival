
package com.darren.survival.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.darren.survival.adapters.MaterialAdapter;
import com.darren.survival.adapters.TargetAdapter;
import com.darren.survival.R;
import com.darren.survival.elements.model.Good;
import com.darren.survival.utls.CraftingManager;
import com.darren.survival.utls.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MakeFragment extends Fragment {
    private View view;

    private Button btnBack;
    private Button btnMake;
    private TextView txtName;

    private ListView targetList;
    private ListView materialList;

    private TargetAdapter targetListAdapter;
    private MaterialAdapter materialListAdapter;

    private List<Good> targets;

    private CraftingManager craftingManager = CraftingManager.getInstance();

    public MakeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_make, container, false);
        init();
        return view;
    }

    private void init() {
        txtName = (TextView)view.findViewById(R.id.txtName);
        txtName.setText("");
        btnBack = (Button) view.findViewById(R.id.btnBack);
        btnMake = (Button) view.findViewById(R.id.btnMake);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.btnBack:
                        break;
                    case R.id.btnMake:
                        break;
                }
            }
        };
        btnBack.setOnClickListener(onClickListener);
        btnMake.setOnClickListener(onClickListener);

        targetList = (ListView) view.findViewById(R.id.targetList);
        materialList = (ListView) view.findViewById(R.id.materialList);

        targets = new ArrayList<>();
        final Map<String, Recipe> recipeMap = craftingManager.getRecipeMap();
        for (String targetID : recipeMap.keySet()) {
            targets.add(Good.findGoodById(targetID));
        }

        targetListAdapter = new TargetAdapter(getActivity(), targets);

        targetList.setAdapter(targetListAdapter);
        targetList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                btnMake.setVisibility(View.VISIBLE);
                targetListAdapter.setSelectedPosition(position);
                targetListAdapter.notifyDataSetChanged();
                materialListAdapter.setData(recipeMap.get(((Good) targetListAdapter.getItem(position)).getID()));
                txtName.setText(targets.get(position).getName());
                if (!targetListAdapter.isMakable(position)) {
                    btnMake.setVisibility(View.GONE);
                }
            }
        });

        targetList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                targetListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        materialListAdapter = new MaterialAdapter(getActivity(), recipeMap.get(targets.get(0).getID()));
        materialList.setAdapter(materialListAdapter);
        txtName.setText(targets.get(0).getName());
    }

    public interface MakeFOnClickListener {
        void MakeFOnClick(View v);
    }

}
