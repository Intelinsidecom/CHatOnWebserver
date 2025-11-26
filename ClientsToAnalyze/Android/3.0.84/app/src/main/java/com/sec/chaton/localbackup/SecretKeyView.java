package com.sec.chaton.localbackup;

import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.widget.C3263j;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class SecretKeyView extends Fragment {

    /* renamed from: a */
    private final int f5964a = 8;

    /* renamed from: b */
    private final int f5965b = 16;

    /* renamed from: c */
    private EditText f5966c;

    /* renamed from: d */
    private TextView f5967d;

    /* renamed from: e */
    private TextView f5968e;

    /* renamed from: f */
    private EditText f5969f;

    /* renamed from: g */
    private TextView f5970g;

    /* renamed from: h */
    private LinearLayout f5971h;

    /* renamed from: i */
    private String f5972i;

    /* renamed from: j */
    private String f5973j;

    /* renamed from: k */
    private boolean f5974k;

    /* renamed from: l */
    private Dialog f5975l;

    /* renamed from: m */
    private Dialog f5976m;

    /* renamed from: n */
    private Dialog f5977n;

    /* renamed from: o */
    private String f5978o;

    /* renamed from: p */
    private String f5979p;

    /* renamed from: q */
    private Menu f5980q;

    /* renamed from: r */
    private Activity f5981r;

    /* renamed from: s */
    private AsyncTaskC1666y f5982s;

    /* renamed from: t */
    private LinearLayout f5983t;

    /* renamed from: u */
    private InterfaceC1667z f5984u;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f5974k = arguments.getBoolean("password_mode");
        this.f5978o = arguments.getString("target_filepath");
        this.f5979p = arguments.getString(BackupListView.f5955a);
        if (!C3223ck.m11327a()) {
            m6823a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5981r = activity;
        try {
            this.f5984u = (InterfaceC1667z) this.f5981r;
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must implement ITrunkViewListener.", activity.toString()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f5982s != null) {
            this.f5982s.cancel(true);
            C3641ai.m13210a(this.f5981r, R.string.backup_failed, 1).show();
        }
        this.f5981r = null;
        this.f5984u = null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_secretkey, viewGroup, false);
        this.f5983t = (LinearLayout) viewInflate.findViewById(R.id.hiddenlayout);
        this.f5966c = (EditText) viewInflate.findViewById(R.id.txtPassword);
        this.f5967d = (TextView) viewInflate.findViewById(R.id.txtGuide);
        this.f5969f = (EditText) viewInflate.findViewById(R.id.txtConfirm);
        this.f5970g = (TextView) viewInflate.findViewById(R.id.password_guide);
        if (!this.f5974k) {
            this.f5971h = (LinearLayout) viewInflate.findViewById(R.id.confirmLayout);
            this.f5968e = (TextView) viewInflate.findViewById(R.id.password_title);
            this.f5971h.setVisibility(8);
            this.f5968e.setText(getString(R.string.summary_for_passlock));
            this.f5983t.setVisibility(8);
        }
        PasswordTransformationMethod passwordTransformationMethod = new PasswordTransformationMethod();
        this.f5966c.setTransformationMethod(passwordTransformationMethod);
        if (this.f5974k) {
            this.f5969f.setTransformationMethod(passwordTransformationMethod);
            this.f5967d.setText(String.format(this.f5981r.getString(R.string.minPassword), 8));
            this.f5970g.setVisibility(0);
            this.f5983t.requestFocus();
        }
        this.f5966c.addTextChangedListener(new C1662u(this));
        this.f5969f.addTextChangedListener(new C1663v(this));
        setHasOptionsMenu(true);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6825a(boolean z) {
        if (this.f5980q != null) {
            this.f5980q.findItem(R.id.backup_secretkey_done).setEnabled(z);
        }
    }

    /* renamed from: a */
    private void m6823a() {
        if (this.f5976m == null) {
            this.f5976m = AbstractC3271a.m11494a(this.f5981r).mo11495a(R.string.backup).mo11506b(R.string.unable_backup_sdcard).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1664w(this)).mo11505a().mo11517a();
            this.f5976m.setCancelable(false);
        }
        if (this.f5976m != null) {
            this.f5976m.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6826b() {
        if (this.f5977n == null) {
            this.f5977n = AbstractC3271a.m11494a(this.f5981r).mo11495a(R.string.password_title).mo11506b(R.string.backup_password_toast).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1665x(this)).mo11505a().mo11517a();
            this.f5977n.setCancelable(false);
        }
        if (this.f5977n != null) {
            this.f5977n.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6829c() {
        if (this.f5975l == null) {
            this.f5975l = new C3263j(this.f5981r).m11487a(R.string.setting_webview_please_wait);
            this.f5975l.setCancelable(false);
        }
        if (this.f5975l != null) {
            this.f5975l.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.backup_secretkey_menu, menu);
        this.f5980q = menu;
        m6825a(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C1658q c1658q = new C1658q();
        switch (menuItem.getItemId()) {
            case R.id.backup_secretkey_done /* 2131166585 */:
                this.f5972i = this.f5966c.getText().toString();
                if (this.f5974k) {
                    this.f5973j = this.f5969f.getText().toString();
                    if (this.f5972i != null) {
                        if (this.f5972i.equals(this.f5973j)) {
                            try {
                                c1658q.m6938a(EnumC1660s.ENCRYPT, this.f5972i);
                                this.f5984u.mo6807a(true);
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return false;
                            }
                        } else {
                            m6826b();
                            break;
                        }
                    }
                } else {
                    try {
                        if (this.f5972i != null) {
                            m6831d();
                        } else {
                            m6826b();
                            this.f5966c.setText("");
                        }
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        m6826b();
                        this.f5966c.setText("");
                        return false;
                    }
                }
                break;
            case R.id.backup_secretkey_cancel /* 2131166586 */:
                getActivity().finish();
                break;
        }
        return false;
    }

    /* renamed from: d */
    private void m6831d() {
        this.f5982s = new AsyncTaskC1666y(this, null);
        if (Build.VERSION.SDK_INT < 11) {
            this.f5982s.execute(new Void[0]);
        } else {
            this.f5982s.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }
}
