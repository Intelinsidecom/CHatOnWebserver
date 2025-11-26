package com.sec.chaton.localbackup;

import android.annotation.SuppressLint;
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
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.widget.C4923p;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class SecretKeyView extends Fragment {

    /* renamed from: a */
    private final int f9006a = 8;

    /* renamed from: b */
    private final int f9007b = 16;

    /* renamed from: c */
    private EditText f9008c;

    /* renamed from: d */
    private TextView f9009d;

    /* renamed from: e */
    private TextView f9010e;

    /* renamed from: f */
    private EditText f9011f;

    /* renamed from: g */
    private TextView f9012g;

    /* renamed from: h */
    private LinearLayout f9013h;

    /* renamed from: i */
    private String f9014i;

    /* renamed from: j */
    private String f9015j;

    /* renamed from: k */
    private boolean f9016k;

    /* renamed from: l */
    private Dialog f9017l;

    /* renamed from: m */
    private Dialog f9018m;

    /* renamed from: n */
    private Dialog f9019n;

    /* renamed from: o */
    private String f9020o;

    /* renamed from: p */
    private String f9021p;

    /* renamed from: q */
    private Menu f9022q;

    /* renamed from: r */
    private Activity f9023r;

    /* renamed from: s */
    private AsyncTaskC2514aa f9024s;

    /* renamed from: t */
    private LinearLayout f9025t;

    /* renamed from: u */
    private InterfaceC2515ab f9026u;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f9016k = arguments.getBoolean("password_mode");
        this.f9020o = arguments.getString("target_filepath");
        this.f9021p = arguments.getString(BackupListView.f8996a);
        if (!C4873ck.m18500a()) {
            m10851a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9023r = activity;
        try {
            this.f9026u = (InterfaceC2515ab) this.f9023r;
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must implement ITrunkViewListener.", activity.toString()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f9024s != null) {
            this.f9024s.cancel(true);
            C5179v.m19810a(this.f9023r, R.string.backup_failed, 1).show();
        }
        this.f9023r = null;
        this.f9026u = null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_secretkey, viewGroup, false);
        this.f9025t = (LinearLayout) viewInflate.findViewById(R.id.hiddenlayout);
        this.f9008c = (EditText) viewInflate.findViewById(R.id.txtPassword);
        this.f9009d = (TextView) viewInflate.findViewById(R.id.txtGuide);
        this.f9011f = (EditText) viewInflate.findViewById(R.id.txtConfirm);
        this.f9012g = (TextView) viewInflate.findViewById(R.id.password_guide);
        if (!this.f9016k) {
            this.f9013h = (LinearLayout) viewInflate.findViewById(R.id.confirmLayout);
            this.f9010e = (TextView) viewInflate.findViewById(R.id.password_title);
            this.f9013h.setVisibility(8);
            this.f9010e.setText(getString(R.string.summary_for_passlock));
            this.f9025t.setVisibility(8);
        }
        PasswordTransformationMethod passwordTransformationMethod = new PasswordTransformationMethod();
        this.f9008c.setTransformationMethod(passwordTransformationMethod);
        if (this.f9016k) {
            this.f9011f.setTransformationMethod(passwordTransformationMethod);
            this.f9009d.setText(String.format(this.f9023r.getString(R.string.minPassword), 8));
            this.f9012g.setVisibility(0);
            this.f9025t.requestFocus();
        }
        this.f9008c.addTextChangedListener(new C2564w(this));
        this.f9011f.addTextChangedListener(new C2565x(this));
        setHasOptionsMenu(true);
        this.f9008c.requestFocus();
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10853a(boolean z) {
        if (this.f9022q != null) {
            this.f9022q.findItem(R.id.backup_secretkey_done).setEnabled(z);
        }
    }

    /* renamed from: a */
    private void m10851a() {
        if (this.f9018m == null) {
            this.f9018m = AbstractC4932a.m18733a(this.f9023r).mo18734a(R.string.backup).mo18746b(R.string.unable_backup_sdcard).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2566y(this)).mo18745a().mo18758a();
            this.f9018m.setCancelable(false);
        }
        if (this.f9018m != null) {
            this.f9018m.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10854b() {
        if (this.f9019n == null) {
            this.f9019n = AbstractC4932a.m18733a(this.f9023r).mo18734a(R.string.password_title).mo18746b(R.string.backup_password_toast).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2567z(this)).mo18745a().mo18758a();
            this.f9019n.setCancelable(false);
        }
        if (this.f9019n != null) {
            this.f9019n.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10857c() {
        if (this.f9017l == null) {
            this.f9017l = new C4923p(this.f9023r).m18724a(R.string.setting_webview_please_wait);
            this.f9017l.setCancelable(false);
        }
        if (this.f9017l != null) {
            this.f9017l.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.backup_secretkey_menu, menu);
        this.f9022q = menu;
        m10853a(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C2560s c2560s = new C2560s();
        switch (menuItem.getItemId()) {
            case R.id.backup_secretkey_done /* 2131166667 */:
                this.f9014i = this.f9008c.getText().toString();
                if (this.f9016k) {
                    this.f9015j = this.f9011f.getText().toString();
                    if (this.f9014i != null) {
                        if (this.f9014i.equals(this.f9015j)) {
                            try {
                                c2560s.m10969a(EnumC2562u.ENCRYPT, this.f9014i);
                                this.f9026u.mo10835b(true);
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return false;
                            }
                        } else {
                            m10854b();
                            break;
                        }
                    }
                } else {
                    try {
                        if (this.f9014i != null) {
                            m10859d();
                        } else {
                            m10854b();
                            this.f9008c.setText("");
                        }
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        m10854b();
                        this.f9008c.setText("");
                        return false;
                    }
                }
                break;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    private void m10859d() {
        this.f9024s = new AsyncTaskC2514aa(this, null);
        if (Build.VERSION.SDK_INT < 11) {
            this.f9024s.execute(new Void[0]);
        } else {
            this.f9024s.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }
}
