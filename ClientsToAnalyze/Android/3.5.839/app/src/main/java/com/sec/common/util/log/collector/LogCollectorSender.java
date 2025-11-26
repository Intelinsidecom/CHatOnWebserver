package com.sec.common.util.log.collector;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.os.RemoteException;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.common.C4996f;
import com.sec.common.util.C5052r;
import com.sec.spp.push.dlc.api.IDlcApi;
import com.sec.spp.push.dlc.api.IDlcService;

/* loaded from: classes.dex */
public class LogCollectorSender extends IntentService {

    /* renamed from: a */
    private static final String f18352a = LogCollectorSender.class.getSimpleName();

    public LogCollectorSender() {
        super(f18352a);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g(f18352a, "onHandleIntent ");
        }
        if (C5036a.m19132e()) {
            if (C5038c.m19147a(System.currentTimeMillis())) {
                if (C4996f.f18229a.f18172d) {
                    C4996f.f18229a.m18893g(f18352a, "onHandleIntent() doesn't send log data because oldtime stamp was too old");
                }
                C5036a.m19125b();
                return;
            }
            if (C5038c.m19150b()) {
                if (C4996f.f18229a.f18172d) {
                    C4996f.f18229a.m18893g(f18352a, "onHandleIntent() Service is already binded send Log Now");
                }
                if (C5038c.m19154d() == null) {
                    if (C4996f.f18229a.f18172d) {
                        C4996f.f18229a.m18893g(f18352a, "onHandleIntent() Service is null");
                    }
                    C5036a.m19125b();
                    return;
                }
                m19116a();
                return;
            }
            C5038c.m19169r();
            try {
                finalize();
            } catch (Throwable th) {
                if (C4996f.f18229a.f18172d) {
                    C4996f.f18229a.m18893g(f18352a, "onHandleIntent() finalize Exception :: " + th.toString());
                }
            }
        }
    }

    /* renamed from: a */
    private void m19116a() throws Throwable {
        boolean z;
        boolean z2;
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g(f18352a, "sendInstantLogs ");
        }
        Cursor cursorM19124b = C5036a.m19124b(0);
        if (cursorM19124b != null) {
            if (cursorM19124b.getCount() < 1 || !cursorM19124b.moveToFirst()) {
                z = false;
            } else {
                z = false;
                do {
                    String string = cursorM19124b.getString(cursorM19124b.getColumnIndex("_id"));
                    long j = cursorM19124b.getLong(cursorM19124b.getColumnIndex("date"));
                    String string2 = cursorM19124b.getString(cursorM19124b.getColumnIndex("pageId"));
                    String string3 = cursorM19124b.getString(cursorM19124b.getColumnIndex("eventId"));
                    String strM19199a = C5052r.m19199a(C5038c.m19166o(), "¶", C5038c.m19143a(), "¶", C5038c.m19165n(), "¶", cursorM19124b.getString(cursorM19124b.getColumnIndex("metaInfo")));
                    if (C4996f.f18229a.f18172d) {
                        C4996f.f18229a.m18893g(f18352a, "sendInstantLogs() log " + string + "(Activity :: " + string2 + ":" + string3 + ") = " + strM19199a);
                    }
                    try {
                        IDlcService iDlcServiceM19154d = C5038c.m19154d();
                        if (iDlcServiceM19154d != null) {
                            int iRequestSend = iDlcServiceM19154d.requestSend("QOS", "006", j, string2 + ":" + string3, null, C5038c.m19164m(), "99.02.00", strM19199a);
                            if (C4996f.f18229a.f18172d) {
                                C4996f.f18229a.m18893g(f18352a, "sendInstantLogs mService.requestSend's ret = " + iRequestSend);
                            }
                            switch (iRequestSend) {
                                case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                                    C5038c.m19153c(false);
                                case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                                case -1:
                                default:
                                    z2 = true;
                                    break;
                                case 0:
                                    C5036a.m19123a(string);
                                    z2 = z;
                                    break;
                            }
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (z) {
                    }
                } while (cursorM19124b.moveToNext());
            }
            if (cursorM19124b != null) {
                cursorM19124b.close();
            }
            if (z) {
                C5038c.m19170s();
                C5036a.m19125b();
                try {
                    finalize();
                    return;
                } catch (Throwable th) {
                    if (C4996f.f18229a.f18172d) {
                        C4996f.f18229a.m18893g(f18352a, "sendInstantLogs() finalize Exception :: " + th.toString());
                        return;
                    }
                    return;
                }
            }
            m19117b();
        }
    }

    /* renamed from: b */
    private void m19117b() throws Throwable {
        boolean z;
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g(f18352a, "sendSummaryLogs ");
        }
        boolean z2 = false;
        Cursor cursorM19119a = C5036a.m19119a(0);
        if (cursorM19119a != null) {
            if (cursorM19119a.getCount() >= 1) {
                String strM19143a = C5038c.m19143a();
                String strM19166o = C5038c.m19166o();
                String strM19165n = C5038c.m19165n();
                String strM19164m = C5038c.m19164m();
                if (cursorM19119a.moveToFirst()) {
                    do {
                        String string = cursorM19119a.getString(cursorM19119a.getColumnIndex("_id"));
                        long j = cursorM19119a.getLong(cursorM19119a.getColumnIndex("date"));
                        String string2 = cursorM19119a.getString(cursorM19119a.getColumnIndex("pageId"));
                        String string3 = cursorM19119a.getString(cursorM19119a.getColumnIndex("eventId"));
                        String str = string2 + ":" + string3;
                        String strM19199a = C5052r.m19199a(strM19166o, "¶", strM19143a, "¶", strM19165n, cursorM19119a.getString(cursorM19119a.getColumnIndex("metaInfo")), "¶", Integer.valueOf(cursorM19119a.getInt(cursorM19119a.getColumnIndex(VKApiConst.COUNT))));
                        if (C4996f.f18229a.f18172d) {
                            C4996f.f18229a.m18893g(f18352a, "sendSummaryLogs() log " + string + "(Activity :: " + str + ") = " + strM19199a);
                        }
                        try {
                            IDlcService iDlcServiceM19154d = C5038c.m19154d();
                            if (iDlcServiceM19154d != null) {
                                int iRequestSend = iDlcServiceM19154d.requestSend("QOS", "006", j, str, null, strM19164m, "99.02.00", strM19199a);
                                if (C4996f.f18229a.f18172d) {
                                    C4996f.f18229a.m18893g(f18352a, "sendSummaryLogs mService.requestSend's ret = " + iRequestSend);
                                }
                                switch (iRequestSend) {
                                    case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                                        C5038c.m19153c(false);
                                    case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                                    case -1:
                                    default:
                                        z = true;
                                        break;
                                    case 0:
                                        C5036a.m19127b(string);
                                        z = z2;
                                        break;
                                }
                            } else {
                                z = z2;
                            }
                            z2 = z;
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        if (z2) {
                        }
                    } while (cursorM19119a.moveToNext());
                }
            }
            if (cursorM19119a != null) {
                cursorM19119a.close();
            }
            if (z2) {
                C5038c.m19170s();
                C5036a.m19125b();
                try {
                    finalize();
                } catch (Throwable th) {
                    if (C4996f.f18229a.f18172d) {
                        C4996f.f18229a.m18893g(f18352a, "sendSummaryLogs() finalize Exception :: " + th.toString());
                    }
                }
            }
            m19118c();
        }
    }

    /* renamed from: c */
    private void m19118c() throws Throwable {
        boolean z;
        IDlcService iDlcServiceM19154d;
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g(f18352a, "sendQOSLogMessage ");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM19143a = C5038c.m19143a();
        String strM19166o = C5038c.m19166o();
        String strM19165n = C5038c.m19165n();
        String strM19164m = C5038c.m19164m();
        String str = "2001:8100";
        String strM19199a = C5052r.m19199a(strM19166o, "¶", strM19143a, "¶", strM19165n, "¶", "¶", C5038c.m19162k(), "¶", C5038c.m19160i(), "¶", "¶", "¶", C5036a.m19130d());
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g(f18352a, "sendQOSLogMessage() log (Activity :: " + str + ") = " + strM19199a);
        }
        try {
            iDlcServiceM19154d = C5038c.m19154d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (iDlcServiceM19154d != null) {
            int iRequestSend = iDlcServiceM19154d.requestSend("QOS", "006", jCurrentTimeMillis, str, null, strM19164m, "99.02.00", strM19199a);
            if (C4996f.f18229a.f18172d) {
                C4996f.f18229a.m18893g(f18352a, "sendQOSLogMessage mService.requestSend's ret = " + iRequestSend);
            }
            switch (iRequestSend) {
                case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                    C5038c.m19153c(false);
                case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                case -1:
                default:
                    z = true;
                    break;
                case 0:
                    C5036a.m19128c();
                    z = false;
                    break;
            }
        } else {
            z = false;
        }
        if (z) {
            C5036a.m19128c();
        }
        C5038c.m19170s();
        try {
            finalize();
        } catch (Throwable th) {
            if (C4996f.f18229a.f18172d) {
                C4996f.f18229a.m18893g(f18352a, "sendQOSLogMessage() finalize Exception :: " + th.toString());
            }
        }
    }
}
