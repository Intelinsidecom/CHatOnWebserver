package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.HomeTabFragment;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.item.BuddyGroupItem;
import com.sec.chaton.buddy.item.BuddyGroupListItem;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatONShortcutUtil;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.Dip;
import com.sec.chaton.util.HangulJamoUtil;
import com.sec.chaton.util.KoreanUtil;
import com.sec.chaton.util.ProfileImageLoader;
import com.sec.chaton.widget.ProfileImageView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class BuddyFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener, HomeTabFragment.OnTabChangeListener, ChatActivity.OnBackKeyListener {

    /* renamed from: a */
    public static final String f409a = BuddyFragment.class.getSimpleName();

    /* renamed from: A */
    private String f410A;

    /* renamed from: B */
    private String f411B;

    /* renamed from: C */
    private int f412C;

    /* renamed from: D */
    private String[] f413D;

    /* renamed from: E */
    private String f414E;

    /* renamed from: F */
    private LinearLayout f415F;

    /* renamed from: G */
    private Bundle f416G;

    /* renamed from: S */
    private BuddyItem f428S;

    /* renamed from: T */
    private ImageView f429T;

    /* renamed from: U */
    private BuddyAdapter f430U;

    /* renamed from: W */
    private HorizontalScrollView f432W;

    /* renamed from: X */
    private String f433X;

    /* renamed from: ae */
    private int f440ae;

    /* renamed from: af */
    private String f441af;

    /* renamed from: ag */
    private String f442ag;

    /* renamed from: aj */
    private int f445aj;

    /* renamed from: i */
    private Context f453i;

    /* renamed from: j */
    private LinearLayout f454j;

    /* renamed from: k */
    private LinearLayout f455k;

    /* renamed from: l */
    private ExpandableListView f456l;

    /* renamed from: m */
    private LinearLayout f457m;

    /* renamed from: n */
    private LinearLayout f458n;

    /* renamed from: o */
    private EditText f459o;

    /* renamed from: p */
    private Button f460p;

    /* renamed from: q */
    private Button f461q;

    /* renamed from: r */
    private TextView f462r;

    /* renamed from: s */
    private LinearLayout f463s;

    /* renamed from: t */
    private TextView f464t;

    /* renamed from: w */
    private EditText f467w;

    /* renamed from: x */
    private EditText f468x;

    /* renamed from: y */
    private Button f469y;

    /* renamed from: z */
    private RelativeLayout f470z;

    /* renamed from: u */
    private boolean f465u = false;

    /* renamed from: v */
    private boolean f466v = false;

    /* renamed from: H */
    private int f417H = 11;

    /* renamed from: I */
    private int f418I = 0;

    /* renamed from: J */
    private int f419J = 1;

    /* renamed from: K */
    private String[] f420K = null;

    /* renamed from: L */
    private String[] f421L = null;

    /* renamed from: M */
    private ArrayList f422M = new ArrayList();

    /* renamed from: N */
    private ArrayList f423N = new ArrayList();

    /* renamed from: O */
    private final ArrayList f424O = new ArrayList();

    /* renamed from: P */
    private final ArrayList f425P = new ArrayList();

    /* renamed from: Q */
    private final ArrayList f426Q = new ArrayList();

    /* renamed from: R */
    private final ArrayList f427R = new ArrayList();

    /* renamed from: V */
    private DbRequest f431V = null;

    /* renamed from: Y */
    private boolean f434Y = false;

    /* renamed from: Z */
    private ProgressDialog f435Z = null;

    /* renamed from: aa */
    private AlertDialog f436aa = null;

    /* renamed from: ab */
    private boolean f437ab = true;

    /* renamed from: ac */
    private boolean f438ac = false;

    /* renamed from: ad */
    private boolean f439ad = false;

    /* renamed from: ah */
    private ArrayList f443ah = new ArrayList();

    /* renamed from: ai */
    private TextWatcher f444ai = new C0104ba(this);

    /* renamed from: b */
    View.OnClickListener f446b = new ViewOnClickListenerC0109bf(this);

    /* renamed from: c */
    MenuItem.OnMenuItemClickListener f447c = new MenuItemOnMenuItemClickListenerC0107bd(this);

    /* renamed from: d */
    Handler f448d = new HandlerC0113f(this);

    /* renamed from: e */
    AbstractQueryTask.OnQueryTaskResult f449e = new C0112e(this);

    /* renamed from: f */
    AbstractQueryTask.OnQueryTaskResult f450f = new C0111d(this);

    /* renamed from: g */
    AbstractQueryTask.OnQueryTaskResult f451g = new C0103b(this);

    /* renamed from: h */
    ContentObserver f452h = new C0076a(this, new Handler());

    public class DbRequest implements NotifyingAsyncQueryHandler.AsyncQueryListener {

        /* renamed from: a */
        public int f471a = 1;

        /* renamed from: b */
        public int f472b = 2;

        /* renamed from: c */
        public int f473c = 3;

        /* renamed from: d */
        public int f474d = 4;

        /* renamed from: e */
        public int f475e = 5;

        /* renamed from: f */
        public int f476f = 6;

        /* renamed from: g */
        public int f477g = 10;

        /* renamed from: h */
        NotifyingAsyncQueryHandler f478h;

        public DbRequest() {
            this.f478h = null;
            this.f478h = new NotifyingAsyncQueryHandler(BuddyFragment.this.getActivity().getContentResolver(), this);
        }

        /* renamed from: a */
        public void m527a() {
            ChatONLogWriter.m3512f("getBuddyCount() : " + this.f475e, BuddyFragment.f409a);
            this.f478h.startQuery(this.f475e, null, ChatONContract.BuddyTable.f1713a, new String[]{"buddy_no"}, null, null, null);
        }

        /* renamed from: a */
        public void m528a(int i) {
            String str;
            String str2;
            Uri uriM2168a;
            ChatONLogWriter.m3512f("getBuddyList() : " + i, BuddyFragment.f409a);
            String str3 = "";
            if (i == 11) {
                if (BuddyFragment.this.f419J == 6) {
                    Uri uriM2174e = ChatONContract.BuddyTable.m2174e();
                    String[] stringArray = BuddyFragment.this.f416G.getStringArray(ChatFragment.f724c);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (stringArray.length <= 0) {
                        return;
                    }
                    String str4 = "buddy_no IN ( ";
                    for (String str5 : stringArray) {
                        stringBuffer.append(", '" + str5 + "'");
                    }
                    str = "group_type, buddy_name COLLATE LOCALIZED ASC";
                    str2 = str4 + stringBuffer.toString().substring(1) + " )";
                    uriM2168a = uriM2174e;
                } else if (BuddyFragment.this.f419J == 5) {
                    Uri uriM2171b = ChatONContract.BuddyTable.m2171b();
                    String[] stringArray2 = BuddyFragment.this.f416G.getStringArray(ChatFragment.f724c);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    if (stringArray2.length > 0) {
                        String str6 = "buddy_no NOT IN ( ";
                        for (String str7 : stringArray2) {
                            stringBuffer2.append(", '" + str7 + "'");
                        }
                        str3 = str6 + stringBuffer2.toString().substring(1) + " )";
                    }
                    str = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC";
                    str2 = str3;
                    uriM2168a = uriM2171b;
                } else if (BuddyFragment.this.f419J == 8) {
                    Uri uriM2168a2 = ChatONContract.BuddyTable.m2168a();
                    str = "group_type, buddy_name COLLATE LOCALIZED ASC";
                    str2 = "buddy_no NOT IN (SELECT participants_buddy_no FROM participant WHERE participants_inbox_no = '" + BuddyFragment.this.f416G.getString("inboxNO") + "')";
                    uriM2168a = uriM2168a2;
                } else {
                    str = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC";
                    str2 = "";
                    uriM2168a = ChatONContract.BuddyTable.m2171b();
                }
            } else if (i == 12) {
                str = "group_type, relation_icon DESC, buddy_name COLLATE LOCALIZED ASC";
                str2 = "";
                uriM2168a = ChatONContract.BuddyTable.m2172c();
            } else if (i == 21) {
                str = "group_type, buddy_name COLLATE LOCALIZED ASC";
                str2 = "";
                uriM2168a = ChatONContract.BuddyTable.m2168a();
            } else {
                str = null;
                str2 = "";
                uriM2168a = null;
            }
            if (uriM2168a != null) {
                ChatONLogWriter.m3512f("URI : " + uriM2168a.toString(), BuddyFragment.f409a);
                ChatONLogWriter.m3512f("WHERE : " + str2, BuddyFragment.f409a);
                ChatONLogWriter.m3512f("WHERE ARGS : " + ((Object) null), BuddyFragment.f409a);
                ChatONLogWriter.m3512f("ORDER BY : " + str, BuddyFragment.f409a);
            }
            this.f478h.startQuery(i, null, uriM2168a, null, str2, null, str);
        }

        @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
        /* renamed from: a */
        public void mo529a(int i, Object obj, int i2) {
        }

        @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
        /* renamed from: a */
        public void mo530a(int i, Object obj, Cursor cursor) {
            if (BuddyFragment.this.getActivity() == null) {
                return;
            }
            ChatONLogWriter.m3512f("onQueryComplete() : " + i, BuddyFragment.f409a);
            if (i == this.f475e) {
                int count = cursor.getCount();
                cursor.close();
                BuddyFragment.this.f445aj = count;
                if (count > 0) {
                    BuddyFragment.this.m497h();
                } else if (BuddyFragment.this.f419J == 1) {
                    BuddyFragment.this.m495g();
                } else if (BuddyFragment.this.f419J == 5) {
                    Toast.makeText(BuddyFragment.this.f453i, BuddyFragment.this.getResources().getString(C0062R.string.buddy_list_invite_toast_failed_nomore), 0).show();
                    Intent intent = new Intent();
                    intent.putExtra("receivers", new String[0]);
                    BuddyFragment.this.getActivity().setResult(0, intent);
                    BuddyFragment.this.getActivity().finish();
                } else if (BuddyFragment.this.f419J == 6 || BuddyFragment.this.f419J == 3) {
                    BuddyFragment.this.m497h();
                }
            } else if (i == this.f476f) {
                int count2 = cursor.getCount();
                cursor.close();
                if (count2 >= 50) {
                    Toast.makeText(BuddyFragment.this.getActivity(), String.format(BuddyFragment.this.getResources().getString(C0062R.string.buddy_list_addfavorites_toast_failed_50), 50), 0).show();
                } else {
                    BuddyItem buddyItem = (BuddyItem) obj;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_relation_group", (Integer) 1);
                    contentValues.put("group_relation_buddy", buddyItem.m668a());
                    this.f478h.startInsert(BuddyFragment.this.f431V.f471a, buddyItem, ChatONContract.GroupRelationTable.f1715a, contentValues);
                }
            } else if (i == 11) {
                if (BuddyFragment.this.f419J == 6) {
                    BuddyFragment.this.m482c(cursor);
                } else if (BuddyFragment.this.f419J == 8) {
                    BuddyFragment.this.m477b(cursor);
                    BuddyFragment.this.m500j();
                } else {
                    BuddyFragment.this.m469a(cursor);
                    BuddyFragment.this.m500j();
                }
                BuddyFragment.this.m473a(BuddyFragment.this.f422M, BuddyFragment.this.f423N);
            } else if (i == 12) {
                BuddyFragment.this.m486d(cursor);
                BuddyFragment.this.m500j();
                BuddyFragment.this.m473a(BuddyFragment.this.f422M, BuddyFragment.this.f423N);
            } else if (i == 21) {
                BuddyFragment.this.m490e(cursor);
                BuddyFragment.this.f430U.m440a(21);
                if (BuddyFragment.this.f426Q.size() > 0) {
                    BuddyFragment.this.f456l.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
                    BuddyFragment.this.f463s.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
                } else {
                    BuddyFragment.this.f456l.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
                    BuddyFragment.this.f463s.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
                }
                BuddyFragment.this.m473a(BuddyFragment.this.f426Q, BuddyFragment.this.f427R);
            }
            if (i == 11 || i == 12 || i == 21) {
                BuddyFragment.this.m506m();
                if (i == 11) {
                    BuddyFragment.this.f456l.setFastScrollEnabled(false);
                    BuddyFragment.this.f430U.m439a();
                    BuddyFragment.this.f456l.setFastScrollEnabled(true);
                } else {
                    BuddyFragment.this.f456l.setFastScrollEnabled(false);
                }
            }
            cursor.close();
        }

        @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
        /* renamed from: a */
        public void mo531a(int i, Object obj, Uri uri) {
            if (BuddyFragment.this.getActivity() != null && i == this.f471a) {
                BuddyItem buddyItem = (BuddyItem) obj;
                if (Integer.parseInt(uri.getLastPathSegment()) == -1) {
                    Toast.makeText(BuddyFragment.this.getActivity(), BuddyFragment.this.getResources().getString(C0062R.string.buddy_list_addfavorites_toast_failed), 0).show();
                } else {
                    Toast.makeText(BuddyFragment.this.getActivity(), BuddyFragment.this.getString(C0062R.string.buddy_list_addfavorites_toast_success, buddyItem.m673b()), 0).show();
                    BuddyFragment.this.m498i();
                }
            }
        }

        /* renamed from: a */
        public void m532a(BuddyItem buddyItem) {
            ChatONLogWriter.m3512f("addFavorites() : " + this.f476f, BuddyFragment.f409a);
            this.f478h.startQuery(this.f476f, buddyItem, ChatONContract.GroupRelationTable.f1715a, null, "group_relation_group = 1 ", null, null);
        }

        /* renamed from: b */
        public void m533b() {
            ChatONLogWriter.m3512f("setNewBuddyClear() : " + this.f477g, BuddyFragment.f409a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("buddy_is_new", "N");
            contentValues.put("buddy_is_profile_updated", "N");
            contentValues.put("buddy_is_status_updated", "N");
            this.f478h.startUpdate(this.f477g, null, ChatONContract.BuddyTable.f1713a, contentValues, null, null);
        }

        @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
        /* renamed from: b */
        public void mo534b(int i, Object obj, int i2) throws Resources.NotFoundException {
            if (BuddyFragment.this.getActivity() != null && i == this.f472b) {
                if (i2 != -1) {
                    Toast.makeText(BuddyFragment.this.getActivity(), C0062R.string.buddy_list_removefavorites_toast_success, 0).show();
                    BuddyFragment.this.m498i();
                } else {
                    Toast.makeText(BuddyFragment.this.getActivity(), BuddyFragment.this.getResources().getString(C0062R.string.buddy_list_removefavorites_toast_failed), 0).show();
                }
            }
        }

        /* renamed from: b */
        public void m535b(BuddyItem buddyItem) {
            ChatONLogWriter.m3512f("removeFavorites() : " + this.f472b, BuddyFragment.f409a);
            this.f478h.startDelete(this.f472b, buddyItem, ChatONContract.GroupRelationTable.f1715a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{buddyItem.m668a()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m469a(Cursor cursor) {
        int i;
        int i2;
        int i3;
        ArrayList arrayList;
        String string;
        this.f422M.clear();
        this.f423N.clear();
        if (cursor.getCount() == 0 && this.f419J == 5) {
            Toast.makeText(this.f453i, getResources().getString(C0062R.string.buddy_list_invite_toast_failed_nomore), 0).show();
            Intent intent = new Intent();
            intent.putExtra("receivers", new String[0]);
            getActivity().setResult(0, intent);
            getActivity().finish();
            return;
        }
        String str = new SimpleDateFormat("MM-dd").format(new Date());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        cursor.moveToNext();
        if (cursor.getInt(cursor.getColumnIndex("group_type")) != 1) {
            this.f422M.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_group_favorites), 0, 1, false, false, 0));
            this.f423N.add(new ArrayList());
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (cursor.getInt(cursor.getColumnIndex("group_type")) > 1) {
                    i = i5;
                    break;
                }
                arrayList3.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y")));
                i4 = i5 + 1;
                if (!cursor.moveToNext()) {
                    i = i4;
                    break;
                }
            }
            this.f422M.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_group_favorites), i, 1, false, false, 0));
            this.f423N.add(arrayList3);
        }
        cursor.moveToPrevious();
        ArrayList arrayList4 = new ArrayList();
        while (cursor.moveToNext() && (string = cursor.getString(cursor.getColumnIndex("group_name"))) != null && string.length() != 0) {
            BuddyItem buddyItem = new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("group_name")), null, null, null, null, true, 0, cursor.getString(cursor.getColumnIndex("group_name")), false, 0, 0, 0, 0, 0, 0, 0, false, false);
            HashMap map = new HashMap();
            try {
                String str2 = "%%" + cursor.getString(cursor.getColumnIndex("buddy_no")) + "%%";
                String[] strArrSplit = cursor.getString(cursor.getColumnIndex("buddy_email")).split(str2);
                String[] strArrSplit2 = cursor.getString(cursor.getColumnIndex("buddy_samsung_email")).split(str2);
                if (strArrSplit.length > 0 && strArrSplit.length == strArrSplit2.length) {
                    for (int i6 = 0; i6 < strArrSplit.length; i6++) {
                        map.put(strArrSplit[i6], strArrSplit2[i6]);
                    }
                }
            } catch (Exception e) {
            }
            buddyItem.m675b(true);
            buddyItem.m671a(map);
            arrayList4.add(buddyItem);
        }
        this.f423N.add(arrayList4);
        this.f422M.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_optionmenu_sortby_group), arrayList4.size(), 1, false, false, 0));
        cursor.moveToPrevious();
        int i7 = 2;
        char c = 0;
        ArrayList arrayList5 = new ArrayList();
        int i8 = 0;
        while (cursor.moveToNext()) {
            char cM3597a = KoreanUtil.m3597a(Character.toUpperCase(cursor.getString(cursor.getColumnIndex("buddy_name")).charAt(0)));
            if (c == cM3597a || c == 0) {
                i2 = i8;
                i3 = i7;
                arrayList = arrayList5;
            } else {
                this.f423N.add(arrayList5);
                this.f422M.add(new BuddyGroupItem(i7, String.valueOf(c), i8, 2, false, false, 0));
                i2 = 0;
                i3 = i7 + 1;
                arrayList = new ArrayList();
            }
            BuddyItem buddyItem2 = new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y"));
            arrayList.add(buddyItem2);
            if ((buddyItem2.m681f().length() == 10 && buddyItem2.m681f().substring(5).equals(str)) || (buddyItem2.m681f().length() == 5 && buddyItem2.m681f().equals(str))) {
                arrayList2.add(buddyItem2);
            }
            i8 = i2 + 1;
            i7 = i3;
            c = cM3597a;
            arrayList5 = arrayList;
        }
        if (arrayList5.size() > 0) {
            this.f423N.add(arrayList5);
            int i9 = i7 + 1;
            this.f422M.add(new BuddyGroupItem(i7, String.valueOf(c), i8, 2, false, false, 0));
        }
        if (this.f419J == 5) {
        }
        boolean z = ChatONPref.m3519a().getBoolean("Profile Birth Chk", false);
        ChatONLogWriter.m3512f("BIRTHDAY CATEGORY SHOW SETTING : " + z, f409a);
        if (z && this.f419J == 1 && arrayList2.size() > 0) {
            this.f422M.add(0, new BuddyGroupItem(0, getResources().getString(C0062R.string.buddy_list_group_birthday), arrayList2.size(), 0, true, false, 0));
            this.f423N.add(0, arrayList2);
        }
    }

    /* renamed from: a */
    private void m472a(ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        Iterator it = this.f423N.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m692q()) {
                    hashSet.add(buddyItem.m668a());
                }
            }
        }
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            String str = (String) it3.next();
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                Iterator it5 = ((ArrayList) it4.next()).iterator();
                while (it5.hasNext()) {
                    BuddyItem buddyItem2 = (BuddyItem) it5.next();
                    if (buddyItem2.m668a().equals(str)) {
                        buddyItem2.m672a(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m473a(ArrayList arrayList, ArrayList arrayList2) {
        this.f424O.clear();
        this.f425P.clear();
        if (this.f419J == 9) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) it.next()).iterator();
                while (it2.hasNext()) {
                    BuddyItem buddyItem = (BuddyItem) it2.next();
                    buddyItem.m672a(true);
                    Iterator it3 = this.f443ah.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            String str = (String) it3.next();
                            if (buddyItem.m668a().equals(str)) {
                                buddyItem.m672a(false);
                                ChatONLogWriter.m3511e("SupplyDataToAdapter buddy set to false:" + str, f409a);
                                break;
                            }
                        }
                    }
                }
            }
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            this.f424O.add(new BuddyGroupItem((BuddyGroupItem) it4.next()));
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            ArrayList arrayList3 = (ArrayList) it5.next();
            ArrayList arrayList4 = new ArrayList();
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                arrayList4.add(new BuddyItem((BuddyItem) it6.next()));
            }
            this.f425P.add(arrayList4);
        }
        this.f430U.notifyDataSetChanged();
        this.f430U.m444b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m477b(Cursor cursor) {
        int i;
        int i2;
        int i3;
        ArrayList arrayList;
        this.f422M.clear();
        this.f423N.clear();
        if (cursor.getCount() == 0) {
            this.f422M.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_group_favorites), 0, 1, false, false, 0));
            this.f423N.add(new ArrayList());
            return;
        }
        String str = new SimpleDateFormat("MM-dd").format(new Date());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        cursor.moveToNext();
        if (cursor.getInt(cursor.getColumnIndex("group_type")) != 1) {
            this.f422M.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_group_favorites), 0, 1, false, false, 0));
            this.f423N.add(new ArrayList());
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (cursor.getInt(cursor.getColumnIndex("group_type")) > 1) {
                    i = i5;
                    break;
                }
                arrayList3.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y")));
                i4 = i5 + 1;
                if (!cursor.moveToNext()) {
                    i = i4;
                    break;
                }
            }
            this.f422M.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_group_favorites), i, 1, false, false, 0));
            this.f423N.add(arrayList3);
        }
        cursor.moveToPrevious();
        int i6 = 2;
        char c = 0;
        ArrayList arrayList4 = new ArrayList();
        int i7 = 0;
        while (cursor.moveToNext()) {
            char cM3597a = KoreanUtil.m3597a(Character.toUpperCase(cursor.getString(cursor.getColumnIndex("buddy_name")).charAt(0)));
            if (c == cM3597a || c == 0) {
                i2 = i7;
                i3 = i6;
                arrayList = arrayList4;
            } else {
                this.f423N.add(arrayList4);
                this.f422M.add(new BuddyGroupItem(i6, String.valueOf(c), i7, 2, false, false, 0));
                i2 = 0;
                i3 = i6 + 1;
                arrayList = new ArrayList();
            }
            BuddyItem buddyItem = new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y"));
            arrayList.add(buddyItem);
            if ((buddyItem.m681f().length() == 10 && buddyItem.m681f().substring(5).equals(str)) || (buddyItem.m681f().length() == 5 && buddyItem.m681f().equals(str))) {
                arrayList2.add(buddyItem);
            }
            i7 = i2 + 1;
            i6 = i3;
            c = cM3597a;
            arrayList4 = arrayList;
        }
        if (arrayList4.size() > 0) {
            this.f423N.add(arrayList4);
            int i8 = i6 + 1;
            this.f422M.add(new BuddyGroupItem(i6, String.valueOf(c), i7, 2, false, false, 0));
        }
        if (this.f419J == 5) {
        }
        boolean z = ChatONPref.m3519a().getBoolean("Profile Birth Chk", false);
        ChatONLogWriter.m3512f("BIRTHDAY CATEGORY SHOW SETTING : " + z, f409a);
        if (z && this.f419J == 1 && arrayList2.size() > 0) {
            this.f422M.add(0, new BuddyGroupItem(0, getResources().getString(C0062R.string.buddy_list_group_birthday), arrayList2.size(), 0, true, false, 0));
            this.f423N.add(0, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m482c(Cursor cursor) {
        int i;
        int i2;
        ArrayList arrayList;
        this.f422M.clear();
        this.f423N.clear();
        new ArrayList();
        if (cursor.getCount() == 0) {
            return;
        }
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        int i3 = 2;
        char c = 0;
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        while (cursor.moveToNext()) {
            char cM3597a = KoreanUtil.m3597a(Character.toUpperCase(cursor.getString(cursor.getColumnIndex("buddy_name")).charAt(0)));
            if (cursor.getInt(cursor.getColumnIndex("group_relation_group")) != 1) {
                if (c == cM3597a || c == 0) {
                    i = i4;
                    i2 = i3;
                    arrayList = arrayList2;
                } else {
                    this.f423N.add(arrayList2);
                    this.f422M.add(new BuddyGroupItem(i3, String.valueOf(c), i4, 2, false, false, 0));
                    i = 0;
                    i2 = i3 + 1;
                    arrayList = new ArrayList();
                }
                arrayList.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y")));
                i4 = i + 1;
                i3 = i2;
                c = cM3597a;
                arrayList2 = arrayList;
            }
        }
        this.f423N.add(arrayList2);
        int i5 = i3 + 1;
        this.f422M.add(new BuddyGroupItem(i3, String.valueOf(c), i4, 2, false, false, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m486d(Cursor cursor) {
        int i;
        int i2;
        int i3;
        ArrayList arrayList;
        int i4;
        this.f422M.clear();
        this.f423N.clear();
        String str = new SimpleDateFormat("MM-dd").format(new Date());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i5 = 0;
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (true) {
            i = i5;
            if (!cursor.moveToNext()) {
                break;
            }
            if (cursor.getInt(cursor.getColumnIndex("group_type")) > 1) {
                cursor.moveToPrevious();
                break;
            } else {
                arrayList3.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y")));
                i5 = i + 1;
            }
        }
        this.f422M.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_group_favorites), i, 1, false, false, -1));
        this.f423N.add(arrayList3);
        int i6 = 0;
        int i7 = -1;
        ArrayList arrayList4 = new ArrayList();
        int i8 = 2;
        while (cursor.moveToNext()) {
            int i9 = cursor.getInt(cursor.getColumnIndex("relation_icon"));
            if (i9 != i7) {
                if (i7 != -1) {
                    this.f423N.add(arrayList4);
                    this.f422M.add(new BuddyGroupItem(i8, getResources().getString(C0062R.string.buddy_list_group_level) + " " + String.valueOf(i7), i6, 2, false, false, i7));
                    i4 = 0;
                    i8++;
                } else {
                    i4 = i6;
                }
                i2 = i4;
                i3 = i8;
                arrayList = new ArrayList();
            } else {
                i2 = i6;
                i3 = i8;
                arrayList = arrayList4;
            }
            BuddyItem buddyItem = new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y"));
            arrayList.add(buddyItem);
            if ((buddyItem.m681f().length() == 10 && buddyItem.m681f().substring(5).equals(str)) || (buddyItem.m681f().length() == 5 && buddyItem.m681f().equals(str))) {
                arrayList2.add(buddyItem);
            }
            i6 = i2 + 1;
            i8 = i3;
            i7 = i9;
            arrayList4 = arrayList;
        }
        this.f423N.add(arrayList4);
        int i10 = i8 + 1;
        this.f422M.add(new BuddyGroupItem(i8, getResources().getString(C0062R.string.buddy_list_group_level) + " " + String.valueOf(i7), i6, 2, false, false, i7));
        if (ChatONPref.m3519a().getBoolean("Profile Birth Chk", true) && this.f419J == 1 && arrayList2.size() > 0) {
            this.f422M.add(0, new BuddyGroupItem(0, getResources().getString(C0062R.string.buddy_list_group_birthday), arrayList2.size(), 0, true, false, -2));
            this.f423N.add(0, arrayList2);
        }
    }

    /* renamed from: e */
    private void m489e() throws Resources.NotFoundException {
        ChatONLogWriter.m3512f("initView()", f409a);
        this.f454j = (LinearLayout) getView().findViewById(C0062R.id.buddy_list_layout);
        this.f455k = (LinearLayout) getView().findViewById(C0062R.id.tell_friends_layout);
        this.f463s = (LinearLayout) getView().findViewById(C0062R.id.buddy_list_noresult_layout);
        this.f464t = (TextView) getView().findViewById(C0062R.id.title_menu);
        this.f467w = (EditText) getView().findViewById(C0062R.id.edit_title);
        this.f468x = (EditText) getView().findViewById(C0062R.id.tmp_title);
        this.f469y = (Button) getView().findViewById(C0062R.id.buddy_menu_save);
        this.f470z = (RelativeLayout) getView().findViewById(C0062R.id.chat_title_bar);
        this.f415F = (LinearLayout) getView().findViewById(C0062R.id.searcdh_bar);
        this.f456l = (ExpandableListView) getView().findViewById(C0062R.id.buddy_list);
        this.f456l.setOnGroupClickListener(this);
        this.f456l.setOnGroupCollapseListener(this);
        this.f456l.setOnGroupExpandListener(this);
        this.f456l.setOnChildClickListener(this);
        this.f459o = (EditText) getView().findViewById(C0062R.id.buddy_search);
        this.f457m = (LinearLayout) getView().findViewById(C0062R.id.buddy_menu_bar);
        this.f458n = (LinearLayout) getView().findViewById(C0062R.id.lLayoutProfile);
        this.f462r = (TextView) getView().findViewById(C0062R.id.textNames);
        this.f460p = (Button) getView().findViewById(C0062R.id.tell_friends_button);
        this.f461q = (Button) getView().findViewById(C0062R.id.buddy_menu_invite);
        this.f432W = (HorizontalScrollView) getView().findViewById(C0062R.id.buddy_choice_panel);
        Drawable drawable = getResources().getDrawable(C0062R.drawable.ic_btn_search);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f459o.setCompoundDrawables(null, null, drawable, null);
        this.f417H = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getInt("BUDDY_SORT_STYLE", 11);
        if (this.f417H == 13) {
            this.f417H = 11;
        }
        this.f416G = getArguments();
        if (this.f416G == null) {
            this.f419J = 1;
            this.f418I = this.f417H;
        } else {
            this.f419J = this.f416G.getInt("ACTIVITY_PURPOSE", 1);
        }
        if (this.f419J == 1) {
            this.f457m.setVisibility(8);
            registerForContextMenu(this.f456l);
        } else if (this.f419J == 6) {
            setHasOptionsMenu(true);
            this.f417H = 11;
            this.f457m.setVisibility(8);
            this.f459o.setVisibility(8);
            this.f468x.setVisibility(0);
            this.f458n.setVisibility(8);
            this.f467w.setVisibility(0);
            this.f469y.setVisibility(8);
            this.f470z.setVisibility(0);
            this.f467w.setSingleLine();
            this.f414E = this.f416G.getString(ChatFragment.f725d);
            this.f410A = this.f416G.getString("inboxNO");
            this.f412C = this.f416G.getInt("chatType");
            this.f465u = this.f416G.getBoolean(ChatFragment.f728g);
            this.f413D = this.f416G.getStringArray(ChatFragment.f724c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f415F.getLayoutParams());
            layoutParams.height = (int) Dip.m3571a(54.0f);
            layoutParams.addRule(3, C0062R.id.buddy_choice_panel);
            this.f415F.setLayoutParams(layoutParams);
            this.f415F.setBackgroundColor(C0062R.color.transparent);
            this.f467w.setOnClickListener(new ViewOnClickListenerC0101ay(this));
            this.f469y.setOnClickListener(new ViewOnClickListenerC0100ax(this));
            this.f467w.setText(this.f414E);
            this.f467w.addTextChangedListener(new C0105bb(this));
            ChatONLogWriter.m3509d("mChattitle:" + this.f414E);
            this.f467w.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0106bc(this));
        } else {
            this.f457m.findViewById(C0062R.id.buddy_menu_group_chat).setVisibility(8);
            this.f457m.findViewById(C0062R.id.buddy_menu_broadcast).setVisibility(8);
            this.f457m.findViewById(C0062R.id.buddy_menu_invite).setVisibility(8);
            this.f457m.findViewById(C0062R.id.buddy_menu_add_group).setVisibility(8);
            this.f457m.findViewById(C0062R.id.buddy_menu_blind_memo).setVisibility(8);
            this.f457m.setVisibility(0);
            if (this.f419J == 2) {
                this.f457m.findViewById(C0062R.id.buddy_menu_group_chat).setVisibility(0);
            } else if (this.f419J == 3) {
                this.f457m.findViewById(C0062R.id.buddy_menu_broadcast).setVisibility(0);
            } else if (this.f419J == 5) {
                if (this.f416G.getInt("chatType") == ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a()) {
                    this.f461q.setText(C0062R.string.invite_create_groupchat);
                }
                this.f461q.setVisibility(0);
                this.f417H = 11;
            } else if (this.f419J == 8) {
                this.f417H = 11;
                this.f457m.setVisibility(8);
            } else if (this.f419J == 9) {
                this.f457m.findViewById(C0062R.id.buddy_menu_blind_memo).setVisibility(0);
            } else if (this.f419J == 10) {
                this.f457m.findViewById(C0062R.id.buddy_menu_add_group).setVisibility(0);
            }
            this.f456l.setChoiceMode(2);
            this.f456l.setItemsCanFocus(false);
        }
        this.f457m.findViewById(C0062R.id.buddy_menu_group_chat).setOnClickListener(this.f446b);
        this.f457m.findViewById(C0062R.id.buddy_menu_broadcast).setOnClickListener(this.f446b);
        this.f457m.findViewById(C0062R.id.buddy_menu_invite).setOnClickListener(this.f446b);
        this.f457m.findViewById(C0062R.id.buddy_menu_add_group).setOnClickListener(this.f446b);
        this.f457m.findViewById(C0062R.id.buddy_menu_cancel).setOnClickListener(this.f446b);
        this.f457m.findViewById(C0062R.id.buddy_menu_blind_memo).setOnClickListener(this.f446b);
        this.f460p.setOnClickListener(new ViewOnClickListenerC0102az(this));
        m492f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m490e(Cursor cursor) {
        int i;
        ArrayList arrayList;
        int i2;
        int i3;
        ArrayList arrayList2;
        this.f426Q.clear();
        this.f427R.clear();
        String string = this.f459o.getText().toString();
        new ArrayList();
        if (cursor.getCount() == 0) {
            return;
        }
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        int i4 = 2;
        ArrayList arrayList3 = new ArrayList();
        int i5 = 0;
        char c = 0;
        while (cursor.moveToNext()) {
            String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
            boolean z = false;
            if (HangulJamoUtil.m3582a(string2.toUpperCase(), string.toUpperCase())) {
                if (this.f419J == 5 || this.f419J == 8) {
                    String string3 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                    Iterator it = this.f423N.iterator();
                    while (true) {
                        boolean z2 = z;
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        Iterator it2 = ((ArrayList) it.next()).iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = z2;
                                break;
                            }
                            BuddyItem buddyItem = (BuddyItem) it2.next();
                            if (!buddyItem.m697v() && string3.equals(buddyItem.m668a())) {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            break;
                        }
                    }
                } else {
                    z = true;
                }
                if (z) {
                    char cM3597a = KoreanUtil.m3597a(Character.toUpperCase(string2.charAt(0)));
                    if (cursor.getInt(cursor.getColumnIndex("group_relation_group")) != 1) {
                        if (c == cM3597a || c == 0) {
                            i2 = i5;
                            i3 = i4;
                            arrayList2 = arrayList3;
                        } else {
                            this.f427R.add(arrayList3);
                            this.f426Q.add(new BuddyGroupItem(i4, String.valueOf(c), i5, 2, false, false, 0));
                            i2 = 0;
                            i3 = i4 + 1;
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), 0, 0, 0, 0, 0, 0, cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), cursor.getString(cursor.getColumnIndex("buddy_is_profile_updated")).equals("Y"), cursor.getString(cursor.getColumnIndex("buddy_is_status_updated")).equals("Y")));
                        i = i2 + 1;
                        i4 = i3;
                        c = cM3597a;
                        arrayList = arrayList2;
                    }
                }
            } else {
                i = i5;
                arrayList = arrayList3;
            }
            arrayList3 = arrayList;
            i5 = i;
        }
        if (c != 0) {
            this.f427R.add(arrayList3);
            int i6 = i4 + 1;
            this.f426Q.add(new BuddyGroupItem(i4, String.valueOf(c), i5, 2, false, false, 0));
        }
        m472a(this.f427R);
    }

    /* renamed from: f */
    private void m492f() {
        if (this.f419J == 1) {
            this.f464t.setVisibility(8);
            return;
        }
        if (this.f419J == 2) {
            this.f464t.setVisibility(0);
            this.f464t.setText(getString(C0062R.string.buddy_list_optionmenu_groupchat));
            return;
        }
        if (this.f419J == 3) {
            this.f464t.setVisibility(0);
            this.f464t.setText(getString(C0062R.string.buddy_list_optionmenu_broadcast));
            return;
        }
        if (this.f419J == 5) {
            this.f464t.setVisibility(0);
            this.f464t.setText(getString(C0062R.string.chat_view_menu_invite));
            return;
        }
        if (this.f419J == 6) {
            this.f464t.setVisibility(0);
            if (ChatONContract.InBoxTable.ChatType.m2188a(this.f412C) == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                this.f464t.setText(getString(C0062R.string.buddy_chat_profile, Integer.valueOf(this.f413D.length + 1)));
                return;
            } else {
                this.f464t.setText(getString(C0062R.string.buddy_chat_profile, Integer.valueOf(this.f413D.length)));
                return;
            }
        }
        if (this.f419J != 8) {
            if (this.f419J == 9) {
                this.f464t.setVisibility(0);
                this.f464t.setText(C0062R.string.mypage_buddies_say);
            } else if (this.f419J == 10) {
                this.f464t.setVisibility(0);
                this.f464t.setText(getString(C0062R.string.buddy_list_optionmenu_addgroup));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m495g() {
        this.f419J = 7;
        this.f454j.setVisibility(8);
        this.f455k.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m497h() {
        if (this.f419J == 7) {
            this.f419J = 1;
        }
        this.f454j.setVisibility(0);
        this.f455k.setVisibility(8);
        boolean z = (this.f419J == 1 || this.f419J == 6 || this.f419J == 8) ? false : true;
        if (this.f430U == null) {
            this.f430U = new BuddyAdapter(this.f456l, getActivity(), this.f424O, C0062R.layout.buddy_adapter_group_item, this.f425P, C0062R.layout.buddy_adapter_child_item, z, this.f417H, this.f457m, this.f419J, this.f464t, this.f416G);
            this.f456l.setAdapter(this.f430U);
        }
        m498i();
        if (this.f419J != 9) {
            this.f430U.m441a(this.f432W);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m498i() {
        ChatONLogWriter.m3512f("refreshList()", f409a);
        this.f459o.removeTextChangedListener(this.f444ai);
        this.f459o.setText("");
        this.f459o.addTextChangedListener(this.f444ai);
        if (this.f430U != null) {
            this.f430U.m440a(this.f417H);
            this.f431V.m528a(this.f417H);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m500j() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.f423N.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m685j() && !arrayList2.contains(buddyItem.m668a())) {
                    arrayList.add(buddyItem);
                    arrayList2.add(buddyItem.m668a());
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f422M.add(0, new BuddyGroupItem(-1, getResources().getString(C0062R.string.buddy_list_group_new_buddy), arrayList.size(), -1, true, false, 0));
            this.f423N.add(0, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m503k() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f434Y) {
            return;
        }
        for (int i = 0; i < this.f424O.size(); i++) {
            if (!this.f456l.isGroupExpanded(i) && ((BuddyGroupItem) this.f424O.get(i)).m659d() != -1) {
                stringBuffer.append("," + ((BuddyGroupItem) this.f424O.get(i)).m657b());
            }
        }
        if (this.f419J == 1) {
            getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putInt("BUDDY_SORT_STYLE", this.f417H).commit();
            if (this.f417H == 12) {
                if (stringBuffer.toString().length() > 0) {
                    getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", stringBuffer.toString().substring(1)).commit();
                    return;
                } else {
                    getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("RELATIONSHIP_FOLDER_STATE", null).commit();
                    return;
                }
            }
            if (this.f417H == 11) {
                if (stringBuffer.toString().length() > 0) {
                    getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", stringBuffer.toString().substring(1)).commit();
                } else {
                    getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).edit().putString("ALPHABET_FOLDER_STATE", null).commit();
                }
            }
        }
    }

    /* renamed from: l */
    private void m505l() {
        String string = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("RELATIONSHIP_FOLDER_STATE", null);
        if (string != null) {
            this.f420K = string.split(",");
        } else {
            this.f420K = new String[0];
        }
        String string2 = getActivity().getSharedPreferences("BUDDY_ACTIVITY", 0).getString("ALPHABET_FOLDER_STATE", null);
        if (string2 != null) {
            this.f421L = string2.split(",");
        } else {
            this.f421L = new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m506m() {
        if (this.f434Y || this.f419J == 6) {
            for (int i = 0; i < this.f424O.size(); i++) {
                this.f456l.expandGroup(i);
            }
            return;
        }
        if (this.f419J == 5) {
            for (int i2 = 0; i2 < this.f424O.size(); i2++) {
                if (((BuddyGroupItem) this.f424O.get(i2)).m659d() < 2) {
                    this.f456l.collapseGroup(i2);
                } else {
                    this.f456l.expandGroup(i2);
                }
            }
            return;
        }
        m505l();
        for (int i3 = 0; i3 < this.f424O.size(); i3++) {
            this.f456l.expandGroup(i3);
        }
        String[] strArr = (this.f417H != 12 || this.f420K == null) ? (this.f417H != 11 || this.f421L == null) ? null : this.f421L : this.f420K;
        if (strArr != null) {
            for (int i4 = 0; i4 < this.f424O.size(); i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= strArr.length) {
                        break;
                    }
                    if (((BuddyGroupItem) this.f424O.get(i4)).m657b().equals(strArr[i5])) {
                        this.f456l.collapseGroup(i4);
                        break;
                    }
                    i5++;
                }
                if (this.f419J == 1 && this.f418I != this.f417H && ((BuddyGroupItem) this.f424O.get(i4)).m659d() < 2) {
                    this.f456l.collapseGroup(i4);
                }
            }
        }
        if (((BuddyGroupItem) this.f424O.get(0)).m659d() == -1) {
            this.f456l.expandGroup(0);
        }
        this.f418I = this.f417H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m508n() throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(C0062R.drawable.btn_del);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (this.f459o.getText().toString().length() > 0) {
            this.f459o.setCompoundDrawables(null, null, drawable, null);
            this.f459o.setOnTouchListener(new ViewOnTouchListenerC0110c(this, drawable));
        } else {
            Drawable drawable2 = getResources().getDrawable(C0062R.drawable.ic_btn_search);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.f459o.setCompoundDrawables(null, null, drawable2, null);
            this.f459o.setOnTouchListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m511o() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f459o.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m513p() {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = this.f425P.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m692q()) {
                    hashSet.add(buddyItem.m668a());
                } else {
                    hashSet2.add(buddyItem.m668a());
                }
            }
        }
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            String str = (String) it3.next();
            Iterator it4 = this.f423N.iterator();
            while (it4.hasNext()) {
                Iterator it5 = ((ArrayList) it4.next()).iterator();
                while (it5.hasNext()) {
                    BuddyItem buddyItem2 = (BuddyItem) it5.next();
                    if (buddyItem2.m668a().equals(str)) {
                        buddyItem2.m672a(true);
                    }
                }
            }
        }
        Iterator it6 = hashSet2.iterator();
        while (it6.hasNext()) {
            String str2 = (String) it6.next();
            Iterator it7 = this.f423N.iterator();
            while (it7.hasNext()) {
                Iterator it8 = ((ArrayList) it7.next()).iterator();
                while (it8.hasNext()) {
                    BuddyItem buddyItem3 = (BuddyItem) it8.next();
                    if (buddyItem3.m668a().equals(str2)) {
                        buddyItem3.m672a(false);
                    }
                }
            }
        }
    }

    /* renamed from: q */
    private void m515q() {
        Iterator it = this.f423N.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m685j() || buddyItem.m696u() || buddyItem.m695t()) {
                    this.f431V.m533b();
                    return;
                }
            }
        }
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: a */
    public void mo390a() {
        setHasOptionsMenu(true);
        this.f437ab = true;
        ChatONLogWriter.m3512f("onTabSelected() : " + this.f437ab, f409a);
        if (this.f438ac && this.f430U != null) {
            this.f431V.m527a();
        }
        this.f438ac = false;
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: b */
    public void mo391b() {
        setHasOptionsMenu(false);
        m515q();
        m511o();
        this.f437ab = false;
        ChatONLogWriter.m3512f("onTabUnSelected() : " + this.f437ab, f409a);
    }

    /* renamed from: c */
    public int m525c() {
        return this.f445aj;
    }

    @Override // com.sec.chaton.chat.ChatActivity.OnBackKeyListener
    /* renamed from: d */
    public boolean mo526d() {
        if (this.f419J != 6) {
            return true;
        }
        ChatONLogWriter.m3509d("mEditTitle.isFocusable()" + this.f467w.isFocused());
        if (this.f467w.isFocused()) {
            this.f468x.requestFocus();
            ChatONLogWriter.m3509d("포커스다");
            return false;
        }
        if (!this.f465u && this.f411B == null) {
            if (ChatONContract.InBoxTable.ChatType.m2188a(this.f412C) == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                this.f411B += this.f414E + " (" + (this.f413D.length + 1) + ")";
            } else if (ChatONContract.InBoxTable.ChatType.m2188a(this.f412C) == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                this.f411B += this.f414E + " (" + this.f413D.length + ")";
            } else {
                this.f411B = this.f414E;
            }
            this.f411B = this.f414E;
        }
        if (this.f411B != null) {
            if (ChatONContract.InBoxTable.ChatType.m2188a(this.f412C) == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                this.f411B += " (" + (this.f413D.length + 1) + ")";
            } else if (ChatONContract.InBoxTable.ChatType.m2188a(this.f412C) == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                this.f411B += " (" + this.f413D.length + ")";
            } else {
                this.f411B = this.f414E;
            }
        }
        Intent intent = new Intent();
        intent.putExtra("receivers", (String[]) null);
        intent.putExtra(ChatFragment.f728g, this.f411B);
        getActivity().setResult(-1, intent);
        getActivity().finish();
        ChatONLogWriter.m3509d("포커스가 아니다");
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) throws Resources.NotFoundException {
        ChatONLogWriter.m3512f("onActivityCreated()", f409a);
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE)) {
                this.f440ae = arguments.getInt(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE);
                ChatONLogWriter.m3509d("Buddy content_type:" + this.f440ae);
                this.f439ad = true;
            }
            if (arguments.containsKey("download_uri")) {
                this.f441af = arguments.getString("download_uri");
                ChatONLogWriter.m3509d("Buddy download_uri:" + this.f441af);
            }
            if (arguments.containsKey("sub_content")) {
                this.f442ag = arguments.getString("sub_content");
                ChatONLogWriter.m3509d("Buddy sub_content:" + this.f442ag);
            }
        }
        m505l();
        m489e();
        if (this.f437ab) {
            this.f431V.m527a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            ChatONLogWriter.m3512f("Add buddy success", f409a);
            if (this.f431V != null) {
                this.f431V.m527a();
            }
        }
        if (i2 == -1) {
            switch (i) {
                case 4:
                    String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
                    Intent intent2 = new Intent();
                    intent2.putExtra("receivers", stringArrayExtra);
                    getActivity().setResult(-1, intent2);
                    getActivity().finish();
                    break;
            }
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        boolean z;
        BuddyItem buddyItem = (BuddyItem) ((ArrayList) this.f425P.get(i)).get(i2);
        if (buddyItem.m697v()) {
            if (this.f419J == 2 || this.f419J == 3 || this.f419J == 10 || this.f419J == 9) {
                HashMap mapM698w = buddyItem.m698w();
                if (mapM698w != null && mapM698w.size() > 0) {
                    Iterator it = mapM698w.keySet().iterator();
                    while (it.hasNext()) {
                        String strValueOf = String.valueOf(it.next());
                        ChatONLogWriter.m3512f(strValueOf + ", " + ((String) mapM698w.get(strValueOf)), f409a);
                        this.f430U.m443a(strValueOf, true);
                        this.f430U.m444b();
                    }
                    this.f456l.invalidateViews();
                }
            } else if (this.f419J == 5) {
                HashMap mapM698w2 = buddyItem.m698w();
                String[] stringArray = this.f416G.getStringArray(ChatFragment.f724c);
                if (mapM698w2 != null && mapM698w2.size() > 0) {
                    Iterator it2 = mapM698w2.keySet().iterator();
                    while (it2.hasNext()) {
                        String strValueOf2 = String.valueOf(it2.next());
                        ChatONLogWriter.m3512f(strValueOf2 + ", " + ((String) mapM698w2.get(strValueOf2)), f409a);
                        int length = stringArray.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                z = false;
                                break;
                            }
                            if (stringArray[i3].equals(strValueOf2)) {
                                z = true;
                                break;
                            }
                            i3++;
                        }
                        if (!z) {
                            this.f430U.m443a(strValueOf2, true);
                        }
                    }
                    this.f430U.m444b();
                    this.f456l.invalidateViews();
                }
            } else if (this.f419J == 1) {
                HashMap mapM698w3 = buddyItem.m698w();
                BuddyGroupListItem buddyGroupListItem = new BuddyGroupListItem(Integer.parseInt(buddyItem.m668a()), buddyItem.m673b(), mapM698w3 == null ? 0 : mapM698w3.size(), 2);
                Intent intent = new Intent(this.f453i, (Class<?>) BuddyGroupEditActivity.class);
                intent.putExtra("ACTIVITY_PURPOSE", 3);
                intent.putExtra("ACTIVITY_PURPOSE_ARG1", buddyGroupListItem);
                this.f453i.startActivity(intent);
            }
        } else if (this.f419J == 1 || this.f419J == 8) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
            intent2.setFlags(67108864);
            intent2.putExtra("chatType", ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a());
            intent2.putExtra("receivers", new String[]{buddyItem.m668a()});
            if (this.f439ad) {
                intent2.putExtra(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, this.f440ae);
                intent2.putExtra("download_uri", this.f441af);
                if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f440ae) == ChatONContract.MessageTable.MsgContentType.CALENDAR || ChatONContract.MessageTable.MsgContentType.m2195a(this.f440ae) == ChatONContract.MessageTable.MsgContentType.CONTACT) {
                    intent2.putExtra("sub_content", this.f442ag);
                }
                startActivity(intent2);
                getActivity().finish();
            } else {
                ((BaseActivity) getActivity()).openActivityOrFragment(intent2);
            }
        } else if (this.f419J == 2 || this.f419J == 3 || this.f419J == 5 || this.f419J == 10 || this.f419J == 9) {
            CheckBox checkBox = (CheckBox) view.findViewById(C0062R.id.buddy_child_check);
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
            } else {
                checkBox.setChecked(true);
            }
            buddyItem.m672a(checkBox.isChecked());
            this.f430U.m443a(buddyItem.m668a(), checkBox.isChecked());
            this.f430U.m444b();
            this.f456l.invalidateViews();
        } else if (this.f419J == 6) {
            Intent intent3 = new Intent(this.f453i, (Class<?>) BuddyProfileActivity.class);
            intent3.putExtra("PROFILE_BUDDY_NO", buddyItem.m668a());
            intent3.putExtra("PROFILE_BUDDY_NAME", buddyItem.m673b());
            intent3.setFlags(268435456);
            this.f453i.startActivity(intent3);
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        new Timer(true).schedule(new C0114g(this, new Handler()), 100L);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        ChatONLogWriter.m3512f("onCreate()", f409a);
        super.onCreate(bundle);
        this.f453i = getActivity();
        this.f431V = new DbRequest();
        this.f453i.getContentResolver().registerContentObserver(ChatONContract.BuddyTable.f1713a, true, this.f452h);
        this.f453i.getContentResolver().registerContentObserver(ChatONContract.GroupTable.f1716a, true, this.f452h);
        this.f453i.getContentResolver().registerContentObserver(ChatONContract.GroupRelationTable.f1715a, true, this.f452h);
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        ArrayList arrayList;
        boolean z;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ExpandableListView.ExpandableListContextMenuInfo expandableListContextMenuInfo = (ExpandableListView.ExpandableListContextMenuInfo) contextMenuInfo;
        int packedPositionType = ExpandableListView.getPackedPositionType(expandableListContextMenuInfo.packedPosition);
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListContextMenuInfo.packedPosition);
        if (packedPositionType == 1) {
            int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListContextMenuInfo.packedPosition);
            if (((BuddyItem) ((ArrayList) this.f425P.get(packedPositionGroup)).get(packedPositionChild)).m697v()) {
                contextMenu.setHeaderTitle(((BuddyItem) ((ArrayList) this.f425P.get(packedPositionGroup)).get(packedPositionChild)).m673b());
                contextMenu.add(0, 111, 1, getResources().getString(C0062R.string.buddy_group_list_dialog_removegroup_title)).setOnMenuItemClickListener(this.f447c);
                contextMenu.add(0, 112, 2, getResources().getString(C0062R.string.buddy_list_contextual_menu_viewprofile)).setOnMenuItemClickListener(this.f447c);
                return;
            }
            this.f429T = ((BuddyItem) ((ArrayList) this.f425P.get(packedPositionGroup)).get(packedPositionChild)).m694s();
            contextMenu.setHeaderTitle(((BuddyItem) ((ArrayList) this.f425P.get(packedPositionGroup)).get(packedPositionChild)).m673b());
            contextMenu.add(0, 101, 1, getResources().getString(C0062R.string.buddy_list_contextual_menu_viewprofile)).setOnMenuItemClickListener(this.f447c);
            int i = 0;
            while (true) {
                if (i >= this.f422M.size()) {
                    arrayList = null;
                    break;
                } else {
                    if (((BuddyGroupItem) this.f422M.get(i)).m659d() == 1) {
                        arrayList = (ArrayList) this.f423N.get(i);
                        break;
                    }
                    i++;
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((BuddyItem) it.next()).m668a().equals(((BuddyItem) ((ArrayList) this.f425P.get(packedPositionGroup)).get(packedPositionChild)).m668a())) {
                        z = true;
                        break;
                    }
                }
                z = false;
            } else {
                z = false;
            }
            if (z) {
                contextMenu.add(0, 103, 2, getResources().getString(C0062R.string.buddy_list_contextual_menu_removefavorites)).setOnMenuItemClickListener(this.f447c);
            } else {
                contextMenu.add(0, 102, 2, getResources().getString(C0062R.string.buddy_list_contextual_menu_addfavorites)).setOnMenuItemClickListener(this.f447c);
            }
            contextMenu.add(0, 105, 3, getResources().getString(C0062R.string.buddy_list_contextual_menu_shortcut)).setOnMenuItemClickListener(this.f447c);
            contextMenu.add(0, 104, 4, getResources().getString(C0062R.string.buddy_list_contextual_menu_block)).setOnMenuItemClickListener(this.f447c);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ChatONLogWriter.m3512f("onCreateView()", f409a);
        return layoutInflater.inflate(C0062R.layout.buddy_layout2, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f453i.getContentResolver().unregisterContentObserver(this.f452h);
        super.onDestroy();
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return false;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i) {
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Bitmap bitmap;
        this.f459o.setText("");
        m511o();
        switch (menuItem.getItemId()) {
            case 1:
                this.f436aa = new AlertDialog.Builder(this.f453i).setTitle(getString(C0062R.string.buddy_list_optionmenu_listby)).setSingleChoiceItems(new String[]{getString(C0062R.string.buddy_list_optionmenu_sortby_option_buddy), getString(C0062R.string.buddy_list_optionmenu_sortby_option_interaction)}, this.f417H - 11, new DialogInterfaceOnClickListenerC0108be(this)).show();
                return true;
            case 2:
                Intent intent = new Intent(getActivity(), (Class<?>) ActivityRegist.class);
                intent.putExtra(RtspHeaders.Values.MODE, 1);
                startActivityForResult(intent, 1);
                return true;
            case 3:
                startActivity(new Intent(getActivity(), (Class<?>) BuddyGroupActivity.class));
                return true;
            case 4:
                m503k();
                Intent intent2 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent2.putExtra("BUDDY_SORT_STYLE", this.f417H);
                intent2.putExtra("ACTIVITY_PURPOSE", 2);
                startActivity(intent2);
                return true;
            case 5:
                m503k();
                Intent intent3 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent3.putExtra("BUDDY_SORT_STYLE", this.f417H);
                intent3.putExtra("ACTIVITY_PURPOSE", 3);
                startActivity(intent3);
                return true;
            case 6:
                startActivity(new Intent(getActivity(), (Class<?>) ActivitySettings.class));
                return true;
            case 7:
                Intent intentM3525a = ChatONShortcutUtil.m3525a(getActivity(), this.f410A, ChatONContract.InBoxTable.ChatType.m2188a(this.f412C));
                ProfileImageView profileImageView = new ProfileImageView(getActivity());
                profileImageView.init(profileImageView, ChatONContract.InBoxTable.ChatType.m2188a(this.f412C));
                if (ChatONContract.InBoxTable.ChatType.m2188a(this.f412C) == ChatONContract.InBoxTable.ChatType.ONETOONE) {
                    ProfileImageLoader.m3610a(getActivity()).m3623a(profileImageView, this.f410A);
                    profileImageView.setBuddyNo(this.f410A);
                }
                String str = this.f414E;
                try {
                    bitmap = ((BitmapDrawable) profileImageView.getDrawable()).getBitmap();
                } catch (Exception e) {
                    bitmap = null;
                }
                ChatONShortcutUtil.m3526a(getActivity(), intentM3525a, str, Bitmap.createScaledBitmap(ChatOnGraphics.m3527a(getActivity(), bitmap), ChatONShortcutUtil.m3524a(getResources().getDisplayMetrics().density), ChatONShortcutUtil.m3524a(getResources().getDisplayMetrics().density), true));
                return true;
            case 8:
                Intent intent4 = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent4.putExtra("ACTIVITY_PURPOSE", 5);
                intent4.putExtra(ChatFragment.f724c, this.f413D);
                intent4.putExtra("chatType", this.f412C);
                startActivityForResult(intent4, 4);
                return true;
            default:
                return true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.f437ab = false;
        if (this.f434Y && this.f426Q.size() == 0) {
            this.f459o.setText("");
        }
        this.f459o.removeTextChangedListener(this.f444ai);
        m503k();
        m511o();
        ChatONLogWriter.m3512f("onPause() : " + this.f437ab, f409a);
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        if (this.f419J == 1) {
            menu.clear();
            menu.add(0, 1, 1, getResources().getString(C0062R.string.buddy_list_optionmenu_sortby)).setIcon(C0062R.drawable.list_by);
            menu.add(0, 2, 2, getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_title)).setIcon(C0062R.drawable.add_buddy);
            menu.add(0, 3, 3, getResources().getString(C0062R.string.buddy_list_optionmenu_addgroup)).setIcon(C0062R.drawable.group_add);
            menu.add(0, 4, 4, getResources().getString(C0062R.string.buddy_list_optionmenu_groupchat)).setIcon(C0062R.drawable.group_chat);
            menu.add(0, 5, 5, getResources().getString(C0062R.string.buddy_list_optionmenu_broadcast)).setIcon(C0062R.drawable.broadcast);
            if (ChatONPref.m3519a().contains("UpdateIsCritical")) {
                menu.add(0, 6, 6, getResources().getString(C0062R.string.buddy_list_optionmenu_setting)).setIcon(C0062R.drawable.settings_new);
            } else {
                menu.add(0, 6, 6, getResources().getString(C0062R.string.buddy_list_optionmenu_setting)).setIcon(C0062R.drawable.settings);
            }
            if (this.f417H != 11) {
                menu.removeItem(3);
                return;
            } else {
                if (menu.findItem(3) == null) {
                    menu.add(0, 3, 3, getResources().getString(C0062R.string.buddy_list_optionmenu_addgroup));
                    return;
                }
                return;
            }
        }
        if (this.f419J == 7) {
            menu.clear();
            menu.add(0, 2, 2, getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_title)).setIcon(C0062R.drawable.add_buddy);
            menu.add(0, 3, 3, getResources().getString(C0062R.string.buddy_list_optionmenu_addgroup)).setIcon(C0062R.drawable.group_edit);
            if (ChatONPref.m3519a().contains("UpdateIsCritical")) {
                menu.add(0, 6, 6, getResources().getString(C0062R.string.buddy_list_optionmenu_setting)).setIcon(C0062R.drawable.settings_new);
                return;
            } else {
                menu.add(0, 6, 6, getResources().getString(C0062R.string.buddy_list_optionmenu_setting)).setIcon(C0062R.drawable.settings);
                return;
            }
        }
        if (this.f419J == 6) {
            menu.clear();
            if (this.f465u) {
                menu.add(0, 7, 1, getResources().getString(C0062R.string.buddy_list_contextual_menu_shortcut)).setEnabled(true).setIcon(C0062R.drawable.add_shortcut);
            } else {
                menu.add(0, 7, 1, getResources().getString(C0062R.string.buddy_list_contextual_menu_shortcut)).setEnabled(false).setIcon(C0062R.drawable.add_shortcut);
            }
            menu.add(0, 8, 2, getResources().getString(C0062R.string.buddy_list_menubar_invite)).setIcon(C0062R.drawable.invite_buddy);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f437ab = true;
        ChatONLogWriter.m3512f("onResume() : " + this.f437ab, f409a);
        ChatONLogWriter.m3512f("isChanged : " + this.f438ac, f409a);
        this.f459o.addTextChangedListener(this.f444ai);
        m511o();
        if (this.f419J == 9) {
            this.f438ac = true;
            this.f443ah.clear();
            this.f443ah = getActivity().getIntent().getExtras().getStringArrayList("ACTIVITY_PURPOSE_ARG");
        }
        if (this.f438ac) {
            this.f431V.m527a();
        } else {
            this.f438ac = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        ChatONLogWriter.m3512f("onStart() : " + this.f437ab, f409a);
        super.onStart();
        if (this.f419J != 1 || this.f422M.size() <= 0) {
            return;
        }
        boolean z = ChatONPref.m3519a().getBoolean("Profile Birth Chk", true);
        ChatONLogWriter.m3512f("onStart() isShowBirthdayCategory : " + z, f409a);
        if (!z) {
            for (int i = 0; i < this.f422M.size(); i++) {
                if (((BuddyGroupItem) this.f422M.get(i)).m659d() == 0) {
                    this.f422M.remove(i);
                    this.f423N.remove(i);
                    m473a(this.f422M, this.f423N);
                    return;
                }
            }
            return;
        }
        for (int i2 = 0; i2 < this.f422M.size(); i2++) {
            if (((BuddyGroupItem) this.f422M.get(i2)).m659d() == 0) {
                return;
            }
        }
        if (0 == 0) {
            String str = new SimpleDateFormat("MM-dd").format(new Date());
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f422M.size(); i3++) {
                BuddyGroupItem buddyGroupItem = (BuddyGroupItem) this.f422M.get(i3);
                if (buddyGroupItem.m659d() == 2 || buddyGroupItem.m659d() == 3) {
                    Iterator it = ((ArrayList) this.f423N.get(i3)).iterator();
                    while (it.hasNext()) {
                        BuddyItem buddyItem = (BuddyItem) it.next();
                        if ((buddyItem.m681f().length() == 10 && buddyItem.m681f().substring(5).equals(str)) || (buddyItem.m681f().length() == 5 && buddyItem.m681f().equals(str))) {
                            arrayList.add(buddyItem);
                        }
                    }
                }
            }
            for (int i4 = 0; i4 < this.f422M.size(); i4++) {
                if (((BuddyGroupItem) this.f422M.get(i4)).m659d() == 1 && arrayList.size() > 0) {
                    this.f422M.add(i4, new BuddyGroupItem(0, getResources().getString(C0062R.string.buddy_list_group_birthday), arrayList.size(), 0, true, false, 0));
                    this.f423N.add(i4, arrayList);
                    m473a(this.f422M, this.f423N);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        ChatONLogWriter.m3512f("onStop()", f409a);
        try {
            this.f459o.removeTextChangedListener(this.f444ai);
        } catch (Exception e) {
        }
        m515q();
        super.onStop();
    }
}
