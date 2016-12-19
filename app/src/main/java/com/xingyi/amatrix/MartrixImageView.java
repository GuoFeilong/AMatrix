package com.xingyi.amatrix;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by feilong.guo on 16/12/19.
 */

public class MartrixImageView extends View {
    private static final long ANIM_TIME = 500;
    private Matrix matrix;
    private Camera camera;
    private Bitmap bitmap;
    private Paint mPaint;
    private int matrixDegree;
    private int currentMatrix;
    private boolean openState;
    private OpenListener openListener;

    public MartrixImageView(Context context) {
        this(context, null);
    }

    public MartrixImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MartrixImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        matrix = new Matrix();
        camera = new Camera();
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setMatrixBitmap(canvas);
    }

    private void setMatrixBitmap(Canvas canvas) {
        if (bitmap != null) {
            matrix.reset();
            camera.save();
            camera.rotateX(currentMatrix);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-getWidth() / 2, -getHeight() / 2);
            matrix.postTranslate(getWidth() / 2, getHeight() / 2);
            canvas.drawBitmap(bitmap, matrix, mPaint);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


    public void setMatrixDegree(int matrixDegree) {
        this.matrixDegree = matrixDegree;
        animMartrix();
    }

    private void animMartrix() {
        openState = !openState;
        if (openListener != null) {
            openListener.openOrClose(openState);
        }
        ValueAnimator valueAnimator;
        if (openState) {
            valueAnimator = ValueAnimator.ofFloat(0, 1.F);
        } else {
            valueAnimator = ValueAnimator.ofFloat(1.F, 0);

        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float percent = Float.valueOf(animation.getAnimatedValue().toString());
                currentMatrix = (int) (percent * matrixDegree);
                invalidate();
            }
        });
        valueAnimator.setDuration(ANIM_TIME);
        valueAnimator.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                animMartrix();
                break;
        }
        return true;
    }

    public boolean isOpenState() {
        return openState;
    }

    public interface OpenListener{
        void openOrClose(boolean open);
    }

    public void setOpenListener(OpenListener openListener) {
        this.openListener = openListener;
    }
}
