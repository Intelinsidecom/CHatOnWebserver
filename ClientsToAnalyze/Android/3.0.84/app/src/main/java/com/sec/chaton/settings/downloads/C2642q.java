package com.sec.chaton.settings.downloads;

import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p027e.p028a.C1366j;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.C3330f;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3350l;
import com.sec.vip.amschaton.C3584q;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AmsItemHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.q */
/* loaded from: classes.dex */
public class C2642q {

    /* renamed from: a */
    private static final String f9887a = C2642q.class.getSimpleName();

    /* renamed from: b */
    private static final List<InterfaceC2644s> f9888b = new ArrayList();

    /* renamed from: c */
    private static final List<InterfaceC2645t> f9889c = new ArrayList();

    /* renamed from: a */
    public static boolean m9637a(Context context, EnumC1327e enumC1327e, String str) {
        File fileM9638b = m9638b(context, enumC1327e, str);
        return fileM9638b != null && fileM9638b.exists();
    }

    /* renamed from: b */
    public static File m9638b(Context context, EnumC1327e enumC1327e, String str) {
        return new File(m9633a(context, enumC1327e), str);
    }

    /* renamed from: a */
    public static void m9634a(Context context, EnumC1327e enumC1327e, String str, File file) throws Throwable {
        try {
            File file2 = new File(m9633a(context, enumC1327e), str);
            boolean zRenameTo = file.renameTo(file2);
            if (C3250y.f11734b) {
                C3250y.m11450b("download_ams, installItem, [renameResult: " + zRenameTo + "], targetFile: " + file2.getPath(), f9887a);
            }
            if (!zRenameTo) {
                throw new IOException("Can't rename file.");
            }
            try {
                C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6093a(enumC1327e.m5703b(), str, C3347i.m11774a()));
                if (enumC1327e == EnumC1327e.Template) {
                    C3584q.m12778a().m12807b(context);
                }
                Iterator<InterfaceC2644s> it = f9888b.iterator();
                while (it.hasNext()) {
                    it.next().mo7448b(enumC1327e, str);
                }
            } catch (OperationApplicationException e) {
                throw new IOException(e);
            } catch (RemoteException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9887a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: c */
    public static void m9641c(Context context, EnumC1327e enumC1327e, String str) {
        try {
            File file = new File(m9633a(context, enumC1327e), str);
            boolean z = false;
            if (file != null && file.exists()) {
                z = true;
                file.delete();
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("download_ams, uninstallItem, [deleteExist: " + z + "], targetFile: " + file.getPath(), f9887a);
            }
            try {
                C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6092a(enumC1327e.m5703b(), str));
                if (enumC1327e == EnumC1327e.Template) {
                    C3584q.m12778a().m12807b(context);
                }
                Iterator<InterfaceC2645t> it = f9889c.iterator();
                while (it.hasNext()) {
                    it.next().mo7445a(enumC1327e, str);
                }
            } catch (OperationApplicationException e) {
                throw new IOException(e);
            } catch (RemoteException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9887a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: a */
    public static File m9633a(Context context, EnumC1327e enumC1327e) {
        File fileM11800a = C3350l.m11800a(context);
        File file = null;
        switch (C2643r.f9890a[enumC1327e.ordinal()]) {
            case 1:
                file = new File(fileM11800a, "amsBackgroundItem");
                break;
            case 2:
                file = new File(fileM11800a, "amsStampItem");
                break;
            case 3:
                file = new File(fileM11800a, "amsTemplateItem");
                break;
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    public static int m9632a(EnumC1327e enumC1327e) {
        String str = null;
        switch (C2643r.f9890a[enumC1327e.ordinal()]) {
            case 1:
                str = "new_ams_item_background_count";
                break;
            case 2:
                str = "new_ams_item_stamp_count";
                break;
            case 3:
                str = "new_ams_item_template_count";
                break;
        }
        return C3159aa.m10962a().m10978a(str, (Integer) 0).intValue();
    }

    /* renamed from: a */
    public static void m9635a(InterfaceC2644s interfaceC2644s) {
        if (!f9888b.contains(interfaceC2644s)) {
            f9888b.add(interfaceC2644s);
        }
    }

    /* renamed from: b */
    public static void m9639b(InterfaceC2644s interfaceC2644s) {
        f9888b.remove(interfaceC2644s);
    }

    /* renamed from: a */
    public static void m9636a(InterfaceC2645t interfaceC2645t) {
        if (!f9889c.contains(interfaceC2645t)) {
            f9889c.add(interfaceC2645t);
        }
    }

    /* renamed from: b */
    public static void m9640b(InterfaceC2645t interfaceC2645t) {
        f9889c.remove(interfaceC2645t);
    }
}
