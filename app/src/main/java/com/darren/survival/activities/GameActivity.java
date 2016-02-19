package com.darren.survival.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.darren.survival.R;
import com.darren.survival.elements.Survivor;
import com.darren.survival.elements.model.Good;
import com.darren.survival.elements.model.Motion;
import com.darren.survival.fragments.BackpackFragment;
import com.darren.survival.fragments.ChooseFragment;
import com.darren.survival.fragments.ElementFragment;
import com.darren.survival.fragments.MakeFragment;
import com.darren.survival.fragments.MotionFragment;
import com.darren.survival.fragments.MotionProgressBarFragment;
import com.darren.survival.fragments.SceneFragment;

import java.util.List;


public class GameActivity extends AppCompatActivity implements BackpackFragment.BackpackFOnClickListener, MotionFragment.MotionFOnClickListener,
        ChooseFragment.ChooseFOnClickListener, MotionProgressBarFragment.MotionProgressBarFListener, MakeFragment.MakeFOnClickListener {
    private Survivor survivor = null;

    private FragmentManager fm;
    private FragmentTransaction transaction;

    private BackpackFragment bpFragment;
    private ChooseFragment chooseFragment;
    private ElementFragment elementFragment;
    private MotionFragment motionFragment;
    private MakeFragment makeFragment;
    private SceneFragment sceneFragment;

    private MotionProgressBarFragment motionProgressBarFragment;

    private Fragment topFragment;
    private Fragment leftFragment;
    private Fragment rightFragment;

    private boolean isMotionProgressBarShowing;

    /**
     * 启动此activity
     *
     * @param context 上下文
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, GameActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        init();
        setScreen();
    }

    /**
     * 初始化
     */
    private void init() {
        survivor = Survivor.getInstance();

        fm = getFragmentManager();

        bpFragment = new BackpackFragment();
        chooseFragment = new ChooseFragment();
        elementFragment = new ElementFragment();
        motionFragment = new MotionFragment();
        makeFragment = new MakeFragment();
        sceneFragment = new SceneFragment();
        motionProgressBarFragment = new MotionProgressBarFragment();

        transaction = fm.beginTransaction();//开启事物



        //主界面默认布局
        transaction.add(R.id.leftLayout, elementFragment);
        leftFragment = elementFragment;
        transaction.add(R.id.rightLayout, motionFragment);
        rightFragment = motionFragment;
        transaction.add(R.id.topLayout, sceneFragment);
        topFragment = sceneFragment;

        //将所有将会用到的fragment加入到其应该出现的位置，但不显示
        transaction.add(R.id.rightLayout, bpFragment);
        transaction.hide(bpFragment);
        transaction.add(R.id.rightLayout, chooseFragment);
        transaction.hide(chooseFragment);
        transaction.add(R.id.rightLayout, makeFragment);
        transaction.hide(makeFragment);
        transaction.add(R.id.rightLayout, motionProgressBarFragment);
        transaction.hide(motionProgressBarFragment);

        transaction.commit();
    }

    /**
     * 设置横屏和全屏
     */
    private void setScreen() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * backpackFragment点击事件
     */
    @Override
    public void backpackFOnClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnBack:
                onBackPressed();
                break;
        }
    }

    /**
     * motionFragment点击事件
     */
    @Override
    public void MotionFOnClick(View v) {
        if(isMotionProgressBarShowing) return;
        int id = v.getId();
        switch (id) {
            case R.id.btnHunt:
                showProgress(Motion.hunter);
                break;
            case R.id.btnTour:
                showProgress(Motion.tourer);
                break;
            case R.id.btnFire:
                if (Motion.firer.getFireTimeLeft() <= 0) {
                    chooseFragment.setData(ChooseFragment.CHOICE_TYPE_KINDLING_AND_INFLAMMABLE, Motion.firer.getKINDLING(), Motion.firer.getINFLAMMABLES());
                    if (rightFragment != chooseFragment) replaceRightFragment(chooseFragment);
                } else {
                    chooseFragment.setData(ChooseFragment.CHOICE_TYPE_FIREABLES, Motion.firer.getFIREABLES());
                    if (rightFragment != chooseFragment) replaceRightFragment(chooseFragment);
                }
                break;
            case R.id.btnHurry:
                showProgress(Motion.hurrier);
                break;
            case R.id.btnCamp:
                showProgress(Motion.camper);
                break;
            case R.id.btnRest:
                showProgress(Motion.restor);
                break;
            case R.id.btnMake:
                replaceRightFragment(makeFragment);
                break;
            case R.id.btnPack:
                replaceRightFragment(bpFragment);
                break;
        }
    }

    /**
     * chooseFragment点击事件
     */
    @Override
    public void chooseFOnClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.sure:
                switch (chooseFragment.getChoiceType()) {
                    case ChooseFragment.CHOICE_TYPE_KINDLING_AND_INFLAMMABLE:
                        showProgress(Motion.firer);
                        break;
                    case ChooseFragment.CHOICE_TYPE_FIREABLES:
                        Motion.firer.fire(chooseFragment.getChoices().get(0));
                        chooseFragment.notifySetDataChanged();
                }
                break;
            case R.id.back:
                onBackPressed();
                break;
        }
    }

    /**
     * MakeFragment点击事件
     */
    @Override
    public void MakeFOnClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnBack:
                onBackPressed();
                break;
        }
    }

    public void showProgress(Motion motion) {
        isMotionProgressBarShowing = true;
        transaction = fm.beginTransaction();
        transaction.show(motionProgressBarFragment);
        transaction.commit();
        motionProgressBarFragment.progress(motion);
    }

    /**
     * MotionProgressBarFragment回调事件
     */
    @Override
    public void progressDone(Motion motion) {
        transaction = fm.beginTransaction();
        transaction.hide(motionProgressBarFragment);
        transaction.commit();

        isMotionProgressBarShowing = false;

        switch (motion.getName()) {
            case MotionProgressBarFragment.MOTION_NAME_FIRER:
                List<Good> choices = chooseFragment.getChoices();
                Motion.firer.startFire(choices.get(0), choices.get(1));
                chooseFragment.setData(ChooseFragment.CHOICE_TYPE_FIREABLES, Motion.firer.getFIREABLES());
                if (rightFragment != chooseFragment) replaceRightFragment(chooseFragment);
                break;
        }
        notifyDataSetChanged();
    }

    /**
     * 刷新fragment数据
     */
    private void notifyDataSetChanged() {
        elementFragment.notifyDataSetChanged();
        sceneFragment.notifyDataSetChanged();
        motionFragment.notifySetDataChanged();
        chooseFragment.notifySetDataChanged();
        bpFragment.notifySetDataChanged();
    }

    /**
     * 更换左侧显示的fragment
     *
     * @param newLeftFragment 将要更换成的fragment
     */
    private void replaceLeftFragment(Fragment newLeftFragment) {
        transaction = fm.beginTransaction();
        transaction.hide(leftFragment);
        transaction.show(newLeftFragment);
        leftFragment = newLeftFragment;
        transaction.commit();
    }

    /**
     * 更换右侧显示的fragment
     *
     * @param newRightFragment 将要更换成的fragment
     */
    private void replaceRightFragment(Fragment newRightFragment) {
        transaction = fm.beginTransaction();
        transaction.hide(rightFragment);
        transaction.show(newRightFragment);
        rightFragment = newRightFragment;
        transaction.commit();
    }

    /**
     * 返回键监听
     */
    @Override
    public void onBackPressed() {
        if (rightFragment != motionFragment) {
            transaction = fm.beginTransaction();
            transaction.hide(rightFragment);
            transaction.show(motionFragment);
            rightFragment = motionFragment;
            transaction.commit();
        } else super.onBackPressed();
        notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
