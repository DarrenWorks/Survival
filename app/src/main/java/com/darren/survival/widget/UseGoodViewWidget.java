package com.darren.survival.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darren.survival.R;
import com.darren.survival.elements.model.Good;

/**
 * Created by Darren on 2016/1/19 0019.
 */
public class UseGoodViewWidget extends LinearLayout {
    private TextView goodName;
    private TextView countForUse;
    public UseGoodViewWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.widget_use_good, this);
        init();
    }

    private void init() {
        goodName = (TextView)findViewById(R.id.goodName);
        countForUse = (TextView)findViewById(R.id.countForUse);
    }

    public void setMassage(Good good) {
        goodName.setText(good.getName());
        countForUse.setText(String.format("(%d)", good.getCOUNT()));
    }

    public void setTextBold(boolean isBold) {
        if(isBold) {
            goodName.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            countForUse.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        } else {
            goodName.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            countForUse.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        }
        goodName.getPaint().setFakeBoldText(isBold);
        countForUse.getPaint().setFakeBoldText(isBold);
    }
}
