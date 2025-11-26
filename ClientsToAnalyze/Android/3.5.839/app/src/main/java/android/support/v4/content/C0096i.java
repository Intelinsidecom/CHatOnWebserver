package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.spp.push.dlc.api.IDlcApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: LocalBroadcastManager.java */
/* renamed from: android.support.v4.content.i */
/* loaded from: classes.dex */
public class C0096i {

    /* renamed from: f */
    private static final Object f316f = new Object();

    /* renamed from: g */
    private static C0096i f317g;

    /* renamed from: a */
    private final Context f318a;

    /* renamed from: b */
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f319b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, ArrayList<C0099l>> f320c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C0098k> f321d = new ArrayList<>();

    /* renamed from: e */
    private final Handler f322e;

    /* renamed from: a */
    public static C0096i m358a(Context context) {
        C0096i c0096i;
        synchronized (f316f) {
            if (f317g == null) {
                f317g = new C0096i(context.getApplicationContext());
            }
            c0096i = f317g;
        }
        return c0096i;
    }

    private C0096i(Context context) {
        this.f318a = context;
        this.f322e = new HandlerC0097j(this, context.getMainLooper());
    }

    /* renamed from: a */
    public void m362a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f319b) {
            C0099l c0099l = new C0099l(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.f319b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f319b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C0099l> arrayList2 = this.f320c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f320c.put(action, arrayList2);
                }
                arrayList2.add(c0099l);
            }
        }
    }

    /* renamed from: a */
    public void m361a(BroadcastReceiver broadcastReceiver) {
        int i;
        synchronized (this.f319b) {
            ArrayList<IntentFilter> arrayListRemove = this.f319b.remove(broadcastReceiver);
            if (arrayListRemove != null) {
                for (int i2 = 0; i2 < arrayListRemove.size(); i2++) {
                    IntentFilter intentFilter = arrayListRemove.get(i2);
                    for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                        String action = intentFilter.getAction(i3);
                        ArrayList<C0099l> arrayList = this.f320c.get(action);
                        if (arrayList != null) {
                            int i4 = 0;
                            while (i4 < arrayList.size()) {
                                if (arrayList.get(i4).f327b == broadcastReceiver) {
                                    arrayList.remove(i4);
                                    i = i4 - 1;
                                } else {
                                    i = i4;
                                }
                                i4 = i + 1;
                            }
                            if (arrayList.size() <= 0) {
                                this.f320c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m363a(Intent intent) {
        String str;
        ArrayList arrayList;
        synchronized (this.f319b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f318a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<C0099l> arrayList2 = this.f320c.get(intent.getAction());
            if (arrayList2 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                }
                ArrayList arrayList3 = null;
                int i = 0;
                while (i < arrayList2.size()) {
                    C0099l c0099l = arrayList2.get(i);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + c0099l.f326a);
                    }
                    if (c0099l.f328c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                            arrayList = arrayList3;
                        } else {
                            arrayList = arrayList3;
                        }
                    } else {
                        int iMatch = c0099l.f326a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList.add(c0099l);
                            c0099l.f328c = true;
                        } else {
                            if (z) {
                                switch (iMatch) {
                                    case IDlcApi.RC_NOT_PERMITTED /* -4 */:
                                        str = "category";
                                        break;
                                    case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                                        str = "action";
                                        break;
                                    case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                                        str = SlookAirButtonFrequentContactAdapter.DATA;
                                        break;
                                    case -1:
                                        str = "type";
                                        break;
                                    default:
                                        str = "unknown reason";
                                        break;
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str);
                            }
                            arrayList = arrayList3;
                        }
                    }
                    i++;
                    arrayList3 = arrayList;
                }
                if (arrayList3 != null) {
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        ((C0099l) arrayList3.get(i2)).f328c = false;
                    }
                    this.f321d.add(new C0098k(intent, arrayList3));
                    if (!this.f322e.hasMessages(1)) {
                        this.f322e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m359a() {
        C0098k[] c0098kArr;
        while (true) {
            synchronized (this.f319b) {
                int size = this.f321d.size();
                if (size <= 0) {
                    return;
                }
                c0098kArr = new C0098k[size];
                this.f321d.toArray(c0098kArr);
                this.f321d.clear();
            }
            for (C0098k c0098k : c0098kArr) {
                for (int i = 0; i < c0098k.f325b.size(); i++) {
                    c0098k.f325b.get(i).f327b.onReceive(this.f318a, c0098k.f324a);
                }
            }
        }
    }
}
