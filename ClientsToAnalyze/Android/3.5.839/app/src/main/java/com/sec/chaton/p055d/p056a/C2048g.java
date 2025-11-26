package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.EnumC2129j;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p065io.entry.inner.Address;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/* compiled from: AddBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.g */
/* loaded from: classes.dex */
public class C2048g extends AbstractC1900a {

    /* renamed from: b */
    EnumC2129j f7492b;

    /* renamed from: c */
    private String f7493c;

    /* renamed from: d */
    private String f7494d;

    /* renamed from: e */
    private ContentResolver f7495e;

    /* renamed from: g */
    private boolean f7496g;

    public C2048g(C2454e c2454e, String str) {
        this(c2454e, str, true, EnumC2129j.NONE);
    }

    public C2048g(C2454e c2454e, String str, boolean z) {
        this(c2454e, str, z, EnumC2129j.NONE);
    }

    public C2048g(C2454e c2454e, String str, boolean z, EnumC2129j enumC2129j) {
        super(c2454e);
        this.f7492b = EnumC2129j.NONE;
        this.f7493c = str;
        this.f7496g = z;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(this.f7493c, ",");
        String strM18172a = "";
        C4815ag c4815ag = new C4815ag();
        while (stringTokenizer.hasMoreTokens()) {
            Address address = new Address();
            String strNextToken = stringTokenizer.nextToken();
            if (this.f7492b != EnumC2129j.NONE) {
                address.idtype = String.valueOf(this.f7492b.m9536a());
            }
            address.value = strNextToken;
            if (this.f7494d != null && !TextUtils.isEmpty(this.f7494d)) {
                address.name = this.f7494d;
            }
            arrayList.add(address);
            strM18172a = c4815ag.m18172a(arrayList);
        }
        C4904y.m18646e("\n" + strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, UnsupportedEncodingException, OperationApplicationException {
        if (c0778b.m3110e() != null) {
            this.f7495e = CommonApplication.m18732r().getContentResolver();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            C4904y.m18639b("[TEST] ADD BUDDY TASK started", null);
            Iterator<Buddy> it = ((GetBuddyList) c0778b.m3110e()).buddy.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                if (C4904y.f17872b) {
                    C4904y.m18639b("NO : " + next.value + ", OrgNumber : " + next.orgnum + ", Name : " + next.name + ", Deleted : " + next.deleted + ", OrgName : " + next.orgname, this.f18194f);
                    C4904y.m18639b("StatusMsg : " + next.status + ", ImageStatus : " + next.getImagestatus().toString() + ", BIRTHDAY : " + next.birthday + ", showphonenumber=" + next.showphonenumber + ", extra info : " + next.einfo, this.f18194f);
                    C4904y.m18639b("OrgNumbers : " + next.orgnums + ", Msisdns : " + next.msisdns, this.f18194f);
                    C4904y.m18639b("Group : " + next.group + ", SEmail : " + next.samsungemail + ", SAInfo : " + next.sainfo, this.f18194f);
                    C4904y.m18639b("Result : " + next.result + ", DeviceType : " + next.devicetype, this.f18194f);
                }
                C2496n.m10790e(CommonApplication.m18732r(), next.value);
                if (!this.f7493c.startsWith("+0999")) {
                    arrayList.add(C2190d.m9818b(next));
                    if (next.value != null) {
                        arrayList.add(C2181ag.m9738a(next.value));
                    }
                }
                if (next.value != null) {
                    arrayList.add(C2176ab.m9669a(next.value, 0));
                }
            }
            this.f7495e.applyBatch("com.sec.chaton.provider", arrayList);
            C4904y.m18639b("[TEST] ADD BUDDY cpo applyBatch", null);
            if (this.f7496g) {
                new C2128i(null).m9504a(false);
            }
        }
    }
}
