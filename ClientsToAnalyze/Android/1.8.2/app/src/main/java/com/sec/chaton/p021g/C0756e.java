package com.sec.chaton.p021g;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import com.sec.chaton.EnumC0836m;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1791w;
import java.io.File;

/* compiled from: InterlockedImage.java */
/* renamed from: com.sec.chaton.g.e */
/* loaded from: classes.dex */
public class C0756e implements InterfaceC0752a {

    /* renamed from: a */
    private Intent f2771a;

    public C0756e(Intent intent) {
        this.f2771a = intent;
    }

    @Override // com.sec.chaton.p021g.InterfaceC0752a
    /* renamed from: a */
    public EnumC0836m mo3250a() {
        EnumC0836m enumC0836m;
        File file;
        this.f2771a.putExtra("callForward", true);
        this.f2771a.putExtra("content_type", EnumC0699n.IMAGE.m3162a());
        Uri uri = (Uri) this.f2771a.getExtras().get("android.intent.extra.STREAM");
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            try {
                Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(uri, null, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        this.f2771a.putExtra("download_uri", Uri.fromFile(new File(cursorQuery.getString(cursorQuery.getColumnIndex("_data")))).toString());
                        enumC0836m = EnumC0836m.FORWARD;
                    } else {
                        try {
                            if (C1767bw.m6002a()) {
                                file = new File(GlobalApplication.m3260b().getExternalCacheDir() + "/tmp/");
                            } else {
                                file = new File(GlobalApplication.m3260b().getCacheDir() + "/tmp/");
                            }
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = GlobalApplication.m3260b().getContentResolver().openAssetFileDescriptor(uri, "r");
                            Bitmap bitmapM6088a = C1791w.m6088a(GlobalApplication.m3260b(), uri, (int) assetFileDescriptorOpenAssetFileDescriptor.getLength());
                            String str = System.currentTimeMillis() + "jpeg";
                            C1791w.m6096a(bitmapM6088a, file, str, Bitmap.CompressFormat.JPEG, 100);
                            assetFileDescriptorOpenAssetFileDescriptor.close();
                            File file2 = new File(file, str);
                            if (file2.exists()) {
                                this.f2771a.putExtra("download_uri", Uri.fromFile(file2).toString());
                                enumC0836m = EnumC0836m.FORWARD;
                            }
                        } catch (Exception e) {
                            enumC0836m = EnumC0836m.HOME;
                        }
                    }
                    return enumC0836m;
                } finally {
                    cursorQuery.close();
                }
            } catch (SecurityException e2) {
                return EnumC0836m.HOME;
            }
        }
        if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f2771a.putExtra("download_uri", uri.toString());
            return EnumC0836m.FORWARD;
        }
        return EnumC0836m.HOME;
    }
}
