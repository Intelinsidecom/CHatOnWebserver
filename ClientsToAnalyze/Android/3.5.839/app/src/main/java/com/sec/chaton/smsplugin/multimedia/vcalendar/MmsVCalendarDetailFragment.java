package com.sec.chaton.smsplugin.multimedia.vcalendar;

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
import com.sec.chaton.multimedia.vcalendar.C2886b;
import com.sec.chaton.multimedia.vcalendar.C2894j;
import com.sec.chaton.multimedia.vcalendar.C2895k;
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
public class MmsVCalendarDetailFragment extends Fragment {

    /* renamed from: a */
    public static final String f14166a = MmsVCalendarDetailFragment.class.getSimpleName();

    /* renamed from: b */
    private String f14167b;

    /* renamed from: c */
    private String f14168c;

    /* renamed from: d */
    private String f14169d;

    /* renamed from: e */
    private Long f14170e;

    /* renamed from: f */
    private Long f14171f;

    /* renamed from: g */
    private String f14172g;

    /* renamed from: h */
    private String f14173h;

    /* renamed from: i */
    private int f14174i;

    /* renamed from: j */
    private C2894j f14175j;

    /* renamed from: k */
    private C2895k f14176k;

    /* renamed from: l */
    private ProgressDialog f14177l;

    /* renamed from: m */
    private MenuItem f14178m;

