package com.sec.chaton.chat.p054a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.AsyncTaskC2728d;
import com.sec.chaton.multimedia.audio.C2726b;
import com.sec.chaton.util.C4894o;

/* compiled from: AudioBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.g */
/* loaded from: classes.dex */
public class C1534g extends AbstractC1525as {
    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.media_voice);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g_ */
    protected void mo8372g_() {
        super.mo8372g_();
        this.f5861h.f6443am.setVisibility(8);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() throws NumberFormatException {
        ImageView imageView;
        TextView textView;
        super.mo8357a();
        if (TextUtils.isEmpty(this.f5877x) && !TextUtils.isEmpty(this.f5876w)) {
            m8429a(m8404s(), this.f5876w, this.f5867n, this.f5868o, this.f5866m, this.f5875v);
        }
        if (m8404s()) {
            imageView = this.f5861h.f6408Z;
            textView = this.f5861h.f6431aa;
            this.f5861h.f6407Y.setVisibility(0);
            this.f5861h.f6407Y.setOrientation(0);
            this.f5861h.f6431aa.setVisibility(0);
            this.f5861h.f6408Z.setVisibility(0);
        } else {
            imageView = this.f5861h.f6481z;
            textView = this.f5861h.f6383A;
            this.f5861h.f6480y.setVisibility(0);
            this.f5861h.f6480y.setOrientation(0);
            this.f5861h.f6383A.setVisibility(0);
            this.f5861h.f6481z.setVisibility(0);
        }
        if (!C2726b.m11429a().m11448d(this.f5866m)) {
            try {
                int i = Integer.parseInt(this.f5877x);
                textView.setText(String.format("%d:%02d/%d:%02d", 0, 0, Integer.valueOf(i / 60000), Integer.valueOf((i / 1000) % 60)));
            } catch (NumberFormatException e) {
                textView.setText(this.f5877x);
            }
        }
        AsyncTaskC2728d asyncTaskC2728dM11449e = C2726b.m11429a().m11449e(this.f5866m);
        if (asyncTaskC2728dM11449e != null) {
            asyncTaskC2728dM11449e.m11461a(this.f5857d);
        }
        if (C2726b.m11429a().m11446c(this.f5866m)) {
            imageView.setImageResource(R.drawable.chat_push_to_talk_play);
        } else {
            imageView.setImageResource(R.drawable.chat_attach_btn_icon_walkie_talkie);
        }
        imageView.setBackgroundResource(R.drawable.chat_attach_btn_bg);
        imageView.setOnClickListener(this);
        imageView.setContentDescription(this.f5856c.getString(R.string.media_voice));
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    @TargetApi(16)
    /* renamed from: a */
    public void mo8361a(boolean z) {
        ImageView imageView;
        super.mo8361a(z);
        if (m8404s()) {
            this.f5861h.f6407Y.setVisibility(8);
            this.f5861h.f6407Y.setOrientation(1);
            this.f5861h.f6408Z.setOnClickListener(null);
            imageView = this.f5861h.f6408Z;
        } else {
            this.f5861h.f6480y.setVisibility(8);
            this.f5861h.f6480y.setOrientation(1);
            this.f5861h.f6481z.setOnClickListener(null);
            imageView = this.f5861h.f6481z;
        }
        imageView.setImageDrawable(null);
        if (Build.VERSION.SDK_INT < 16) {
            imageView.setBackgroundDrawable(null);
        } else {
            imageView.setBackground(null);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    protected String mo8370e() {
        return "";
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.InterfaceC1548u
    /* renamed from: b_ */
    public C1546s mo8387b_() {
        return new C1546s(this.f5874u, this.f5876w, null);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f5858e.isClosed()) {
            if ((view.equals(this.f5861h.f6408Z) || view.equals(this.f5861h.f6481z)) && this.f5858e.moveToPosition(this.f5859f)) {
                this.f5864k.mo8244b(m8404s(), this.f5858e, this.f5861h.f6409a);
            }
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.InterfaceC1542o
    /* renamed from: h_ */
    public void mo8400h_() {
        super.mo8400h_();
        if (m8404s()) {
            C2726b.m11429a().m11434a(this.f5868o);
        } else {
            C2726b.m11429a().m11434a(this.f5866m);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.InterfaceC1547t
    /* renamed from: m */
    public boolean mo8415m() {
        return mo8373i();
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: n */
    public String mo8401n() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON/Voice/";
    }

    /* renamed from: a */
    private void m8429a(boolean z, String str, String str2, long j, long j2, String str3) {
        if (!TextUtils.isEmpty(str) && !str.endsWith(".tmp")) {
            String strM18613b = C4894o.m18613b(str);
            if (!TextUtils.isEmpty(strM18613b)) {
                new Thread(new RunnableC1535h(this, z, str2, j, strM18613b, j2, str3)).start();
            }
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.InterfaceC1545r
    /* renamed from: o */
    public boolean mo8413o() {
        return mo8373i();
    }
}
