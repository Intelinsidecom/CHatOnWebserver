package com.sec.chaton.userprofile;

import android.os.AsyncTask;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p065io.entry.inner.CoverStoryAdd;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: MyPageManager.java */
/* renamed from: com.sec.chaton.userprofile.bq */
/* loaded from: classes.dex */
public class AsyncTaskC4758bq extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    File f17442a;

    /* renamed from: b */
    ImageView f17443b;

    /* renamed from: c */
    CoverStoryAdd f17444c;

    public AsyncTaskC4758bq(File file, ImageView imageView, CoverStoryAdd coverStoryAdd) {
        this.f17442a = file;
        this.f17443b = imageView;
        this.f17444c = coverStoryAdd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        String str = this.f17442a.getName().split("\\.")[r0.length - 1];
        C4904y.m18646e("ChatOnGraphics.MY_COVERSTORY_NAME + ext: mycoverstory." + str, C4754bm.f17418a);
        File file = new File(C4754bm.f17427j + "mycoverstory." + str);
        if (file.exists()) {
            file.delete();
        }
        C4636a.m17602a(this.f17442a, file);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        if (this.f17444c != null) {
            String[] strArrSplit = this.f17444c.metacontents.split("\\.");
            if (strArrSplit.length > 0) {
                String str = "mycoverstory." + strArrSplit[strArrSplit.length - 1];
                C4904y.m18646e("entry.metacontents: " + this.f17444c.metacontents + " // mFileName: " + str, C4754bm.f17418a);
                C4809aa.m18108a("coverstory_file_name", str);
            }
            C4754bm.m18042a(this.f17443b);
            C5179v.m19810a(CommonApplication.m18732r(), R.string.mypage_coverstory_sample_changed, 0).show();
        }
    }
}
