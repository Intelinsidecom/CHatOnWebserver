package com.sec.chaton.shop;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.shop.entrys.ApplyResponseEntry;
import com.sec.chaton.shop.entrys.DeleteResponseEntry;
import com.sec.chaton.shop.entrys.DownloadCancelResponseEntry;
import com.sec.chaton.shop.entrys.DownloadResponseEntry;
import com.sec.chaton.shop.entrys.DownloadedListResponseEntry;
import com.sec.chaton.shop.entrys.MultiDownloadResponse;
import com.sec.chaton.shop.entrys.PreDownloadResponseEntry;
import com.sec.chaton.shop.entrys.PurchaseResponseEntry;
import com.sec.chaton.shop.entrys.ViewResolutionResponseEntry;

/* compiled from: ChatONShopFragment.java */
/* renamed from: com.sec.chaton.shop.i */
/* loaded from: classes.dex */
class HandlerC3736i extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONShopFragment f13418a;

    HandlerC3736i(ChatONShopFragment chatONShopFragment) {
        this.f13418a = chatONShopFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                m14081a(message.getData().getString("purchase_result"), (PurchaseResponseEntry) message.obj);
                break;
            case 2:
                m14081a(message.getData().getString("download_result"), (DownloadResponseEntry) message.obj);
                break;
            case 3:
                m14081a(message.getData().getString("itemlist_result"), (DownloadedListResponseEntry) message.obj);
                break;
            case 4:
                m14081a(message.getData().getString("itemcancel_result"), (DownloadCancelResponseEntry) message.obj);
                break;
            case 5:
                m14081a(message.getData().getString("itemdelete_result"), (DeleteResponseEntry) message.obj);
                break;
            case 6:
                m14081a(message.getData().getString("itemapply_result"), (ApplyResponseEntry) message.obj);
                break;
            case 7:
                m14081a(message.getData().getString("viewresolution_result"), (ViewResolutionResponseEntry) message.obj);
                break;
            case 8:
                m14081a(message.getData().getString("predownload_result"), (PreDownloadResponseEntry) message.obj);
                break;
            case 9:
                m14081a(message.getData().getString("itemmultidownload_result"), (MultiDownloadResponse) message.obj);
                break;
            default:
                this.f13418a.loadUrl((String) message.obj);
                break;
        }
    }

    /* renamed from: a */
    private void m14081a(String str, Object obj) {
        if (obj != null) {
            String strM10710a = new C2477a().m10710a(obj);
            if (!TextUtils.isEmpty(str)) {
                this.f13418a.loadUrl(C2602p.m11011a(str, strM10710a));
            }
        }
    }
}
