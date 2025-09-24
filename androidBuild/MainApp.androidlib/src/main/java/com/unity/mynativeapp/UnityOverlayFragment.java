package com.unity.mynativeapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.unity3d.player.IUnityPlayerSupport;
import com.unity3d.player.UnityPlayer;

public class UnityOverlayFragment extends Fragment {

    private UnityPlayer unityPlayer;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_unity_overlay, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        unityPlayer = ((IUnityPlayerSupport) UnityPlayer.currentActivity).getUnityPlayerConnection();

        Button showMainButton = view.findViewById(R.id.show_main_button);
        Button sendMsgButton = view.findViewById(R.id.send_msg_button);
        Button unloadButton = view.findViewById(R.id.unload_button);
        Button finishButton = view.findViewById(R.id.finish_button);

        showMainButton.setOnClickListener(v -> SharedClass.showMainActivity(getActivity(), ""));
        sendMsgButton.setOnClickListener(v -> unityPlayer.UnitySendMessage("Cube", "ChangeColor", "yellow"));
        unloadButton.setOnClickListener(v -> unityPlayer.unload());
        finishButton.setOnClickListener(v -> getActivity().finish());
    }
}
