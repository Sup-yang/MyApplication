package com.example.yang.wuxinghaoping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {
RatingBar smallRating;
    RatingBar indicatorRating;
TextView ratingtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingtext= (TextView) findViewById(R.id.rating_text);
        smallRating= (RatingBar) findViewById(R.id.small_rating);
        indicatorRating= (RatingBar) findViewById(R.id.indicator_rating);
        ((RatingBar)findViewById(R.id.sanxing)).setOnRatingBarChangeListener(this);
        ((RatingBar)findViewById(R.id.wuxing)).setOnRatingBarChangeListener(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        final int number=ratingBar.getNumStars();
        ratingtext.setText("Rating:"+""+rating+"/"+number);

        //显示星星的数量
        if (indicatorRating.getNumStars()!=number){
            indicatorRating.setNumStars(number);
            smallRating.setNumStars(number);

        }

        //指定当前分数，也可以在代码中控制
        if (indicatorRating.getRating()!=rating){
            indicatorRating.setRating(rating);
            smallRating.setRating(rating);
        }


        // 指定分数的数量增长单位，默认为0.5
        final float ratingsize=ratingBar.getStepSize();

        if (indicatorRating.getStepSize()!=ratingsize){
            indicatorRating.setStepSize(ratingsize);
            smallRating.setStepSize(ratingsize);

        }

    }
}
