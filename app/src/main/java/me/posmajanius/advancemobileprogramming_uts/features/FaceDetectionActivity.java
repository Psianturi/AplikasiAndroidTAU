package me.posmajanius.advancemobileprogramming_uts.features;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;


import java.util.List;

import me.posmajanius.advancemobileprogramming_uts.R;


public class FaceDetectionActivity extends AppCompatActivity {
    private Button cameraButton;
    private final static int REQUEST_IMAGE_CAPTURE = 1234;
    private FirebaseVisionImage image;
    private FirebaseVisionFaceDetector detector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_detection);

        FirebaseApp.initializeApp(this);
        cameraButton =findViewById(R.id.camera_button);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) !=null){
                    startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            detectFaces(bitmap);
        }
    }

    private void detectFaces(Bitmap bitmap) {

        FirebaseVisionFaceDetectorOptions highAccuracyOpts;
        highAccuracyOpts = new FirebaseVisionFaceDetectorOptions.Builder()
                .setPerformanceMode(FirebaseVisionFaceDetectorOptions.ACCURATE)
                .setLandmarkMode(FirebaseVisionFaceDetectorOptions.NO_LANDMARKS)
                .setClassificationMode(FirebaseVisionFaceDetectorOptions.ALL_CLASSIFICATIONS)
                .setMinFaceSize(0.12f)
                .setContourMode(FirebaseVisionFaceDetectorOptions.ALL_CONTOURS)
                .enableTracking()
                .build();

        try {
            image = FirebaseVisionImage.fromBitmap(bitmap);
            detector = FirebaseVision.getInstance()
                    .getVisionFaceDetector(highAccuracyOpts);
        } catch (Exception e) {
            e.printStackTrace();
        }

        detector.detectInImage(image).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionFace>>() {
            @Override
            public void onSuccess(List<FirebaseVisionFace> firebaseVisionFaces) {
                String resultText= "Persentasi Wajah";
                int i = 1;
                for (FirebaseVisionFace face: firebaseVisionFaces){
                    resultText = resultText.concat("\n"+i+".")
                            .concat("\nSmile: " + face.getSmilingProbability()*100+"%")
                            .concat("\nLeft Eye: "+ face.getLeftEyeOpenProbability()*100+"%")
                            .concat("\nRight Eye: "+ face.getRightEyeOpenProbability()*100+"%")
                            .concat("\nHead Angle Y: "+ face.getHeadEulerAngleY()*100+"%")
                            .concat("\nHead Angle Z: "+ face.getHeadEulerAngleZ()*100+"%");

                    i++;
                }
                if (firebaseVisionFaces.size() == 0){
                    Toast.makeText(FaceDetectionActivity.this, "No Faces", Toast.LENGTH_SHORT).show();
                }else {
                    Bundle bundle = new Bundle();
                    bundle.putString(LCOFaceDetection.RESULT_TEXT, resultText);
                    DialogFragment resultDialog = new ResultDialog();
                    resultDialog.setArguments(bundle);
                    resultDialog.setCancelable(false);
                    resultDialog.show(getSupportFragmentManager(), LCOFaceDetection.RESULT_DIALOG);
                }
            }
        });
    }

}
