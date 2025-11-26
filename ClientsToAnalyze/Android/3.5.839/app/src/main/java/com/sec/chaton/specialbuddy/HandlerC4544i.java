package com.sec.chaton.specialbuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.mobileweb.C2586a;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.mobileweb.EnumC2598l;
import com.sec.chaton.mobileweb.p077a.AsyncTaskC2587a;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p065io.entry.FollowingStatusEntry;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.shop.ChatONShopActivity;
import com.sec.chaton.shop.entrys.ToastRequestEntry;
import com.sec.chaton.util.C4904y;
import java.util.Map;
import org.json.JSONException;

/* compiled from: ChatONLiveMainFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.i */
/* loaded from: classes.dex */
class HandlerC4544i extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveMainFragment f16404a;

    HandlerC4544i(ChatONLiveMainFragment chatONLiveMainFragment) {
        this.f16404a = chatONLiveMainFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ToastRequestEntry toastRequestEntry;
        Intent intentM10990a;
        FollowingStatusEntry followingStatusEntry = null;
        if (this.f16404a.isValidActivity()) {
            if (!C2602p.m11019b(this.f16404a.mWebView.getUrl())) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("[Security Check] Interface called from : " + this.f16404a.mWebView.getUrl(), ChatONLiveMainFragment.f16291a);
                    return;
                }
                return;
            }
            EnumC2598l enumC2598lM11002a = EnumC2598l.m11002a(message.what);
            if (enumC2598lM11002a != null) {
                String str = (String) message.obj;
                C4904y.m18639b(String.format("api(%s) with arguments : %s", enumC2598lM11002a.m11006d(), str), ChatONLiveMainFragment.f16291a);
                switch (enumC2598lM11002a) {
                    case HANDSHAKE_V2:
                        AsyncTaskC2587a.m10995a(this.f16404a.f16297j, C2602p.m11012a(this.f16404a.getRequestApiList())).execute(str);
                        break;
                    case GOPAGE_V1:
                    case GOPAGE_V2:
                    case GOPAGE_V3:
                        C2586a c2586aM10989a = C2586a.m10989a(Uri.parse(str));
                        if (c2586aM10989a != null) {
                            switch (c2586aM10989a.m10991a()) {
                                case M_ACTION_BUDDY_POPUP:
                                    Intent intentM10990a2 = c2586aM10989a.m10990a(this.f16404a.getAttachedActivity());
                                    if (intentM10990a2 != null) {
                                        Map<String, String> mapM10992b = c2586aM10989a.m10992b();
                                        this.f16404a.f16293f = null;
                                        if (mapM10992b != null) {
                                            this.f16404a.f16293f = mapM10992b.get("buddyid");
                                        }
                                        this.f16404a.startActivity(intentM10990a2);
                                        break;
                                    }
                                    break;
                                case M_ACTION_LIVE_CONTENTS:
                                    Intent intentM10990a3 = c2586aM10989a.m10990a(this.f16404a.getAttachedActivity());
                                    if (intentM10990a3 != null) {
                                        Map<String, String> mapM10992b2 = c2586aM10989a.m10992b();
                                        this.f16404a.f16293f = null;
                                        if (mapM10992b2 != null) {
                                            this.f16404a.f16293f = mapM10992b2.get("buddyid");
                                        }
                                        intentM10990a3.setFlags(67108864);
                                        intentM10990a3.putExtra("fromLiveMain", true);
                                        this.f16404a.startActivity(intentM10990a3);
                                        break;
                                    }
                                    break;
                                case M_ACTION_LIVE_CHAT:
                                    if (C2349a.m10301a("live_chat_feature") && (intentM10990a = c2586aM10989a.m10990a(this.f16404a.getAttachedActivity())) != null) {
                                        intentM10990a.setFlags(67108864);
                                        this.f16404a.startActivity(intentM10990a);
                                        break;
                                    }
                                    break;
                            }
                        }
                        break;
                    case BADGECLEAR_V1:
                        if ("live".equals(str)) {
                            C4542g.m17231a();
                            break;
                        }
                        break;
                    case FOLLOWINGSTATUS_V1:
                        try {
                            try {
                                followingStatusEntry = (FollowingStatusEntry) new C2477a(str).m10709a(FollowingStatusEntry.class);
                            } catch (ClassNotFoundException e) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e, ChatONLiveMainFragment.f16291a);
                                }
                            } catch (IllegalAccessException e2) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e2, ChatONLiveMainFragment.f16291a);
                                }
                            } catch (InstantiationException e3) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e3, ChatONLiveMainFragment.f16291a);
                                }
                            } catch (JSONException e4) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e4, ChatONLiveMainFragment.f16291a);
                                }
                            }
                            if (followingStatusEntry != null) {
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("FOLLOWINGSTATUS_V1 id[" + followingStatusEntry.getId() + "], status[" + followingStatusEntry.getStatus() + "]", ChatONLiveMainFragment.f16291a);
                                }
                                if (followingStatusEntry.getStatus().compareTo(Boolean.toString(true)) == 0) {
                                    new C2128i(null).m9515c();
                                    if (C4904y.f17872b) {
                                        C4904y.m18639b("FOLLOWINGSTATUS_V1 id[" + followingStatusEntry.getId() + "] status changed", ChatONLiveMainFragment.f16291a);
                                        break;
                                    }
                                }
                            }
                        } catch (NullPointerException e5) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("FOLLOWINGSTATUS_V1 no key for ...", ChatONLiveMainFragment.f16291a);
                                return;
                            }
                            return;
                        } catch (UnsupportedOperationException e6) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("FOLLOWINGSTATUS_V1 not a hierarchical URI", ChatONLiveMainFragment.f16291a);
                                return;
                            }
                            return;
                        }
                        break;
                    case TOAST_V1:
                        if (this.f16404a.getActivity() != null && (this.f16404a.getActivity() instanceof ChatONShopActivity) && !((ChatONShopActivity) this.f16404a.getActivity()).m13974h()) {
                            try {
                                toastRequestEntry = (ToastRequestEntry) new C2477a(str).m10709a(ToastRequestEntry.class);
                            } catch (Exception e7) {
                                this.f16404a.m17131a("TOAST_V1", e7.toString());
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e7, ChatONLiveMainFragment.f16291a);
                                }
                                toastRequestEntry = null;
                            }
                            if (toastRequestEntry != null) {
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("TOAST_V1 : " + toastRequestEntry, ChatONLiveMainFragment.f16291a);
                                }
                                this.f16404a.m17130a(toastRequestEntry.message, toastRequestEntry.period);
                                break;
                            }
                        }
                        break;
                }
            }
        }
    }
}
