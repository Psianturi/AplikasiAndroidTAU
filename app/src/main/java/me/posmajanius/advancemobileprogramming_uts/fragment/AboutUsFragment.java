package me.posmajanius.advancemobileprogramming_uts.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.posmajanius.advancemobileprogramming_uts.QuestionerActivity;
import me.posmajanius.advancemobileprogramming_uts.QuizActivity;
import me.posmajanius.advancemobileprogramming_uts.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {
    private TextView textviewForm;


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        textviewForm = view.findViewById(R.id.tv_form);
        textviewForm.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), QuestionerActivity.class);
                startActivity(i);
            }
        }));
        return view;

    }
}
