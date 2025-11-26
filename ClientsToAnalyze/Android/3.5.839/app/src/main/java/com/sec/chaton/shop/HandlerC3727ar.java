package com.sec.chaton.shop;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.settings.p096a.p097a.C3447n;
import com.sec.chaton.shop.entrys.DownloadResponseEntry;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.util.C5052r;

/* compiled from: ShopSkinDownloads.java */
/* renamed from: com.sec.chaton.shop.ar */
/* loaded from: classes.dex */
class HandlerC3727ar extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3726aq f13405a;

    HandlerC3727ar(C3726aq c3726aq) {
        this.f13405a = c3726aq;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AlertDialogC4916i alertDialogC4916i;
        super.handleMessage(message);
        if (this.f13405a.f13402c == null) {
            return;
        }
        C3447n c3447n = (C3447n) message.obj;
        DownloadResponseEntry downloadResponseEntry = new DownloadResponseEntry(c3447n.f12885a.itemType, c3447n.f12885a.itemId);
        Message message2 = new Message();
        message2.what = 2;
        message2.obj = downloadResponseEntry;
        Bundle bundle = new Bundle();
        switch (message.what) {
            case 1:
                break;
            case 2:
                if (this.f13405a.f13401b != null) {
                    this.f13405a.f13401b.getButton(-2).setEnabled(false);
                    break;
                }
                break;
            case 3:
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("download_skin, PackageId: ", c3447n.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3726aq.f13400a);
                }
                if (this.f13405a.f13401b != null && !((Activity) this.f13405a.f13402c).isFinishing()) {
                    this.f13405a.f13401b.dismiss();
                }
                bundle.putString("download_result", c3447n.f12885a.cancel);
                message2.setData(bundle);
                this.f13405a.f13403d.sendMessage(message2);
                return;
            case 4:
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("Download completed , Shop itemid: ", c3447n.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3726aq.f13400a);
                }
                try {
                    try {
                        try {
                            this.f13405a.m14059a(c3447n.f12885a);
                            bundle.putString("download_result", c3447n.f12885a.success);
                            message2.setData(bundle);
                            this.f13405a.f13403d.sendMessage(message2);
                        } catch (OperationApplicationException e) {
                            e.printStackTrace();
                            if (this.f13405a.f13401b != null && !((Activity) this.f13405a.f13402c).isFinishing()) {
                                alertDialogC4916i = this.f13405a.f13401b;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (this.f13405a.f13401b != null && !((Activity) this.f13405a.f13402c).isFinishing()) {
                                alertDialogC4916i = this.f13405a.f13401b;
                            }
                        }
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                        if (this.f13405a.f13401b != null && !((Activity) this.f13405a.f13402c).isFinishing()) {
                            alertDialogC4916i = this.f13405a.f13401b;
                        }
                    }
                    if (this.f13405a.f13401b != null && !((Activity) this.f13405a.f13402c).isFinishing()) {
                        alertDialogC4916i = this.f13405a.f13401b;
                        alertDialogC4916i.dismiss();
                    }
                    return;
                } finally {
                }
            case 5:
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("download_skin failed , Shop itemid: ", c3447n.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3726aq.f13400a);
                }
                if (this.f13405a.f13401b != null && !((Activity) this.f13405a.f13402c).isFinishing()) {
                    this.f13405a.f13401b.dismiss();
                }
                bundle.putString("download_result", c3447n.f12885a.error);
                message2.setData(bundle);
                this.f13405a.f13403d.sendMessage(message2);
                return;
            case 6:
                if (this.f13405a.f13401b != null) {
                    this.f13405a.f13401b.m18719a(c3447n.m19061f().intValue());
                    return;
                }
                return;
            default:
                return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("download_skin, PackageId: ", c3447n.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3726aq.f13400a);
        }
    }
}
