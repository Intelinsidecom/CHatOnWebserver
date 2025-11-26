package com.sec.chaton.calllog.common.view.swipe;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class SwipeUILayout extends FrameLayout {

    /* renamed from: a */
    private View f3187a;

    /* renamed from: b */
    private View f3188b;

    /* renamed from: c */
    private View f3189c;

    /* renamed from: d */
    private View f3190d;

    /* renamed from: e */
    private View f3191e;

    /* renamed from: f */
    private ImageView f3192f;

    /* renamed from: g */
    private ImageView f3193g;

    /* renamed from: h */
    private TextView f3194h;

    /* renamed from: i */
    private boolean f3195i;

    /* renamed from: j */
    private int f3196j;

    public SwipeUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3195i = true;
        m4408a(context);
        m4412a();
    }

    /* renamed from: a */
    private void m4408a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.swipe_layout, (ViewGroup) this, true);
        this.f3187a = findViewById(R.id.left);
        this.f3188b = findViewById(R.id.left_gradient);
        this.f3189c = findViewById(R.id.center);
        this.f3190d = findViewById(R.id.right_gradient);
        this.f3191e = findViewById(R.id.right);
        this.f3192f = (ImageView) findViewById(R.id.icon_right);
        this.f3193g = (ImageView) findViewById(R.id.icon_left);
        this.f3193g.setVisibility(8);
        this.f3194h = (TextView) findViewById(R.id.swipe_text);
        this.f3187a.setVisibility(8);
        this.f3188b.setVisibility(8);
        this.f3189c.setVisibility(8);
        this.f3190d.setVisibility(8);
        this.f3191e.setVisibility(8);
    }

    public void setVideoEventUI(boolean z) {
        this.f3195i = z;
    }

    /* renamed from: a */
    public final void m4412a() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f3196j = point.x;
    }

    /* renamed from: b */
    public int m4415b() {
        return this.f3188b.getWidth() + this.f3196j;
    }

    /* renamed from: a */
    private void m4409a(View view, int i) {
        if (view.getVisibility() == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, i, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(500L);
            view.startAnimation(translateAnimation);
        }
    }

    /* renamed from: a */
    public void m4413a(float f) {
        int width = (((int) f) - this.f3188b.getWidth()) - this.f3196j;
        m4409a(this.f3189c, width);
        m4409a(this.f3188b, width);
        m4409a(this.f3187a, width);
        m4409a(this.f3190d, width);
        m4409a(this.f3191e, width);
    }

    /* renamed from: b */
    public void m4416b(float f) {
        int width = (this.f3188b.getWidth() + this.f3196j) - ((int) f);
        m4409a(this.f3189c, width);
        m4409a(this.f3188b, width);
        m4409a(this.f3187a, width);
        m4409a(this.f3190d, width);
        m4409a(this.f3191e, width);
    }

    /* renamed from: c */
    public void m4417c(float f) {
        m4409a(this.f3189c, (int) (-f));
        m4409a(this.f3188b, (int) (-f));
        m4409a(this.f3187a, (int) (-f));
        m4409a(this.f3190d, (int) (-f));
        m4409a(this.f3191e, (int) (-f));
    }

    /* renamed from: a */
    public void m4414a(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3189c.getLayoutParams();
        if (i > 0) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = -i;
            m4410b(i);
        } else {
            layoutParams.rightMargin = -i;
            layoutParams.leftMargin = i;
            m4411c(-i);
        }
        this.f3189c.setLayoutParams(layoutParams);
    }

    public void setCenterMessage(String str) {
        this.f3194h.setText(str);
    }

    /* renamed from: b */
    private void m4410b(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3188b.getLayoutParams();
        layoutParams.leftMargin = i - layoutParams.width;
        layoutParams.rightMargin = this.f3196j - i;
        this.f3188b.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f3187a.getLayoutParams();
        layoutParams2.rightMargin = (this.f3196j + layoutParams.width) - i;
        layoutParams2.leftMargin = (i - this.f3196j) - layoutParams.width;
        this.f3187a.setLayoutParams(layoutParams2);
        if (this.f3195i) {
            this.f3194h.setText(getResources().getString(R.string.call_btn_voicecall));
        } else {
            this.f3194h.setText(getResources().getString(R.string.call_btn_videocall));
        }
        if (i > layoutParams.width * 2) {
            this.f3194h.setAlpha(1.0f);
        } else {
            this.f3194h.setAlpha(i / (2.0f * layoutParams.width));
        }
        this.f3192f.setAlpha(MotionEventCompat.ACTION_MASK);
        if (i <= layoutParams.width) {
            int i2 = ((layoutParams.width - i) * 256) / layoutParams.width;
        }
        this.f3190d.setVisibility(8);
        this.f3191e.setVisibility(8);
        this.f3189c.setVisibility(0);
        this.f3188b.setVisibility(0);
        this.f3187a.setVisibility(0);
    }

    /* renamed from: c */
    private void m4411c(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3190d.getLayoutParams();
        layoutParams.leftMargin = this.f3196j - i;
        layoutParams.rightMargin = i - layoutParams.width;
        this.f3190d.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f3191e.getLayoutParams();
        layoutParams2.rightMargin = (i - this.f3196j) - layoutParams.width;
        layoutParams2.leftMargin = (this.f3196j + layoutParams.width) - i;
        this.f3191e.setLayoutParams(layoutParams2);
        this.f3194h.setText(getResources().getString(R.string.call_btn_chatting));
        if (i > layoutParams.width * 2) {
            this.f3194h.setAlpha(1.0f);
        } else {
            this.f3194h.setAlpha(i / (2.0f * layoutParams.width));
        }
        if (i > layoutParams.width) {
            this.f3192f.setAlpha(0);
        } else {
            this.f3192f.setAlpha(((layoutParams.width - i) * 256) / layoutParams.width);
        }
        this.f3187a.setVisibility(8);
        this.f3188b.setVisibility(8);
        this.f3189c.setVisibility(0);
        this.f3190d.setVisibility(0);
        this.f3191e.setVisibility(0);
    }
}
