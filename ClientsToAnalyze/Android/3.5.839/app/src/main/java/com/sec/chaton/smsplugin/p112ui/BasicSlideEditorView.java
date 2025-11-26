package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class BasicSlideEditorView extends LinearLayout implements InterfaceC4315ih {

    /* renamed from: a */
    private ImageView f14740a;

    /* renamed from: b */
    private View f14741b;

    /* renamed from: c */
    private TextView f14742c;

    /* renamed from: d */
    private EditText f14743d;

    /* renamed from: e */
    private boolean f14744e;

    /* renamed from: f */
    private InterfaceC4307i f14745f;

    public BasicSlideEditorView(Context context) {
        super(context);
        this.f14744e = true;
    }

    public BasicSlideEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14744e = true;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        this.f14740a = (ImageView) findViewById(R.id.image);
        this.f14741b = findViewById(R.id.audio);
        this.f14742c = (TextView) findViewById(R.id.audio_name);
        this.f14743d = (EditText) findViewById(R.id.text_message);
        this.f14743d.addTextChangedListener(new C4280h(this));
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
        this.f14741b.setVisibility(0);
        this.f14742c.setText(str);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImage(String str, Bitmap bitmap) {
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_missing_thumbnail_picture);
            } catch (OutOfMemoryError e) {
                C3890m.m14995a("BasicSlideEditorView", "setImage: out of memory: ", e);
                return;
            }
        }
        this.f14740a.setImageBitmap(bitmap);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageRegionFit(String str) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setText(String str, String str2) {
        this.f14744e = false;
        if (str2 != null && !str2.equals(this.f14743d.getText().toString())) {
            this.f14743d.setText(str2);
            this.f14743d.setSelection(str2.length());
        }
        this.f14744e = true;
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setTextVisibility(boolean z) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setVideo(String str, Uri uri) throws IOException {
        try {
            Bitmap bitmapM16286a = VideoAttachmentView.m16286a(this.mContext, uri);
            if (bitmapM16286a == null) {
                bitmapM16286a = BitmapFactory.decodeResource(getResources(), R.drawable.ic_missing_thumbnail_video);
            }
            this.f14740a.setImageBitmap(bitmapM16286a);
        } catch (OutOfMemoryError e) {
            C3890m.m14995a("BasicSlideEditorView", "setVideo: out of memory: ", e);
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
        this.f14740a.setImageDrawable(null);
        this.f14741b.setVisibility(8);
        this.f14744e = false;
        this.f14743d.setText("");
        this.f14744e = true;
    }

    public void setVisibility(boolean z) {
    }

    public void setOnTextChangedListener(InterfaceC4307i interfaceC4307i) {
        this.f14745f = interfaceC4307i;
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
