package com.sec.chaton.smsplugin.p112ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.URLSpan;
import android.view.WindowManager;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.TempFileProvider;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3799r;
import com.sec.chaton.smsplugin.p110g.AbstractC3863i;
import com.sec.chaton.smsplugin.p110g.C3855a;
import com.sec.chaton.smsplugin.p110g.C3856b;
import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p111h.C3875a;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3897t;
import com.sec.chaton.smsplugin.spam.C4012bp;
import com.sec.chaton.smsplugin.spam.C4015bs;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5097t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MessageUtils.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.ui.cd */
/* loaded from: classes.dex */
public class C4149cd {

    /* renamed from: c */
    public static DialogInterface.OnKeyListener f15442c;

    /* renamed from: d */
    private static String f15443d;

    /* renamed from: h */
    private static Point f15447h;

    /* renamed from: e */
    private static final Map<String, String> f15444e = new ConcurrentHashMap(20);

    /* renamed from: a */
    public static final Uri f15440a = Uri.withAppendedPath(Telephony.MmsSms.CONTENT_URI, "wap-push-messages");

    /* renamed from: b */
    public static final Uri f15441b = Uri.withAppendedPath(Telephony.Sms.CONTENT_URI, "group");

    /* renamed from: f */
    private static final char[] f15445f = {'-', '.', ',', '(', ')', ' ', '/', '\\', '*', '#', '+'};

    /* renamed from: g */
    private static HashMap f15446g = new HashMap(f15445f.length);

    static {
        for (int i = 0; i < f15445f.length; i++) {
            f15446g.put(Character.valueOf(f15445f[i]), Character.valueOf(f15445f[i]));
        }
        f15442c = new DialogInterfaceOnKeyListenerC4157cl(null);
        f15447h = new Point();
    }

    /* renamed from: a */
    public static int m16389a(C3870p c3870p) {
        if (c3870p == null) {
            return 0;
        }
        int size = c3870p.size();
        if (size > 1) {
            return 4;
        }
        if (size != 1) {
            return 0;
        }
        C3869o c3869oM14914d = c3870p.get(0);
        if (c3870p.m14922k() > 0) {
            return 5;
        }
        if (c3869oM14914d.m14867g()) {
            return 2;
        }
        if (c3869oM14914d.m14865f() && c3869oM14914d.m14863e()) {
            return 4;
        }
        if (c3869oM14914d.m14865f()) {
            return 3;
        }
        if (c3869oM14914d.m14863e()) {
            return 1;
        }
        if (c3869oM14914d.m14861d()) {
        }
        return 0;
    }

    /* renamed from: a */
    public static String m16393a(Context context, long j) {
        return m16394a(context, j, false);
    }

    /* renamed from: a */
    public static String m16394a(Context context, long j, boolean z) {
        return DateFormat.getTimeFormat(context).format(Long.valueOf(j));
    }

    /* renamed from: a */
    public static void m16399a(Context context, int i) {
        if (context instanceof Activity) {
            Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
            intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", false);
            intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", false);
            intent.putExtra("android.intent.extra.ringtone.INCLUDE_DRM", false);
            intent.putExtra("android.intent.extra.ringtone.TITLE", context.getString(R.string.select_audio));
            ((PluginComposeMessageActivity) context).startActivityForResult(intent, i);
        }
    }

