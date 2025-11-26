package com.sec.chaton.buddy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.coolots.C0529i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.p016a.C0577br;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p017e.p019b.C0680g;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1797a;
import com.sec.chaton.widget.C1798b;
import com.sec.widget.C2126af;
import com.sec.widget.C2153y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GroupProfileFragment extends Fragment {

    /* renamed from: a */
    public static final String f1212a = GroupProfileFragment.class.getSimpleName();

    /* renamed from: f */
    private Context f1217f;

    /* renamed from: g */
    private Bundle f1218g;

    /* renamed from: h */
    private int f1219h;

    /* renamed from: j */
    private EditText f1221j;

    /* renamed from: k */
    private ImageButton f1222k;

    /* renamed from: l */
    private ImageButton f1223l;

    /* renamed from: m */
    private ImageButton f1224m;

    /* renamed from: n */
    private ImageButton f1225n;

    /* renamed from: o */
    private BuddyFragment f1226o;

    /* renamed from: p */
    private C1798b f1227p;

    /* renamed from: q */
    private ListView f1228q;

    /* renamed from: r */
    private String f1229r;

    /* renamed from: s */
    private String f1230s;

    /* renamed from: t */
    private String f1231t;

    /* renamed from: u */
    private C0666j f1232u;

    /* renamed from: v */
    private Toast f1233v;

    /* renamed from: i */
    private String[] f1220i = null;

    /* renamed from: b */
    View.OnClickListener f1213b = new ViewOnClickListenerC0382em(this);

    /* renamed from: c */
    AdapterView.OnItemSelectedListener f1214c = new C0385ep(this);

    /* renamed from: w */
    private TextWatcher f1234w = new C0386eq(this);

    /* renamed from: d */
    InterfaceC0677d f1215d = new C0387er(this);

    /* renamed from: e */
    InterfaceC0667k f1216e = new C0388es(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1217f = GlobalApplication.m3260b();
        this.f1218g = null;
        setHasOptionsMenu(true);
        if (this.f1218g == null) {
            this.f1218g = bundle;
            if (this.f1218g == null) {
                this.f1218g = getArguments();
                if (this.f1218g == null) {
                    Log.e("Group Profile Fragment", "onCreate Finish 1");
                    getActivity().finish();
                    return;
                }
            }
        }
        if (bundle == null) {
            this.f1226o = new BuddyFragment();
            this.f1226o.setArguments(this.f1218g);
            FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.buddy_controller, this.f1226o);
            if (!fragmentTransactionBeginTransaction.isEmpty()) {
                fragmentTransactionBeginTransaction.commit();
            }
        }
        this.f1219h = this.f1218g.getInt("ACTIVITY_PURPOSE");
        this.f1229r = this.f1218g.getString("ACTIVITY_PURPOSE_ARG");
        this.f1230s = this.f1218g.getString("ACTION_PURPOSE_ARG1");
        if (this.f1219h == 6 && this.f1218g.getString("group profile", "profile").equals("GROUP PROFILE")) {
            this.f1220i = this.f1218g.getStringArray("ACTION_PURPOSE_ARG2");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.group_profile_layout, viewGroup, false);
        this.f1221j = (EditText) viewInflate.findViewById(R.id.group_name);
        this.f1232u = new C0666j(getActivity().getContentResolver(), this.f1216e);
        this.f1222k = (ImageButton) viewInflate.findViewById(R.id.group_profile_chat);
        this.f1223l = (ImageButton) viewInflate.findViewById(R.id.group_profile_call);
        this.f1225n = (ImageButton) viewInflate.findViewById(R.id.group_profile_video_call);
        this.f1224m = (ImageButton) viewInflate.findViewById(R.id.group_profile_broadcast);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1797a(getResources().getString(R.string.buddy_list_optionmenu_editgroup), R.drawable.edit_group));
        arrayList.add(new C1797a(getResources().getString(R.string.buddy_group_list_header_delete), R.drawable.delete));
        this.f1227p = new C1798b(this.f1217f, arrayList);
        this.f1228q = (ListView) viewInflate.findViewById(R.id.group_profile_option_list);
        this.f1218g.getInt(ChatFragment.f1757m);
        this.f1228q = (ListView) viewInflate.findViewById(R.id.group_profile_option_list);
        this.f1228q.setOnItemClickListener(new C0379ej(this));
        if (!C0529i.m2697a(this.f1217f)) {
            this.f1223l.setVisibility(8);
            this.f1225n.setVisibility(8);
        } else {
            if (C1789u.m6075a().getInt("group_voice_call_max_count", 4) == 1 || !C0577br.m2769h()) {
                this.f1223l.setVisibility(8);
            } else {
                this.f1223l.setVisibility(0);
            }
            if (C1789u.m6075a().getInt("group_video_call_max_count", 4) == 1 || !C0577br.m2770i()) {
                this.f1225n.setVisibility(8);
            } else {
                this.f1225n.setVisibility(0);
            }
        }
        if (this.f1230s != null) {
            this.f1221j.setText(this.f1230s);
            this.f1221j.setSelection(this.f1230s.length());
        }
        if (!getActivity().getClass().equals(GroupProfileActivity.class)) {
            this.f1221j.setKeyListener(null);
            this.f1226o.m2037a(false);
        } else {
            this.f1221j.clearFocus();
            this.f1221j.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0380ek(this));
            this.f1221j.addTextChangedListener(this.f1234w);
            C2126af.m7480a(this.f1221j, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
            this.f1221j.setOnEditorActionListener(new C0381el(this));
        }
        this.f1222k.setOnClickListener(this.f1213b);
        this.f1224m.setOnClickListener(this.f1213b);
        this.f1223l.setOnClickListener(this.f1213b);
        this.f1225n.setOnClickListener(this.f1213b);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
            return true;
        }
        if (menuItem.getItemId() == 123) {
            if (this.f1228q.getVisibility() == 0) {
                this.f1228q.setVisibility(8);
            } else {
                this.f1228q.setVisibility(0);
                this.f1228q.setDivider(this.f1217f.getResources().getDrawable(R.drawable.list_2line));
                this.f1228q.setAdapter((ListAdapter) this.f1226o.m2058o());
                this.f1228q.setOnItemSelectedListener(this.f1226o.m2059p());
            }
        } else if (menuItem.getItemId() == R.id.actionbar_title_done) {
            m2232a();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2232a() {
        if (this.f1221j.getText().toString().trim().length() > 0) {
            this.f1231t = this.f1221j.getText().toString().trim();
            if (this.f1231t.toUpperCase().equals(getResources().getString(R.string.buddy_list_group_birthday).toUpperCase()) || this.f1231t.toUpperCase().equals(getResources().getString(R.string.buddy_list_group_favorites).toUpperCase()) || this.f1231t.toUpperCase().equals(getResources().getString(R.string.buddy_list_group_favorites2).toUpperCase())) {
                C2153y.m7536a(getActivity().getApplicationContext(), getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0).show();
                return;
            }
            if (!TextUtils.isEmpty(this.f1231t)) {
                C0668l.m3077a(new C0668l(), 153, new C0680g(this.f1215d, this.f1231t, 3));
            }
            this.f1221j.clearFocus();
            m2233a(this.f1221j);
        }
    }

    /* renamed from: a */
    private void m2233a(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1217f.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.f1221j.removeTextChangedListener(this.f1234w);
        super.onPause();
    }
}
