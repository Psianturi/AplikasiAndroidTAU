package me.posmajanius.advancemobileprogramming_uts.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.posmajanius.advancemobileprogramming_uts.R;
import me.posmajanius.advancemobileprogramming_uts.features.FaceDetectionActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FiturFragment extends Fragment {
    private CardView cardViewFaceFetection, cardViewTextDetection;


    public FiturFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fitur, container, false);
        cardViewFaceFetection = view.findViewById(R.id.cardViewFaceDetection);
        cardViewFaceFetection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), FaceDetectionActivity.class);
                startActivity(i);

            }
        });
        return view;
    }

}
