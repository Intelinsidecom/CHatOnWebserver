package com.sec.chaton.settings;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C4875cm;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5033j;
import com.sec.widget.C5144ag;
import java.util.Timer;

/* loaded from: classes.dex */
public class FragmentPasswordLockHint extends Fragment {

    /* renamed from: f */
    private FragmentActivity f12728f;

    /* renamed from: g */
    private MenuItem f12729g;

    /* renamed from: h */
    private MenuItem f12730h;

    /* renamed from: a */
    private final int f12723a = 0;

    /* renamed from: b */
    private String f12724b = ActivityPasswordLockHint.class.getSimpleName();

    /* renamed from: c */
    private EditText f12725c = null;

    /* renamed from: d */
    private TextView f12726d = null;

    /* renamed from: e */
    private String f12727e = null;

    /* renamed from: i */
    private int f12731i = 0;

    /* renamed from: j */
    private TextWatcher f12732j = new C3609es(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12728f = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        BaseActivity.m6160a((Fragment) this, true);
        View viewInflate = layoutInflater.inflate(R.layout.layout_password_lock_hint, viewGroup, false);
        C4875cm.m18511a(this.f12728f);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + this.f12728f.isTaskRoot() + ", Task ID: " + this.f12728f.getTaskId() + ", Memory Address:" + this, this.f12724b);
        this.f12725c = (EditText) viewInflate.findViewById(R.id.password_hint);
        this.f12725c.setFilters(new InputFilter[]{new C4902w(getActivity(), 40)});
        this.f12726d = (TextView) viewInflate.findViewById(R.id.password_hint_length);
        if (bundle != null) {
            this.f12725c.setText(bundle.getString("hint_text"));
            this.f12731i = bundle.getInt("hint_text_length");
            this.f12726d.setText(this.f12731i + "/40");
        } else {
            this.f12726d.setText(this.f12725c.length() + "/40");
        }
        m13598c();
        this.f12727e = this.f12728f.getSharedPreferences("PASSWORD_LOCK", 0).getString("PASSWORD_HINT", "");
        C4904y.m18641c("[LIFE] onCreate Hint" + this.f12727e, this.f12724b);
        if ("".equals(this.f12727e)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Hint null", this.f12724b);
            }
        } else {
            String strM13594b = m13594b(this.f12727e);
            if (C4904y.f17872b) {
                C4904y.m18639b("Hint : " + strM13594b, this.f12724b);
            }
            this.f12725c.setText(strM13594b);
            Editable text = this.f12725c.getText();
            if (text != null && text.length() != 0) {
                int iMin = Math.min(text.length(), 100);
                this.f12725c.setSelection(iMin, iMin);
            }
            if (this.f12729g != null) {
                this.f12729g.setEnabled(true);
            }
            if (this.f12730h != null) {
                this.f12730h.setEnabled(true);
            }
        }
        this.f12725c.addTextChangedListener(this.f12732j);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.cancel_done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f12729g = null;
        this.f12730h = null;
        this.f12729g = menu.findItem(R.id.menu_done);
        this.f12729g.setEnabled(false);
        this.f12730h = menu.findItem(R.id.menu_cancel);
        if (this.f12730h != null) {
            this.f12730h.setEnabled(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_done) {
            m13595b();
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_cancel) {
            this.f12728f.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("hint_text_length", this.f12731i);
        bundle.putString("hint_text", this.f12725c.getText().toString());
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12728f = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13595b() {
        this.f12727e = this.f12725c.getText().toString();
        if (C4904y.f17872b) {
            C4904y.m18639b("editTextpasswordhint : " + this.f12727e, this.f12724b);
        }
        String strM13593a = m13593a(this.f12727e);
        SharedPreferences.Editor editorEdit = this.f12728f.getSharedPreferences("PASSWORD_LOCK", 0).edit();
        editorEdit.putString("PASSWORD_HINT", strM13593a);
        C5033j.m19087a(editorEdit);
        this.f12728f.finish();
    }

    /* renamed from: c */
    private void m13598c() {
        this.f12725c.setOnEditorActionListener(new C3608er(this));
        C5144ag.m19709a(this.f12725c, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C4904y.m18641c("[LIFE] onStart, isTaskRoot: " + this.f12728f.isTaskRoot() + ", Task ID: " + this.f12728f.getTaskId() + ", Memory Address:" + this, this.f12724b);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m13602a();
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + this.f12728f.isTaskRoot() + ", Task ID: " + this.f12728f.getTaskId() + ", Memory Address:" + this, this.f12724b);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C4904y.m18641c("[LIFE] onPause, isTaskRoot: " + this.f12728f.isTaskRoot() + ", Task ID: " + this.f12728f.getTaskId() + ", Memory Address:" + this, this.f12724b);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        m13600d();
        C4904y.m18641c("[LIFE] onStop, isTaskRoot: " + this.f12728f.isTaskRoot() + ", Task ID: " + this.f12728f.getTaskId() + ", Memory Address:" + this, this.f12724b);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m13600d();
        C4904y.m18641c("[LIFE] onDestroy, isTaskRoot: " + this.f12728f.isTaskRoot() + ", Task ID: " + this.f12728f.getTaskId() + ", Memory Address:" + this, this.f12724b);
    }

    /* renamed from: a */
    public void m13602a() {
        new Timer(true).schedule(new C3610et(this, new Handler(), (InputMethodManager) this.f12728f.getSystemService("input_method")), 100L);
    }

    /* renamed from: d */
    private void m13600d() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f12728f.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f12725c.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private String m13593a(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    /* renamed from: b */
    private String m13594b(String str) {
        return new String(Base64.decode(str, 0));
    }
}
