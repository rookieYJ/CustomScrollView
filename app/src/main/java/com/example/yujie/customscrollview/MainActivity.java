package com.example.yujie.customscrollview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ObservableScrollView scrollView;
    private ImageView iv;
    private LinearLayout head;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        head = findViewById(R.id.head);
        head.bringToFront();
        scrollView = findViewById(R.id.scrollView);
        iv = findViewById(R.id.iv);
        iv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                height = iv.getHeight();
            }
        });

        scrollView.setObservableScrollViewListener(new ObservableScrollView.ObservableScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt) {
                Log.d("MainActivity", "t:" + t);
                if(t <= 0){
                    head.setVisibility(View.GONE);
                }else if(t > 0 && t < height){
                    head.setVisibility(View.VISIBLE);
                    head.setBackgroundColor(Color.argb( (int)(t*255/height), 0, 0, 255));
                }
            }
        });
    }
}
