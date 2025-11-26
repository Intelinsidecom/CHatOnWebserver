package com.sec.chaton.msgbox;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.RichString;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.Dip;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.widget.ProfileImageView;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public class MsgBoxListAdapter extends SimpleCursorAdapter {

    /* renamed from: a */
    public static final String[] f1953a = {"_id", "inbox_no", "inbox_chat_type", "inbox_participants", "inbox_title", "inbox_unread_count", "inbox_last_time", "inbox_translated", "inbox_last_message", "inbox_session_id", "inbox_title_fixed"};

    /* renamed from: b */
    private LayoutInflater f1954b;

    /* renamed from: c */
    private ListView f1955c;

    /* renamed from: d */
    private Display f1956d;

    /* renamed from: e */
    private OnChatisNew f1957e;

    public MsgBoxListAdapter(Context context, ListView listView, int i, Cursor cursor) {
        super(context, i, cursor, f1953a, null, -1);
        this.f1954b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f1955c = listView;
        this.f1956d = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
    }

    /* renamed from: a */
    public void m2412a(OnChatisNew onChatisNew) {
        this.f1957e = onChatisNew;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws Resources.NotFoundException, NumberFormatException {
        int position = cursor.getPosition();
        String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
        int i = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
        String string2 = cursor.getString(cursor.getColumnIndex("inbox_unread_count"));
        String string3 = cursor.getString(cursor.getColumnIndex("inbox_trunk_unread_count"));
        String string4 = cursor.getString(cursor.getColumnIndex("inbox_last_message"));
        String string5 = cursor.getString(cursor.getColumnIndex("inbox_title"));
        String string6 = cursor.getString(cursor.getColumnIndex("buddy_name"));
        String string7 = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_participants"));
        long j = cursor.getLong(cursor.getColumnIndex("inbox_last_time"));
        cursor.getString(cursor.getColumnIndex("inbox_last_msg_no"));
        String string8 = cursor.getString(cursor.getColumnIndex("inbox_is_new"));
        ChatONLogWriter.m3509d("isnew:" + string8);
        C0269s c0269s = (C0269s) view.getTag();
        if (string8.equals("Y")) {
            view.setBackgroundColor(Color.parseColor("#4C91BD"));
            c0269s.f2018d.setTextColor(Color.parseColor("#F6FF00"));
            this.f1957e.mo2447a(view, true);
        } else {
            view.setBackgroundResource(C0062R.drawable.buddy_item_xml);
            c0269s.f2018d.setTextColor(Color.parseColor("#EFAD51"));
        }
        String[] strArrSplit = string4.split(";");
        if (strArrSplit.length >= 2) {
            int i3 = Integer.parseInt(strArrSplit[0]);
            ChatONContract.MessageTable.MsgContentType msgContentTypeM2195a = ChatONContract.MessageTable.MsgContentType.m2195a(Integer.parseInt(strArrSplit[1]));
            if ((i3 == 1 || i3 == 2) && msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.SYSTEM && string4 != null) {
                if (i3 == 1) {
                    switch (msgContentTypeM2195a) {
                        case TEXT:
                            string4 = String.format(GlobalApplication.m2387e().getString(C0062R.string.dialog_chatting_me), strArrSplit.length < 3 ? "" : ChatUtil.m800b(strArrSplit[2]));
                            break;
                        case IMAGE:
                            string4 = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_image);
                            break;
                        case AUDIO:
                            string4 = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_voice);
                            break;
                        case CALENDAR:
                            string4 = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_calendar);
                            break;
                        case CONTACT:
                            string4 = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_contact);
                            break;
                        case GEO:
                            string4 = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_location);
                            break;
                        case VIDEO:
                            string4 = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_video);
                            break;
                    }
                } else if (ChatONContract.InBoxTable.ChatType.m2188a(i) == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                    String string9 = strArrSplit.length < 4 ? GlobalApplication.m2388f().getString(C0062R.string.unknown) : ChatUtil.m800b(strArrSplit[3]);
                    if (msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.TEXT) {
                        string4 = string9 + ": " + InBoxDatabaseHelper.m2247a(msgContentTypeM2195a, (String) null);
                    } else {
                        string4 = string9 + ": " + (strArrSplit.length < 3 ? "" : ChatUtil.m800b(strArrSplit[2]));
                    }
                } else {
                    string4 = msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.TEXT ? InBoxDatabaseHelper.m2247a(msgContentTypeM2195a, (String) null) : strArrSplit.length < 3 ? "" : ChatUtil.m800b(strArrSplit[2]);
                }
            }
        }
        if (string4 != null) {
            if (string2 == null || string2.length() == 0 || Integer.parseInt(string2) == 0) {
                if (string4 == null) {
                    c0269s.f2018d.setText(string4, TextView.BufferType.NORMAL);
                } else {
                    c0269s.f2018d.setText(new RichString(this.mContext.getResources(), string4, (int) (c0269s.f2018d.getLineHeight() * 1.2f)), TextView.BufferType.NORMAL);
                }
                c0269s.f2019e.setVisibility(4);
                if (string3 == null || string3.length() == 0 || Integer.parseInt(string3) == 0) {
                    c0269s.f2020f.setVisibility(4);
                    c0269s.f2021g.setVisibility(4);
                } else {
                    c0269s.f2021g.setVisibility(0);
                    c0269s.f2020f.setVisibility(4);
                    if (string3.length() == 3) {
                        c0269s.f2021g.setTextSize(10.0f);
                        c0269s.f2021g.setText(C0062R.string.chat_max_unread);
                    } else {
                        c0269s.f2021g.setTextSize(12.0f);
                        c0269s.f2021g.setText(string3);
                    }
                }
            } else {
                c0269s.f2019e.setVisibility(0);
                if (string4 == null) {
                    c0269s.f2018d.setText(string4);
                } else {
                    c0269s.f2018d.setText(new RichString(this.mContext.getResources(), string4, (int) (c0269s.f2018d.getLineHeight() * 1.2f)), TextView.BufferType.NORMAL);
                }
                if (string2.length() == 3) {
                    c0269s.f2019e.setTextSize(10.0f);
                    c0269s.f2019e.setText(C0062R.string.chat_max_unread);
                } else {
                    c0269s.f2019e.setTextSize(12.0f);
                    c0269s.f2019e.setText(string2);
                }
                if (string3 == null || string3.length() == 0 || Integer.parseInt(string3) == 0) {
                    c0269s.f2020f.setVisibility(4);
                    c0269s.f2021g.setVisibility(4);
                } else {
                    c0269s.f2020f.setVisibility(0);
                    c0269s.f2021g.setVisibility(4);
                    if (string3.length() == 3) {
                        c0269s.f2020f.setTextSize(10.0f);
                        c0269s.f2020f.setText(C0062R.string.chat_max_unread);
                    } else {
                        c0269s.f2020f.setTextSize(12.0f);
                        c0269s.f2020f.setText(string3);
                    }
                }
            }
        }
        if (i == ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a()) {
            if (string7.equals("Y") || i2 > 0) {
                c0269s.f2015a.setText(string5);
            } else {
                c0269s.f2015a.setText(GlobalApplication.m2388f().getString(C0062R.string.chat_title_no_buddies));
            }
            if (i2 >= 10) {
                c0269s.f2015a.setPadding(0, 0, 10, 0);
            } else {
                c0269s.f2015a.setPadding(0, 0, 0, 0);
            }
            c0269s.f2023i.setVisibility(0);
            c0269s.f2023i.setText("(" + (i2 + 1) + ")");
        } else if (i == ChatONContract.InBoxTable.ChatType.BROADCAST.m2189a()) {
            c0269s.f2015a.setText(ChatUtil.m796a(string7, string5));
            if (i2 >= 10) {
                c0269s.f2015a.setPadding(0, 0, 10, 0);
            } else {
                c0269s.f2015a.setPadding(0, 0, 0, 0);
            }
            c0269s.f2023i.setVisibility(0);
            c0269s.f2023i.setText("(" + i2 + ")");
        } else {
            if (string7.equals("Y")) {
                c0269s.f2015a.setText(string5);
            } else {
                c0269s.f2015a.setText(string6);
            }
            c0269s.f2023i.setVisibility(8);
        }
        c0269s.f2024j.setClickable(false);
        c0269s.f2024j.setFocusable(false);
        if (this.f1955c.getChoiceMode() == 0) {
            c0269s.f2024j.setVisibility(8);
        } else {
            c0269s.f2024j.setVisibility(0);
            c0269s.f2024j.setOnCheckedChangeListener(new C0256f(this, position));
            if (this.f1955c.isItemChecked(position)) {
                c0269s.f2024j.setChecked(true);
            } else {
                c0269s.f2024j.setChecked(false);
            }
        }
        String[] strArrSplit2 = new SimpleDateFormat("dd MMM/hh:mmaa", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - j;
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str3.equals(str)) {
            c0269s.f2022h.setText(strArrSplit2[1].toLowerCase());
        } else if (str2.equals(str4)) {
            c0269s.f2022h.setText(strArrSplit2[0]);
        } else {
            c0269s.f2022h.setText(new SimpleDateFormat("d MMM,yyyy", Locale.ENGLISH).format(Long.valueOf(j)));
        }
        c0269s.f2025k.setBuddyName(string5);
        if (i == ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a()) {
            ProfileImageLoader.m3610a(this.mContext).m3623a(c0269s.f2025k, string);
            c0269s.f2025k.setBuddyNo(string);
        } else {
            c0269s.f2025k.init(c0269s.f2025k, ChatONContract.InBoxTable.ChatType.m2188a(i));
        }
        if (i == ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a()) {
            c0269s.f2025k.setOnClickListener(new ViewOnClickListenerC0255e(this, string, string5));
        } else {
            c0269s.f2025k.setOnClickListener(null);
        }
        view.setTag(c0269s);
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f1954b.inflate(C0062R.layout.item_msgbox, (ViewGroup) null);
        C0269s c0269s = new C0269s();
        c0269s.f2015a = (TextView) viewInflate.findViewById(C0062R.id.msgboxTextName);
        c0269s.f2016b = (TextView) viewInflate.findViewById(C0062R.id.msg_no_item);
        c0269s.f2017c = (TextView) viewInflate.findViewById(C0062R.id.msgboxCount);
        c0269s.f2018d = (TextView) viewInflate.findViewById(C0062R.id.msgboxTextMessage);
        c0269s.f2019e = (TextView) viewInflate.findViewById(C0062R.id.msgboxImageCount);
        c0269s.f2020f = (TextView) viewInflate.findViewById(C0062R.id.leftTrunkImageCount);
        c0269s.f2021g = (TextView) viewInflate.findViewById(C0062R.id.rightTrunkImageCount);
        c0269s.f2025k = (ProfileImageView) viewInflate.findViewById(C0062R.id.msgboxImageCheck);
        c0269s.f2024j = (CheckBox) viewInflate.findViewById(C0062R.id.msgCheck);
        c0269s.f2022h = (TextView) viewInflate.findViewById(C0062R.id.msgboxTime);
        c0269s.f2023i = (TextView) viewInflate.findViewById(C0062R.id.participantcount);
        c0269s.f2025k.setFocusable(false);
        c0269s.f2015a.setMaxWidth((int) Dip.m3571a(Dip.m3572b(this.f1956d.getWidth()) - 160.0f));
        viewInflate.setTag(c0269s);
        return viewInflate;
    }
}
