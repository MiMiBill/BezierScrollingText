package com.yun.activie.anim.lib;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class MainActivity extends AppCompatActivity {


    private View iv_circle_pan_center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_circle_pan_center = findViewById(R.id.iv_circle_pan_center);
        startRotate(iv_circle_pan_center);
    }

    public void startRotate(View view) {

        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 0, 720);
        // 动画的持续时间，执行多久？
        anim.setDuration(1500);
        anim.setRepeatCount(-1);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
//        final float[] f = {0};
//        anim.setInterpolator(new TimeInterpolator() {
//            @Override
//            public float getInterpolation(float t) {
////                float f1 = ( float ) (Math.cos((t + 1) * Math.PI) / 2.0f) + 0.5f;
////                Log.e("HHHHHHHh", "" + t + "     " + (f[0] - f1));
//                f[0] = ( float ) (Math.cos((t + 1) * Math.PI) / 2.0f) + 0.5f;
//                return f[0];
//            }
//        });
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //当旋转结束的时候回调给调用者当前所选择的内容

            }
        });
        // 正式开始启动执行动画
        anim.start();
    }
}