package com.sec.chaton.msgbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.p034a.C0760c;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1301ax;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.ProfileImageView;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.a */
/* loaded from: classes.dex */
public class C0736a extends SimpleCursorAdapter {

    /* renamed from: a */
    public static final String[] f2521a = {"_id", "inbox_no", "inbox_chat_type", "inbox_participants", "inbox_title", "inbox_unread_count", "inbox_last_time", "inbox_translated", "inbox_last_message", "inbox_session_id", "inbox_title_fixed"};

    /* renamed from: b */
    InterfaceC0626f f2522b;

    /* renamed from: c */
    private LayoutInflater f2523c;

    /* renamed from: d */
    private ListView f2524d;

    /* renamed from: e */
    private Display f2525e;

    /* renamed from: f */
    private boolean f2526f;

    /* renamed from: g */
    private String f2527g;

    /* renamed from: h */
    private InterfaceC0756u f2528h;

    /* renamed from: i */
    private int f2529i;

    /* renamed from: j */
    private C0630j f2530j;

    public C0736a(Context context, ListView listView, int i, Cursor cursor) {
        super(context, i, cursor, f2521a, null, -1);
        this.f2526f = false;
        this.f2527g = null;
        this.f2522b = new C0745j(this);
        this.f2523c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f2524d = listView;
        this.f2525e = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        this.f2530j = new C0630j(GlobalApplication.m3105f().getContentResolver(), this.f2522b);
    }

    /* renamed from: a */
    public void m3182a(InterfaceC0756u interfaceC0756u) {
        this.f2528h = interfaceC0756u;
    }

