package com.sec.chaton.smsplugin.p111h;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5084g;
import com.sec.google.android.p134a.p135a.C5097t;

/* compiled from: DownloadManager.java */
/* renamed from: com.sec.chaton.smsplugin.h.d */
/* loaded from: classes.dex */
public class C3881d {

    /* renamed from: g */
    private static C3881d f13971g;

    /* renamed from: a */
    private final Context f13972a;

    /* renamed from: c */
    private final SharedPreferences f13974c;

    /* renamed from: d */
    private boolean f13975d;

    /* renamed from: e */
    private final SharedPreferences.OnSharedPreferenceChangeListener f13976e = new SharedPreferencesOnSharedPreferenceChangeListenerC3882e(this);

    /* renamed from: f */
    private final BroadcastReceiver f13977f = new C3883f(this);

    /* renamed from: b */
    private final Handler f13973b = new Handler();

    private C3881d(Context context) {
        this.f13972a = context;
        this.f13974c = PreferenceManager.getDefaultSharedPreferences(context);
        this.f13974c.registerOnSharedPreferenceChangeListener(this.f13976e);
        context.registerReceiver(this.f13977f, new IntentFilter("android.intent.action.SERVICE_STATE"));
        this.f13975d = m14966a(this.f13974c);
    }

    /* renamed from: a */
    public boolean m14978a() {
        return this.f13975d;
    }

    /* renamed from: a */
    public static void m14965a(Context context) {
        if (f13971g != null) {
            C3890m.m14997c("DownloadManager", "Already initialized.");
        }
        f13971g = new C3881d(context);
    }

    /* renamed from: b */
    public static C3881d m14970b() {
        if (f13971g == null) {
            throw new IllegalStateException("Uninitialized.");
        }
        return f13971g;
    }

    /* renamed from: a */
    static boolean m14966a(SharedPreferences sharedPreferences) {
        return m14967a(sharedPreferences, m14972c());
    }

    /* renamed from: a */
    static boolean m14967a(SharedPreferences sharedPreferences, boolean z) {
        if (z) {
        }
        return true;
    }

    /* renamed from: c */
    static boolean m14972c() {
        return "true".equals(SystemProperties.get("gsm.operator.isroaming", (String) null));
    }

    /* renamed from: a */
    public void m14977a(Uri uri, int i) {
        try {
            if (((C5084g) C5097t.m19426a(this.f13972a).m19449a(uri)).m19321c() < System.currentTimeMillis() / 1000 && i == 129) {
                this.f13973b.post(new RunnableC3884g(this));
                SqliteWrapper.delete(this.f13972a, this.f13972a.getContentResolver(), uri, (String) null, (String[]) null);
                return;
            }
            if (i == 135) {
                this.f13973b.post(new RunnableC3885h(this, uri));
            } else if (!this.f13975d) {
                i |= 4;
            }
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("st", Integer.valueOf(i));
            SqliteWrapper.update(this.f13972a, this.f13972a.getContentResolver(), uri, contentValues, (String) null, (String[]) null);
        } catch (C5111c e) {
            C3890m.m14995a("DownloadManager", e.getMessage(), e);
        }
    }

    /* renamed from: d */
    public static void m14973d() {
        C3879b.m14961a(true, false);
    }

    /* renamed from: a */
    public void m14976a(int i) {
        this.f13973b.post(new RunnableC3886i(this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m14971b(Uri uri) {
        C5084g c5084g = (C5084g) C5097t.m19426a(this.f13972a).m19449a(uri);
        C5082e c5082eMo19314b = c5084g.mo19314b();
        String strM19308c = c5082eMo19314b != null ? c5082eMo19314b.m19308c() : this.f13972a.getString(R.string.no_subject);
        C5082e c5082eMo19324w_ = c5084g.mo19324w_();
        return this.f13972a.getString(R.string.dl_failure_notification, strM19308c, c5082eMo19324w_ != null ? C3782a.m14204a(c5082eMo19324w_.m19308c(), false).m14264f() : this.f13972a.getString(R.string.unknown_sender));
    }

    /* renamed from: a */
    public int m14975a(Uri uri) {
        Cursor cursorQuery = SqliteWrapper.query(this.f13972a, this.f13972a.getContentResolver(), uri, new String[]{"st"}, (String) null, (String[]) null, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    return cursorQuery.getInt(0) & (-5);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return 128;
    }
}
