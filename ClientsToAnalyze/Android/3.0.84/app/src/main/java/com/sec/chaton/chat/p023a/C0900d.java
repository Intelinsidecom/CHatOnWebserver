package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.AsyncTaskC1776h;
import com.sec.chaton.multimedia.audio.C1770b;
import com.sec.chaton.util.C3243r;
import java.io.IOException;

/* compiled from: AudioBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.d */
/* loaded from: classes.dex */
public class C0900d extends AbstractC0894af {
    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a */
    public String mo5092a(Context context) {
        return context.getString(R.string.setting_push_to_talk);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a_ */
    protected void mo5093a_() {
        super.mo5093a_();
        this.f3794h.f4250ae.setVisibility(8);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    protected void mo5087a() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        ImageView imageView;
        TextView textView;
        super.mo5087a();
        if (TextUtils.isEmpty(this.f3810x) && !TextUtils.isEmpty(this.f3809w)) {
            m5105a(m5123n(), this.f3809w, this.f3800n, this.f3801o, this.f3799m, this.f3808v);
        }
        if (m5123n()) {
            imageView = this.f3794h.f4229R;
            textView = this.f3794h.f4230S;
            this.f3794h.f4228Q.setVisibility(0);
            this.f3794h.f4228Q.setOrientation(0);
            this.f3794h.f4230S.setVisibility(0);
            this.f3794h.f4229R.setVisibility(0);
        } else {
            imageView = this.f3794h.f4293w;
            textView = this.f3794h.f4294x;
            this.f3794h.f4292v.setVisibility(0);
            this.f3794h.f4292v.setOrientation(0);
            this.f3794h.f4294x.setVisibility(0);
            this.f3794h.f4293w.setVisibility(0);
        }
        if (!C1770b.m7289a().m7308d(this.f3799m)) {
            textView.setText(this.f3810x);
        }
        AsyncTaskC1776h asyncTaskC1776hM7309e = C1770b.m7289a().m7309e(this.f3799m);
        if (asyncTaskC1776hM7309e != null) {
            asyncTaskC1776hM7309e.m7337a(this.f3790d);
        }
        if (C1770b.m7289a().m7306c(this.f3799m)) {
            imageView.setImageResource(R.drawable.chat_push_to_talk_play);
        } else {
            imageView.setImageResource(R.drawable.chat_attach_btn_icon_walkie_talkie);
        }
        imageView.setBackgroundResource(R.drawable.chat_attach_btn_bg);
        imageView.setOnClickListener(this);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        if (m5123n()) {
            this.f3794h.f4228Q.setVisibility(8);
            this.f3794h.f4228Q.setOrientation(1);
            this.f3794h.f4229R.setOnClickListener(null);
        } else {
            this.f3794h.f4292v.setVisibility(8);
            this.f3794h.f4292v.setOrientation(1);
            this.f3794h.f4293w.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: c */
    protected String mo5103c() {
        return null;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.InterfaceC0912p
    /* renamed from: f */
    public C0910n mo5095f() {
        return new C0910n(this.f3807u, this.f3809w, null);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f3791e.isClosed()) {
            if ((view == this.f3794h.f4229R || view == this.f3794h.f4293w) && this.f3791e.moveToPosition(this.f3792f)) {
                this.f3797k.mo4988b(m5123n(), this.f3791e, this.f3794h.f4238a);
            }
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.InterfaceC0908l
    /* renamed from: c_ */
    public void mo5106c_() {
        super.mo5106c_();
        if (m5123n()) {
            C1770b.m7289a().m7294a(this.f3801o);
        } else {
            C1770b.m7289a().m7294a(this.f3799m);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.InterfaceC0911o
    /* renamed from: k */
    public boolean mo5102k() {
        return mo5096g();
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: l */
    public String mo5107l() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON/Voice/";
    }

    /* renamed from: a */
    private void m5105a(boolean z, String str, String str2, long j, long j2, String str3) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (!TextUtils.isEmpty(str) && !str.endsWith(".tmp")) {
            String strM11423b = C3243r.m11423b(str);
            if (!TextUtils.isEmpty(strM11423b)) {
                new Thread(new RunnableC0901e(this, z, str2, j, strM11423b, j2, str3)).start();
            }
        }
    }
}
