package com.sec.chaton.multimedia.vcalendar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class VCalendarDetailFragment extends Fragment {

    /* renamed from: a */
    public static final String f10617a = VCalendarDetailFragment.class.getSimpleName();

    /* renamed from: b */
    private String f10618b;

    /* renamed from: c */
    private String f10619c;

    /* renamed from: d */
    private String f10620d;

    /* renamed from: e */
    private Long f10621e;

    /* renamed from: f */
    private Long f10622f;

    /* renamed from: g */
    private String f10623g;

    /* renamed from: h */
    private String f10624h;

    /* renamed from: i */
    private int f10625i;

    /* renamed from: j */
    private C2894j f10626j;

    /* renamed from: k */
    private C2895k f10627k;

    /* renamed from: l */
    private ProgressDialog f10628l;

    /* renamed from: m */
    private MenuItem f10629m;

    /* renamed from: n */
    private Activity f10630n;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Date date;
        Date date2;
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcalendar_detail2, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f10625i = arguments.getInt("ACTIVITY_PURPOSE", 0);
        }
        if (this.f10625i == 1) {
            if (arguments != null) {
                this.f10618b = arguments.getString("inbox_NO");
                this.f10620d = arguments.getString("extra summary");
                this.f10621e = Long.valueOf(arguments.getLong("extra dtstart", 0L));
                this.f10622f = Long.valueOf(arguments.getLong("extra dtend", 0L));
                this.f10623g = arguments.getString("extra location");
                this.f10624h = arguments.getString("extra desc");
            }
        } else if (this.f10625i == 2) {
            if (arguments != null) {
                this.f10619c = arguments.getString("URI");
            }
            try {
                m12021b();
                this.f10627k = this.f10626j.f10669a.get(0);
                if (this.f10627k == null) {
                    if (this.f10630n != null) {
                        this.f10630n.finish();
                    }
                    return null;
                }
                this.f10620d = this.f10627k.f10678i;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                if (this.f10627k.f10672c != null) {
                    try {
                        date = simpleDateFormat.parse(this.f10627k.f10672c.substring(0, this.f10627k.f10672c.length() - 1));
                    } catch (Exception e) {
                        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
                        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
                        try {
                            date = simpleDateFormat2.parse(this.f10627k.f10672c);
                        } catch (ParseException e2) {
                            e2.printStackTrace();
                            date = null;
                        }
                    }
                    if (date != null) {
                        this.f10621e = Long.valueOf(date.getTime());
                    } else {
                        this.f10621e = null;
                    }
                }
                if (this.f10627k.f10671b != null) {
                    try {
                        date2 = simpleDateFormat.parse(this.f10627k.f10671b.substring(0, this.f10627k.f10671b.length() - 1));
                    } catch (Exception e3) {
                        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyyMMdd");
                        simpleDateFormat3.setTimeZone(TimeZone.getTimeZone("GMT"));
                        try {
                            date2 = simpleDateFormat3.parse(this.f10627k.f10671b);
                        } catch (ParseException e4) {
                            e4.printStackTrace();
                            date2 = null;
                        }
                    }
                    if (date2 != null) {
                        this.f10622f = Long.valueOf(date2.getTime());
                    } else {
                        this.f10622f = null;
                    }
                }
                this.f10623g = this.f10627k.f10679j;
                this.f10624h = this.f10627k.f10670a;
                if (this.f10629m != null) {
                    this.f10629m.setTitle(R.string.save);
                }
            } catch (Exception e5) {
                C4904y.m18635a(e5, f10617a);
                if (this.f10630n != null) {
                    C5179v.m19811a(this.f10630n, getString(R.string.vcalendar_parsing_error), 1).show();
                    this.f10630n.finish();
                }
                return null;
            }
        }
        if (this.f10620d == null || this.f10620d.length() == 0) {
            this.f10620d = getString(R.string.insert_calendar_no_title);
        }
        if (this.f10623g == null) {
            this.f10623g = "";
        }
        if (this.f10624h == null) {
            this.f10624h = "";
        }
        if ((this.f10621e == null || this.f10622f == null) && this.f10630n != null) {
            C5179v.m19811a(this.f10630n, getString(R.string.vcalendar_parsing_error), 1).show();
            this.f10630n.finish();
            return null;
        }
        ((TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_title)).setText(this.f10620d);
        Date date3 = new Date(this.f10621e.longValue());
        Date date4 = new Date(this.f10622f.longValue());
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("EEEE ", GlobalApplication.m10283b().getConfiguration().locale);
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(CommonApplication.m18732r());
        SimpleDateFormat simpleDateFormat5 = android.text.format.DateFormat.is24HourFormat(CommonApplication.m18732r()) ? new SimpleDateFormat(" HH:mm", GlobalApplication.m10283b().getConfiguration().locale) : new SimpleDateFormat(" hh:mma", GlobalApplication.m10283b().getConfiguration().locale);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.setTime(new Date(this.f10621e.longValue()));
        ((TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_date_from)).setText(simpleDateFormat4.format(date3) + dateFormat.format(date3) + simpleDateFormat5.format(date3));
        calendar.setTime(new Date(this.f10622f.longValue()));
        ((TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_date_to)).setText("- " + simpleDateFormat4.format(date4) + dateFormat.format(date4) + simpleDateFormat5.format(date4));
        TextView textView = (TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_location);
        if (this.f10623g == null || this.f10623g.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f10623g);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_description);
        if (!TextUtils.isEmpty(this.f10624h)) {
            textView2.setText(this.f10624h);
        }
        this.f10628l = new ProgressDialogC4926s(this.f10630n);
        this.f10628l.setProgressStyle(0);
        this.f10628l.setMessage(getString(R.string.wait_sending));
        return viewInflate;
    }

    /* renamed from: a */
    private void m12019a() {
        C2895k c2895k = new C2895k();
        c2895k.f10678i = this.f10620d;
        c2895k.f10672c = String.valueOf(this.f10621e);
        c2895k.f10671b = String.valueOf(this.f10622f);
        c2895k.f10679j = this.f10623g;
        c2895k.f10670a = this.f10624h;
        this.f10626j = new C2894j();
        this.f10626j.m12059a(c2895k);
        this.f10628l.show();
        new HandlerThreadC2888d(this, "sendCalendar").start();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m12024a(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcalendar.VCalendarDetailFragment.m12024a(java.lang.String):void");
    }

    /* renamed from: b */
    private void m12021b() throws Exception {
        String str;
        BufferedReader bufferedReader = null;
        C2886b c2886b = new C2886b();
        if (this.f10619c != null) {
            String[] strArrSplit = this.f10619c.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f10619c;
            } else {
                if (strArrSplit.length != 2) {
                    throw new Exception("Parsing Error");
                }
                str = strArrSplit[1];
            }
        } else {
            str = null;
        }
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb.append(line + "\n");
                    }
                }
                this.f10626j = c2886b.m12050a(sb.toString());
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: c */
    private void m12022c() {
        String str;
        if (Build.VERSION.SDK_INT < 8) {
            str = "calendar";
        } else {
            str = "com.android.calendar";
        }
        if (this.f10630n != null) {
            ContentResolver contentResolver = this.f10630n.getContentResolver();
            ContentValues contentValues = new ContentValues();
            int iM12023d = m12023d();
            if (iM12023d > 0) {
                contentValues.put("calendar_id", Integer.valueOf(iM12023d));
                contentValues.put("title", this.f10620d);
                contentValues.put("description", this.f10624h);
                contentValues.put("eventLocation", this.f10623g);
                contentValues.put("dtstart", this.f10621e);
                contentValues.put("dtend", this.f10622f);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(this.f10621e.longValue()));
                contentValues.put("eventTimezone", calendar.getTimeZone().getID());
                C4904y.m18639b("******* SAVE EVENTS : " + contentValues.toString(), null);
                contentResolver.insert(Uri.parse("content://" + str + "/events"), contentValues);
                C5179v.m19811a(this.f10630n, getString(R.string.toast_save_media), 0).show();
            } else {
                C5179v.m19811a(this.f10630n, getString(R.string.buddy_profile_calendar_toast_notfound), 1).show();
            }
            this.f10630n.finish();
        }
    }

    /* renamed from: d */
    private int m12023d() {
        int i;
        Cursor cursorM12017a = null;
        try {
            cursorM12017a = m12017a(new String[]{"_id", "name"}, Build.VERSION.SDK_INT >= 14 ? null : "selected=1", "calendars");
            if (cursorM12017a == null || !cursorM12017a.moveToFirst()) {
                i = 0;
            } else {
                int columnIndex = cursorM12017a.getColumnIndex("_id");
                do {
                    String string = cursorM12017a.getString(columnIndex);
                    if (string != null) {
                        i = Integer.parseInt(string);
                        break;
                    }
                } while (cursorM12017a.moveToNext());
                i = 0;
            }
            return i;
        } finally {
            if (cursorM12017a != null) {
                cursorM12017a.close();
            }
        }
    }

    /* renamed from: a */
    private Cursor m12017a(String[] strArr, String str, String str2) {
        Cursor cursorQuery = null;
        Uri uri = Uri.parse("content://calendar/" + str2);
        if (this.f10630n == null) {
            return null;
        }
        try {
            cursorQuery = this.f10630n.getContentResolver().query(uri, strArr, str, null, null);
        } catch (IllegalArgumentException e) {
        }
        if (cursorQuery != null) {
            return cursorQuery;
        }
        try {
            return this.f10630n.getContentResolver().query(Uri.parse("content://com.android.calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e2) {
            return cursorQuery;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10630n = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10630n = null;
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332 || menuItem.getItemId() == R.id.menu_cancel) {
            if (this.f10630n != null) {
                this.f10630n.finish();
                return true;
            }
        } else if (menuItem.getItemId() == R.id.menu_done) {
            this.f10629m.setEnabled(false);
            if (this.f10625i == 1) {
                m12019a();
                return true;
            }
            if (this.f10625i != 2) {
                return true;
            }
            m12022c();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f10629m = menu.findItem(R.id.menu_done);
        if (this.f10625i == 2) {
            this.f10629m.setTitle(R.string.save);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
