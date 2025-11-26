package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class SlideshowAttachmentView extends LinearLayout implements InterfaceC4315ih {

    /* renamed from: a */
    private ImageView f15152a;

    /* renamed from: b */
    private TextView f15153b;

    public SlideshowAttachmentView(Context context) {
        super(context);
    }

    public SlideshowAttachmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        this.f15152a = (ImageView) findViewById(R.id.slideshow_image);
        this.f15153b = (TextView) findViewById(R.id.slideshow_text);
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
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_missing_thumbnail_picture);
            } catch (OutOfMemoryError e) {
            }
        }
        if (bitmap != null) {
            this.f15152a.setImageBitmap(bitmap);
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageRegionFit(String str) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageVisibility(boolean z) {
        this.f15152a.setVisibility(z ? 0 : 4);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setText(String str, String str2) {
        this.f15153b.setText(str2);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setTextVisibility(boolean z) {
        this.f15153b.setVisibility(z ? 0 : 4);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setVideo(String str, Uri uri) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            try {
                mediaPlayer.setDataSource(this.mContext, uri);
                this.f15152a.setImageBitmap(mediaPlayer.getFrameAt(1000));
            } catch (IOException e) {
                C3890m.m14995a("SlideshowAttachmentView", "Unexpected IOException.", e);
            }
        } finally {
            mediaPlayer.release();
        }
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
        this.f15152a.setImageURI(null);
        this.f15153b.setText("");
    }

    public void setVisibility(boolean z) {
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
