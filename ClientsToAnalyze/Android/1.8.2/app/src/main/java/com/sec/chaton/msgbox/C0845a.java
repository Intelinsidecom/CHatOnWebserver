package com.sec.chaton.msgbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
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
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C0970p;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1722ae;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.widget.ProfileImageView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: MsgBoxListAdapter.java */
/* renamed from: com.sec.chaton.msgbox.a */
/* loaded from: classes.dex */
public class C0845a extends SimpleCursorAdapter {

    /* renamed from: a */
    public static final String[] f3133a = {"_id", "inbox_no", "inbox_chat_type", "inbox_participants", "inbox_title", "inbox_unread_count", "inbox_last_time", "inbox_translated", "inbox_last_message", "inbox_session_id", "inbox_title_fixed"};

    /* renamed from: b */
    InterfaceC0667k f3134b;

    /* renamed from: c */
    private LayoutInflater f3135c;

    /* renamed from: d */
    private ListView f3136d;

    /* renamed from: e */
    private Display f3137e;

    /* renamed from: f */
    private boolean f3138f;

    /* renamed from: g */
    private int f3139g;

    /* renamed from: h */
    private String f3140h;

    /* renamed from: i */
    private InterfaceC0870z f3141i;

    /* renamed from: j */
    private int f3142j;

    /* renamed from: k */
    private C0666j f3143k;

    public C0845a(Context context, ListView listView, int i, Cursor cursor) {
        super(context, i, cursor, f3133a, null, -1);
        this.f3138f = false;
        this.f3139g = 0;
        this.f3140h = null;
        this.f3134b = new C0846b(this);
        this.f3135c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3136d = listView;
        this.f3137e = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        if (((Activity) context).findViewById(R.id.fragment_controller) != null) {
            this.f3138f = true;
        }
        this.f3143k = new C0666j(GlobalApplication.m3256a().getContentResolver(), this.f3134b);
    }

    /* renamed from: a */
    public void m3545a(InterfaceC0870z interfaceC0870z) {
        this.f3141i = interfaceC0870z;
    }

