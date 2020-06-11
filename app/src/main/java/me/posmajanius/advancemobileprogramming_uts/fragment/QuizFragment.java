package me.posmajanius.advancemobileprogramming_uts.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import me.posmajanius.advancemobileprogramming_uts.QuizActivity;
import me.posmajanius.advancemobileprogramming_uts.R;

/**
 * A fragment with a Google +1 button.
 */
public class QuizFragment extends Fragment {
    private Button btnNext;

    public QuizFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        btnNext = view.findViewById(R.id.btn_go_to_quiz);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), QuizActivity.class);
                startActivity(i);
            }
        });
        return view;

}}
