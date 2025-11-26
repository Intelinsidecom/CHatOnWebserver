package com.sec.chaton.settings.game;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.mobileweb.C2586a;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.mobileweb.EnumC2598l;
import com.sec.chaton.mobileweb.p077a.AsyncTaskC2587a;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.settings.game.entry.App;
import com.sec.chaton.settings.game.entry.AppListEntry;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;

/* compiled from: GameMobileWebFragment.java */
/* renamed from: com.sec.chaton.settings.game.a */
/* loaded from: classes.dex */
class HandlerC3646a extends Handler {

    /* renamed from: a */
    final /* synthetic */ GameMobileWebFragment f13218a;

    HandlerC3646a(GameMobileWebFragment gameMobileWebFragment) {
        this.f13218a = gameMobileWebFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        EnumC2598l enumC2598lM11002a;
        if (this.f13218a.isValidActivity() && (enumC2598lM11002a = EnumC2598l.m11002a(message.what)) != null) {
            String str = (String) message.obj;
            String str2 = String.format("api(%s) with arguments : %s", enumC2598lM11002a.m11006d(), str);
            if (C4904y.f17872b) {
                C4904y.m18639b(str2, GameMobileWebFragment.f13214a);
            }
            switch (enumC2598lM11002a) {
                case HANDSHAKE_V2:
                    AsyncTaskC2587a.m10995a(this.f13218a.f13217d, C2602p.m11012a(this.f13218a.getRequestApiList())).execute(str);
                    break;
                case BADGECLEAR_V1:
                    C4809aa.m18104a().m18124a("cleared_timestamp_game", Long.valueOf(C4809aa.m18104a().m18118a("notification_api_timestamp", 0L)));
                    C4809aa.m18104a().m18126b("new_game_count", (Integer) 0);
                    break;
                case APPLIST_V1:
                    AppListEntry appListEntry = null;
                    try {
                        appListEntry = (AppListEntry) new C2477a(str).m10709a(AppListEntry.class);
                    } catch (ClassNotFoundException e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, GameMobileWebFragment.f13214a);
                        }
                    } catch (IllegalAccessException e2) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e2, GameMobileWebFragment.f13214a);
                        }
                    } catch (InstantiationException e3) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e3, GameMobileWebFragment.f13214a);
                        }
                    } catch (JSONException e4) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e4, GameMobileWebFragment.f13214a);
                        }
                    }
                    if (appListEntry != null) {
                        ArrayList<App> arrayList = new ArrayList<>();
                        Iterator<App> it = appListEntry.app.iterator();
                        while (it.hasNext()) {
                            App next = it.next();
                            if (next.uri != null && C5034k.m19095a(GlobalApplication.m18732r(), next.uri)) {
                                App app = new App();
                                app.uri = next.uri;
                                arrayList.add(app);
                            }
                        }
                        AppListEntry appListEntry2 = new AppListEntry();
                        appListEntry2.app = arrayList;
                        this.f13218a.loadUrl(C2602p.m11011a(appListEntry.success, new C2477a().m10710a(appListEntry2)));
                        break;
                    }
                    break;
                case APPEXEC_V1:
                    C4822an.m18212a(GlobalApplication.m18732r(), str);
                    break;
                case GOPAGE_V2:
                    if (C2586a.m10989a(Uri.parse(str)) != null) {
                        switch (r0.m10991a()) {
                            case M_ACTION_MORE_TAB:
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("GOPAGE : MORE_TAB", GameMobileWebFragment.f13214a);
                                }
                                this.f13218a.getAttachedActivity().finish();
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
