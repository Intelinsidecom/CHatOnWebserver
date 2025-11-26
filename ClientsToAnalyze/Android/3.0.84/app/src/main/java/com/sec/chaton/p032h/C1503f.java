package com.sec.chaton.p032h;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.EnumC2947t;
import com.sec.chaton.multimedia.doc.EnumC1794a;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.p027e.EnumC1455w;
import java.io.File;

/* compiled from: InterlockedDocument.java */
/* renamed from: com.sec.chaton.h.f */
/* loaded from: classes.dex */
public class C1503f implements InterfaceC1498a {

    /* renamed from: a */
    private Intent f5538a;

    public C1503f(Intent intent) {
        this.f5538a = intent;
    }

    @Override // com.sec.chaton.p032h.InterfaceC1498a
    /* renamed from: a */
    public EnumC2947t mo6465a() {
        this.f5538a.putExtra("callForward", true);
        Uri uri = (Uri) this.f5538a.getExtras().get("android.intent.extra.STREAM");
        if (uri == null) {
            return EnumC2947t.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            return EnumC2947t.HOME;
        }
        if (uri.getScheme() != null && uri.getScheme().equals("file")) {
            this.f5538a.putExtra("callForward", true);
            this.f5538a.putExtra("download_uri", uri.toString());
            String name = null;
            if (Uri.decode(uri.toString()).startsWith("file:///")) {
                File file = new File(uri.getPath());
                if (this.f5538a.getExtras().containsKey("android.intent.extra.TEXT")) {
                    name = this.f5538a.getExtras().getString("android.intent.extra.TEXT");
                }
                if (file != null) {
                    EnumC1794a enumC1794aM7386c = FileExplorerActivity.m7386c(name);
                    if (enumC1794aM7386c == EnumC1794a.UNKNOWN) {
                        name = file.getName();
                        enumC1794aM7386c = FileExplorerActivity.m7386c(name);
                    }
                    if (enumC1794aM7386c == EnumC1794a.TXT || enumC1794aM7386c == EnumC1794a.SNB) {
                        this.f5538a.putExtra("content_type", EnumC1455w.FILE.m6364a());
                    } else {
                        this.f5538a.putExtra("content_type", EnumC1455w.DOCUMENT.m6364a());
                    }
                }
            }
            if (!TextUtils.isEmpty(name)) {
                this.f5538a.putExtra("sub_content", name);
            }
            return EnumC2947t.FORWARD;
        }
        return EnumC2947t.HOME;
    }
}
