package com.sec.chaton.shop;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.settings.p096a.p097a.C3447n;
import com.sec.chaton.shop.entrys.MultiDownloadResponse;
import com.sec.chaton.shop.items.Item;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;
import com.sec.widget.C5179v;

/* compiled from: ShopMultiDownloadSkin.java */
/* renamed from: com.sec.chaton.shop.ac */
/* loaded from: classes.dex */
class HandlerC3712ac extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3711ab f13363a;

    HandlerC3712ac(C3711ab c3711ab) {
        this.f13363a = c3711ab;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        super.handleMessage(message);
        if (this.f13363a.f13350c != null) {
            C3447n c3447n = (C3447n) message.obj;
            Message message2 = new Message();
            Bundle bundle = new Bundle();
            if (c3447n.f12885a == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("Skin download entry field has problem , Shop itemid: ", c3447n.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3711ab.f13348b);
                }
                if (this.f13363a.f13354g != null) {
                    this.f13363a.f13354g.dismiss();
                    return;
                }
                return;
            }
            message2.what = 9;
            switch (message.what) {
                case 1:
                    break;
                case 2:
                    if (this.f13363a.f13354g != null) {
                        this.f13363a.f13354g.getButton(-2).setEnabled(false);
                        break;
                    }
                    break;
                case 3:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Skin download canceled , Shop itemid: ", c3447n.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3711ab.f13348b);
                    }
                    if (this.f13363a.f13354g != null && !((Activity) this.f13363a.f13350c).isFinishing()) {
                        this.f13363a.f13354g.dismiss();
                    }
                    bundle.putString("itemmultidownload_result", this.f13363a.f13360m.cancel);
                    message2.obj = new MultiDownloadResponse(this.f13363a.f13358k);
                    message2.setData(bundle);
                    this.f13363a.f13355h.sendMessage(message2);
                    C5179v.m19810a(this.f13363a.f13350c, R.string.calllog_cancelled_call, 0).show();
                    return;
                case 4:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Skin download completed , Shop itemid: ", c3447n.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3711ab.f13348b);
                    }
                    try {
                        this.f13363a.m14007a(c3447n.f12885a);
                        this.f13363a.f13358k.add(new Item(c3447n.f12885a.itemId, c3447n.f12885a.itemType, c3447n.f12885a.itemVersion));
                        if (this.f13363a.f13354g != null) {
                            this.f13363a.f13354g.setMessage(this.f13363a.f13350c.getResources().getString(R.string.anicon_file_downloading) + "    (" + this.f13363a.f13352e + "/" + this.f13363a.f13356i + ")");
                        }
                        if (this.f13363a.f13352e < this.f13363a.f13356i) {
                            this.f13363a.m14016d();
                            return;
                        }
                        bundle.putString("itemmultidownload_result", this.f13363a.f13360m.success);
                        message2.obj = new MultiDownloadResponse(this.f13363a.f13358k);
                        message2.setData(bundle);
                        this.f13363a.f13355h.sendMessage(message2);
                        C5179v.m19810a(this.f13363a.f13350c, R.string.item_downloaded, 0).show();
                        if (this.f13363a.f13354g != null && !((Activity) this.f13363a.f13350c).isFinishing()) {
                            this.f13363a.f13354g.dismiss();
                            return;
                        }
                        return;
                    } catch (OperationApplicationException e) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("OperationApplicationException: " + e.getMessage(), C3711ab.f13348b);
                            return;
                        }
                        return;
                    } catch (RemoteException e2) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("RemoteException: " + e2.getMessage(), C3711ab.f13348b);
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Exception: " + e3.getMessage(), C3711ab.f13348b);
                            return;
                        }
                        return;
                    }
                case 5:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Skin download failed , Shop itemid: ", c3447n.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3711ab.f13348b);
                    }
                    if (this.f13363a.f13354g != null && !((Activity) this.f13363a.f13350c).isFinishing()) {
                        this.f13363a.f13354g.dismiss();
                    }
                    message2.obj = new MultiDownloadResponse(this.f13363a.f13358k);
                    bundle.putString("itemmultidownload_result", this.f13363a.f13360m.error);
                    message2.setData(bundle);
                    this.f13363a.f13355h.sendMessage(message2);
                    C5179v.m19810a(this.f13363a.f13350c, R.string.anicon_file_download_fail, 0).show();
                    return;
                case 6:
                    if (this.f13363a.f13354g != null && !((Activity) this.f13363a.f13350c).isFinishing()) {
                        this.f13363a.f13354g.m18719a(c3447n.m19061f().intValue());
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("download_skin, Shop itemid: ", c3447n.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3711ab.f13348b);
            }
        }
    }
}
