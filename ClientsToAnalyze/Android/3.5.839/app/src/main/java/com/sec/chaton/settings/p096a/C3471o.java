package com.sec.chaton.settings.p096a;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2196j;
import com.sec.chaton.p057e.p058a.C2197k;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.C4996f;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FontHelper.java */
/* renamed from: com.sec.chaton.settings.a.o */
/* loaded from: classes.dex */
public class C3471o {

    /* renamed from: a */
    private static final String f12955a = C3471o.class.getSimpleName();

    /* renamed from: b */
    private static final List<InterfaceC3472p> f12956b = new ArrayList();

    /* renamed from: c */
    private static final List<InterfaceC3473q> f12957c = new ArrayList();

    /* renamed from: a */
    public static ArrayList<ContentProviderOperation> m13799a(Context context) {
        String[] strArrM9904b = C2197k.m9904b(context);
        if (strArrM9904b == null || strArrM9904b.length <= 0) {
            return null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        for (String str : strArrM9904b) {
            File fileM13807c = m13807c(context, str);
            if (!fileM13807c.exists()) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("download_font, checkValidationAndUpdateInstallStatus(), font does not exist (id/path)" + str + "/" + fileM13807c.getPath(), f12955a);
                }
                arrayList.add(C2196j.m9897a(EnumC2258bd.Font, str));
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static synchronized void m13802a(Context context, String str, File file) {
        try {
            m13805b(context, str, file);
            try {
                C4821am.m18189a(context, "com.sec.chaton.provider2", C2196j.m9898a(EnumC2258bd.Font, str, C5034k.m19090a()));
                Iterator<InterfaceC3472p> it = f12956b.iterator();
                while (it.hasNext()) {
                    it.next().m13808a(str);
                }
            } catch (OperationApplicationException e) {
                throw C1057b.m6157a(e);
            } catch (RemoteException e2) {
                throw C1057b.m6157a(e2);
            }
        } catch (IOException e3) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12955a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: a */
    public static synchronized void m13801a(Context context, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("Uninstall font package. ", str), f12955a);
        }
        try {
            m13806b(context, str);
            try {
                C4821am.m18189a(context, "com.sec.chaton.provider2", ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.Font).buildUpon().appendPath(str).build()).build());
                Iterator<InterfaceC3473q> it = f12957c.iterator();
                while (it.hasNext()) {
                    it.next().m13809a(str);
                }
            } catch (OperationApplicationException e) {
                throw C1057b.m6157a(e);
            } catch (RemoteException e2) {
                throw C1057b.m6157a(e2);
            }
        } catch (IOException e3) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12955a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: b */
    public static synchronized File m13805b(Context context, String str, File file) {
        File fileM13807c;
        IOException e;
        try {
            fileM13807c = m13807c(context, str);
            try {
                if (C4904y.f17872b) {
                    C4904y.m18639b("download_font, saveFontFile : ", f12955a);
                    C4904y.m18639b("download_font   - (from) " + file.getPath().toString(), f12955a);
                    C4904y.m18639b("download_font   - (to) " + fileM13807c.getPath().toString(), f12955a);
                }
                if (!file.renameTo(fileM13807c)) {
                    throw new IOException(C5052r.m19199a("Can't rename anicon panel file.", fileM13807c));
                }
            } catch (IOException e2) {
                e = e2;
                if (C4996f.f18229a.f18174f) {
                    C4996f.f18229a.mo18649a(f12955a, e.getMessage(), e);
                }
                return fileM13807c;
            }
        } catch (IOException e3) {
            fileM13807c = null;
            e = e3;
        }
        return fileM13807c;
    }

    /* renamed from: b */
    public static synchronized void m13806b(Context context, String str) {
        File fileM13807c = m13807c(context, str);
        if (fileM13807c.exists()) {
            fileM13807c.delete();
        }
    }

    /* renamed from: c */
    public static File m13807c(Context context, String str) {
        return new File(m13804b(context), C5052r.m19199a(str, ".font"));
    }

    /* renamed from: b */
    public static File m13804b(Context context) {
        File dir = context.getDir("font", 0);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    /* renamed from: a */
    public static boolean m13803a(String str) throws NumberFormatException {
        int i;
        int iIntValue = C4809aa.m18104a().m18120a("Default Font Typeface", (Integer) (-1)).intValue();
        try {
            i = Integer.parseInt(str);
            if (C4904y.f17872b) {
                C4904y.m18639b("isAppliedItem(), saved/new : " + iIntValue + " / " + i, f12955a);
            }
        } catch (NumberFormatException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f12955a);
            }
        }
        if (iIntValue == i) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static void m13800a() {
        C4809aa.m18104a().m18123a("Default Font Typeface");
    }
}
