package com.darren.survival.fragment;


import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.darren.survival.R;
import com.darren.survival.elements.model.Motion;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotionFragment extends Fragment {

    private Button btnHunt;
    private Button btnTour;
    private Button btnFire;
    private Button btnHurry;
    private Button btnCamp;
    private Button btnRest;
    private Button btnMake;
    private Button btnPack;

    private View view = null;

    private LocalBroadcastManager localBroadcastManager;

    public MotionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_motion, container, false);
        init();
        return view;
    }

    private void init() {
        btnHunt =(Button)view.findViewById(R.id.btnHunt);
        btnTour =(Button)view.findViewById(R.id.btnTour);
        btnFire =(Button)view.findViewById(R.id.btnFire);
        btnHurry =(Button)view.findViewById(R.id.btnHurry);
        btnCamp = (Button)view.findViewById(R.id.btnCamp);
        btnRest = (Button)view.findViewById(R.id.btnRest);
        btnMake = (Button)view.findViewById(R.id.btnMake);
        btnPack = (Button)view.findViewById(R.id.btnPack);

        BtnOnClickListener onClickListener = new BtnOnClickListener();
        btnHunt.setOnClickListener(onClickListener);
        btnTour.setOnClickListener(onClickListener);
        btnFire.setOnClickListener(onClickListener);
        btnHurry.setOnClickListener(onClickListener);
        btnCamp.setOnClickListener(onClickListener);
        btnRest.setOnClickListener(onClickListener);
        btnMake.setOnClickListener(onClickListener);
        btnPack.setOnClickListener(onClickListener);

        localBroadcastManager = LocalBroadcastManager.getInstance(getActivity());
    }

    public void notifySetDataChanged() {
        if(Motion.firer.getFireTimeLeft() >0) btnFire.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        else  btnFire.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }

    public interface MotionFOnClickListener {
        void MotionFOnClick(View v);
    }

    private class BtnOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(getActivity() instanceof  MotionFOnClickListener) {
                ((MotionFOnClickListener)getActivity()).MotionFOnClick(v);
            }
        }
    }

}
