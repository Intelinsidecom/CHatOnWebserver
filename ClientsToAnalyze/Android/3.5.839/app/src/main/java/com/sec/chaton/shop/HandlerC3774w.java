package com.sec.chaton.shop;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.settings.p096a.p097a.C3451r;
import com.sec.chaton.shop.entrys.MultiDownloadResponse;
import com.sec.chaton.shop.items.Item;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;
import com.sec.widget.C5179v;

/* compiled from: ShopMultiDownloadRingTone.java */
/* renamed from: com.sec.chaton.shop.w */
/* loaded from: classes.dex */
class HandlerC3774w extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3773v f13538a;

    HandlerC3774w(C3773v c3773v) {
        this.f13538a = c3773v;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f13538a.f13525c != null) {
            C3451r c3451r = (C3451r) message.obj;
            Message message2 = new Message();
            Bundle bundle = new Bundle();
            if (c3451r.f12899a == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("RingTone download entry field has problem , Shop itemid: ", c3451r.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3773v.f13523b);
                }
                if (this.f13538a.f13529g != null) {
                    this.f13538a.f13529g.dismiss();
                    return;
                }
                return;
            }
            message2.what = 9;
            switch (message.what) {
                case 1:
                    break;
                case 2:
                    if (this.f13538a.f13529g != null) {
                        this.f13538a.f13529g.getButton(-2).setEnabled(false);
                        break;
                    }
                    break;
                case 3:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("RingTone download canceled , Shop itemid: ", c3451r.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3773v.f13523b);
                    }
                    if (this.f13538a.f13529g != null && !((Activity) this.f13538a.f13525c).isFinishing()) {
                        this.f13538a.f13529g.dismiss();
                    }
                    bundle.putString("itemmultidownload_result", this.f13538a.f13535m.cancel);
                    message2.obj = new MultiDownloadResponse(this.f13538a.f13533k);
                    message2.setData(bundle);
                    this.f13538a.f13530h.sendMessage(message2);
                    C5179v.m19810a(this.f13538a.f13525c, R.string.calllog_cancelled_call, 0).show();
                    return;
                case 4:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("RingTone download completed , Shop itemid: ", c3451r.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3773v.f13523b);
                    }
                    try {
                        this.f13538a.m14172b(c3451r.f12899a);
                        this.f13538a.f13533k.add(new Item(c3451r.f12899a.itemId, c3451r.f12899a.itemType, c3451r.f12899a.itemVersion));
                        if (this.f13538a.f13529g != null) {
                            this.f13538a.f13529g.setMessage(this.f13538a.f13525c.getResources().getString(R.string.anicon_file_downloading) + "    (" + this.f13538a.f13527e + "/" + this.f13538a.f13531i + ")");
                        }
                        if (this.f13538a.f13527e < this.f13538a.f13531i) {
                            this.f13538a.m14177d();
                            return;
                        }
                        bundle.putString("itemmultidownload_result", this.f13538a.f13535m.success);
                        message2.obj = new MultiDownloadResponse(this.f13538a.f13533k);
                        message2.setData(bundle);
                        this.f13538a.f13530h.sendMessage(message2);
                        C5179v.m19810a(this.f13538a.f13525c, R.string.item_downloaded, 0).show();
                        if (this.f13538a.f13529g != null && !((Activity) this.f13538a.f13525c).isFinishing()) {
                            this.f13538a.f13529g.dismiss();
                            return;
                        }
                        return;
                    } catch (OperationApplicationException e) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("OperationApplicationException: " + e.getMessage(), C3773v.f13523b);
                            return;
                        }
                        return;
                    } catch (RemoteException e2) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("RemoteException: " + e2.getMessage(), C3773v.f13523b);
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Exception: " + e3.getMessage(), C3773v.f13523b);
                            return;
                        }
                        return;
                    }
                case 5:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Ringtone download failed , Shop itemid: ", c3451r.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3773v.f13523b);
                    }
                    if (this.f13538a.f13529g != null && !((Activity) this.f13538a.f13525c).isFinishing()) {
                        this.f13538a.f13529g.dismiss();
                    }
                    message2.obj = new MultiDownloadResponse(this.f13538a.f13533k);
                    bundle.putString("itemmultidownload_result", this.f13538a.f13535m.error);
                    message2.setData(bundle);
                    this.f13538a.f13530h.sendMessage(message2);
                    C5179v.m19810a(this.f13538a.f13525c, R.string.anicon_file_download_fail, 0).show();
                    return;
                case 6:
                    if (this.f13538a.f13529g != null && !((Activity) this.f13538a.f13525c).isFinishing()) {
                        this.f13538a.f13529g.m18719a(c3451r.m19061f().intValue());
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("download_ringtone, Shop itemid: ", c3451r.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3773v.f13523b);
            }
        }
    }
}
