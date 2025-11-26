package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.Map;

/* loaded from: classes.dex */
public class AudioAttachmentView extends LinearLayout implements InterfaceC4315ih {

    /* renamed from: a */
    private final Resources f14735a;

    /* renamed from: b */
    private ImageView f14736b;

    /* renamed from: c */
    private Uri f14737c;

    /* renamed from: d */
    private MediaPlayer f14738d;

    /* renamed from: e */
    private boolean f14739e;

    public AudioAttachmentView(Context context) {
        super(context);
        this.f14735a = context.getResources();
    }

    public AudioAttachmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14735a = context.getResources();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        this.f14736b = (ImageView) findViewById(R.id.attachment_icon);
        this.f14736b.setImageResource(R.drawable.co_attach_p_voice_normal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m15726h() {
        C3890m.m14999e("AudioAttachmentView", "Error occurred while playing audio.");
        m15725a(this.f14735a.getString(R.string.cannot_play_audio));
        mo15732c();
    }

    /* renamed from: i */
    private void m15727i() {
        if (this.f14738d != null) {
            try {
                this.f14738d.stop();
                this.f14738d.release();
            } finally {
                this.f14738d = null;
            }
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: a */
    public synchronized void mo15728a() {
        if (!this.f14739e && this.f14737c != null) {
            this.f14738d = MediaPlayer.create(this.mContext, this.f14737c);
            if (this.f14738d != null) {
                this.f14738d.setAudioStreamType(3);
                this.f14738d.setOnCompletionListener(new C4226f(this));
                this.f14738d.setOnErrorListener(new C4253g(this));
                this.f14739e = true;
                this.f14738d.start();
            }
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: b */
    public void mo15730b() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setAudio(Uri uri, String str, Map<String, ?> map) {
        synchronized (this) {
            this.f14737c = uri;
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImage(String str, Bitmap bitmap) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageRegionFit(String str) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setText(String str, String str2) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setTextVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setVideo(String str, Uri uri) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setVideoVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: c */
    public synchronized void mo15732c() {
        try {
            m15727i();
        } finally {
            this.f14739e = false;
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: d */
    public void mo15733d() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4343ji
    /* renamed from: e */
    public void mo15734e() {
        synchronized (this) {
            if (this.f14739e) {
                mo15732c();
            }
        }
    }

    public void setVisibility(boolean z) {
    }

    /* renamed from: a */
    private void m15725a(String str) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: f */
    public void mo15735f() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: g */
    public void mo15736g() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: a */
    public void mo15729a(int i) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: b */
    public void mo15731b(int i) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setRawAttachment(String str) {
    }

    public void setRawAttachmentVisibility(boolean z) {
    }
}
