package com.sec.chaton.settings.downloads;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.EnumC1774f;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1355ad;
import com.sec.chaton.p027e.p028a.C1366j;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3350l;
import com.sec.common.util.C3364o;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: SoundHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.df */
/* loaded from: classes.dex */
public class C2620df {

    /* renamed from: a */
    private static final String f9845a = C2620df.class.getSimpleName();

    /* renamed from: b */
    private static final List<InterfaceC2622dh> f9846b = new ArrayList();

    /* renamed from: c */
    private static final List<InterfaceC2623di> f9847c = new ArrayList();

    /* renamed from: a */
    public static ArrayList<ContentProviderOperation> m9594a(Context context) {
        File fileM9611f;
        String[] strArrM5978a = C1355ad.m5978a(context);
        if (strArrM5978a == null || strArrM5978a.length <= 0) {
            return null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        for (String str : strArrM5978a) {
            if (!C2559az.m9507a(str) && ((fileM9611f = m9611f(context, str)) == null || !fileM9611f.exists())) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_sound, checkValidationAndUpdateInstallStatus(), file does not exist (id/path)" + str + "/" + fileM9611f.getPath(), f9845a);
                }
                arrayList.add(C1366j.m6092a(EnumC1399aq.Sound, str));
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static synchronized void m9596a(Context context, String str, File file) {
        try {
            m9602b(context, str, file);
            try {
                C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6093a(EnumC1399aq.Sound, str, C3347i.m11774a()));
                Iterator<InterfaceC2622dh> it = f9846b.iterator();
                while (it.hasNext()) {
                    it.next().m9612a(str);
                }
            } catch (OperationApplicationException e) {
                throw new IOException(e);
            } catch (RemoteException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9845a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: a */
    public static synchronized void m9595a(Context context, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("Uninstall sound package. ", str), f9845a);
        }
        try {
            m9604b(context, str);
            try {
                C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6092a(EnumC1399aq.Sound, str));
                Iterator<InterfaceC2623di> it = f9847c.iterator();
                while (it.hasNext()) {
                    it.next().m9613a(str);
                }
            } catch (OperationApplicationException e) {
                throw new IOException(e);
            } catch (RemoteException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9845a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: b */
    public static synchronized File m9602b(Context context, String str, File file) {
        File fileM9611f;
        IOException e;
        try {
            fileM9611f = m9611f(context, str);
            if (fileM9611f == null) {
                fileM9611f = null;
            } else {
                try {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download_sound, saveSoundFile : ", f9845a);
                        C3250y.m11450b("download_sound   - (from) " + file.getPath().toString(), f9845a);
                        C3250y.m11450b("download_sound   - (to) " + fileM9611f.getPath().toString(), f9845a);
                    }
                    if (!file.renameTo(fileM9611f)) {
                        throw new IOException(C3364o.m11849a("Can't rename sound file.", fileM9611f));
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (C3330f.f12033a.f11975e) {
                        C3330f.f12033a.m11652a(f9845a, e.getMessage(), e);
                    }
                    return fileM9611f;
                }
            }
        } catch (IOException e3) {
            fileM9611f = null;
            e = e3;
        }
        return fileM9611f;
    }

    /* renamed from: b */
    public static synchronized void m9604b(Context context, String str) {
        File fileM9611f = m9611f(context, str);
        if (fileM9611f != null && fileM9611f.exists()) {
            fileM9611f.delete();
        }
    }

    /* renamed from: c */
    public static Uri m9606c(Context context, String str) {
        Uri uriFromFile;
        if (C2559az.m9507a(str)) {
            uriFromFile = m9608d(context, str);
        } else {
            try {
                uriFromFile = Uri.fromFile(m9611f(context, str));
            } catch (Exception e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9845a);
                }
                return null;
            }
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("getSoundFileOfAll(), return URI : " + uriFromFile.toString(), f9845a);
            return uriFromFile;
        }
        return uriFromFile;
    }

    /* renamed from: d */
    public static Uri m9608d(Context context, String str) {
        Map<String, C2559az> mapM9506a;
        C2559az c2559az;
        if (C2559az.m9507a(str) && (mapM9506a = C2559az.m9506a()) != null && (c2559az = mapM9506a.get(str)) != null) {
            return Uri.parse(c2559az.f9738s);
        }
        return null;
    }

    /* renamed from: e */
    public static int m9610e(Context context, String str) {
        Map<String, C2559az> mapM9506a;
        C2559az c2559az;
        if (C2559az.m9507a(str) && (mapM9506a = C2559az.m9506a()) != null && (c2559az = mapM9506a.get(str)) != null) {
            return c2559az.f9737r;
        }
        return -1;
    }

    /* renamed from: f */
    public static File m9611f(Context context, String str) {
        if (C2559az.m9507a(str)) {
            return null;
        }
        return new File(m9601b(context), C3364o.m11849a(str, ".snd"));
    }

    /* renamed from: b */
    public static File m9601b(Context context) {
        File file = new File(C3350l.m11800a(context), "sound");
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    public static void m9597a(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.chatlist_font_size_last_message));
        textView.setTextColor(resources.getColor(R.color.download_before_color));
    }

    /* renamed from: b */
    public static void m9605b(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.chatlist_font_size_last_message));
        textView.setTextColor(resources.getColor(R.color.download_after_color));
    }

    /* renamed from: c */
    public static void m9607c(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.downloading_font_size));
        textView.setTextColor(resources.getColor(R.color.black));
    }

    /* renamed from: d */
    public static void m9609d(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.chatlist_font_size_last_message));
        textView.setTextColor(resources.getColor(R.color.black));
    }

    /* renamed from: a */
    static int m9593a(EnumC2624dj enumC2624dj) {
        switch (C2621dg.f9848a[enumC2624dj.ordinal()]) {
            case 1:
                return R.drawable.chat_attach_btn_play;
            case 2:
                return R.drawable.chat_attach_btn_pause;
            case 3:
                return R.drawable.chat_attach_btn_loading;
            default:
                return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static boolean m9598a(ImageView imageView, EnumC1774f enumC1774f) throws Resources.NotFoundException {
        if (imageView == null || enumC1774f == null) {
            return false;
        }
        switch (C2621dg.f9849b[enumC1774f.ordinal()]) {
            case 1:
                Drawable drawable = PushClientApplication.m8156h().getResources().getDrawable(m9593a(EnumC2624dj.BUTTON_PROGRESS));
                imageView.setImageDrawable(drawable);
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                return true;
            case 2:
            case 3:
                imageView.setImageResource(m9593a(EnumC2624dj.BUTTON_STOP));
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
                imageView.setImageResource(m9593a(EnumC2624dj.BUTTON_PLAY));
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    public static int m9592a() {
        return C3159aa.m10962a().m10978a("new_sound_count", (Integer) 0).intValue();
    }

    /* renamed from: a */
    public static boolean m9599a(String str) {
        String strM10979a = C3159aa.m10962a().m10979a("Ringtone", (String) null);
        if (TextUtils.isEmpty(strM10979a)) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("isAppliedItem(), preference ringtone is (null)", f9845a);
            return false;
        }
        Uri uriM9606c = m9606c(CommonApplication.m11493l(), str);
        if (uriM9606c == null) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("isAppliedItem(), uri (itemId) is (null)", f9845a);
            return false;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("isAppliedItem(), saved/new : " + strM10979a + " / " + uriM9606c.toString(), f9845a);
        }
        return strM10979a.equalsIgnoreCase(uriM9606c.toString());
    }

    /* renamed from: b */
    public static void m9603b() {
        C3159aa.m10962a().m10981a("Ringtone");
        C3159aa.m10962a().m10981a("Ringtone title");
    }

    /* renamed from: a */
    public static boolean m9600a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("download_sound, apply(), itemId is (null) or (empty) ", f9845a);
            return false;
        }
        File fileM9611f = m9611f(CommonApplication.m11493l(), str);
        if (fileM9611f == null || !fileM9611f.exists()) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("download_sound, apply(), itemId / (failed) : " + str.toString(), f9845a);
            return false;
        }
        Uri uriFromFile = Uri.fromFile(fileM9611f);
        C3159aa.m10962a().m10986b("Ringtone", uriFromFile.toString());
        C3159aa.m10962a().m10986b("Ringtone title", str2);
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("download_sound, apply(), itemId / uri : ", str.toString() + "/" + uriFromFile.toString(), ", title : ", str2), f9845a);
        }
        return true;
    }
}
