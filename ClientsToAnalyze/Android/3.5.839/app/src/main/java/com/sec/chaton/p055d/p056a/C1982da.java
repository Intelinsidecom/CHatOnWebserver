package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.block.C1093u;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2187am;
import com.sec.chaton.p065io.entry.inner.Address;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: HideBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.da */
/* loaded from: classes.dex */
public class C1982da extends AbstractC1900a {

    /* renamed from: b */
    String f7272b;

    /* renamed from: c */
    String[] f7273c;

    /* renamed from: d */
    boolean f7274d;

    /* renamed from: e */
    String f7275e;

    public C1982da(C2454e c2454e, String str, boolean z) {
        super(c2454e);
        this.f7274d = false;
        this.f7275e = "";
        this.f7272b = str;
        this.f7273c = null;
        this.f7274d = z;
    }

    public C1982da(C2454e c2454e, String[] strArr, boolean z) {
        super(c2454e);
        this.f7274d = false;
        this.f7275e = "";
        this.f7272b = strArr[0];
        this.f7273c = strArr;
        this.f7274d = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1982da(C2454e c2454e, ArrayList<C1093u> arrayList, boolean z) {
        super(c2454e);
        int i = 0;
        this.f7274d = false;
        this.f7275e = "";
        this.f7273c = new String[arrayList.size()];
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                this.f7273c[i2] = arrayList.get(i2).f3484a;
                i = i2 + 1;
            } else {
                this.f7274d = z;
                return;
            }
        }
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    protected String mo9086c() {
        ArrayList arrayList = new ArrayList();
        if (this.f7273c != null) {
            for (int i = 0; i < this.f7273c.length; i++) {
                Address address = new Address();
                address.f8559id = this.f7273c[i];
                address.ishide = Boolean.toString(this.f7274d);
                arrayList.add(address);
            }
        } else {
            Address address2 = new Address();
            address2.f8559id = this.f7272b;
            address2.ishide = Boolean.toString(this.f7274d);
            arrayList.add(address2);
            if (!this.f7274d) {
                this.f7275e = this.f7272b;
            }
        }
        String strM18172a = new C4815ag().m18172a(arrayList);
        C4904y.m18646e("\n" + strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    protected void mo9084a(C0778b c0778b) throws RemoteException, UnsupportedEncodingException, OperationApplicationException {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (C4904y.f17872b) {
                C4904y.m18639b("HideBuddyTask SUCCESS and getAllBuddies()", this.f18194f);
            }
            new C2128i(null).m9504a(true);
            if (!TextUtils.isEmpty(this.f7275e)) {
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                arrayList.add(C2187am.m9779a(this.f7275e));
                ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
                if (arrayList.size() > 0) {
                    contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
                    return;
                }
                return;
            }
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("HideBuddyTask FAIL httpEntry : " + c0778b.m3107b(), this.f18194f);
        }
    }
}
