package com.unity.mynativeapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.unity3d.player.IUnityPlayerSupport;
import com.unity3d.player.UnityPlayer;

public class SharedClass {

    public static void showMainActivity(String setToColor) {
        showMainActivity(UnityPlayer.currentActivity, setToColor);
    }

    public static void showMainActivity(Activity activity, String setToColor) {
        Intent intent = new Intent((Context) activity, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("setColor", setToColor);
        activity.startActivity(intent);
    }

    public static void addControlsToUnityFrame(Activity activity) {
        UnityPlayer unityPlayer = ((IUnityPlayerSupport) UnityPlayer.currentActivity).getUnityPlayerConnection();
        FrameLayout layout = unityPlayer.getFrameLayout();


        FragmentManager fm = UnityPlayer.currentActivity.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        Fragment fragment = fm.findFragmentByTag("UnityOverlayFragment");
        ft.add(android.R.id.content, new UnityOverlayFragment(), "UnityOverlayFragment");
        ft.commit();
//        View overlay = activity.getLayoutInflater().inflate(R.layout.button_overlay, layout, false);
//        layout.addView(overlay);
//
//        // Set up buttons
//        Button showMainButton = overlay.findViewById(R.id.show_main_button);
//        Button sendMsgButton = overlay.findViewById(R.id.send_msg_button);
//        Button unloadButton = overlay.findViewById(R.id.unload_button);
//        Button finishButton = overlay.findViewById(R.id.finish_button);
//
//        showMainButton.setOnClickListener(v -> showMainActivity(activity, ""));
//
//        sendMsgButton.setOnClickListener(v ->
//                unityPlayer.UnitySendMessage("Cube", "ChangeColor", "yellow")
//        );
//
//        unloadButton.setOnClickListener(v ->
//                unityPlayer.unload()
//        );
//
//        finishButton.setOnClickListener(v ->
//                activity.finish()
//        );
    }
}
