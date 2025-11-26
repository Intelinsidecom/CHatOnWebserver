package com.sec.chaton.localbackup.chatview;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.C0266z;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.doc.EnumC2758b;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.specialbuddy.C4542g;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatViewAdapter.java */
/* renamed from: com.sec.chaton.localbackup.chatview.d */
/* loaded from: classes.dex */
public class ViewOnClickListenerC2525d extends C0266z implements View.OnClickListener {

    /* renamed from: m */
    private static final String[] f9095m = {"_id", "message_inbox_no", "message_sever_id", "message_session_id", "message_time", "message_content", "message_type", "message_sender", "message_is_failed", "buddy_name"};

    /* renamed from: n */
    private Context f9096n;

    /* renamed from: o */
    private LayoutInflater f9097o;

    /* renamed from: p */
    private int f9098p;

    /* renamed from: q */
    private C5007c f9099q;

    /* renamed from: r */
    private Calendar f9100r;

    /* renamed from: s */
    private Calendar f9101s;

    /* renamed from: t */
    private Date f9102t;

    /* renamed from: u */
    private Date f9103u;

    /* renamed from: v */
    private InterfaceC2528g f9104v;

    public ViewOnClickListenerC2525d(Context context, int i, Cursor cursor, C5007c c5007c, InterfaceC2528g interfaceC2528g) {
        super(context, i, cursor, f9095m, null, -1);
        this.f9096n = context;
        this.f9097o = (LayoutInflater) this.f9096n.getSystemService("layout_inflater");
        this.f9098p = i;
        this.f9099q = c5007c;
        this.f9100r = Calendar.getInstance();
        this.f9101s = Calendar.getInstance();
        this.f9102t = new Date();
        this.f9103u = new Date();
        this.f9104v = interfaceC2528g;
    }

    @Override // android.support.v4.widget.C0266z, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) throws NumberFormatException {
        C2527f c2527f = (C2527f) view.getTag();
        c2527f.f9113h = cursor.getPosition();
        long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
        EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        long j2 = cursor.getLong(cursor.getColumnIndex("message_time"));
        String string = cursor.getString(cursor.getColumnIndex("message_content"));
        int i = cursor.getInt(cursor.getColumnIndex("message_type"));
        String string2 = cursor.getString(cursor.getColumnIndex("message_sender"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        String string4 = cursor.getString(cursor.getColumnIndex("message_formatted"));
        int i2 = cursor.getInt(cursor.getColumnIndex("message_is_failed"));
        String string5 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        c2527f.f9114i = j;
        this.f9102t = new Date(j2);
        this.f9100r.setTime(this.f9102t);
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(string2)) {
            c2527f.f9107b.setText(R.string.setting_interaction_me);
        } else if (!TextUtils.isEmpty(string5)) {
            c2527f.f9107b.setText(string5);
        } else {
            c2527f.f9107b.setText(CommonApplication.m18732r().getString(R.string.unknown));
        }
        m10938a(cursor.getPosition(), i2, i, c2527f, j2, cursor);
        if (j2 == 0) {
            c2527f.f9109d.setVisibility(8);
        } else {
            c2527f.f9109d.setVisibility(0);
            c2527f.f9109d.setText(DateFormat.getTimeFormat(this.f9096n).format(new Date(j2)));
            this.f9100r.setTime(new Date(j2));
        }
        if (enumC2214abM10070a == EnumC2214ab.TEXT) {
            c2527f.f9112g.setVisibility(8);
            if (string != null) {
                c2527f.f9108c.setText(C2799k.m11709a(this.f9096n, string, (int) C5034k.m19088a(30.0f)));
            }
            c2527f.f9108c.setVisibility(0);
        } else {
            c2527f.f9112g.setVisibility(0);
            c2527f.f9106a.setTag(c2527f);
            m10940a(string, string4, enumC2214abM10070a, string3, j, c2527f, view);
        }
        if (i == -1) {
            c2527f.f9115j.setVisibility(0);
        } else {
            c2527f.f9115j.setVisibility(8);
        }
        view.setTag(c2527f);
    }

