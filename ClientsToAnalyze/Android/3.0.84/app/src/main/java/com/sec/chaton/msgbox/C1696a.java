package com.sec.chaton.msgbox;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p035io.entry.ApplinkMsgEntry;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3178at;
import com.sec.chaton.util.C3180av;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.CheckableRelativeLayout;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import com.sec.spp.push.Config;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Query;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.a */
/* loaded from: classes.dex */
public class C1696a extends SimpleCursorAdapter {

    /* renamed from: a */
    public static final String[] f6324a = {"_id", "inbox_no", "inbox_chat_type", "inbox_participants", "inbox_title", "inbox_unread_count", "inbox_last_time", "inbox_translated", "inbox_last_message", "inbox_session_id", "inbox_title_fixed"};

    /* renamed from: f */
    private static int f6325f = 0;

    /* renamed from: b */
    public ArrayList<Integer> f6326b;

    /* renamed from: c */
    InterfaceC1378v f6327c;

    /* renamed from: d */
    private LayoutInflater f6328d;

    /* renamed from: e */
    private int f6329e;

    /* renamed from: g */
    private ArrayList<C3180av> f6330g;

    /* renamed from: h */
    private ArrayList<String> f6331h;

    /* renamed from: i */
    private String f6332i;

    /* renamed from: j */
    private String f6333j;

    /* renamed from: k */
    private boolean f6334k;

    /* renamed from: l */
    private boolean f6335l;

    /* renamed from: m */
    private InterfaceC1716c f6336m;

    /* renamed from: a */
    public void m7126a(C3326c c3326c) {
    }

    public C1696a(Context context, ListView listView, int i, Cursor cursor, C3326c c3326c, SlookAirButton.ItemSelectListener itemSelectListener) {
        super(context, i, cursor, f6324a, null, -1);
        this.f6332i = null;
        this.f6334k = false;
        this.f6335l = false;
        this.f6327c = new C1715b(this);
        this.f6328d = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f6329e = i;
        this.f6326b = new ArrayList<>();
        f6325f = -1;
    }

    public C1696a(Context context, int i, Cursor cursor) {
        super(context, i, cursor, f6324a, null, -1);
        this.f6332i = null;
        this.f6334k = false;
        this.f6335l = false;
        this.f6327c = new C1715b(this);
        this.f6328d = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f6329e = i;
    }

    /* renamed from: a */
    public void m7124a(InterfaceC1714ar interfaceC1714ar) {
    }

    /* renamed from: a */
    public void m7122a() {
    }

