package com.sec.chaton.p017e.p019b;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0658b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuddyGroupAddTask.java */
/* renamed from: com.sec.chaton.e.b.g */
/* loaded from: classes.dex */
public class C0680g extends AbstractC0674a {

    /* renamed from: b */
    private int f2573b;

    /* renamed from: c */
    private String f2574c;

    /* renamed from: d */
    private ArrayList f2575d;

    /* renamed from: e */
    private int f2576e;

    public C0680g(InterfaceC0677d interfaceC0677d, String str, int i) {
        super(interfaceC0677d, new Handler(Looper.getMainLooper()));
        this.f2574c = str;
        this.f2576e = i;
    }

    public C0680g(InterfaceC0677d interfaceC0677d, String[] strArr, int i) {
        super(interfaceC0677d, new Handler(Looper.getMainLooper()));
        this.f2576e = i;
        this.f2574c = strArr[0];
        this.f2575d = new ArrayList();
        for (int i2 = 1; i2 < strArr.length; i2++) {
            this.f2575d.add(strArr[i2]);
        }
    }

    @Override // com.sec.chaton.p017e.p019b.AbstractC0674a
    /* renamed from: a */
    public Object mo3098a() throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
        if (this.f2576e == 2) {
            C0658b.m2995c(contentResolver, this.f2574c);
            this.f2573b = C0658b.m2996d(contentResolver, this.f2574c);
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            try {
                Iterator it = this.f2575d.iterator();
                while (it.hasNext()) {
                    arrayList.add(C0658b.m2988a(contentResolver, this.f2573b, (String) it.next()));
                }
                GlobalApplication.m3260b().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            } catch (OperationApplicationException e) {
                e.printStackTrace();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            return Integer.valueOf(this.f2573b);
        }
        if (this.f2576e == 3) {
            if (this.f2573b == 0) {
                return Integer.valueOf(C0658b.m2997e(contentResolver, this.f2574c));
            }
            return Integer.valueOf(C0658b.m2992b(contentResolver, this.f2573b, this.f2574c));
        }
        if (this.f2576e == 10) {
            if (C0658b.m2987a(contentResolver, String.valueOf(this.f2573b), this.f2574c) == 1) {
                C0658b.m2991a(contentResolver, String.valueOf(this.f2573b));
                if (this.f2575d != null && this.f2575d.size() > 0) {
                    ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                    try {
                        Iterator it2 = this.f2575d.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(C0658b.m2988a(contentResolver, this.f2573b, (String) it2.next()));
                        }
                        GlobalApplication.m3260b().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                    } catch (OperationApplicationException e3) {
                        e3.printStackTrace();
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                }
            }
            return "" + this.f2573b;
        }
        return null;
    }

    /* renamed from: b */
    public void m3100b(int i) {
        this.f2573b = i;
    }
}
