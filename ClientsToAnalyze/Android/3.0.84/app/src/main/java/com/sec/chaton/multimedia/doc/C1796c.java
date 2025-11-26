package com.sec.chaton.multimedia.doc;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import java.io.File;

/* compiled from: FileExplorerFragment.java */
/* renamed from: com.sec.chaton.multimedia.doc.c */
/* loaded from: classes.dex */
class C1796c implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FileExplorerFragment f6668a;

    C1796c(FileExplorerFragment fileExplorerFragment) {
        this.f6668a = fileExplorerFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (((C1799f) this.f6668a.f6644b.get(i)).m7412a() == EnumC1794a.DIRECTORY) {
            this.f6668a.f6648f.push(this.f6668a.f6646d);
            this.f6668a.f6646d = ((C1799f) this.f6668a.f6644b.get(i)).m7422e();
            this.f6668a.f6647e.setText(this.f6668a.f6646d);
            this.f6668a.f6653k.setEnabled(true);
            C3228cp.m11343a(this.f6668a.f6653k);
            if (Build.VERSION.SDK_INT < 11) {
                new AsyncTaskC1797d(this.f6668a, null).execute(this.f6668a.f6646d);
                return;
            } else {
                new AsyncTaskC1797d(this.f6668a, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f6668a.f6646d);
                return;
            }
        }
        String strM7422e = ((C1799f) this.f6668a.f6644b.get(i)).m7422e();
        if (C3250y.f11734b) {
            C3250y.m11450b("send file: " + strM7422e, FileExplorerFragment.f6643a);
        }
        if (this.f6668a.f6652j != null && strM7422e != null) {
            Intent intent = new Intent();
            intent.setData(Uri.fromFile(new File(strM7422e)));
            this.f6668a.f6652j.setResult(-1, intent);
            this.f6668a.f6652j.finish();
        }
    }
}
