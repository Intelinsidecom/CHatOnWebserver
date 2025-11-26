package com.sec.chaton.shop;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.settings.p096a.p097a.C3434a;
import com.sec.chaton.shop.entrys.DownloadResponseEntry;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.util.C5052r;

/* compiled from: ShopAniconDownloads.java */
/* renamed from: com.sec.chaton.shop.o */
/* loaded from: classes.dex */
class HandlerC3766o extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3765n f13510a;

    HandlerC3766o(C3765n c3765n) {
        this.f13510a = c3765n;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AlertDialogC4916i alertDialogC4916i;
        super.handleMessage(message);
        if (this.f13510a.f13507c == null) {
            return;
        }
        C3434a c3434a = (C3434a) message.obj;
        DownloadResponseEntry downloadResponseEntry = new DownloadResponseEntry(c3434a.f12849a.itemType, c3434a.f12849a.itemId);
        Message message2 = new Message();
        message2.what = 2;
        message2.obj = downloadResponseEntry;
        Bundle bundle = new Bundle();
        switch (message.what) {
            case 1:
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("download_anicon, Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3765n.f13505a);
                    return;
                }
                return;
            case 2:
                if (this.f13510a.f13506b != null) {
                    this.f13510a.f13506b.getButton(-2).setEnabled(false);
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("installing_anicon, Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3765n.f13505a);
                    return;
                }
                return;
            case 3:
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("Anicon download canceled , Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3765n.f13505a);
                }
                if (this.f13510a.f13506b != null && !((Activity) this.f13510a.f13507c).isFinishing()) {
                    this.f13510a.f13506b.dismiss();
                }
                bundle.putString("download_result", c3434a.f12849a.cancel);
                message2.setData(bundle);
                this.f13510a.f13508d.sendMessage(message2);
                return;
            case 4:
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("Anicon download completed , Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3765n.f13505a);
                }
                try {
                    try {
                        this.f13510a.m14149a(c3434a.f12849a);
                        bundle.putString("download_result", c3434a.f12849a.success);
                        message2.setData(bundle);
                        this.f13510a.f13508d.sendMessage(message2);
                    } catch (OperationApplicationException e) {
                        e.printStackTrace();
                        if (this.f13510a.f13506b != null && !((Activity) this.f13510a.f13507c).isFinishing()) {
                            alertDialogC4916i = this.f13510a.f13506b;
                        }
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        if (this.f13510a.f13506b != null && !((Activity) this.f13510a.f13507c).isFinishing()) {
                            alertDialogC4916i = this.f13510a.f13506b;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        if (this.f13510a.f13506b != null && !((Activity) this.f13510a.f13507c).isFinishing()) {
                            alertDialogC4916i = this.f13510a.f13506b;
                        }
                    }
                    if (this.f13510a.f13506b != null && !((Activity) this.f13510a.f13507c).isFinishing()) {
                        alertDialogC4916i = this.f13510a.f13506b;
                        alertDialogC4916i.dismiss();
                    }
                    return;
                } finally {
                }
            case 5:
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("Anicon download failed , Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3765n.f13505a);
                }
                if (this.f13510a.f13506b != null && !((Activity) this.f13510a.f13507c).isFinishing()) {
                    this.f13510a.f13506b.dismiss();
                }
                bundle.putString("download_result", c3434a.f12849a.error);
                message2.setData(bundle);
                this.f13510a.f13508d.sendMessage(message2);
                return;
            case 6:
                if (this.f13510a.f13506b != null) {
                    this.f13510a.f13506b.m18719a(c3434a.m19061f().intValue());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
