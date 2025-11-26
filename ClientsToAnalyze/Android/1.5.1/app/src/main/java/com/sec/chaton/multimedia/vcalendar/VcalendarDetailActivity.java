package com.sec.chaton.multimedia.vcalendar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.TimeAdapter;
import java.util.Date;

/* loaded from: classes.dex */
public class VcalendarDetailActivity extends BaseActivity {

    /* renamed from: d */
    private static String f2249d;

    /* renamed from: a */
    protected VCalendarStruct f2250a;

    /* renamed from: b */
    protected int f2251b;

    /* renamed from: c */
    ProgressDialog f2252c;

    /* renamed from: e */
    private String f2253e;

    /* renamed from: g */
    private String f2255g;

    /* renamed from: h */
    private String f2256h;

    /* renamed from: i */
    private String f2257i;

    /* renamed from: j */
    private String f2258j;

    /* renamed from: f */
    private final int f2254f = 0;

    /* renamed from: k */
    private Runnable f2259k = new RunnableC0313e(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2603a() throws Throwable {
        try {
            this.f2253e = new VCalComposer().m2558a(this.f2250a, 2);
        } catch (VCalException e) {
            e.printStackTrace();
        }
        if (this.f2253e != null) {
            m2606a(this.f2253e);
        } else {
            this.f2251b = C0062R.string.toast_make_failed;
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2606a(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcalendar.VcalendarDetailActivity.m2606a(java.lang.String):void");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("extra summary");
        String stringExtra2 = getIntent().getStringExtra("extra dtstart");
        String stringExtra3 = getIntent().getStringExtra("extra dtend") != null ? getIntent().getStringExtra("extra dtend") : stringExtra2;
        String stringExtra4 = getIntent().getStringExtra("extra location");
        String stringExtra5 = getIntent().getStringExtra("extra desc");
        Date date = new Date(Long.parseLong(stringExtra2));
        this.f2256h = TimeAdapter.m3681a(date, "MM/dd hh:mmaa");
        try {
            date = new Date(Long.parseLong(stringExtra3));
        } catch (Exception e) {
        }
        this.f2257i = TimeAdapter.m3681a(date, "MM/dd hh:mmaa");
        this.f2258j = getIntent().getStringExtra("inbox_NO");
        ChatONLogWriter.m3506b("mInBoxNo=" + this.f2258j, getClass().getSimpleName());
        ChatONLogWriter.m3506b("SUMMARY=" + stringExtra, getClass().getSimpleName());
        ChatONLogWriter.m3506b("DTSTART=" + this.f2256h, getClass().getSimpleName());
        ChatONLogWriter.m3506b("DTEND=" + this.f2257i, getClass().getSimpleName());
        ChatONLogWriter.m3506b("LOCATION=" + stringExtra4, getClass().getSimpleName());
        ChatONLogWriter.m3506b("DESC=" + stringExtra5, getClass().getSimpleName());
        setContentView(C0062R.layout.layout_multimedia_vcalendar_detail);
        ((TextView) findViewById(C0062R.id.calendar_title_id)).setText(stringExtra);
        ((TextView) findViewById(C0062R.id.calendar_dtstart_id)).setText(this.f2256h);
        ((TextView) findViewById(C0062R.id.calendar_dtend_id)).setText("~ " + this.f2257i);
        ((TextView) findViewById(C0062R.id.calendar_location_title_id)).setText(stringExtra4);
        ((TextView) findViewById(C0062R.id.calendar_desc_id)).setText(stringExtra5);
        ((Button) findViewById(C0062R.id.vcalendar_btn_cancel)).setOnClickListener(new ViewOnClickListenerC0311c(this));
        ((Button) findViewById(C0062R.id.vcalendar_btn_send)).setOnClickListener(new ViewOnClickListenerC0312d(this, stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5));
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f2252c = new ProgressDialog(this);
                this.f2252c.setProgressStyle(0);
                this.f2252c.setMessage(getString(C0062R.string.wait_sending));
                return this.f2252c;
            default:
                return null;
        }
    }
}
