package com.darren.survival.fragments;


import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.darren.survival.R;
import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;

import java.lang.ref.WeakReference;

public class MotionProgressBarFragment extends DialogFragment {
    public static final String MOTION_NAME_HUNTER = "Hunter";
    public static final String MOTION_NAME_TOUR = "Tourer";
    public static final String MOTION_NAME_FIRER = "Firer";
    public static final String MOTION_NAME_HURRY = "Hurrier";
    public static final String MOTION_NAME_CAMP = "Camper";
    public static final String MOTION_NAME_REST = "Restor";
    public static final String MOTION_NAME_MAKE = "Maker";
    public static final String MOTION_NAME_PACK = "Packer";
    private View view;
    private TextView txtHint;
    private ProgressBar progressBar;
    private Motion motion;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_motion_progress_bar, null);
        init();
        return view;
    }

    private void init() {
        txtHint = (TextView) view.findViewById(R.id.txtHint);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
    }

    public void progress(Motion motion) {
        this.motion = motion;
        txtHint.setText(String.format("%s......", motion.getName()));
        final MyHandler handler = new MyHandler(this, progressBar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<20; i++) {
                handler.sendEmptyMessage(MyHandler.WHAT_PROGRESS);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage(MyHandler.WHAT_DONE);
            }
        });
        thread.start();
    }

    private void progressDone() {
        switch (getMotion().getName()) {
            case MotionProgressBarFragment.MOTION_NAME_HUNTER:
                Motion.hunter.act();
                for(Good newGood : Motion.packer.getNewGoods().keySet()) {
                Toast.makeText(getActivity(), String.format("You've got a new good : %s(%d)", newGood.getName(), Motion.packer.getNewGoods().get(newGood)), Toast.LENGTH_SHORT).show();
                }
                break;
            case MotionProgressBarFragment.MOTION_NAME_TOUR:
                Motion.tourer.act();
                for(Good newGood : Motion.packer.getNewGoods().keySet()) {
                    Toast.makeText(getActivity(), String.format("You've got a new good : %s(%d)", newGood.getName(), Motion.packer.getNewGoods().get(newGood)), Toast.LENGTH_SHORT).show();
                }
                break;
            case MotionProgressBarFragment.MOTION_NAME_HURRY:
                Motion.hurrier.act();
                break;
            case MotionProgressBarFragment.MOTION_NAME_CAMP:
                Motion.camper.act();
                break;
            case MotionProgressBarFragment.MOTION_NAME_REST:
                Motion.restor.act();
                break;
            case MotionProgressBarFragment.MOTION_NAME_PACK:
//                Motion.packer.act();
                break;
        }
        if(getActivity() instanceof MotionProgressBarFListener)
            ((MotionProgressBarFListener) getActivity()).progressDone(getMotion());
    }

    public Motion getMotion() {
        return motion;
    }

    public interface MotionProgressBarFListener {
        void progressDone(Motion motion);
    }

    private static class MyHandler extends Handler {
        private static final int WHAT_PROGRESS = 0;
        private static final int WHAT_DONE = 1;


        private WeakReference<MotionProgressBarFragment> fragment;
        private WeakReference<ProgressBar> progressBar;

        private MyHandler(MotionProgressBarFragment fragment, ProgressBar progressBar) {
            this.fragment = new WeakReference<MotionProgressBarFragment>(fragment);
            this.progressBar = new WeakReference<ProgressBar>(progressBar);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case WHAT_PROGRESS:
                    progressBar.get().incrementProgressBy(1);
                    break;
                case WHAT_DONE:
                    progressBar.get().setProgress(0);
                   fragment.get().progressDone();
            }

        }
    }

}
