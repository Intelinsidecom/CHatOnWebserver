package com.sec.chaton.calllog.buddy.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.sec.chaton.util.C3205bt;

/* loaded from: classes.dex */
public class BuddyImageView extends ImageView {

    /* renamed from: a */
    private String f3153a;

    /* renamed from: b */
    private String f3154b;

    /* renamed from: c */
    private C0826c f3155c;

    /* renamed from: d */
    private long f3156d;

    /* renamed from: e */
    private HandlerC0825b f3157e;

    /* renamed from: f */
    private Handler f3158f;

    /* renamed from: g */
    private int f3159g;

    public void setBuddyGroupDefaultImage() {
    }

    public BuddyImageView(Context context) {
        super(context);
        this.f3153a = null;
        this.f3154b = null;
        this.f3155c = new C0826c(this);
        this.f3156d = 0L;
        this.f3157e = new HandlerC0825b(this);
        this.f3158f = null;
        this.f3159g = -1;
    }

    public BuddyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3153a = null;
        this.f3154b = null;
        this.f3155c = new C0826c(this);
        this.f3156d = 0L;
        this.f3157e = new HandlerC0825b(this);
        this.f3158f = null;
        this.f3159g = -1;
    }

    public BuddyImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3153a = null;
        this.f3154b = null;
        this.f3155c = new C0826c(this);
        this.f3156d = 0L;
        this.f3157e = new HandlerC0825b(this);
        this.f3158f = null;
        this.f3159g = -1;
    }

    public void setImageViewMode(int i) {
        this.f3159g = i;
    }

    /* renamed from: a */
    public void m4379a(String str) {
        C3205bt.m11182a(getContext()).m11210a(this, str);
        int i = this.f3159g;
    }
}
