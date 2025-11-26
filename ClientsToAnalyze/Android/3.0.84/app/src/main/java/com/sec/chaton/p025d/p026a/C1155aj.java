package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1364h;
import com.sec.chaton.p035io.entry.inner.CoverStorySample;
import com.sec.chaton.p035io.entry.inner.CoverStorySampleList;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CoverStorySampleTask.java */
/* renamed from: com.sec.chaton.d.a.aj */
/* loaded from: classes.dex */
public class C1155aj extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4593b = C1155aj.class.getSimpleName();

    public C1155aj(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    protected String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    protected void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        if (C3250y.f11733a) {
            C3250y.m11456e("afterRequest()", f4593b);
        }
        EnumC1587o enumC1587oM1351b = c0267d.m1351b();
        if (c0267d.m11704n() && enumC1587oM1351b != EnumC1587o.ERROR) {
            if (enumC1587oM1351b == EnumC1587o.SUCCESS && c0267d.m1354e() != null) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                CoverStorySampleList coverStorySampleList = (CoverStorySampleList) c0267d.m1354e();
                if (C3250y.f11734b) {
                    C3250y.m11450b("the number of coverStorySample from Server : " + coverStorySampleList.count, f4593b);
                    C3250y.m11450b("time stamp: " + coverStorySampleList.timestamp, f4593b);
                }
                Iterator<CoverStorySample> it = coverStorySampleList.coverstory.iterator();
                while (it.hasNext()) {
                    CoverStorySample next = it.next();
                    if (C3250y.f11734b) {
                        C3250y.m11450b("CoverStorySample id : " + next.f5642id + " / CoverStorySample ThumbUrl :" + next.thumbnailurl, f4593b);
                    }
                    if (!TextUtils.isEmpty(next.status)) {
                        if ("create".equalsIgnoreCase(next.status)) {
                            arrayList.add(C1364h.m6085a(next));
                        } else if ("update".equalsIgnoreCase(next.status)) {
                            arrayList.add(C1364h.m6087b(next));
                        } else if ("delete".equalsIgnoreCase(next.status)) {
                            arrayList.add(C1364h.m6089c(next));
                            if (C3250y.f11734b) {
                                C3250y.m11450b(" Deleted sample Image ID : " + next.f5642id, f4593b);
                            }
                            m5506a(next.f5642id);
                        }
                    } else {
                        arrayList.add(C1364h.m6085a(next));
                    }
                }
                C3159aa.m10962a().m10982a("get_coverstory_sample_timestamp", coverStorySampleList.timestamp);
                CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                return;
            }
            if (enumC1587oM1351b == EnumC1587o.NO_CONTENT && C3250y.f11735c) {
                C3250y.m11453c("no Content", f4593b);
            }
        }
    }

    /* renamed from: a */
    private void m5506a(String str) {
        String[] list;
        String str2 = CommonApplication.m11493l().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        if (C3250y.f11734b) {
            C3250y.m11450b(" deleteSampleImage dirInternalPath : " + str2 + " Deleted sample Image ID : " + str, f4593b);
        }
        File file = new File(str2);
        if (file.exists() && (list = file.list()) != null) {
            for (String str3 : list) {
                if (str3.equalsIgnoreCase(str + ".jpg")) {
                    File file2 = new File(str2 + "/" + str + ".jpg");
                    C3250y.m11450b("deleteSampleImage filename : " + str3 + " @@ sampleId : " + str + ".jpg", f4593b);
                    if (file2.exists() && !file2.isDirectory()) {
                        file2.delete();
                        return;
                    }
                }
            }
        }
    }
}
