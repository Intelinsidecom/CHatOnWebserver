package com.sec.chaton.localbackup.chatview;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.doc.EnumC1794a;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.specialbuddy.C2930k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Query;

/* compiled from: ChatViewAdapter.java */
/* renamed from: com.sec.chaton.localbackup.chatview.d */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1623d extends SimpleCursorAdapter implements View.OnClickListener {

    /* renamed from: a */
    public static final String[] f6051a = {"_id", "message_inbox_no", "message_sever_id", "message_session_id", "message_time", "message_content", "message_type", "message_sender", "message_is_failed", "buddy_name"};

    /* renamed from: b */
    private Context f6052b;

    /* renamed from: c */
    private LayoutInflater f6053c;

    /* renamed from: d */
    private int f6054d;

    /* renamed from: e */
    private C3326c f6055e;

    /* renamed from: f */
    private Calendar f6056f;

    /* renamed from: g */
    private Calendar f6057g;

    /* renamed from: h */
    private Date f6058h;

    /* renamed from: i */
    private Date f6059i;

    /* renamed from: j */
    private InterfaceC1626g f6060j;

    public ViewOnClickListenerC1623d(Context context, int i, Cursor cursor, C3326c c3326c, InterfaceC1626g interfaceC1626g) {
        super(context, i, cursor, f6051a, null, -1);
        this.f6052b = context;
        this.f6053c = (LayoutInflater) this.f6052b.getSystemService("layout_inflater");
        this.f6054d = i;
        this.f6055e = c3326c;
        this.f6056f = Calendar.getInstance();
        this.f6057g = Calendar.getInstance();
        this.f6058h = new Date();
        this.f6059i = new Date();
        this.f6060j = interfaceC1626g;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C1625f c1625f = (C1625f) view.getTag();
        c1625f.f6069h = cursor.getPosition();
        long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
        EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        long j2 = cursor.getLong(cursor.getColumnIndex("message_time"));
        String string = cursor.getString(cursor.getColumnIndex("message_content"));
        int i = cursor.getInt(cursor.getColumnIndex("message_type"));
        String string2 = cursor.getString(cursor.getColumnIndex("message_sender"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        String string4 = cursor.getString(cursor.getColumnIndex("message_formatted"));
        int i2 = cursor.getInt(cursor.getColumnIndex("message_is_failed"));
        String string5 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        c1625f.f6070i = j;
        this.f6058h = new Date(j2);
        this.f6056f.setTime(this.f6058h);
        if (C3159aa.m10962a().m10979a("chaton_id", "").equals(string2)) {
            c1625f.f6063b.setText(R.string.setting_interaction_me);
        } else if (!TextUtils.isEmpty(string5)) {
            c1625f.f6063b.setText(string5);
        } else {
            c1625f.f6063b.setText(CommonApplication.m11493l().getString(R.string.unknown));
        }
        m6908a(cursor.getPosition(), i2, i, c1625f, j2, cursor);
        if (j2 == 0) {
            c1625f.f6065d.setVisibility(8);
        } else {
            c1625f.f6065d.setVisibility(0);
            c1625f.f6065d.setText(DateFormat.getTimeFormat(this.f6052b).format(new Date(j2)));
            this.f6056f.setTime(new Date(j2));
        }
        if (enumC1455wM6358a == EnumC1455w.TEXT) {
            c1625f.f6068g.setVisibility(8);
            c1625f.f6064c.setText(C1835j.m7508a(this.f6052b, string, (int) C3172an.m11085a(30.0f)));
            c1625f.f6064c.setVisibility(0);
        } else {
            c1625f.f6068g.setVisibility(0);
            c1625f.f6062a.setTag(c1625f);
            m6910a(string, string4, enumC1455wM6358a, string3, j, c1625f, view);
        }
        if (i == -1) {
            c1625f.f6071j.setVisibility(0);
        } else {
            c1625f.f6071j.setVisibility(8);
        }
        view.setTag(c1625f);
    }

    /* renamed from: a */
    private void m6908a(int i, int i2, int i3, C1625f c1625f, long j, Cursor cursor) {
        this.f6059i.setTime(0L);
        if (i2 != 0) {
            c1625f.f6066e.setVisibility(8);
            return;
        }
        if (this.mCursor.getCount() > 1) {
            int position = this.mCursor.getPosition();
            if (this.mCursor.getPosition() != 0) {
                this.mCursor.moveToPosition(this.mCursor.getPosition() - 1);
            } else {
                this.mCursor.moveToPosition(this.mCursor.getPosition() + 1);
            }
            this.f6059i.setTime(this.mCursor.getLong(this.mCursor.getColumnIndex("message_time")));
            this.mCursor.moveToPosition(position);
        }
        this.f6057g.setTime(this.f6059i);
        if (this.mCursor.getPosition() == 0 || this.f6056f.get(1) != this.f6057g.get(1) || this.f6056f.get(2) != this.f6057g.get(2) || this.f6056f.get(5) != this.f6057g.get(5)) {
            c1625f.f6066e.setVisibility(0);
            c1625f.f6067f.setText(DateFormat.getDateFormat(CommonApplication.m11493l()).format(this.f6058h));
        } else {
            c1625f.f6066e.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m6910a(String str, String str2, EnumC1455w enumC1455w, String str3, long j, C1625f c1625f, View view) {
        c1625f.f6062a.setOnClickListener(this);
        EnumC1794a enumC1794aM7386c = EnumC1794a.TXT;
        String strValueOf = String.valueOf(enumC1455w.m6364a());
        boolean z = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1625f.f6062a.getLayoutParams();
        switch (C1624e.f6061a[enumC1455w.ordinal()]) {
            case 1:
            case 2:
                z = true;
                strValueOf = j + str3;
                m6909a(str, c1625f.f6064c);
                layoutParams.width = (int) C3172an.m11085a(55.0f);
                layoutParams.height = (int) C3172an.m11085a(55.0f);
                break;
            case 3:
                m6909a(str, c1625f.f6064c);
                layoutParams.width = (int) C3172an.m11085a(55.0f);
                layoutParams.height = (int) C3172an.m11085a(55.0f);
                break;
            case 4:
                strValueOf = j + str3;
                m6909a(str, c1625f.f6064c);
                layoutParams.width = (int) C3172an.m11085a(55.0f);
                layoutParams.height = (int) C3172an.m11085a(55.0f);
                break;
            case 5:
                c1625f.f6064c.setText(str2);
                c1625f.f6064c.setVisibility(0);
                layoutParams.width = (int) C3172an.m11085a(38.0f);
                layoutParams.height = (int) C3172an.m11085a(38.0f);
                break;
            case 6:
                c1625f.f6064c.setText(str2);
                c1625f.f6064c.setVisibility(0);
                layoutParams.width = (int) C3172an.m11085a(35.0f);
                layoutParams.height = (int) C3172an.m11085a(32.5f);
                break;
            case 7:
                c1625f.f6064c.setText(str2);
                c1625f.f6064c.setVisibility(0);
                layoutParams.width = (int) C3172an.m11085a(35.0f);
                layoutParams.height = (int) C3172an.m11085a(32.5f);
                break;
            case 8:
                m6909a(str, c1625f.f6064c);
                layoutParams.width = (int) C3172an.m11085a(35.0f);
                layoutParams.height = (int) C3172an.m11085a(32.5f);
                break;
            case 9:
            case 10:
                enumC1794aM7386c = FileExplorerActivity.m7386c(str2);
                c1625f.f6064c.setText(str2);
                c1625f.f6064c.setVisibility(0);
                layoutParams.width = (int) C3172an.m11085a(38.0f);
                layoutParams.height = (int) C3172an.m11085a(38.0f);
                break;
            case 11:
                c1625f.f6064c.setText(m6907a(str));
                c1625f.f6064c.setVisibility(0);
                layoutParams.width = (int) C3172an.m11085a(38.0f);
                layoutParams.height = (int) C3172an.m11085a(38.0f);
                break;
            case 12:
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM10151a = C2930k.m10151a(str);
                if (specialBuddyShareContentsEntryM10151a != null) {
                    c1625f.f6064c.setText(String.format("%s\n\n%s", specialBuddyShareContentsEntryM10151a.title, specialBuddyShareContentsEntryM10151a.name));
                    c1625f.f6064c.setVisibility(0);
                    layoutParams.width = (int) C3172an.m11085a(38.0f);
                    layoutParams.height = (int) C3172an.m11085a(38.0f);
                    break;
                }
                break;
            case 13:
                SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM10159c = C2930k.m10159c(str);
                if (specialBuddyRecommendBuddyEntryM10159c != null) {
                    c1625f.f6064c.setText(String.format("%s\n\n%s", CommonApplication.m11493l().getString(R.string.live_partner_bubble_title_recommend), specialBuddyRecommendBuddyEntryM10159c.name));
                    c1625f.f6064c.setVisibility(0);
                    layoutParams.width = (int) C3172an.m11085a(38.0f);
                    layoutParams.height = (int) C3172an.m11085a(38.0f);
                    break;
                }
                break;
        }
        c1625f.f6062a.setLayoutParams(layoutParams);
        this.f6055e.m11730a(c1625f.f6062a, new C1638s(strValueOf, str3, z, true, enumC1455w, enumC1794aM7386c, j));
    }

    /* renamed from: a */
    private String m6907a(String str) throws JSONException {
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
            String string = jSONObject.getJSONObject("message").getString("text");
            JSONObject jSONObject2 = jSONObject.getJSONObject("appInfo");
            String string2 = jSONObject2.getString("name");
            JSONArray jSONArray = jSONObject2.getJSONArray("param");
            String string3 = "";
            int i = 0;
            while (true) {
                if (i >= jSONArray.length()) {
                    z = false;
                    break;
                }
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                String string4 = jSONObject3.getString("OS");
                String string5 = jSONObject3.getString("deviceType");
                string3 = jSONObject3.getString("executeUri");
                if ("android".equalsIgnoreCase(string4) && "phone".equalsIgnoreCase(string5)) {
                    break;
                }
                i++;
            }
            return z ? string + "\n" + String.format(CommonApplication.m11493l().getResources().getString(R.string.applink_open_using), string2) : String.format("%s\n\n%s", string, string3);
        } catch (JSONException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    private void m6909a(String str, TextView textView) {
        String strM6911b = m6911b(str);
        if (TextUtils.isEmpty(strM6911b)) {
            textView.setVisibility(8);
        } else {
            textView.setText(C1835j.m7508a(this.f6052b, strM6911b, (int) C3172an.m11085a(30.0f)));
            textView.setVisibility(0);
        }
    }

    /* renamed from: b */
    private String m6911b(String str) {
        String[] strArr = new String[0];
        if (str != null) {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length > 6 && Query.MIXED.equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 6; i < strArrSplit.length; i++) {
                    stringBuffer.append(strArrSplit[i] + "\n");
                }
                return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
        }
        return null;
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f6053c.inflate(this.f6054d, viewGroup, false);
        C1625f c1625f = new C1625f();
        c1625f.f6062a = (ImageView) viewInflate.findViewById(R.id.image_thumb);
        c1625f.f6063b = (TextView) viewInflate.findViewById(R.id.title);
        c1625f.f6064c = (TextView) viewInflate.findViewById(R.id.message);
        c1625f.f6065d = (TextView) viewInflate.findViewById(R.id.time);
        c1625f.f6066e = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutDate);
        c1625f.f6067f = (TextView) viewInflate.findViewById(R.id.textDate);
        c1625f.f6068g = (LinearLayout) viewInflate.findViewById(R.id.image_layout);
        c1625f.f6071j = (ImageView) viewInflate.findViewById(R.id.errorIcon);
        viewInflate.setTag(c1625f);
        return viewInflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1625f c1625f = (C1625f) view.getTag();
        if (this.mCursor != null && !this.mCursor.isClosed() && this.mCursor.moveToPosition(c1625f.f6069h)) {
            this.f6060j.mo6896a(view, c1625f.f6069h, this.mCursor);
        }
    }
}
