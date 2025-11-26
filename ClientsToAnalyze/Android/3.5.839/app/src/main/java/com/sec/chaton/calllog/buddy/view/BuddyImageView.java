package com.sec.chaton.calllog.buddy.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.sec.chaton.util.C4855bt;

/* loaded from: classes.dex */
public class BuddyImageView extends ImageView {

    /* renamed from: a */
    private String f5123a;

    /* renamed from: b */
    private String f5124b;

    /* renamed from: c */
    private C1437c f5125c;

    /* renamed from: d */
    private long f5126d;

    /* renamed from: e */
    private HandlerC1436b f5127e;

    /* renamed from: f */
    private Handler f5128f;

    /* renamed from: g */
    private int f5129g;

    public void setBuddyGroupDefaultImage() {
    }

    public BuddyImageView(Context context) {
        super(context);
        this.f5123a = null;
        this.f5124b = null;
        this.f5125c = new C1437c();
        this.f5126d = 0L;
        this.f5127e = new HandlerC1436b();
        this.f5128f = null;
        this.f5129g = -1;
    }

    public BuddyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5123a = null;
        this.f5124b = null;
        this.f5125c = new C1437c();
        this.f5126d = 0L;
        this.f5127e = new HandlerC1436b();
        this.f5128f = null;
        this.f5129g = -1;
    }

    public BuddyImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5123a = null;
        this.f5124b = null;
        this.f5125c = new C1437c();
        this.f5126d = 0L;
        this.f5127e = new HandlerC1436b();
        this.f5128f = null;
        this.f5129g = -1;
    }

    public void setImageViewMode(int i) {
        this.f5129g = i;
    }

    /* renamed from: a */
    public void m7532a(String str) {
        C4855bt.m18351a(getContext()).m18360a(this, str);
        int i = this.f5129g;
    }
}
