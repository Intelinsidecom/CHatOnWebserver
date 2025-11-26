package com.sec.chaton.receiver;

import android.app.IntentService;
import android.content.Intent;
import com.coolots.sso.calllog.ChatONCallLogData;
import com.sec.chaton.calllog.manager.HandlerC1449a;
import com.sec.chaton.calllog.manager.model.CallLogDBData;
import com.sec.chaton.calllog.manager.noti.C1457a;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CallLogReceiveService extends IntentService {

    /* renamed from: a */
    private static final String f11512a = CallLogReceiveService.class.getSimpleName();

    public CallLogReceiveService() {
        super(f11512a);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        int iM7582b;
        boolean booleanExtra = intent.getBooleanExtra("calllog_type", false);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("calllog_data");
        if (parcelableArrayListExtra != null) {
            ArrayList<CallLogDBData> arrayList = new ArrayList<>();
            CallLogDBData callLogDBData = null;
            HandlerC1449a handlerC1449a = new HandlerC1449a();
            if (!booleanExtra) {
                iM7582b = -1;
            } else {
                iM7582b = handlerC1449a.m7582b() + 1;
            }
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                ChatONCallLogData chatONCallLogData = (ChatONCallLogData) it.next();
                chatONCallLogData.m1513a(iM7582b);
                CallLogDBData callLogDBData2 = new CallLogDBData(chatONCallLogData);
                arrayList.add(callLogDBData2);
                callLogDBData = callLogDBData2.calllogtype == 2 ? callLogDBData2 : callLogDBData;
            }
            if (handlerC1449a.m7574a(arrayList) < 0) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("fail to insert data", f11512a);
                    return;
                }
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("succeed to insert data", f11512a);
            }
            if (callLogDBData != null) {
                C1457a c1457aM7650a = C1457a.m7650a();
                if (callLogDBData.calllogtype == 2) {
                    c1457aM7650a.m7653a(callLogDBData.calldate, callLogDBData.username);
                }
            }
        }
    }
}
