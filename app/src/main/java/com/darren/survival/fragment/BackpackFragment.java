package com.darren.survival.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.darren.survival.R;
import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;
import com.darren.survival.elements.motion.good.Eatable;
import com.darren.survival.widget.ChooseViewWidget;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackpackFragment extends Fragment implements View.OnClickListener, ChooseViewWidget.ChoiceOnClickListener {
    private View view;

    private Button btnBack;
    private Button btnEat;

    private ChooseViewWidget chooseViewWidget;

    public BackpackFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_backpack, container, false);
        init();
        return view;
    }

    public void init() {
        chooseViewWidget = (ChooseViewWidget) view.findViewById(R.id.chooseWidget);
        chooseViewWidget.setFragment(this);
        chooseViewWidget.setData("背包", Motion.packer.getBackpack());

        btnBack = (Button) view.findViewById(R.id.btnBack);
        btnEat = (Button) view.findViewById(R.id.btnEat);
        btnBack.setOnClickListener(this);
    }

    public void notifySetDataChanged() {
        chooseViewWidget.notifySetDataChanged();
    }

    @Override
    public void onClick(View v) {
        if (getActivity() instanceof BackpackFOnClickListener) {
            ((BackpackFOnClickListener) getActivity()).backpackFOnClick(v);
        }
        int id = v.getId();
        switch (id) {
            case R.id.btnBack:
                break;
        }
    }

    @Override
    public void onClick(Good choice) {
        if (choice instanceof Eatable) btnEat.setVisibility(View.VISIBLE);
        else btnEat.setVisibility(View.GONE);
    }

    public interface BackpackFOnClickListener {
        void backpackFOnClick(View v);
    }
}
