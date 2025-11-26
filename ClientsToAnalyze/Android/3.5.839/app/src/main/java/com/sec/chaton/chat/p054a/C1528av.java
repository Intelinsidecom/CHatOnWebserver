package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.multimedia.image.C2844d;
import com.sec.chaton.util.C4904y;

/* compiled from: VideoBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.av */
/* loaded from: classes.dex */
public class C1528av extends AbstractC1525as {
    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.media_video);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    protected String mo8370e() {
        return C1736gi.m8654f(super.mo8370e());
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.InterfaceC1548u
    /* renamed from: b_ */
    public C1546s mo8387b_() {
        if (TextUtils.isEmpty(m8407v())) {
            return new C1546s(this.f5874u, this.f5876w, mo8370e());
        }
        if (!TextUtils.isEmpty(mo8370e())) {
            return new C1546s(this.f5874u, this.f5876w, mo8370e() + m8407v());
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("onShare() - getTextContent() is null", "VideoBubbleDrawer");
        }
        return new C1546s(this.f5874u, this.f5876w, "" + m8407v());
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() {
        String str;
        ImageView imageView;
        super.mo8357a();
        if (m8404s()) {
            str = this.f5868o + this.f5876w;
            imageView = this.f5861h.f6401S;
            this.f5861h.f6401S.setVisibility(0);
            this.f5861h.f6401S.setOnClickListener(this);
        } else {
            str = this.f5866m + this.f5876w;
            imageView = this.f5861h.f6476u;
            this.f5861h.f6476u.setVisibility(0);
            this.f5861h.f6476u.setOnClickListener(this);
        }
        imageView.setContentDescription(this.f5856c.getString(R.string.media_video));
        if (TextUtils.isEmpty(this.f5876w)) {
            imageView.setImageResource(R.drawable.co_attach_p_video_normal);
            return;
        }
        C2844d c2844d = new C2844d(str, this.f5876w, false, true);
        c2844d.m18990a((View) imageView);
        this.f5863j.m19023b(imageView, c2844d);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        ImageView imageView;
        super.mo8361a(z);
        if (m8404s()) {
            imageView = this.f5861h.f6401S;
            this.f5861h.f6401S.setVisibility(8);
            this.f5861h.f6401S.setOnClickListener(null);
        } else {
            imageView = this.f5861h.f6476u;
            this.f5861h.f6476u.setVisibility(8);
            this.f5861h.f6476u.setOnClickListener(null);
        }
        if (!z) {
            imageView.setImageBitmap(null);
            this.f5863j.m19015a((View) imageView);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f5858e.isClosed()) {
            if ((view.equals(this.f5861h.f6476u) || view.equals(this.f5861h.f6401S)) && this.f5858e.moveToPosition(this.f5859f)) {
                this.f5864k.mo8243b(m8404s(), this.f5858e);
            }
        }
    }
}
