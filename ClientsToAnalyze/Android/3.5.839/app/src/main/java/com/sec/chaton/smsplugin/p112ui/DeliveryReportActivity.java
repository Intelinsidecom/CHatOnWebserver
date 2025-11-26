package com.sec.chaton.smsplugin.p112ui;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class DeliveryReportActivity extends ListActivity {

    /* renamed from: a */
    static final String[] f14769a = {"address", "d_rpt", "rr"};

    /* renamed from: b */
    static final String[] f14770b = {"address", "delivery_status", "read_status"};

    /* renamed from: c */
    static final String[] f14771c = {"address", "status"};

    /* renamed from: d */
    private long f14772d;

    /* renamed from: e */
    private String f14773e;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.delivery_report_activity);
        Intent intent = getIntent();
        this.f14772d = m15755a(bundle, intent);
        this.f14773e = m15760b(bundle, intent);
        m15759a();
        m15761b();
    }

    /* renamed from: a */
    private void m15759a() {
        getLayoutInflater();
    }

    /* renamed from: b */
    private void m15761b() {
        List<C4355v> listM15763d = m15763d();
        if (listM15763d == null) {
            listM15763d = new ArrayList<>(1);
            listM15763d.add(new C4355v("", getString(R.string.status_none)));
            C3890m.m14997c("DeliveryReportActivity", "cursor == null");
        }
        setListAdapter(new C4354u(this, listM15763d));
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        m15762c();
    }

    /* renamed from: c */
    private void m15762c() {
        ListView listView = getListView();
        listView.invalidateViews();
        listView.requestFocus();
    }

    /* renamed from: a */
    private long m15755a(Bundle bundle, Intent intent) {
        long j = bundle != null ? bundle.getLong("message_id") : 0L;
        if (j == 0) {
            return intent.getLongExtra("message_id", 0L);
        }
        return j;
    }

    /* renamed from: b */
    private String m15760b(Bundle bundle, Intent intent) {
        String string = null;
        if (bundle != null) {
            string = bundle.getString("message_type");
        }
        if (string == null) {
            return intent.getStringExtra("message_type");
        }
        return string;
    }

    /* renamed from: d */
    private List<C4355v> m15763d() {
        return this.f14773e.equals("sms") ? m15764e() : m15765f();
    }

    /* renamed from: e */
    private List<C4355v> m15764e() {
        ArrayList arrayList = null;
        Cursor cursorQuery = SqliteWrapper.query(this, getContentResolver(), Telephony.Sms.CONTENT_URI, f14771c, "_id = " + this.f14772d, (String[]) null, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new C4355v(getString(R.string.recipient_label) + cursorQuery.getString(0), getString(R.string.status_label) + m15757a(cursorQuery.getInt(1))));
                    }
                }
            } finally {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private String m15758a(C4352s c4352s, Map<String, C4353t> map) {
        if (map == null) {
            return getString(R.string.status_pending);
        }
        String strM16528a = c4352s.m16528a();
        C4353t c4353tM15756a = m15756a(map, Telephony.Mms.isEmailAddress(strM16528a) ? Telephony.Mms.extractAddrSpec(strM16528a) : PhoneNumberUtils.stripSeparators(strM16528a));
        if (c4353tM15756a == null) {
            return getString(R.string.status_pending);
        }
        if (c4352s.m16529b() && c4353tM15756a.f15792b != 0) {
            switch (c4353tM15756a.f15792b) {
            }
            return getString(R.string.status_pending);
        }
        switch (c4353tM15756a.f15791a) {
            case 0:
                break;
            case 129:
            case 134:
                break;
            case 130:
                break;
        }
        return getString(R.string.status_pending);
    }

    /* renamed from: a */
    private static C4353t m15756a(Map<String, C4353t> map, String str) {
        for (String str2 : map.keySet()) {
            if (Telephony.Mms.isEmailAddress(str)) {
                if (TextUtils.equals(str2, str)) {
                    return map.get(str2);
                }
            } else if (PhoneNumberUtils.compare(str2, str)) {
                return map.get(str2);
            }
        }
        return null;
    }

    /* renamed from: f */
    private List<C4355v> m15765f() {
        List<C4352s> listM15767h = m15767h();
        if (listM15767h == null || listM15767h.size() == 0) {
            return null;
        }
        Map<String, C4353t> mapM15766g = m15766g();
        ArrayList arrayList = new ArrayList();
        for (C4352s c4352s : listM15767h) {
            arrayList.add(new C4355v(getString(R.string.recipient_label) + c4352s.m16528a(), getString(R.string.status_label) + m15758a(c4352s, mapM15766g)));
        }
        return arrayList;
    }

    /* renamed from: g */
    private Map<String, C4353t> m15766g() {
        HashMap map = null;
        Cursor cursorQuery = SqliteWrapper.query(this, getContentResolver(), Uri.withAppendedPath(Telephony.Mms.REPORT_STATUS_URI, String.valueOf(this.f14772d)), f14770b, (String) null, (String[]) null, (String) null);
        if (cursorQuery != null) {
            try {
                map = new HashMap();
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    map.put(Telephony.Mms.isEmailAddress(string) ? Telephony.Mms.extractAddrSpec(string) : PhoneNumberUtils.stripSeparators(string), new C4353t(cursorQuery.getInt(1), cursorQuery.getInt(2)));
                }
            } finally {
                cursorQuery.close();
            }
        }
        return map;
    }

    /* renamed from: h */
    private List<C4352s> m15767h() {
        ArrayList arrayList = null;
        Cursor cursorQuery = SqliteWrapper.query(this, getContentResolver(), Uri.withAppendedPath(Telephony.Mms.REPORT_REQUEST_URI, String.valueOf(this.f14772d)), f14769a, (String) null, (String[]) null, (String) null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new C4352s(cursorQuery.getString(0), cursorQuery.getInt(1), cursorQuery.getInt(2)));
                    }
                }
            } finally {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private String m15757a(int i) {
        if (i == -1) {
            return getString(R.string.status_none);
        }
        if (i >= 64) {
            return getString(R.string.status_failed);
        }
        if (i >= 32) {
            return getString(R.string.status_pending);
        }
        return getString(R.string.status_received);
    }
}
