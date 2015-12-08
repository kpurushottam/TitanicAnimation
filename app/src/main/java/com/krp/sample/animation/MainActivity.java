package com.krp.sample.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        /*final TitanicTextView tv = (TitanicTextView) findViewById(R.id.my_text_view);
        final TitanicImageView iv = (TitanicImageView) findViewById(R.id.iv);


        // start animation
//        new Titanic().start(tv);
        new TitanicImage().start(iv);


        Bitmap bitmap1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.img)).getBitmap();
        Bitmap copy1 = bitmap1.copy(bitmap1.getConfig(), true);

        for(int i=0; i<bitmap1.getWidth()/4; i++) {
            for(int j=0; j<bitmap1.getHeight(); j++) {
                if(copy1.getPixel(i,j) != 0) {
                    // is not transparent
                    copy1.setPixel(i, j, Color.RED);
                }
            }
        }
        ((ImageView) findViewById(R.id.car1)).setImageBitmap(copy1);

        Bitmap bitmap2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.img)).getBitmap();
        Bitmap copy2 = bitmap2.copy(bitmap2.getConfig(), true);

        for(int i=0; i<bitmap2.getWidth()/2; i++) {
            for(int j=0; j<bitmap2.getHeight(); j++) {
                if(copy2.getPixel(i,j) != 0) {
                    // is not transparent
                    copy2.setPixel(i, j, Color.RED);
                }
            }
        }
        ((ImageView) findViewById(R.id.car2)).setImageBitmap(copy2);

        Bitmap bitmap3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.img)).getBitmap();
        Bitmap copy3 = bitmap3.copy(bitmap3.getConfig(), true);

        for(int i=0; i<bitmap3.getWidth(); i++) {
            for(int j=0; j<bitmap3.getHeight(); j++) {
                if(copy3.getPixel(i,j) != 0) {
                    // is not transparent
                    copy3.setPixel(i, j, Color.RED);
                }
            }
        }
        ((ImageView) findViewById(R.id.car3)).setImageBitmap(copy3);
    }
}
