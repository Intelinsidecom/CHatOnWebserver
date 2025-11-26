package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.multimedia.image.C2815a;
import com.sec.chaton.util.C4904y;

/* compiled from: AmsBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.b */
/* loaded from: classes.dex */
public class C1529b extends AbstractC1525as {

    /* renamed from: L */
    private static final String f5917L = C1529b.class.getSimpleName();

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.media_animessage);
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
            C4904y.m18641c("onShare() - getTextContent() is null", f5917L);
        }
        return new C1546s(this.f5874u, this.f5876w, "" + m8407v());
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() {
        ImageView imageView;
        super.mo8357a();
        if (m8404s()) {
            imageView = this.f5861h.f6401S;
        } else {
            imageView = this.f5861h.f6476u;
        }
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        imageView.setContentDescription(this.f5856c.getString(R.string.media_animessage));
        if (this.f5876w == null) {
            imageView.setImageResource(R.drawable.co_attach_p_ams_normal);
        } else {
            this.f5863j.m19023b(imageView, new C2815a(this.f5868o + this.f5876w, this.f5876w, true));
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        ImageView imageView;
        super.mo8361a(z);
        if (m8404s()) {
            imageView = this.f5861h.f6401S;
        } else {
            imageView = this.f5861h.f6476u;
        }
        imageView.setVisibility(8);
        if (!z) {
            imageView.setImageBitmap(null);
            this.f5863j.m19015a((View) imageView);
        }
        imageView.setOnClickListener(null);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f5858e.isClosed()) {
            if ((view.equals(this.f5861h.f6476u) || view.equals(this.f5861h.f6401S)) && this.f5858e.moveToPosition(this.f5859f)) {
                this.f5864k.mo8237a(m8404s(), this.f5858e);
            }
        }
    }
}
