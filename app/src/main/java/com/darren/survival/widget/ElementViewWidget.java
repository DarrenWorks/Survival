package com.darren.survival.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darren.survival.R;
import com.darren.survival.elements.model.Parameter;
import com.darren.survival.elements.model.Scene;

/**
 * Created by Darren on 2015/12/28 0028.
 */
public class ElementViewWidget extends LinearLayout {
    private TextView txtName = null;
    private TextView txtValue = null;

    public ElementViewWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.element_widget, this);
        init();
    }

    private void init() {
        txtName = (TextView)findViewById(R.id.txtName);
        txtValue =(TextView)findViewById(R.id.txtValue);
    }

    public void setMassage(Parameter parameter) {
        txtName.setText(parameter.getName());
        txtValue.setText(String.valueOf(parameter.getValue()));
    }

    public void setMassage(Scene scene) {
        txtName.setText("scene");
        txtValue.setText(scene.getName());
    }

    public void setMassage(String name, String value) {
        txtName.setText(name);
        txtValue.setText(value);
    }
}
