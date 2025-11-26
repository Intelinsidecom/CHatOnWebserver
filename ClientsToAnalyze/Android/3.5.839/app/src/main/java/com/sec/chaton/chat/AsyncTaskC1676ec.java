package com.sec.chaton.chat;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ec */
/* loaded from: classes.dex */
class AsyncTaskC1676ec extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    List<File> f6237a;

    /* renamed from: b */
    boolean f6238b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f6239c;

    private AsyncTaskC1676ec(ChatFragment chatFragment) {
        this.f6239c = chatFragment;
        this.f6237a = new ArrayList();
    }

    /* synthetic */ AsyncTaskC1676ec(ChatFragment chatFragment, C1646d c1646d) {
        this(chatFragment);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f6239c.m8274s();
        if (!C2717y.m11395a(this.f6239c.f5637ca) && this.f6239c.f5637ca != EnumC2301u.LIVE) {
            if ((TextUtils.isEmpty(this.f6239c.f5488E) || "null".equals(this.f6239c.f5488E)) && this.f6239c.f5487D != EnumC2300t.BROADCAST) {
                this.f6238b = true;
                if (this.f6239c.f5623cM.size() > 1) {
                    this.f6239c.f5625cO = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        String strM11982d;
        if (this.f6238b) {
            File fileM7895a = this.f6239c.m7895a(((PreviewData) this.f6239c.f5623cM.get(0)).m11982d() == null ? ((PreviewData) this.f6239c.f5623cM.get(0)).m11976a() : ((PreviewData) this.f6239c.f5623cM.get(0)).m11982d(), false, true);
            if (fileM7895a != null) {
                this.f6237a.add(fileM7895a);
                return null;
            }
            return null;
        }
        Iterator it = this.f6239c.f5623cM.iterator();
        while (it.hasNext()) {
            PreviewData previewData = (PreviewData) it.next();
            if (previewData.m11982d() == null) {
                strM11982d = previewData.m11976a();
            } else {
                strM11982d = previewData.m11982d();
            }
            File fileM7895a2 = this.f6239c.m7895a(strM11982d, false, true);
            if (fileM7895a2 != null) {
                this.f6237a.add(fileM7895a2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r8) throws InterruptedException {
        super.onPostExecute(r8);
        if (this.f6237a != null) {
            Iterator<File> it = this.f6237a.iterator();
            while (it.hasNext()) {
                this.f6239c.m7936a(it.next(), (String) null, (String) null, EnumC2214ab.IMAGE, (String) null);
                try {
                    Thread.sleep(10L, 0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!this.f6238b) {
            this.f6239c.m8275t();
        }
        if (this.f6237a != null) {
            this.f6237a.clear();
        }
    }
}
