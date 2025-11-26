package com.sec.chaton.shop;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.mobileweb.C2586a;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.mobileweb.EnumC2598l;
import com.sec.chaton.mobileweb.p077a.AsyncTaskC2587a;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.shop.entrys.ApplyRequestEntry;
import com.sec.chaton.shop.entrys.DeleteRequestEntry;
import com.sec.chaton.shop.entrys.DownloadCancelRequestEntry;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.shop.entrys.DownloadedListRequestEntry;
import com.sec.chaton.shop.entrys.ForwardChatMessageEntry;
import com.sec.chaton.shop.entrys.MultiDownloadRequest;
import com.sec.chaton.shop.entrys.PreDownloadRequestEntry;
import com.sec.chaton.shop.entrys.PurchaseRequestEntry;
import com.sec.chaton.shop.entrys.ToastRequestEntry;
import com.sec.chaton.shop.entrys.VerifiedItemListRequestEntry;
import com.sec.chaton.shop.entrys.ViewResolutionRequestEntry;
import com.sec.chaton.shop.inappbilling.BillingDialogActivity;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: ChatONShopFragment.java */
/* renamed from: com.sec.chaton.shop.h */
/* loaded from: classes.dex */
class HandlerC3735h extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONShopFragment f13417a;

    HandlerC3735h(ChatONShopFragment chatONShopFragment) {
        this.f13417a = chatONShopFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        EnumC2598l enumC2598lM11002a;
        MultiDownloadRequest multiDownloadRequest;
        ForwardChatMessageEntry forwardChatMessageEntry = null;
        PurchaseRequestEntry purchaseRequestEntry = null;
        downloadRequestEntry = null;
        DownloadRequestEntry downloadRequestEntry = null;
        downloadedListRequestEntry = null;
        DownloadedListRequestEntry downloadedListRequestEntry = null;
        downloadCancelRequestEntry = null;
        DownloadCancelRequestEntry downloadCancelRequestEntry = null;
        deleteRequestEntry = null;
        DeleteRequestEntry deleteRequestEntry = null;
        applyRequestEntry = null;
        ApplyRequestEntry applyRequestEntry = null;
        verifiedItemListRequestEntry = null;
        VerifiedItemListRequestEntry verifiedItemListRequestEntry = null;
        viewResolutionRequestEntry = null;
        ViewResolutionRequestEntry viewResolutionRequestEntry = null;
        preDownloadRequestEntry = null;
        PreDownloadRequestEntry preDownloadRequestEntry = null;
        toastRequestEntry = null;
        ToastRequestEntry toastRequestEntry = null;
        forwardChatMessageEntry = null;
        if (this.f13417a.isValidActivity() && (enumC2598lM11002a = EnumC2598l.m11002a(message.what)) != null) {
            String str = (String) message.obj;
            String str2 = String.format("api(%s) with arguments : %s", enumC2598lM11002a.m11006d(), str);
            if (C4904y.f17872b) {
                C4904y.m18639b(str2, ChatONShopFragment.f13331a);
            }
            switch (enumC2598lM11002a) {
                case HANDSHAKE_V2:
                    this.f13417a.m13985a("HANDSHAKE_V2", "receive:" + str.toString());
                    AsyncTaskC2587a.m10995a(this.f13417a.f13342l, C2602p.m11012a(this.f13417a.getRequestApiList())).execute(str);
                    break;
                case GOPAGE_V1:
                case GOPAGE_V2:
                    this.f13417a.m13985a("GOPAGE_V", "receive:" + str.toString());
                    C2586a c2586aM10989a = C2586a.m10989a(Uri.parse(str));
                    if (c2586aM10989a != null) {
                        switch (c2586aM10989a.m10991a()) {
                            case M_ACTION_BUDDY_POPUP:
                                Intent intentM10990a = c2586aM10989a.m10990a(this.f13417a.f13334d);
                                if (intentM10990a != null) {
                                    this.f13417a.startActivity(intentM10990a);
                                    break;
                                }
                                break;
                            case M_ACTION_LIVE_CONTENTS:
                                Intent intentM10990a2 = c2586aM10989a.m10990a(this.f13417a.f13334d);
                                if (intentM10990a2 != null) {
                                    intentM10990a2.setFlags(536870912);
                                    this.f13417a.startActivity(intentM10990a2);
                                    break;
                                }
                                break;
                            case M_ACTION_LIVE_CHAT:
                                if (!C2349a.m10301a("live_chat_feature")) {
                                }
                                break;
                            case M_ACTION_MORE_TAB:
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("GOPAGE : MORE_TAB", ChatONShopFragment.f13331a);
                                }
                                this.f13417a.f13334d.finish();
                                break;
                            case M_ACTION_GO_SAMSUNGACCOUNT:
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("GOPAGE : GO_SAMSUNGACCOUNT", ChatONShopFragment.f13331a);
                                    break;
                                }
                                break;
                        }
                    }
                    break;
                case BADGECLEAR_V1:
                    this.f13417a.m13985a("BADGECLEAR_V1", "receive:" + str.toString());
                    if (C4904y.f17872b) {
                        C4904y.m18639b("BADGECLEAR_V1", ChatONShopFragment.f13331a);
                        break;
                    }
                    break;
                case ITEMPURCHASE_V1:
                    this.f13417a.m13985a("ITEMPURCHASE_V1", "receive:" + str.toString());
                    try {
                        purchaseRequestEntry = (PurchaseRequestEntry) new C2477a(str).m10709a(PurchaseRequestEntry.class);
                    } catch (Exception e) {
                        this.f13417a.m13985a("ITEMPURCHASE_V1", e.toString());
                        C4904y.m18635a(e, ChatONShopFragment.f13331a);
                    }
                    if (purchaseRequestEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ITEMPURCHASE_V1 : " + purchaseRequestEntry, ChatONShopFragment.f13331a);
                        }
                        if (!"GP".equals(purchaseRequestEntry.market.get(0).marketCode)) {
                            C5179v.m19810a(this.f13417a.f13334d, R.string.purchase_failed, 1).show();
                            break;
                        } else if (!C4859bx.m18396c()) {
                            C5179v.m19810a(this.f13417a.f13334d, R.string.purchase_failed, 1).show();
                            break;
                        } else if (C4859bx.m18377a(this.f13417a.f13334d) != null) {
                            if (purchaseRequestEntry.market.get(0).productId == null) {
                                C5179v.m19810a(this.f13417a.f13334d, R.string.purchase_failed, 1).show();
                                break;
                            } else {
                                Intent intent = new Intent(this.f13417a.f13334d, (Class<?>) BillingDialogActivity.class);
                                intent.putExtra("product_id", purchaseRequestEntry.market.get(0).productId);
                                intent.putExtra("item_type", this.f13417a.m13977a(purchaseRequestEntry.itemType));
                                intent.putExtra("item_id", Long.toString(purchaseRequestEntry.itemId));
                                intent.putExtra("market_code", purchaseRequestEntry.market.get(0).marketCode);
                                intent.putExtra("market_data", this.f13417a.m13980a(purchaseRequestEntry.market.get(0)));
                                this.f13417a.startActivityForResult(intent, 10);
                                this.f13417a.f13335e = purchaseRequestEntry;
                                break;
                            }
                        }
                    }
                    break;
                case ITEMDOWNLOAD_V1:
                case ITEMDOWNLOAD_V2:
                    this.f13417a.m13985a("ITEMDOWNLOAD_V1", "receive:" + str.toString());
                    try {
                        downloadRequestEntry = (DownloadRequestEntry) new C2477a(str).m10709a(DownloadRequestEntry.class);
                    } catch (Exception e2) {
                        this.f13417a.m13985a("ITEMDOWNLOAD_V1", e2.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e2, ChatONShopFragment.f13331a);
                        }
                    }
                    if (downloadRequestEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ITEMDOWNLOAD_V1 : " + downloadRequestEntry, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.f13333c.m14078a(downloadRequestEntry, this.f13417a.f13334d, this.f13417a.f13342l);
                        break;
                    }
                    break;
                case ITEMLIST_V1:
                    this.f13417a.m13985a("ITEMLIST_V1", "receive:" + str.toString());
                    try {
                        downloadedListRequestEntry = (DownloadedListRequestEntry) new C2477a(str).m10709a(DownloadedListRequestEntry.class);
                    } catch (Exception e3) {
                        this.f13417a.m13985a("ITEMLIST_V1", e3.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e3, ChatONShopFragment.f13331a);
                        }
                    }
                    if (downloadedListRequestEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ITEMLIST_V1 : " + downloadedListRequestEntry, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.f13333c.m14073a(downloadedListRequestEntry, this.f13417a.f13334d, this.f13417a.f13342l);
                        break;
                    }
                    break;
                case ITEMCANCEL_V1:
                    this.f13417a.m13985a("ITEMCANCEL_V1", "receive:" + str.toString());
                    try {
                        downloadCancelRequestEntry = (DownloadCancelRequestEntry) new C2477a(str).m10709a(DownloadCancelRequestEntry.class);
                    } catch (Exception e4) {
                        this.f13417a.m13985a("ITEMCANCEL_V1", e4.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e4, ChatONShopFragment.f13331a);
                        }
                    }
                    if (downloadCancelRequestEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ITEMCANCEL_V1 : " + downloadCancelRequestEntry, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.f13333c.m14072a(downloadCancelRequestEntry, this.f13417a.f13342l);
                        break;
                    }
                    break;
                case ITEMDELETE_V1:
                    this.f13417a.m13985a("ITEMDELETE_V1", "receive:" + str.toString());
                    try {
                        deleteRequestEntry = (DeleteRequestEntry) new C2477a(str).m10709a(DeleteRequestEntry.class);
                    } catch (Exception e5) {
                        this.f13417a.m13985a("ITEMDELETE_V1", e5.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e5, ChatONShopFragment.f13331a);
                        }
                    }
                    if (deleteRequestEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ITEMDELETE_V1 : " + deleteRequestEntry, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.f13333c.m14077a(deleteRequestEntry, this.f13417a.f13334d, this.f13417a.f13342l);
                        break;
                    }
                    break;
                case ITEMAPPLY_V1:
                    this.f13417a.m13985a("ITEMAPPLY_V1", "receive:" + str.toString());
                    try {
                        applyRequestEntry = (ApplyRequestEntry) new C2477a(str).m10709a(ApplyRequestEntry.class);
                    } catch (Exception e6) {
                        this.f13417a.m13985a("ITEMAPPLY_V1", e6.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e6, ChatONShopFragment.f13331a);
                        }
                    }
                    if (applyRequestEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ITEMAPPLY_V1 : " + applyRequestEntry, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.f13339i = AsyncTaskC3731d.m14064a(applyRequestEntry, this.f13417a.f13334d, this.f13417a.f13342l);
                        this.f13417a.f13339i.execute(new Void[0]);
                        break;
                    }
                    break;
                case VERIFIEDITEMLIST_V1:
                    this.f13417a.m13985a("VERIFIEDITEMLIST_V1", "receive:" + str.toString());
                    try {
                        verifiedItemListRequestEntry = (VerifiedItemListRequestEntry) new C2477a(str).m10709a(VerifiedItemListRequestEntry.class);
                    } catch (Exception e7) {
                        this.f13417a.m13985a("VERIFIEDITEMLIST_V1", e7.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e7, ChatONShopFragment.f13331a);
                        }
                    }
                    if (verifiedItemListRequestEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ITEMAPPLY_V1 : " + verifiedItemListRequestEntry, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.f13333c.m14080a(verifiedItemListRequestEntry, this.f13417a.f13334d);
                        break;
                    }
                    break;
                case VIEWRESOLUTION_V1:
                    this.f13417a.m13985a("VIEWRESOLUTION_V1", "receive:" + str.toString());
                    try {
                        viewResolutionRequestEntry = (ViewResolutionRequestEntry) new C2477a(str).m10709a(ViewResolutionRequestEntry.class);
                    } catch (Exception e8) {
                        this.f13417a.m13985a("VIEWRESOLUTION_V1", e8.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e8, ChatONShopFragment.f13331a);
                        }
                    }
                    if (viewResolutionRequestEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("VIEWRESOLUTION_V1 : " + viewResolutionRequestEntry, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.f13333c.m14076a(viewResolutionRequestEntry, this.f13417a.f13342l);
                        break;
                    }
                    break;
                case PREDOWNLOAD_V1:
                    this.f13417a.m13985a("PREDOWNLOAD_V1", "receive:" + str.toString());
                    try {
                        preDownloadRequestEntry = (PreDownloadRequestEntry) new C2477a(str).m10709a(PreDownloadRequestEntry.class);
                    } catch (Exception e9) {
                        this.f13417a.m13985a("PREDOWNLOAD_V1", e9.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e9, ChatONShopFragment.f13331a);
                        }
                    }
                    if (preDownloadRequestEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("PREDOWNLOAD_V1 : " + preDownloadRequestEntry, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.f13333c.m14074a(preDownloadRequestEntry, this.f13417a.f13342l);
                        break;
                    }
                    break;
                case CLEARHISTORY_V1:
                    this.f13417a.clearHistory();
                    break;
                case TOAST_V1:
                    if (this.f13417a.getActivity() != null && (this.f13417a.getActivity() instanceof ChatONShopActivity) && !((ChatONShopActivity) this.f13417a.getActivity()).m13974h()) {
                        try {
                            toastRequestEntry = (ToastRequestEntry) new C2477a(str).m10709a(ToastRequestEntry.class);
                        } catch (Exception e10) {
                            this.f13417a.m13985a("TOAST_V1", e10.toString());
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e10, ChatONShopFragment.f13331a);
                            }
                        }
                        if (toastRequestEntry != null) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("TOAST_V1 : " + toastRequestEntry, ChatONShopFragment.f13331a);
                            }
                            this.f13417a.m13984a(toastRequestEntry.message, toastRequestEntry.period);
                            break;
                        }
                    }
                    break;
                case FORWARDCHATMESSAGE_V1:
                    this.f13417a.m13985a("FORWARDCHATMESSAGE_V1", "receive:" + str.toString());
                    try {
                        forwardChatMessageEntry = (ForwardChatMessageEntry) new C2477a(str).m10709a(ForwardChatMessageEntry.class);
                    } catch (Exception e11) {
                        this.f13417a.m13985a("FORWARDCHATMESSAGE_V1", e11.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e11, ChatONShopFragment.f13331a);
                        }
                    }
                    if (forwardChatMessageEntry != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("FORWARDCHATMESSAGE_V1 : " + forwardChatMessageEntry, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.m13990b(forwardChatMessageEntry.type, forwardChatMessageEntry.message);
                        break;
                    }
                    break;
                case ITEMMULTIDOWNLOAD_V1:
                case ITEMMULTIDOWNLOAD_V2:
                    this.f13417a.m13985a("ITEMMULTIDOWNLOAD_V2", "receive:" + str.toString());
                    try {
                        multiDownloadRequest = (MultiDownloadRequest) new C2477a(str).m10709a(MultiDownloadRequest.class);
                    } catch (Exception e12) {
                        this.f13417a.m13985a("ITEMMULTIDOWNLOAD_V2", e12.toString());
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e12, ChatONShopFragment.f13331a);
                        }
                        multiDownloadRequest = null;
                    }
                    if (multiDownloadRequest != null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ITEMMULTIDOWNLOAD_V2 : " + multiDownloadRequest, ChatONShopFragment.f13331a);
                        }
                        this.f13417a.f13333c.m14079a(multiDownloadRequest, this.f13417a.f13334d, this.f13417a.f13342l);
                        break;
                    }
                    break;
            }
        }
    }
}
