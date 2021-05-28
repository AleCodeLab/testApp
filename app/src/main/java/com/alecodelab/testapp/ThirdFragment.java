package com.alecodelab.testapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

public class ThirdFragment extends Fragment {
    private final char[] hex_array = "0123456789ABCDEF".toCharArray();
    private String hexString;
    private TestHandler testHandler;
    private TextView tv_rezult;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        testHandler = new TestHandler();
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        tv_rezult = view.findViewById(R.id.textview_rezult);
        if (getArguments() != null) {
            int arrayLength = getArguments().getInt("arrayLength");
            new Thread(new TestRunnable(arrayLength)).start();
        }
        super.onViewCreated(view, savedInstanceState);

    }


    private String convert(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = hex_array[v >>> 4];
            hexChars[i * 2 + 1] = hex_array[v & 0x0F];
        }
        return new String(hexChars);
    }


    class TestRunnable implements Runnable {
        int param;

        TestRunnable(int param) {
            this.param = param;
        }

        @Override
        public void run() {
            try {
                // генерация массива
                byte[] bytes = new byte[param];
                new Random().nextBytes(bytes);
                hexString = convert(bytes);
                testHandler.sendEmptyMessage(1);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();

            }

        }
    }


    class TestHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                tv_rezult.setText(hexString);
            }
            super.handleMessage(msg);
        }
    }


}
