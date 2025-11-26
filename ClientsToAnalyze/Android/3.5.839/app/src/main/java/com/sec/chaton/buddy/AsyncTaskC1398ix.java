package com.sec.chaton.buddy;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p061g.C2346e;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: TellFriendsFragment.java */
/* renamed from: com.sec.chaton.buddy.ix */
/* loaded from: classes.dex */
public class AsyncTaskC1398ix extends AsyncTask<Void, Void, List<C1396iv>> {

    /* renamed from: a */
    List<String> f5023a;

    /* renamed from: b */
    String[] f5024b = {"com.android.mms", "com.facebook.katana", "com.google.android.apps.plus", "com.twitter.android", "com.sina.weibo", "com.renren.xiaonei.android"};

    /* renamed from: c */
    final /* synthetic */ TellFriendsFragment f5025c;

    public AsyncTaskC1398ix(TellFriendsFragment tellFriendsFragment) {
        this.f5025c = tellFriendsFragment;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f5025c.m7016c();
        this.f5023a = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<C1396iv> doInBackground(Void... voidArr) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.f5025c.getActivity().getPackageManager();
        Intent type = new Intent("android.intent.action.SEND").setType("text/plain");
        m7512a(arrayList, packageManager);
        Object[] array = this.f5023a.toArray();
        Arrays.sort(array);
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(type, 65536)) {
            C1396iv c1396iv = new C1396iv(resolveInfo.loadIcon(packageManager), resolveInfo.loadLabel(packageManager));
            c1396iv.m7502a(this.f5025c.getActivity(), resolveInfo.activityInfo.packageName);
            if (Arrays.binarySearch(array, resolveInfo.activityInfo.packageName) < 0) {
                arrayList.add(c1396iv);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<C1396iv> list) {
        if (!isCancelled()) {
            this.f5025c.m7017d();
            this.f5025c.f4189n.addAll(list);
            ((C1397iw) this.f5025c.m63b()).notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    protected void m7512a(List<C1396iv> list, PackageManager packageManager) {
        Intent type = new Intent("android.intent.action.SEND").setType("text/plain");
        for (int i = 0; i < this.f5024b.length; i++) {
            type.setPackage(this.f5024b[i]);
            ResolveInfo resolveInfoM7508a = m7508a(type, packageManager);
            if (resolveInfoM7508a != null) {
                C1396iv c1396iv = new C1396iv(resolveInfoM7508a.loadIcon(packageManager), resolveInfoM7508a.loadLabel(packageManager));
                if (C2349a.m10301a("sms_feature") && C4822an.m18226c() && this.f5024b[i].equals("com.android.mms")) {
                    Intent intentM7505c = c1396iv.m7505c();
                    if (C3847e.m14691aw()) {
                        if (intentM7505c == null) {
                            intentM7505c = C2346e.m10270a(this.f5025c.getActivity());
                        }
                        c1396iv.m7503a(intentM7505c);
                        c1396iv.m7501a(111);
                    } else {
                        if (intentM7505c == null) {
                            intentM7505c = new Intent(this.f5025c.getActivity(), (Class<?>) PluginComposeMessageActivity.class);
                        }
                        intentM7505c.putExtra("sms_body", TellFriendsFragment.m7015a(this.f5025c.getActivity()));
                        intentM7505c.putExtra("from_tellfriends", true);
                        intentM7505c.setClassName(this.f5025c.getActivity(), "com.sec.chaton.smsplugin.ui.ForwardMessageActivity");
                        c1396iv.m7503a(intentM7505c);
                    }
                } else {
                    c1396iv.m7502a(this.f5025c.getActivity(), resolveInfoM7508a.activityInfo.packageName);
                }
                list.add(c1396iv);
                m7510a(resolveInfoM7508a.activityInfo.packageName);
            }
        }
        m7510a(CommonApplication.m18732r().getApplicationInfo().packageName);
    }

    /* renamed from: a */
    protected void m7510a(String str) {
        if (this.f5023a != null) {
            this.f5023a.add(str);
        }
    }

    /* renamed from: a */
    protected ResolveInfo m7508a(Intent intent, PackageManager packageManager) {
        return packageManager.resolveActivity(intent, 0);
    }
}
