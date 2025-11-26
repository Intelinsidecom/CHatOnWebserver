package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import java.util.Map;

/* loaded from: classes.dex */
public class RawAttachmentView extends LinearLayout implements InterfaceC4315ih {

    /* renamed from: a */
    private ImageView f15075a;

    public RawAttachmentView(Context context) {
        super(context);
    }

    public RawAttachmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        this.f15075a = (ImageView) findViewById(R.id.attachment_icon);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: a */
    public void mo15728a() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: b */
    public void mo15730b() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setAudio(Uri uri, String str, Map<String, ?> map) {
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
    public void mo15732c() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: d */
    public void mo15733d() {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4343ji
    /* renamed from: e */
    public void mo15734e() {
    }

    public void setVisibility(boolean z) {
        setVisibility(z ? 0 : 8);
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
        if (str.toLowerCase().endsWith("vcf")) {
            this.f15075a.setImageResource(R.drawable.co_attach_p_contact_normal);
        } else if (str.toLowerCase().endsWith("vcs")) {
            this.f15075a.setImageResource(R.drawable.co_attach_p_calendar_normal);
        }
    }

    public void setRawAttachmentVisibility(boolean z) {
    }
}
