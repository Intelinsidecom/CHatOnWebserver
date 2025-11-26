package com.sec.chaton.settings.p096a;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2185ak;
import com.sec.chaton.p057e.p058a.C2196j;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5048n;
import com.sec.common.util.C5052r;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: SoundHelper.java */
/* renamed from: com.sec.chaton.settings.a.ab */
/* loaded from: classes.dex */
public class C3455ab {

    /* renamed from: a */
    private static final String f12909a = C3455ab.class.getSimpleName();

    /* renamed from: b */
    private static final List<InterfaceC3456ac> f12910b = new ArrayList();

    /* renamed from: c */
    private static final List<InterfaceC3457ad> f12911c = new ArrayList();

    /* renamed from: a */
    public static ArrayList<ContentProviderOperation> m13744a(Context context) {
        File fileM13756f;
        String[] strArrM9758a = C2185ak.m9758a(context);
        if (strArrM9758a == null || strArrM9758a.length <= 0) {
            return null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        for (String str : strArrM9758a) {
            if (!C3470n.m13797a(str) && ((fileM13756f = m13756f(context, str)) == null || !fileM13756f.exists())) {
                if (C4904y.f17872b && fileM13756f != null) {
                    C4904y.m18639b("download_sound, checkValidationAndUpdateInstallStatus(), file does not exist (id/path)" + str + "/" + fileM13756f.getPath(), f12909a);
                }
                arrayList.add(C2196j.m9897a(EnumC2258bd.Sound, str));
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static synchronized void m13746a(Context context, String str, File file) {
        try {
            m13750b(context, str, file);
            try {
                C4821am.m18189a(context, "com.sec.chaton.provider2", C2196j.m9898a(EnumC2258bd.Sound, str, C5034k.m19090a()));
                Iterator<InterfaceC3456ac> it = f12910b.iterator();
                while (it.hasNext()) {
                    it.next().m13757a(str);
                }
            } catch (OperationApplicationException e) {
                throw C1057b.m6157a(e);
            } catch (RemoteException e2) {
                throw C1057b.m6157a(e2);
            }
        } catch (IOException e3) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12909a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: a */
    public static synchronized void m13745a(Context context, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("Uninstall sound package. ", str), f12909a);
        }
        try {
            m13752b(context, str);
            try {
                C4821am.m18189a(context, "com.sec.chaton.provider2", ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.Sound).buildUpon().appendPath(str).build()).build());
                Iterator<InterfaceC3457ad> it = f12911c.iterator();
                while (it.hasNext()) {
                    it.next().m13758a(str);
                }
            } catch (OperationApplicationException e) {
                throw C1057b.m6157a(e);
            } catch (RemoteException e2) {
                throw C1057b.m6157a(e2);
            }
        } catch (IOException e3) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12909a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: b */
    public static synchronized File m13750b(Context context, String str, File file) {
        File fileM13756f;
        IOException e;
        try {
            fileM13756f = m13756f(context, str);
            if (fileM13756f == null) {
                fileM13756f = null;
            } else {
                try {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("download_sound, saveSoundFile : ", f12909a);
                        C4904y.m18639b("download_sound   - (from) " + file.getPath().toString(), f12909a);
                        C4904y.m18639b("download_sound   - (to) " + fileM13756f.getPath().toString(), f12909a);
                    }
                    if (!file.renameTo(fileM13756f)) {
                        throw new IOException(C5052r.m19199a("Can't rename sound file.", fileM13756f));
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (C4996f.f18229a.f18174f) {
                        C4996f.f18229a.mo18649a(f12909a, e.getMessage(), e);
                    }
                    return fileM13756f;
                }
            }
        } catch (IOException e3) {
            fileM13756f = null;
            e = e3;
        }
        return fileM13756f;
    }

    /* renamed from: b */
    public static synchronized void m13752b(Context context, String str) {
        File fileM13756f = m13756f(context, str);
        if (fileM13756f != null && fileM13756f.exists()) {
            fileM13756f.delete();
        }
    }

    /* renamed from: c */
    public static Uri m13753c(Context context, String str) {
        Uri uriFromFile;
        if (C3470n.m13797a(str)) {
            uriFromFile = m13754d(context, str);
        } else {
            try {
                uriFromFile = Uri.fromFile(m13756f(context, str));
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f12909a);
                }
                return null;
            }
        }
        if (C4904y.f17872b && uriFromFile != null) {
            C4904y.m18639b("getSoundFileOfAll(), return URI : " + uriFromFile.toString(), f12909a);
            return uriFromFile;
        }
        return uriFromFile;
    }

    /* renamed from: d */
    public static Uri m13754d(Context context, String str) {
        Map<String, C3470n> mapM13796a;
        C3470n c3470n;
        if (C3470n.m13797a(str) && (mapM13796a = C3470n.m13796a()) != null && (c3470n = mapM13796a.get(str)) != null) {
            return Uri.parse(c3470n.f12954s);
        }
        return null;
    }

    /* renamed from: e */
    public static int m13755e(Context context, String str) {
        Map<String, C3470n> mapM13796a;
        C3470n c3470n;
        if (C3470n.m13797a(str) && (mapM13796a = C3470n.m13796a()) != null && (c3470n = mapM13796a.get(str)) != null) {
            return c3470n.f12953r;
        }
        return -1;
    }

    /* renamed from: f */
    public static File m13756f(Context context, String str) {
        if (C3470n.m13797a(str)) {
            return null;
        }
        return new File(m13749b(context), C5052r.m19199a(str, ".snd"));
    }

    /* renamed from: b */
    public static File m13749b(Context context) {
        File file = new File(C5048n.m19190a(context), "sound");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    public static int m13743a() {
        return C4809aa.m18104a().m18120a("new_sound_count", (Integer) 0).intValue();
    }

    /* renamed from: a */
    public static boolean m13747a(String str) {
        String strM18121a = C4809aa.m18104a().m18121a("Ringtone", (String) null);
        if (TextUtils.isEmpty(strM18121a)) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("isAppliedItem(), preference ringtone is (null)", f12909a);
            return false;
        }
        Uri uriM13753c = m13753c(CommonApplication.m18732r(), str);
        if (uriM13753c == null) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("isAppliedItem(), uri (itemId) is (null)", f12909a);
            return false;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("isAppliedItem(), saved/new : " + strM18121a + " / " + uriM13753c.toString(), f12909a);
        }
        return strM18121a.equalsIgnoreCase(uriM13753c.toString());
    }

    /* renamed from: b */
    public static void m13751b() {
        C4809aa.m18104a().m18123a("Ringtone");
        C4809aa.m18104a().m18123a("Ringtone title");
    }

    /* renamed from: a */
    public static boolean m13748a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("download_sound, apply(), itemId is (null) or (empty) ", f12909a);
            return false;
        }
        File fileM13756f = m13756f(CommonApplication.m18732r(), str);
        if (fileM13756f == null || !fileM13756f.exists()) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("download_sound, apply(), itemId / (failed) : " + str.toString(), f12909a);
            return false;
        }
        Uri uriFromFile = Uri.fromFile(fileM13756f);
        C4809aa.m18104a().m18128b("Ringtone", uriFromFile.toString());
        C4809aa.m18104a().m18128b("Ringtone title", str2);
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("download_sound, apply(), itemId / uri : ", str.toString() + "/" + uriFromFile.toString(), ", title : ", str2), f12909a);
        }
        return true;
    }
}
