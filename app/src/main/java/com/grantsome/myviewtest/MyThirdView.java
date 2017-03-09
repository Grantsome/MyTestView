package com.grantsome.myviewtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tom on 2017/3/8.
 */

public class MyThirdView extends View {

   private Paint mPaintCirclcImageOne;

    private Paint mPaintCirclcImageTwo;

    private Bitmap mBitmapOne;

    private Bitmap mBitmapTwo;

    private Bitmap mBitmapThree;

    private Bitmap mBitmapFour;

    private Bitmap mBitmapFive;

    private Paint mPaintOne;

    private Paint mPaintTwo;

    private Paint mPaintThree;

    private Paint mPaintFour;

    private Paint mPaintFive;

    private Paint mPaintLine;

    private BitmapShader mBitmapShaderOne;

    private BitmapShader mBitmapShaderTwo;

    private BitmapShader mBitmapShaderThird;

    private BitmapShader mBitmapShaderFour;

    private BitmapShader mBitmapShaderFive;

    public MyThirdView(Context context) {
        super(context);
    }


    public MyThirdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    public MyThirdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        mPaintCirclcImageOne = new Paint();
        mPaintCirclcImageOne.setAntiAlias(true);
        mPaintCirclcImageOne.setFilterBitmap(true);
        mPaintCirclcImageOne.setDither(true);
        mBitmapShaderOne = new BitmapShader(mBitmapOne, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaintCirclcImageOne.setShader(mBitmapShaderOne);
        mPaintCirclcImageOne.setColor(Color.WHITE);
        canvas.drawCircle(80, 80, 80, mPaintCirclcImageOne);

        mPaintCirclcImageTwo = new Paint();
        mPaintCirclcImageTwo.setAntiAlias(true);
        mPaintCirclcImageTwo.setFilterBitmap(true);
        mPaintCirclcImageTwo.setDither(true);
        mBitmapShaderTwo = new BitmapShader(mBitmapTwo, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaintCirclcImageTwo.setShader(mBitmapShaderTwo);
        canvas.drawCircle(80, 280, 80, mPaintCirclcImageTwo);

        SimpleDateFormat formatter = new SimpleDateFormat ("HH:mm");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);

        canvas.drawText("我一定在终点等你",200,70,mPaintOne);

        canvas.drawText("[WiFi在线]证明:3+4=0+0≠0恒成立",200,120,mPaintTwo);

        canvas.drawText(str,630,65,mPaintThree);

        canvas.drawCircle(660,110,20,mPaintFour);

        canvas.drawText("5",655,115,mPaintFive);

        canvas.drawLine(0,180,720,180,mPaintLine);
    }

    private void initView(){
      mBitmapOne = ((BitmapDrawable) getResources().getDrawable(R.drawable.boy_third)).getBitmap();
      mBitmapOne = Bitmap.createScaledBitmap(mBitmapOne,160,160,true);

      mBitmapTwo = ((BitmapDrawable) getResources().getDrawable(R.drawable.girl_first)).getBitmap();
      mBitmapTwo = Bitmap.createScaledBitmap(mBitmapTwo,160,160,true);

        mPaintOne = new Paint();
        mPaintOne.setColor(Color.BLACK);
        mPaintOne.setStyle(Paint.Style.FILL);
        mPaintOne.setTextSize(40);

        mPaintTwo = new Paint();
        mPaintTwo.setColor(Color.GRAY);
        mPaintTwo.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintTwo.setTextSize(22);

        mPaintThree = new Paint();
        mPaintThree.setColor(Color.GRAY);
        mPaintThree.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintThree.setTextSize(20);

        mPaintFour = new Paint();
        mPaintFour.setColor(Color.RED);
        mPaintFour.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintFour.setTextSize(20);

        mPaintFive = new Paint();
        mPaintFive.setColor(Color.BLACK);
        mPaintFive.setStyle(Paint.Style.FILL);
        mPaintFive.setTextSize(20);

        mPaintLine = new Paint();
        mPaintLine.setColor(Color.GRAY);
        mPaintLine.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintLine.setTextSize(15);

    }
}
