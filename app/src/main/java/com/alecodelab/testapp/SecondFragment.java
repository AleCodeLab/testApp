package com.alecodelab.testapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;
import java.util.zip.Inflater;

public class SecondFragment extends Fragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText editText = view.findViewById(R.id.et);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().length() > 0) {
                    // введенная длина массива
                    int arrayLength;
                    try {
                        arrayLength = Integer.parseInt(editText.getText().toString());
                    } catch (NumberFormatException e) {

                        e.printStackTrace();
                        Toast.makeText(getContext(), "Введите меньшее значение", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (arrayLength > 0) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("arrayLength", arrayLength);
                        NavHostFragment.findNavController(SecondFragment.this)
                                .navigate(R.id.action_SecondFragment_to_thirdFragment, bundle);
                    } else {
                        Toast.makeText(getContext(), "Неверное значение длины", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Не заполнено поле ввода", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
