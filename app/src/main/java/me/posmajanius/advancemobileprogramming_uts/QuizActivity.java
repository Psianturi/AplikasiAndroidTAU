package me.posmajanius.advancemobileprogramming_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    Button mTrueButton;
    Button mFalseButton;
    TextView mPertanyaanTextView;
    TextView mSkorTextView;
    ProgressBar mProsesBar;
    int mIndex;
    int mScore;
    int mPertanyaan;



    private TrueFalse[] mBankPertanyaan = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, false)
    };


    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / mBankPertanyaan.length);

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //skor tidak berubah menjadi nol, tetapi meneruskan saat diputar landscape
        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt("SkorKey");
            mIndex = savedInstanceState.getInt("IndexKey");
        } else {
            mScore = 0;
            mIndex = 0;

        }

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mPertanyaanTextView = findViewById(R.id.question_text_view);
        mSkorTextView = findViewById(R.id.score);
        mProsesBar =findViewById(R.id.progress_bar);


        mPertanyaan = mBankPertanyaan[mIndex].getPertanyaanID();

        mPertanyaanTextView.setText(mPertanyaan);
        mSkorTextView.setText("Skor :" + mScore + "/" + mBankPertanyaan.length);

        mTrueButton.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                checkJawaban(true);
                updatePertanyaan();
            }
        });

        mFalseButton.setOnClickListener((new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                updatePertanyaan();
                checkJawaban(false);
            }
        }));

    }
    @SuppressLint("SetTextI18n")
    private void updatePertanyaan() {
        mIndex = (mIndex + 1) % mBankPertanyaan.length;

        if (mIndex == 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Selesai");
            alert.setCancelable(false);
            alert.setMessage("Skor Anda :" + mScore + "poin!");
            alert.setPositiveButton("Keluar Kuis", new DialogInterface.OnClickListener( ) {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        mPertanyaan = mBankPertanyaan[mIndex].getPertanyaanID();
        mPertanyaanTextView.setText(mPertanyaan);
        mProsesBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mSkorTextView.setText("Skor :" + mScore + "/" + mBankPertanyaan.length);
    }
    private void checkJawaban(boolean userSelection) {
        boolean jawabanBenar = mBankPertanyaan[mIndex].isJawaban();
        if (userSelection == jawabanBenar){
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            mScore = mScore + 1;
        } else{
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        //untuk save tampilan dan skor, saat hp diputar menjadi landscape
        outState.putInt("SkorKey", mScore);
        outState.putInt("IndexKey", mIndex);
    }

    class TrueFalse {
        private int mPertanyaanID;
        private boolean mJawaban;

        TrueFalse(int questionResourceID, boolean trueOrFalse) {
            mPertanyaanID = questionResourceID;
            mJawaban = trueOrFalse;
        }

        int getPertanyaanID() {
            return mPertanyaanID;
        }

        boolean isJawaban() {
            return mJawaban;
        }

    }

}
