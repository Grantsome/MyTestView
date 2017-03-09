package com.grantsome.myviewtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by tom on 2017/3/7.
 */

public class MySecondView extends View {

    private String mText;

    private int mTextColor;

    private int mTextSize;

    private Paint mPaintOne;

    private Paint mPaintTwo;

    private Rect mRect;

    public MySecondView(Context context) {
        super(context);
    }

    public MySecondView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,R.styleable.MySecondView,0,0);
        try {
            mText = typedArray.getString(R.styleable.MySecondView_viewText);
            mTextColor = typedArray.getColor(R.styleable.MySecondView_viewTextColor, Color.RED);
            //TypedValue.applyDimension是一个将各种单位的值转换为像素的方法,其中的三个参数分别为DisplayMetrics是一个获取屏幕信息的类，第一个参数是指第二个参数的单位，第二个参数是int的值
            mTextSize = typedArray.getDimensionPixelSize(R.styleable.MySecondView_viewTextSize,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
        }finally {
            typedArray.recycle();
        }
        initView();

    }

    public MySecondView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,R.styleable.MySecondView,0,0);
        try {
            mText = typedArray.getString(R.styleable.MySecondView_viewText);
            mTextColor = typedArray.getColor(R.styleable.MySecondView_viewTextColor, Color.RED);
            mTextSize = typedArray.getDimensionPixelSize(R.styleable.MySecondView_viewTextSize,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
        }finally {
            typedArray.recycle();
        }
        initView();
    }

    /*
    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if(widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }else {
            mPaintOne.setTextSize(mTextSize);
            mRect = new Rect();
            mPaintOne.getTextBounds(mText,0,mText.length(),mRect);
            float textWidth = mRect.width();
            width = (int) (textWidth);
        }

        if(heightMode == MeasureSpec.EXACTLY){
            height = heightSize;
        }else {
            mPaintOne.setTextSize(mTextSize);
            mRect = new Rect();
            mPaintOne.getTextBounds(mText,0,mText.length(),mRect);
            float textHeight = mRect.height();
            height = (int) (textHeight);
        }

        setMeasuredDimension(width,height);
    }
     */

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(40,0,420,100,mPaintTwo);
        canvas.drawText(mText,50,30,mPaintOne);
    }

    public void initView(){
        mPaintTwo = new Paint();
        mPaintTwo.setColor(Color.BLUE);

        mPaintOne = new Paint();
        mPaintOne.setColor(mTextColor);
        mPaintOne.setStyle(Paint.Style.FILL);
        mPaintOne.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintOne.setTextSize(mTextSize);

    }

}
