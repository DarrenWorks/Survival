package com.darren.survival.widget;

import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.darren.survival.Adapter.ChooseAdapter;
import com.darren.survival.R;
import com.darren.survival.elements.model.Good;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2016/1/19 0019.
 */
public class ChooseViewWidget extends LinearLayout {
    private Context context;
    private Fragment fragment;

    private TextView choiceType;
    private ListView choiceList;

    private ChooseAdapter chooseAdapter;

    private boolean isListening = false;

    public ChooseViewWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.widget_choose, this);
        init();
    }

    public ChooseViewWidget(Context context,Fragment fragment, AttributeSet attrs) {
        this(context, attrs);
        this.fragment = fragment;
    }

    private void init() {
        choiceType = (TextView) findViewById(R.id.choiceType);
        choiceList = (ListView) findViewById(R.id.choiceList);

        chooseAdapter = new ChooseAdapter(context, new ArrayList<Good>());
        choiceList.setAdapter(chooseAdapter);

        choiceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chooseAdapter.setSelectedPosition(position);
                chooseAdapter.notifyDataSetChanged();
                if (isListening && fragment instanceof ChoiceOnClickListener)
                    ((ChoiceOnClickListener) fragment).onClick(getChoice());
            }
        });
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public void setData(String choiceType, List<Good> choices) {
        this.choiceType.setText(String.format("%s:", choiceType));
        chooseAdapter.setData(choices);
    }

    public void setListening() {
        isListening = true;
    }

    public void notifySetDataChanged() {
        chooseAdapter.notifyDataSetChanged();
    }

    public Good getChoice() {
        return (Good) chooseAdapter.getItem(chooseAdapter.getSelectedPosition());
    }

    public interface ChoiceOnClickListener {
        void onClick(Good choice);
    }
}
