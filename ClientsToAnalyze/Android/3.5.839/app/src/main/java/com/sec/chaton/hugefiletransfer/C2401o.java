package com.sec.chaton.hugefiletransfer;

import android.content.ContentValues;
import com.sec.chaton.p046a.p047a.C0784h;
import com.sec.chaton.p055d.p056a.AbstractC1924ax;
import com.sec.chaton.p057e.C2218af;
import com.sec.chaton.p065io.entry.HugeFileUploadStartEntry;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p126d.p127a.p129b.C4985b;

/* compiled from: MultichannelUploadStart.java */
/* renamed from: com.sec.chaton.hugefiletransfer.o */
/* loaded from: classes.dex */
public class C2401o extends AbstractC1924ax<C4985b, C0784h> {

    /* renamed from: a */
    private long f8537a;

    public C2401o(C4985b c4985b, long j) {
        super(c4985b);
        this.f8537a = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0784h mo6146a(C4985b c4985b) {
        return new C0784h(c4985b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo6150b() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo6149a(C0784h c0784h) {
        if (c0784h.m18953m() == 200) {
            HugeFileUploadStartEntry hugeFileUploadStartEntry = (HugeFileUploadStartEntry) c0784h.m18928p();
            if (C4904y.f17872b) {
                C4904y.m18639b("HttpResponse: " + hugeFileUploadStartEntry, this.f18194f);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("chunk_count", hugeFileUploadStartEntry.chunk_count);
            contentValues.put("upload_key", hugeFileUploadStartEntry.mupload_key);
            CommonApplication.m18732r().getContentResolver().update(C2218af.f7940a, contentValues, "upload_id=?", new String[]{String.valueOf(this.f8537a)});
        }
    }
}
