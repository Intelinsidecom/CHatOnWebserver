package com.sec.chaton.shop;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2182ah;
import com.sec.chaton.p057e.p058a.C2196j;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.settings.p096a.C3455ab;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.shop.entrys.DeleteRequestEntry;
import com.sec.chaton.shop.entrys.DownloadCancelRequestEntry;
import com.sec.chaton.shop.entrys.DownloadCancelResponseEntry;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.entrys.MultiDownloadRequest;
import com.sec.chaton.shop.entrys.MultiDownloadResponse;
import com.sec.chaton.shop.entrys.PreDownloadRequestEntry;
import com.sec.chaton.shop.entrys.PreDownloadResponseEntry;
import com.sec.chaton.shop.entrys.PurchaseRequestEntry;
import com.sec.chaton.shop.entrys.PurchaseResponseEntry;
import com.sec.chaton.shop.entrys.VerifiedItemListRequestEntry;
import com.sec.chaton.shop.entrys.ViewResolutionRequestEntry;
import com.sec.chaton.shop.entrys.ViewResolutionResponseEntry;
import com.sec.chaton.shop.items.Item;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChatONShopDownload.java */
/* renamed from: com.sec.chaton.shop.f */
/* loaded from: classes.dex */
public class C3733f {

    /* renamed from: a */
    private static final String f13415a = C3733f.class.getSimpleName();

    /* renamed from: a */
    public static EnumC2258bd m14069a(long j) {
        EnumC2258bd enumC2258bd = EnumC2258bd.Unknown;
        if (j == 1) {
            return EnumC2258bd.Anicon;
        }
        if (j == 3) {
            return EnumC2258bd.Skin;
        }
        if (j == 5) {
            return EnumC2258bd.Font;
        }
        if (j == 6) {
            return EnumC2258bd.Sound;
        }
        if (j == 7) {
            return EnumC2258bd.AmsTemplate;
        }
        if (j == 8) {
            return EnumC2258bd.AmsBackground;
        }
        if (j == 9) {
            return EnumC2258bd.AmsStamp;
        }
        return enumC2258bd;
    }

    /* renamed from: a */
    public static long m14068a(EnumC2258bd enumC2258bd) {
        switch (C3734g.f13416a[enumC2258bd.ordinal()]) {
            case 1:
                return 1L;
            case 2:
                return 3L;
            case 3:
                return 5L;
            case 4:
                return 6L;
            case 5:
                return 7L;
            case 6:
                return 8L;
            case 7:
                return 9L;
            default:
                return 0L;
        }
    }

    /* renamed from: a */
    public PurchaseResponseEntry m14075a(PurchaseRequestEntry purchaseRequestEntry, Handler handler, Activity activity, Intent intent, String str) {
        PurchaseResponseEntry purchaseResponseEntry;
        if (intent != null) {
            purchaseResponseEntry = new PurchaseResponseEntry(purchaseRequestEntry.itemType, purchaseRequestEntry.itemId, 0, intent.getStringExtra("purchase_data"), purchaseRequestEntry.market.get(0).marketCode, intent.getStringExtra("signature"));
            if (C4904y.f17872b) {
                C4904y.m18639b("start to purchase successful", f13415a);
            }
        } else {
            purchaseResponseEntry = new PurchaseResponseEntry(purchaseRequestEntry.itemType, purchaseRequestEntry.itemId, 0, null, purchaseRequestEntry.market.get(0).marketCode, null);
            if (C4904y.f17875e) {
                C4904y.m18634a("start to purchase, but fail...", f13415a);
            }
        }
        m14070a(handler, 1, purchaseResponseEntry, str);
        return purchaseResponseEntry;
    }

