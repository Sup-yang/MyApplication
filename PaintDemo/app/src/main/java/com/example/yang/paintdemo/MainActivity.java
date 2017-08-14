package com.example.yang.paintdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends GraphicsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SampleView(this));
    }


    private static class SampleView extends View{
        private Paint[] paints;
        private  Paint framPaint;
        private boolean[] userCenter;
        private RectF[] ovals;
        private RectF bigOvals;
        private float start;
        private float sweep;
        private int bigIndex;
        private static  final  float SWEEP_INC=2;
        private static  final  float START_INC=15;

        public SampleView(Context context) {
            super(context);

            paints=new Paint[4];//需要绘制的图片个数
            userCenter=new boolean[4];
            ovals=new RectF[4];

            paints[0]=new Paint();
            paints[0].setAntiAlias(true);
            paints[0].setStyle(Paint.Style.FILL);
            paints[0].setColor(0x88FF0000);
            userCenter[0]=false;

            paints[1]=new Paint(paints[0]);
            paints[1].setColor(Color.BLUE);
            userCenter[1]=true;

            paints[2]=new Paint(paints[0]);
            paints[2].setStyle(Paint.Style.STROKE);
            paints[2].setStrokeWidth(4);
            paints[2].setColor(Color.GREEN);
            userCenter[2]=false;


            paints[3]=new Paint(paints[2]);
            paints[3].setColor(Color.DKGRAY);
            userCenter[3]=true;

            bigOvals=new RectF(40,10,280,250);

            ovals[0]=new RectF(10,270,70,330);
            ovals[1]=new RectF(90,270,150,330);
            ovals[2]=new RectF(170,270,230,330);
            ovals[3]=new RectF(250,270,310,330);

            framPaint=new Paint();
            framPaint.setAntiAlias(true);
            framPaint.setStyle(Paint.Style.STROKE);
            framPaint.setStrokeWidth(0);


        }
        private void drawArcs(Canvas canvas,RectF ovals,boolean usecenter,Paint paint){
            canvas.drawRect(ovals,framPaint);
            canvas.drawArc(ovals,start,sweep,usecenter,paint);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);

            drawArcs(canvas, bigOvals, userCenter[bigIndex],
                    paints[bigIndex]);

            for (int i = 0; i < 4; i++) {
                drawArcs(canvas, ovals[i], userCenter[i], paints[i]);
            }

            sweep += SWEEP_INC;
            if (sweep > 360) {
                sweep -= 360;
                start += START_INC;
                if (start >= 360) {
                    start -= 360;
                }
                bigIndex = (bigIndex + 1) % ovals.length;
            }
            invalidate();
        }
    }

}
