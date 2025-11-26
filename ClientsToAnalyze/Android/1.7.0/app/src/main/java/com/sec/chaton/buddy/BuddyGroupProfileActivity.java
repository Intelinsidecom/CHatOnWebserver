package com.sec.chaton.buddy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p017a.C0365c;
import com.sec.chaton.coolots.AbstractC0617h;
import com.sec.chaton.p013a.p014a.C0159bh;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.p025d.p027b.C0649l;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1606ac;
import com.sec.widget.C1632t;
import com.sec.widget.EditTextWithClearButton;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class BuddyGroupProfileActivity extends BaseActivity implements InterfaceC0387av {

    /* renamed from: a */
    public static final String f1176a = BuddyGroupProfileActivity.class.getSimpleName();

    /* renamed from: e */
    private GeneralHeaderView f1180e;

    /* renamed from: f */
    private C0365c f1181f;

    /* renamed from: g */
    private C1632t f1182g;

    /* renamed from: i */
    private Context f1183i;

    /* renamed from: j */
    private EditTextWithClearButton f1184j;

    /* renamed from: k */
    private TextView f1185k;

    /* renamed from: l */
    private String f1186l;

    /* renamed from: m */
    private C0630j f1187m;

    /* renamed from: n */
    private Toast f1188n;

    /* renamed from: o */
    private ImageButton f1189o;

    /* renamed from: p */
    private ImageButton f1190p;

    /* renamed from: q */
    private ImageButton f1191q;

    /* renamed from: r */
    private ImageButton f1192r;

    /* renamed from: s */
    private int f1193s;

    /* renamed from: t */
    private boolean f1194t;

    /* renamed from: b */
    InterfaceC0641d f1177b = new C0375aj(this);

    /* renamed from: c */
    View.OnClickListener f1178c = new ViewOnClickListenerC0376ak(this);

    /* renamed from: u */
    private View.OnTouchListener f1195u = new ViewOnTouchListenerC0373ah(this);

    /* renamed from: v */
    private TextWatcher f1196v = new C0374ai(this);

    /* renamed from: d */
    InterfaceC0626f f1179d = new C0372ag(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4663f("onCreate()", f1176a);
        setContentView(R.layout.buddy_group_profile);
        if (bundle == null) {
            BuddyFragment buddyFragment = new BuddyFragment();
            buddyFragment.setArguments(m2042b(getIntent()));
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_controller, buddyFragment, "com.sec.chaton:single_pane_fragment").commit();
        }
        this.f1187m = new C0630j(getContentResolver(), this.f1179d);
        m2226b();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f1184j.addTextChangedListener(this.f1196v);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f1184j.removeTextChangedListener(this.f1196v);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public BuddyFragment m2222a() {
        return (BuddyFragment) getSupportFragmentManager().findFragmentByTag("com.sec.chaton:single_pane_fragment");
    }

    /* renamed from: b */
    private void m2226b() {
        this.f1183i = this;
        this.f1181f = (C0365c) getIntent().getExtras().get("groupInfo");
        this.f1180e = (GeneralHeaderView) findViewById(R.id.headerView);
        this.f1184j = (EditTextWithClearButton) findViewById(R.id.buddy_group_profile_edit_groupname);
        this.f1185k = (TextView) findViewById(R.id.group_profile_buddis_layout_title);
        this.f1182g = new C1632t(this);
        this.f1193s = this.f1181f.m2350c();
        this.f1180e.setText(getString(R.string.buddy_group_profile_title, new Object[]{Integer.valueOf(this.f1193s)}));
        this.f1180e.setButtonClickListener(this.f1178c);
        this.f1180e.setButtonEnabled(false);
        this.f1185k.setText(getString(R.string.buddy_group_profile_buddy) + " (" + this.f1193s + ")");
        this.f1184j.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0379an(this));
        this.f1184j.addTextChangedListener(this.f1196v);
        C1606ac.m5880a(this.f1184j, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
        this.f1184j.setMaxLengthString(R.string.toast_text_max_Length);
        this.f1184j.setText(this.f1181f.m2349b());
        this.f1184j.setOnEditorActionListener(new C0377al(this));
        this.f1191q = (ImageButton) findViewById(R.id.group_profile_call);
        this.f1192r = (ImageButton) findViewById(R.id.group_profile_videocall);
        this.f1189o = (ImageButton) findViewById(R.id.group_profile_start_chat);
        this.f1190p = (ImageButton) findViewById(R.id.group_profile_broadcast);
        if (AbstractC0617h.m2831a(this)) {
            if (C1323bs.m4575a().getInt("group_voice_call_max_count", 1) == 1 || !C0159bh.m694g()) {
                this.f1191q.setVisibility(8);
            } else {
                this.f1191q.setVisibility(0);
            }
            if (C1323bs.m4575a().getInt("group_video_call_max_count", 1) == 1 || !C0159bh.m695h()) {
                this.f1192r.setVisibility(8);
            } else {
                this.f1192r.setVisibility(0);
            }
        } else {
            this.f1191q.setVisibility(8);
            this.f1192r.setVisibility(8);
        }
        this.f1191q.setOnClickListener(this.f1178c);
        this.f1192r.setOnClickListener(this.f1178c);
        this.f1189o.setOnClickListener(this.f1178c);
        this.f1190p.setOnClickListener(this.f1178c);
        this.f1191q.setOnTouchListener(this.f1195u);
        this.f1192r.setOnTouchListener(this.f1195u);
        this.f1189o.setOnTouchListener(this.f1195u);
        this.f1190p.setOnTouchListener(this.f1195u);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, R.string.tablet_nonselef_sms_edit).setIcon(R.drawable.group_delete);
        menu.add(0, 2, 1, R.string.buddy_group_list_header_delete).setIcon(R.drawable.group_delete);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                Intent intent = new Intent(this, (Class<?>) BuddyGroupMemberEditActivity.class);
                intent.putExtra("ACTIVITY_PURPOSE", 19);
                intent.putExtra("groupInfo", this.f1181f);
                startActivity(intent);
                break;
            case 2:
                new AlertDialogBuilderC1625m(this.f1183i).setTitle(getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).setMessage(getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0378am(this)).setNegativeButton(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2229c() {
        this.f1184j.clearFocus();
        m2224a(this.f1184j);
        this.f1186l = this.f1184j.getText().toString().trim();
        if (!TextUtils.isEmpty(this.f1186l)) {
            C0627g.m2858a(new C0627g(), 2, new C0649l(this.f1177b, this.f1186l, 3));
        }
    }

    /* renamed from: a */
    private void m2224a(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1183i.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.sec.chaton.buddy.InterfaceC0387av
    /* renamed from: a */
    public void mo2218a(int i) {
    }

    @Override // com.sec.chaton.buddy.InterfaceC0387av
    /* renamed from: b */
    public void mo2219b(int i) {
        this.f1193s = i;
        this.f1180e.setText(getString(R.string.buddy_group_profile_title, new Object[]{Integer.valueOf(this.f1193s)}));
        this.f1185k.setText(getString(R.string.buddy_group_profile_buddy) + " (" + this.f1193s + ")");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (C1632t.m5917c() && this.f1182g != null) {
            if (this.f1182g.m5920b()) {
                this.f1182g.m5918a();
            } else {
                this.f1182g.m5919a(findViewById(R.id.header_button1));
            }
            return false;
        }
        return super.onMenuOpened(i, menu);
    }
}
