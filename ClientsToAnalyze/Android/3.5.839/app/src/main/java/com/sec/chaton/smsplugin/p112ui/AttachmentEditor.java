package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3799r;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;

/* loaded from: classes.dex */
public class AttachmentEditor extends LinearLayout {

    /* renamed from: a */
    private final Context f14729a;

    /* renamed from: b */
    private Handler f14730b;

    /* renamed from: c */
    private InterfaceC4315ih f14731c;

    /* renamed from: d */
    private C3870p f14732d;

    /* renamed from: e */
    private AbstractC4277gx f14733e;

    /* renamed from: f */
    private boolean f14734f;

    public AttachmentEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14729a = context;
    }

    /* renamed from: a */
    public boolean m15723a(C3799r c3799r) {
        m15722a();
        this.f14731c = null;
        if (!c3799r.m14456f()) {
            return false;
        }
        this.f14732d = c3799r.m14457g();
        this.f14731c = m15720b();
        if (this.f14733e == null || !this.f14732d.equals(this.f14733e.getModel())) {
            this.f14733e = C4278gy.m16480a("MmsThumbnailPresenter", this.f14729a, this.f14731c, this.f14732d);
        } else {
            this.f14733e.setView(this.f14731c);
        }
        this.f14733e.present();
        return true;
    }

    public void setHandler(Handler handler) {
        this.f14730b = handler;
    }

    public void setCanSend(boolean z) {
        if (this.f14734f != z) {
            this.f14734f = z;
        }
    }

    /* renamed from: a */
    public void m15722a() {
        if (this.f14731c != null) {
            ((View) this.f14731c).setVisibility(8);
        }
    }

    /* renamed from: a */
    private View m15717a(int i, int i2) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById == null) {
            return ((ViewStub) findViewById(i)).inflate();
        }
        return viewFindViewById;
    }

    /* renamed from: b */
    private InterfaceC4315ih m15720b() {
        boolean zM15721c = m15721c();
        if (this.f14732d.size() > 1) {
            return m15719a(zM15721c);
        }
        C3869o c3869o = this.f14732d.get(0);
        if (c3869o.m14863e()) {
            return m15718a(R.id.image_attachment_view_stub, R.id.image_attachment_view, R.id.image_del_btn, 10, 4, 12);
        }
        if (c3869o.m14867g()) {
            return m15718a(R.id.video_attachment_view_stub, R.id.video_attachment_view, R.id.video_del_btn, 8, 5, 12);
        }
        if (c3869o.m14865f()) {
            return m15718a(R.id.audio_attachment_view_stub, R.id.audio_attachment_view, R.id.audio_del_btn, 9, 6, 12);
        }
        if (this.f14732d.m14921j()) {
            return m15718a(R.id.raw_attachment_view_stub, R.id.raw_attachment_view, R.id.raw_del_btn, 11, 7, 12);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    private boolean m15721c() {
        return this.f14729a.getResources().getConfiguration().orientation == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private InterfaceC4315ih m15718a(int i, int i2, int i3, int i4, int i5, int i6) {
        LinearLayout linearLayout = (LinearLayout) m15717a(i, i2);
        linearLayout.setVisibility(0);
        ((ImageButton) linearLayout.findViewById(i3)).setOnClickListener(new ViewOnClickListenerC4145c(this, i6));
        return (InterfaceC4315ih) linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private InterfaceC4315ih m15719a(boolean z) {
        LinearLayout linearLayout = (LinearLayout) m15717a(R.id.slideshow_attachment_view_stub, R.id.slideshow_attachment_view);
        linearLayout.setVisibility(0);
        ((ImageButton) linearLayout.findViewById(R.id.remove_slideshow_button)).setOnClickListener(new ViewOnClickListenerC4145c(this, 12));
        return (InterfaceC4315ih) linearLayout;
    }
}
