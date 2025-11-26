package com.sec.chaton.p028e;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import com.sec.chaton.EnumC0250am;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1311bg;
import com.sec.chaton.util.C1327bw;
import java.io.File;

/* compiled from: InterlockedImage.java */
/* renamed from: com.sec.chaton.e.a */
/* loaded from: classes.dex */
public class C0674a implements InterfaceC0679f {

    /* renamed from: a */
    private Intent f2322a;

    public C0674a(Intent intent) {
        this.f2322a = intent;
    }

    @Override // com.sec.chaton.p028e.InterfaceC0679f
    /* renamed from: a */
    public EnumC0250am mo3045a() {
        EnumC0250am enumC0250am;
        File file;
        this.f2322a.putExtra("callForward", true);
        this.f2322a.putExtra("content_type", EnumC0651d.IMAGE.m2978a());
        Uri uri = (Uri) this.f2322a.getExtras().get("android.intent.extra.STREAM");
        if (uri == null) {
            return EnumC0250am.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            try {
                Cursor cursorQuery = GlobalApplication.m3100a().getContentResolver().query(uri, null, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        try {
                            int columnIndex = cursorQuery.getColumnIndex("_data");
                            if (columnIndex != -1) {
                                this.f2322a.putExtra("download_uri", Uri.fromFile(new File(cursorQuery.getString(columnIndex))).toString());
                            } else {
                                this.f2322a.putExtra("download_uri", Uri.fromFile(C1311bg.m4564a(GlobalApplication.m3100a(), null, null, uri)).toString());
                            }
                            enumC0250am = EnumC0250am.FORWARD;
                        } catch (NullPointerException e) {
                            enumC0250am = EnumC0250am.HOME;
                        }
                    } else {
                        try {
                            if (C1327bw.m4595a()) {
                                file = new File(GlobalApplication.m3100a().getExternalCacheDir() + "/tmp/");
                            } else {
                                file = new File(GlobalApplication.m3100a().getCacheDir() + "/tmp/");
                            }
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = GlobalApplication.m3100a().getContentResolver().openAssetFileDescriptor(uri, "r");
                            Bitmap bitmapM4501a = C1294aq.m4501a(GlobalApplication.m3100a(), uri, (int) assetFileDescriptorOpenAssetFileDescriptor.getLength());
                            String str = System.currentTimeMillis() + "jpeg";
                            C1294aq.m4508a(bitmapM4501a, file, str, Bitmap.CompressFormat.JPEG, 100);
                            assetFileDescriptorOpenAssetFileDescriptor.close();
                            File file2 = new File(file, str);
                            if (file2.exists()) {
                                this.f2322a.putExtra("download_uri", Uri.fromFile(file2).toString());
                                enumC0250am = EnumC0250am.FORWARD;
                            }
                        } catch (Exception e2) {
                            enumC0250am = EnumC0250am.HOME;
                        }
                    }
                    return enumC0250am;
                } finally {
                    cursorQuery.close();
                }
            } catch (IllegalStateException e3) {
                return EnumC0250am.HOME;
            } catch (SecurityException e4) {
                return EnumC0250am.HOME;
            }
        }
        if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f2322a.putExtra("download_uri", uri.toString());
            return EnumC0250am.FORWARD;
        }
        return EnumC0250am.HOME;
    }
}
