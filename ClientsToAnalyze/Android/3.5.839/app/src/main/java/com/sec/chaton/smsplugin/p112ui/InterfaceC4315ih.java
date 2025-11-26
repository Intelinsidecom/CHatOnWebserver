package com.sec.chaton.smsplugin.p112ui;

import android.graphics.Bitmap;
import android.net.Uri;
import java.util.Map;

/* compiled from: SlideViewInterface.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ih */
/* loaded from: classes.dex */
public interface InterfaceC4315ih extends InterfaceC4343ji {
    /* renamed from: a */
    void mo15728a();

    /* renamed from: a */
    void mo15729a(int i);

    /* renamed from: b */
    void mo15730b();

    /* renamed from: b */
    void mo15731b(int i);

    /* renamed from: c */
    void mo15732c();

    /* renamed from: d */
    void mo15733d();

    /* renamed from: f */
    void mo15735f();

    /* renamed from: g */
    void mo15736g();

    void setAudio(Uri uri, String str, Map<String, ?> map);

    void setImage(String str, Bitmap bitmap);

    void setImageRegionFit(String str);

    void setImageVisibility(boolean z);

    void setRawAttachment(String str);

    void setText(String str, String str2);

    void setTextVisibility(boolean z);

    void setVideo(String str, Uri uri);

    void setVideoVisibility(boolean z);
}
