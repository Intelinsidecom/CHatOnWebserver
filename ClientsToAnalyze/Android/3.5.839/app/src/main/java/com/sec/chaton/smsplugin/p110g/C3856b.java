package com.sec.chaton.smsplugin.p110g;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.p104d.p105a.C3813a;
import com.sec.chaton.smsplugin.p108e.C3849b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3891n;
import com.sec.google.android.p134a.C5111c;
import java.util.HashMap;
import java.util.Map;
import org.p146b.p147a.p148a.InterfaceC5237b;

/* compiled from: AudioModel.java */
/* renamed from: com.sec.chaton.smsplugin.g.b */
/* loaded from: classes.dex */
public class C3856b extends AbstractC3863i {

    /* renamed from: m */
    private final HashMap<String, String> f13860m;

    public C3856b(Context context, Uri uri) throws C5111c {
        this(context, (String) null, (String) null, uri);
        m14750c(uri);
        m14752b();
    }

    public C3856b(Context context, String str, String str2, Uri uri) {
        super(context, "audio", str, str2, uri);
        this.f13860m = new HashMap<>();
    }

    public C3856b(Context context, String str, String str2, C3849b c3849b) {
        super(context, "audio", str, str2, c3849b);
        this.f13860m = new HashMap<>();
    }

    /* renamed from: c */
    private void m14750c(Uri uri) throws C5111c {
        int iLastIndexOf;
        String string;
        if (uri == null) {
            C3890m.m14999e("Mms/media", "Uri is null !!!");
            return;
        }
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            Cursor cursorQuery = SqliteWrapper.query(this.f13879a, this.f13879a.getContentResolver(), uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        if (m14799b(uri)) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            this.f13884f = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("ct"));
                        } else {
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            this.f13884f = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime_type"));
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("album"));
                            if (!TextUtils.isEmpty(string2)) {
                                this.f13860m.put("album", string2);
                            }
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("artist"));
                            if (!TextUtils.isEmpty(string3)) {
                                this.f13860m.put("artist", string3);
                            }
                        }
                        this.f13883e = string.substring(string.lastIndexOf(47) + 1);
                        if (TextUtils.isEmpty(this.f13884f)) {
                            throw new C5111c("Type of media is unknown.");
                        }
                    } else {
                        throw new C5111c("Nothing found: " + uri);
                    }
                } finally {
                    cursorQuery.close();
                }
            } else {
                throw new C5111c("Bad URI: " + uri);
            }
        } else if ("file".equals(scheme)) {
            C3891n c3891nM15001a = C3891n.m15001a();
            String path = uri.getPath();
            String strM15002a = C3891n.m15002a(path);
            if (TextUtils.isEmpty(strM15002a) && (iLastIndexOf = path.lastIndexOf(46)) >= 0) {
                strM15002a = path.substring(iLastIndexOf + 1);
            }
            this.f13883e = path.substring(path.lastIndexOf(47) + 1);
            Cursor cursorQuery2 = this.f13879a.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, "_data=\"" + path + "\"", null, null);
            if (cursorQuery2 != null) {
                try {
                    if (cursorQuery2.moveToFirst()) {
                        this.f13884f = cursorQuery2.getString(cursorQuery2.getColumnIndexOrThrow("mime_type"));
                    }
                } finally {
                    cursorQuery2.close();
                }
            }
            if (this.f13884f == null) {
                this.f13884f = C3891n.m15004b().m15005b(strM15002a);
            }
            if (this.f13884f == null) {
                this.f13884f = c3891nM15001a.m15005b(strM15002a);
            }
        } else {
            throw new C5111c("Bad URI: " + uri);
        }
        m14825z();
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5239d
    /* renamed from: a */
    public void mo14745a(InterfaceC5237b interfaceC5237b) {
        String strMo14494b = interfaceC5237b.mo14494b();
        EnumC3864j enumC3864j = EnumC3864j.NO_ACTIVE_ACTION;
        if (strMo14494b.equals("SmilMediaStart")) {
            enumC3864j = EnumC3864j.START;
            m14803D();
        } else if (strMo14494b.equals("SmilMediaEnd")) {
            enumC3864j = EnumC3864j.STOP;
        } else if (strMo14494b.equals("SmilMediaPause")) {
            enumC3864j = EnumC3864j.PAUSE;
        } else if (strMo14494b.equals("SmilMediaSeek")) {
            enumC3864j = EnumC3864j.SEEK;
            this.f13887i = ((C3813a) interfaceC5237b).m14499f();
        }
        m14806a(enumC3864j);
        m14833a(false);
    }

    /* renamed from: a */
    public Map<String, ?> m14751a() {
        return this.f13860m;
    }

    /* renamed from: b */
    protected void m14752b() {
        C3859e.m14762a().mo14760b(this.f13884f);
    }

    @Override // com.sec.chaton.smsplugin.p110g.AbstractC3863i
    /* renamed from: c */
    protected boolean mo14753c() {
        return true;
    }
}
