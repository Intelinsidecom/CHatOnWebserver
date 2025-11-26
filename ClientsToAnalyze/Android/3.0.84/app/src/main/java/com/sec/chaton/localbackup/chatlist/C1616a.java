package com.sec.chaton.localbackup.chatlist;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p035io.entry.ApplinkMsgEntry;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.AdaptableTextView;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Query;

/* compiled from: BackupChatListAdapter.java */
/* renamed from: com.sec.chaton.localbackup.chatlist.a */
/* loaded from: classes.dex */
public class C1616a extends SimpleCursorAdapter {

    /* renamed from: a */
    public static final String[] f6017a = {"_id", "inbox_no", "inbox_chat_type", "inbox_participants", "inbox_title", "inbox_unread_count", "inbox_last_time", "inbox_translated", "inbox_last_message", "inbox_session_id", "inbox_title_fixed"};

    /* renamed from: b */
    private Context f6018b;

    /* renamed from: c */
    private LayoutInflater f6019c;

    /* renamed from: d */
    private int f6020d;

    public C1616a(Context context, int i, Cursor cursor) {
        super(context, i, cursor, f6017a, null, -1);
        this.f6018b = context;
        this.f6019c = (LayoutInflater) this.f6018b.getSystemService("layout_inflater");
        this.f6020d = i;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws Resources.NotFoundException, NumberFormatException {
        String strM5323b;
        String strM5323b2;
        String strM5323b3;
        String strM5323b4;
        String strM5323b5;
        String strM5323b6;
        String strM5323b7;
        C1618c c1618c = (C1618c) view.getTag();
        int i = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        String string = cursor.getString(cursor.getColumnIndex("inbox_last_message"));
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_title"));
        String string3 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        long j = cursor.getLong(cursor.getColumnIndex("inbox_last_time"));
        c1618c.f6023b.setText(string2);
        if (j > 0) {
            c1618c.f6025d.setText(m6863a(j));
        } else {
            c1618c.f6025d.setText((CharSequence) null);
        }
        if (string != null) {
            String[] strArrSplit = string.split(Config.KEYVALUE_SPLIT);
            String str = "";
            if (strArrSplit.length > 2) {
                str = strArrSplit[2];
            }
            if (strArrSplit.length >= 2) {
                int i3 = Integer.parseInt(strArrSplit[0]);
                EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(Integer.parseInt(strArrSplit[1]));
                if ((i3 == 1 || i3 == 2) && enumC1455wM6358a != EnumC1455w.SYSTEM) {
                    if (i3 == 1) {
                        string = EnumC1455w.m6363a(enumC1455wM6358a, strArrSplit, Query.MIXED.equals(str.split("\n")[0]));
                    } else if (EnumC1450r.m6339a(i) == EnumC1450r.GROUPCHAT) {
                        if (strArrSplit.length < 4) {
                            strM5323b4 = GlobalApplication.m6451b().getString(R.string.unknown);
                        } else {
                            strM5323b4 = C1075eq.m5323b(strArrSplit[3]);
                        }
                        if (enumC1455wM6358a == EnumC1455w.TEXT) {
                            if (strArrSplit.length < 3) {
                                strM5323b7 = "";
                            } else {
                                strM5323b7 = C1075eq.m5323b(strArrSplit[2]);
                                if (C1075eq.m5326c(strM5323b7)) {
                                    strM5323b7 = new StringBuilder(strM5323b7).substring(1);
                                }
                            }
                            string = strM5323b4 + ": " + strM5323b7;
                        } else if (enumC1455wM6358a == EnumC1455w.APPLINK) {
                            if (strArrSplit.length < 3) {
                                strM5323b6 = "";
                            } else {
                                strM5323b6 = C1075eq.m5323b(strArrSplit[2]);
                            }
                            string = strM5323b4 + ": " + ApplinkMsgEntry.getDisplayMessage(strM5323b6);
                        } else if (enumC1455wM6358a == EnumC1455w.POLL) {
                            String string4 = "";
                            if (strArrSplit.length < 3) {
                                strM5323b5 = "";
                            } else {
                                strM5323b5 = C1075eq.m5323b(strArrSplit[2]);
                            }
                            try {
                                if (new JSONObject(strM5323b5).getJSONObject("push_message").getString("content_type").equals("result")) {
                                    string4 = CommonApplication.m11493l().getString(R.string.poll_result_now_available);
                                } else {
                                    string4 = CommonApplication.m11493l().getString(R.string.poll_title);
                                }
                            } catch (JSONException e) {
                                C3250y.m11443a(e, getClass().getSimpleName());
                            }
                            string = strM5323b4 + ":" + string4;
                        } else {
                            string = strM5323b4 + ": " + EnumC1455w.m6362a(enumC1455wM6358a, str, Query.MIXED.equals(str.split("\n")[0]));
                        }
                    } else if (enumC1455wM6358a == EnumC1455w.TEXT) {
                        if (strArrSplit.length < 3) {
                            strM5323b3 = "";
                        } else {
                            strM5323b3 = C1075eq.m5323b(strArrSplit[2]);
                            if (C1075eq.m5326c(strM5323b3)) {
                                strM5323b3 = new StringBuilder(strM5323b3).substring(1);
                            }
                        }
                        string = strM5323b3;
                    } else if (enumC1455wM6358a == EnumC1455w.APPLINK) {
                        if (strArrSplit.length < 3) {
                            strM5323b2 = "";
                        } else {
                            strM5323b2 = C1075eq.m5323b(strArrSplit[2]);
                        }
                        string = ApplinkMsgEntry.getDisplayMessage(strM5323b2);
                    } else if (enumC1455wM6358a == EnumC1455w.POLL) {
                        String string5 = "";
                        if (strArrSplit.length < 3) {
                            strM5323b = "";
                        } else {
                            strM5323b = C1075eq.m5323b(strArrSplit[2]);
                        }
                        try {
                            if (new JSONObject(strM5323b).getJSONObject("push_message").getString("content_type").equals("result")) {
                                string5 = CommonApplication.m11493l().getString(R.string.poll_result_now_available);
                            } else {
                                string5 = CommonApplication.m11493l().getString(R.string.poll_title);
                            }
                        } catch (JSONException e2) {
                            C3250y.m11443a(e2, getClass().getSimpleName());
                        }
                        string = string5;
                    } else {
                        string = EnumC1455w.m6362a(enumC1455wM6358a, str, Query.MIXED.equals(str.split("\n")[0]));
                    }
                }
            }
        }
        if (string == null) {
            c1618c.f6024c.setText(string, TextView.BufferType.NORMAL);
        } else {
            float f = 1.2f;
            if (GlobalApplication.m6451b().getDisplayMetrics().density >= 2.0f) {
                f = 1.0f;
            }
            c1618c.f6024c.setText(C1835j.m7508a(this.f6018b, string, (int) (f * c1618c.f6024c.getLineHeight())), TextView.BufferType.NORMAL);
        }
        switch (EnumC1450r.m6339a(i)) {
            case ONETOONE:
                c1618c.f6022a.setImageResource(R.drawable.contacts_default_01);
                c1618c.f6026e.setVisibility(4);
                break;
            case GROUPCHAT:
                c1618c.f6022a.setImageResource(R.drawable.contacts_default_group);
                if (!string3.equals("Y") && i2 <= 0) {
                    c1618c.f6023b.setText(GlobalApplication.m6451b().getString(R.string.chat_title_no_buddies));
                    break;
                } else {
                    c1618c.f6023b.setText(string2);
                    c1618c.f6026e.setVisibility(0);
                    c1618c.f6026e.setText("(" + (i2 + 1) + ")");
                    break;
                }
            case BROADCAST:
            case BROADCAST2:
                c1618c.f6022a.setImageResource(R.drawable.chat_ic_broadcast);
                c1618c.f6023b.setText(C1075eq.m5320a(string3, string2, i2));
                c1618c.f6026e.setVisibility(0);
                if (i2 > 0) {
                    c1618c.f6026e.setText("(" + i2 + ")");
                    break;
                } else {
                    c1618c.f6026e.setText("");
                    break;
                }
            default:
                c1618c.f6022a.setImageResource(R.drawable.contacts_default_01);
                break;
        }
        view.setTag(c1618c);
    }

    /* renamed from: a */
    private String m6863a(long j) {
        if (new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis())).equals(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j)))) {
            return DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(j));
        }
        return DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j));
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f6019c.inflate(this.f6020d, viewGroup, false);
        C1618c c1618c = new C1618c();
        c1618c.f6022a = (ImageView) viewInflate.findViewById(R.id.image1);
        c1618c.f6023b = (TextView) viewInflate.findViewById(R.id.text1);
        c1618c.f6024c = (TextView) viewInflate.findViewById(R.id.text2);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.space3);
        frameLayout.setVisibility(0);
        LinearLayout linearLayout = new LinearLayout(this.f6018b);
        AdaptableTextView adaptableTextView = new AdaptableTextView(this.f6018b);
        adaptableTextView.setTextAppearance(this.f6018b, R.style.TextAppearance_List01_Variable);
        adaptableTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        c1618c.f6026e = adaptableTextView;
        AdaptableTextView adaptableTextView2 = new AdaptableTextView(this.f6018b);
        adaptableTextView2.setTextAppearance(this.f6018b, R.style.TextAppearance_List07_Variable);
        c1618c.f6025d = adaptableTextView2;
        linearLayout.setOrientation(0);
        linearLayout.addView(adaptableTextView);
        linearLayout.addView(adaptableTextView2);
        frameLayout.addView(linearLayout);
        viewInflate.setTag(c1618c);
        return viewInflate;
    }
}
