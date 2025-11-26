package com.sec.chaton.settings.downloads;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1366j;
import com.sec.chaton.p027e.p028a.C1367k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3364o;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FontHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.bj */
/* loaded from: classes.dex */
public class C2570bj {

    /* renamed from: a */
    private static final String f9750a = C2570bj.class.getSimpleName();

    /* renamed from: b */
    private static final List<InterfaceC2571bk> f9751b = new ArrayList();

    /* renamed from: c */
    private static final List<InterfaceC2572bl> f9752c = new ArrayList();

    /* renamed from: a */
    public static ArrayList<ContentProviderOperation> m9510a(Context context) {
        String[] strArrM6099b = C1367k.m6099b(context);
        if (strArrM6099b == null || strArrM6099b.length <= 0) {
            return null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        for (String str : strArrM6099b) {
            File fileM9521c = m9521c(context, str);
            if (!fileM9521c.exists()) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_font, checkValidationAndUpdateInstallStatus(), font does not exist (id/path)" + str + "/" + fileM9521c.getPath(), f9750a);
                }
                arrayList.add(C1366j.m6092a(EnumC1399aq.Font, str));
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static synchronized void m9512a(Context context, String str, File file) {
        try {
            m9517b(context, str, file);
            try {
                C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6093a(EnumC1399aq.Font, str, C3347i.m11774a()));
                Iterator<InterfaceC2571bk> it = f9751b.iterator();
                while (it.hasNext()) {
                    it.next().m9524a(str);
                }
            } catch (OperationApplicationException e) {
                throw new IOException(e);
            } catch (RemoteException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9750a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: a */
    public static synchronized void m9511a(Context context, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("Uninstall font package. ", str), f9750a);
        }
        try {
            m9519b(context, str);
            try {
                C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6092a(EnumC1399aq.Font, str));
                Iterator<InterfaceC2572bl> it = f9752c.iterator();
                while (it.hasNext()) {
                    it.next().m9525a(str);
                }
            } catch (OperationApplicationException e) {
                throw new IOException(e);
            } catch (RemoteException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9750a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: b */
    public static synchronized File m9517b(Context context, String str, File file) {
        File fileM9521c;
        IOException e;
        try {
            fileM9521c = m9521c(context, str);
            try {
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_font, saveFontFile : ", f9750a);
                    C3250y.m11450b("download_font   - (from) " + file.getPath().toString(), f9750a);
                    C3250y.m11450b("download_font   - (to) " + fileM9521c.getPath().toString(), f9750a);
                }
                if (!file.renameTo(fileM9521c)) {
                    throw new IOException(C3364o.m11849a("Can't rename anicon panel file.", fileM9521c));
                }
            } catch (IOException e2) {
                e = e2;
                if (C3330f.f12033a.f11975e) {
                    C3330f.f12033a.m11652a(f9750a, e.getMessage(), e);
                }
                return fileM9521c;
            }
        } catch (IOException e3) {
            fileM9521c = null;
            e = e3;
        }
        return fileM9521c;
    }

    /* renamed from: b */
    public static synchronized void m9519b(Context context, String str) {
        File fileM9521c = m9521c(context, str);
        if (fileM9521c.exists()) {
            fileM9521c.delete();
        }
    }

    /* renamed from: c */
    public static File m9521c(Context context, String str) {
        return new File(m9516b(context), C3364o.m11849a(str, ".font"));
    }

    /* renamed from: b */
    public static File m9516b(Context context) {
        File dir = context.getDir("font", 0);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    /* renamed from: a */
    public static void m9513a(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.chatlist_font_size_last_message));
        textView.setTextColor(resources.getColor(R.color.download_before_color));
    }

    /* renamed from: b */
    public static void m9520b(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.chatlist_font_size_last_message));
        textView.setTextColor(resources.getColor(R.color.download_after_color));
    }

    /* renamed from: c */
    public static void m9522c(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.downloading_font_size));
        textView.setTextColor(resources.getColor(R.color.black));
    }

    /* renamed from: d */
    public static void m9523d(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.chatlist_font_size_last_message));
        textView.setTextColor(resources.getColor(R.color.black));
    }

    /* renamed from: a */
    public static boolean m9514a(String str) throws NumberFormatException {
        int i;
        int iIntValue = C3159aa.m10962a().m10978a("Default Font Typeface", (Integer) (-1)).intValue();
        try {
            i = Integer.parseInt(str);
            if (C3250y.f11734b) {
                C3250y.m11450b("isAppliedItem(), saved/new : " + iIntValue + " / " + i, f9750a);
            }
        } catch (NumberFormatException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f9750a);
            }
        }
        if (iIntValue == i) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static int m9509a() {
        return C3159aa.m10962a().m10978a("new_font_count", (Integer) 0).intValue();
    }

    /* renamed from: a */
    public static boolean m9515a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("download_font, apply(), itemId is (null) or (empty) ", f9750a);
            return false;
        }
        File fileM9521c = m9521c(CommonApplication.m11493l(), str);
        if (fileM9521c == null || !fileM9521c.exists()) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("download_font, apply(), itemId / (failed) : " + str.toString(), f9750a);
            return false;
        }
        C3159aa.m10962a().m10984b("Default Font Typeface", Integer.valueOf(str));
        C3159aa.m10962a().m10986b("Default Font Name", str2);
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("download_font, apply(), itemId : ", str.toString()), f9750a);
        }
        return true;
    }

    /* renamed from: b */
    public static void m9518b() {
        C3159aa.m10962a().m10981a("Default Font Typeface");
    }
}
