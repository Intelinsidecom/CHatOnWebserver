package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: ContactBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.l */
/* loaded from: classes.dex */
public class C1539l extends AbstractC1525as {
    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.media_contact);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    protected String mo8370e() {
        return "";
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() {
        ImageView imageView;
        super.mo8357a();
        if (m8404s()) {
            imageView = this.f5861h.f6408Z;
            this.f5861h.f6407Y.setVisibility(0);
            this.f5861h.f6431aa.setText(this.f5877x);
            this.f5861h.f6431aa.setVisibility(0);
        } else {
            imageView = this.f5861h.f6481z;
            this.f5861h.f6480y.setVisibility(0);
            this.f5861h.f6383A.setText(this.f5877x);
            this.f5861h.f6383A.setVisibility(0);
        }
        imageView.setImageResource(R.drawable.co_attach_p_contact_normal);
        imageView.setOnClickListener(this);
        imageView.setVisibility(0);
        imageView.setContentDescription(this.f5856c.getString(R.string.media_contact));
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        super.mo8361a(z);
        if (m8404s()) {
            this.f5861h.f6408Z.setOnClickListener(null);
            this.f5861h.f6407Y.setVisibility(8);
        } else {
            this.f5861h.f6481z.setOnClickListener(null);
            this.f5861h.f6480y.setVisibility(8);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f5858e.isClosed()) {
            if ((view.equals(this.f5861h.f6408Z) || view.equals(this.f5861h.f6481z)) && this.f5858e.moveToPosition(this.f5859f)) {
                this.f5864k.mo8253d(m8404s(), this.f5858e, this.f5861h.f6409a);
            }
        }
    }
}
