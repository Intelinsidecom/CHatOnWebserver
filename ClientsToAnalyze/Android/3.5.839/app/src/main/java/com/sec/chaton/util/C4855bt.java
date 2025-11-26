package com.sec.chaton.util;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p067j.C2433c;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.trunk.p121c.C4636a;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;

/* compiled from: ProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.bt */
/* loaded from: classes.dex */
public class C4855bt {

    /* renamed from: a */
    private static final String f17675a = C4855bt.class.getSimpleName();

    /* renamed from: b */
    private static C4855bt f17676b = null;

    /* renamed from: c */
    private final Context f17677c;

    /* renamed from: a */
    public static C4855bt m18351a(Context context) {
        if (f17676b == null) {
            f17676b = new C4855bt(context);
        }
        return f17676b;
    }

    private C4855bt(Context context) {
        this.f17677c = context;
    }

    /* renamed from: a */
    public void m18358a() throws ExecutionException, InterruptedException {
        try {
            C2496n.m10782c(this.f17677c).get();
        } catch (InterruptedException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f17675a);
            }
        } catch (ExecutionException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f17675a);
            }
        }
    }

    /* renamed from: a */
    public void m18363a(String str) {
        try {
            C2496n.m10790e(this.f17677c, str).get();
        } catch (InterruptedException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f17675a);
            }
        } catch (ExecutionException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f17675a);
            }
        }
    }

    /* renamed from: a */
    public void m18360a(ImageView imageView, String str) {
        m18361a(imageView, str, Buddy.BuddyImageStatus.NOT_CHANGE.getCode());
    }

    /* renamed from: a */
    public void m18362a(ImageView imageView, String str, boolean z) {
        m18360a(imageView, str);
    }

    /* renamed from: a */
    public void m18361a(ImageView imageView, String str, int i) {
        C2496n.m10764a(imageView, str);
    }

    /* renamed from: b */
    public void m18367b(ImageView imageView, String str) {
        C2496n.m10776b(imageView, str);
    }

    @Deprecated
    /* renamed from: a */
    public void m18364a(String str, EnumC2300t enumC2300t) {
    }

    /* renamed from: a */
    public void m18359a(ImageView imageView, EnumC4857bv enumC4857bv) {
        m18366b(imageView, enumC4857bv);
    }

    /* renamed from: b */
    public void m18366b(ImageView imageView, EnumC4857bv enumC4857bv) {
        switch (C4856bu.f17678a[enumC4857bv.ordinal()]) {
            case 1:
                imageView.setImageResource(C2496n.m10752a(EnumC2300t.BROADCAST));
                break;
            case 2:
                imageView.setImageResource(C2496n.m10768b());
                break;
            case 3:
                imageView.setImageResource(C2496n.m10751a());
                break;
            case 4:
                imageView.setImageResource(C2496n.m10752a(EnumC2300t.GROUPCHAT));
                break;
            case 5:
                imageView.setImageResource(C2496n.m10752a(EnumC2300t.ONETOONE));
                break;
        }
    }

    /* renamed from: b */
    public static String m18354b(String str) {
        File fileM10771b = C2496n.m10771b(GlobalApplication.m18732r(), str);
        return (!fileM10771b.exists() || fileM10771b.length() == 0) ? "" : fileM10771b.getName();
    }

    @Deprecated
    /* renamed from: a */
    public void m18365a(String str, String str2, String str3) {
        String strM10534a;
        File absoluteFile = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile();
        String str4 = "tmp_" + System.currentTimeMillis() + ".jpeg_";
        File file = new File(absoluteFile, m18353a(str, str4));
        if (C4809aa.m18104a().m18119a("is_file_server_primary ", (Boolean) true).booleanValue()) {
            strM10534a = C2433c.m10534a(EnumC4867ce.PRIMARY, EnumC4868cf.FILE);
        } else {
            strM10534a = C2433c.m10534a(EnumC4867ce.SECONDARY, EnumC4868cf.FILE);
        }
        String str5 = String.format("%s%s?%s=%s&%s=%s&%s=%s&%s=%s", strM10534a, "/profileimage", "uid", C4809aa.m18104a().m18121a("uid", ""), "imei", C4822an.m18228d(), "size", 160, "filename", str4);
        ContentValues contentValues = new ContentValues();
        C4904y.m18639b("setGroupChatImage()", getClass().getSimpleName());
        if (!file.exists()) {
            String strM9868e = "";
            if (!TextUtils.isEmpty(str2)) {
                strM9868e = C2191e.m9868e(GlobalApplication.m10279a().getContentResolver(), str2);
            }
            File file2 = new File(this.f17677c.getFilesDir(), m18356d(strM9868e));
            if (file2.exists()) {
                C4636a.m17602a(file2, file);
                contentValues.put("profile_url", str5);
                GlobalApplication.m18732r().getContentResolver().update(C2299s.f8209a, contentValues, "inbox_no='" + str + "'", null);
            }
        }
    }

    /* renamed from: a */
    private static String m18353a(String str, String str2) {
        return C2496n.m10771b(GlobalApplication.m18732r(), str).getName();
    }

    /* renamed from: c */
    public static String m18355c(String str) {
        return C2496n.m10757a(GlobalApplication.m18732r(), str).getName();
    }

    /* renamed from: d */
    public static String m18356d(String str) {
        try {
            return C2496n.m10780c(GlobalApplication.m18732r(), str).getName();
        } catch (UnsupportedEncodingException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f17675a);
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m18352a(String str, int i) {
        String str2 = C4865cc.m18449b(EnumC4867ce.PRIMARY) + "/check/" + str + "/image/?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&imei=" + C4822an.m18228d() + "&mode=nonbuddy";
        if (i > 0) {
            return str2 + "&size=" + i;
        }
        return str2;
    }

    /* renamed from: e */
    public static String m18357e(String str) {
        return m18352a(str, -1);
    }
}
