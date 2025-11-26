package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class SlideListItemView extends LinearLayout implements InterfaceC4315ih {

    /* renamed from: a */
    private TextView f15125a;

    /* renamed from: b */
    private ImageView f15126b;

    /* renamed from: c */
    private TextView f15127c;

    /* renamed from: d */
    private ImageView f15128d;

    public SlideListItemView(Context context) {
        super(context);
    }

    public SlideListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        this.f15125a = (TextView) findViewById(R.id.text_preview);
        this.f15125a.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.f15126b = (ImageView) findViewById(R.id.image_preview);
        this.f15127c = (TextView) findViewById(R.id.attachment_name);
        this.f15128d = (ImageView) findViewById(R.id.attachment_icon);
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
        if (str != null) {
            this.f15127c.setText(str);
            this.f15128d.setImageResource(R.drawable.ic_mms_music);
        } else {
            this.f15127c.setText("");
            this.f15128d.setImageDrawable(null);
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImage(String str, Bitmap bitmap) {
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_missing_thumbnail_picture);
            } catch (OutOfMemoryError e) {
                C3890m.m14995a("SlideListItemView", "setImage: out of memory: ", e);
                return;
            }
        }
        this.f15126b.setImageBitmap(bitmap);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageRegionFit(String str) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setText(String str, String str2) {
        this.f15125a.setText(str2);
        this.f15125a.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setTextVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setVideo(String str, Uri uri) {
        if (str != null) {
            this.f15127c.setText(str);
            this.f15128d.setImageResource(R.drawable.movie);
        } else {
            this.f15127c.setText("");
            this.f15128d.setImageDrawable(null);
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            try {
                mediaPlayer.setDataSource(this.mContext, uri);
                this.f15126b.setImageBitmap(mediaPlayer.getFrameAt(1000));
            } catch (IOException e) {
                C3890m.m14995a("SlideListItemView", "Unexpected IOException.", e);
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
