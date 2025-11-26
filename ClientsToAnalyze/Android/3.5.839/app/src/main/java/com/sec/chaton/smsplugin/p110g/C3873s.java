package com.sec.chaton.smsplugin.p110g;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.sec.chaton.smsplugin.p104d.p105a.C3813a;
import com.sec.chaton.smsplugin.p108e.C3849b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5111c;
import org.p146b.p147a.p148a.InterfaceC5237b;

/* compiled from: VideoModel.java */
/* renamed from: com.sec.chaton.smsplugin.g.s */
/* loaded from: classes.dex */
public class C3873s extends AbstractC3867m {
    public C3873s(Context context, Uri uri, C3868n c3868n) throws C5111c {
        this(context, (String) null, (String) null, uri, c3868n);
        m14945c(uri);
        m14948a();
    }

    public C3873s(Context context, String str, String str2, Uri uri, C3868n c3868n) {
        super(context, "video", str, str2, uri, c3868n);
    }

    public C3873s(Context context, String str, String str2, C3849b c3849b, C3868n c3868n) {
        super(context, "video", str, str2, c3849b, c3868n);
    }

    /* renamed from: c */
    private void m14945c(Uri uri) throws C5111c {
        String scheme = uri.getScheme();
        if (scheme == null) {
            throw new C5111c("Bad URI: " + uri);
        }
        if (scheme.equals("content")) {
            m14947e(uri);
        } else if (uri.getScheme().equals("file")) {
            m14946d(uri);
        }
        m14825z();
    }

    /* renamed from: d */
    private void m14946d(Uri uri) {
        int iLastIndexOf;
        this.f13883e = uri.getPath();
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(this.f13883e);
        if (TextUtils.isEmpty(fileExtensionFromUrl) && (iLastIndexOf = this.f13883e.lastIndexOf(46)) >= 0) {
            fileExtensionFromUrl = this.f13883e.substring(iLastIndexOf + 1);
        }
        this.f13884f = singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14994a("Mms/media", "New VideoModel initFromFile created: mSrc=" + this.f13883e + " mContentType=" + this.f13884f + " mUri=" + uri);
        }
    }

    /* renamed from: e */
    private void m14947e(Uri uri) throws C5111c {
        String string;
        Cursor cursorQuery = SqliteWrapper.query(this.f13879a, this.f13879a.getContentResolver(), uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    try {
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    } catch (IllegalArgumentException e) {
                        string = uri.toString();
                    }
                    this.f13883e = string.substring(string.lastIndexOf(47) + 1);
                    this.f13884f = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime_type"));
                    if (TextUtils.isEmpty(this.f13884f)) {
                        throw new C5111c("Type of media is unknown.");
                    }
                    if (this.f13884f.equals("video/mp4") && !TextUtils.isEmpty(this.f13883e)) {
                        int iLastIndexOf = this.f13883e.lastIndexOf(".");
                        if (iLastIndexOf != -1) {
                            try {
                                String strSubstring = this.f13883e.substring(iLastIndexOf + 1);
                                if (!TextUtils.isEmpty(strSubstring) && (strSubstring.equalsIgnoreCase("3gp") || strSubstring.equalsIgnoreCase("3gpp") || strSubstring.equalsIgnoreCase("3g2"))) {
                                    this.f13884f = "video/3gpp";
                                }
                            } catch (IndexOutOfBoundsException e2) {
                            }
                        }
                    }
                    if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                        C3890m.m14994a("Mms/media", "New VideoModel initFromContentUri created: mSrc=" + this.f13883e + " mContentType=" + this.f13884f + " mUri=" + uri);
                    }
                    return;
                }
                throw new C5111c("Nothing found: " + uri);
            } finally {
                cursorQuery.close();
            }
        }
        throw new C5111c("Bad URI: " + uri);
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5239d
    /* renamed from: a */
    public void mo14745a(InterfaceC5237b interfaceC5237b) {
        String strMo14494b = interfaceC5237b.mo14494b();
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14994a("Mms/media", "[VideoModel] handleEvent " + interfaceC5237b.mo14494b() + " on " + this);
        }
        EnumC3864j enumC3864j = EnumC3864j.NO_ACTIVE_ACTION;
        if (strMo14494b.equals("SmilMediaStart")) {
            enumC3864j = EnumC3864j.START;
            m14803D();
            this.f13901n = true;
        } else if (strMo14494b.equals("SmilMediaEnd")) {
            enumC3864j = EnumC3864j.STOP;
            if (this.f13885g != 1) {
                this.f13901n = false;
            }
        } else if (strMo14494b.equals("SmilMediaPause")) {
            enumC3864j = EnumC3864j.PAUSE;
            this.f13901n = true;
        } else if (strMo14494b.equals("SmilMediaSeek")) {
            enumC3864j = EnumC3864j.SEEK;
            this.f13887i = ((C3813a) interfaceC5237b).m14499f();
            this.f13901n = true;
        }
        m14806a(enumC3864j);
        m14833a(false);
    }

    /* renamed from: a */
    protected void m14948a() {
        C3859e.m14762a().mo14761c(this.f13884f);
    }

    @Override // com.sec.chaton.smsplugin.p110g.AbstractC3863i
    /* renamed from: c */
    protected boolean mo14753c() {
        return true;
    }
}
