package com.sec.chaton.p021g;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.EnumC0836m;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0699n;
import java.io.File;

/* compiled from: InterlockedAudio.java */
/* renamed from: com.sec.chaton.g.b */
/* loaded from: classes.dex */
public class C0753b implements InterfaceC0752a {

    /* renamed from: a */
    private Intent f2768a;

    public C0753b(Intent intent) {
        this.f2768a = intent;
    }

    @Override // com.sec.chaton.p021g.InterfaceC0752a
    /* renamed from: a */
    public EnumC0836m mo3250a() {
        this.f2768a.putExtra("callForward", true);
        this.f2768a.putExtra("content_type", EnumC0699n.AUDIO.m3162a());
        Uri uri = (Uri) this.f2768a.getExtras().get("android.intent.extra.STREAM");
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        this.f2768a.putExtra("download_uri", Uri.fromFile(new File(cursorQuery.getString(cursorQuery.getColumnIndex("_data")))).toString());
                        EnumC0836m enumC0836m = EnumC0836m.FORWARD;
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } else if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f2768a.putExtra("download_uri", uri.toString());
            return EnumC0836m.FORWARD;
        }
        return EnumC0836m.HOME;
    }
}