    /* renamed from: a */
    public void m3546a(String str) {
        this.f3140h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3543a(String str, String str2) {
        if (str.startsWith("0999")) {
            Intent intent = new Intent(this.mContext, (Class<?>) SpecialBuddyActivity.class);
            intent.putExtra("specialuserid", str);
            intent.putExtra("specialBuddyAdded", true);
            intent.setFlags(67108864);
            this.mContext.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.mContext, (Class<?>) BuddyProfileActivity.class);
        intent2.putExtra("PROFILE_BUDDY_NO", str);
        intent2.putExtra("PROFILE_BUDDY_NAME", str2);
        intent2.setFlags(67108864);
        this.mContext.startActivity(intent2);
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws Resources.NotFoundException, NumberFormatException {
        String str;
        String strM2689b;
        String strM2689b2;
        String strM2689b3;
        String string;
        String strM2689b4;
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
        "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
        String string11 = cursor.getString(cursor.getColumnIndex("inbox_enable_noti"));
        C0851g c0851g = (C0851g) view.getTag();
        if (string9.equals("Y")) {
            if (GlobalApplication.m3265f()) {
                c0851g.f3169n.setBackgroundResource(R.drawable.buddy_item_highlight_xml);
                c0851g.f3159d.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_last_msg_highlight));
                c0851g.f3156a.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_name_highlight));
                c0851g.f3164i.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_name_highlight));
            } else {
                c0851g.f3169n.setBackgroundColor(Color.parseColor("#4C91BD"));
            }
            this.f3141i.mo3532a(view, true);
        } else {
            c0851g.f3169n.setBackgroundResource(R.drawable.buddy_item_xml);
            if (GlobalApplication.m3265f()) {
                c0851g.f3159d.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_last_msg));
                c0851g.f3156a.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_name));
                c0851g.f3164i.setTextColor(this.mContext.getResources().getColor(R.color.msgbox_list_item_name));
            } else {
                c0851g.f3159d.setTextColor(Color.parseColor("#EFAD51"));
            }
        }
        if (this.f3138f) {
            this.f3139g = this.f3142j + 50;
            c0851g.f3156a.setMaxWidth(this.f3139g);
        }
        if (string5 != null) {
            String[] strArrSplit = string5.split(";");
            if (strArrSplit.length >= 2) {
                int i3 = Integer.parseInt(strArrSplit[0]);
                EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(Integer.parseInt(strArrSplit[1]));
                if ((i3 == 1 || i3 == 2) && enumC0699nM3160a != EnumC0699n.SYSTEM && string5 != null) {
                    if (i3 == 1) {
                        switch (enumC0699nM3160a) {
                            case TEXT:
                                if (strArrSplit.length < 3) {
                                    strM2689b4 = "";
                                } else {
                                    strM2689b4 = C0493bg.m2689b(strArrSplit[2]);
                                }
                                string = String.format(GlobalApplication.m3260b().getString(R.string.dialog_chatting_me), strM2689b4);
                                break;
                            case IMAGE:
                                string = GlobalApplication.m3262c().getString(R.string.last_message_me_image);
                                break;
                            case AUDIO:
                                string = GlobalApplication.m3262c().getString(R.string.last_message_me_voice);
                                break;
                            case CALENDAR:
                                string = GlobalApplication.m3262c().getString(R.string.last_message_me_calendar);
                                break;
                            case CONTACT:
                                string = GlobalApplication.m3262c().getString(R.string.last_message_me_contact);
                                break;
                            case GEO:
                                string = GlobalApplication.m3262c().getString(R.string.last_message_me_location);
                                break;
                            case VIDEO:
                                string = GlobalApplication.m3262c().getString(R.string.last_message_me_video);
                                break;
                            case ANICON:
                                string = GlobalApplication.m3262c().getString(R.string.last_message_me_anicon);
                                break;
                            case DOCUMENT:
                                string = GlobalApplication.m3262c().getString(R.string.last_message_me_document);
                                break;
                            default:
                                string = string5;
                                break;
                        }
                        string5 = string;
                    } else if (EnumC0695j.m3145a(i) == EnumC0695j.GROUPCHAT) {
                        if (strArrSplit.length < 4) {
                            strM2689b2 = GlobalApplication.m3262c().getString(R.string.unknown);
                        } else {
                            strM2689b2 = C0493bg.m2689b(strArrSplit[3]);
                        }
                        if (enumC0699nM3160a != EnumC0699n.TEXT) {
                            string5 = strM2689b2 + ": " + C0660d.m3015a(enumC0699nM3160a, (String) null);
                        } else {
                            if (strArrSplit.length < 3) {
                                strM2689b3 = "";
                            } else {
                                strM2689b3 = C0493bg.m2689b(strArrSplit[2]);
                            }
                            string5 = strM2689b2 + ": " + strM2689b3;
                        }
                    } else if (enumC0699nM3160a != EnumC0699n.TEXT) {
                        string5 = C0660d.m3015a(enumC0699nM3160a, (String) null);
                    } else {
                        if (strArrSplit.length < 3) {
                            strM2689b = "";
                        } else {
                            strM2689b = C0493bg.m2689b(strArrSplit[2]);
                        }
                        string5 = strM2689b;
                    }
                }
            }
            if (string3 == null || string3.length() == 0 || Integer.parseInt(string3) == 0) {
                if (string5 == null) {
                    c0851g.f3159d.setText(string5, TextView.BufferType.NORMAL);
                } else {
                    c0851g.f3159d.setText(new C0970p(this.mContext.getResources(), string5, (int) (c0851g.f3159d.getLineHeight() * 1.2f)), TextView.BufferType.NORMAL);
                }
                c0851g.f3160e.setVisibility(4);
                if (string4 == null || string4.length() == 0 || Integer.parseInt(string4) == 0) {
                    c0851g.f3161f.setVisibility(4);
                    c0851g.f3162g.setVisibility(4);
                } else {
                    c0851g.f3162g.setVisibility(0);
                    c0851g.f3161f.setVisibility(4);
                    if (string4.length() == 3) {
                        c0851g.f3162g.setTextSize(10.0f);
                        c0851g.f3162g.setText(R.string.chat_max_unread);
                    } else {
                        c0851g.f3162g.setTextSize(12.0f);
                        c0851g.f3162g.setText(string4);
                    }
                }
            } else {
                c0851g.f3160e.setVisibility(0);
                if (string5 == null) {
                    c0851g.f3159d.setText(string5);
                } else {
                    c0851g.f3159d.setText(new C0970p(this.mContext.getResources(), string5, (int) (c0851g.f3159d.getLineHeight() * 1.2f)), TextView.BufferType.NORMAL);
                }
                if (string3.length() == 3) {
                    c0851g.f3160e.setTextSize(10.0f);
                    c0851g.f3160e.setText(R.string.chat_max_unread);
                } else {
                    c0851g.f3160e.setTextSize(12.0f);
                    c0851g.f3160e.setText(string3);
                }
                if (string4 == null || string4.length() == 0 || Integer.parseInt(string4) == 0) {
                    c0851g.f3161f.setVisibility(4);
                    c0851g.f3162g.setVisibility(4);
                } else {
                    c0851g.f3161f.setVisibility(0);
                    c0851g.f3162g.setVisibility(4);
                    if (string4.length() == 3) {
                        c0851g.f3161f.setTextSize(10.0f);
                        c0851g.f3161f.setText(R.string.chat_max_unread);
                    } else {
                        c0851g.f3161f.setTextSize(12.0f);
                        c0851g.f3161f.setText(string4);
                    }
                }
            }
        }
        if (i == EnumC0695j.GROUPCHAT.m3146a()) {
            if (!string8.equals("Y") && i2 <= 0) {
                c0851g.f3156a.setText(GlobalApplication.m3262c().getString(R.string.chat_title_no_buddies));
            } else {
                c0851g.f3156a.setText(string6);
            }
            if (i2 >= 10) {
                c0851g.f3156a.setPadding(0, 0, 10, 0);
            } else {
                c0851g.f3156a.setPadding(0, 0, 0, 0);
            }
            c0851g.f3164i.setVisibility(0);
            c0851g.f3164i.setText("(" + (i2 + 1) + ")");
            c0851g.f3156a.setWidth(this.f3139g - c0851g.f3164i.getMeasuredWidth());
        } else if (i == EnumC0695j.BROADCAST.m3146a()) {
            c0851g.f3156a.setText(C0493bg.m2685a(string8, string6));
            if (i2 >= 10) {
                c0851g.f3156a.setPadding(0, 0, 10, 0);
            } else {
                c0851g.f3156a.setPadding(0, 0, 0, 0);
            }
            c0851g.f3164i.setVisibility(0);
            c0851g.f3164i.setText("(" + i2 + ")");
            c0851g.f3156a.setWidth(this.f3139g - c0851g.f3164i.getMeasuredWidth());
        } else {
            if (string8.equals("Y") || TextUtils.isEmpty(string7)) {
                c0851g.f3156a.setText(string6);
            } else {
                c0851g.f3156a.setText(string7);
            }
            c0851g.f3164i.setVisibility(8);
        }
        c0851g.f3165j.setClickable(false);
        c0851g.f3165j.setFocusable(false);
        if (this.f3136d.getChoiceMode() == 0) {
            c0851g.f3165j.setVisibility(8);
        } else {
            c0851g.f3165j.setVisibility(0);
            c0851g.f3165j.setOnCheckedChangeListener(new C0847c(this, position));
            if (this.f3136d.isItemChecked(position)) {
                c0851g.f3165j.setChecked(true);
            } else {
                c0851g.f3165j.setChecked(false);
            }
        }
        String str2 = "h:mm aa";
        if (DateFormat.is24HourFormat(this.mContext)) {
            str2 = "HH:mm";
        }
        new SimpleDateFormat(str2, Locale.ENGLISH).format(Long.valueOf(j));
        new SimpleDateFormat("dd MMM/hh:mm aa", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        c0851g.f3163h.setAlpha(0.5f);
        DateFormat.getMediumDateFormat(this.mContext).format(Long.valueOf(j));
        if (new Date(j).getDate() == new Date(System.currentTimeMillis()).getDate()) {
            str = DateFormat.getTimeFormat(this.mContext).format(Long.valueOf(j));
        } else {
            str = DateFormat.getDateFormat(this.mContext).format(Long.valueOf(j));
        }
        c0851g.f3163h.setText(str);
        c0851g.f3166k.setBuddyName(string6);
        if (i == EnumC0695j.ONETOONE.m3146a() && !TextUtils.isEmpty(string10)) {
            C1746bb.m5945a(this.mContext).m5959a(c0851g.f3166k, string10);
            c0851g.f3166k.setBuddyNo(string10);
        } else {
            c0851g.f3166k.m6129a(c0851g.f3166k, EnumC0695j.m3145a(i));
        }
        if (i == EnumC0695j.ONETOONE.m3146a()) {
            c0851g.f3166k.setOnClickListener(new ViewOnClickListenerC0848d(this));
            c0851g.f3166k.setTag(new C0850f(this, string6, string10, string7, string2, i, i2));
        } else {
            c0851g.f3166k.setOnClickListener(null);
        }
        if (GlobalApplication.m3265f()) {
            if (!TextUtils.isEmpty(this.f3140h) && this.f3140h.equals(string2)) {
                c0851g.f3167l.setVisibility(0);
                c0851g.f3156a.setTextColor(this.mContext.getResources().getColor(R.color.chat_list_item_selected));
                c0851g.f3159d.setTextColor(this.mContext.getResources().getColor(R.color.chat_list_item_selected));
                c0851g.f3164i.setTextColor(this.mContext.getResources().getColor(R.color.chat_list_item_selected));
            } else {
                c0851g.f3167l.setVisibility(8);
            }
        }
        if ("Y".equals(string11)) {
            c0851g.f3170o.setVisibility(8);
        } else {
            c0851g.f3170o.setVisibility(0);
        }
        view.setTag(c0851g);
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f3135c.inflate(R.layout.item_msgbox, (ViewGroup) null);
        C0851g c0851g = new C0851g();
        c0851g.f3156a = (TextView) viewInflate.findViewById(R.id.msgboxTextName);
        c0851g.f3157b = (TextView) viewInflate.findViewById(R.id.msg_no_item);
        c0851g.f3158c = (TextView) viewInflate.findViewById(R.id.msgboxCount);
        c0851g.f3159d = (TextView) viewInflate.findViewById(R.id.msgboxTextMessage);
        c0851g.f3160e = (TextView) viewInflate.findViewById(R.id.msgboxImageCount);
        c0851g.f3161f = (TextView) viewInflate.findViewById(R.id.leftTrunkImageCount);
        c0851g.f3162g = (TextView) viewInflate.findViewById(R.id.rightTrunkImageCount);
        c0851g.f3166k = (ProfileImageView) viewInflate.findViewById(R.id.msgboxImageCheck);
        c0851g.f3165j = (CheckBox) viewInflate.findViewById(R.id.msgCheck);
        c0851g.f3163h = (TextView) viewInflate.findViewById(R.id.msgboxTime);
        c0851g.f3164i = (TextView) viewInflate.findViewById(R.id.participantcount);
        c0851g.f3169n = (LinearLayout) viewInflate.findViewById(R.id.msgLinear);
        c0851g.f3166k.setFocusable(false);
        c0851g.f3170o = (ImageView) viewInflate.findViewById(R.id.notiMuteIcon);
        if (this.f3138f) {
            this.f3142j = (int) C1722ae.m5894a(C1722ae.m5895b(((Activity) this.mContext).findViewById(R.id.fragment_controller).getWidth()) - 200.0f);
            this.f3139g = this.f3142j + 50;
            c0851g.f3156a.setMaxWidth(this.f3139g);
            c0851g.f3167l = (ImageView) viewInflate.findViewById(R.id.msg_selecter);
            c0851g.f3168m = (ImageView) viewInflate.findViewById(R.id.item_line);
        } else {
            this.f3139g = ((int) C1722ae.m5894a(C1722ae.m5895b(this.f3137e.getWidth()) - 160.0f)) + 50;
            c0851g.f3156a.setMaxWidth(this.f3139g);
        }
        viewInflate.setTag(c0851g);
        return viewInflate;
    }
}
