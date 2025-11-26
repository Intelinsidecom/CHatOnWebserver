package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.p024b.C0958i;
import com.sec.chaton.p020c.C0816a;

/* compiled from: GeoBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.r */
/* loaded from: classes.dex */
public class C0914r extends AbstractViewOnClickListenerC0920x implements InterfaceC0909m {
    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a */
    public String mo5092a(Context context) {
        return context.getString(R.string.media_map);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: c */
    protected String mo5103c() {
        return null;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    protected void mo5087a() throws Resources.NotFoundException {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        ImageView imageView2;
        String strSubstring = null;
        super.mo5087a();
        if (m5123n()) {
            ImageView imageView3 = this.f3794h.f4229R;
            TextView textView3 = this.f3794h.f4230S;
            TextView textView4 = this.f3794h.f4231T;
            this.f3794h.f4228Q.setVisibility(0);
            this.f3794h.f4229R.setOnClickListener(this);
            this.f3794h.f4230S.setVisibility(0);
            this.f3794h.f4231T.setVisibility(0);
            this.f3794h.f4229R.setVisibility(0);
            imageView = imageView3;
            textView = textView3;
            textView2 = textView4;
            imageView2 = null;
        } else {
            imageView = this.f3794h.f4293w;
            textView = this.f3794h.f4294x;
            textView2 = this.f3794h.f4295y;
            imageView2 = this.f3794h.f4296z;
            this.f3794h.f4292v.setVisibility(0);
            this.f3794h.f4293w.setOnClickListener(this);
            this.f3794h.f4294x.setVisibility(0);
            this.f3794h.f4295y.setVisibility(0);
            this.f3794h.f4293w.setVisibility(0);
        }
        if (C0816a.m4365a()) {
            imageView.setImageResource(R.drawable.co_attach_p_location_normal);
        } else {
            imageView.setImageResource(R.drawable.co_attach_p_alert_normal);
        }
        String[] strArr = new String[0];
        if (this.f3802p != null) {
            String[] strArrSplit = this.f3802p.split("\n");
            if (strArrSplit.length > 6) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 6; i < strArrSplit.length; i++) {
                    stringBuffer.append(strArrSplit[i] + "\n");
                }
                strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
        }
        if (!TextUtils.isEmpty(this.f3803q)) {
            textView.setTextColor(this.f3789c.getResources().getColor(R.color.translate_source_text));
        }
        if (TextUtils.isEmpty(strSubstring)) {
            textView.setText(strSubstring);
            textView.setVisibility(8);
            textView2.setText(strSubstring);
            textView2.setVisibility(8);
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.f3803q)) {
            textView.setText(strSubstring);
            textView.setVisibility(0);
            textView2.setText(this.f3803q);
            textView2.setVisibility(0);
            if (imageView2 != null && C0958i.m5166a()) {
                imageView2.setVisibility(0);
                imageView2.setOnClickListener(new ViewOnClickListenerC0915s(this));
                return;
            }
            return;
        }
        textView2.setVisibility(8);
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        textView.setText(strSubstring);
        textView.setVisibility(0);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        if (m5123n()) {
            this.f3794h.f4228Q.setVisibility(8);
            this.f3794h.f4229R.setOnClickListener(null);
        } else {
            this.f3794h.f4292v.setVisibility(8);
            this.f3794h.f4293w.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: g */
    public boolean mo5096g() {
        return true;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: h */
    public C0910n mo5097h() {
        return new C0910n(this.f3807u, this.f3802p, null);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f3791e.isClosed()) {
            if ((view == this.f3794h.f4229R || view == this.f3794h.f4293w) && this.f3791e.moveToPosition(this.f3792f)) {
                this.f3797k.mo4992c(m5123n(), this.f3791e);
            }
        }
    }
}
