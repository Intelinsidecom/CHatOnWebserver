package com.sec.chaton.hugefiletransfer;

import android.content.ContentValues;
import com.sec.chaton.p046a.p047a.C0784h;
import com.sec.chaton.p055d.p056a.AbstractC1924ax;
import com.sec.chaton.p057e.C2218af;
import com.sec.chaton.p065io.entry.HugeFileUploadEndEntry;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p126d.p127a.p129b.C4985b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MultichannelUploadEnd.java */
/* renamed from: com.sec.chaton.hugefiletransfer.n */
/* loaded from: classes.dex */
public class C2400n extends AbstractC1924ax<C4985b, C0784h> {

    /* renamed from: a */
    private long f8536a;

    public C2400n(C4985b c4985b, long j) {
        super(c4985b);
        this.f8536a = j;
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
    public void mo6149a(C0784h c0784h) throws JSONException {
        ContentValues contentValues = new ContentValues();
        if (c0784h.m18953m() == 200) {
            HugeFileUploadEndEntry hugeFileUploadEndEntry = (HugeFileUploadEndEntry) c0784h.m18928p();
            if (C4904y.f17872b) {
                C4904y.m18639b("HttpResponse: " + hugeFileUploadEndEntry, this.f18194f);
            }
            contentValues.put("download_url", hugeFileUploadEndEntry.public_url);
            contentValues.put("auth_code", hugeFileUploadEndEntry.auth_code);
            contentValues.put("expiration_time", hugeFileUploadEndEntry.expired_time);
            contentValues.put("status", Integer.valueOf(EnumC2388b.SUCCESS.m10385a()));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("max_upload_count", hugeFileUploadEndEntry.max_upload_count);
            jSONObject.put("upload_count", hugeFileUploadEndEntry.upload_count);
            contentValues.put("extra_json", jSONObject.toString());
        } else {
            contentValues.put("status", Integer.valueOf(EnumC2388b.FAIL.m10385a()));
        }
        CommonApplication.m18732r().getContentResolver().update(C2218af.f7940a, contentValues, "upload_id=?", new String[]{String.valueOf(this.f8536a)});
    }
}
