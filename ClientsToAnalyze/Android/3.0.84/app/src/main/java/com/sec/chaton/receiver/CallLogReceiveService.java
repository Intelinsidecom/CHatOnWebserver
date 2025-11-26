package com.sec.chaton.receiver;

import android.app.IntentService;
import android.content.Intent;
import com.coolots.sso.calllog.ChatONCallLogData;
import com.sec.chaton.calllog.manager.HandlerC0838a;
import com.sec.chaton.calllog.manager.model.CallLogDBData;
import com.sec.chaton.calllog.manager.noti.C0846a;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CallLogReceiveService extends IntentService {

    /* renamed from: a */
    private static final String f8060a = CallLogReceiveService.class.getSimpleName();

    public CallLogReceiveService() {
        super(f8060a);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        int iM4428b;
        boolean booleanExtra = intent.getBooleanExtra("calllog_type", false);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("calllog_data");
        if (parcelableArrayListExtra != null) {
            ArrayList<CallLogDBData> arrayList = new ArrayList<>();
            CallLogDBData callLogDBData = null;
            HandlerC0838a handlerC0838a = new HandlerC0838a();
            if (!booleanExtra) {
                iM4428b = -1;
            } else {
                iM4428b = handlerC0838a.m4428b() + 1;
            }
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                ChatONCallLogData chatONCallLogData = (ChatONCallLogData) it.next();
                chatONCallLogData.m70a(iM4428b);
                CallLogDBData callLogDBData2 = new CallLogDBData(chatONCallLogData);
                arrayList.add(callLogDBData2);
                callLogDBData = callLogDBData2.calllogtype == 2 ? callLogDBData2 : callLogDBData;
            }
            if (handlerC0838a.m4420a(arrayList) < 0) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("fail to insert data", f8060a);
                    return;
                }
                return;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("succeed to insert data", f8060a);
            }
            if (callLogDBData != null) {
                C0846a c0846aM4496a = C0846a.m4496a();
                if (callLogDBData.calllogtype == 2) {
                    c0846aM4496a.m4498a(callLogDBData.duration, callLogDBData.username);
                } else if (callLogDBData.calllogtype == 0 && callLogDBData.callmethod == 12) {
                    c0846aM4496a.m4499a(callLogDBData.duration, callLogDBData.username, callLogDBData.rejectmsg);
                }
            }
        }
    }
}
