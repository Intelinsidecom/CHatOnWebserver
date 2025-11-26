package com.sec.chaton.multimedia.p079b;

import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: SaveFileTask.java */
/* renamed from: com.sec.chaton.multimedia.b.a */
/* loaded from: classes.dex */
public class AsyncTaskC2751a extends AsyncTask<String, Integer, String> {

    /* renamed from: a */
    private static final String f9880a = AsyncTaskC2751a.class.getSimpleName();

    /* renamed from: b */
    private String f9881b;

    /* renamed from: c */
    private String f9882c;

    /* renamed from: d */
    private String f9883d;

    /* renamed from: e */
    private boolean f9884e;

    /* renamed from: f */
    private boolean f9885f;

    /* renamed from: g */
    private MediaScannerConnection f9886g;

    /* renamed from: h */
    private MediaScannerConnection.MediaScannerConnectionClient f9887h = new C2752b(this);

    /* renamed from: a */
    public static AsyncTaskC2751a m11541a(String str, String str2, String str3, boolean z) {
        return new AsyncTaskC2751a(str, str2, str3, z);
    }

    private AsyncTaskC2751a(String str, String str2, String str3, boolean z) {
        this.f9881b = str;
        this.f9882c = str2;
        this.f9883d = str3;
        this.f9884e = z;
        if (this.f9883d == null) {
            this.f9883d = this.f9881b.substring(this.f9881b.lastIndexOf("/") + 1);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("mSourceUri: " + this.f9881b + ", mDestPath: " + this.f9882c + ", showPath: " + z, f9880a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f9886g = new MediaScannerConnection(CommonApplication.m18732r(), this.f9887h);
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        if (this.f9882c != null && this.f9883d != null) {
            File file = new File(this.f9882c, this.f9883d);
            if (file.exists() && file.length() > 0) {
                this.f9885f = true;
                return null;
            }
        }
        return C4894o.m18603a(this.f9881b, this.f9882c, this.f9883d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("save result: " + str, f9880a);
        }
        if (this.f9885f) {
            C5179v.m19811a(CommonApplication.m18732r(), GlobalApplication.m10283b().getString(R.string.ams_msg_already_saved), 0).show();
            return;
        }
        if (str != null) {
            this.f9886g.connect();
            if (this.f9884e) {
                C5179v.m19811a(CommonApplication.m18732r(), GlobalApplication.m10283b().getString(R.string.toast_save_media) + "\n(" + this.f9882c + ")", 0).show();
                return;
            } else {
                C5179v.m19811a(CommonApplication.m18732r(), GlobalApplication.m10283b().getString(R.string.toast_save_media), 0).show();
                return;
            }
        }
        C5179v.m19810a(CommonApplication.m18732r(), R.string.buddy_profile_saveprofile_toast_failed, 0).show();
    }
}
