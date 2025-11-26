package com.sec.chaton.multimedia.doc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import java.io.File;

/* compiled from: FileExplorerFragment.java */
/* renamed from: com.sec.chaton.multimedia.doc.d */
/* loaded from: classes.dex */
class C2760d implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FileExplorerFragment f9960a;

    C2760d(FileExplorerFragment fileExplorerFragment) {
        this.f9960a = fileExplorerFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    @SuppressLint({"NewApi"})
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (((C2763g) this.f9960a.f9933b.get(i)).m11606a() == EnumC2758b.DIRECTORY) {
            this.f9960a.f9937f.push(this.f9960a.f9935d);
            this.f9960a.f9935d = ((C2763g) this.f9960a.f9933b.get(i)).m11616e();
            this.f9960a.f9936e.setText(this.f9960a.f9935d);
            this.f9960a.f9942k.setEnabled(true);
            C4880cr.m18523a(this.f9960a.f9942k);
            if (Build.VERSION.SDK_INT < 11) {
                new AsyncTaskC2761e(this.f9960a, null).execute(this.f9960a.f9935d);
                return;
            } else {
                new AsyncTaskC2761e(this.f9960a, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f9960a.f9935d);
                return;
            }
        }
        String strM11616e = ((C2763g) this.f9960a.f9933b.get(i)).m11616e();
        if (C4904y.f17872b) {
            C4904y.m18639b("send file: " + strM11616e, FileExplorerFragment.f9932a);
        }
        if (this.f9960a.f9941j != null && strM11616e != null) {
            Intent intent = new Intent();
            intent.setData(Uri.fromFile(new File(strM11616e)));
            this.f9960a.f9941j.setResult(-1, intent);
            this.f9960a.f9941j.finish();
        }
    }
}
