package com.sec.chaton.multimedia.p048a;

import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.File;

/* compiled from: SaveFileTask.java */
/* renamed from: com.sec.chaton.multimedia.a.a */
/* loaded from: classes.dex */
public class AsyncTaskC1767a extends AsyncTask<String, Integer, String> {

    /* renamed from: a */
    private static final String f6513a = AsyncTaskC1767a.class.getSimpleName();

    /* renamed from: b */
    private String f6514b;

    /* renamed from: c */
    private String f6515c;

    /* renamed from: d */
    private String f6516d;

    /* renamed from: e */
    private boolean f6517e;

    /* renamed from: f */
    private boolean f6518f;

    /* renamed from: g */
    private MediaScannerConnection f6519g;

    /* renamed from: h */
    private MediaScannerConnection.MediaScannerConnectionClient f6520h = new C1768b(this);

    public AsyncTaskC1767a(String str, String str2, boolean z) {
        this.f6514b = str;
        this.f6515c = str2;
        this.f6517e = z;
        this.f6516d = this.f6514b.substring(this.f6514b.lastIndexOf("/") + 1);
        if (C3250y.f11734b) {
            C3250y.m11450b("mSourceUri: " + this.f6514b + ", mDestPath: " + this.f6515c + ", showPath: " + z, f6513a);
        }
    }

    public AsyncTaskC1767a(String str, String str2, String str3, boolean z) {
        this.f6514b = str;
        this.f6515c = str2;
        this.f6516d = str3;
        this.f6517e = z;
        if (C3250y.f11734b) {
            C3250y.m11450b("mSourceUri: " + this.f6514b + ", mDestPath: " + this.f6515c + ", showPath: " + z, f6513a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f6519g = new MediaScannerConnection(CommonApplication.m11493l(), this.f6520h);
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        File file;
        if (this.f6515c == null || this.f6516d == null || (file = new File(this.f6515c, this.f6516d)) == null || !file.exists() || file.length() <= 0) {
            return C3243r.m11415a(this.f6514b, this.f6515c, this.f6516d);
        }
        this.f6518f = true;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("save result: " + str, f6513a);
        }
        if (this.f6518f) {
            C3641ai.m13211a(CommonApplication.m11493l(), GlobalApplication.m6451b().getString(R.string.ams_msg_already_saved), 0).show();
            return;
        }
        if (str != null) {
            this.f6519g.connect();
            if (this.f6517e) {
                C3641ai.m13211a(CommonApplication.m11493l(), GlobalApplication.m6451b().getString(R.string.toast_save_media) + "\n" + this.f6515c, 0).show();
                return;
            } else {
                C3641ai.m13211a(CommonApplication.m11493l(), GlobalApplication.m6451b().getString(R.string.toast_save_media), 0).show();
                return;
            }
        }
        C3641ai.m13210a(CommonApplication.m11493l(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
    }
}
