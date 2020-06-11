package me.posmajanius.advancemobileprogramming_uts.features;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import me.posmajanius.advancemobileprogramming_uts.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultDialog extends DialogFragment {
    private Button okBUtton;
    private TextView resultTV;



    public ResultDialog() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result_dialog, container, false);
        String resultText = "";
        okBUtton = view.findViewById(R.id.result_ok_button);
        resultTV = view.findViewById(R.id.result_text_view);

        Bundle bundle = getArguments();
        resultText = bundle.getString(LCOFaceDetection.RESULT_TEXT);

        resultTV.setText(resultText);

        okBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });



        return view;

    }

}
