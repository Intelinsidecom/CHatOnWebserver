package com.sec.chaton.calllog.common.view.swipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
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

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SwipeUILayout extends FrameLayout {

    /* renamed from: a */
    private View f5157a;

    /* renamed from: b */
    private View f5158b;

    /* renamed from: c */
    private View f5159c;

    /* renamed from: d */
    private View f5160d;

    /* renamed from: e */
    private View f5161e;

    /* renamed from: f */
    private ImageView f5162f;

    /* renamed from: g */
    private ImageView f5163g;

    /* renamed from: h */
    private TextView f5164h;

    /* renamed from: i */
    private boolean f5165i;

    /* renamed from: j */
    private int f5166j;

    public SwipeUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5165i = true;
        m7562a(context);
        m7566a();
    }

    /* renamed from: a */
    private void m7562a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.swipe_layout, (ViewGroup) this, true);
        this.f5157a = findViewById(R.id.left);
        this.f5158b = findViewById(R.id.left_gradient);
        this.f5159c = findViewById(R.id.center);
        this.f5160d = findViewById(R.id.right_gradient);
        this.f5161e = findViewById(R.id.right);
        this.f5162f = (ImageView) findViewById(R.id.icon_right);
        this.f5163g = (ImageView) findViewById(R.id.icon_left);
        this.f5163g.setVisibility(8);
        this.f5164h = (TextView) findViewById(R.id.swipe_text);
        this.f5157a.setVisibility(8);
        this.f5158b.setVisibility(8);
        this.f5159c.setVisibility(8);
        this.f5160d.setVisibility(8);
        this.f5161e.setVisibility(8);
    }

    public void setVideoEventUI(boolean z) {
        this.f5165i = z;
    }

    /* renamed from: a */
    public final void m7566a() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f5166j = point.x;
    }

    /* renamed from: b */
    public int m7569b() {
        return this.f5158b.getWidth() + this.f5166j;
    }

    /* renamed from: a */
    private void m7563a(View view, int i) {
        if (view.getVisibility() == 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, i, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(500L);
            view.startAnimation(translateAnimation);
        }
    }

    /* renamed from: a */
    public void m7567a(float f) {
        int width = (((int) f) - this.f5158b.getWidth()) - this.f5166j;
        m7563a(this.f5159c, width);
        m7563a(this.f5158b, width);
        m7563a(this.f5157a, width);
        m7563a(this.f5160d, width);
        m7563a(this.f5161e, width);
    }

    /* renamed from: b */
    public void m7570b(float f) {
        int width = (this.f5158b.getWidth() + this.f5166j) - ((int) f);
        m7563a(this.f5159c, width);
        m7563a(this.f5158b, width);
        m7563a(this.f5157a, width);
        m7563a(this.f5160d, width);
        m7563a(this.f5161e, width);
    }

    /* renamed from: c */
    public void m7571c(float f) {
        m7563a(this.f5159c, (int) (-f));
        m7563a(this.f5158b, (int) (-f));
        m7563a(this.f5157a, (int) (-f));
        m7563a(this.f5160d, (int) (-f));
        m7563a(this.f5161e, (int) (-f));
    }

    /* renamed from: a */
    public void m7568a(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5159c.getLayoutParams();
        if (i > 0) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = -i;
            m7564b(i);
        } else {
            layoutParams.rightMargin = -i;
            layoutParams.leftMargin = i;
            m7565c(-i);
        }
        this.f5159c.setLayoutParams(layoutParams);
    }

    public void setCenterMessage(String str) {
        this.f5164h.setText(str);
    }

    /* renamed from: b */
    private void m7564b(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5158b.getLayoutParams();
        layoutParams.leftMargin = i - layoutParams.width;
        layoutParams.rightMargin = this.f5166j - i;
        this.f5158b.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f5157a.getLayoutParams();
        layoutParams2.rightMargin = (this.f5166j + layoutParams.width) - i;
        layoutParams2.leftMargin = (i - this.f5166j) - layoutParams.width;
        this.f5157a.setLayoutParams(layoutParams2);
        if (this.f5165i) {
            this.f5164h.setText(getResources().getString(R.string.call_btn_voicecall));
        } else {
            this.f5164h.setText(getResources().getString(R.string.call_btn_videocall));
        }
        if (i > layoutParams.width * 2) {
            this.f5164h.setAlpha(1.0f);
        } else {
            this.f5164h.setAlpha(i / (2.0f * layoutParams.width));
        }
        this.f5162f.setAlpha(255);
        if (i <= layoutParams.width) {
            int i2 = ((layoutParams.width - i) * 256) / layoutParams.width;
        }
        this.f5160d.setVisibility(8);
        this.f5161e.setVisibility(8);
        this.f5159c.setVisibility(0);
        this.f5158b.setVisibility(0);
        this.f5157a.setVisibility(0);
    }

    /* renamed from: c */
    private void m7565c(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5160d.getLayoutParams();
        layoutParams.leftMargin = this.f5166j - i;
        layoutParams.rightMargin = i - layoutParams.width;
        this.f5160d.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f5161e.getLayoutParams();
        layoutParams2.rightMargin = (i - this.f5166j) - layoutParams.width;
        layoutParams2.leftMargin = (this.f5166j + layoutParams.width) - i;
        this.f5161e.setLayoutParams(layoutParams2);
        this.f5164h.setText(getResources().getString(R.string.call_btn_chatting));
        if (i > layoutParams.width * 2) {
            this.f5164h.setAlpha(1.0f);
        } else {
            this.f5164h.setAlpha(i / (2.0f * layoutParams.width));
        }
        if (i > layoutParams.width) {
            this.f5162f.setAlpha(0);
        } else {
            this.f5162f.setAlpha(((layoutParams.width - i) * 256) / layoutParams.width);
        }
        this.f5157a.setVisibility(8);
        this.f5158b.setVisibility(8);
        this.f5159c.setVisibility(0);
        this.f5160d.setVisibility(0);
        this.f5161e.setVisibility(0);
    }
}
