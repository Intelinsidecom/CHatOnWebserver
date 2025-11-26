package com.sec.chaton.settings.p096a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: DownloadHelper.java */
/* renamed from: com.sec.chaton.settings.a.m */
/* loaded from: classes.dex */
public class C3469m {
    /* renamed from: a */
    public static ProgressDialog m13794a(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(0);
        progressDialog.setMessage(context.getString(R.string.dialog_connecting_server));
        return progressDialog;
    }

    /* renamed from: b */
    public static AbstractC4932a m13795b(Context context) {
        return AbstractC4932a.m18733a(context).mo18734a(R.string.setting_download_all_title).mo18746b(R.string.setting_download_all_question_fix).mo18756d(R.string.dialog_ok, null).mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
    }

    /* renamed from: a */
    public static int m13793a() {
        return C3460d.m13760a() + C3474r.m13822b() + C3455ab.m13743a();
    }
}
