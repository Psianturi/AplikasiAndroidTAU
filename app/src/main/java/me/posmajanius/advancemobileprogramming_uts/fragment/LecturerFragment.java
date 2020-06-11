package me.posmajanius.advancemobileprogramming_uts.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.posmajanius.advancemobileprogramming_uts.R;
import me.posmajanius.advancemobileprogramming_uts.one.OneAdapter;
import me.posmajanius.advancemobileprogramming_uts.one.OneModel;
import me.posmajanius.advancemobileprogramming_uts.two.TwoModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class LecturerFragment extends Fragment {
    private ArrayList<OneModel> oneModels = new ArrayList<>();
    private OneAdapter oneAdapter;


    public LecturerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lecturer, container, false);
        addData();
        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_lecturer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        OneAdapter oneAdapter = new OneAdapter(getContext(), oneModels);
        recyclerView.setAdapter(oneAdapter);
        return view;
    }
    void addData() {
        oneModels = new ArrayList<>();
        oneModels.add(new OneModel(R.drawable.tanri_abeng, "Dr. Tanri Abeng, MBA", "",
                "Rector TANRI ABENG UNIVERSITY"));
        oneModels.add(new OneModel(R.drawable.prof_sadik, "Prof. Dr. Muh. Nur Sadik, MPM", " ",
                "Vice Rector TANRI ABENG UNIVERSITY"));
        oneModels.add(new OneModel(R.drawable.nur_afny, "Dr. NUR AFNY CATUR ANDRIANI, S.Si., M.Sc.", "",
                "Dean School of Engineering and Technology"));
        oneModels.add(new OneModel(R.drawable.sir_johny, "Johny H Siringo Ringo, BIT., MIMS.", "",
                "Head of Informatic Engineering"));
        oneModels.add(new OneModel(R.drawable.erna_m, "Erna Mariana Susilowardhani, S.Sos., M.Si", ".",
                "Head of Communication Science Study Programme"));
        oneModels.add(new OneModel(R.drawable.rudi, "Rudi Sutomo, S.Kom, M.Si., M.Kom.", "",
                "Head Of Internal Quality Assurance"));

    }

}

