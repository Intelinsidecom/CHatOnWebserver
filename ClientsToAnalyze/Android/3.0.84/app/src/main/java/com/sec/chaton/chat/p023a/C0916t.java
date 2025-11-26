package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.image.C1874c;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.util.C3250y;
import twitter4j.Query;

/* compiled from: ImageBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.t */
/* loaded from: classes.dex */
public class C0916t extends AbstractC0894af {

    /* renamed from: F */
    private static final String f3845F = C0916t.class.getSimpleName();

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a */
    public String mo5092a(Context context) {
        return this.f3807u == EnumC1455w.IMAGE ? context.getString(R.string.media_photo) : context.getString(R.string.media_animessage);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: c */
    protected String mo5103c() {
        String strC = super.mo5103c();
        String[] strArr = new String[0];
        if (strC != null) {
            String[] strArrSplit = strC.split("\n");
            if (strArrSplit.length > 6 && Query.MIXED.equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 6; i < strArrSplit.length; i++) {
                    stringBuffer.append(strArrSplit[i] + "\n");
                }
                return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
        }
        return null;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.InterfaceC0912p
    /* renamed from: f */
    public C0910n mo5095f() {
        return TextUtils.isEmpty(m5126q()) ? new C0910n(this.f3807u, this.f3809w, mo5103c()) : new C0910n(this.f3807u, this.f3809w, mo5103c() + m5126q());
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    protected void mo5087a() {
        ImageView imageView;
        String str;
        super.mo5087a();
        if (C3250y.f11734b) {
            C3250y.m11450b(f3845F, "Uri.parse(content): " + this.f3809w);
        }
        if (TextUtils.isEmpty(this.f3809w) && !C1555a.m6596a().m6599a(this.f3799m, true)) {
            C1555a.m6596a().m6597a(this.f3790d, null, new Handler(), 0, super.mo5103c(), true, this.f3800n, this.f3799m, this.f3807u, this.f3798l, this.f3808v);
        }
        if (m5123n()) {
            String str2 = this.f3801o + this.f3809w;
            imageView = this.f3794h.f4226O;
            if (this.f3809w == null) {
                this.f3794h.f4226O.setVisibility(8);
                this.f3794h.f4235X.setVisibility(0);
                str = str2;
            } else {
                this.f3794h.f4226O.setVisibility(0);
                this.f3794h.f4235X.setVisibility(8);
                str = str2;
            }
        } else {
            String str3 = this.f3799m + this.f3809w;
            imageView = this.f3794h.f4291u;
            if (this.f3809w == null) {
                this.f3794h.f4291u.setVisibility(8);
                this.f3794h.f4249ad.setVisibility(0);
                str = str3;
            } else {
                this.f3794h.f4291u.setVisibility(0);
                this.f3794h.f4249ad.setVisibility(8);
                str = str3;
            }
        }
        imageView.setOnClickListener(this);
        this.f3796j.m11730a(imageView, new C1874c(str, this.f3809w, true, true, this.f3807u));
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        ImageView imageView;
        super.mo5090a(z);
        if (m5123n()) {
            this.f3794h.f4226O.setVisibility(8);
            this.f3794h.f4235X.setVisibility(8);
            imageView = this.f3794h.f4226O;
        } else {
            this.f3794h.f4291u.setVisibility(8);
            this.f3794h.f4249ad.setVisibility(8);
            imageView = this.f3794h.f4291u;
        }
        if (!z) {
            imageView.setImageBitmap(null);
            this.f3796j.m11732a(imageView);
        }
        imageView.setOnClickListener(null);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f3791e.isClosed()) {
            if ((view == this.f3794h.f4291u || view == this.f3794h.f4226O) && this.f3791e.moveToPosition(this.f3792f)) {
                this.f3797k.mo4980a(m5123n(), this.f3791e);
            }
        }
    }
}
