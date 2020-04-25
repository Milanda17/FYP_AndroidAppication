

package org.tensorflow.lite.examples.classification.indoormap;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    private Paint paint;
    public interface OnToggledListener {
        void OnToggled(MyView v, boolean touchOn);
    }


    private OnToggledListener toggledListener;


    public MyView(Context context, int x, int y) {
        super(context);

    }

    public MyView(Context context) {
        super(context);
       // paint = new Paint();
        //paint.setColor(Color.GRAY);

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }








  /*  @Override
    protected void onDraw(Canvas canvas) {

       // canvas.drawColor(Color.BLUE);
        canvas.drawCircle(200, 200, 100, paint);

        /*mRectSquare.left = 50;
        mRectSquare.top = 50;
        mRectSquare.right = mRectSquare.left + mSquareSize;
        mRectSquare.bottom = mRectSquare.top + mSquareSize;

        canvas.drawRect(mRectSquare, mPaintSquare);
    }*/




}