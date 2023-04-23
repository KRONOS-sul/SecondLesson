package com.example.secondlesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment {

    EditText etPlaceOfStudy, etJob;
    Button btnNavigate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        setOnClick();
    }

    private void setOnClick() {
        btnNavigate.setOnClickListener(view -> {
            if (!etPlaceOfStudy.getText().toString().isEmpty() &&
                    !etJob.getText().toString().isEmpty()) {
                navigateToFourth();
            } else {
                Toast.makeText(requireActivity(), "Fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToFourth() {
        String ageInfo = getArguments().getString("ageInfo");
        String sexInfo = getArguments().getString("sexInfo");
        String secondNameInfo = getArguments().getString("secondNameInfo");
        String nameInfo = getArguments().getString("nameInfo");

        Bundle bundle = new Bundle();
        String placeOfStudyInfo = etPlaceOfStudy.getText().toString();
        String jobInfo = etJob.getText().toString();
        bundle.putString("placeOfStudyInfo", placeOfStudyInfo);
        bundle.putString("jobInfo", jobInfo);

        bundle.putString("nameInfo", nameInfo);
        bundle.putString("secondNameInfo", secondNameInfo);
        bundle.putString("ageInfo", ageInfo);
        bundle.putString("sexInfo", sexInfo);

        FourthFragment fourthFragment = new FourthFragment();
        fourthFragment.setArguments(bundle);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fourthFragment)
                .commit();
    }

    private void initViews() {
        etPlaceOfStudy = requireActivity().findViewById(R.id.et_place_of_study);
        etJob = requireActivity().findViewById(R.id.et_job);
        btnNavigate = requireActivity().findViewById(R.id.navigate_to_fourth_btn);
    }

}