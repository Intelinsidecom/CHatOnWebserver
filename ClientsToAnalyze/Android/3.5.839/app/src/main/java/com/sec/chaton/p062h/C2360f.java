package com.sec.chaton.p062h;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.chat.EnumC1761hg;
import com.sec.chaton.multimedia.doc.EnumC2758b;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import java.io.File;

/* compiled from: InterlockedDocument.java */
/* renamed from: com.sec.chaton.h.f */
/* loaded from: classes.dex */
public class C2360f implements InterfaceC2355a {

    /* renamed from: a */
    private Intent f8391a;

    /* renamed from: a */
    public static C2360f m10316a(Intent intent) {
        return new C2360f(intent);
    }

    private C2360f(Intent intent) {
        this.f8391a = intent;
    }

    @Override // com.sec.chaton.p062h.InterfaceC2355a
    /* renamed from: a */
    public EnumC1761hg mo10310a() {
        String string;
        EnumC2758b enumC2758bM11581d;
        this.f8391a.putExtra("callForward", true);
        Uri uri = (Uri) this.f8391a.getExtras().get("android.intent.extra.STREAM");
        if (uri == null) {
            return EnumC1761hg.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            return EnumC1761hg.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f8391a.putExtra("callForward", true);
            this.f8391a.putExtra("download_uri", uri.toString());
            String name = null;
            if (Uri.decode(uri.toString()).startsWith("file:///")) {
                File file = new File(uri.getPath());
                if (!this.f8391a.getExtras().containsKey("android.intent.extra.TEXT")) {
                    string = null;
                } else {
                    string = this.f8391a.getExtras().getString("android.intent.extra.TEXT");
                }
                EnumC2758b enumC2758bM11581d2 = FileExplorerActivity.m11581d(string);
                if (enumC2758bM11581d2 == EnumC2758b.UNKNOWN) {
                    name = file.getName();
                    enumC2758bM11581d = FileExplorerActivity.m11581d(name);
                } else {
                    name = string;
                    enumC2758bM11581d = enumC2758bM11581d2;
                }
                this.f8391a.putExtra("content_type", FileExplorerActivity.m11577a(enumC2758bM11581d).m10076a());
            }
            if (!TextUtils.isEmpty(name)) {
                this.f8391a.putExtra("sub_content", name);
            }
            return EnumC1761hg.FORWARD;
        }
        return EnumC1761hg.HOME;
    }
}
