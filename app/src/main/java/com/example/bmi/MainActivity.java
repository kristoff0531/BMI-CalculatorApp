package com.example.bmi;

import static com.example.bmi.R.color.Red;
import static com.example.bmi.R.color.orange;
import static com.example.bmi.R.color.teal_200;
import static com.example.bmi.R.color.yellow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightFt,edtHeightIn;
        TextView txtResult;
        Button btnCal,btnClear;
        LinearLayout LlMain;
        LottieAnimationView laView;


        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btnCal=findViewById(R.id.btnCal);
        txtResult=findViewById(R.id.txtResult);
//        LlMain=findViewById(R.id.LlMain);
        btnClear=findViewById(R.id.btnClear);
        laView=findViewById(R.id.lottie_animation);


        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt( edtWeight.getText().toString());
                int ft=Integer.parseInt(edtHeightFt.getText().toString());
                int in=Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn=ft*12 + in;
                double totalcm=totalIn*2.5;

                double totalmeter=totalcm/100;
                double bmi=wt/(totalmeter*totalmeter);

                if (bmi>25){
                    txtResult.setText("High BMI---> OVERWEIGHT");

//                    LlMain.setBackgroundColor(getResources().getColor(Red));
                    txtResult.setTextColor(getResources().getColor(Red));
                    laView.setAnimation(R.raw.lottie_redweight);
                    laView.playAnimation();


                }
                else if(bmi<=18){
                    txtResult.setText("LOW BMI---> UNDERWEIGHT");

                    txtResult.setTextColor(getResources().getColor(orange));
                    laView.setAnimation(R.raw.lottie_yellowweight);
                    laView.playAnimation();
                }
                else{
                    txtResult.setText("NORMAl--->HEALTHY");

                    txtResult.setTextColor(getResources().getColor(teal_200));
                    laView.setAnimation(R.raw.lottie_gainweight);
                    laView.playAnimation();

                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtWeight.setText("");
                edtHeightFt.setText("");
                edtHeightIn.setText("");
                txtResult.setText("");

//                LlMain.setBackgroundColor(getResources().getColor(R.color.white));
                laView.setAnimation(R.raw.lottie_weightmachine);
                laView.playAnimation();
            }
        });


    }

}