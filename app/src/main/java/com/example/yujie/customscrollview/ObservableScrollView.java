package com.example.yujie.customscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by yujie on 2018/2/2.
 */

public class ObservableScrollView extends ScrollView {

    private ObservableScrollViewListener listener;

    public ObservableScrollView(Context context) {
        this(context, null);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        listener.onScrollChanged(this, l, t, oldl, oldt);
    }

    public interface ObservableScrollViewListener{
        void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt);
    }

    public void setObservableScrollViewListener(ObservableScrollViewListener listener){
        this.listener = listener;
    }

}
