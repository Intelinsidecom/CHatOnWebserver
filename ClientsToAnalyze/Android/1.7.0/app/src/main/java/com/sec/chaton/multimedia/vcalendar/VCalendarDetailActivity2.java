package com.sec.chaton.multimedia.vcalendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class VCalendarDetailActivity2 extends Activity {

    /* renamed from: a */
    public static final String f2751a = VCalendarListFragment.class.getSimpleName();

    /* renamed from: c */
    private String f2753c;

    /* renamed from: d */
    private String f2754d;

    /* renamed from: e */
    private String f2755e;

    /* renamed from: f */
    private Long f2756f;

    /* renamed from: g */
    private Long f2757g;

    /* renamed from: h */
    private String f2758h;

    /* renamed from: i */
    private String f2759i;

    /* renamed from: j */
    private int f2760j;

    /* renamed from: k */
    private C0812b f2761k;

    /* renamed from: l */
    private C0811a f2762l;

    /* renamed from: m */
    private Context f2763m;

    /* renamed from: n */
    private ProgressDialog f2764n;

    /* renamed from: p */
    private BroadcastReceiver f2766p;

    /* renamed from: q */
    private boolean f2767q;

    /* renamed from: r */
    private GeneralHeaderView f2768r;

    /* renamed from: o */
    private final int f2765o = 0;

    /* renamed from: b */
    View.OnClickListener f2752b = new ViewOnClickListenerC0815e(this);

    /* renamed from: s */
    private Runnable f2769s = new RunnableC0814d(this);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f2767q = true;
        }
        setContentView(R.layout.layout_multimedia_vcalendar_detail2);
    }

    @Override // android.app.Activity
    public void onResume() {
        Date date;
        Date date2;
        super.onResume();
        m3311c();
        this.f2763m = this;
        this.f2760j = getIntent().getIntExtra("ACTIVITY_PURPOSE", 1);
        this.f2768r = (GeneralHeaderView) findViewById(R.id.headerView);
        this.f2768r.setButtonClickListener(this.f2752b);
        if (this.f2760j == 1) {
            if (this.f2767q) {
                C1619g.m5888a(getBaseContext(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                finish();
                return;
            }
            this.f2753c = getIntent().getStringExtra("inbox_NO");
            this.f2755e = getIntent().getStringExtra("extra summary");
            this.f2756f = Long.valueOf(getIntent().getLongExtra("extra dtstart", 0L));
            this.f2757g = Long.valueOf(getIntent().getLongExtra("extra dtend", 0L));
            this.f2758h = getIntent().getStringExtra("extra location");
            this.f2759i = getIntent().getStringExtra("extra desc");
            this.f2768r.setButtonImageResource(R.drawable.general_btn_icon_send_xml);
        } else if (this.f2760j == 2 || this.f2760j == 3) {
            if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("URI")) {
                this.f2754d = getIntent().getExtras().getString("URI");
            }
            try {
                m3307a((Context) this);
                this.f2762l = (C0811a) this.f2761k.f2800a.get(0);
                if (this.f2762l == null) {
                    finish();
                    return;
                }
                this.f2755e = this.f2762l.f2795i;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
                if (this.f2762l.f2789c != null) {
                    try {
                        date = simpleDateFormat.parse(this.f2762l.f2789c.substring(0, this.f2762l.f2789c.length() - 1));
                    } catch (Exception e) {
                        try {
                            date = new SimpleDateFormat("yyyyMMdd").parse(this.f2762l.f2789c);
                        } catch (ParseException e2) {
                            e2.printStackTrace();
                            date = null;
                        }
                    }
                    if (date != null) {
                        this.f2756f = Long.valueOf(date.getTime());
                    } else {
                        this.f2756f = null;
                    }
                }
                if (this.f2762l.f2788b != null) {
                    try {
                        date2 = simpleDateFormat.parse(this.f2762l.f2788b.substring(0, this.f2762l.f2788b.length() - 1));
                    } catch (Exception e3) {
                        try {
                            date2 = new SimpleDateFormat("yyyyMMdd").parse(this.f2762l.f2788b);
                        } catch (ParseException e4) {
                            e4.printStackTrace();
                            date2 = null;
                        }
                    }
                    if (date2 != null) {
                        this.f2757g = Long.valueOf(date2.getTime());
                    } else {
                        this.f2757g = null;
                    }
                }
                this.f2758h = this.f2762l.f2796j;
                this.f2759i = this.f2762l.f2787a;
            } catch (Exception e5) {
                C1619g.m5889a(this, getString(R.string.vcalendar_parsing_error), 1).show();
                finish();
                e5.printStackTrace();
                return;
            }
        }
        if (this.f2755e == null || this.f2755e.length() == 0) {
            this.f2755e = "No title";
        }
        if (this.f2758h == null) {
            this.f2758h = "";
        }
        if (this.f2759i == null) {
            this.f2759i = "";
        }
        if (this.f2756f == null || this.f2757g == null) {
            C1619g.m5889a(this, getString(R.string.vcalendar_parsing_error), 1).show();
            finish();
            return;
        }
        ((TextView) findViewById(R.id.vcalendar_event_detail_title)).setText(this.f2755e);
        Date date3 = new Date(this.f2756f.longValue());
        Date date4 = new Date(this.f2757g.longValue());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEEE ", GlobalApplication.m3106g().getConfiguration().locale);
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(GlobalApplication.m3100a());
        SimpleDateFormat simpleDateFormat3 = android.text.format.DateFormat.is24HourFormat(this.f2763m) ? new SimpleDateFormat(" HH:mm", GlobalApplication.m3106g().getConfiguration().locale) : new SimpleDateFormat(" hh:mma", GlobalApplication.m3106g().getConfiguration().locale);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(this.f2756f.longValue()));
        ((TextView) findViewById(R.id.vcalendar_event_detail_date_from)).setText(simpleDateFormat2.format(date3) + dateFormat.format(date3) + simpleDateFormat3.format(date3));
        calendar.setTime(new Date(this.f2757g.longValue()));
        ((TextView) findViewById(R.id.vcalendar_event_detail_date_to)).setText("- " + simpleDateFormat2.format(date4) + dateFormat.format(date4) + simpleDateFormat3.format(date4));
        TextView textView = (TextView) findViewById(R.id.vcalendar_event_detail_location);
        if (this.f2758h == null || this.f2758h.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f2758h);
        }
        TextView textView2 = (TextView) findViewById(R.id.vcalendar_event_detail_description);
        if (TextUtils.isEmpty(this.f2759i)) {
            ((LinearLayout) findViewById(R.id.vcalendar_event_detail_desc_area)).setVisibility(8);
        } else {
            textView2.setText(this.f2759i);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        m3315e();
        super.onPause();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3322a(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r5 = 0
            r1 = 0
            boolean r0 = com.sec.chaton.util.C1327bw.m4595a()
            if (r0 == 0) goto Lb4
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3100a()
            java.io.File r0 = r0.getExternalFilesDir(r1)
            if (r0 == 0) goto Lb4
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3100a()
            java.io.File r0 = r0.getExternalFilesDir(r1)
            java.lang.String r0 = r0.getAbsolutePath()
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = "/"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r7.f2753c
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L45
            r2.mkdir()
        L45:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = r7.f2753c
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = com.sec.chaton.util.C1302ay.m4546a()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = ".VCS"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = r0.toString()
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lc6 java.io.FileNotFoundException -> Lcd java.io.IOException -> Ld7
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lc6 java.io.FileNotFoundException -> Lcd java.io.IOException -> Ld7
            byte[] r1 = r8.getBytes()     // Catch: java.lang.Throwable -> Le1 java.io.IOException -> Le6 java.io.FileNotFoundException -> Le8
            r0.write(r1)     // Catch: java.lang.Throwable -> Le1 java.io.IOException -> Le6 java.io.FileNotFoundException -> Le8
            if (r0 == 0) goto L83
            r0.close()     // Catch: java.io.IOException -> Ld5
        L83:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L96
            r7.m3322a(r8)
        L96:
            if (r2 == 0) goto L9d
            java.lang.String r1 = "extra fileuri"
            r0.putExtra(r1, r2)
        L9d:
            java.lang.String r1 = "extra vcalendar"
            java.lang.String r2 = r7.f2755e
            r0.putExtra(r1, r2)
            r1 = -1
            r7.setResult(r1, r0)
            android.app.ProgressDialog r0 = r7.f2764n
            r0.dismiss()
            r7.removeDialog(r5)
            r7.finish()
        Lb3:
            return
        Lb4:
            android.content.Context r0 = r7.getBaseContext()
            r1 = 2131558527(0x7f0d007f, float:1.8742372E38)
            android.widget.Toast r0 = com.sec.widget.C1619g.m5888a(r0, r1, r5)
            r0.show()
            r7.finish()
            goto Lb3
        Lc6:
            r0 = move-exception
        Lc7:
            if (r1 == 0) goto Lcc
            r1.close()     // Catch: java.io.IOException -> Ldf
        Lcc:
            throw r0
        Lcd:
            r0 = move-exception
            r0 = r1
        Lcf:
            if (r0 == 0) goto L83
            r0.close()     // Catch: java.io.IOException -> Ld5
            goto L83
        Ld5:
            r0 = move-exception
            goto L83
        Ld7:
            r0 = move-exception
            r0 = r1
        Ld9:
            if (r0 == 0) goto L83
            r0.close()     // Catch: java.io.IOException -> Ld5
            goto L83
        Ldf:
            r1 = move-exception
            goto Lcc
        Le1:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto Lc7
        Le6:
            r1 = move-exception
            goto Ld9
        Le8:
            r1 = move-exception
            goto Lcf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2.m3322a(java.lang.String):void");
    }

    /* renamed from: a */
    private void m3307a(Context context) throws IOException {
        C0823m c0823m = new C0823m();
        String str = null;
        if (this.f2754d != null) {
            String[] strArrSplit = this.f2754d.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f2754d;
            } else if (strArrSplit.length == 2) {
                str = strArrSplit[1];
            } else {
                finish();
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line + "\n");
            } else {
                bufferedReader.close();
                this.f2761k = c0823m.m3353a(sb.toString());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3306a() {
        String str;
        if (Build.VERSION.SDK_INT < 8) {
            str = "calendar";
        } else {
            str = "com.android.calendar";
        }
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        int iM3308b = m3308b();
        if (iM3308b > 0) {
            contentValues.put("calendar_id", Integer.valueOf(iM3308b));
            contentValues.put("title", this.f2755e);
            contentValues.put("description", this.f2759i);
            contentValues.put("eventLocation", this.f2758h);
            contentValues.put("dtstart", this.f2756f);
            contentValues.put("dtend", this.f2757g);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(this.f2756f.longValue()));
            contentValues.put("eventTimezone", calendar.getTimeZone().getID());
            C1341p.m4658b("******* SAVE EVENTS : " + contentValues.toString(), null);
            contentResolver.insert(Uri.parse("content://" + str + "/events"), contentValues);
            C1619g.m5889a(this.f2763m, getResources().getString(R.string.read_vcalendar_save_toast_success), 0).show();
        } else {
            C1619g.m5889a(this.f2763m, getResources().getString(R.string.buddy_profile_calendar_toast_notfound), 1).show();
        }
        finish();
    }

    /* renamed from: b */
    private int m3308b() {
        String[] strArr = {"_id", "name"};
        String str = "selected=1";
        if (Build.VERSION.SDK_INT >= 14) {
            str = null;
        }
        Cursor cursorM3303a = m3303a(strArr, str, "calendars");
        if (cursorM3303a != null && cursorM3303a.moveToFirst()) {
            int columnIndex = cursorM3303a.getColumnIndex("name");
            int columnIndex2 = cursorM3303a.getColumnIndex("_id");
            do {
                cursorM3303a.getString(columnIndex);
                String string = cursorM3303a.getString(columnIndex2);
                if (string != null) {
                    return Integer.parseInt(string);
                }
            } while (cursorM3303a.moveToNext());
        }
        return 0;
    }

    /* renamed from: a */
    private Cursor m3303a(String[] strArr, String str, String str2) {
        Cursor cursorManagedQuery = null;
        try {
            cursorManagedQuery = managedQuery(Uri.parse("content://calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e) {
        }
        if (cursorManagedQuery != null) {
            return cursorManagedQuery;
        }
        try {
            return managedQuery(Uri.parse("content://com.android.calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e2) {
            return cursorManagedQuery;
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f2764n = new ProgressDialogC1354a(this);
                this.f2764n.setProgressStyle(0);
                this.f2764n.setMessage(getString(R.string.wait_sending));
                return this.f2764n;
            default:
                return null;
        }
    }

    /* renamed from: c */
    private void m3311c() {
        this.f2766p = new C0813c(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f2766p, intentFilter);
        m3313d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3313d() {
        if (!C1327bw.m4595a()) {
            C1619g.m5888a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: e */
    private void m3315e() {
        unregisterReceiver(this.f2766p);
    }
}
