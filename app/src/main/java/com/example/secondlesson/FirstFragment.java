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

public class FirstFragment extends Fragment {
    Button btnNavigate;
    EditText etName, etSecondName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        setClick();
    }

    private void setClick() {
        btnNavigate.setOnClickListener(view -> {
            if (!etName.getText().toString().isEmpty() &&
                    !etSecondName.getText().toString().isEmpty()) {
                navigateToSecond();
            } else {
                Toast.makeText(requireActivity(), "Fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToSecond() {
        Bundle bundle = new Bundle();
        String nameInfo = etName.getText().toString();
        String secondNameInfo = etSecondName.getText().toString();
        bundle.putString("nameInfo", nameInfo);
        bundle.putString("secondNameInfo", secondNameInfo);

        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, secondFragment)
                .commit();
    }

    private void initViews() {
        btnNavigate = requireActivity().findViewById(R.id.navigate_to_second_btn);
        etName = requireActivity().findViewById(R.id.et_name);
        etSecondName = requireActivity().findViewById(R.id.et_second_name);
    }
}