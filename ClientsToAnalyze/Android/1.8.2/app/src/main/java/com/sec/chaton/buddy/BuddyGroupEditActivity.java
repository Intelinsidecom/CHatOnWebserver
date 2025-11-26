package com.sec.chaton.buddy;

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
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p010a.C0255a;
import com.sec.chaton.buddy.p010a.C0256b;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.util.C1725ah;
import com.sec.chaton.util.C1734aq;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.EditTextWithClearButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddyGroupEditActivity extends BaseActivity implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener {

    /* renamed from: a */
    public static final String f1032a = BuddyGroupEditActivity.class.getSimpleName();

    /* renamed from: A */
    private LinearLayout f1033A;

    /* renamed from: B */
    private Button f1034B;

    /* renamed from: C */
    private Button f1035C;

    /* renamed from: D */
    private TextView f1036D;

    /* renamed from: E */
    private LinearLayout f1037E;

    /* renamed from: F */
    private TextView f1038F;

    /* renamed from: G */
    private Button f1039G;

    /* renamed from: H */
    private LinearLayout f1040H;

    /* renamed from: I */
    private LinearLayout f1041I;

    /* renamed from: J */
    private TextView f1042J;

    /* renamed from: K */
    private TextView f1043K;

    /* renamed from: L */
    private String[] f1044L;

    /* renamed from: M */
    private HorizontalScrollView f1045M;

    /* renamed from: N */
    private C0666j f1046N;

    /* renamed from: O */
    private int f1047O;

    /* renamed from: P */
    private String f1048P;

    /* renamed from: i */
    C0322cg f1056i;

    /* renamed from: j */
    C0256b f1057j;

    /* renamed from: o */
    private Context f1062o;

    /* renamed from: p */
    private EditTextWithClearButton f1063p;

    /* renamed from: q */
    private LinearLayout f1064q;

    /* renamed from: r */
    private EditTextWithClearButton f1065r;

    /* renamed from: s */
    private LinearLayout f1066s;

    /* renamed from: t */
    private ImageButton f1067t;

    /* renamed from: u */
    private ImageButton f1068u;

    /* renamed from: v */
    private Button f1069v;

    /* renamed from: w */
    private Button f1070w;

    /* renamed from: x */
    private Button f1071x;

    /* renamed from: y */
    private ExpandableListView f1072y;

    /* renamed from: z */
    private LinearLayout f1073z;

    /* renamed from: b */
    ArrayList f1052b = new ArrayList();

    /* renamed from: c */
    ArrayList f1053c = new ArrayList();

    /* renamed from: d */
    ArrayList f1054d = new ArrayList();

    /* renamed from: e */
    ArrayList f1055e = new ArrayList();

    /* renamed from: Q */
    private boolean f1049Q = false;

    /* renamed from: k */
    View.OnClickListener f1058k = new ViewOnClickListenerC0316ca(this);

    /* renamed from: l */
    InterfaceC0667k f1059l = new C0317cb(this);

    /* renamed from: m */
    InterfaceC0677d f1060m = new C0318cc(this);

    /* renamed from: n */
    LoaderManager.LoaderCallbacks f1061n = new C0319cd(this);

    /* renamed from: R */
    private TextWatcher f1050R = new C0320ce(this);

    /* renamed from: S */
    private TextWatcher f1051S = new C0321cf(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C1786r.m6067f("onCreate()", f1032a);
        super.onCreate(bundle);
        setContentView(R.layout.buddy_group_edit_layout);
        this.f1046N = new C0666j(getContentResolver(), this.f1059l);
        m2083c();
        this.f1056i = new C0322cg(this.f1072y, this, this.f1054d, R.layout.buddy_adapter_group_item, this.f1055e, R.layout.buddy_adapter_child_item, this.f1066s, this.f1049Q, this.f1047O, this.f1036D);
        if (this.f1047O == 3) {
            this.f1056i.m2405b(true);
        }
        this.f1072y.setAdapter(this.f1056i);
        getSupportLoaderManager().restartLoader(this.f1047O, null, this.f1061n);
        this.f1072y.setOnGroupClickListener(this);
        this.f1072y.setOnChildClickListener(this);
        this.f1056i.m2399a(this.f1045M);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        C1786r.m6067f("onStart()", f1032a);
        super.onStart();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        C1786r.m6067f("onResume()", f1032a);
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f1065r.removeTextChangedListener(this.f1050R);
        this.f1063p.removeTextChangedListener(this.f1051S);
        super.onPause();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.f1065r.removeTextChangedListener(this.f1050R);
        this.f1063p.removeTextChangedListener(this.f1051S);
        super.onStop();
    }

    /* renamed from: c */
    private void m2083c() throws Resources.NotFoundException {
        this.f1062o = this;
        this.f1036D = (TextView) findViewById(R.id.buddy_group_profile_title);
        this.f1037E = (LinearLayout) findViewById(R.id.buddy_group_profile_header_layout);
        this.f1038F = (TextView) findViewById(R.id.buddy_group_profile_groupname);
        this.f1040H = (LinearLayout) findViewById(R.id.buddy_group_profile_edit_layout);
        this.f1063p = (EditTextWithClearButton) findViewById(R.id.buddy_group_profile_edit_groupname);
        this.f1063p.setOnClickListener(this.f1058k);
        this.f1039G = (Button) findViewById(R.id.buddy_group_profile_rename_groupname);
        this.f1039G.setOnClickListener(this.f1058k);
        this.f1041I = (LinearLayout) findViewById(R.id.buddy_group_profile_addmember_layout);
        this.f1041I.setOnClickListener(this.f1058k);
        this.f1070w = (Button) findViewById(R.id.buddy_remove_to_group);
        this.f1070w.setOnClickListener(this.f1058k);
        this.f1064q = (LinearLayout) findViewById(R.id.group_search_bar);
        this.f1066s = (LinearLayout) findViewById(R.id.group_menu_bar);
        this.f1067t = (ImageButton) findViewById(R.id.buddy_group_profile_addmember);
        this.f1067t.setOnClickListener(this.f1058k);
        this.f1042J = (TextView) findViewById(R.id.buddy_group_profile_addmember_info);
        this.f1042J.setOnClickListener(this.f1058k);
        this.f1068u = (ImageButton) findViewById(R.id.buddy_group_profile_remove_member);
        this.f1068u.setOnClickListener(this.f1058k);
        this.f1043K = (TextView) findViewById(R.id.buddy_group_profile_remove_member_info);
        this.f1043K.setOnClickListener(this.f1058k);
        this.f1065r = (EditTextWithClearButton) findViewById(R.id.buddy_search_for_add);
        this.f1065r.setShowSearch(true);
        this.f1069v = (Button) findViewById(R.id.buddy_add_to_group);
        this.f1069v.setOnClickListener(this.f1058k);
        this.f1071x = (Button) findViewById(R.id.buddy_menu_cancel);
        this.f1071x.setOnClickListener(this.f1058k);
        this.f1072y = (ExpandableListView) findViewById(R.id.buddy_list_for_group_edit);
        this.f1072y.setChoiceMode(2);
        this.f1072y.setItemsCanFocus(false);
        this.f1073z = (LinearLayout) findViewById(R.id.buddy_list_add_to_group_search_noresult_layout);
        this.f1033A = (LinearLayout) findViewById(R.id.buddy_group_nomembers_layout);
        this.f1047O = getIntent().getExtras().getInt("ACTIVITY_PURPOSE", 1);
        this.f1037E.setVisibility(8);
        this.f1064q.setVisibility(8);
        this.f1066s.setVisibility(8);
        this.f1069v.setVisibility(8);
        this.f1070w.setVisibility(8);
        this.f1034B = (Button) findViewById(R.id.buddy_menu_groupchat);
        this.f1034B.setOnClickListener(this.f1058k);
        this.f1035C = (Button) findViewById(R.id.buddy_menu_broadcast);
        this.f1035C.setOnClickListener(this.f1058k);
        if (this.f1057j == null) {
            this.f1057j = (C0256b) getIntent().getExtras().get("ACTIVITY_PURPOSE_ARG1");
        }
        if (this.f1047O == 1) {
            this.f1070w.setVisibility(0);
            this.f1037E.setVisibility(0);
            this.f1038F.setText(this.f1057j.m2316b());
            this.f1038F.setOnClickListener(new ViewOnClickListenerC0312bx(this));
            this.f1063p.setText(this.f1057j.m2316b());
            this.f1063p.setOnEditorActionListener(new C0313by(this));
        } else if (this.f1047O == 2) {
            this.f1036D.setText(getString(R.string.buddy_group_profile_title_add_member));
            this.f1041I.setVisibility(8);
            this.f1064q.setVisibility(0);
            this.f1069v.setVisibility(0);
            this.f1066s.setVisibility(0);
            this.f1044L = getIntent().getStringArrayExtra("ACTIVITY_PURPOSE_ARG2");
        } else if (this.f1047O == 3) {
            this.f1036D.setText(this.f1057j.m2316b() + " (" + this.f1057j.m2317c() + ")");
            this.f1037E.setVisibility(8);
            this.f1041I.setVisibility(8);
            this.f1041I.setOnClickListener(null);
            this.f1066s.setVisibility(0);
            this.f1069v.setVisibility(8);
            this.f1070w.setVisibility(8);
            this.f1071x.setVisibility(8);
            this.f1034B.setVisibility(0);
            this.f1034B.setEnabled(false);
            this.f1035C.setVisibility(0);
            this.f1035C.setEnabled(false);
        }
        Drawable drawable = getResources().getDrawable(R.drawable.ic_btn_search);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f1065r.setCompoundDrawables(null, null, drawable, null);
        this.f1045M = (HorizontalScrollView) findViewById(R.id.buddy_choice_panel);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f1047O == 1 && this.f1041I.getVisibility() == 0) {
            menu.add(0, 1, 0, R.string.buddy_group_list_header_delete).setIcon(R.drawable.group_delete);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f1047O == 1 && this.f1041I.getVisibility() == 0) {
            return super.onPrepareOptionsMenu(menu);
        }
        return false;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                new AlertDialogBuilderC2120a(this.f1062o).setTitle(getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).setMessage(getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).setPositiveButton(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).setNegativeButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0314bz(this)).show();
                break;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2068a(Cursor cursor) {
        ArrayList arrayList;
        int i;
        int i2;
        char c = 0;
        int i3 = 2;
        int i4 = 0;
        ArrayList arrayList2 = new ArrayList();
        this.f1052b.clear();
        this.f1053c.clear();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 0.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        if (cursor.getCount() == 0) {
            this.f1072y.setLayoutParams(layoutParams);
            this.f1073z.setLayoutParams(layoutParams);
            this.f1033A.setLayoutParams(layoutParams2);
            this.f1068u.setEnabled(false);
            return;
        }
        this.f1072y.setLayoutParams(layoutParams2);
        this.f1073z.setLayoutParams(layoutParams);
        this.f1033A.setLayoutParams(layoutParams);
        this.f1068u.setEnabled(true);
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        ArrayList arrayList3 = new ArrayList();
        while (cursor.moveToNext()) {
            char cM5917a = C1734aq.m5917a(Character.toUpperCase(cursor.getString(cursor.getColumnIndex("buddy_name")).charAt(0)));
            if (c == cM5917a || c == 0) {
                arrayList = arrayList2;
                i = i4;
                i2 = i3;
            } else {
                this.f1053c.add(arrayList2);
                this.f1052b.add(new C0255a(i3, String.valueOf(c), i4, 2, false, false, 0));
                arrayList = new ArrayList();
                i = 0;
                i2 = i3 + 1;
            }
            C0257c c0257c = new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), 0, 0, 0, 0, 0, 0, cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false);
            if (this.f1047O == 3) {
                c0257c.m2322a(true);
            }
            arrayList.add(c0257c);
            i4 = i + 1;
            arrayList3.add(cursor.getString(cursor.getColumnIndex("buddy_no")));
            arrayList2 = arrayList;
            i3 = i2;
            c = cM5917a;
        }
        this.f1053c.add(arrayList2);
        int i5 = i3 + 1;
        this.f1052b.add(new C0255a(i3, String.valueOf(c), i4, 2, false, false, 0));
        this.f1044L = (String[]) arrayList3.toArray(new String[0]);
        startManagingCursor(cursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2077b(Cursor cursor) {
        int i;
        ArrayList arrayList;
        int i2;
        int i3;
        String string;
        this.f1052b.clear();
        this.f1053c.clear();
        if (cursor.getCount() != 0) {
            ArrayList arrayList2 = new ArrayList();
            if (!cursor.isBeforeFirst()) {
                cursor.moveToPosition(-1);
            }
            cursor.moveToNext();
            if (cursor.getInt(cursor.getColumnIndex("group_type")) == 1) {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (cursor.getInt(cursor.getColumnIndex("group_type")) > 1) {
                        i = i5;
                        break;
                    }
                    arrayList2.add(new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
                    i4 = i5 + 1;
                    if (!cursor.moveToNext()) {
                        i = i4;
                        break;
                    }
                }
                this.f1052b.add(new C0255a(1, getResources().getString(R.string.buddy_list_group_favorites), i, 1, false, false, 0));
                this.f1053c.add(arrayList2);
            }
            cursor.moveToPrevious();
            ArrayList arrayList3 = new ArrayList();
            while (cursor.moveToNext() && (string = cursor.getString(cursor.getColumnIndex("group_name"))) != null && string.length() != 0) {
                C0257c c0257c = new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("group_name")), null, null, null, null, true, 0, cursor.getString(cursor.getColumnIndex("group_name")), false, 0, 0, 0, 0, 0, 0, 0, false, false);
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
                c0257c.m2326b(true);
                c0257c.m2321a(map);
                arrayList3.add(c0257c);
            }
            this.f1053c.add(arrayList3);
            this.f1052b.add(new C0255a(1, getResources().getString(R.string.buddy_list_optionmenu_sortby_group), arrayList3.size(), 4, false, false, 0));
            cursor.moveToPrevious();
            int i7 = 2;
            int i8 = 0;
            ArrayList arrayList4 = new ArrayList();
            char c = 0;
            while (true) {
                arrayList = arrayList4;
                if (!cursor.moveToNext()) {
                    break;
                }
                char cM5917a = C1734aq.m5917a(Character.toUpperCase(cursor.getString(cursor.getColumnIndex("buddy_name")).charAt(0)));
                if (c == cM5917a || c == 0) {
                    i2 = i8;
                    i3 = i7;
                    arrayList4 = arrayList;
                } else {
                    this.f1053c.add(arrayList);
                    this.f1052b.add(new C0255a(i7, String.valueOf(c), i8, 2, false, false, 0));
                    i2 = 0;
                    i3 = i7 + 1;
                    arrayList4 = new ArrayList();
                }
                arrayList4.add(new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y"), cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false));
                i8 = i2 + 1;
                i7 = i3;
                c = cM5917a;
            }
            startManagingCursor(cursor);
            if (arrayList != null && arrayList.size() > 0) {
                this.f1053c.add(arrayList);
                int i9 = i7 + 1;
                this.f1052b.add(new C0255a(i7, String.valueOf(c), i8, 2, false, false, 0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2074a(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = this.f1052b.iterator();
        while (it.hasNext()) {
            arrayList3.add(new C0255a((C0255a) it.next()));
        }
        Iterator it2 = this.f1053c.iterator();
        while (it2.hasNext()) {
            ArrayList arrayList5 = (ArrayList) it2.next();
            ArrayList arrayList6 = new ArrayList();
            Iterator it3 = arrayList5.iterator();
            while (it3.hasNext()) {
                C0257c c0257c = (C0257c) it3.next();
                if (C1725ah.m5900a(c0257c.m2324b().toUpperCase(), str.toUpperCase())) {
                    arrayList6.add(new C0257c(c0257c));
                }
            }
            arrayList4.add(arrayList6);
        }
        for (int i = 0; i < arrayList3.size(); i++) {
            if (((ArrayList) arrayList4.get(i)).size() > 0) {
                ((C0255a) arrayList3.get(i)).m2306a(((ArrayList) arrayList4.get(i)).size());
                arrayList.add(arrayList3.get(i));
                arrayList2.add((ArrayList) ((ArrayList) arrayList4.get(i)).clone());
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 0.0f);
        if (arrayList.size() > 0) {
            if (((C0255a) arrayList.get(0)).m2309d() < 2) {
                arrayList.remove(0);
                arrayList2.remove(0);
            }
            this.f1072y.setLayoutParams(layoutParams);
            this.f1073z.setLayoutParams(layoutParams2);
            this.f1033A.setLayoutParams(layoutParams2);
            this.f1056i.m2403a(true);
            m2075a(arrayList, arrayList2);
            return;
        }
        this.f1072y.setLayoutParams(layoutParams2);
        this.f1073z.setLayoutParams(layoutParams);
        this.f1033A.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2075a(ArrayList arrayList, ArrayList arrayList2) {
        this.f1054d.clear();
        this.f1055e.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f1054d.add(new C0255a((C0255a) it.next()));
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ArrayList arrayList3 = (ArrayList) it2.next();
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                arrayList4.add(new C0257c((C0257c) it3.next()));
            }
            this.f1055e.add(arrayList4);
        }
        this.f1056i.notifyDataSetChanged();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1054d.size()) {
                if (((C0255a) this.f1054d.get(i2)).m2309d() == 2) {
                    this.f1072y.expandGroup(i2);
                } else {
                    this.f1072y.collapseGroup(i2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public ArrayList m2101a() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f1053c.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2345q() && !arrayList.contains(c0257c.m2318a())) {
                    arrayList.add(c0257c.m2318a());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m2070a(ExpandableListView expandableListView) {
        Iterator it = this.f1053c.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                ((C0257c) it2.next()).m2322a(false);
            }
        }
        Iterator it3 = this.f1055e.iterator();
        while (it3.hasNext()) {
            Iterator it4 = ((ArrayList) it3.next()).iterator();
            while (it4.hasNext()) {
                ((C0257c) it4.next()).m2322a(false);
            }
        }
        this.f1056i.m2406c();
        this.f1056i.m2398a(this.f1047O);
        this.f1072y.invalidateViews();
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return false;
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C0257c c0257c = (C0257c) ((ArrayList) this.f1055e.get(i)).get(i2);
        if (this.f1047O == 2) {
            if (c0257c.m2350v()) {
                HashMap mapM2351w = c0257c.m2351w();
                if (mapM2351w != null && mapM2351w.size() > 0) {
                    Iterator it = mapM2351w.keySet().iterator();
                    while (it.hasNext()) {
                        String strValueOf = String.valueOf(it.next());
                        String str = (String) mapM2351w.get(strValueOf);
                        C1786r.m6067f(strValueOf + ", " + str, f1032a);
                        boolean z = false;
                        if (this.f1044L != null && this.f1044L.length > 0) {
                            String[] strArr = this.f1044L;
                            int length = strArr.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                if (!strArr[i3].equals(strValueOf)) {
                                    i3++;
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        if (!z) {
                            this.f1056i.m2401a(strValueOf, str);
                            this.f1056i.m2402a(strValueOf, true);
                        }
                    }
                    this.f1056i.m2398a(this.f1047O);
                    this.f1072y.invalidateViews();
                    return true;
                }
                return true;
            }
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.buddy_child_check);
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
            } else {
                checkBox.setChecked(true);
            }
            c0257c.m2322a(checkBox.isChecked());
            this.f1056i.m2402a(c0257c.m2318a(), checkBox.isChecked());
            this.f1072y.invalidateViews();
            this.f1056i.m2398a(this.f1047O);
            return true;
        }
        if (this.f1047O == 1) {
            if (this.f1056i.m2407d()) {
                CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.buddy_child_check);
                if (checkBox2.isChecked()) {
                    checkBox2.setChecked(false);
                } else {
                    checkBox2.setChecked(true);
                }
                c0257c.m2322a(checkBox2.isChecked());
                this.f1056i.m2402a(c0257c.m2318a(), checkBox2.isChecked());
                this.f1072y.invalidateViews();
                this.f1056i.m2398a(this.f1047O);
                return true;
            }
            return true;
        }
        if (this.f1047O == 3) {
            CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.buddy_child_check);
            if (checkBox3.isChecked()) {
                checkBox3.setChecked(false);
            } else {
                checkBox3.setChecked(true);
            }
            c0257c.m2322a(checkBox3.isChecked());
            this.f1056i.m2402a(c0257c.m2318a(), checkBox3.isChecked());
            this.f1072y.invalidateViews();
            this.f1056i.m2398a(this.f1047O);
            return true;
        }
        return true;
    }

    /* renamed from: b */
    public void m2102b() {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = this.f1055e.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2345q()) {
                    hashSet.add(c0257c.m2318a());
                } else {
                    hashSet2.add(c0257c.m2318a());
                }
            }
        }
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            String str = (String) it3.next();
            Iterator it4 = this.f1053c.iterator();
            while (it4.hasNext()) {
                Iterator it5 = ((ArrayList) it4.next()).iterator();
                while (it5.hasNext()) {
                    C0257c c0257c2 = (C0257c) it5.next();
                    if (c0257c2.m2318a().equals(str)) {
                        c0257c2.m2322a(true);
                    }
                }
            }
        }
        Iterator it6 = hashSet2.iterator();
        while (it6.hasNext()) {
            String str2 = (String) it6.next();
            Iterator it7 = this.f1053c.iterator();
            while (it7.hasNext()) {
                Iterator it8 = ((ArrayList) it7.next()).iterator();
                while (it8.hasNext()) {
                    C0257c c0257c3 = (C0257c) it8.next();
                    if (c0257c3.m2318a().equals(str2)) {
                        c0257c3.m2322a(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2069a(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1062o.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2078b(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1062o.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m2085d() {
        m2070a(this.f1072y);
        m2069a(this.f1063p);
        this.f1036D.setText(getString(R.string.buddy_group_profile_title, new Object[]{Integer.valueOf(this.f1057j.m2317c())}));
        this.f1037E.setVisibility(0);
        this.f1041I.setVisibility(0);
        this.f1066s.setVisibility(8);
        this.f1056i.m2405b(false);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            getSupportLoaderManager().restartLoader(this.f1047O, null, this.f1061n);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f1047O == 2) {
            setResult(-1);
            finish();
            return;
        }
        if (this.f1047O == 3) {
            finish();
            return;
        }
        if (this.f1047O == 1) {
            if (this.f1041I.getVisibility() == 8) {
                m2085d();
                return;
            }
            if (this.f1040H.getVisibility() == 0) {
                this.f1038F.setVisibility(0);
                this.f1040H.setVisibility(8);
                this.f1063p.setText("");
                m2069a(this.f1063p);
                return;
            }
            finish();
        }
    }
}
