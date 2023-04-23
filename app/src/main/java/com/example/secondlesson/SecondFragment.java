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

public class SecondFragment extends Fragment {

    EditText etAge, etSex;
    Button btnNavigate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        setOnClick();
    }

    private void setOnClick() {
        btnNavigate.setOnClickListener(view -> {
            if (!etAge.getText().toString().isEmpty() &&
                    !etSex.getText().toString().isEmpty()) {
                navigateToThird();
            } else {
                Toast.makeText(requireActivity(), "Fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToThird() {
        String secondNameInfo = getArguments().getString("secondNameInfo");
        String nameInfo = getArguments().getString("nameInfo");

        Bundle bundle = new Bundle();
        String ageInfo = etAge.getText().toString();
        String sexInfo = etSex.getText().toString();
        bundle.putString("ageInfo", ageInfo);
        bundle.putString("sexInfo", sexInfo);

        bundle.putString("nameInfo", nameInfo);
        bundle.putString("secondNameInfo", secondNameInfo);

        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, thirdFragment)
                .commit();
    }

    private void initViews() {
        etAge = requireActivity().findViewById(R.id.et_age);
        etSex = requireActivity().findViewById(R.id.et_sex);
        btnNavigate = requireActivity().findViewById(R.id.navigate_to_third_btn);
    }
}