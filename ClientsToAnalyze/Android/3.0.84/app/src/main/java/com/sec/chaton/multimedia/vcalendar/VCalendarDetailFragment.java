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
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
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
    public static final String f7296a = VCalendarDetailFragment.class.getSimpleName();

    /* renamed from: b */
    private String f7297b;

    /* renamed from: c */
    private String f7298c;

    /* renamed from: d */
    private String f7299d;

    /* renamed from: e */
    private Long f7300e;

    /* renamed from: f */
    private Long f7301f;

    /* renamed from: g */
    private String f7302g;

    /* renamed from: h */
    private String f7303h;

    /* renamed from: i */
    private int f7304i;

    /* renamed from: j */
    private C1925j f7305j;

    /* renamed from: k */
    private C1926k f7306k;

    /* renamed from: l */
    private ProgressDialog f7307l;

    /* renamed from: m */
    private MenuItem f7308m;

    /* renamed from: n */
    private Activity f7309n;

    /* renamed from: o */
    private Runnable f7310o = new RunnableC1919d(this);

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
            this.f7304i = arguments.getInt("ACTIVITY_PURPOSE", 0);
        }
        if (this.f7304i == 1) {
            if (arguments != null) {
                this.f7297b = arguments.getString("inbox_NO");
                this.f7299d = arguments.getString("extra summary");
                this.f7300e = Long.valueOf(arguments.getLong("extra dtstart", 0L));
                this.f7301f = Long.valueOf(arguments.getLong("extra dtend", 0L));
                this.f7302g = arguments.getString("extra location");
                this.f7303h = arguments.getString("extra desc");
            }
        } else if (this.f7304i == 2) {
            if (arguments != null) {
                this.f7298c = arguments.getString("URI");
            }
            try {
                m7793b();
                this.f7306k = this.f7305j.f7348a.get(0);
                if (this.f7306k == null) {
                    if (this.f7309n != null) {
                        this.f7309n.finish();
                    }
                    return null;
                }
                this.f7299d = this.f7306k.f7357i;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                if (this.f7306k.f7351c != null) {
                    try {
                        date = simpleDateFormat.parse(this.f7306k.f7351c.substring(0, this.f7306k.f7351c.length() - 1));
                    } catch (Exception e) {
                        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
                        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
                        try {
                            date = simpleDateFormat2.parse(this.f7306k.f7351c);
                        } catch (ParseException e2) {
                            e2.printStackTrace();
                            date = null;
                        }
                    }
                    if (date != null) {
                        this.f7300e = Long.valueOf(date.getTime());
                    } else {
                        this.f7300e = null;
                    }
                }
                if (this.f7306k.f7350b != null) {
                    try {
                        date2 = simpleDateFormat.parse(this.f7306k.f7350b.substring(0, this.f7306k.f7350b.length() - 1));
                    } catch (Exception e3) {
                        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyyMMdd");
                        simpleDateFormat3.setTimeZone(TimeZone.getTimeZone("GMT"));
                        try {
                            date2 = simpleDateFormat3.parse(this.f7306k.f7350b);
                        } catch (ParseException e4) {
                            e4.printStackTrace();
                            date2 = null;
                        }
                    }
                    if (date2 != null) {
                        this.f7301f = Long.valueOf(date2.getTime());
                    } else {
                        this.f7301f = null;
                    }
                }
                this.f7302g = this.f7306k.f7358j;
                this.f7303h = this.f7306k.f7349a;
                if (this.f7308m != null) {
                    this.f7308m.setTitle(R.string.save);
                }
            } catch (Exception e5) {
                C3250y.m11443a(e5, f7296a);
                if (this.f7309n != null) {
                    C3641ai.m13211a(this.f7309n, getString(R.string.vcalendar_parsing_error), 1).show();
                    this.f7309n.finish();
                }
                return null;
            }
        }
        if (this.f7299d == null || this.f7299d.length() == 0) {
            this.f7299d = getString(R.string.insert_calendar_no_title);
        }
        if (this.f7302g == null) {
            this.f7302g = "";
        }
        if (this.f7303h == null) {
            this.f7303h = "";
        }
        if ((this.f7300e == null || this.f7301f == null) && this.f7309n != null) {
            C3641ai.m13211a(this.f7309n, getString(R.string.vcalendar_parsing_error), 1).show();
            this.f7309n.finish();
            return null;
        }
        ((TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_title)).setText(this.f7299d);
        Date date3 = new Date(this.f7300e.longValue());
        Date date4 = new Date(this.f7301f.longValue());
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("EEEE ", GlobalApplication.m6451b().getConfiguration().locale);
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(CommonApplication.m11493l());
        SimpleDateFormat simpleDateFormat5 = android.text.format.DateFormat.is24HourFormat(CommonApplication.m11493l()) ? new SimpleDateFormat(" HH:mm", GlobalApplication.m6451b().getConfiguration().locale) : new SimpleDateFormat(" hh:mma", GlobalApplication.m6451b().getConfiguration().locale);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.setTime(new Date(this.f7300e.longValue()));
        ((TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_date_from)).setText(simpleDateFormat4.format(date3) + dateFormat.format(date3) + simpleDateFormat5.format(date3));
        calendar.setTime(new Date(this.f7301f.longValue()));
        ((TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_date_to)).setText("- " + simpleDateFormat4.format(date4) + dateFormat.format(date4) + simpleDateFormat5.format(date4));
        TextView textView = (TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_location);
        if (this.f7302g == null || this.f7302g.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f7302g);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_description);
        if (!TextUtils.isEmpty(this.f7303h)) {
            textView2.setText(this.f7303h);
        }
        this.f7307l = new ProgressDialogC3265l(this.f7309n);
        this.f7307l.setProgressStyle(0);
        this.f7307l.setMessage(getString(R.string.wait_sending));
        return viewInflate;
    }

    /* renamed from: a */
    private void m7791a() {
        C1926k c1926k = new C1926k();
        c1926k.f7357i = this.f7299d;
        c1926k.f7351c = String.valueOf(this.f7300e);
        c1926k.f7350b = String.valueOf(this.f7301f);
        c1926k.f7358j = this.f7302g;
        c1926k.f7349a = this.f7303h;
        this.f7305j = new C1925j();
        this.f7305j.m7830a(c1926k);
        this.f7307l.show();
        new Thread((ThreadGroup) null, this.f7310o).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7796a(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcalendar.VCalendarDetailFragment.m7796a(java.lang.String):void");
    }

    /* renamed from: b */
    private void m7793b() throws Exception {
        String str;
        BufferedReader bufferedReader = null;
        C1917b c1917b = new C1917b();
        if (this.f7298c != null) {
            String[] strArrSplit = this.f7298c.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f7298c;
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
                this.f7305j = c1917b.m7820a(sb.toString());
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
    private void m7794c() {
        String str;
        if (Build.VERSION.SDK_INT < 8) {
            str = "calendar";
        } else {
            str = "com.android.calendar";
        }
        if (this.f7309n != null) {
            ContentResolver contentResolver = this.f7309n.getContentResolver();
            ContentValues contentValues = new ContentValues();
            int iM7795d = m7795d();
            if (iM7795d > 0) {
                contentValues.put("calendar_id", Integer.valueOf(iM7795d));
                contentValues.put("title", this.f7299d);
                contentValues.put("description", this.f7303h);
                contentValues.put("eventLocation", this.f7302g);
                contentValues.put("dtstart", this.f7300e);
                contentValues.put("dtend", this.f7301f);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(this.f7300e.longValue()));
                contentValues.put("eventTimezone", calendar.getTimeZone().getID());
                C3250y.m11450b("******* SAVE EVENTS : " + contentValues.toString(), null);
                contentResolver.insert(Uri.parse("content://" + str + "/events"), contentValues);
                C3641ai.m13211a(this.f7309n, getString(R.string.toast_save_media), 0).show();
            } else {
                C3641ai.m13211a(this.f7309n, getString(R.string.buddy_profile_calendar_toast_notfound), 1).show();
            }
            this.f7309n.finish();
        }
    }

    /* renamed from: d */
    private int m7795d() {
        String[] strArr = {"_id", "name"};
        String str = "selected=1";
        if (Build.VERSION.SDK_INT >= 14) {
            str = null;
        }
        Cursor cursorM7789a = m7789a(strArr, str, "calendars");
        if (cursorM7789a != null && cursorM7789a.moveToFirst()) {
            int columnIndex = cursorM7789a.getColumnIndex("_id");
            do {
                String string = cursorM7789a.getString(columnIndex);
                if (string != null) {
                    return Integer.parseInt(string);
                }
            } while (cursorM7789a.moveToNext());
        }
        return 0;
    }

    /* renamed from: a */
    private Cursor m7789a(String[] strArr, String str, String str2) {
        Cursor cursorQuery = null;
        Uri uri = Uri.parse("content://calendar/" + str2);
        if (this.f7309n == null) {
            return null;
        }
        try {
            cursorQuery = this.f7309n.getContentResolver().query(uri, strArr, str, null, null);
        } catch (IllegalArgumentException e) {
        }
        if (cursorQuery != null) {
            return cursorQuery;
        }
        try {
            return this.f7309n.getContentResolver().query(Uri.parse("content://com.android.calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e2) {
            return cursorQuery;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f7309n = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f7309n = null;
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.f7309n != null) {
                this.f7309n.finish();
                return true;
            }
        } else if (menuItem.getItemId() == R.id.menu_done) {
            this.f7308m.setEnabled(false);
            if (this.f7304i == 1) {
                m7791a();
                return true;
            }
            if (this.f7304i != 2) {
                return true;
            }
            m7794c();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f7308m = menu.findItem(R.id.menu_done);
        if (this.f7304i == 2) {
            this.f7308m.setTitle(R.string.save);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