    /* renamed from: a */
    public void m3183a(String str) {
        this.f2527g = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3180a(String str, String str2) {
        Intent intent = new Intent(this.mContext, (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", str);
        intent.putExtra("PROFILE_BUDDY_NAME", str2);
        intent.setFlags(67108864);
        this.mContext.startActivity(intent);
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws Resources.NotFoundException, NumberFormatException {
        String strM2718b;
        String strM2718b2;
        String strM2718b3;
        String string;
        String strM2718b4;
        int position = cursor.getPosition();
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_no"));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        String string3 = cursor.getString(cursor.getColumnIndex("inbox_unread_count"));
        String string4 = cursor.getString(cursor.getColumnIndex("inbox_trunk_unread_count"));
        String string5 = cursor.getString(cursor.getColumnIndex("inbox_last_message"));
        String string6 = cursor.getString(cursor.getColumnIndex("inbox_title"));
        String string7 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        String string8 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        long j = cursor.getLong(cursor.getColumnIndex("inbox_last_time"));
        String string9 = cursor.getString(cursor.getColumnIndex("inbox_is_new"));
        String string10 = cursor.getString(cursor.getColumnIndex("buddy_no"));
        C0757v c0757v = (C0757v) view.getTag();
        if (string9.equals("Y")) {
            c0757v.f2578n.setBackgroundResource(R.drawable.buddy_item_highlight_xml);
            c0757v.f2568d.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_last_msg_highlight));
            c0757v.f2565a.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_name_highlight));
            c0757v.f2573i.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_name_highlight));
            this.f2528h.mo3174a(view, true);
        } else {
            c0757v.f2578n.setBackgroundResource(R.drawable.buddy_item_xml);
            c0757v.f2568d.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_last_msg));
            c0757v.f2565a.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_name));
            c0757v.f2573i.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_name));
        }
        if (this.f2526f) {
            c0757v.f2565a.setMaxWidth(this.f2529i);
        }
        if (string5 != null) {
            String[] strArrSplit = string5.split(";");
            if (strArrSplit.length >= 2) {
                int i3 = Integer.parseInt(strArrSplit[0]);
                EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(Integer.parseInt(strArrSplit[1]));
                if ((i3 == 1 || i3 == 2) && enumC0651dM2976a != EnumC0651d.SYSTEM && string5 != null) {
                    if (i3 == 1) {
                        switch (C0744i.f2540a[enumC0651dM2976a.ordinal()]) {
                            case 1:
                                if (strArrSplit.length < 3) {
                                    strM2718b4 = "";
                                } else {
                                    strM2718b4 = C0520a.m2718b(strArrSplit[2]);
                                }
                                string = String.format(GlobalApplication.m3100a().getString(R.string.dialog_chatting_me), strM2718b4);
                                break;
                            case 2:
                                string = GlobalApplication.m3106g().getString(R.string.last_message_me_image);
                                break;
                            case 3:
                                string = GlobalApplication.m3106g().getString(R.string.last_message_me_voice);
                                break;
                            case 4:
                                string = GlobalApplication.m3106g().getString(R.string.last_message_me_calendar);
                                break;
                            case 5:
                                string = GlobalApplication.m3106g().getString(R.string.last_message_me_contact);
                                break;
                            case 6:
                                string = GlobalApplication.m3106g().getString(R.string.last_message_me_location);
                                break;
                            case 7:
                                string = GlobalApplication.m3106g().getString(R.string.last_message_me_video);
                                break;
                            case 8:
                                string = GlobalApplication.m3106g().getString(R.string.toast_supported_format);
                                break;
                            default:
                                string = string5;
                                break;
                        }
                        string5 = string;
                    } else if (EnumC0665r.m3011a(i) == EnumC0665r.GROUPCHAT) {
                        if (strArrSplit.length < 4) {
                            strM2718b2 = GlobalApplication.m3106g().getString(R.string.unknown);
                        } else {
                            strM2718b2 = C0520a.m2718b(strArrSplit[3]);
                        }
                        if (enumC0651dM2976a != EnumC0651d.TEXT) {
                            string5 = strM2718b2 + ": " + C0634n.m2902a(enumC0651dM2976a, (String) null);
                        } else {
                            if (strArrSplit.length < 3) {
                                strM2718b3 = "";
                            } else {
                                strM2718b3 = C0520a.m2718b(strArrSplit[2]);
                            }
                            string5 = strM2718b2 + ": " + strM2718b3;
                        }
                    } else if (enumC0651dM2976a != EnumC0651d.TEXT) {
                        string5 = C0634n.m2902a(enumC0651dM2976a, (String) null);
                    } else {
                        if (strArrSplit.length < 3) {
                            strM2718b = "";
                        } else {
                            strM2718b = C0520a.m2718b(strArrSplit[2]);
                        }
                        string5 = strM2718b;
                    }
                }
            }
            if (string3 == null || string3.length() == 0 || Integer.parseInt(string3) == 0) {
                if (string5 == null) {
                    c0757v.f2568d.setText(string5, TextView.BufferType.NORMAL);
                } else {
                    c0757v.f2568d.setText(new C0760c(this.mContext.getResources(), string5, (int) (c0757v.f2568d.getLineHeight() * 1.2f)), TextView.BufferType.NORMAL);
                }
                c0757v.f2569e.setVisibility(4);
                if (string4 == null || string4.length() == 0 || Integer.parseInt(string4) == 0) {
                    c0757v.f2570f.setVisibility(4);
                    c0757v.f2571g.setVisibility(4);
                } else {
                    c0757v.f2571g.setVisibility(0);
                    c0757v.f2570f.setVisibility(4);
                    if (string4.length() == 3) {
                        c0757v.f2571g.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.text_size_10));
                        c0757v.f2571g.setText(R.string.chat_max_unread);
                    } else {
                        c0757v.f2571g.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.text_size_12));
                        c0757v.f2571g.setText(string4);
                    }
                }
            } else {
                c0757v.f2569e.setVisibility(0);
                if (string5 == null) {
                    c0757v.f2568d.setText(string5);
                } else {
                    c0757v.f2568d.setText(new C0760c(this.mContext.getResources(), string5, (int) (c0757v.f2568d.getLineHeight() * 1.2f)), TextView.BufferType.NORMAL);
                }
                if (string3.length() == 3) {
                    c0757v.f2569e.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.text_size_10));
                    c0757v.f2569e.setText(R.string.chat_max_unread);
                } else {
                    c0757v.f2569e.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.text_size_12));
                    c0757v.f2569e.setText(string3);
                }
                if (string4 == null || string4.length() == 0 || Integer.parseInt(string4) == 0) {
                    c0757v.f2570f.setVisibility(4);
                    c0757v.f2571g.setVisibility(4);
                } else {
                    c0757v.f2570f.setVisibility(0);
                    c0757v.f2571g.setVisibility(4);
                    if (string4.length() == 3) {
                        c0757v.f2570f.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.text_size_10));
                        c0757v.f2570f.setText(R.string.chat_max_unread);
                    } else {
                        c0757v.f2570f.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.text_size_12));
                        c0757v.f2570f.setText(string4);
                    }
                }
            }
        }
        if (i == EnumC0665r.GROUPCHAT.m3012a()) {
            if (!string8.equals("Y") && i2 <= 0) {
                c0757v.f2565a.setText(GlobalApplication.m3106g().getString(R.string.chat_title_no_buddies));
            } else {
                c0757v.f2565a.setText(string6);
            }
            if (i2 >= 10) {
                c0757v.f2565a.setPadding(0, 0, 10, 0);
            } else {
                c0757v.f2565a.setPadding(0, 0, 0, 0);
            }
            c0757v.f2573i.setVisibility(0);
            c0757v.f2573i.setText("(" + (i2 + 1) + ")");
            c0757v.f2565a.setMaxWidth((this.f2525e.getWidth() - ((int) this.mContext.getResources().getDimension(R.dimen.msg_list_space))) - ((int) this.mContext.getResources().getDimension(R.dimen.msg_list_count_space)));
        } else if (i == EnumC0665r.BROADCAST.m3012a()) {
            c0757v.f2565a.setText(C0520a.m2714a(string8, string6));
            if (i2 >= 10) {
                c0757v.f2565a.setPadding(0, 0, 10, 0);
            } else {
                c0757v.f2565a.setPadding(0, 0, 0, 0);
            }
            c0757v.f2573i.setVisibility(0);
            c0757v.f2573i.setText("(" + i2 + ")");
            c0757v.f2565a.setMaxWidth((this.f2525e.getWidth() - ((int) this.mContext.getResources().getDimension(R.dimen.msg_list_space))) - ((int) this.mContext.getResources().getDimension(R.dimen.msg_list_count_space)));
        } else {
            if (string8.equals("Y") || TextUtils.isEmpty(string7)) {
                c0757v.f2565a.setText(string6);
            } else {
                c0757v.f2565a.setText(string7);
            }
            c0757v.f2573i.setVisibility(8);
        }
        c0757v.f2574j.setClickable(false);
        c0757v.f2574j.setFocusable(false);
        if (this.f2524d.getChoiceMode() == 0) {
            c0757v.f2574j.setVisibility(8);
        } else {
            c0757v.f2574j.setVisibility(0);
            c0757v.f2574j.setOnCheckedChangeListener(new C0743h(this, position));
            if (this.f2524d.isItemChecked(position)) {
                c0757v.f2574j.setChecked(true);
            } else {
                c0757v.f2574j.setChecked(false);
            }
        }
        String str = "h:mm aa";
        if (DateFormat.is24HourFormat(this.mContext)) {
            str = "HH:mm";
        }
        String str2 = new SimpleDateFormat(str, Locale.ENGLISH).format(Long.valueOf(j));
        String[] strArrSplit2 = new SimpleDateFormat("MMM dd/hh:mm aa", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str5 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str6 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str5.equals(str3)) {
            c0757v.f2572h.setText(str2);
        } else if (str4.equals(str6)) {
            c0757v.f2572h.setText(strArrSplit2[0]);
        } else {
            c0757v.f2572h.setText(new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH).format(Long.valueOf(j)));
        }
        c0757v.f2575k.setBuddyName(string6);
        if (i == EnumC0665r.ONETOONE.m3012a() && !TextUtils.isEmpty(string10)) {
            C1348w.m4685a(this.mContext).m4699a(c0757v.f2575k, string10);
            c0757v.f2575k.setBuddyNo(string10);
        } else {
            c0757v.f2575k.m4722a(c0757v.f2575k, EnumC0665r.m3011a(i));
        }
        if (i == EnumC0665r.ONETOONE.m3012a()) {
            c0757v.f2575k.setOnClickListener(new ViewOnClickListenerC0742g(this));
            c0757v.f2575k.setTag(new C0746k(this, string6, string10, string7, string2, i, i2));
        } else {
            c0757v.f2575k.setOnClickListener(null);
        }
        view.setTag(c0757v);
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f2523c.inflate(R.layout.item_msgbox, (ViewGroup) null);
        C0757v c0757v = new C0757v();
        c0757v.f2565a = (TextView) viewInflate.findViewById(R.id.msgboxTextName);
        c0757v.f2566b = (TextView) viewInflate.findViewById(R.id.msg_no_item);
        c0757v.f2567c = (TextView) viewInflate.findViewById(R.id.msgboxCount);
        c0757v.f2568d = (TextView) viewInflate.findViewById(R.id.msgboxTextMessage);
        c0757v.f2569e = (TextView) viewInflate.findViewById(R.id.msgboxImageCount);
        c0757v.f2570f = (TextView) viewInflate.findViewById(R.id.leftTrunkImageCount);
        c0757v.f2571g = (TextView) viewInflate.findViewById(R.id.rightTrunkImageCount);
        c0757v.f2575k = (ProfileImageView) viewInflate.findViewById(R.id.msgboxImageCheck);
        c0757v.f2574j = (CheckBox) viewInflate.findViewById(R.id.msgCheck);
        c0757v.f2572h = (TextView) viewInflate.findViewById(R.id.msgboxTime);
        c0757v.f2573i = (TextView) viewInflate.findViewById(R.id.participantcount);
        c0757v.f2578n = (LinearLayout) viewInflate.findViewById(R.id.msgLinear);
        c0757v.f2575k.setFocusable(false);
        if (this.f2526f) {
            this.f2529i = (int) C1301ax.m4544a(C1301ax.m4545b(((Activity) this.mContext).findViewById(R.id.fragment_controller).getWidth()) - 200.0f);
            c0757v.f2565a.setMaxWidth(this.f2529i);
            c0757v.f2576l = (ImageView) viewInflate.findViewById(R.id.msg_selecter);
            c0757v.f2577m = (ImageView) viewInflate.findViewById(R.id.item_line);
        } else {
            c0757v.f2565a.setMaxWidth(this.f2525e.getWidth() - ((int) this.mContext.getResources().getDimension(R.dimen.msg_list_space)));
        }
        viewInflate.setTag(c0757v);
        return viewInflate;
    }
}
