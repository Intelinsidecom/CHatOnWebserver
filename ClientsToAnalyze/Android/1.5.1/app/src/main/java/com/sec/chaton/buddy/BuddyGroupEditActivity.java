package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.item.BuddyGroupItem;
import com.sec.chaton.buddy.item.BuddyGroupListItem;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.HangulJamoUtil;
import com.sec.chaton.util.KoreanUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddyGroupEditActivity extends BaseActivity implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener {

    /* renamed from: a */
    public static final String f487a = BuddyGroupEditActivity.class.getSimpleName();

    /* renamed from: A */
    private TextView f488A;

    /* renamed from: B */
    private LinearLayout f489B;

    /* renamed from: C */
    private TextView f490C;

    /* renamed from: D */
    private Button f491D;

    /* renamed from: E */
    private LinearLayout f492E;

    /* renamed from: F */
    private LinearLayout f493F;

    /* renamed from: G */
    private TextView f494G;

    /* renamed from: H */
    private TextView f495H;

    /* renamed from: I */
    private String[] f496I;

    /* renamed from: J */
    private HorizontalScrollView f497J;

    /* renamed from: K */
    private NotifyingAsyncQueryHandler f498K;

    /* renamed from: L */
    private int f499L;

    /* renamed from: M */
    private String f500M;

    /* renamed from: f */
    BuddyGroupEditAdapter f508f;

    /* renamed from: g */
    BuddyGroupListItem f509g;

    /* renamed from: l */
    private Context f514l;

    /* renamed from: m */
    private EditText f515m;

    /* renamed from: n */
    private LinearLayout f516n;

    /* renamed from: o */
    private EditText f517o;

    /* renamed from: p */
    private LinearLayout f518p;

    /* renamed from: q */
    private ImageButton f519q;

    /* renamed from: r */
    private ImageButton f520r;

    /* renamed from: s */
    private Button f521s;

    /* renamed from: t */
    private Button f522t;

    /* renamed from: u */
    private Button f523u;

    /* renamed from: v */
    private ExpandableListView f524v;

    /* renamed from: w */
    private LinearLayout f525w;

    /* renamed from: x */
    private LinearLayout f526x;

    /* renamed from: y */
    private Button f527y;

    /* renamed from: z */
    private Button f528z;

    /* renamed from: b */
    ArrayList f504b = new ArrayList();

    /* renamed from: c */
    ArrayList f505c = new ArrayList();

    /* renamed from: d */
    ArrayList f506d = new ArrayList();

    /* renamed from: e */
    ArrayList f507e = new ArrayList();

    /* renamed from: N */
    private boolean f501N = false;

    /* renamed from: h */
    View.OnClickListener f510h = new ViewOnClickListenerC0116i(this);

    /* renamed from: i */
    NotifyingAsyncQueryHandler.AsyncQueryListener f511i = new C0122o(this);

    /* renamed from: j */
    AbstractQueryTask.OnQueryTaskResult f512j = new C0123p(this);

    /* renamed from: k */
    LoaderManager.LoaderCallbacks f513k = new C0120m(this);

    /* renamed from: O */
    private TextWatcher f502O = new C0121n(this);

    /* renamed from: P */
    private TextWatcher f503P = new C0119l(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m546a(Cursor cursor) {
        ArrayList arrayList;
        int i;
        int i2;
        int i3 = 2;
        ArrayList arrayList2 = new ArrayList();
        this.f504b.clear();
        this.f505c.clear();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 0.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        if (cursor.getCount() == 0) {
            this.f524v.setLayoutParams(layoutParams);
            this.f525w.setLayoutParams(layoutParams);
            this.f526x.setLayoutParams(layoutParams2);
            this.f520r.setEnabled(false);
            return;
        }
        this.f524v.setLayoutParams(layoutParams2);
        this.f525w.setLayoutParams(layoutParams);
        this.f526x.setLayoutParams(layoutParams);
        this.f520r.setEnabled(true);
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        ArrayList arrayList3 = new ArrayList();
        int i4 = 0;
        char c = 0;
        ArrayList arrayList4 = arrayList2;
        while (cursor.moveToNext()) {
            char cM3597a = KoreanUtil.m3597a(Character.toUpperCase(cursor.getString(cursor.getColumnIndex("buddy_name")).charAt(0)));
            if (c == cM3597a || c == 0) {
                arrayList = arrayList4;
                i = i4;
                i2 = i3;
            } else {
                this.f505c.add(arrayList4);
                this.f504b.add(new BuddyGroupItem(i3, String.valueOf(c), i4, 2, false, false, 0));
                arrayList = new ArrayList();
                i = 0;
                i2 = i3 + 1;
            }
            BuddyItem buddyItem = new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), 0, 0, 0, 0, 0, 0, cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false);
            if (this.f499L == 3) {
                buddyItem.m672a(true);
            }
            arrayList.add(buddyItem);
            arrayList3.add(cursor.getString(cursor.getColumnIndex("buddy_no")));
            i4 = i + 1;
            i3 = i2;
            c = cM3597a;
            arrayList4 = arrayList;
        }
        this.f505c.add(arrayList4);
        int i5 = i3 + 1;
        this.f504b.add(new BuddyGroupItem(i3, String.valueOf(c), i4, 2, false, false, 0));
        this.f496I = (String[]) arrayList3.toArray(new String[0]);
        startManagingCursor(cursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m547a(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f514l.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m548a(ExpandableListView expandableListView) {
        Iterator it = this.f505c.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                ((BuddyItem) it2.next()).m672a(false);
            }
        }
        Iterator it3 = this.f507e.iterator();
        while (it3.hasNext()) {
            Iterator it4 = ((ArrayList) it3.next()).iterator();
            while (it4.hasNext()) {
                ((BuddyItem) it4.next()).m672a(false);
            }
        }
        this.f508f.m598c();
        this.f508f.m590a(this.f499L);
        this.f524v.invalidateViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m552a(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = this.f504b.iterator();
        while (it.hasNext()) {
            arrayList3.add(new BuddyGroupItem((BuddyGroupItem) it.next()));
        }
        Iterator it2 = this.f505c.iterator();
        while (it2.hasNext()) {
            ArrayList arrayList5 = (ArrayList) it2.next();
            ArrayList arrayList6 = new ArrayList();
            Iterator it3 = arrayList5.iterator();
            while (it3.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it3.next();
                if (HangulJamoUtil.m3582a(buddyItem.m673b().toUpperCase(), str.toUpperCase())) {
                    arrayList6.add(new BuddyItem(buddyItem));
                }
            }
            arrayList4.add(arrayList6);
        }
        for (int i = 0; i < arrayList3.size(); i++) {
            if (((ArrayList) arrayList4.get(i)).size() > 0) {
                ((BuddyGroupItem) arrayList3.get(i)).m656a(((ArrayList) arrayList4.get(i)).size());
                arrayList.add(arrayList3.get(i));
                arrayList2.add((ArrayList) ((ArrayList) arrayList4.get(i)).clone());
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 0.0f);
        if (arrayList.size() <= 0) {
            this.f524v.setLayoutParams(layoutParams2);
            this.f525w.setLayoutParams(layoutParams);
            this.f526x.setLayoutParams(layoutParams2);
            return;
        }
        if (((BuddyGroupItem) arrayList.get(0)).m659d() < 2) {
            arrayList.remove(0);
            arrayList2.remove(0);
        }
        this.f524v.setLayoutParams(layoutParams);
        this.f525w.setLayoutParams(layoutParams2);
        this.f526x.setLayoutParams(layoutParams2);
        this.f508f.m595a(true);
        m553a(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m553a(ArrayList arrayList, ArrayList arrayList2) {
        this.f506d.clear();
        this.f507e.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f506d.add(new BuddyGroupItem((BuddyGroupItem) it.next()));
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ArrayList arrayList3 = (ArrayList) it2.next();
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                arrayList4.add(new BuddyItem((BuddyItem) it3.next()));
            }
            this.f507e.add(arrayList4);
        }
        this.f508f.notifyDataSetChanged();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f506d.size()) {
                return;
            }
            if (((BuddyGroupItem) this.f506d.get(i2)).m659d() > 1) {
                this.f524v.expandGroup(i2);
            } else {
                this.f524v.collapseGroup(i2);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m555b(Cursor cursor) {
        int i;
        int i2;
        int i3;
        ArrayList arrayList;
        String string;
        this.f504b.clear();
        this.f505c.clear();
        if (cursor.getCount() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        cursor.moveToNext();
        if (cursor.getInt(cursor.getColumnIndex("group_type")) != 1) {
            this.f504b.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_group_favorites), 0, 1, false, false, 0));
            this.f505c.add(new ArrayList());
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (cursor.getInt(cursor.getColumnIndex("group_type")) > 1) {
                    i = i5;
                    break;
                }
                arrayList2.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
                i4 = i5 + 1;
                if (!cursor.moveToNext()) {
                    i = i4;
                    break;
                }
            }
            this.f504b.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_group_favorites), i, 1, false, false, 0));
            this.f505c.add(arrayList2);
        }
        cursor.moveToPrevious();
        ArrayList arrayList3 = new ArrayList();
        while (cursor.moveToNext() && (string = cursor.getString(cursor.getColumnIndex("group_name"))) != null && string.length() != 0) {
            BuddyItem buddyItem = new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("group_name")), null, null, null, null, true, 0, cursor.getString(cursor.getColumnIndex("group_name")), false, 0, 0, 0, 0, 0, 0, 0, false, false);
            HashMap map = new HashMap();
            try {
                String str = "%%" + cursor.getString(cursor.getColumnIndex("buddy_no")) + "%%";
                String[] strArrSplit = cursor.getString(cursor.getColumnIndex("buddy_email")).split(str);
                String[] strArrSplit2 = cursor.getString(cursor.getColumnIndex("buddy_samsung_email")).split(str);
                if (strArrSplit.length > 0 && strArrSplit.length == strArrSplit2.length) {
                    for (int i6 = 0; i6 < strArrSplit.length; i6++) {
                        map.put(strArrSplit[i6], strArrSplit2[i6]);
                    }
                }
            } catch (Exception e) {
            }
            buddyItem.m675b(true);
            buddyItem.m671a(map);
            arrayList3.add(buddyItem);
        }
        this.f505c.add(arrayList3);
        this.f504b.add(new BuddyGroupItem(1, getResources().getString(C0062R.string.buddy_list_optionmenu_sortby_group), arrayList3.size(), 1, false, false, 0));
        cursor.moveToPrevious();
        int i7 = 2;
        char c = 0;
        ArrayList arrayList4 = new ArrayList();
        int i8 = 0;
        while (cursor.moveToNext()) {
            char cM3597a = KoreanUtil.m3597a(Character.toUpperCase(cursor.getString(cursor.getColumnIndex("buddy_name")).charAt(0)));
            if (c == cM3597a || c == 0) {
                i2 = i8;
                i3 = i7;
                arrayList = arrayList4;
            } else {
                this.f505c.add(arrayList4);
                this.f504b.add(new BuddyGroupItem(i7, String.valueOf(c), i8, 2, false, false, 0));
                i2 = 0;
                i3 = i7 + 1;
                arrayList = new ArrayList();
            }
            arrayList.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
            i8 = i2 + 1;
            i7 = i3;
            c = cM3597a;
            arrayList4 = arrayList;
        }
        startManagingCursor(cursor);
        if (arrayList4 == null || arrayList4.size() <= 0) {
            return;
        }
        this.f505c.add(arrayList4);
        int i9 = i7 + 1;
        this.f504b.add(new BuddyGroupItem(i7, String.valueOf(c), i8, 2, false, false, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m556b(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f514l.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    private void m561c() throws Resources.NotFoundException {
        this.f514l = this;
        this.f488A = (TextView) findViewById(C0062R.id.buddy_group_profile_title);
        this.f489B = (LinearLayout) findViewById(C0062R.id.buddy_group_profile_header_layout);
        this.f490C = (TextView) findViewById(C0062R.id.buddy_group_profile_groupname);
        this.f492E = (LinearLayout) findViewById(C0062R.id.buddy_group_profile_edit_layout);
        this.f515m = (EditText) findViewById(C0062R.id.buddy_group_profile_edit_groupname);
        this.f515m.setOnClickListener(this.f510h);
        this.f491D = (Button) findViewById(C0062R.id.buddy_group_profile_rename_groupname);
        this.f491D.setOnClickListener(this.f510h);
        this.f493F = (LinearLayout) findViewById(C0062R.id.buddy_group_profile_addmember_layout);
        this.f493F.setOnClickListener(this.f510h);
        this.f522t = (Button) findViewById(C0062R.id.buddy_remove_to_group);
        this.f522t.setOnClickListener(this.f510h);
        this.f516n = (LinearLayout) findViewById(C0062R.id.group_search_bar);
        this.f518p = (LinearLayout) findViewById(C0062R.id.group_menu_bar);
        this.f519q = (ImageButton) findViewById(C0062R.id.buddy_group_profile_addmember);
        this.f519q.setOnClickListener(this.f510h);
        this.f494G = (TextView) findViewById(C0062R.id.buddy_group_profile_addmember_info);
        this.f494G.setOnClickListener(this.f510h);
        this.f520r = (ImageButton) findViewById(C0062R.id.buddy_group_profile_remove_member);
        this.f520r.setOnClickListener(this.f510h);
        this.f495H = (TextView) findViewById(C0062R.id.buddy_group_profile_remove_member_info);
        this.f495H.setOnClickListener(this.f510h);
        this.f517o = (EditText) findViewById(C0062R.id.buddy_search_for_add);
        this.f521s = (Button) findViewById(C0062R.id.buddy_add_to_group);
        this.f521s.setOnClickListener(this.f510h);
        this.f523u = (Button) findViewById(C0062R.id.buddy_menu_cancel);
        this.f523u.setOnClickListener(this.f510h);
        this.f524v = (ExpandableListView) findViewById(C0062R.id.buddy_list_for_group_edit);
        this.f524v.setChoiceMode(2);
        this.f524v.setItemsCanFocus(false);
        this.f525w = (LinearLayout) findViewById(C0062R.id.buddy_list_add_to_group_search_noresult_layout);
        this.f526x = (LinearLayout) findViewById(C0062R.id.buddy_group_nomembers_layout);
        this.f499L = getIntent().getExtras().getInt("ACTIVITY_PURPOSE", 1);
        this.f489B.setVisibility(8);
        this.f516n.setVisibility(8);
        this.f518p.setVisibility(8);
        this.f521s.setVisibility(8);
        this.f522t.setVisibility(8);
        this.f527y = (Button) findViewById(C0062R.id.buddy_menu_groupchat);
        this.f527y.setOnClickListener(this.f510h);
        this.f528z = (Button) findViewById(C0062R.id.buddy_menu_broadcast);
        this.f528z.setOnClickListener(this.f510h);
        if (this.f509g == null) {
            this.f509g = (BuddyGroupListItem) getIntent().getExtras().get("ACTIVITY_PURPOSE_ARG1");
        }
        if (this.f499L == 1) {
            this.f522t.setVisibility(0);
            this.f489B.setVisibility(0);
            this.f490C.setText(this.f509g.m666b());
            this.f490C.setOnClickListener(new ViewOnClickListenerC0117j(this));
            this.f515m.setText(this.f509g.m666b());
            this.f515m.setOnEditorActionListener(new C0118k(this));
        } else if (this.f499L == 2) {
            this.f488A.setText(getString(C0062R.string.buddy_group_profile_title_add_member));
            this.f493F.setVisibility(8);
            this.f516n.setVisibility(0);
            this.f521s.setVisibility(0);
            this.f518p.setVisibility(0);
            this.f496I = getIntent().getStringArrayExtra("ACTIVITY_PURPOSE_ARG2");
        } else if (this.f499L == 3) {
            this.f488A.setText(this.f509g.m666b() + " (" + this.f509g.m667c() + ")");
            this.f489B.setVisibility(8);
            this.f493F.setVisibility(8);
            this.f493F.setOnClickListener(null);
            this.f518p.setVisibility(0);
            this.f521s.setVisibility(8);
            this.f522t.setVisibility(8);
            this.f523u.setVisibility(8);
            this.f527y.setVisibility(0);
            this.f527y.setEnabled(false);
            this.f528z.setVisibility(0);
            this.f528z.setEnabled(false);
        }
        Drawable drawable = getResources().getDrawable(C0062R.drawable.ic_btn_search);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f517o.setCompoundDrawables(null, null, drawable, null);
        this.f497J = (HorizontalScrollView) findViewById(C0062R.id.buddy_choice_panel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m563d() throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(C0062R.drawable.btn_del);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (this.f517o.getText().toString().length() > 0) {
            this.f517o.setCompoundDrawables(null, null, drawable, null);
            this.f517o.setOnTouchListener(new ViewOnTouchListenerC0093aq(this, drawable));
        } else {
            Drawable drawable2 = getResources().getDrawable(C0062R.drawable.ic_btn_search);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.f517o.setCompoundDrawables(null, null, drawable2, null);
            this.f517o.setOnTouchListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m564e() throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(C0062R.drawable.btn_del);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (this.f515m.getText().toString().length() > 0) {
            this.f515m.setCompoundDrawables(null, null, drawable, null);
            this.f515m.setOnTouchListener(new ViewOnTouchListenerC0092ap(this, drawable));
        } else {
            this.f515m.setCompoundDrawables(null, null, null, null);
            this.f515m.setOnTouchListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m567f() {
        m548a(this.f524v);
        m547a(this.f515m);
        this.f488A.setText(getString(C0062R.string.buddy_group_profile_title, new Object[]{Integer.valueOf(this.f509g.m667c())}));
        this.f489B.setVisibility(0);
        this.f493F.setVisibility(0);
        this.f518p.setVisibility(8);
        this.f508f.m597b(false);
    }

    /* renamed from: a */
    public ArrayList m583a() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f505c.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m692q() && !arrayList.contains(buddyItem.m668a())) {
                    arrayList.add(buddyItem.m668a());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void m584b() {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = this.f507e.iterator();
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
            Iterator it4 = this.f505c.iterator();
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
            Iterator it7 = this.f505c.iterator();
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

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            getSupportLoaderManager().mo37a(this.f499L, null, this.f513k);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f499L == 2) {
            setResult(-1);
            finish();
            return;
        }
        if (this.f499L == 3) {
            finish();
            return;
        }
        if (this.f499L == 1) {
            if (this.f493F.getVisibility() == 8) {
                m567f();
                return;
            }
            if (this.f492E.getVisibility() != 0) {
                finish();
                return;
            }
            this.f490C.setVisibility(0);
            this.f492E.setVisibility(8);
            this.f515m.setText("");
            m547a(this.f515m);
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        BuddyItem buddyItem = (BuddyItem) ((ArrayList) this.f507e.get(i)).get(i2);
        if (this.f499L != 2) {
            if (this.f499L == 1) {
                if (!this.f508f.m599d()) {
                    return true;
                }
                CheckBox checkBox = (CheckBox) view.findViewById(C0062R.id.buddy_child_check);
                if (checkBox.isChecked()) {
                    checkBox.setChecked(false);
                } else {
                    checkBox.setChecked(true);
                }
                buddyItem.m672a(checkBox.isChecked());
                this.f508f.m594a(buddyItem.m668a(), checkBox.isChecked());
                this.f524v.invalidateViews();
                this.f508f.m590a(this.f499L);
                return true;
            }
            if (this.f499L != 3) {
                return true;
            }
            CheckBox checkBox2 = (CheckBox) view.findViewById(C0062R.id.buddy_child_check);
            if (checkBox2.isChecked()) {
                checkBox2.setChecked(false);
            } else {
                checkBox2.setChecked(true);
            }
            buddyItem.m672a(checkBox2.isChecked());
            this.f508f.m594a(buddyItem.m668a(), checkBox2.isChecked());
            this.f524v.invalidateViews();
            this.f508f.m590a(this.f499L);
            return true;
        }
        if (!buddyItem.m697v()) {
            CheckBox checkBox3 = (CheckBox) view.findViewById(C0062R.id.buddy_child_check);
            if (checkBox3.isChecked()) {
                checkBox3.setChecked(false);
            } else {
                checkBox3.setChecked(true);
            }
            buddyItem.m672a(checkBox3.isChecked());
            this.f508f.m594a(buddyItem.m668a(), checkBox3.isChecked());
            this.f524v.invalidateViews();
            this.f508f.m590a(this.f499L);
            return true;
        }
        HashMap mapM698w = buddyItem.m698w();
        if (mapM698w == null || mapM698w.size() <= 0) {
            return true;
        }
        Iterator it = mapM698w.keySet().iterator();
        while (it.hasNext()) {
            String strValueOf = String.valueOf(it.next());
            String str = (String) mapM698w.get(strValueOf);
            ChatONLogWriter.m3512f(strValueOf + ", " + str, f487a);
            boolean z = false;
            if (this.f496I != null && this.f496I.length > 0) {
                String[] strArr = this.f496I;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (strArr[i3].equals(strValueOf)) {
                        z = true;
                        break;
                    }
                    i3++;
                }
            }
            if (!z) {
                this.f508f.m593a(strValueOf, str);
                this.f508f.m594a(strValueOf, true);
            }
        }
        this.f508f.m590a(this.f499L);
        this.f524v.invalidateViews();
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        ChatONLogWriter.m3512f("onCreate()", f487a);
        super.onCreate(bundle);
        setContentView(C0062R.layout.buddy_group_edit_layout);
        this.f498K = new NotifyingAsyncQueryHandler(getContentResolver(), this.f511i);
        m561c();
        this.f508f = new BuddyGroupEditAdapter(this.f524v, this, this.f506d, C0062R.layout.buddy_adapter_group_item, this.f507e, C0062R.layout.buddy_adapter_child_item, this.f518p, this.f501N, this.f499L, this.f488A);
        if (this.f499L == 3) {
            this.f508f.m597b(true);
        }
        this.f524v.setAdapter(this.f508f);
        getSupportLoaderManager().mo37a(this.f499L, null, this.f513k);
        this.f524v.setOnGroupClickListener(this);
        this.f524v.setOnChildClickListener(this);
        this.f508f.m591a(this.f497J);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f499L == 1 && this.f493F.getVisibility() == 0) {
            menu.add(0, 1, 0, C0062R.string.buddy_group_list_header_delete).setIcon(C0062R.drawable.group_delete);
        }
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return false;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                new AlertDialog.Builder(this.f514l).setTitle(getResources().getString(C0062R.string.buddy_group_list_dialog_removegroup_title)).setMessage(getResources().getString(C0062R.string.buddy_group_list_dialog_removegroup_message)).setPositiveButton(getResources().getString(C0062R.string.dialog_ok), new DialogInterfaceOnClickListenerC0115h(this)).setNegativeButton(getResources().getString(C0062R.string.cancel), (DialogInterface.OnClickListener) null).show();
                break;
        }
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f517o.removeTextChangedListener(this.f502O);
        this.f515m.removeTextChangedListener(this.f503P);
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f499L == 1 && this.f493F.getVisibility() == 0) {
            return super.onPrepareOptionsMenu(menu);
        }
        return false;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        ChatONLogWriter.m3512f("onResume()", f487a);
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        ChatONLogWriter.m3512f("onStart()", f487a);
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.f517o.removeTextChangedListener(this.f502O);
        this.f515m.removeTextChangedListener(this.f503P);
        super.onStop();
    }
}
