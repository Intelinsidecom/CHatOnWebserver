package com.sec.chaton.localbackup.p045a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3158a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.AlertDialogC3256c;
import com.sec.common.CommonApplication;
import com.sec.common.util.p070a.C3332a;
import com.sec.widget.C3641ai;
import java.io.File;

/* compiled from: BackupFileDownloadHelperTask.java */
/* renamed from: com.sec.chaton.localbackup.a.a */
/* loaded from: classes.dex */
public class AsyncTaskC1610a extends AsyncTask<String, Integer, String> {

    /* renamed from: a */
    private static final String f5986a = AsyncTaskC1610a.class.getSimpleName();

    /* renamed from: b */
    private Context f5987b;

    /* renamed from: c */
    private String f5988c;

    /* renamed from: d */
    private String f5989d;

    /* renamed from: e */
    private long f5990e;

    /* renamed from: f */
    private String f5991f;

    /* renamed from: g */
    private EnumC1455w f5992g;

    /* renamed from: h */
    private AlertDialogC3256c f5993h;

    /* renamed from: i */
    private Handler f5994i;

    /* renamed from: j */
    private boolean f5995j;

    /* renamed from: k */
    private String f5996k;

    /* renamed from: l */
    private View f5997l;

    /* renamed from: m */
    private Handler f5998m = new HandlerC1611b(this);

    public AsyncTaskC1610a(Context context, String str, String str2, long j, String str3, EnumC1455w enumC1455w, View view, Handler handler, boolean z) {
        this.f5987b = context;
        this.f5988c = str;
        this.f5989d = str2;
        this.f5990e = j;
        this.f5991f = str3;
        this.f5992g = enumC1455w;
        this.f5994i = handler;
        this.f5995j = z;
        this.f5997l = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String strM11411a;
        if (C3250y.f11734b) {
            C3250y.m11450b("mContnet :" + this.f5988c, f5986a);
        }
        if (this.f5988c == null) {
            return null;
        }
        String[] strArrSplit = this.f5988c.split("\n");
        if (strArrSplit == null || strArrSplit.length <= 4) {
            return null;
        }
        String str = strArrSplit[2];
        this.f5996k = strArrSplit[3];
        String str2 = "imei=" + C3171am.m11045a() + "&buddyid=" + strArrSplit[4] + "&filename=" + this.f5996k;
        if (C3250y.f11734b) {
            C3250y.m11450b("filedownLoadUrl:" + str2, f5986a);
        }
        String strM10954a = "";
        try {
            strM11411a = GlobalApplication.m6453c().m11411a();
        } catch (Exception e) {
            C3250y.m11443a(e, f5986a);
        }
        if (TextUtils.isEmpty(strM11411a)) {
            return null;
        }
        strM10954a = C3158a.m10954a(new C3158a(C3158a.m10958b(strM11411a), C3158a.m10959c(strM11411a)).m10960b(str2.getBytes()));
        return str + "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&param=" + strM10954a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.media_download_fail, 0).show();
            return;
        }
        if (this.f5995j) {
            this.f5993h = m6843b(str);
            this.f5993h.m11483a(0);
            this.f5993h.show();
        }
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.f5987b, R.string.sdcard_not_found, 0).show();
            return;
        }
        File file = new File(CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() + "/localBackup/" + this.f5989d, this.f5996k);
        C3332a.m11750a().m11754a(this.f5998m, str, file, new C1613d(this.f5990e, file.getAbsolutePath(), this.f5989d, this.f5991f, this.f5992g, this.f5997l));
        super.onPostExecute(str);
    }

    /* renamed from: b */
    private AlertDialogC3256c m6843b(String str) {
        if (this.f5993h == null) {
            this.f5993h = new AlertDialogC3256c(this.f5987b);
            this.f5993h.setTitle(R.string.download_title);
            this.f5993h.setMessage(this.f5987b.getResources().getString(R.string.anicon_file_downloading));
            this.f5993h.setCancelable(false);
        }
        this.f5993h.setButton(-2, this.f5987b.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1612c(this, str));
        return this.f5993h;
    }
}
