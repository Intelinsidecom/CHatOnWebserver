package com.sec.chaton.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.EnumC1748bd;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ProfileImageView extends ImageView {

    /* renamed from: a */
    int f6476a;

    /* renamed from: b */
    ArrayList f6477b;

    /* renamed from: c */
    private Context f6478c;

    /* renamed from: d */
    private String f6479d;

    /* renamed from: e */
    private String f6480e;

    /* renamed from: f */
    private View.OnClickListener f6481f;

    /* renamed from: g */
    private View.OnClickListener f6482g;

    public ProfileImageView(Context context) {
        super(context);
        this.f6480e = null;
        this.f6476a = 0;
        this.f6477b = new ArrayList();
        this.f6481f = new ViewOnClickListenerC1802f(this);
        this.f6482g = new ViewOnClickListenerC1803g(this);
        this.f6478c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6480e = null;
        this.f6476a = 0;
        this.f6477b = new ArrayList();
        this.f6481f = new ViewOnClickListenerC1802f(this);
        this.f6482g = new ViewOnClickListenerC1803g(this);
        this.f6478c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6480e = null;
        this.f6476a = 0;
        this.f6477b = new ArrayList();
        this.f6481f = new ViewOnClickListenerC1802f(this);
        this.f6482g = new ViewOnClickListenerC1803g(this);
        this.f6478c = context;
    }

    public void setBuddyNo(String str) {
        this.f6479d = str;
    }

    public void setBuddyName(String str) {
        this.f6480e = str;
    }

    /* renamed from: a */
    public void m6129a(View view, EnumC0695j enumC0695j) {
        switch (enumC0695j) {
            case ONETOONE:
                C1746bb.m5945a(getContext()).m5958a((ImageView) view, EnumC1748bd.BUDDY);
                setOnClickListener(this.f6482g);
                break;
            case GROUPCHAT:
                if (GlobalApplication.m3265f()) {
                    C1746bb.m5945a(getContext()).m5958a((ImageView) view, EnumC1748bd.CHAT_GROUP);
                } else {
                    C1746bb.m5945a(getContext()).m5958a((ImageView) view, EnumC1748bd.GROUP);
                }
                setOnClickListener(this.f6481f);
                break;
            case BROADCAST:
                C1746bb.m5945a(getContext()).m5958a((ImageView) view, EnumC1748bd.BROADCAST);
                setOnClickListener(this.f6481f);
                break;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (GlobalApplication.m3265f()) {
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), 5.0f, 5.0f, Path.Direction.CW);
            canvas.clipPath(path);
        }
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
        }
    }
}