    /* renamed from: a */
    private void m10938a(int i, int i2, int i3, C2527f c2527f, long j, Cursor cursor) {
        this.f9103u.setTime(0L);
        if (i2 != 0) {
            c2527f.f9110e.setVisibility(8);
            return;
        }
        if (this.f579c.getCount() > 1) {
            int position = this.f579c.getPosition();
            if (this.f579c.getPosition() != 0) {
                this.f579c.moveToPosition(this.f579c.getPosition() - 1);
            } else {
                this.f579c.moveToPosition(this.f579c.getPosition() + 1);
            }
            this.f9103u.setTime(this.f579c.getLong(this.f579c.getColumnIndex("message_time")));
            this.f579c.moveToPosition(position);
        }
        this.f9101s.setTime(this.f9103u);
        if (this.f579c.getPosition() == 0 || this.f9100r.get(1) != this.f9101s.get(1) || this.f9100r.get(2) != this.f9101s.get(2) || this.f9100r.get(5) != this.f9101s.get(5)) {
            c2527f.f9110e.setVisibility(0);
            c2527f.f9111f.setText(DateFormat.getDateFormat(CommonApplication.m18732r()).format(this.f9102t));
        } else {
            c2527f.f9110e.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m10940a(String str, String str2, EnumC2214ab enumC2214ab, String str3, long j, C2527f c2527f, View view) throws NumberFormatException {
        String str4;
        boolean z;
        c2527f.f9106a.setOnClickListener(this);
        EnumC2758b enumC2758bM11581d = EnumC2758b.TXT;
        String strValueOf = String.valueOf(enumC2214ab.m10076a());
        boolean z2 = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c2527f.f9106a.getLayoutParams();
        switch (C2526e.f9105a[enumC2214ab.ordinal()]) {
            case 1:
            case 2:
                z2 = true;
                m10939a(str, c2527f.f9108c);
                layoutParams.width = (int) C5034k.m19088a(55.0f);
                layoutParams.height = (int) C5034k.m19088a(55.0f);
                str4 = j + str3;
                z = false;
                break;
            case 3:
                m10939a(str, c2527f.f9108c);
                layoutParams.width = (int) C5034k.m19088a(55.0f);
                layoutParams.height = (int) C5034k.m19088a(55.0f);
                str4 = strValueOf;
                z = false;
                break;
            case 4:
                m10939a(str, c2527f.f9108c);
                layoutParams.width = (int) C5034k.m19088a(55.0f);
                layoutParams.height = (int) C5034k.m19088a(55.0f);
                str4 = j + str3;
                z = false;
                break;
            case 5:
                try {
                    int i = Integer.parseInt(str2);
                    c2527f.f9108c.setText(String.format("%d:%02d/%d:%02d", 0, 0, Integer.valueOf(i / 60000), Integer.valueOf((i / 1000) % 60)));
                } catch (NumberFormatException e) {
                    c2527f.f9108c.setText(str2);
                }
                c2527f.f9108c.setVisibility(0);
                layoutParams.width = (int) C5034k.m19088a(38.0f);
                layoutParams.height = (int) C5034k.m19088a(38.0f);
                str4 = strValueOf;
                z = false;
                break;
            case 6:
                c2527f.f9108c.setText(str2);
                c2527f.f9108c.setVisibility(0);
                layoutParams.width = (int) C5034k.m19088a(35.0f);
                layoutParams.height = (int) C5034k.m19088a(32.5f);
                str4 = strValueOf;
                z = false;
                break;
            case 7:
                c2527f.f9108c.setText(str2);
                c2527f.f9108c.setVisibility(0);
                layoutParams.width = (int) C5034k.m19088a(35.0f);
                layoutParams.height = (int) C5034k.m19088a(32.5f);
                str4 = strValueOf;
                z = false;
                break;
            case 8:
                m10939a(str, c2527f.f9108c);
                layoutParams.width = (int) C5034k.m19088a(35.0f);
                layoutParams.height = (int) C5034k.m19088a(32.5f);
                str4 = strValueOf;
                z = false;
                break;
            case 9:
            case 10:
                enumC2758bM11581d = FileExplorerActivity.m11581d(str2);
                c2527f.f9108c.setText(str2);
                c2527f.f9108c.setVisibility(0);
                layoutParams.width = (int) C5034k.m19088a(38.0f);
                layoutParams.height = (int) C5034k.m19088a(38.0f);
                str4 = strValueOf;
                z = false;
                break;
            case 11:
                c2527f.f9108c.setText(m10942c(str));
                c2527f.f9108c.setVisibility(0);
                layoutParams.width = (int) C5034k.m19088a(38.0f);
                layoutParams.height = (int) C5034k.m19088a(38.0f);
                str4 = strValueOf;
                z = false;
                break;
            case 12:
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM17227a = C4542g.m17227a(str);
                if (specialBuddyShareContentsEntryM17227a != null) {
                    c2527f.f9108c.setText(String.format("%s\n\n%s\n\n%s", CommonApplication.m18732r().getString(R.string.live), specialBuddyShareContentsEntryM17227a.title, specialBuddyShareContentsEntryM17227a.name));
                    c2527f.f9108c.setVisibility(0);
                    layoutParams.width = (int) C5034k.m19088a(38.0f);
                    layoutParams.height = (int) C5034k.m19088a(38.0f);
                }
                c2527f.f9112g.setVisibility(8);
                str4 = strValueOf;
                z = true;
                break;
            case 13:
                SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM17238c = C4542g.m17238c(str);
                if (specialBuddyRecommendBuddyEntryM17238c != null) {
                    c2527f.f9108c.setText(String.format("%s\n\n%s", CommonApplication.m18732r().getString(R.string.add_buddy_live_recommendation), specialBuddyRecommendBuddyEntryM17238c.name));
                    c2527f.f9108c.setVisibility(0);
                    layoutParams.width = (int) C5034k.m19088a(38.0f);
                    layoutParams.height = (int) C5034k.m19088a(38.0f);
                }
                c2527f.f9112g.setVisibility(8);
                str4 = strValueOf;
                z = true;
                break;
            case 14:
                c2527f.f9112g.setVisibility(8);
                str4 = strValueOf;
                z = true;
                break;
            case 15:
                c2527f.f9108c.setText(String.format("%s\n\n%s", CommonApplication.m18732r().getString(R.string.hugefile_large_file), m10937a(str)));
                c2527f.f9108c.setVisibility(0);
                c2527f.f9112g.setVisibility(8);
                str4 = strValueOf;
                z = true;
                break;
            case 16:
                c2527f.f9108c.setText(String.format("%s\n\n%s", CommonApplication.m18732r().getString(R.string.glympse_title), m10941b(str)));
                c2527f.f9108c.setVisibility(0);
                c2527f.f9112g.setVisibility(8);
                str4 = strValueOf;
                z = true;
                break;
            default:
                str4 = strValueOf;
                z = false;
                break;
        }
        if (!z) {
            c2527f.f9106a.setLayoutParams(layoutParams);
            this.f9099q.m19023b(c2527f.f9106a, new C2540s(str4, str3, z2, true, enumC2214ab, enumC2758bM11581d, j));
        }
    }

    /* renamed from: a */
    private String m10937a(String str) {
        if (str != null) {
            String[] strArrSplit = str.split("\n");
            StringBuilder sb = new StringBuilder();
            if (strArrSplit.length > 6) {
                for (int i = 6; i < strArrSplit.length; i++) {
                    sb.append(strArrSplit[i] + "\n");
                }
                return sb.toString().substring(0, sb.length() - 1);
            }
        }
        return null;
    }

    /* renamed from: b */
    private String m10941b(String str) {
        if (str != null) {
            String[] strArrSplit = str.split("\n");
            StringBuilder sb = new StringBuilder();
            if (strArrSplit.length > 5) {
                for (int i = 5; i < strArrSplit.length; i++) {
                    sb.append(strArrSplit[i] + "\n");
                }
                return sb.toString().substring(0, sb.length() - 1);
            }
        }
        return null;
    }

    /* renamed from: c */
    private String m10942c(String str) throws JSONException {
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
            String string = jSONObject.getJSONObject(VKApiConst.MESSAGE).getString("text");
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
            return z ? string + "\n" + String.format(CommonApplication.m18732r().getResources().getString(R.string.applink_open_using), string2) : String.format("%s\n\n%s", string, string3);
        } catch (JSONException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    private void m10939a(String str, TextView textView) {
        String strM10943d = m10943d(str);
        if (TextUtils.isEmpty(strM10943d)) {
            textView.setVisibility(8);
        } else {
            textView.setText(C2799k.m11709a(this.f9096n, strM10943d, (int) C5034k.m19088a(30.0f)));
            textView.setVisibility(0);
        }
    }

    /* renamed from: d */
    private String m10943d(String str) {
        String[] strArr = new String[0];
        if (str != null) {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length > 6 && "mixed".equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 6; i < strArrSplit.length; i++) {
                    stringBuffer.append(strArrSplit[i] + "\n");
                }
                return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
        }
        return null;
    }

    @Override // android.support.v4.widget.AbstractC0259s, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f9097o.inflate(this.f9098p, viewGroup, false);
        C2527f c2527f = new C2527f();
        c2527f.f9106a = (ImageView) viewInflate.findViewById(R.id.image_thumb);
        c2527f.f9107b = (TextView) viewInflate.findViewById(R.id.title);
        c2527f.f9108c = (TextView) viewInflate.findViewById(R.id.message);
        c2527f.f9109d = (TextView) viewInflate.findViewById(R.id.time);
        c2527f.f9110e = (RelativeLayout) viewInflate.findViewById(R.id.lLayoutDate);
        c2527f.f9111f = (TextView) viewInflate.findViewById(R.id.textDate);
        c2527f.f9112g = (LinearLayout) viewInflate.findViewById(R.id.image_layout);
        c2527f.f9115j = (ImageView) viewInflate.findViewById(R.id.errorIcon);
        viewInflate.setTag(c2527f);
        return viewInflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C2527f c2527f = (C2527f) view.getTag();
        if (this.f579c != null && !this.f579c.isClosed() && this.f579c.moveToPosition(c2527f.f9113h)) {
            this.f9104v.mo10926a(view, c2527f.f9113h, this.f579c);
        }
    }
}
