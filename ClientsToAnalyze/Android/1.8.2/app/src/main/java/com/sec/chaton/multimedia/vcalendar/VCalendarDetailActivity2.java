package com.sec.chaton.multimedia.vcalendar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.C2153y;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class VCalendarDetailActivity2 extends Activity {

    /* renamed from: a */
    public static final String f3717a = VCalendarListFragment.class.getSimpleName();

    /* renamed from: b */
    long f3718b;

    /* renamed from: c */
    long f3719c;

    /* renamed from: d */
    private String f3720d;

    /* renamed from: e */
    private String f3721e;

    /* renamed from: f */
    private String f3722f;

    /* renamed from: g */
    private Long f3723g;

    /* renamed from: h */
    private Long f3724h;

    /* renamed from: i */
    private String f3725i;

    /* renamed from: j */
    private String f3726j;

    /* renamed from: k */
    private int f3727k;

    /* renamed from: l */
    private C1029i f3728l;

    /* renamed from: m */
    private C1030j f3729m;

    /* renamed from: n */
    private String f3730n;

    /* renamed from: o */
    private Context f3731o;

    /* renamed from: p */
    private ImageView f3732p;

    /* renamed from: q */
    private ProgressDialog f3733q;

    /* renamed from: r */
    private final int f3734r = 0;

    /* renamed from: s */
    private Runnable f3735s = new RunnableC1024d(this);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_multimedia_vcalendar_detail2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.vcalendar_event_menubar);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
            linearLayout.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        setTitle(R.string.media_calendar);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu_send_save_cancel, menu);
        if (this.f3727k == 1) {
            menu.removeItem(R.id.menu_save);
        } else {
            menu.removeItem(R.id.menu_send);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws ClassNotFoundException {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_cancel /* 2131494116 */:
                Intent intent = new Intent();
                intent.putExtra("extra vcalendar", this.f3722f);
                setResult(0, intent);
                finish();
                break;
            case R.id.menu_send /* 2131494119 */:
                C1030j c1030j = new C1030j();
                c1030j.f3781i = this.f3722f;
                c1030j.f3775c = String.valueOf(this.f3723g);
                c1030j.f3774b = String.valueOf(this.f3724h);
                c1030j.f3782j = this.f3725i;
                c1030j.f3773a = this.f3726j;
                c1030j.f3784l = this.f3730n;
                this.f3728l = new C1029i();
                this.f3728l.m3993a(c1030j);
                showDialog(0);
                new Thread((ThreadGroup) null, this.f3735s).start();
                break;
            case R.id.menu_save /* 2131494126 */:
                m3965b();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onResume() {
        Date date;
        Date date2;
        boolean z;
        Date date3;
        Date date4;
        boolean z2;
        boolean z3;
        super.onResume();
        this.f3731o = this;
        this.f3727k = getIntent().getIntExtra("ACTIVITY_PURPOSE", 1);
        if (this.f3727k == 1) {
            this.f3720d = getIntent().getStringExtra("inbox_NO");
            this.f3722f = getIntent().getStringExtra("extra summary");
            this.f3723g = Long.valueOf(getIntent().getLongExtra("extra dtstart", 0L));
            this.f3724h = Long.valueOf(getIntent().getLongExtra("extra dtend", 0L));
            this.f3725i = getIntent().getStringExtra("extra location");
            this.f3726j = getIntent().getStringExtra("extra desc");
            this.f3730n = getIntent().getStringExtra("extra timezone");
            z2 = true;
            z3 = true;
        } else if (this.f3727k == 2 || this.f3727k == 3) {
            if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("URI")) {
                this.f3721e = getIntent().getExtras().getString("URI");
            }
            try {
                m3963a((Context) this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f3729m = (C1030j) this.f3728l.f3772a.get(0);
            this.f3722f = this.f3729m.f3781i;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
            if (this.f3729m.f3775c != null) {
                try {
                    date = simpleDateFormat.parse(this.f3729m.f3775c.substring(0, this.f3729m.f3775c.length() - 1));
                } catch (Exception e2) {
                    date = null;
                }
                if (date == null) {
                    try {
                        date2 = simpleDateFormat.parse(this.f3729m.f3775c.substring(0, this.f3729m.f3775c.length()) + "T000000");
                        z = false;
                    } catch (Exception e3) {
                        date2 = date;
                        z = true;
                    }
                } else {
                    date2 = date;
                    z = true;
                }
                if (date2 != null) {
                    this.f3723g = Long.valueOf(date2.getTime());
                } else {
                    this.f3723g = null;
                }
            } else {
                z = true;
            }
            if (this.f3729m.f3774b != null) {
                try {
                    date3 = simpleDateFormat.parse(this.f3729m.f3774b.substring(0, this.f3729m.f3774b.length() - 1));
                } catch (Exception e4) {
                    date3 = null;
                }
                if (date3 == null) {
                    try {
                        z2 = false;
                        date4 = simpleDateFormat.parse(this.f3729m.f3774b.substring(0, this.f3729m.f3774b.length()) + "T000000");
                    } catch (Exception e5) {
                        date4 = date3;
                        z2 = true;
                    }
                } else {
                    date4 = date3;
                    z2 = true;
                }
                if (date4 != null) {
                    this.f3724h = Long.valueOf(date4.getTime());
                } else {
                    this.f3724h = null;
                }
            } else {
                z2 = true;
            }
            this.f3725i = this.f3729m.f3782j;
            this.f3726j = this.f3729m.f3773a;
            this.f3730n = this.f3729m.f3784l;
            z3 = z;
        } else {
            z2 = true;
            z3 = true;
        }
        if (this.f3722f == null || this.f3722f.length() == 0) {
            this.f3722f = "No title";
        }
        if (this.f3725i == null) {
            this.f3725i = "";
        }
        if (this.f3726j == null) {
            this.f3726j = "";
        }
        if (this.f3730n == null) {
            this.f3730n = "";
        }
        if (this.f3723g == null || this.f3724h == null) {
            Toast.makeText(this, getString(R.string.vcalendar_parsing_error), 1).show();
            finish();
            return;
        }
        ((TextView) findViewById(R.id.vcalendar_event_detail_title)).setText(this.f3722f);
        TimeZone timeZone = TimeZone.getDefault();
        this.f3718b = timeZone.getRawOffset();
        this.f3719c = this.f3718b;
        long dSTSavings = timeZone.getDSTSavings();
        if (dSTSavings != 0) {
            if (true == timeZone.inDaylightTime(new Date(this.f3723g.longValue()))) {
                this.f3718b += dSTSavings;
            }
            if (true == timeZone.inDaylightTime(new Date(this.f3724h.longValue()))) {
                this.f3719c += dSTSavings;
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(this.f3723g.longValue()));
        TextView textView = (TextView) findViewById(R.id.vcalendar_event_detail_date_from);
        if (z3) {
            textView.setText(new SimpleDateFormat("EEEE dd/MM/yyyy hh:mma", GlobalApplication.m3262c().getConfiguration().locale).format(new Date(this.f3723g.longValue() + this.f3718b)));
        } else {
            textView.setText(new SimpleDateFormat("EEEE dd/MM/yyyy hh:mma", GlobalApplication.m3262c().getConfiguration().locale).format(new Date(this.f3723g.longValue())));
        }
        calendar.setTime(new Date(this.f3724h.longValue()));
        TextView textView2 = (TextView) findViewById(R.id.vcalendar_event_detail_date_to);
        if (z2) {
            textView2.setText("- " + new SimpleDateFormat("EEEE dd/MM/yyyy hh:mma", GlobalApplication.m3262c().getConfiguration().locale).format(new Date(this.f3724h.longValue() + this.f3719c)));
        } else {
            textView2.setText("- " + new SimpleDateFormat("EEEE dd/MM/yyyy hh:mma", GlobalApplication.m3262c().getConfiguration().locale).format(new Date(this.f3724h.longValue())));
        }
        TextView textView3 = (TextView) findViewById(R.id.vcalendar_event_detail_location);
        this.f3732p = (ImageView) findViewById(R.id.vcalendar_event_detail_map);
        if (this.f3725i == null || this.f3725i.length() == 0) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(this.f3725i);
        }
        this.f3732p.setVisibility(8);
        TextView textView4 = (TextView) findViewById(R.id.vcalendar_event_detail_description);
        if (TextUtils.isEmpty(this.f3726j)) {
            ((LinearLayout) findViewById(R.id.vcalendar_event_detail_desc_area)).setVisibility(8);
        } else {
            textView4.setText(this.f3726j);
        }
        m3962a();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    /* renamed from: a */
    private void m3962a() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3967a(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r1 = 0
            boolean r0 = com.sec.chaton.util.C1767bw.m6002a()
            if (r0 == 0) goto Laa
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3260b()
            java.io.File r0 = r0.getExternalFilesDir(r1)
            java.lang.String r0 = r0.getAbsolutePath()
        L13:
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = "/"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r6.f3720d
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L3a
            r2.mkdir()
        L3a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = r6.f3720d
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = com.sec.chaton.util.C1769by.m6005a()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = ".VCS"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = r0.toString()
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lb8 java.io.FileNotFoundException -> Lbf java.io.IOException -> Lc9
            r0.<init>(r2)     // Catch: java.lang.Throwable -> Lb8 java.io.FileNotFoundException -> Lbf java.io.IOException -> Lc9
            byte[] r1 = r7.getBytes()     // Catch: java.lang.Throwable -> Ld3 java.io.IOException -> Ld8 java.io.FileNotFoundException -> Lda
            r0.write(r1)     // Catch: java.lang.Throwable -> Ld3 java.io.IOException -> Ld8 java.io.FileNotFoundException -> Lda
            if (r0 == 0) goto L78
            r0.close()     // Catch: java.io.IOException -> Lc7
        L78:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L8b
            r6.m3967a(r7)
        L8b:
            if (r2 == 0) goto L92
            java.lang.String r1 = "extra fileuri"
            r0.putExtra(r1, r2)
        L92:
            java.lang.String r1 = "extra vcalendar"
            java.lang.String r2 = r6.f3722f
            r0.putExtra(r1, r2)
            r1 = -1
            r6.setResult(r1, r0)
            android.app.ProgressDialog r0 = r6.f3733q
            r0.dismiss()
            r0 = 0
            r6.removeDialog(r0)
            r6.finish()
            return
        Laa:
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3260b()
            java.io.File r0 = r0.getFilesDir()
            java.lang.String r0 = r0.getAbsolutePath()
            goto L13
        Lb8:
            r0 = move-exception
        Lb9:
            if (r1 == 0) goto Lbe
            r1.close()     // Catch: java.io.IOException -> Ld1
        Lbe:
            throw r0
        Lbf:
            r0 = move-exception
            r0 = r1
        Lc1:
            if (r0 == 0) goto L78
            r0.close()     // Catch: java.io.IOException -> Lc7
            goto L78
        Lc7:
            r0 = move-exception
            goto L78
        Lc9:
            r0 = move-exception
            r0 = r1
        Lcb:
            if (r0 == 0) goto L78
            r0.close()     // Catch: java.io.IOException -> Lc7
            goto L78
        Ld1:
            r1 = move-exception
            goto Lbe
        Ld3:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto Lb9
        Ld8:
            r1 = move-exception
            goto Lcb
        Lda:
            r1 = move-exception
            goto Lc1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2.m3967a(java.lang.String):void");
    }

    /* renamed from: a */
    private void m3963a(Context context) throws IOException {
        C1023c c1023c = new C1023c();
        String str = null;
        if (this.f3721e != null) {
            String[] strArrSplit = this.f3721e.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f3721e;
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
                this.f3728l = c1023c.m3983a(sb.toString());
                return;
            }
        }
    }

    /* renamed from: b */
    private void m3965b() throws ClassNotFoundException {
        String str;
        if (Build.VERSION.SDK_INT < 8) {
            str = "calendar";
        } else {
            str = "com.android.calendar";
        }
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        int iM3966c = m3966c();
        if (iM3966c > 0) {
            if (m3964a(Uri.parse("content://" + str + "/events"), this.f3722f, this.f3723g.longValue() + this.f3718b, this.f3724h.longValue() + this.f3719c)) {
                Toast.makeText(this.f3731o, R.string.regist_already_regist, 0).show();
                finish();
                return;
            }
            if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
                try {
                    Class<?> cls = Class.forName("android.provider.CalendarContract$Events");
                    contentValues.put((String) cls.getField("CALENDAR_ID").get(new String()), Integer.valueOf(iM3966c));
                    contentValues.put((String) cls.getField("TITLE").get(new String()), this.f3722f);
                    contentValues.put((String) cls.getField("DESCRIPTION").get(new String()), this.f3726j);
                    contentValues.put((String) cls.getField("EVENT_LOCATION").get(new String()), this.f3725i);
                    contentValues.put((String) cls.getField("DTSTART").get(new String()), this.f3723g);
                    contentValues.put((String) cls.getField("DTEND").get(new String()), this.f3724h);
                    if (TextUtils.isEmpty(this.f3730n)) {
                        this.f3730n = TimeZone.getDefault().toString();
                    }
                    contentValues.put((String) cls.getField("EVENT_TIMEZONE").get(new String()), this.f3730n);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                contentValues.put("calendar_id", Integer.valueOf(iM3966c));
                contentValues.put("title", this.f3722f);
                contentValues.put("description", this.f3726j);
                contentValues.put("eventLocation", this.f3725i);
                contentValues.put("dtstart", Long.valueOf(this.f3723g.longValue() + this.f3718b));
                contentValues.put("dtend", Long.valueOf(this.f3724h.longValue() + this.f3719c));
                contentValues.put("eventTimezone", this.f3730n);
            }
            C1786r.m6061b("******* SAVE EVENTS : " + contentValues.toString(), null);
            contentResolver.insert(Uri.parse("content://" + str + "/events"), contentValues);
            C2153y.m7535a(this, R.string.read_vcalendar_save_toast_success, 0).show();
        } else {
            Toast.makeText(this.f3731o, getResources().getString(R.string.buddy_profile_calendar_toast_notfound), 1).show();
        }
        finish();
    }

    /* renamed from: a */
    private boolean m3964a(Uri uri, String str, long j, long j2) {
        boolean z;
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"calendar_id", "title", "description", "dtstart", "dtend", "deleted", "eventLocation"}, null, null, null);
        try {
            cursorQuery.moveToFirst();
            int count = cursorQuery.getCount();
            int i = 0;
            while (true) {
                if (i < count) {
                    Date date = new Date(j);
                    Date date2 = new Date(j2);
                    Date date3 = new Date(cursorQuery.getLong(3));
                    Date date4 = new Date(cursorQuery.getLong(4));
                    if (str.equals(cursorQuery.getString(1)) && date.compareTo(date3) == 0 && date2.compareTo(date4) == 0 && cursorQuery.getInt(5) == 0) {
                        z = true;
                    } else {
                        cursorQuery.moveToNext();
                        i++;
                    }
                } else {
                    z = false;
                    if (cursorQuery != null) {
                    }
                }
            }
            return z;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: c */
    private int m3966c() {
        String str;
        String[] strArr = {"_id", "name"};
        if (Build.VERSION.SDK_INT > 13) {
            str = "visible=1";
        } else {
            str = "selected=1";
        }
        Cursor cursorM3960a = m3960a(strArr, str, "calendars");
        if (cursorM3960a != null && cursorM3960a.moveToFirst()) {
            int columnIndex = cursorM3960a.getColumnIndex("name");
            int columnIndex2 = cursorM3960a.getColumnIndex("_id");
            do {
                cursorM3960a.getString(columnIndex);
                String string = cursorM3960a.getString(columnIndex2);
                if (string != null) {
                    return Integer.parseInt(string);
                }
            } while (cursorM3960a.moveToNext());
        }
        return 0;
    }

    /* renamed from: a */
    private Cursor m3960a(String[] strArr, String str, String str2) {
        Cursor cursorManagedQuery = null;
        Uri uri = Uri.parse("content://calendar/" + str2);
        try {
            cursorManagedQuery = managedQuery(uri, strArr, str, null, null);
        } catch (SQLiteException e) {
        } catch (IllegalArgumentException e2) {
        }
        C1786r.m6061b("nayeon", "Failed to get provider at [" + uri.toString() + "]");
        if (cursorManagedQuery == null) {
            try {
                return managedQuery(Uri.parse("content://com.android.calendar/" + str2), strArr, str, null, null);
            } catch (IllegalArgumentException e3) {
                return cursorManagedQuery;
            }
        }
        return cursorManagedQuery;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f3733q = new ProgressDialogC1806j(this);
                this.f3733q.setProgressStyle(0);
                this.f3733q.setMessage(getString(R.string.wait_sending));
                return this.f3733q;
            default:
                return null;
        }
    }
}
