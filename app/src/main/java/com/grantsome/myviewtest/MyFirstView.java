package com.grantsome.myviewtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tom on 2017/3/7.
 */

public class MyFirstView extends View {

    private int mColor;

    private Paint mPaintOne;

    private Paint mPaintTwo;

    private Paint mPaintThree;

    private Paint mPaintFour;

    private RectF mRectFOne;

    private RectF mRectFTwo;

    private RectF mRectFThree;

    private RectF mRectFFour;

    private RectF mRectFFive;

    private RectF mRectFSix;

    private RectF mRectFSeven;

    private RectF mRectFEight;

    private Path mPathOne;

    private Path mPathTwo;

    private Path mPathThree;

    private Path mPathFour;

    private Path mPathFive;

    private Path mPathSix;

    private Path mPathSeven;

    private Path mPathEight;

    public MyFirstView(Context context) {
        super(context);
    }

    public MyFirstView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取typedArray对象
        //关于typedArray的解释:一个数组容器,先通过obtain...方法获取属性值,然后在通过recycle()函数回收资源
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,R.styleable.MyFirstView,0,0);
        try{
            mColor = typedArray.getColor(R.styleable.MyFirstView_viewColor, Color.LTGRAY);
        }finally {
            typedArray.recycle();
        }
        initView();
    }

    public MyFirstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,R.styleable.MyFirstView,0,0);
        try{
            mColor = typedArray.getColor(R.styleable.MyFirstView_viewColor, Color.LTGRAY);
        }finally {
            typedArray.recycle();
        }
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        /*
         简要叙述一下drawCircle的参数以及作用：第一个参数：中心点的x轴,第二个参数：中心点的y轴,第三个参数：半径R
        */
        canvas.drawCircle(75,75,75,mPaintOne);
        canvas.drawCircle(250,75,75,mPaintOne);
        canvas.drawPath(mPathSeven,mPaintOne);
        canvas.drawPath(mPathEight,mPaintTwo);
        //mPaintOne.reset();//写上reset之后,如果你摁一下电源键让手机暂时停止工作(也就是让手机从屏幕正常发亮使用状态变为关闭不亮状态，然后，所有的cricle就变颜色了，全部变为黑色,所以我注释掉了它)，旋转屏幕估计也是这样子;

        canvas.drawCircle(75,250,75,mPaintTwo);
        canvas.drawCircle(250,250,75,mPaintTwo);
        canvas.drawCircle(425,250,75,mPaintTwo);
        canvas.drawPath(mPathFive,mPaintOne);
        canvas.drawCircle(600,250,75,mPaintTwo);
        canvas.drawPath(mPathSix,mPaintTwo);
        //mPaintTwo.reset();//同上

        canvas.drawOval(mRectFOne,mPaintThree);
        canvas.drawOval(mRectFTwo,mPaintThree);
        canvas.drawRect(mRectFThree,mPaintThree);
        canvas.drawRect(mRectFFour,mPaintThree);

        canvas.drawOval(mRectFFive,mPaintFour);
        canvas.drawOval(mRectFSix,mPaintFour);
        canvas.drawRect(mRectFSeven,mPaintFour);
        canvas.drawRect(mRectFEight,mPaintFour);

        canvas.drawPath(mPathOne,mPaintThree);
        canvas.drawPath(mPathTwo,mPaintThree);
        canvas.drawPath(mPathThree,mPaintFour);
        canvas.drawPath(mPathFour,mPaintFour);

        canvas.drawText("Grantsome",30,1000,mPaintOne);
    }

    private void initView(){
        /*
          简单介绍一下paint属性
          setAnitAlias设置画笔的锯齿效果(boolean 值),会消耗大量资源
          setDither是否使用图像抖动处理(更加清晰饱满)
          setColor设置画笔颜色(int)
          setARGB设置画笔的argb值
          setAplha设置绘制图形的透明度
          setStyle设置画笔风格,空心或者实心
          setStrokeWidth设置空心的边框宽度
         */
       mPaintOne = new Paint(Paint.ANTI_ALIAS_FLAG);
       mPaintOne.setColor(mColor);
       mPaintOne.setStyle(Paint.Style.FILL);

       mPaintTwo = new Paint(Paint.ANTI_ALIAS_FLAG);
       mPaintTwo.setStyle(Paint.Style.STROKE);
       mPaintTwo.setColor(mColor);

       mPaintThree = new Paint(Paint.ANTI_ALIAS_FLAG);
       mPaintThree.setColor(mColor);
       mPaintThree.setStyle(Paint.Style.FILL_AND_STROKE);

        //第一个参数是长方形的宽的起点,第二个是长的起点,第三个是宽的终点,第四个参数是长的终点
       mRectFOne = new RectF(30,350,130,550);
       mRectFTwo = new RectF(200,350,300,550);
       mRectFThree = new RectF(370,350,470,550);
       mRectFFour = new RectF(540,350,640,550);

        mPaintFour = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintFour.setColor(mColor);
        mPaintFour.setStyle(Paint.Style.STROKE);

        mRectFFive = new RectF(30,580,130,780);
        mRectFSix = new RectF(200,580,300,780);
        mRectFSeven = new RectF(370,580,470,780);
        mRectFEight = new RectF(540,580,640,780);

        mPathOne = new Path();
        mPathOne.moveTo(70,800);
        mPathOne.lineTo(0,1000);
        mPathOne.lineTo(140,1000);
        mPathOne.close();

        mPathTwo = new Path();
        mPathTwo.moveTo(250,800);
        mPathTwo.lineTo(180,1000);
        mPathTwo.lineTo(320,1000);
        mPathTwo.close();

        mPathThree = new Path();
        mPathThree.moveTo(430,800);
        mPathThree.lineTo(360,1000);
        mPathThree.lineTo(480,1000);
        mPathThree.close();

        mPathFour = new Path();
        mPathFour.moveTo(610,800);
        mPathFour.lineTo(540,1000);
        mPathFour.lineTo(660,1000);
        mPathFour.close();

        mPathFive = new Path();
        mPathFive.moveTo(425+71,250+23);//A
        mPathFive.lineTo(425+17,250+23);//F
        mPathFive.lineTo(425,250+75);//B
        mPathFive.lineTo(425-17,250+23);//G
        mPathFive.lineTo(425-71,250+23);//C
        mPathFive.lineTo(425-27,250-9);//H
        mPathFive.lineTo(425-44,250-60);//D
        mPathFive.lineTo(425,250-28);//I
        mPathFive.lineTo(425+44,250-60);//E
        mPathFive.lineTo(425+27,250-9);//J
        mPathFive.close();

        mPathSix = new Path();
        mPathSix.moveTo(600+71,250+23);//A
        mPathSix.lineTo(600+17,250+23);//F
        mPathSix.lineTo(600,250+75);//B
        mPathSix.lineTo(600-17,250+23);//G
        mPathSix.lineTo(600-71,250+23);//C
        mPathSix.lineTo(600-27,250-9);//H
        mPathSix.lineTo(600-44,250-60);//D
        mPathSix.lineTo(600,250-28);//I
        mPathSix.lineTo(600+44,250-60);//E
        mPathSix.lineTo(600+27,250-9);//J
        mPathSix.close();

        mPathSeven = new Path();
        mPathSeven.moveTo(425+71,75+23);//A
        mPathSeven.lineTo(425+17,75+23);//F
        mPathSeven.lineTo(425,75+75);//B
        mPathSeven.lineTo(425-17,75+23);//G
        mPathSeven.lineTo(425-71,75+23);//C
        mPathSeven.lineTo(425-27,75-9);//H
        mPathSeven.lineTo(425-44,75-60);//D
        mPathSeven.lineTo(425,75-28);//I
        mPathSeven.lineTo(425+44,75-60);//E
        mPathSeven.lineTo(425+27,75-9);//J
        mPathSeven.close();

        mPathEight = new Path();
        mPathEight.moveTo(600+71,75+23);//A
        mPathEight.lineTo(600+17,75+23);//F
        mPathEight.lineTo(600,75+75);//B
        mPathEight.lineTo(600-17,75+23);//G
        mPathEight.lineTo(600-71,75+23);//C
        mPathEight.lineTo(600-27,75-9);//H
        mPathEight.lineTo(600-44,75-60);//D
        mPathEight.lineTo(600,75-28);//I
        mPathEight.lineTo(600+44,75-60);//E
        mPathEight.lineTo(600+27,75-9);//J
        mPathEight.close();
    }

}
