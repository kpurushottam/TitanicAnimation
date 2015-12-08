package com.krp.sample.animation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by purushottam.kumar on 9/11/2015.
 */
public class TitanicImageView extends ImageView {

    public interface AnimationSetupCallback {
        public void onSetupAnimation(TitanicImageView titanicTextView);
    }

    // callback fired at first onSizeChanged
    private AnimationSetupCallback animationSetupCallback;
    // wave shader coordinates
    private float maskX, maskY;
    // if true, the shader will display the wave
    private boolean sinking;
    // true after the first onSizeChanged
    private boolean setUp;

    private Paint paint;

    // shader containing a repeated wave
    private BitmapShader shader;
    // shader matrix
    private Matrix shaderMatrix;
    // wave drawable
    private Drawable wave;
    // (getHeight() - waveHeight) / 2
    private float offsetY;

    public TitanicImageView(Context context) {
        super(context);
        init();
    }

    public TitanicImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitanicImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        shaderMatrix = new Matrix();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public AnimationSetupCallback getAnimationSetupCallback() {
        return animationSetupCallback;
    }

    public void setAnimationSetupCallback(AnimationSetupCallback animationSetupCallback) {
        this.animationSetupCallback = animationSetupCallback;
    }

    public float getMaskX() {
        return maskX;
    }

    public void setMaskX(float maskX) {
        this.maskX = maskX;
        invalidate();
    }

    public float getMaskY() {
        return maskY;
    }

    public void setMaskY(float maskY) {
        this.maskY = maskY;
        invalidate();
    }

    public boolean isSinking() {
        return sinking;
    }

    public void setSinking(boolean sinking) {
        this.sinking = sinking;
    }

    public boolean isSetUp() {
        return setUp;
    }

    /**
     * Create the shader
     * draw the wave with current color for a background
     * repeat the bitmap horizontally, and clamp colors vertically
     */
    private void createShader() {

        if (wave == null) {
            wave = getResources().getDrawable(R.drawable.red);
        }

        int waveW = wave.getIntrinsicWidth();
        int waveH = wave.getIntrinsicHeight();

        Bitmap b = Bitmap.createBitmap(waveW, waveH, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);

        wave.setBounds(0, 0, waveW, waveH);
        wave.draw(c);

        shader = new BitmapShader(b, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);

        offsetY = (getHeight() - waveH) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // modify text paint shader according to sinking state
        /*if (sinking && shader != null) {

            // first call after sinking, assign it to our paint
            if (paint.getShader() == null) {
                paint.setShader(shader);
            }

            // translate shader accordingly to maskX maskY positions
            // maskY is affected by the offset to vertically center the wave
            shaderMatrix.setTranslate(maskX, maskY + offsetY);

            // assign matrix to invalidate the shader
            shader.setLocalMatrix(shaderMatrix);
        } else {
            paint.setShader(null);
        }*/
        /*Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.red);

        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
//        paint.setShader(shader);
//        canvas.drawBitmap(bitmap, 10, 10, paint);
        canvas.drawLine(0,0,100,100,paint);*/


        Bitmap bitmap3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.img)).getBitmap();
        Bitmap copy3 = bitmap3.copy(bitmap3.getConfig(), true);

        for(int i=0; i<getWidth(); i++) {
            for(int j=0; j<bitmap3.getHeight(); j++) {
                if(copy3.getPixel(i,j) != 0) {
                    // is not transparent
                    copy3.setPixel(i, j, Color.RED);
                }
            }
        }

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);

        canvas.drawBitmap(copy3, copy3.getWidth(), copy3.getHeight(), paint);

        super.onDraw(canvas);
    }

    private int width;
    public void setWidth(int width) {
        this.width = width;
        invalidate();
    }
}