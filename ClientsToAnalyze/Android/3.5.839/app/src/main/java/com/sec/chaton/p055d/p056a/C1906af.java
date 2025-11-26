package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2194h;
import com.sec.chaton.p065io.entry.inner.CoverStorySample;
import com.sec.chaton.p065io.entry.inner.CoverStorySampleList;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CoverStorySampleTask.java */
/* renamed from: com.sec.chaton.d.a.af */
/* loaded from: classes.dex */
public class C1906af extends AbstractC1900a {

    /* renamed from: b */
    private static final String f7126b = C1906af.class.getSimpleName();

    public C1906af(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if (C4904y.f17871a) {
            C4904y.m18646e("afterRequest()", f7126b);
        }
        EnumC2464o enumC2464oM3107b = c0778b.m3107b();
        if (c0778b.m18954n() && enumC2464oM3107b != EnumC2464o.ERROR) {
            if (enumC2464oM3107b == EnumC2464o.SUCCESS && c0778b.m3110e() != null) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                CoverStorySampleList coverStorySampleList = (CoverStorySampleList) c0778b.m3110e();
                if (C4904y.f17872b) {
                    C4904y.m18639b("the number of coverStorySample from Server : " + coverStorySampleList.count, f7126b);
                    C4904y.m18639b("time stamp: " + coverStorySampleList.timestamp, f7126b);
                }
                Iterator<CoverStorySample> it = coverStorySampleList.coverstory.iterator();
                while (it.hasNext()) {
                    CoverStorySample next = it.next();
                    if (C4904y.f17872b) {
                        C4904y.m18639b("CoverStorySample id : " + next.f8564id + " / CoverStorySample ThumbUrl :" + next.thumbnailurl, f7126b);
                    }
                    if (!TextUtils.isEmpty(next.status)) {
                        if ("create".equalsIgnoreCase(next.status)) {
                            arrayList.add(C2194h.m9890a(next));
                        } else if ("update".equalsIgnoreCase(next.status)) {
                            arrayList.add(C2194h.m9892b(next));
                        } else if ("delete".equalsIgnoreCase(next.status)) {
                            arrayList.add(C2194h.m9894c(next));
                            if (C4904y.f17872b) {
                                C4904y.m18639b(" Deleted sample Image ID : " + next.f8564id, f7126b);
                            }
                            m9088a(next.f8564id);
                        }
                    } else {
                        arrayList.add(C2194h.m9890a(next));
                    }
                }
                C4809aa.m18104a().m18124a("get_coverstory_sample_timestamp", coverStorySampleList.timestamp);
                CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                return;
            }
            if (enumC2464oM3107b == EnumC2464o.NO_CONTENT && C4904y.f17873c) {
                C4904y.m18641c("no Content", f7126b);
            }
        }
    }

    /* renamed from: a */
    private void m9088a(String str) {
        String[] list;
        String str2 = CommonApplication.m18732r().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        if (C4904y.f17872b) {
            C4904y.m18639b(" deleteSampleImage dirInternalPath : " + str2 + " Deleted sample Image ID : " + str, f7126b);
        }
        File file = new File(str2);
        if (file.exists() && (list = file.list()) != null) {
            for (String str3 : list) {
                if (str3.equalsIgnoreCase(str + ".jpg")) {
                    File file2 = new File(str2 + "/" + str + ".jpg");
                    C4904y.m18639b("deleteSampleImage filename : " + str3 + " @@ sampleId : " + str + ".jpg", f7126b);
                    if (file2.exists() && !file2.isDirectory()) {
                        file2.delete();
                        return;
                    }
                }
            }
        }
    }
}
