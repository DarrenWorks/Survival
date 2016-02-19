package com.darren.survival.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.darren.survival.R;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Darren on 2016/1/21 0021.
 */
public class MotionProgressBar extends LinearLayout {
    private Context context;
    private ProgressBar progressBar;
    private TextView txtHint;
    private Queue<String> queue = new LinkedList<>();
    private String hint;
    private boolean isProgressing = false;


    public MotionProgressBar(Context context) {
        this(context, null);
    }

    public MotionProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.widget_motion_progress_bar, this);
        init();
    }

    private void init() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtHint = (TextView) findViewById(R.id.txtHint);

        progressBar.setMinimumWidth((int) (getWidth() * 0.7));
        progressBar.setMinimumHeight((int) (getHeight() * 0.2));

//        txtHint.setMinimumHeight((int) (getHeight() * 0.7));
//        txtHint.setMinimumHeight((int) (getHeight() * 0.2));
    }

    private void setHint() {
        txtHint.setText(hint);
    }

    public void incrementProgressBy(int diff) {
        progressBar.incrementProgressBy(diff);
    }

    private void setProgress(int progress) {
        progressBar.setProgress(progress);
    }

    public void addTransaction(String hint) {
        queue.offer(hint);
        if(!isProgressing) startProgress();
    }

    private void startProgress() {
        isProgressing = true;

        final MyHandler handler = new MyHandler(this);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                hint =queue.poll();
                handler.sendEmptyMessage(MyHandler.WHAT_SET_VISIBLE);
                do{
                    handler.sendEmptyMessage(MyHandler.WHAT_SET_HINT);
                    for(int i=0;i<20;i++) {
                        handler.sendEmptyMessage(MyHandler.WHAT_INCREMENT_BY);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    handler.sendEmptyMessage(MyHandler.WHAT_CLEAR_PROGRESS);
                    hint = queue.poll();
                } while (hint != null);
                hint = "";
                handler.sendEmptyMessage(MyHandler.WHAT_SET_HINT);
                handler.sendEmptyMessage(MyHandler.WHAT_SET_GONE);
                isProgressing = false;
            }
        });
            thread.start();
    }

    private static class MyHandler extends Handler {
        private static final int WHAT_SET_VISIBLE = 0;
        private static final int WHAT_SET_GONE = 1;
        private static final int WHAT_INCREMENT_BY = 2;
        private static final int WHAT_SET_HINT = 3;
        private static final int WHAT_CLEAR_PROGRESS = 4;
        private WeakReference<MotionProgressBar> motionProgressBar;

        private MyHandler(MotionProgressBar motionProgressBar) {
            this.motionProgressBar = new WeakReference<MotionProgressBar>(motionProgressBar);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case WHAT_SET_VISIBLE:
                    motionProgressBar.get().setVisibility(VISIBLE);
                    motionProgressBar.get().bringToFront();
                    break;
                case WHAT_SET_GONE:
                    motionProgressBar.get().setVisibility(GONE);
                    break;
                case WHAT_INCREMENT_BY:
                    motionProgressBar.get().incrementProgressBy(1);
                    break;
                case WHAT_SET_HINT:
                    motionProgressBar.get().setHint();
                    break;
                case WHAT_CLEAR_PROGRESS:
                    motionProgressBar.get().setProgress(0);
                    break;
            }
        }
    }

    private class Transaction {

    }
}
