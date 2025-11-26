package com.sec.chaton.smsplugin.p112ui;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.InterfaceC3788g;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SearchActivity extends ListActivity {

    /* renamed from: b */
    private AsyncQueryHandler f15095b;

    /* renamed from: c */
    private HashMap<C3782a, TextView> f15096c = new HashMap<>();

    /* renamed from: a */
    InterfaceC3788g f15094a = new C4293hm(this);

    public class TextViewSnippet extends TextView {

        /* renamed from: a */
        private static String f15097a = "…";

        /* renamed from: b */
        private static int f15098b = 1;

        /* renamed from: c */
        private String f15099c;

        /* renamed from: d */
        private String f15100d;

        /* renamed from: e */
        private Pattern f15101e;

        public TextViewSnippet(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public TextViewSnippet(Context context) {
            super(context);
        }

        public TextViewSnippet(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        @Override // android.widget.TextView, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            String strSubstring;
            String lowerCase = this.f15099c.toLowerCase();
            int iStart = 0;
            int length = this.f15100d.toLowerCase().length();
            int length2 = lowerCase.length();
            Matcher matcher = this.f15101e.matcher(this.f15099c);
            if (matcher.find(0)) {
                iStart = matcher.start();
            }
            TextPaint paint = getPaint();
            float fMeasureText = paint.measureText(this.f15100d);
            float width = getWidth();
            if (fMeasureText > width) {
                strSubstring = this.f15099c.substring(iStart, iStart + length);
            } else {
                float fMeasureText2 = width - (paint.measureText(f15097a) * 2.0f);
                int i5 = -1;
                strSubstring = null;
                int i6 = -1;
                int i7 = -1;
                while (true) {
                    int i8 = i7 + 1;
                    int iMax = Math.max(0, iStart - i8);
                    int iMin = Math.min(length2, iStart + length + i8);
                    if (iMax == i6 && iMin == i5) {
                        break;
                    }
                    String strSubstring2 = this.f15099c.substring(iMax, iMin);
                    if (paint.measureText(strSubstring2) > fMeasureText2) {
                        break;
                    }
                    Object[] objArr = new Object[3];
                    objArr[0] = iMax == 0 ? "" : f15097a;
                    objArr[1] = strSubstring2;
                    objArr[2] = iMin == length2 ? "" : f15097a;
                    i6 = iMax;
                    strSubstring = String.format("%s%s%s", objArr);
                    i5 = iMin;
                    i7 = i8;
                }
            }
            SpannableString spannableString = new SpannableString(strSubstring);
            Matcher matcher2 = this.f15101e.matcher(strSubstring);
            for (int iEnd = 0; matcher2.find(iEnd); iEnd = matcher2.end()) {
                spannableString.setSpan(new StyleSpan(f15098b), matcher2.start(), matcher2.end(), 0);
            }
            setText(spannableString);
            super.onLayout(z, i, i2, i3, i4);
        }

        public void setText(String str, String str2) {
            this.f15101e = Pattern.compile("\\b" + Pattern.quote(str2), 2);
            this.f15099c = str;
            this.f15100d = str2;
            requestLayout();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        C3782a.m14221b(this.f15094a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public long m16180a(long j, long j2) {
        Cursor cursorQuery = getContentResolver().query(Uri.parse(Uri.parse("content://mms-sms/messageIdToThread").buildUpon().appendQueryParameter("row_id", String.valueOf(j)).appendQueryParameter("table_to_use", String.valueOf(j2)).build().toString()), null, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    return cursorQuery.getLong(cursorQuery.getColumnIndex("thread_id"));
                }
            } finally {
                cursorQuery.close();
            }
        }
        return -1L;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("query");
        if (stringExtra == null) {
            stringExtra = getIntent().getStringExtra("intent_extra_data_key");
        }
        if (stringExtra != null) {
            stringExtra = stringExtra.trim();
        }
        Uri data = getIntent().getData();
        if (data != null && data.getQueryParameter("source_id") != null) {
            new Thread(new RunnableC4294hn(this, data, stringExtra)).start();
            return;
        }
        setContentView(R.layout.search_activity);
        ContentResolver contentResolver = getContentResolver();
        ListView listView = getListView();
        listView.setItemsCanFocus(true);
        listView.setFocusable(true);
        listView.setClickable(true);
        setTitle("");
        C3782a.m14212a(this.f15094a);
        this.f15095b = new C4295ho(this, contentResolver, stringExtra, listView);
        this.f15095b.startQuery(0, null, Telephony.MmsSms.SEARCH_URI.buildUpon().appendQueryParameter("pattern", stringExtra).build(), null, null, null, null);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return false;
        }
    }
}
