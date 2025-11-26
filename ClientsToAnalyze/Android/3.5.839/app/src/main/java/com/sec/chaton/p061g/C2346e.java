package com.sec.chaton.p061g;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2097bc;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.google.android.p134a.C5111c;
import com.sec.widget.C5179v;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: InviteHelper.java */
/* renamed from: com.sec.chaton.g.e */
/* loaded from: classes.dex */
public class C2346e {

    /* renamed from: d */
    private static C2346e f8349d = null;

    /* renamed from: c */
    private C2097bc f8352c;

    /* renamed from: a */
    String f8350a = "InviteHelper";

    /* renamed from: e */
    private HashSet<String> f8353e = null;

    /* renamed from: b */
    Handler f8351b = new HandlerC2347f(this, Looper.getMainLooper());

    private C2346e() throws Throwable {
        if (this.f8353e == null) {
            m10273d();
        }
    }

    /* renamed from: a */
    public static C2346e m10271a() {
        if (f8349d == null) {
            f8349d = new C2346e();
        }
        return f8349d;
    }

    /* renamed from: a */
    public void m10274a(String[] strArr) {
        Iterator<String> it = m10275b(strArr).iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                if (!this.f8353e.contains(next)) {
                    PrintWriter printWriter = new PrintWriter(GlobalApplication.m18732r().openFileOutput("InviteHistory.txt", MotionRecognitionManager.EVENT_SMART_ALERT_SETTING));
                    printWriter.println(next);
                    printWriter.close();
                    this.f8353e.add(next);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        C4904y.m18639b("record\n" + this.f8353e.toString(), "InviteHistory");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m10273d() throws java.lang.Throwable {
        /*
            r5 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r5.f8353e = r0
            r0 = 0
            android.content.Context r1 = com.sec.chaton.global.GlobalApplication.m18732r()     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L68
            java.lang.String r2 = "InviteHistory.txt"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L68
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L80
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L80
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L80
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L80
        L1d:
            java.lang.String r0 = r2.readLine()     // Catch: java.io.IOException -> L29 java.lang.Throwable -> L79 java.io.FileNotFoundException -> L80
            if (r0 == 0) goto L2d
            java.util.HashSet<java.lang.String> r3 = r5.f8353e     // Catch: java.io.IOException -> L29 java.lang.Throwable -> L79 java.io.FileNotFoundException -> L80
            r3.add(r0)     // Catch: java.io.IOException -> L29 java.lang.Throwable -> L79 java.io.FileNotFoundException -> L80
            goto L1d
        L29:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L80
        L2d:
            if (r1 == 0) goto L32
            r1.close()     // Catch: java.io.IOException -> L77
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "initCache\n"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.util.HashSet<java.lang.String> r1 = r5.f8353e
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "InviteHistory"
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
            return
        L53:
            r1 = move-exception
        L54:
            java.lang.String r1 = "InviteHistory.txt is not found"
            java.lang.String r2 = "InviteHistory"
            com.sec.chaton.util.C4904y.m18639b(r1, r2)     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L32
            r0.close()     // Catch: java.io.IOException -> L63
            goto L32
        L63:
            r0 = move-exception
        L64:
            r0.printStackTrace()
            goto L32
        L68:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L6c:
            if (r1 == 0) goto L71
            r1.close()     // Catch: java.io.IOException -> L72
        L71:
            throw r0
        L72:
            r1 = move-exception
            r1.printStackTrace()
            goto L71
        L77:
            r0 = move-exception
            goto L64
        L79:
            r0 = move-exception
            goto L6c
        L7b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L6c
        L80:
            r0 = move-exception
            r0 = r1
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p061g.C2346e.m10273d():void");
    }

    /* renamed from: b */
    public void m10276b() {
        int iIntValue = C4809aa.m18104a().m18120a("free_sms_reset_month", (Integer) (-1)).intValue();
        int iIntValue2 = C4809aa.m18104a().m18120a("free_sms_reset_year", (Integer) (-1)).intValue();
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(2);
        int i2 = calendar.get(1);
        if ((iIntValue == i && iIntValue2 == i2) ? false : true) {
            C4809aa.m18104a().m18123a("free_sms_remain_count");
            C4809aa.m18104a().m18123a("free_sms_max_count");
            C4809aa.m18104a().m18123a("free_sms_invitation_count");
            GlobalApplication.m18732r().deleteFile("InviteHistory.txt");
            C4809aa.m18104a().m18126b("free_sms_reset_month", Integer.valueOf(i));
            C4809aa.m18104a().m18126b("free_sms_reset_year", Integer.valueOf(i2));
            this.f8352c = new C2097bc(this.f8351b);
            this.f8352c.m9369a();
        }
    }

    /* renamed from: c */
    public HashSet<String> m10277c() {
        return this.f8353e;
    }

    /* renamed from: a */
    public static Intent m10270a(Context context) {
        HashSet<String> hashSetM10277c = m10271a().m10277c();
        Intent intent = new Intent(context, (Class<?>) BuddyActivity2.class);
        intent.putExtra("ACTIVITY_PURPOSE", 1000);
        intent.putExtra("fromsms", "true");
        intent.putExtra("max", 20);
        intent.putExtra("from_send_invitation", true);
        if (hashSetM10277c != null && hashSetM10277c.size() > 0) {
            intent.putExtra("freesms_invite_list", hashSetM10277c);
        }
        return intent;
    }

    /* renamed from: a */
    public static void m10272a(Context context, int i, Intent intent, boolean z, Handler handler) {
        HashMap map;
        C2344c c2344c;
        if (intent != null && (map = (HashMap) intent.getExtra("result")) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(C3789h.m14307c(C3782a.m14228c((String) it.next())));
            }
            if (arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    try {
                        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(str, C4822an.m18236g().toUpperCase());
                        boolean zIsValidNumber = phoneNumberUtil.isValidNumber(phoneNumber);
                        C4904y.m18639b(phoneNumber + " is isValidNumber : " + zIsValidNumber, "InviteHistory");
                        if (!zIsValidNumber) {
                            Toast toastM19811a = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 1);
                            toastM19811a.setText(CommonApplication.m18732r().getString(R.string.has_invalid_recipient, str));
                            toastM19811a.show();
                        } else {
                            arrayList2.add(String.valueOf(phoneNumber.getCountryCode()));
                            arrayList3.add(String.valueOf(phoneNumber.getNationalNumber()));
                        }
                    } catch (NumberParseException e) {
                        e.printStackTrace();
                    }
                }
                if (arrayList2.size() > 0 && arrayList3.size() > 0) {
                    if (handler != null) {
                        c2344c = new C2344c(context, (String[]) arrayList2.toArray(new String[0]), (String[]) arrayList3.toArray(new String[0]), z, handler);
                    } else {
                        c2344c = new C2344c(context, (String[]) arrayList2.toArray(new String[0]), (String[]) arrayList3.toArray(new String[0]), z, new HandlerC2348g());
                    }
                    try {
                        c2344c.m10266a();
                    } catch (C5111c e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public ArrayList<String> m10275b(String[] strArr) {
        Phonenumber.PhoneNumber phoneNumber;
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            phoneNumber = phoneNumberUtil.parse(strArr[0], C4822an.m18236g().toUpperCase());
        } catch (NumberParseException e) {
            C3890m.m14996b("InviteHistory", "Parsing failed for Number :" + strArr[0]);
            phoneNumber = null;
        }
        StringBuilder sb = new StringBuilder();
        if (phoneNumber != null) {
            sb.append("buddy_phonenumber_external_use LIKE '%" + phoneNumber.getNationalNumber() + "'");
            sb.append(" OR buddy_phonenumber_external_use LIKE '%" + phoneNumber.getNationalNumber() + " %'");
        }
        for (int i = 1; i < strArr.length; i++) {
            try {
                Phonenumber.PhoneNumber phoneNumber2 = phoneNumberUtil.parse(strArr[i], C4822an.m18236g().toUpperCase());
                if (phoneNumber2 != null) {
                    sb.append(" OR buddy_phonenumber_external_use LIKE '%");
                    sb.append(phoneNumber2.getNationalNumber());
                    sb.append("'");
                    sb.append(" OR buddy_phonenumber_external_use LIKE '%");
                    sb.append(phoneNumber2.getNationalNumber());
                    sb.append(" %'");
                }
            } catch (NumberParseException e2) {
                C3890m.m14996b("InviteHistory", "Parsing failed for Number :" + strArr[i]);
                e2.printStackTrace();
            }
        }
        String string = sb.toString();
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2289i.f8196a, null, string, null, null);
        if (cursorQuery != null && cursorQuery.getCount() != 0) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no")));
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }
}
