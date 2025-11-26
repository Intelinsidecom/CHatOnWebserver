package com.sec.chaton.multimedia.vcalendar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.multimedia.vcalendar.VCalendarStruct;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.TimeAdapter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class VCalendarDetailActivity2 extends BaseActivity {

    /* renamed from: a */
    public static final String f2186a = VCalendarListFragment.class.getSimpleName();

    /* renamed from: c */
    private String f2188c;

    /* renamed from: d */
    private String f2189d;

    /* renamed from: e */
    private String f2190e;

    /* renamed from: f */
    private Long f2191f;

    /* renamed from: g */
    private Long f2192g;

    /* renamed from: h */
    private String f2193h;

    /* renamed from: i */
    private String f2194i;

    /* renamed from: j */
    private int f2195j;

    /* renamed from: k */
    private VCalendarStruct f2196k;

    /* renamed from: l */
    private VCalendarStruct.EventStruct f2197l;

    /* renamed from: m */
    private Context f2198m;

    /* renamed from: n */
    private Button f2199n;

    /* renamed from: o */
    private Button f2200o;

    /* renamed from: p */
    private Button f2201p;

    /* renamed from: q */
    private ImageView f2202q;

    /* renamed from: r */
    private ProgressDialog f2203r;

    /* renamed from: s */
    private final int f2204s = 0;

    /* renamed from: b */
    View.OnClickListener f2187b = new ViewOnClickListenerC0310b(this);

    /* renamed from: t */
    private Runnable f2205t = new RunnableC0309a(this);

    /* renamed from: a */
    private Cursor m2562a(String[] strArr, String str, String str2) {
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

    /* renamed from: a */
    private String m2565a(int i) {
        return i == 2 ? "Monday" : i == 3 ? "Tuesday" : i == 4 ? "Wednesday" : i == 5 ? "Thursday" : i == 6 ? "Friday" : i == 7 ? "Saturday" : i == 1 ? "Sunday" : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2566a() {
        String str = Build.VERSION.SDK_INT < 8 ? "calendar" : "com.android.calendar";
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        int iM2568b = m2568b();
        if (iM2568b > 0) {
            contentValues.put("calendar_id", Integer.valueOf(iM2568b));
            contentValues.put("title", this.f2190e);
            contentValues.put("description", this.f2194i);
            contentValues.put("eventLocation", this.f2193h);
            contentValues.put("dtstart", this.f2191f);
            contentValues.put("dtend", this.f2192g);
            ChatONLogWriter.m3506b("******* SAVE EVENTS : " + contentValues.toString(), null);
            contentResolver.insert(Uri.parse("content://" + str + "/events"), contentValues);
            Toast.makeText(this.f2198m, getResources().getString(C0062R.string.read_vcalendar_save_toast_success), 0).show();
        } else {
            Toast.makeText(this.f2198m, getResources().getString(C0062R.string.buddy_profile_calendar_toast_notfound), 1).show();
        }
        finish();
    }

    /* renamed from: a */
    private void m2567a(Context context) throws IOException {
        VCalParser vCalParser = new VCalParser();
        String str = null;
        if (this.f2189d != null) {
            String[] strArrSplit = this.f2189d.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f2189d;
            } else if (strArrSplit.length == 2) {
                str = strArrSplit[1];
            } else {
                finish();
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        String str2 = "";
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                this.f2196k = vCalParser.m2560a(str2);
                return;
            }
            str2 = str2 + line + "\n";
        }
    }

    /* renamed from: b */
    private int m2568b() {
        Cursor cursorM2562a = m2562a(new String[]{"_id", "name"}, "selected=1", "calendars");
        if (cursorM2562a != null && cursorM2562a.moveToFirst()) {
            int columnIndex = cursorM2562a.getColumnIndex("name");
            int columnIndex2 = cursorM2562a.getColumnIndex("_id");
            do {
                cursorM2562a.getString(columnIndex);
                String string = cursorM2562a.getString(columnIndex2);
                if (string != null) {
                    return Integer.parseInt(string);
                }
            } while (cursorM2562a.moveToNext());
        }
        return 0;
    }

    /* renamed from: b */
    private String m2570b(String str) throws IOException {
        try {
            List<Address> fromLocationName = new Geocoder(this.f2198m).getFromLocationName(str, 5);
            if (fromLocationName.size() > 0) {
                return String.valueOf(fromLocationName.get(0).getLatitude()) + "," + String.valueOf(fromLocationName.get(0).getLongitude());
            }
        } catch (IOException e) {
            ChatONLogWriter.m3501a(e, getClass().getName());
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2580a(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r4 = 0
            boolean r0 = com.sec.chaton.util.StorageStateInfoUtil.m3677a()
            if (r0 == 0) goto Laa
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m2387e()
            java.io.File r0 = r0.getExternalFilesDir(r4)
            java.lang.String r0 = r0.getAbsolutePath()
        L13:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r5.f2188c
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L3a
            r1.mkdir()
        L3a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = "/"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r5.f2188c
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "/"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = com.sec.chaton.util.TimeAdapter.m3678a()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ".VCS"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lb8 java.io.FileNotFoundException -> Lc0 java.io.IOException -> Lca
            r1.<init>(r0)     // Catch: java.lang.Throwable -> Lb8 java.io.FileNotFoundException -> Lc0 java.io.IOException -> Lca
            byte[] r2 = r6.getBytes()     // Catch: java.lang.Throwable -> Ld4 java.io.IOException -> Ld6 java.io.FileNotFoundException -> Ld8
            r1.write(r2)     // Catch: java.lang.Throwable -> Ld4 java.io.IOException -> Ld6 java.io.FileNotFoundException -> Ld8
            if (r1 == 0) goto L78
            r1.close()     // Catch: java.io.IOException -> Lc8
        L78:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            boolean r2 = r2.exists()
            if (r2 != 0) goto L8b
            r5.m2580a(r6)
        L8b:
            if (r0 == 0) goto L92
            java.lang.String r2 = "extra fileuri"
            r1.putExtra(r2, r0)
        L92:
            java.lang.String r0 = "extra vcalendar"
            java.lang.String r2 = r5.f2190e
            r1.putExtra(r0, r2)
            r0 = -1
            r5.setResult(r0, r1)
            android.app.ProgressDialog r0 = r5.f2203r
            r0.dismiss()
            r0 = 0
            r5.removeDialog(r0)
            r5.finish()
            return
        Laa:
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m2387e()
            java.io.File r0 = r0.getFilesDir()
            java.lang.String r0 = r0.getAbsolutePath()
            goto L13
        Lb8:
            r0 = move-exception
            r1 = r4
        Lba:
            if (r1 == 0) goto Lbf
            r1.close()     // Catch: java.io.IOException -> Ld2
        Lbf:
            throw r0
        Lc0:
            r1 = move-exception
            r1 = r4
        Lc2:
            if (r1 == 0) goto L78
            r1.close()     // Catch: java.io.IOException -> Lc8
            goto L78
        Lc8:
            r1 = move-exception
            goto L78
        Lca:
            r1 = move-exception
            r1 = r4
        Lcc:
            if (r1 == 0) goto L78
            r1.close()     // Catch: java.io.IOException -> Lc8
            goto L78
        Ld2:
            r1 = move-exception
            goto Lbf
        Ld4:
            r0 = move-exception
            goto Lba
        Ld6:
            r2 = move-exception
            goto Lcc
        Ld8:
            r2 = move-exception
            goto Lc2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcalendar.VCalendarDetailActivity2.m2580a(java.lang.String):void");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_multimedia_vcalendar_detail2);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                this.f2203r = new ProgressDialog(this);
                this.f2203r.setProgressStyle(0);
                this.f2203r.setMessage(getString(C0062R.string.wait_sending));
                return this.f2203r;
            default:
                return null;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws IOException {
        super.onResume();
        this.f2198m = this;
        this.f2195j = getIntent().getIntExtra("ACTIVITY_PURPOSE", 1);
        if (this.f2195j == 1) {
            this.f2188c = getIntent().getStringExtra("inbox_NO");
            this.f2190e = getIntent().getStringExtra("extra summary");
            this.f2191f = Long.valueOf(getIntent().getLongExtra("extra dtstart", 0L));
            this.f2192g = Long.valueOf(getIntent().getLongExtra("extra dtend", 0L));
            this.f2193h = getIntent().getStringExtra("extra location");
            this.f2194i = getIntent().getStringExtra("extra desc");
        } else if (this.f2195j == 2 || this.f2195j == 3) {
            if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("URI")) {
                this.f2189d = getIntent().getExtras().getString("URI");
            }
            try {
                m2567a((Context) this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f2197l = (VCalendarStruct.EventStruct) this.f2196k.f2235a.get(0);
            this.f2190e = this.f2197l.f2244i;
            if (this.f2197l.f2238c != null) {
                Date dateM3682a = TimeAdapter.m3682a(this.f2197l.f2238c.substring(0, this.f2197l.f2238c.length() - 1));
                if (dateM3682a != null) {
                    this.f2191f = Long.valueOf(dateM3682a.getTime());
                } else {
                    this.f2191f = null;
                }
            }
            if (this.f2197l.f2237b != null) {
                Date dateM3682a2 = TimeAdapter.m3682a(this.f2197l.f2237b.substring(0, this.f2197l.f2237b.length() - 1));
                if (dateM3682a2 != null) {
                    this.f2192g = Long.valueOf(dateM3682a2.getTime());
                } else {
                    this.f2192g = null;
                }
            }
            this.f2193h = this.f2197l.f2245j;
            this.f2194i = this.f2197l.f2236a;
        }
        if (this.f2190e == null || this.f2190e.equals("")) {
            this.f2190e = "No title";
        }
        if (this.f2193h == null) {
            this.f2193h = "";
        }
        if (this.f2194i == null) {
            this.f2194i = "";
        }
        if (this.f2191f == null || this.f2192g == null) {
            Toast.makeText(this, getString(C0062R.string.vcalendar_parsing_error), 1).show();
            finish();
            return;
        }
        ((TextView) findViewById(C0062R.id.vcalendar_event_detail_title)).setText(this.f2190e);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(this.f2191f.longValue()));
        ((TextView) findViewById(C0062R.id.vcalendar_event_detail_date_from)).setText(m2565a(calendar.get(7)) + " " + new SimpleDateFormat("dd MMM, yyyy hh:mm:ssa", Locale.US).format(new Date(this.f2191f.longValue())).toLowerCase());
        calendar.setTime(new Date(this.f2192g.longValue()));
        ((TextView) findViewById(C0062R.id.vcalendar_event_detail_date_to)).setText("- " + m2565a(calendar.get(7)) + " " + new SimpleDateFormat("dd MMM, yyyy hh:mm:ssa", Locale.US).format(new Date(this.f2192g.longValue())).toLowerCase());
        TextView textView = (TextView) findViewById(C0062R.id.vcalendar_event_detail_location);
        this.f2202q = (ImageView) findViewById(C0062R.id.vcalendar_event_detail_map);
        if (this.f2193h.equals("")) {
            textView.setVisibility(8);
            this.f2202q.setVisibility(8);
            ((ImageView) findViewById(C0062R.id.vcalendar_event_detail_map_bottom_line)).setVisibility(8);
        } else {
            textView.setText(this.f2193h);
            String strM2570b = ChatONConst.m1972a() ? m2570b(this.f2193h) : null;
            if (strM2570b == null || strM2570b.length() <= 0) {
                this.f2202q.setVisibility(8);
            } else {
                ChatONLogWriter.m3506b("************** CENTER : " + strM2570b, f2186a);
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL("http://maps.googleapis.com/maps/api/staticmap?center=" + strM2570b + "&zoom=18&size=512x512&maptype=roadmap&markers=color|red|" + strM2570b + "&sensor=false").openConnection()).getInputStream(), AMSLibs.ENUM_VIP_AMS_WQVGA_SAVE_USER_STAMPIMAGE_SIZE);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                    bufferedInputStream.close();
                    this.f2202q.setImageBitmap(bitmapDecodeStream);
                } catch (Exception e2) {
                    ChatONLogWriter.m3500a((Throwable) e2);
                }
            }
        }
        TextView textView2 = (TextView) findViewById(C0062R.id.vcalendar_event_detail_description);
        if (this.f2194i.equals("")) {
            ((LinearLayout) findViewById(C0062R.id.vcalendar_event_detail_desc_area)).setVisibility(8);
        } else {
            textView2.setText(this.f2194i);
        }
        this.f2200o = (Button) findViewById(C0062R.id.vcal_event_detail_send);
        this.f2200o.setOnClickListener(this.f2187b);
        this.f2199n = (Button) findViewById(C0062R.id.vcal_event_detail_save);
        this.f2199n.setOnClickListener(this.f2187b);
        this.f2201p = (Button) findViewById(C0062R.id.vcal_event_detail_cancel);
        this.f2201p.setOnClickListener(this.f2187b);
        this.f2201p.setVisibility(0);
        if (this.f2195j == 1) {
            this.f2200o.setVisibility(0);
            this.f2199n.setVisibility(8);
        } else {
            this.f2200o.setVisibility(8);
            this.f2199n.setVisibility(0);
            this.f2199n.setEnabled(true);
        }
    }
}
