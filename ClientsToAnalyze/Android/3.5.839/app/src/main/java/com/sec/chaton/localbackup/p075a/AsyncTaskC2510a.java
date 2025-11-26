package com.sec.chaton.localbackup.p075a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.CommonApplication;
import com.sec.common.util.p133a.C5017a;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: BackupFileDownloadHelperTask.java */
/* renamed from: com.sec.chaton.localbackup.a.a */
/* loaded from: classes.dex */
public class AsyncTaskC2510a extends AsyncTask<String, Integer, String> {

    /* renamed from: a */
    private static final String f9028a = AsyncTaskC2510a.class.getSimpleName();

    /* renamed from: b */
    private Context f9029b;

    /* renamed from: c */
    private String f9030c;

    /* renamed from: d */
    private String f9031d;

    /* renamed from: e */
    private long f9032e;

    /* renamed from: f */
    private String f9033f;

    /* renamed from: g */
    private EnumC2214ab f9034g;

    /* renamed from: h */
    private AlertDialogC4916i f9035h;

    /* renamed from: i */
    private Handler f9036i;

    /* renamed from: j */
    private boolean f9037j;

    /* renamed from: k */
    private String f9038k;

    /* renamed from: l */
    private View f9039l;

    /* renamed from: m */
    private Handler f9040m = new HandlerC2511b(this);

    public AsyncTaskC2510a(Context context, String str, String str2, long j, String str3, EnumC2214ab enumC2214ab, View view, Handler handler, boolean z) {
        this.f9029b = context;
        this.f9030c = str;
        this.f9031d = str2;
        this.f9032e = j;
        this.f9033f = str3;
        this.f9034g = enumC2214ab;
        this.f9036i = handler;
        this.f9037j = z;
        this.f9039l = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String strM18595a;
        if (C4904y.f17872b) {
            C4904y.m18639b("mContnet :" + this.f9030c, f9028a);
        }
        if (this.f9030c == null) {
            return null;
        }
        String[] strArrSplit = this.f9030c.split("\n");
        if (strArrSplit == null || strArrSplit.length <= 4) {
            return null;
        }
        String str = strArrSplit[2];
        this.f9038k = strArrSplit[3];
        String str2 = "imei=" + C4822an.m18228d() + "&buddyid=" + strArrSplit[4] + "&filename=" + this.f9038k;
        if (C4904y.f17872b) {
            C4904y.m18639b("filedownLoadUrl:" + str2, f9028a);
        }
        String strM18098a = "";
        try {
            strM18595a = GlobalApplication.m10284c().m18595a();
        } catch (Exception e) {
            C4904y.m18635a(e, f9028a);
        }
        if (TextUtils.isEmpty(strM18595a)) {
            return null;
        }
        strM18098a = C4808a.m18098a(new C4808a(C4808a.m18100b(strM18595a), C4808a.m18101c(strM18595a)).m18102b(str2.getBytes()));
        return str + "?uid=" + C4809aa.m18104a().m18121a("uid", "") + "&param=" + strM18098a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.media_download_fail, 0).show();
            return;
        }
        if (this.f9037j) {
            this.f9035h = m10871b(str);
            this.f9035h.m18719a(0);
            this.f9035h.show();
        }
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f9029b, R.string.sdcard_not_found, 0).show();
            return;
        }
        File file = new File(CommonApplication.m18732r().getExternalFilesDir(null).getAbsolutePath() + "/localBackup/" + this.f9031d, this.f9038k);
        C5017a.m19064a().m19068a(this.f9040m, str, file, new C2513d(this.f9032e, file.getAbsolutePath(), this.f9031d, this.f9033f, this.f9034g, this.f9039l));
        super.onPostExecute(str);
    }

    /* renamed from: b */
    private AlertDialogC4916i m10871b(String str) {
        if (this.f9035h == null) {
            this.f9035h = new AlertDialogC4916i(this.f9029b);
            this.f9035h.setTitle(R.string.download_title);
            this.f9035h.setMessage(this.f9029b.getResources().getString(R.string.anicon_file_downloading));
            this.f9035h.setCancelable(false);
        }
        this.f9035h.setButton(-2, this.f9029b.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2512c(this, str));
        return this.f9035h;
    }
}