    /* renamed from: a */
    public static void m16400a(Context context, int i, long j) {
        if (context instanceof Activity) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("audio/amr");
            intent.setClassName("com.android.soundrecorder", "com.android.soundrecorder.SoundRecorder");
            intent.putExtra("android.provider.MediaStore.extra.MAX_BYTES", j);
            ((PluginComposeMessageActivity) context).startActivityForResult(intent, i);
        }
    }

    /* renamed from: b */
    public static void m16422b(Context context, int i, long j) {
        if (context instanceof Activity) {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", 0);
            if (C3847e.m14657aH()) {
                long jM14660aK = C3847e.m14660aK();
                if (jM14660aK > 0) {
                    j = Math.min(j, jM14660aK);
                }
            }
            intent.putExtra("android.intent.extra.sizeLimit", j);
            intent.putExtra("mms", true);
            intent.putExtra("output", TempFileProvider.f13544a);
            ((PluginComposeMessageActivity) context).startActivityForResult(intent, i);
        }
    }

    /* renamed from: b */
    public static void m16421b(Context context, int i) {
        m16401a(context, i, "video/*");
    }

    /* renamed from: c */
    public static void m16427c(Context context, int i) {
        m16401a(context, i, "image/*");
    }

    /* renamed from: a */
    private static void m16401a(Context context, int i, String str) {
        if (context instanceof Activity) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType(str);
            ((Activity) context).startActivityForResult(intent, i);
        }
    }

    /* renamed from: a */
    public static void m16409a(Context context, C3870p c3870p) {
        C3856b c3856bM14876p;
        String strM14812m;
        if (!c3870p.m14916e()) {
            throw new IllegalArgumentException("viewSimpleSlideshow() called on a non-simple slideshow");
        }
        C3869o c3869oM14914d = c3870p.get(0);
        if (c3869oM14914d.m14863e()) {
            c3856bM14876p = c3869oM14914d.m14875o();
        } else if (c3869oM14914d.m14867g()) {
            c3856bM14876p = c3869oM14914d.m14877q();
        } else if (!c3869oM14914d.m14865f()) {
            c3856bM14876p = null;
        } else {
            c3856bM14876p = c3869oM14914d.m14876p();
        }
        if (c3856bM14876p != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(1);
            intent.putExtra("SingleItemOnly", true);
            if (c3856bM14876p.m14823x()) {
                strM14812m = c3856bM14876p.m14802C().m14729e();
            } else {
                strM14812m = c3856bM14876p.m14812m();
            }
            intent.setDataAndType(c3856bM14876p.m14813n(), strM14812m);
            context.startActivity(intent);
        }
    }

    /* renamed from: a */
    public static void m16410a(Context context, String str, String str2) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        abstractC4932aM18733a.mo18753c(android.R.drawable.ic_dialog_alert);
        abstractC4932aM18733a.mo18740a(str);
        abstractC4932aM18733a.mo18749b(str2);
        abstractC4932aM18733a.mo18756d(android.R.string.ok, new DialogInterfaceOnClickListenerC4150ce());
        abstractC4932aM18733a.mo18752b();
    }

    /* renamed from: a */
    public static void m16404a(Context context, Uri uri, Handler handler, InterfaceC4158cm interfaceC4158cm, boolean z) {
        RunnableC4151cf runnableC4151cf = new RunnableC4151cf(context);
        handler.postDelayed(runnableC4151cf, 1000L);
        new Thread(new RunnableC4152cg(context, uri, handler, runnableC4151cf, interfaceC4158cm, z)).start();
    }

    /* renamed from: a */
    public static void m16402a(Context context, DialogInterface.OnClickListener onClickListener) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        abstractC4932aM18733a.mo18734a(R.string.discard_message);
        abstractC4932aM18733a.mo18746b(R.string.discard_message_reason);
        abstractC4932aM18733a.mo18756d(R.string.dialog_ok, onClickListener);
        abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
        abstractC4932aM18733a.mo18752b();
    }

    /* renamed from: a */
    public static String m16391a() {
        if (f15443d == null) {
            f15443d = GlobalApplication.m10279a().m10295j().getLine1Number();
        }
        return f15443d;
    }

    /* renamed from: a */
    public static void m16412a(Context context, Collection<Long> collection, int i, Runnable runnable) {
        String[] strArr;
        StringBuilder sb = new StringBuilder("m_type = 132 AND read = 0 AND rr = 128");
        if (collection != null) {
            StringBuilder sb2 = new StringBuilder();
            strArr = new String[collection.size()];
            Iterator<Long> it = collection.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                if (i2 > 0) {
                    sb2.append(" OR ");
                }
                sb2.append("thread_id").append("=?");
                strArr[i2] = Long.toString(jLongValue);
                i2++;
            }
            sb.append(" AND (" + sb2.toString() + ")");
        } else {
            strArr = null;
        }
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), Telephony.Mms.Inbox.CONTENT_URI, new String[]{"_id", "m_id"}, sb.toString(), strArr, (String) null);
        if (cursorQuery != null) {
            HashMap map = new HashMap();
            try {
                if (cursorQuery.getCount() == 0) {
                    if (runnable != null) {
                        runnable.run();
                    }
                } else {
                    while (cursorQuery.moveToNext()) {
                        map.put(cursorQuery.getString(1), C3875a.m14950a(context, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, cursorQuery.getLong(0))));
                    }
                    cursorQuery.close();
                    m16403a(context, new DialogInterfaceOnClickListenerC4154ci(map, context, i, runnable), new DialogInterfaceOnClickListenerC4155cj(runnable), new DialogInterfaceOnCancelListenerC4156ck(runnable));
                }
            } finally {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: a */
    private static void m16403a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        abstractC4932aM18733a.mo18751b(true);
        abstractC4932aM18733a.mo18734a(R.string.confirm);
        abstractC4932aM18733a.mo18746b(R.string.message_send_read_report);
        abstractC4932aM18733a.mo18756d(R.string.yes, onClickListener);
        abstractC4932aM18733a.mo18747b(R.string.no, onClickListener2);
        abstractC4932aM18733a.mo18737a(onCancelListener);
        abstractC4932aM18733a.mo18752b();
    }

    /* renamed from: a */
    public static String m16395a(Cursor cursor, int i, int i2) {
        String string = cursor.getString(i);
        int i3 = cursor.getInt(i2);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (i3 != 0) {
            return (i3 == 106 && (i == 1 || i == 4)) ? string : new C5082e(i3, string).m19308c();
        }
        return string;
    }

    /* renamed from: a */
    public static ArrayList<String> m16397a(URLSpan[] uRLSpanArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (URLSpan uRLSpan : uRLSpanArr) {
            arrayList.add(uRLSpan.getURL());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m16405a(Context context, Uri uri, C3870p c3870p) {
        m16406a(context, uri, c3870p, 0);
    }

    /* renamed from: a */
    private static void m16406a(Context context, Uri uri, C3870p c3870p, int i) {
        if (c3870p == null ? false : c3870p.m14916e()) {
            m16409a(context, c3870p);
            return;
        }
        if (c3870p != null) {
            C5097t c5097tM19426a = C5097t.m19426a(context);
            try {
                C5086i c5086iM14899a = c3870p.m14899a();
                c5097tM19426a.m19450a(uri, c5086iM14899a);
                c3870p.m14905a(c5086iM14899a);
            } catch (C5111c e) {
                C3890m.m14999e("Mms", "Unable to save message for preview");
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) SlideshowActivity.class);
        intent.setData(uri);
        if (i > 0 && (context instanceof Activity)) {
            ((PluginComposeMessageActivity) context).startActivityForResult(intent, i);
        } else {
            context.startActivity(intent);
        }
    }

    /* renamed from: a */
    public static void m16407a(Context context, C3799r c3799r, int i) {
        C3870p c3870pM14457g = c3799r.m14457g();
        if (c3870pM14457g == null) {
            throw new IllegalStateException("msg.getSlideshow() == null");
        }
        if (c3870pM14457g.m14916e()) {
            m16409a(context, c3870pM14457g);
            return;
        }
        Uri uriM14450c = c3799r.m14450c(false);
        if (uriM14450c != null) {
            m16406a(context, uriM14450c, (C3870p) null, i);
        }
    }

    /* renamed from: b */
    public static void m16420b() throws IOException {
        String str = Environment.getExternalStorageDirectory() + "/mms_oom_hprof_data";
        try {
            Debug.dumpHprofData(str);
            C3890m.m14997c("Mms", "##### written hprof data to " + str);
        } catch (IOException e) {
            C3890m.m14999e("Mms", "writeHprofDataToFile: caught " + e);
        }
    }

    /* renamed from: a */
    public static boolean m16418a(String str) {
        if (!C3847e.m14631O()) {
            return false;
        }
        int length = str == null ? 0 : str.length();
        if (str == null || length < C3847e.m14632P() || length > C3847e.m14633Q() || !Character.isLetter(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '.') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: p */
    private static String m16447p(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '+' && sb.length() == 0) {
                sb.append(cCharAt);
            } else if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            } else if (f15446g.get(Character.valueOf(cCharAt)) == null) {
                return null;
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m16425b(String str) {
        return m16437g(str) != null;
    }

    /* renamed from: c */
    public static boolean m16429c(String str) {
        return (m16441j(str) || m16433e(str) == null) ? false : true;
    }

    /* renamed from: d */
    public static boolean m16432d(String str) {
        if (str.length() < C3847e.m14663aN()) {
            return false;
        }
        return C3847e.m14662aM() <= -1 || str.length() <= C3847e.m14662aM();
    }

    /* renamed from: e */
    public static String m16433e(String str) {
        if (m16436f(str)) {
            str = m16439h(str);
        }
        String strM16447p = m16447p(str);
        if ("".equals(strM16447p)) {
            return null;
        }
        if (C3847e.m14657aH() && strM16447p != null && !m16432d(strM16447p)) {
            return null;
        }
        if (strM16447p != null) {
            return strM16447p;
        }
        if (m16418a(str)) {
            return str;
        }
        return null;
    }

    /* renamed from: f */
    public static boolean m16436f(String str) {
        int iIndexOf = str.indexOf(" <");
        int iIndexOf2 = str.indexOf(62);
        if (iIndexOf == -1) {
            return false;
        }
        return iIndexOf2 == -1 || iIndexOf2 > iIndexOf;
    }

    /* renamed from: g */
    public static String m16437g(String str) {
        if (!Telephony.Mms.isEmailAddress(str)) {
            String strM16447p = m16447p(str);
            if (strM16447p != null) {
                return strM16447p;
            }
            if ((!C3847e.m14657aH() || strM16447p == null || m16432d(strM16447p)) && m16418a(str)) {
                return str;
            }
            return null;
        }
        return str;
    }

    /* renamed from: h */
    public static String m16439h(String str) {
        if (str == null) {
            return "";
        }
        try {
            if (str.length() == 0) {
                return "";
            }
            int iIndexOf = str.indexOf(60);
            int iIndexOf2 = str.indexOf(62);
            int i = iIndexOf < 0 ? 0 : iIndexOf + 1;
            if (iIndexOf2 < 0) {
                iIndexOf2 = str.length();
            }
            return str.substring(i, iIndexOf2);
        } catch (StringIndexOutOfBoundsException e) {
            C3890m.m14999e("Mms", "Illegal name and number format!");
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: i */
    public static final String m16440i(String str) {
        C3890m.m14994a("Mms", "[convertCharaterforKOR] src.length() " + str.length());
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            switch (sb.charAt(i)) {
                case 7:
                    sb.setCharAt(i, (char) 9679);
                    break;
                case 162:
                    sb.setCharAt(i, (char) 65504);
                    break;
                case 163:
                    sb.setCharAt(i, (char) 65505);
                    break;
                case 165:
                    sb.setCharAt(i, (char) 65509);
                    break;
                case 169:
                    sb.setCharAt(i, (char) 9426);
                    break;
                case 171:
                    sb.setCharAt(i, (char) 8810);
                    break;
                case 187:
                    sb.setCharAt(i, (char) 8811);
                    break;
                case 4510:
                    sb.setCharAt(i, (char) 12685);
                    break;
                case 4514:
                    sb.setCharAt(i, (char) 8229);
                    break;
                case 8226:
                    sb.setCharAt(i, (char) 183);
                    break;
                case 8361:
                    sb.setCharAt(i, (char) 65510);
                    break;
                case 65533:
                    sb.setCharAt(i, ' ');
                    break;
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m16392a(long j, int i) {
        return DateFormat.format("yyyyMMdd_kkmmss", j).toString() + "_" + i;
    }

    /* renamed from: j */
    public static boolean m16441j(String str) {
        if (str == null || str.indexOf(64) != -1) {
            return Telephony.Mms.isEmailAddress(str);
        }
        return false;
    }

    /* renamed from: k */
    public static int[] m16442k(String str) {
        if (str == null) {
            return new int[4];
        }
        int[] iArr = new int[4];
        int length = str.length();
        if (!C3847e.m14669aa()) {
            int i = 0;
            int i2 = 0;
            while (i < length && str.charAt(i) <= 127) {
                i2++;
                i++;
            }
            iArr[0] = 1;
            if (i == length) {
                iArr[1] = i2;
                iArr[2] = C3847e.m14670ab() - iArr[1];
                iArr[3] = 1;
                iArr[0] = (i2 / (C3847e.m14670ab() + 1)) + 1;
            } else {
                iArr[1] = str.length();
                iArr[2] = C3847e.m14670ab() - (iArr[1] * 2);
                iArr[3] = 3;
                iArr[0] = ((iArr[1] * 2) / (C3847e.m14670ab() + 1)) + 1;
            }
        } else {
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (str.charAt(i4) > 127) {
                    i3 += 2;
                } else {
                    i3++;
                }
            }
            iArr[3] = C3847e.m14670ab();
            iArr[2] = iArr[3] - (i3 % (iArr[3] + 1));
            iArr[1] = i3 % (iArr[3] + 1);
            iArr[0] = (i3 / (iArr[3] + 1)) + 1;
        }
        return iArr;
    }

    /* renamed from: c */
    public static int m16426c() {
        ((WindowManager) GlobalApplication.m10279a().getSystemService("window")).getDefaultDisplay().getSize(f15447h);
        return f15447h.x;
    }

    /* renamed from: d */
    public static int m16430d() {
        ((WindowManager) GlobalApplication.m10279a().getSystemService("window")).getDefaultDisplay().getSize(f15447h);
        return f15447h.y;
    }

    /* renamed from: l */
    public static int m16443l(String str) {
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += str.charAt(i2) > 127 ? 2 : 1;
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m16414a(Context context) {
        if (((DevicePolicyManager) context.getSystemService("device_policy")) == null) {
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[PHI: r1
  0x0053: PHI (r1v1 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v0 boolean), (r1v2 boolean), (r1v2 boolean), (r1v2 boolean) binds: [B:18:0x0056, B:19:0x0058, B:21:0x005e, B:12:0x0049, B:13:0x004b, B:15:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m16424b(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 1
            r1 = 0
            int r2 = m16419b(r6)
            java.lang.String r3 = "Mms"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "SpamMessageFilterForVIPMode - number : "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            com.sec.chaton.smsplugin.p111h.C3890m.m14996b(r3, r4)
            if (r2 != r0) goto L3d
        L22:
            java.lang.String r1 = "Mms"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "SpamMessageFilterForVIPMode: isSpam = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.sec.chaton.smsplugin.p111h.C3890m.m14996b(r1, r2)
            return r0
        L3d:
            r3 = 2
            if (r2 != r3) goto L55
            if (r7 == 0) goto L49
            boolean r2 = m16415a(r6, r7)
            if (r2 != r0) goto L49
            r1 = r0
        L49:
            if (r1 != 0) goto L53
            if (r8 == 0) goto L53
            boolean r2 = m16423b(r6, r8)
            if (r2 == r0) goto L22
        L53:
            r0 = r1
            goto L22
        L55:
            r3 = 3
            if (r2 != r3) goto L53
            if (r7 == 0) goto L53
            boolean r2 = m16428c(r6, r7)
            if (r2 != 0) goto L53
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4149cd.m16424b(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m16419b(android.content.Context r7) {
        /*
            r2 = 0
            java.lang.String r0 = "com.sec.android.app.firewall"
            java.lang.String r0 = "mode"
            java.lang.String r0 = "vip_mode"
            java.lang.String r0 = "black_msg"
            java.lang.String r0 = "white_msg"
            java.lang.String r0 = "content://com.sec.android.app.firewall/mode"
            android.net.Uri r1 = android.net.Uri.parse(r0)
            r6 = 0
            android.content.ContentResolver r0 = r7.getContentResolver()
            r3 = r2
            r4 = r2
            r5 = r2
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L8d
            boolean r0 = r1.moveToFirst()
            if (r0 == 0) goto L8d
            java.lang.String r0 = "vip_mode"
            int r0 = r1.getColumnIndex(r0)
            int r0 = r1.getInt(r0)
            java.lang.String r2 = "Mms"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "firewallOnOff = "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.sec.chaton.smsplugin.p111h.C3890m.m14996b(r2, r3)
            r2 = 1
            if (r0 != r2) goto L7e
            java.lang.String r0 = "black_msg"
            int r0 = r1.getColumnIndex(r0)
            int r0 = r1.getInt(r0)
        L5e:
            if (r1 == 0) goto L63
            r1.close()
        L63:
            java.lang.String r1 = "Mms"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "MessageBlockMode = "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.sec.chaton.smsplugin.p111h.C3890m.m14996b(r1, r2)
            return r0
        L7e:
            r2 = 2
            if (r0 != r2) goto L8d
            java.lang.String r0 = "white_msg"
            int r0 = r1.getColumnIndex(r0)
            int r0 = r1.getInt(r0)
            goto L5e
        L8d:
            r0 = r6
            goto L5e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4149cd.m16419b(android.content.Context):int");
    }

    /* renamed from: a */
    public static boolean m16415a(Context context, String str) {
        boolean z = false;
        Uri uri = Uri.parse("content://com.sec.android.app.firewall/black_msg_num");
        if (str != null && !"".equals(str)) {
            Cursor cursorQuery = context.getContentResolver().query(uri, null, "checked=1", null, null);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                for (int i = 0; i < cursorQuery.getCount(); i++) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("numbers"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("criteria"));
                    C3890m.m14996b("Mms", "isVIPModeBlackNumberMessage - rejectNumber : " + string);
                    C3890m.m14996b("Mms", "isFirewallRejectNumberMessage - criteria : " + i2);
                    switch (i2) {
                        case 0:
                            if (PhoneNumberUtils.compareStrictly(string, str)) {
                                z = true;
                                break;
                            }
                            break;
                        case 1:
                            if (str.startsWith(string)) {
                                z = true;
                                break;
                            }
                            break;
                        case 2:
                            if (str.endsWith(string)) {
                                z = true;
                                break;
                            }
                            break;
                        case 3:
                            if (str.contains(string)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    if (!z) {
                        cursorQuery.moveToNext();
                    } else {
                        cursorQuery.close();
                    }
                }
                cursorQuery.close();
            } else {
                C3890m.m14996b("Mms", "isVIPModeBlackNumberMessage - cursor is null");
            }
            C3890m.m14996b("Mms", "isVIPModeBlackNumberMessage - " + z);
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m16423b(Context context, String str) {
        boolean z = false;
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.sec.android.app.firewall/black_msg_str"), null, "checked=1", null, null);
        if (cursorQuery != null) {
            cursorQuery.moveToFirst();
            int i = 0;
            while (true) {
                if (i >= cursorQuery.getCount()) {
                    break;
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("text"));
                C3890m.m14996b("Mms", "isVIPModeBlackStringMessage - rejectNumber : " + string);
                if (str.contains(string)) {
                    z = true;
                    break;
                }
                cursorQuery.moveToNext();
                i++;
            }
            cursorQuery.close();
        } else {
            C3890m.m14996b("Mms", "isVIPModeBlackStringMessage - cursor is null");
        }
        C3890m.m14996b("Mms", "isVIPModeBlackStringMessage - " + z);
        return z;
    }

    /* renamed from: c */
    public static boolean m16428c(Context context, String str) {
        boolean z = false;
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.sec.android.app.firewall/white_msg_num"), null, "checked=1", null, null);
        if (cursorQuery != null) {
            cursorQuery.moveToFirst();
            int i = 0;
            while (true) {
                if (i >= cursorQuery.getCount()) {
                    break;
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("numbers"));
                C3890m.m14996b("Mms", "isVIPModeWhiteNumberMessage - acceptNumber : " + string);
                if (PhoneNumberUtils.compareStrictly(string, str)) {
                    z = true;
                    break;
                }
                cursorQuery.moveToNext();
                i++;
            }
            cursorQuery.close();
        } else {
            C3890m.m14996b("Mms", "isVIPModeWhiteNumberMessage - cursor is null");
        }
        C3890m.m14996b("Mms", "isVIPModeWhiteNumberMessage - " + z);
        return z;
    }

    /* renamed from: d */
    public static boolean m16431d(Context context, String str) {
        return C4015bs.m15438a(context, 0, str);
    }

    /* renamed from: m */
    public static boolean m16444m(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!PhoneNumberUtils.isReallyDialable(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m16434e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(context, R.string.number_not_found, 0).show();
            return false;
        }
        if (C3847e.m14671ac() && C3847e.m14672ad()) {
            C4012bp.m15422a(context, 0, str.replaceAll("[\\s\\-()]", ""), true, 0);
            Toast.makeText(context, R.string.noti_registered_as_spamnumber, 0).show();
            return true;
        }
        if (C4015bs.m15438a(context, 0, str)) {
            Toast.makeText(context, R.string.spam_number_save_already, 0).show();
            return false;
        }
        if (!m16444m(str.replaceAll("[\\s\\-()]", ""))) {
            Toast.makeText(context, R.string.spam_number_validation, 0).show();
            return false;
        }
        C4012bp.m15422a(context, 0, str.replaceAll("[\\s\\-()]", ""), true, 0);
        Toast.makeText(context, R.string.noti_registered_as_spamnumber, 0).show();
        return true;
    }

    /* renamed from: f */
    public static boolean m16435f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(context, R.string.number_not_found, 0).show();
            return false;
        }
        if (!C4015bs.m15438a(context, 0, str)) {
            return false;
        }
        C4012bp.m15421a(context, 0, str);
        return true;
    }

    /* renamed from: n */
    public static String m16445n(String str) {
        char[] cArr = {'\\', '/', ':', '*', '?', '\"', '<', '>', '|', ';', '\n'};
        int length = str.length();
        int i = 0;
        String str2 = str;
        while (i < length) {
            char cCharAt = str2.charAt(i);
            String strReplace = str2;
            for (char c2 : cArr) {
                if (cCharAt == c2) {
                    strReplace = strReplace.replace(strReplace.charAt(i), '_');
                }
            }
            i++;
            str2 = strReplace;
        }
        C3890m.m14996b("Mms", "replaceInvalidFilename(),from=" + str + ",to=" + str2);
        return str2;
    }

    /* renamed from: a */
    public static Bitmap m16390a(Context context, Uri uri) throws IOException {
        Bitmap frameAtTime = null;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(context, uri);
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                mediaMetadataRetriever.release();
            } catch (RuntimeException e) {
                mediaMetadataRetriever.release();
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e2) {
                }
                throw th;
            }
        } catch (RuntimeException e3) {
        }
        return frameAtTime;
    }

    /* renamed from: a */
    public static void m16408a(Context context, C3866l c3866l) {
        String strM14744a;
        String strM14812m;
        Uri uriM14746b = null;
        if (c3866l != null) {
            if (c3866l instanceof AbstractC3863i) {
                AbstractC3863i abstractC3863i = (AbstractC3863i) c3866l;
                if (abstractC3863i.m14823x()) {
                    strM14812m = abstractC3863i.m14802C().m14729e();
                } else {
                    strM14812m = abstractC3863i.m14812m();
                }
                strM14744a = strM14812m;
                uriM14746b = abstractC3863i.m14813n();
            } else if (c3866l instanceof C3855a) {
                C3855a c3855a = (C3855a) c3866l;
                strM14744a = c3855a.m14744a();
                uriM14746b = c3855a.m14746b();
            } else {
                strM14744a = null;
            }
            if (strM14744a == null || uriM14746b == null) {
                C3890m.m14999e("Mms", "can't get model data");
                return;
            }
            String lowerCase = strM14744a.toLowerCase();
            if (lowerCase.startsWith(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                C3897t.m15054d(context, uriM14746b, lowerCase);
                return;
            }
            if (lowerCase.startsWith("video")) {
                C3897t.m15052b(context, uriM14746b, lowerCase);
                return;
            }
            if ("text/x-vcard".equalsIgnoreCase(lowerCase)) {
                C3897t.m15055e(context, uriM14746b, lowerCase);
                return;
            }
            if ("text/x-vcalendar".equalsIgnoreCase(lowerCase)) {
                C3897t.m15053c(context, uriM14746b, lowerCase);
            } else if ("text/x-vtodo".equalsIgnoreCase(lowerCase)) {
                C3897t.m15057g(context, uriM14746b, lowerCase);
            } else {
                C3897t.m15049a(context, uriM14746b, lowerCase);
            }
        }
    }

    /* renamed from: a */
    public static boolean m16417a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        int iCodePointAt = Character.codePointAt(charSequence, 0);
        byte directionality = Character.getDirectionality(iCodePointAt);
        int i = 0;
        while (true) {
            if ((directionality != 13 && ((iCodePointAt < 48 || iCodePointAt > 57) && iCodePointAt != 32)) || (i = i + 1) >= length) {
                break;
            }
            iCodePointAt = Character.codePointAt(charSequence, i);
            directionality = Character.getDirectionality(iCodePointAt);
        }
        return directionality == 1 || directionality == 2 || directionality == 16 || directionality == 17;
    }

    /* renamed from: a */
    public static void m16398a(Activity activity, String str, String str2) {
        if (!TextUtils.isEmpty(str) && activity.getFragmentManager().findFragmentByTag("link_action") == null) {
            try {
                DialogFragmentC4094ac.m16291a(str, str2).show(activity.getFragmentManager(), "link_action");
            } catch (IllegalStateException e) {
                C3890m.m14999e("Mms", "Exception: " + e.toString());
            }
        }
    }

    /* renamed from: a */
    public static boolean m16416a(C3782a c3782a) {
        String strM14264f = c3782a.m14264f();
        if (!TextUtils.isEmpty(c3782a.m14262d()) && m16413a(c3782a.m14262d().charAt(0))) {
            return false;
        }
        if (TextUtils.isEmpty(strM14264f) || !m16413a(strM14264f.charAt(0))) {
            return Telephony.Mms.isEmailAddress(strM14264f) || Telephony.Mms.isPhoneNumber(strM14264f) || c3782a.m14260b();
        }
        return false;
    }

    /* renamed from: o */
    public static boolean m16446o(String str) {
        if (TextUtils.isEmpty(str) || m16413a(str.charAt(0))) {
            return false;
        }
        if (!m16418a(str)) {
            return m16425b(str);
        }
        C3890m.m14999e("Mms", "alias number just return false meaning cannot add contact");
        return false;
    }

    /* renamed from: a */
    public static boolean m16413a(char c2) {
        return C3847e.m14684ap() ? c2 == '%' || c2 == '$' : c2 == '*' || c2 == '%' || c2 == '$';
    }

    /* renamed from: g */
    public static void m16438g(Context context, String str) {
        m16411a(context, str, false, (String) null);
    }

    /* renamed from: a */
    public static void m16411a(Context context, String str, boolean z, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.indexOf(":") > 0) {
                str = str.split(":")[1];
            }
            C3890m.m14996b("Mms", "Make a call");
            Intent intent = new Intent("android.intent.action.CALL_PRIVILEGED", Uri.fromParts("tel", str, null));
            if (z) {
                intent.putExtra("ipcall", true);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("android.phone.extra.CALL_DIRECTCALL_DIRECTION", str2);
            }
            intent.setFlags(335544320);
            C3897t.m15050a(context, intent);
        }
    }

    /* renamed from: a */
    public static String m16396a(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str2 : strArr) {
            if (str2 != null && str2.length() != 0) {
                if (z) {
                    z = false;
                } else {
                    sb.append(str);
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
