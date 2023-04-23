package com.example.secondlesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FourthFragment extends Fragment {

    TextView tvMain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        setMainView();
    }

    private void setMainView() {
        String ageInfo = getArguments().getString("ageInfo");
        String sexInfo = getArguments().getString("sexInfo");
        String secondNameInfo = getArguments().getString("secondNameInfo");
        String nameInfo = getArguments().getString("nameInfo");
        String jobInfo = getArguments().getString("jobInfo");
        String placeOfStudyInfo = getArguments().getString("placeOfStudyInfo");

        tvMain.setText(nameInfo + "\n" + secondNameInfo + "\n" +
                ageInfo + "\n" + sexInfo + "\n" +
                jobInfo + "\n" + placeOfStudyInfo);
    }

    private void initViews() {
        tvMain = requireActivity().findViewById(R.id.tv_main);
    }


}