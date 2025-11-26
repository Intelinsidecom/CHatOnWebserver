package com.sec.common.util.log.collector;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.RemoteException;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3364o;
import com.sec.spp.push.dlc.api.IDlcService;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class LogCollectorSender extends IntentService {

    /* renamed from: a */
    private static final String f12085a = LogCollectorSender.class.getSimpleName();

    /* renamed from: b */
    private IDlcService f12086b;

    /* renamed from: c */
    private boolean f12087c;

    /* renamed from: d */
    private boolean f12088d;

    /* renamed from: e */
    private String f12089e;

    /* renamed from: f */
    private ServiceConnection f12090f;

    public LogCollectorSender() {
        super(f12085a);
        this.f12086b = null;
        this.f12087c = false;
        this.f12088d = false;
        this.f12090f = new ServiceConnectionC3354d(this);
        this.f12089e = new SimpleDateFormat("yyyyMMdd").format(new Date(C3347i.m11774a()));
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (C3330f.f12033a.f11973c) {
            C3330f.f12033a.m11654b(f12085a, "onHandleIntent ");
        }
        this.f12087c = intent.getBooleanExtra("bUrgent", false);
        this.f12088d = intent.getBooleanExtra("bFlush", false);
        if (this.f12086b == null) {
            m11816a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11809a(IDlcService iDlcService) throws Throwable {
        if (C3330f.f12033a.f11973c) {
            C3330f.f12033a.m11654b(f12085a, "sendlogs ");
        }
        Cursor cursorM11817a = C3351a.m11817a(0);
        if (cursorM11817a.getCount() >= 1 && cursorM11817a.moveToFirst()) {
            do {
                String string = cursorM11817a.getString(cursorM11817a.getColumnIndex("_id"));
                String string2 = cursorM11817a.getString(cursorM11817a.getColumnIndex("category"));
                String string3 = cursorM11817a.getString(cursorM11817a.getColumnIndex("date"));
                String string4 = cursorM11817a.getString(cursorM11817a.getColumnIndex("page_id"));
                String strM11849a = C3364o.m11849a(string2, "\u0001", string3, "|", string4, "|", cursorM11817a.getString(cursorM11817a.getColumnIndex("action_id")), "|", cursorM11817a.getString(cursorM11817a.getColumnIndex("meta_info")), "|", Integer.valueOf(cursorM11817a.getInt(cursorM11817a.getColumnIndex("count"))));
                if (!string2.equals("QOS") || !string4.equals("01000001")) {
                    if (C3330f.f12033a.f11973c) {
                        C3330f.f12033a.m11654b(f12085a, "sendlogs() log " + string + " = " + strM11849a);
                    }
                    try {
                        if (!this.f12088d || string3.compareTo(this.f12089e) < 0) {
                            int iRequestSend = iDlcService.requestSend(string2, "006", C3347i.m11774a() / 1000, string4, null, strM11849a);
                            if (C3330f.f12033a.f11973c) {
                                C3330f.f12033a.m11654b(f12085a, "mService.requestSend's ret = " + iRequestSend);
                            }
                            if (iRequestSend == 0) {
                                C3351a.m11820a(string);
                            }
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            } while (cursorM11817a.moveToNext());
        }
        cursorM11817a.close();
        this.f12087c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11814b(IDlcService iDlcService) throws Throwable {
        if (C3330f.f12033a.f11973c) {
            C3330f.f12033a.m11654b(f12085a, "sendUrgentlogs ");
        }
        Cursor cursorM11817a = C3351a.m11817a(0);
        if (cursorM11817a.getCount() >= 1 && cursorM11817a.moveToFirst()) {
            do {
                String string = cursorM11817a.getString(cursorM11817a.getColumnIndex("_id"));
                String string2 = cursorM11817a.getString(cursorM11817a.getColumnIndex("category"));
                if (string2.equals("QOS")) {
                    String string3 = cursorM11817a.getString(cursorM11817a.getColumnIndex("date"));
                    String string4 = cursorM11817a.getString(cursorM11817a.getColumnIndex("page_id"));
                    String strM11849a = C3364o.m11849a(string2, "\u0001", string3, "|", string4, "|", cursorM11817a.getString(cursorM11817a.getColumnIndex("action_id")), "|", cursorM11817a.getString(cursorM11817a.getColumnIndex("meta_info")), "|", Integer.valueOf(cursorM11817a.getInt(cursorM11817a.getColumnIndex("count"))));
                    if (C3330f.f12033a.f11973c) {
                        C3330f.f12033a.m11654b(f12085a, "sendlogs() log " + string + " = " + strM11849a);
                    }
                    try {
                        int iRequestSendUrgent = iDlcService.requestSendUrgent(string2, "006", C3347i.m11774a() / 1000, string4, null, strM11849a);
                        if (C3330f.f12033a.f11973c) {
                            C3330f.f12033a.m11654b(f12085a, "mService.requestSend's ret = " + iRequestSendUrgent);
                        }
                        if (iRequestSendUrgent == 0) {
                            C3351a.m11820a(string);
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            } while (cursorM11817a.moveToNext());
        }
        cursorM11817a.close();
        this.f12087c = false;
    }

    /* renamed from: a */
    public void m11816a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.sec.spp.push", "com.sec.spp.push.dlc.writer.WriterService"));
        if (!CommonApplication.m11493l().bindService(intent, this.f12090f, 1) && C3330f.f12033a.f11973c) {
            C3330f.f12033a.m11654b("bind service failed", f12085a);
        }
    }
}
