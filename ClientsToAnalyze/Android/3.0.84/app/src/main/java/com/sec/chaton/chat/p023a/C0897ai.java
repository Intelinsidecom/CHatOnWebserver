package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.image.C1874c;
import twitter4j.Query;

/* compiled from: VideoBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ai */
/* loaded from: classes.dex */
public class C0897ai extends AbstractC0894af {
    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a */
    public String mo5092a(Context context) {
        return context.getString(R.string.media_video);
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
        String str;
        ImageView imageView;
        super.mo5087a();
        if (m5123n()) {
            str = this.f3801o + this.f3809w;
            imageView = this.f3794h.f4226O;
            this.f3794h.f4226O.setVisibility(0);
            this.f3794h.f4226O.setOnClickListener(this);
        } else {
            str = this.f3799m + this.f3809w;
            imageView = this.f3794h.f4291u;
            this.f3794h.f4291u.setVisibility(0);
            this.f3794h.f4291u.setOnClickListener(this);
        }
        if (TextUtils.isEmpty(this.f3809w)) {
            imageView.setImageResource(R.drawable.co_attach_p_video_normal);
            return;
        }
        C1874c c1874c = new C1874c(str, this.f3809w, false, true);
        c1874c.m11708a((View) imageView);
        this.f3796j.m11730a(imageView, c1874c);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        ImageView imageView;
        super.mo5090a(z);
        if (m5123n()) {
            imageView = this.f3794h.f4226O;
            this.f3794h.f4226O.setVisibility(8);
            this.f3794h.f4226O.setOnClickListener(null);
        } else {
            imageView = this.f3794h.f4291u;
            this.f3794h.f4291u.setVisibility(8);
            this.f3794h.f4291u.setOnClickListener(null);
        }
        if (!z) {
            imageView.setImageBitmap(null);
            this.f3796j.m11732a(imageView);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f3791e.isClosed()) {
            if ((view == this.f3794h.f4291u || view == this.f3794h.f4226O) && this.f3791e.moveToPosition(this.f3792f)) {
                this.f3797k.mo4987b(m5123n(), this.f3791e);
            }
        }
    }
}
