package com.darren.survival.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darren.survival.R;
import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;
import com.darren.survival.widgets.ChooseViewWidget;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ChooseFragment extends Fragment implements ChooseViewWidget.ChoiceOnClickListener{
    public static final int CHOICE_TYPE_KINDLING_AND_INFLAMMABLE = 0;
    public static final int CHOICE_TYPE_FIREABLES = 1;

    private View view;

    private TextView hint;
    private Button back;
    private Button sure;

    private int choiceType;

    private List<ChooseViewWidget> chooseWidgetList = new ArrayList<>();

    private LinearLayout chooseWidgets;

    public ChooseFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose, container, false);
        chooseWidgets = (LinearLayout)view.findViewById(R.id.chooceWidgets);
        hint = (TextView)view.findViewById(R.id.hint);
        back = (Button)view.findViewById(R.id.back);
        sure = (Button)view.findViewById(R.id.sure);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity() instanceof ChooseFOnClickListener) {
                    ((ChooseFOnClickListener) getActivity()).chooseFOnClick(v);
                }
                int id = v.getId();
                switch (id) {
                    case R.id.sure :
                        break;
                    case R.id.back :
                        break;
                }
            }
        };
        sure.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
        return view;
    }

    public void setData(int choiceType, List<Good> ... choices) {
        this.choiceType = choiceType;
        chooseWidgets.removeAllViews();
        chooseWidgetList.clear();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;

        switch (choiceType) {
            case CHOICE_TYPE_KINDLING_AND_INFLAMMABLE :
                ChooseViewWidget chooseWidget = new ChooseViewWidget(getActivity(), this, null);
                chooseWidget.setData("火种", choices[0]);
                chooseWidget.setLayoutParams(params);
                chooseWidgets.addView(chooseWidget);
                chooseWidgetList.add(chooseWidget);
                chooseWidget = new ChooseViewWidget(getActivity(), this, null);
                chooseWidget.setData("引燃物", choices[1]);
                chooseWidget.setLayoutParams(params);
                chooseWidgets.addView(chooseWidget);
                chooseWidgetList.add(chooseWidget);
                hint.setText("请选择火种和引燃物");
                break;
            case CHOICE_TYPE_FIREABLES :
                chooseWidget = new ChooseViewWidget(getActivity(), this, null);
                chooseWidget.setData("助燃物", choices[0]);
                chooseWidget.setLayoutParams(params);
                chooseWidgets.addView(chooseWidget);
                chooseWidgetList.add(chooseWidget);
                hint.setText(String.format("剩余燃烧时间：%dmin", Motion.firer.getFireTimeLeft()));
                break;
        }
    }

    public void notifySetDataChanged() {
        for(ChooseViewWidget chooseWidget : chooseWidgetList) {
            chooseWidget.notifySetDataChanged();
        }
        hint.setText(String.format("剩余燃烧时间：%dmin", Motion.firer.getFireTimeLeft()));
    }

    public List<Good> getChoices() {
        List<Good> choices = new LinkedList<>();
        for(ChooseViewWidget chooseWidget : chooseWidgetList) {
            choices.add(chooseWidget.getChoice());
        }
        return choices;
    }

    public int getChoiceType() {
        return choiceType;
    }

    @Override
    public void onClick(Good choice) {
        for(ChooseViewWidget chooseViewWidget : chooseWidgetList) {
            if(!chooseViewWidget.isChoiceSelected()) {
                sure.setVisibility(View.INVISIBLE);
                return;
            }
        }
        sure.setVisibility(View.VISIBLE);
    }

    public interface ChooseFOnClickListener {
        void chooseFOnClick(View v);
    }

}
