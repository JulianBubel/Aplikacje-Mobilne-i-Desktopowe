package com.example.hobby.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hobby.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.titleText.setText("Moje Hobby");
        binding.descriptionText.setText("Generalnie to lubie filmy oglądac i to różne jakby nie ma to znaczenia o ile jest dobry albo tak słaby że aż dobry, też ciężary lubie podnosić takie tam hobby fajne fizyczne podobno zdrowe ale to taka ruletka bo niby zdrowe ale bark czasem boli więc lipa");
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}