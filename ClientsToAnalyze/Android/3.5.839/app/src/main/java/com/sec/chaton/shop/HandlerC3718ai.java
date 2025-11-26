package com.sec.chaton.shop;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.settings.p096a.p097a.C3434a;
import com.sec.chaton.shop.entrys.MultiDownloadResponse;
import com.sec.chaton.shop.items.Item;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;
import com.sec.widget.C5179v;

/* compiled from: ShopMultiDownloadSticker.java */
/* renamed from: com.sec.chaton.shop.ai */
/* loaded from: classes.dex */
class HandlerC3718ai extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3717ah f13385a;

    HandlerC3718ai(C3717ah c3717ah) {
        this.f13385a = c3717ah;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f13385a.f13372c != null) {
            C3434a c3434a = (C3434a) message.obj;
            Message message2 = new Message();
            Bundle bundle = new Bundle();
            if (c3434a.f12849a == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("Anicon download entry field has problem , Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3717ah.f13370b);
                }
                if (this.f13385a.f13375f != null) {
                    this.f13385a.f13375f.dismiss();
                    return;
                }
                return;
            }
            message2.what = 9;
            switch (message.what) {
                case 1:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("download_anicon, Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3717ah.f13370b);
                        break;
                    }
                    break;
                case 2:
                    if (this.f13385a.f13375f != null) {
                        this.f13385a.f13375f.getButton(-2).setEnabled(false);
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("installing_anicon, PackageId: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3717ah.f13370b);
                        break;
                    }
                    break;
                case 3:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Anicon download canceled , Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3717ah.f13370b);
                    }
                    if (this.f13385a.f13375f != null && !((Activity) this.f13385a.f13372c).isFinishing()) {
                        this.f13385a.f13375f.dismiss();
                    }
                    bundle.putString("itemmultidownload_result", this.f13385a.f13382m.cancel);
                    message2.obj = new MultiDownloadResponse(this.f13385a.f13380k);
                    message2.setData(bundle);
                    this.f13385a.f13376g.sendMessage(message2);
                    C5179v.m19810a(this.f13385a.f13372c, R.string.calllog_cancelled_call, 1).show();
                    break;
                case 4:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Anicon download completed , Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3717ah.f13370b);
                    }
                    try {
                        this.f13385a.m14029a(c3434a.f12849a);
                        this.f13385a.f13380k.add(new Item(c3434a.f12849a.itemId, c3434a.f12849a.itemType, c3434a.f12849a.itemVersion));
                        if (this.f13385a.f13375f != null) {
                            this.f13385a.f13375f.setMessage(this.f13385a.f13372c.getResources().getString(R.string.anicon_file_downloading) + "    (" + this.f13385a.f13377h + "/" + this.f13385a.f13378i + ")");
                        }
                        if (this.f13385a.f13377h < this.f13385a.f13378i) {
                            this.f13385a.m14038d();
                            break;
                        } else {
                            bundle.putString("itemmultidownload_result", this.f13385a.f13382m.success);
                            message2.obj = new MultiDownloadResponse(this.f13385a.f13380k);
                            message2.setData(bundle);
                            this.f13385a.f13376g.sendMessage(message2);
                            C5179v.m19810a(this.f13385a.f13372c, R.string.item_downloaded, 1).show();
                            if (this.f13385a.f13375f != null && !((Activity) this.f13385a.f13372c).isFinishing()) {
                                this.f13385a.f13375f.dismiss();
                                break;
                            }
                        }
                    } catch (OperationApplicationException e) {
                        e.printStackTrace();
                        return;
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                    break;
                case 5:
                    if (C4904y.f17872b) {
                        C4904y.m18639b(C5052r.m19199a("Anicon download failed , Shop itemid: ", c3434a.m13720d(), ". Status: ", Integer.valueOf(message.what)), C3717ah.f13370b);
                    }
                    if (this.f13385a.f13375f != null && !((Activity) this.f13385a.f13372c).isFinishing()) {
                        this.f13385a.f13375f.dismiss();
                    }
                    message2.obj = new MultiDownloadResponse(this.f13385a.f13380k);
                    bundle.putString("itemmultidownload_result", this.f13385a.f13382m.error);
                    message2.setData(bundle);
                    this.f13385a.f13376g.sendMessage(message2);
                    C5179v.m19810a(this.f13385a.f13372c, R.string.anicon_file_download_fail, 1).show();
                    break;
                case 6:
                    if (this.f13385a.f13375f != null) {
                        this.f13385a.f13375f.m18719a(c3434a.m19061f().intValue());
                        break;
                    }
                    break;
            }
        }
    }
}
