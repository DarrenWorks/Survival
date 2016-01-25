package com.darren.survival.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.darren.survival.R;
import com.darren.survival.elements.Survivor;
import com.darren.survival.widget.ElementViewWidget;

/**
 * A simple {@link Fragment} subclass.
 */
public class SceneFragment extends Fragment {
    private View view;

    private ElementViewWidget scene;
    private ElementViewWidget nextScene;
    private ElementViewWidget distance;

    private Survivor survivor = Survivor.getInstance();


    public SceneFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_scene, container, false);
        init();
        return view;
    }

    private void init() {
        scene = (ElementViewWidget)view.findViewById(R.id.scene);
        nextScene = (ElementViewWidget)view.findViewById(R.id.nextScene);
        distance = (ElementViewWidget)view.findViewById(R.id.distance);

        scene.setMassage("当前场景", survivor.getScene().getName());
        nextScene.setMassage("下一场景", survivor.getNextScene().getName());
        distance.setMassage("距离下一场景距离", String.valueOf(survivor.getScene().getLength()));
    }

    public void notifyDataSetChanged() {
        scene.setMassage("当前场景", survivor.getScene().getName());
        nextScene.setMassage("下一场景", survivor.getNextScene().getName());
        distance.setMassage("距离下一场景距离", String.valueOf(survivor.getScene().getLength()));
    }

}
