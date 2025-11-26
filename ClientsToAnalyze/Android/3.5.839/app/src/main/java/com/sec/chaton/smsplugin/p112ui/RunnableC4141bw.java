package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.sharedialog.ShareActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bw */
/* loaded from: classes.dex */
class RunnableC4141bw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f15415a;

    /* renamed from: b */
    final /* synthetic */ Uri f15416b;

    /* renamed from: c */
    final /* synthetic */ ArrayList f15417c;

    /* renamed from: d */
    final /* synthetic */ Intent f15418d;

    /* renamed from: e */
    final /* synthetic */ String f15419e;

    /* renamed from: f */
    final /* synthetic */ String f15420f;

    /* renamed from: g */
    final /* synthetic */ C4132bn f15421g;

    RunnableC4141bw(C4132bn c4132bn, List list, Uri uri, ArrayList arrayList, Intent intent, String str, String str2) {
        this.f15421g = c4132bn;
        this.f15415a = list;
        this.f15416b = uri;
        this.f15417c = arrayList;
        this.f15418d = intent;
        this.f15419e = str;
        this.f15420f = str2;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String string;
        boolean z;
        StringBuilder sb = new StringBuilder();
        if (this.f15415a.size() > 0) {
            Iterator it = this.f15415a.iterator();
            while (it.hasNext()) {
                try {
                    C4132bn.m16375b(this.f15421g.f15387c, this.f15416b, (Uri) it.next());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String str = (String) this.f15417c.get(0);
            if (this.f15415a.size() > 1) {
                int i = 1;
                while (true) {
                    if (i >= this.f15415a.size()) {
                        z = false;
                        break;
                    } else {
                        if (!str.equals(this.f15417c.get(i))) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z) {
                    this.f15418d.setType("application/*");
                } else {
                    this.f15418d.setType(str);
                }
                this.f15418d.setAction("android.intent.action.SEND_MULTIPLE");
                this.f15418d.putParcelableArrayListExtra("android.intent.extra.STREAM", C4132bn.f15382h);
            } else {
                this.f15418d.setType(str);
                this.f15418d.setAction("android.intent.action.SEND");
                this.f15418d.putExtra("android.intent.extra.STREAM", C4132bn.f15382h.get(0));
            }
        } else {
            this.f15418d.setAction("android.intent.action.SEND");
            this.f15418d.setType("text/plain");
        }
        if (this.f15419e == null) {
            string = null;
        } else {
            sb.append(this.f15421g.f15387c.getResources().getString(R.string.subject_label));
            sb.append(' ');
            sb.append(this.f15419e);
            string = sb.toString();
        }
        this.f15418d.putExtra("android.intent.extra.TEXT", C4149cd.m16396a("\n", new String[]{string, this.f15420f}));
        this.f15421g.f15387c.startActivity(ShareActivity.m13949a(this.f15421g.f15387c, this.f15418d));
    }
}