    /* renamed from: a */
    public void m14078a(DownloadRequestEntry downloadRequestEntry, Activity activity, Handler handler) {
        if (C4904y.f17872b) {
            C4904y.m18639b("start to download", f13415a);
        }
        new C3763l().m14146a(downloadRequestEntry, activity, handler);
        ArrayList arrayList = new ArrayList();
        arrayList.add(C2182ah.m9742a(m14069a(downloadRequestEntry.itemType).m10123a(), Long.toString(downloadRequestEntry.itemId)));
        try {
            C4821am.m18190a(activity, "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        } catch (OperationApplicationException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f13415a);
            }
        } catch (RemoteException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f13415a);
            }
        }
    }

    /* renamed from: a */
    public void m14077a(DeleteRequestEntry deleteRequestEntry, Activity activity, Handler handler) {
        new C3768q().m14156a(deleteRequestEntry, activity, handler);
    }

    /* renamed from: a */
    public DownloadCancelResponseEntry m14072a(DownloadCancelRequestEntry downloadCancelRequestEntry, Handler handler) {
        return new DownloadCancelResponseEntry(downloadCancelRequestEntry.itemType, downloadCancelRequestEntry.itemId);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.shop.entrys.DownloadedListResponseEntry m14073a(com.sec.chaton.shop.entrys.DownloadedListRequestEntry r15, android.app.Activity r16, android.os.Handler r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.shop.C3733f.m14073a(com.sec.chaton.shop.entrys.DownloadedListRequestEntry, android.app.Activity, android.os.Handler):com.sec.chaton.shop.entrys.DownloadedListResponseEntry");
    }

    /* renamed from: a */
    private void m14071a(ArrayList<Item> arrayList) {
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<Item> it = arrayList.iterator();
            while (it.hasNext()) {
                Item next = it.next();
                arrayList2.add(C2196j.m9898a(m14069a(next.itemType), String.valueOf(next.itemId), 0L));
            }
            if (arrayList2.size() > 0) {
                try {
                    C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList2);
                } catch (OperationApplicationException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f13415a);
                        return;
                    }
                    return;
                } catch (RemoteException e2) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, f13415a);
                        return;
                    }
                    return;
                }
            }
            Iterator<Item> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Item next2 = it2.next();
                switch (C3734g.f13416a[m14069a(next2.itemType).ordinal()]) {
                    case 2:
                        C3474r.m13824b(String.valueOf(next2.itemId));
                        break;
                    case 4:
                        if (!C3455ab.m13747a(String.valueOf(next2.itemId))) {
                            break;
                        } else {
                            C3455ab.m13751b();
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: a */
    public ViewResolutionResponseEntry m14076a(ViewResolutionRequestEntry viewResolutionRequestEntry, Handler handler) {
        return new ViewResolutionResponseEntry("mResolution");
    }

    /* renamed from: a */
    public void m14080a(VerifiedItemListRequestEntry verifiedItemListRequestEntry, Activity activity) {
        ArrayList arrayList = new ArrayList();
        Iterator<Item> it = verifiedItemListRequestEntry.item.iterator();
        while (it.hasNext()) {
            Item next = it.next();
            String string = Long.toString(next.itemId);
            String strM10123a = m14069a(next.itemType).m10123a();
            if (C4904y.f17872b) {
                C4904y.m18639b("Delete verified item : " + string, f13415a);
            }
            arrayList.add(C2182ah.m9742a(strM10123a, string));
        }
        try {
            C4821am.m18190a(activity, "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
            if (C4904y.f17872b) {
                C4904y.m18639b("The verified item is expired. Delete from database.", f13415a);
            }
        } catch (Exception e) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Failed to delete verified item. ", f13415a);
            }
        }
    }

    /* renamed from: a */
    public PreDownloadResponseEntry m14074a(PreDownloadRequestEntry preDownloadRequestEntry, Handler handler) {
        PreDownloadResponseEntry preDownloadResponseEntry = null;
        switch ((int) preDownloadRequestEntry.itemType) {
            case 1:
                preDownloadResponseEntry = new PreDownloadResponseEntry(preDownloadRequestEntry.itemType, "png", 240);
                break;
            case 3:
                preDownloadResponseEntry = new PreDownloadResponseEntry(preDownloadRequestEntry.itemType, C3474r.m13810a(), C3474r.m13810a(), C5034k.m19100e(), C5034k.m19101f(), 3);
                break;
            case 5:
                preDownloadResponseEntry = new PreDownloadResponseEntry(preDownloadRequestEntry.itemType);
                break;
            case 6:
                preDownloadResponseEntry = new PreDownloadResponseEntry(preDownloadRequestEntry.itemType, "mp3");
                break;
            case 7:
            case 8:
            case 9:
                preDownloadResponseEntry = new PreDownloadResponseEntry(preDownloadRequestEntry.itemType);
                break;
        }
        m14070a(handler, 8, preDownloadResponseEntry, preDownloadRequestEntry.success);
        return preDownloadResponseEntry;
    }

    /* renamed from: a */
    public void m14079a(MultiDownloadRequest multiDownloadRequest, Activity activity, Handler handler) {
        if (C4904y.f17872b) {
            C4904y.m18639b("start to multidownload", f13415a);
        }
        ArrayList arrayList = new ArrayList();
        int iM10677a = C2471v.m10677a(activity);
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(activity, R.string.popup_no_network_connection, 0).show();
            if (C4904y.f17872b) {
                C4904y.m18639b("There is no network connection", f13415a);
            }
            Bundle bundle = new Bundle();
            Message message = new Message();
            message.what = 9;
            bundle.putString("itemmultidownload_result", multiDownloadRequest.error);
            message.obj = new MultiDownloadResponse(new ArrayList());
            message.setData(bundle);
            handler.sendMessage(message);
        }
        Iterator<Item> it = multiDownloadRequest.item.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.toString(it.next().itemId));
        }
        if (arrayList.size() == 0) {
            C5179v.m19810a(activity, R.string.already_downloaded, 0).show();
            Bundle bundle2 = new Bundle();
            Message message2 = new Message();
            message2.what = 9;
            bundle2.putString("itemmultidownload_result", multiDownloadRequest.error);
            message2.obj = new MultiDownloadResponse(new ArrayList());
            message2.setData(bundle2);
            handler.sendMessage(message2);
            return;
        }
        EnumC2258bd enumC2258bdM14069a = m14069a(multiDownloadRequest.item.get(0).itemType);
        if (enumC2258bdM14069a == null) {
            Bundle bundle3 = new Bundle();
            Message message3 = new Message();
            message3.what = 9;
            bundle3.putString("itemmultidownload_result", multiDownloadRequest.error);
            message3.obj = new MultiDownloadResponse(new ArrayList());
            message3.setData(bundle3);
            handler.sendMessage(message3);
            return;
        }
        switch (C3734g.f13416a[enumC2258bdM14069a.ordinal()]) {
            case 1:
                new C3717ah(activity, multiDownloadRequest, arrayList, handler).m14047a();
                break;
            case 2:
                new C3711ab(activity, multiDownloadRequest, arrayList, handler).m14025a();
                break;
            case 4:
                new C3773v(activity, multiDownloadRequest, arrayList, handler).m14186a();
                break;
        }
    }

    /* renamed from: a */
    private void m14070a(Handler handler, int i, Object obj, String str) {
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        Bundle bundle = new Bundle();
        switch (i) {
            case 1:
                bundle.putString("purchase_result", str);
                break;
            case 2:
            case 4:
            default:
                bundle = null;
                break;
            case 3:
                bundle.putString("itemlist_result", str);
                break;
            case 5:
                bundle.putString("itemdelete_result", str);
                break;
            case 6:
                bundle.putString("itemapply_result", str);
                break;
            case 7:
                bundle.putString("viewresolution_result", str);
                break;
            case 8:
                bundle.putString("predownload_result", str);
                break;
        }
        if (bundle != null) {
            message.setData(bundle);
        }
        handler.sendMessage(message);
    }
}