    /* renamed from: a */
    public void m7127a(String str) {
        this.f6332i = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7121a(String str, String str2) {
        if (str.startsWith("0999")) {
            if (GlobalApplication.m6456e()) {
                Intent intent = new Intent(this.mContext, (Class<?>) SpecialBuddyActivity.class);
                intent.putExtra("specialuserid", str);
                intent.putExtra("speicalusername", str2);
                this.mContext.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(this.mContext, (Class<?>) SpecialBuddyDialog.class);
            intent2.putExtra("specialuserid", str);
            intent2.putExtra("speicalusername", str2);
            intent2.setFlags(67108864);
            this.mContext.startActivity(intent2);
            return;
        }
        if (GlobalApplication.m6456e()) {
            Intent intent3 = new Intent(this.mContext, (Class<?>) BuddyProfileActivity.class);
            intent3.putExtra("PROFILE_BUDDY_NO", str);
            intent3.putExtra("PROFILE_BUDDY_NAME", str2);
            intent3.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
            this.mContext.startActivity(intent3);
            return;
        }
        Intent intent4 = new Intent(this.mContext, (Class<?>) BuddyDialog.class);
        intent4.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
        intent4.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
        intent4.setFlags(67108864);
        this.mContext.startActivity(intent4);
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
        boolean zEquals;
        cursor.getPosition();
        String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_unread_count"));
        String string3 = cursor.getString(cursor.getColumnIndex("inbox_trunk_unread_count"));
        String string4 = cursor.getString(cursor.getColumnIndex("inbox_last_message"));
        String string5 = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
        String string6 = cursor.getString(cursor.getColumnIndex("inbox_title"));
        String string7 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        long j = cursor.getLong(cursor.getColumnIndex("inbox_last_time"));
        String string8 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        String string9 = cursor.getString(cursor.getColumnIndex("relation_buddy_no"));
        String str = (TextUtils.isEmpty(string9) || string9.equals(string8)) ? null : string9;
        boolean zEquals2 = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
        C1717d c1717d = (C1717d) view.getTag();
        if (string4 != null) {
            String[] strArrSplit = string4.split(Config.KEYVALUE_SPLIT);
            String str2 = null;
            if (strArrSplit.length > 2) {
                str2 = strArrSplit[2];
            }
            if (strArrSplit.length >= 2) {
                int i3 = Integer.parseInt(strArrSplit[0]);
                EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(Integer.parseInt(strArrSplit[1]));
                if ((i3 == 1 || i3 == 2) && enumC1455wM6358a != EnumC1455w.SYSTEM) {
                    if (C3159aa.m10962a().m10979a("chaton_id", "").equals(string5)) {
                        if (TextUtils.isEmpty(str2)) {
                            zEquals = false;
                        } else {
                            zEquals = Query.MIXED.equals(str2.split("\n")[0]);
                        }
                        string4 = EnumC1455w.m6363a(enumC1455wM6358a, strArrSplit, zEquals);
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
                            string4 = strM5323b4 + ": " + strM5323b7;
                        } else if (enumC1455wM6358a == EnumC1455w.APPLINK) {
                            if (strArrSplit.length < 3) {
                                strM5323b6 = "";
                            } else {
                                strM5323b6 = C1075eq.m5323b(strArrSplit[2]);
                            }
                            string4 = strM5323b4 + ": " + ApplinkMsgEntry.getDisplayMessage(strM5323b6);
                        } else if (enumC1455wM6358a == EnumC1455w.POLL) {
                            String string10 = "";
                            if (strArrSplit.length < 3) {
                                strM5323b5 = "";
                            } else {
                                strM5323b5 = C1075eq.m5323b(strArrSplit[2]);
                            }
                            try {
                                if (new JSONObject(strM5323b5).getJSONObject("push_message").getString("content_type").equals("result")) {
                                    string10 = CommonApplication.m11493l().getString(R.string.poll_result_now_available);
                                } else {
                                    string10 = CommonApplication.m11493l().getString(R.string.poll_title);
                                }
                            } catch (JSONException e) {
                                C3250y.m11443a(e, getClass().getSimpleName());
                            }
                            string4 = strM5323b4 + ":" + string10;
                        } else {
                            boolean zEquals3 = false;
                            if (!TextUtils.isEmpty(str2)) {
                                zEquals3 = Query.MIXED.equals(str2.split("\n")[0]);
                            }
                            string4 = strM5323b4 + ": " + EnumC1455w.m6362a(enumC1455wM6358a, str2, zEquals3);
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
                        string4 = strM5323b3;
                    } else if (enumC1455wM6358a == EnumC1455w.APPLINK) {
                        if (strArrSplit.length < 3) {
                            strM5323b2 = "";
                        } else {
                            strM5323b2 = C1075eq.m5323b(strArrSplit[2]);
                        }
                        string4 = ApplinkMsgEntry.getDisplayMessage(strM5323b2);
                    } else if (enumC1455wM6358a == EnumC1455w.POLL) {
                        String string11 = "";
                        if (strArrSplit.length < 3) {
                            strM5323b = "";
                        } else {
                            strM5323b = C1075eq.m5323b(strArrSplit[2]);
                        }
                        try {
                            if (new JSONObject(strM5323b).getJSONObject("push_message").getString("content_type").equals("result")) {
                                string11 = CommonApplication.m11493l().getString(R.string.poll_result_now_available);
                            } else {
                                string11 = CommonApplication.m11493l().getString(R.string.poll_title);
                            }
                        } catch (JSONException e2) {
                            C3250y.m11443a(e2, getClass().getSimpleName());
                        }
                        string4 = string11;
                    } else {
                        boolean zEquals4 = false;
                        if (!TextUtils.isEmpty(str2)) {
                            zEquals4 = Query.MIXED.equals(str2.split("\n")[0]);
                        }
                        string4 = EnumC1455w.m6362a(enumC1455wM6358a, str2, zEquals4);
                    }
                }
            }
            if (string4 == null) {
                c1717d.f6361b.setText(string4, TextView.BufferType.NORMAL);
            } else {
                float f = 1.2f;
                if (GlobalApplication.m6451b().getDisplayMetrics().density >= 2.0f) {
                    f = 1.0f;
                }
                c1717d.f6361b.setText(C1835j.m7508a(this.mContext, string4, (int) (f * c1717d.f6361b.getLineHeight())), TextView.BufferType.NORMAL);
            }
            if (c1717d.f6362c != null) {
                if (string2 == null || string2.length() == 0 || Integer.parseInt(string2) == 0) {
                    c1717d.f6362c.setVisibility(8);
                } else {
                    c1717d.f6362c.setVisibility(0);
                    if (string2.length() >= 3) {
                        c1717d.f6362c.setText(R.string.chat_max_unread);
                    } else {
                        c1717d.f6362c.setText(string2);
                    }
                }
            }
            if (c1717d.f6363d != null) {
                if (string3 == null || string3.length() == 0 || Integer.parseInt(string3) == 0) {
                    c1717d.f6363d.setVisibility(8);
                } else {
                    c1717d.f6363d.setVisibility(0);
                    if (string3.length() >= 3) {
                        c1717d.f6363d.setText(R.string.chat_max_unread);
                    } else {
                        c1717d.f6363d.setText(string3);
                    }
                }
            }
        } else {
            c1717d.f6361b.setText(string4, TextView.BufferType.NORMAL);
            if (c1717d.f6362c != null) {
                if (string2 == null || string2.length() == 0 || Integer.parseInt(string2) == 0) {
                    c1717d.f6362c.setVisibility(8);
                } else {
                    c1717d.f6362c.setVisibility(0);
                    if (string2.length() >= 3) {
                        c1717d.f6362c.setText(R.string.chat_max_unread);
                    } else {
                        c1717d.f6362c.setText(string2);
                    }
                }
            }
            if (c1717d.f6363d != null) {
                if (string3 == null || string3.length() == 0 || Integer.parseInt(string3) == 0) {
                    c1717d.f6363d.setVisibility(8);
                } else {
                    c1717d.f6363d.setVisibility(0);
                    if (string3.length() >= 3) {
                        c1717d.f6363d.setText(R.string.chat_max_unread);
                    } else {
                        c1717d.f6363d.setText(string3);
                    }
                }
            }
        }
        c1717d.f6360a.setVisibility(0);
        c1717d.f6365f.setVisibility(0);
        c1717d.f6365f.setText("");
        if (i == EnumC1450r.GROUPCHAT.m6342a()) {
            if (!string7.equals("Y") && i2 <= 0) {
                c1717d.f6360a.setText(GlobalApplication.m6451b().getString(R.string.chat_title_no_buddies), TextView.BufferType.SPANNABLE);
            } else {
                c1717d.f6360a.setText(string6, TextView.BufferType.SPANNABLE);
            }
            if (i2 >= 10) {
                c1717d.f6360a.setPadding(0, 0, 5, 0);
            } else {
                c1717d.f6360a.setPadding(0, 0, 0, 0);
            }
            c1717d.f6365f.setText(" (" + (i2 + 1) + ")");
        } else if (EnumC1450r.m6340a(EnumC1450r.m6339a(i))) {
            c1717d.f6360a.setText(C1075eq.m5320a(string7, string6, i2), TextView.BufferType.SPANNABLE);
            if (i2 >= 10) {
                c1717d.f6360a.setPadding(0, 0, 5, 0);
            } else {
                c1717d.f6360a.setPadding(0, 0, 0, 0);
            }
            if (i2 > 0) {
                c1717d.f6365f.setText(" (" + i2 + ")");
            } else {
                c1717d.f6365f.setText("");
            }
        } else {
            c1717d.f6360a.setText(string6, TextView.BufferType.SPANNABLE);
        }
        if (this.f6333j != null && this.f6333j.length() > 0) {
            if (C3178at.m11103a().m11118c(c1717d.f6360a.getText().toString().toLowerCase())) {
                this.f6330g = C3178at.m11103a().m11117a(c1717d.f6360a.getText().toString());
                C3178at.m11103a();
                C3178at.m11109a(this.f6330g, this.f6333j.toString().toLowerCase());
                this.f6331h = new ArrayList<>();
                String string12 = c1717d.f6360a.getText().toString();
                C3178at.m11103a();
                String strSubstring = string12.substring(C3178at.m11115d());
                this.f6330g = C3178at.m11103a().m11117a(strSubstring);
                this.f6331h.add(c1717d.f6360a.getText().toString().replace(strSubstring, ""));
                C3178at.m11103a();
                if (C3178at.m11110b() != -1) {
                    Spannable spannable = (Spannable) c1717d.f6360a.getText();
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(GlobalApplication.m6451b().getColor(R.color.buddy_list_item_status_highlight));
                    C3178at.m11103a();
                    int iM11110b = C3178at.m11110b();
                    C3178at.m11103a();
                    int iM11115d = iM11110b + C3178at.m11115d();
                    C3178at.m11103a();
                    int iM11114c = C3178at.m11114c();
                    C3178at.m11103a();
                    spannable.setSpan(foregroundColorSpan, iM11115d, iM11114c + C3178at.m11115d() + 1, 33);
                    c1717d.f6360a.setText(spannable);
                    C3178at.m11103a();
                    C3178at.m11116e();
                }
            } else {
                int iIndexOf = c1717d.f6360a.getText().toString().toLowerCase().indexOf(this.f6333j.toString().toLowerCase());
                if (iIndexOf >= 0) {
                    int length = this.f6333j.length() + c1717d.f6360a.getText().toString().toLowerCase().indexOf(this.f6333j.toString().toLowerCase());
                    Spannable spannable2 = (Spannable) c1717d.f6360a.getText();
                    spannable2.setSpan(new ForegroundColorSpan(GlobalApplication.m6451b().getColor(R.color.buddy_list_item_status_highlight)), iIndexOf, length, 33);
                    c1717d.f6360a.setText(spannable2);
                }
            }
        }
        c1717d.f6364e.setVisibility(0);
        if (c1717d.f6364e != null && j != 0) {
            c1717d.f6364e.setText(m7119a(j));
        } else {
            c1717d.f6364e.setText("");
        }
        if (i == EnumC1450r.ONETOONE.m6342a() && !TextUtils.isEmpty(string8)) {
            C3205bt.m11182a(this.mContext).m11210a(c1717d.f6366g, string8);
        } else {
            C3205bt.m11182a(this.mContext).m11213a(c1717d.f6366g, string, str, EnumC1450r.m6339a(i));
        }
        if (zEquals2) {
            c1717d.f6368i.setVisibility(8);
        } else {
            c1717d.f6368i.setVisibility(0);
        }
        if (GlobalApplication.m6456e() && !this.f6335l) {
            if (this.f6332i != null && this.f6332i.equals(string)) {
                if (this.f6334k) {
                    c1717d.f6372m.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_arrow_pressed_holo_light);
                } else {
                    c1717d.f6372m.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_arrow_holo_light);
                }
                c1717d.f6372m.setVisibility(0);
                c1717d.f6373n.setVisibility(8);
            } else {
                if (this.f6334k) {
                    c1717d.f6373n.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_pressed_holo_light);
                } else {
                    c1717d.f6373n.setBackgroundResource(R.drawable.tablet_tw_preference_contents_list_no_arrow_left_holo_light);
                }
                c1717d.f6372m.setVisibility(8);
                c1717d.f6373n.setVisibility(0);
            }
        }
        view.setTag(c1717d);
    }

    /* renamed from: a */
    private String m7119a(long j) {
        if (new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis())).equals(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j)))) {
            return DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(j));
        }
        return DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j));
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        CheckableRelativeLayout checkableRelativeLayout = (CheckableRelativeLayout) this.f6328d.inflate(this.f6329e, (ViewGroup) null);
        C1717d c1717d = new C1717d();
        c1717d.f6369j = (FrameLayout) checkableRelativeLayout.findViewById(R.id.space1);
        c1717d.f6369j.setVisibility(0);
        c1717d.f6370k = (FrameLayout) checkableRelativeLayout.findViewById(R.id.space3);
        c1717d.f6371l = (FrameLayout) checkableRelativeLayout.findViewById(R.id.space4);
        View viewInflate = this.f6328d.inflate(R.layout.msgbox_list_item_unreadcoount, c1717d.f6370k);
        View viewInflate2 = this.f6328d.inflate(R.layout.msgbox_list_item_message_last_time, c1717d.f6371l);
        viewInflate.setVisibility(0);
        viewInflate2.setVisibility(0);
        c1717d.f6360a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        c1717d.f6361b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        c1717d.f6362c = (TextView) checkableRelativeLayout.findViewById(R.id.chatRoomUnReadCount);
        c1717d.f6363d = (TextView) checkableRelativeLayout.findViewById(R.id.chatRoomTrunkUnReadCount);
        c1717d.f6366g = (ImageView) checkableRelativeLayout.findViewById(R.id.image1);
        c1717d.f6364e = (TextView) checkableRelativeLayout.findViewById(R.id.chatRoomLastMessageTime);
        c1717d.f6365f = (TextView) checkableRelativeLayout.findViewById(R.id.chatRoomParticipantsCount);
        c1717d.f6367h = checkableRelativeLayout;
        c1717d.f6368i = (ImageView) checkableRelativeLayout.findViewById(R.id.chatRoomMessageAlert);
        if (GlobalApplication.m6456e()) {
            int paddingLeft = checkableRelativeLayout.getPaddingLeft();
            int paddingTop = checkableRelativeLayout.getPaddingTop();
            int paddingRight = checkableRelativeLayout.getPaddingRight();
            int paddingBottom = checkableRelativeLayout.getPaddingBottom();
            c1717d.f6374o = (TableLayout) checkableRelativeLayout.findViewById(R.id.content);
            c1717d.f6374o.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            c1717d.f6367h.setBackgroundResource(R.drawable.tablet_listview_selector);
            c1717d.f6372m = checkableRelativeLayout.findViewById(R.id.chat_selector);
            c1717d.f6373n = checkableRelativeLayout.findViewById(R.id.chat_unselector);
        }
        checkableRelativeLayout.setChoiceMode(f6325f);
        checkableRelativeLayout.setTag(c1717d);
        return checkableRelativeLayout;
    }

    /* renamed from: b */
    public void m7129b(String str) {
        this.f6333j = str;
    }

    /* renamed from: a */
    public void m7128a(boolean z) {
        this.f6334k = z;
    }

    /* renamed from: a */
    public void m7125a(InterfaceC1716c interfaceC1716c) {
        this.f6336m = interfaceC1716c;
    }

    /* renamed from: a */
    public void m7123a(int i) {
        f6325f = i;
    }

    /* renamed from: b */
    public void m7130b(boolean z) {
        this.f6335l = z;
    }
}
