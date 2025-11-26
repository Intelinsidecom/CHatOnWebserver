package com.sec.chaton.userprofile;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.p131f.C4999c;
import java.io.File;
import java.io.IOException;

/* compiled from: MyPageManager.java */
/* renamed from: com.sec.chaton.userprofile.br */
/* loaded from: classes.dex */
public class AsyncTaskC4759br extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    ImageView f17445a;

    /* renamed from: b */
    Bitmap f17446b;

    public AsyncTaskC4759br(ImageView imageView) {
        this.f17445a = imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        File file = new File(C4754bm.f17427j + "mycoverstory.jpg");
        if (file.exists() && file.length() > 0) {
            try {
                this.f17446b = new C4999c().m18976a(file).m18969a();
                return null;
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, C4754bm.f17418a);
                }
                if (file.exists()) {
                    file.delete();
                }
                C4809aa.m18108a("coverstory_metaid", Spam.ACTIVITY_REPORT);
                if (C4904y.f17872b) {
                    C4904y.m18639b("[CoverStory] #3# PrefConst.PREF_MYPAGE_COVERSTORY_METAID set 1", C4754bm.f17418a);
                    return null;
                }
                return null;
            }
        }
        C4809aa.m18108a("coverstory_metaid", Spam.ACTIVITY_REPORT);
        if (C4904y.f17872b) {
            C4904y.m18639b("[CoverStory] #4# PrefConst.PREF_MYPAGE_COVERSTORY_METAID set 1", C4754bm.f17418a);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r3) {
        super.onPostExecute(r3);
        if (this.f17446b != null) {
            this.f17445a.setImageBitmap(this.f17446b);
            C4809aa.m18108a("mypage_coverstory_state", "updated");
            if (C4904y.f17872b) {
                C4904y.m18639b("Coverstory bitmap Exists", C4754bm.f17418a);
            }
        } else {
            C1331gk.m7458a(this.f17445a);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(" Coverstory setCoverstoryAndDownload() MYPAGE_STATUS_UPDATED set", C4754bm.f17418a);
        }
    }
}
