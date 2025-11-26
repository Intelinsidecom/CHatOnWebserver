package com.sec.chaton.buddy;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: TellFriendsFragment.java */
/* renamed from: com.sec.chaton.buddy.iu */
/* loaded from: classes.dex */
public class AsyncTaskC0791iu extends AsyncTask<Void, Void, List<C0789is>> {

    /* renamed from: a */
    List<String> f3081a;

    /* renamed from: b */
    String[] f3082b = {"com.android.mms", "com.facebook.katana", "com.google.android.apps.plus", "com.twitter.android", "com.sina.weibo", "com.renren.xiaonei.android"};

    /* renamed from: c */
    final /* synthetic */ TellFriendsFragment f3083c;

    public AsyncTaskC0791iu(TellFriendsFragment tellFriendsFragment) {
        this.f3083c = tellFriendsFragment;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f3083c.m3942a();
        this.f3081a = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<C0789is> doInBackground(Void... voidArr) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.f3083c.getActivity().getPackageManager();
        Intent type = new Intent("android.intent.action.SEND").setType("text/plain");
        m4362a(arrayList, packageManager);
        Object[] array = this.f3081a.toArray();
        Arrays.sort(array);
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(type, 65536)) {
            C0789is c0789is = new C0789is(resolveInfo.loadIcon(packageManager), resolveInfo.loadLabel(packageManager));
            c0789is.m4354a(this.f3083c.getActivity(), resolveInfo.activityInfo.packageName);
            if (Arrays.binarySearch(array, resolveInfo.activityInfo.packageName) < 0) {
                arrayList.add(c0789is);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<C0789is> list) {
        if (!isCancelled()) {
            this.f3083c.m3943b();
            this.f3083c.f2344f.addAll(list);
            ((C0790it) this.f3083c.getListAdapter()).notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    protected void m4362a(List<C0789is> list, PackageManager packageManager) {
        Intent type = new Intent("android.intent.action.SEND").setType("text/plain");
        for (int i = 0; i < this.f3082b.length; i++) {
            type.setPackage(this.f3082b[i]);
            ResolveInfo resolveInfoM4358a = m4358a(type, packageManager);
            if (resolveInfoM4358a != null) {
                C0789is c0789is = new C0789is(resolveInfoM4358a.loadIcon(packageManager), resolveInfoM4358a.loadLabel(packageManager));
                c0789is.m4354a(this.f3083c.getActivity(), resolveInfoM4358a.activityInfo.packageName);
                list.add(c0789is);
                m4360a(resolveInfoM4358a.activityInfo.packageName);
            }
        }
        m4360a(CommonApplication.m11493l().getApplicationInfo().packageName);
    }

    /* renamed from: a */
    protected void m4360a(String str) {
        if (this.f3081a != null) {
            this.f3081a.add(str);
        }
    }

    /* renamed from: a */
    protected ResolveInfo m4358a(Intent intent, PackageManager packageManager) {
        return packageManager.resolveActivity(intent, 0);
    }
}
