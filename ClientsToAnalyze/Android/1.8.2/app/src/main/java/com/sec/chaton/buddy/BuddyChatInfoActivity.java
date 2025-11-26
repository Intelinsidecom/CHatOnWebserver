package com.sec.chaton.buddy;

import android.app.ActionBar;
import android.content.ContentValues;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0240a;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.InterfaceC0454a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProfileImageView;
import com.sec.widget.C2153y;

/* loaded from: classes.dex */
public class BuddyChatInfoActivity extends BaseMultiPaneActivity {

    /* renamed from: a */
    public static final String f891a = BuddyChatInfoActivity.class.getSimpleName();

    /* renamed from: b */
    final String f892b;

    /* renamed from: c */
    EditText f893c;

    /* renamed from: d */
    private InterfaceC0454a f894d;

    /* renamed from: e */
    private BuddyFragment f895e = null;

    /* renamed from: i */
    private String f896i;

    /* renamed from: j */
    private ProfileImageView f897j;

    /* renamed from: k */
    private int f898k;

    /* renamed from: l */
    private LinearLayout f899l;

    /* renamed from: m */
    private CheckBox f900m;

    /* renamed from: n */
    private String f901n;

    /* renamed from: o */
    private String f902o;

    /* renamed from: p */
    private boolean f903p;

    /* renamed from: q */
    private String f904q;

    /* renamed from: r */
    private boolean f905r;

    /* renamed from: s */
    private String f906s;

    /* renamed from: t */
    private TextWatcher f907t;

    public BuddyChatInfoActivity() {
        this.f892b = C1767bw.m6002a() ? GlobalApplication.m3256a().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath();
        this.f903p = false;
        this.f905r = false;
        this.f907t = new C0262ad(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_chat_info);
        getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        this.f896i = C1789u.m6075a().getString("Push Name", "");
        this.f893c = (EditText) findViewById(R.id.user_name);
        this.f902o = getIntent().getExtras().getString(ChatFragment.f1750f);
        this.f903p = getIntent().getExtras().getBoolean(ChatFragment.f1753i);
        this.f905r = getIntent().getExtras().getBoolean(ChatFragment.f1755k);
        this.f898k = getIntent().getIntExtra("chatType", 0);
        this.f897j = (ProfileImageView) findViewById(R.id.user_image);
        this.f897j.m6129a(this.f897j, EnumC0695j.m3145a(this.f898k));
        if (bundle == null) {
            this.f895e = new BuddyFragment();
            this.f894d = this.f895e;
            if (EnumC0695j.m3145a(this.f898k) == EnumC0695j.GROUPCHAT) {
                this.f895e.f990b = true;
            } else {
                this.f895e.f990b = false;
            }
            this.f895e.setArguments(m1828b(getIntent()));
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.add(R.id.buddy_controller, this.f895e);
            if (!fragmentTransactionBeginTransaction.isEmpty()) {
                fragmentTransactionBeginTransaction.commit();
            }
        }
        boolean z = getIntent().getExtras().containsKey(ChatFragment.f1758n) ? getIntent().getExtras().getBoolean(ChatFragment.f1758n) : true;
        this.f901n = getIntent().getExtras().getString("inboxNO");
        this.f899l = (LinearLayout) findViewById(R.id.alert_layout);
        this.f900m = (CheckBox) findViewById(R.id.alert_check);
        if (EnumC0695j.m3145a(this.f898k) == EnumC0695j.GROUPCHAT) {
            this.f899l.setVisibility(0);
            if (this.f900m != null) {
                this.f900m.setChecked(z);
                this.f900m.setOnClickListener(new ViewOnClickListenerC0259aa(this));
            }
        } else {
            this.f899l.setVisibility(8);
        }
        if (this.f898k == EnumC0695j.BROADCAST.m3146a()) {
            String str = GlobalApplication.m3262c().getString(R.string.insert_inbox_broad_cast) + " : ";
            if (this.f902o.startsWith(str)) {
                this.f902o = this.f902o.replaceFirst(str, " ");
            }
        }
        this.f893c.setText(this.f902o);
        C1786r.m6064d("mChattitle:" + this.f902o);
        this.f893c.clearFocus();
        this.f893c.addTextChangedListener(this.f907t);
        this.f893c.setOnEditorActionListener(new C0260ab(this));
        this.f893c.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0261ac(this));
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        switch (menuItem.getItemId()) {
            case R.id.actionbar_title_cancel /* 2131494128 */:
                finish();
                return true;
            case R.id.actionbar_title_change /* 2131494129 */:
            default:
                return super.onOptionsItemSelected(menuItem);
            case R.id.actionbar_title_done /* 2131494130 */:
                m1893a();
                return true;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f894d == null || this.f894d.isBackKeyIgnore()) {
            super.onBackPressed();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        C1786r.m6063c("onResume()", f891a);
        super.onResume();
        this.f906s = this.f893c.getText().toString();
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected C0240a mo608a(String str) {
        return super.mo608a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1893a() {
        if (this.f893c.getText().toString().replaceAll(" ", "").replaceAll("\n", "").replaceAll(",", "").length() == 0) {
            this.f893c.clearFocus();
            return;
        }
        if (this.f893c.getText().toString().matches(".*,.*")) {
        }
        if (this.f903p && !this.f906s.equals(this.f893c.getText().toString())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_title", this.f893c.getText().toString());
            contentValues.put("inbox_title_fixed", "Y");
            if (getContentResolver().update(C0694i.f2616a, contentValues, "inbox_no='" + this.f901n + "'", null) > 0) {
                C2153y.m7535a(this, R.string.buddy_profile_saveprofile_toast_success, 0).show();
                this.f902o = this.f893c.getText().toString();
            } else {
                C2153y.m7535a(this, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        } else {
            C2153y.m7535a(this, R.string.buddy_profile_saveprofile_toast_success, 0).show();
            this.f904q = this.f893c.getText().toString();
            this.f902o = this.f893c.getText().toString();
        }
        this.f905r = true;
        this.f893c.clearFocus();
        m1894a(this.f893c);
    }

    /* renamed from: a */
    private void m1894a(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
            if (Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
                actionBar.setTitle(getResources().getString(R.string.chat_view_menu_info2));
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
            }
        }
    }
}
