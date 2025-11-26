package com.sec.chaton.sharedialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShareActivity.java */
/* renamed from: com.sec.chaton.sharedialog.b */
/* loaded from: classes.dex */
public class AsyncTaskC3694b extends AsyncTask<Void, Void, List<C3695c>> implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ ShareActivity f13303a;

    /* renamed from: b */
    private ArrayList<C3695c> f13304b = new ArrayList<>();

    /* renamed from: c */
    private Context f13305c;

    /* renamed from: d */
    private Intent f13306d;

    /* renamed from: e */
    private List<String> f13307e;

    AsyncTaskC3694b(ShareActivity shareActivity, Context context, Intent intent) {
        this.f13303a = shareActivity;
        this.f13306d = intent;
        this.f13305c = context;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f13307e = new ArrayList();
        this.f13304b.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<C3695c> doInBackground(Void... voidArr) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent(this.f13306d);
        PackageManager packageManager = this.f13305c.getPackageManager();
        m13957a(arrayList, packageManager);
        Object[] array = this.f13307e.toArray();
        Arrays.sort(array);
        ArrayList arrayList2 = new ArrayList();
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
            C3695c c3695c = new C3695c(resolveInfo.loadIcon(packageManager), resolveInfo.loadLabel(packageManager));
            c3695c.m13959a(this.f13305c, resolveInfo.activityInfo.packageName, intent, resolveInfo.activityInfo.name);
            if (Arrays.binarySearch(array, resolveInfo.activityInfo.packageName) < 0) {
                arrayList2.add(c3695c);
            }
        }
        C3693a c3693a = new C3693a(arrayList2, this.f13305c);
        if (c3693a.m13952a() != null) {
            arrayList.addAll(c3693a.m13952a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<C3695c> list) {
        if (!isCancelled()) {
            this.f13304b.addAll(list);
            if (this.f13303a.f13296c == null) {
                this.f13303a.f13296c = new DialogC3696d(this.f13305c, this.f13304b);
                this.f13303a.f13296c.setOnDismissListener(this);
                this.f13303a.f13296c.show();
            }
        }
    }

    /* renamed from: a */
    protected void m13957a(List<C3695c> list, PackageManager packageManager) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < ShareActivity.f13294a.length) {
                this.f13306d.setPackage(ShareActivity.f13294a[i2]);
                List<ResolveInfo> listM13953a = m13953a(this.f13306d, packageManager);
                if (listM13953a != null) {
                    for (ResolveInfo resolveInfo : listM13953a) {
                        C3695c c3695c = new C3695c(resolveInfo.loadIcon(packageManager), resolveInfo.loadLabel(packageManager));
                        c3695c.m13959a(this.f13305c, resolveInfo.activityInfo.packageName, this.f13306d, resolveInfo.activityInfo.name);
                        list.add(c3695c);
                        m13955a(resolveInfo.activityInfo.packageName);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected void m13955a(String str) {
        if (this.f13307e != null) {
            this.f13307e.add(str);
        }
    }

    /* renamed from: a */
    protected List<ResolveInfo> m13953a(Intent intent, PackageManager packageManager) {
        return packageManager.queryIntentActivities(intent, 65536);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f13303a.finish();
    }
}