    /* renamed from: n */
    private Activity f14179n;

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
            this.f14174i = arguments.getInt("ACTIVITY_PURPOSE", 0);
        }
        if (this.f14174i == 1) {
            if (arguments != null) {
                this.f14167b = arguments.getString("inbox_NO");
                this.f14169d = arguments.getString("extra summary");
                this.f14170e = Long.valueOf(arguments.getLong("extra dtstart", 0L));
                this.f14171f = Long.valueOf(arguments.getLong("extra dtend", 0L));
                this.f14172g = arguments.getString("extra location");
                this.f14173h = arguments.getString("extra desc");
            }
        } else if (this.f14174i == 2) {
            if (arguments != null) {
                this.f14168c = arguments.getString("URI");
            }
            try {
                m15194b();
                this.f14176k = this.f14175j.f10669a.get(0);
                if (this.f14176k == null) {
                    if (this.f14179n != null) {
                        this.f14179n.finish();
                    }
                    return null;
                }
                this.f14169d = this.f14176k.f10678i;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                if (this.f14176k.f10672c != null) {
                    try {
                        date = simpleDateFormat.parse(this.f14176k.f10672c.substring(0, this.f14176k.f10672c.length() - 1));
                    } catch (Exception e) {
                        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
                        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
                        try {
                            date = simpleDateFormat2.parse(this.f14176k.f10672c);
                        } catch (ParseException e2) {
                            e2.printStackTrace();
                            date = null;
                        }
                    }
                    if (date != null) {
                        this.f14170e = Long.valueOf(date.getTime());
                    } else {
                        this.f14170e = null;
                    }
                }
                if (this.f14176k.f10671b != null) {
                    try {
                        date2 = simpleDateFormat.parse(this.f14176k.f10671b.substring(0, this.f14176k.f10671b.length() - 1));
                    } catch (Exception e3) {
                        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyyMMdd");
                        simpleDateFormat3.setTimeZone(TimeZone.getTimeZone("GMT"));
                        try {
                            date2 = simpleDateFormat3.parse(this.f14176k.f10671b);
                        } catch (ParseException e4) {
                            e4.printStackTrace();
                            date2 = null;
                        }
                    }
                    if (date2 != null) {
                        this.f14171f = Long.valueOf(date2.getTime());
                    } else {
                        this.f14171f = null;
                    }
                }
                this.f14172g = this.f14176k.f10679j;
                this.f14173h = this.f14176k.f10670a;
                if (this.f14178m != null) {
                    this.f14178m.setTitle(R.string.save);
                }
            } catch (Exception e5) {
                C4904y.m18635a(e5, f14166a);
                if (this.f14179n != null) {
                    C5179v.m19811a(this.f14179n, getString(R.string.vcalendar_parsing_error), 1).show();
                    this.f14179n.finish();
                }
                return null;
            }
        }
        if (this.f14169d == null || this.f14169d.length() == 0) {
            this.f14169d = getString(R.string.insert_calendar_no_title);
        }
        if (this.f14172g == null) {
            this.f14172g = "";
        }
        if (this.f14173h == null) {
            this.f14173h = "";
        }
        if ((this.f14170e == null || this.f14171f == null) && this.f14179n != null) {
            C5179v.m19811a(this.f14179n, getString(R.string.vcalendar_parsing_error), 1).show();
            this.f14179n.finish();
            return null;
        }
        ((TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_title)).setText(this.f14169d);
        Date date3 = new Date(this.f14170e.longValue());
        Date date4 = new Date(this.f14171f.longValue());
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("EEEE ", GlobalApplication.m10283b().getConfiguration().locale);
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(CommonApplication.m18732r());
        SimpleDateFormat simpleDateFormat5 = android.text.format.DateFormat.is24HourFormat(CommonApplication.m18732r()) ? new SimpleDateFormat(" HH:mm", GlobalApplication.m10283b().getConfiguration().locale) : new SimpleDateFormat(" hh:mma", GlobalApplication.m10283b().getConfiguration().locale);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.setTime(new Date(this.f14170e.longValue()));
        ((TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_date_from)).setText(simpleDateFormat4.format(date3) + dateFormat.format(date3) + simpleDateFormat5.format(date3));
        calendar.setTime(new Date(this.f14171f.longValue()));
        ((TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_date_to)).setText("- " + simpleDateFormat4.format(date4) + dateFormat.format(date4) + simpleDateFormat5.format(date4));
        TextView textView = (TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_location);
        if (this.f14172g == null || this.f14172g.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f14172g);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.vcalendar_event_detail_description);
        if (!TextUtils.isEmpty(this.f14173h)) {
            textView2.setText(this.f14173h);
        }
        this.f14177l = ProgressDialogC4926s.m18730a(this.f14179n);
        this.f14177l.setProgressStyle(0);
        this.f14177l.setMessage(getString(R.string.wait_sending));
        return viewInflate;
    }

    /* renamed from: a */
    private void m15192a() {
        C2895k c2895k = new C2895k();
        c2895k.f10678i = this.f14169d;
        c2895k.f10672c = String.valueOf(this.f14170e);
        c2895k.f10671b = String.valueOf(this.f14171f);
        c2895k.f10679j = this.f14172g;
        c2895k.f10670a = this.f14173h;
        this.f14175j = new C2894j();
        this.f14175j.m12059a(c2895k);
        this.f14177l.show();
        new HandlerThreadC3938b(this, "sendCalendar").start();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dd  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m15197a(java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.multimedia.vcalendar.MmsVCalendarDetailFragment.m15197a(java.lang.String):void");
    }

    /* renamed from: b */
    private void m15194b() throws Exception {
        String str;
        BufferedReader bufferedReader = null;
        C2886b c2886b = new C2886b();
        if (this.f14168c != null) {
            String[] strArrSplit = this.f14168c.split("file://");
            if (strArrSplit.length == 1) {
                str = this.f14168c;
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
                this.f14175j = c2886b.m12050a(sb.toString());
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
    private void m15195c() throws NumberFormatException {
        String str;
        if (Build.VERSION.SDK_INT < 8) {
            str = "calendar";
        } else {
            str = "com.android.calendar";
        }
        if (this.f14179n != null) {
            ContentResolver contentResolver = this.f14179n.getContentResolver();
            ContentValues contentValues = new ContentValues();
            int iM15196d = m15196d();
            if (iM15196d > 0) {
                contentValues.put("calendar_id", Integer.valueOf(iM15196d));
                contentValues.put("title", this.f14169d);
                contentValues.put("description", this.f14173h);
                contentValues.put("eventLocation", this.f14172g);
                contentValues.put("dtstart", this.f14170e);
                contentValues.put("dtend", this.f14171f);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(this.f14170e.longValue()));
                contentValues.put("eventTimezone", calendar.getTimeZone().getID());
                C4904y.m18639b("******* SAVE EVENTS : " + contentValues.toString(), null);
                contentResolver.insert(Uri.parse("content://" + str + "/events"), contentValues);
                C5179v.m19811a(this.f14179n, getString(R.string.toast_save_media), 0).show();
            } else {
                C5179v.m19811a(this.f14179n, getString(R.string.buddy_profile_calendar_toast_notfound), 1).show();
            }
            this.f14179n.finish();
        }
    }

    /* renamed from: d */
    private int m15196d() throws NumberFormatException {
        int i;
        String[] strArr = {"_id", "name"};
        String str = "selected=1";
        if (Build.VERSION.SDK_INT >= 14) {
            str = null;
        }
        Cursor cursorM15190a = m15190a(strArr, str, "calendars");
        if (cursorM15190a == null || !cursorM15190a.moveToFirst()) {
            i = 0;
        } else {
            int columnIndex = cursorM15190a.getColumnIndex("_id");
            do {
                String string = cursorM15190a.getString(columnIndex);
                if (string != null) {
                    i = Integer.parseInt(string);
                    break;
                }
            } while (cursorM15190a.moveToNext());
            i = 0;
        }
        if (cursorM15190a != null) {
            cursorM15190a.close();
        }
        return i;
    }

    /* renamed from: a */
    private Cursor m15190a(String[] strArr, String str, String str2) {
        Cursor cursorQuery = null;
        Uri uri = Uri.parse("content://calendar/" + str2);
        if (this.f14179n == null) {
            return null;
        }
        try {
            cursorQuery = this.f14179n.getContentResolver().query(uri, strArr, str, null, null);
        } catch (IllegalArgumentException e) {
        }
        if (cursorQuery != null) {
            return cursorQuery;
        }
        try {
            return this.f14179n.getContentResolver().query(Uri.parse("content://com.android.calendar/" + str2), strArr, str, null, null);
        } catch (IllegalArgumentException e2) {
            return cursorQuery;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f14179n = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f14179n = null;
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws NumberFormatException {
        if (menuItem.getItemId() == 16908332) {
            if (this.f14179n != null) {
                this.f14179n.finish();
                return true;
            }
        } else if (menuItem.getItemId() == R.id.menu_done) {
            this.f14178m.setEnabled(false);
            if (this.f14174i == 1) {
                m15192a();
                return true;
            }
            if (this.f14174i != 2) {
                return true;
            }
            m15195c();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        this.f14178m = menu.findItem(R.id.menu_done);
        if (this.f14174i == 2) {
            this.f14178m.setTitle(R.string.save);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
