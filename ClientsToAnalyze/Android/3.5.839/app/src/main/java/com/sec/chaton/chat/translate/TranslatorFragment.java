package com.sec.chaton.chat.translate;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TranslatorFragment extends Fragment {

    /* renamed from: a */
    public static final String f6968a = TranslatorFragment.class.getSimpleName();

    /* renamed from: b */
    Context f6969b;

    /* renamed from: d */
    AsyncTaskC1848ad f6971d;

    /* renamed from: e */
    TranslatorSpinner f6972e;

    /* renamed from: f */
    TranslatorSpinner f6973f;

    /* renamed from: g */
    EditText f6974g;

    /* renamed from: h */
    EditText f6975h;

    /* renamed from: i */
    LinearLayout f6976i;

    /* renamed from: j */
    private Activity f6977j;

    /* renamed from: l */
    private String f6979l;

    /* renamed from: m */
    private String f6980m;

    /* renamed from: n */
    private String f6981n;

    /* renamed from: o */
    private String f6982o;

    /* renamed from: p */
    private String f6983p;

    /* renamed from: q */
    private String f6984q;

    /* renamed from: r */
    private String f6985r;

    /* renamed from: s */
    private ImageButton f6986s;

    /* renamed from: k */
    private ProgressDialog f6978k = null;

    /* renamed from: c */
    C1850c f6970c = null;

    /* renamed from: t */
    private TextWatcher f6987t = new C1846ab(this);

    /* renamed from: u */
    private TextWatcher f6988u = new C1847ac(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6977j = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f6977j = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6969b = this.f6977j.getApplicationContext();
        this.f6970c = C1850c.m9024d();
        this.f6979l = this.f6977j.getIntent().getExtras().getString("source_language");
        this.f6981n = this.f6977j.getIntent().getExtras().getString("source_text");
        this.f6980m = this.f6977j.getIntent().getExtras().getString("target_language");
        this.f6982o = this.f6977j.getIntent().getExtras().getString("TRANSLATOR_INBOX_NO");
        this.f6983p = this.f6977j.getIntent().getExtras().getString("TRANSLATOR_MESSAGE_ID");
        this.f6983p = "-1";
        this.f6984q = this.f6981n;
        C4904y.m18639b("Source Lang Code for Translator : " + this.f6979l, f6968a);
        C4904y.m18639b("Target Lang Code for Translator : " + this.f6980m, f6968a);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.chat_translator_page, viewGroup, false);
        BaseActivity.m6160a((Fragment) this, true);
        this.f6972e = (TranslatorSpinner) viewInflate.findViewById(R.id.chat_translator_lang_spinner_me);
        this.f6973f = (TranslatorSpinner) viewInflate.findViewById(R.id.chat_translator_lang_spinner_buddy);
        this.f6974g = (EditText) viewInflate.findViewById(R.id.chat_translator_msg_me);
        this.f6975h = (EditText) viewInflate.findViewById(R.id.chat_translator_msg_buddy);
        this.f6974g.setImeOptions(1073741830);
        this.f6975h.setImeOptions(0);
        m9003a(this.f6974g, false);
        m9003a(this.f6975h, false);
        this.f6976i = (LinearLayout) viewInflate.findViewById(R.id.chat_translator_trans_button);
        this.f6976i.setOnClickListener(new ViewOnClickListenerC1866s(this));
        this.f6986s = (ImageButton) viewInflate.findViewById(R.id.chat_translator_send);
        this.f6986s.setOnClickListener(new ViewOnClickListenerC1869v(this));
        this.f6974g.addTextChangedListener(this.f6987t);
        this.f6974g.setOnTouchListener(new ViewOnTouchListenerC1870w(this));
        this.f6974g.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1871x(this));
        this.f6975h.addTextChangedListener(this.f6988u);
        this.f6975h.setOnTouchListener(new ViewOnTouchListenerC1872y(this));
        this.f6975h.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1873z(this));
        this.f6978k = (ProgressDialog) new C4923p(this.f6977j).m18724a(R.string.dialog_connecting_server);
        this.f6978k.setCancelable(true);
        this.f6978k.setOnCancelListener(new DialogInterfaceOnCancelListenerC1845aa(this));
        m8992c();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            m8997e();
            this.f6977j.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: c */
    private void m8992c() {
        this.f6974g.setText(this.f6981n);
        m8987a(false);
        m8995d();
        m8984a(this.f6974g, this.f6975h, this.f6979l, this.f6980m);
    }

    /* renamed from: d */
    private void m8995d() {
        C1849b c1849bM9017a = C1849b.m9017a(this.f6977j, android.R.layout.simple_spinner_item, android.R.id.text1, new ArrayList());
        C1849b c1849bM9017a2 = C1849b.m9017a(this.f6977j, android.R.layout.simple_spinner_item, android.R.id.text1, new ArrayList());
        Iterator<String> it = this.f6970c.m9039e().f6998I.iterator();
        while (it.hasNext()) {
            String next = it.next();
            c1849bM9017a.add(next);
            c1849bM9017a2.add(next);
        }
        c1849bM9017a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c1849bM9017a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.f6972e.setAdapter((SpinnerAdapter) c1849bM9017a);
        this.f6973f.setAdapter((SpinnerAdapter) c1849bM9017a2);
        this.f6979l = C1850c.m9024d().m9039e().m9013d(this.f6979l);
        this.f6980m = C1850c.m9024d().m9039e().m9014e(this.f6980m);
        int iM8981a = m8981a(this.f6970c, this.f6979l, this.f6972e);
        int iM8981a2 = m8981a(this.f6970c, this.f6980m, this.f6973f);
        this.f6972e.setSelection(iM8981a);
        this.f6973f.setSelection(iM8981a2);
        this.f6979l = this.f6970c.m9034b((String) ((ArrayAdapter) this.f6972e.getAdapter()).getItem(iM8981a));
        this.f6980m = this.f6970c.m9034b((String) ((ArrayAdapter) this.f6973f.getAdapter()).getItem(iM8981a2));
        this.f6970c.m9039e().m9008a(this.f6973f, this.f6979l, this.f6980m);
        this.f6972e.setOnItemSelectedListener(new C1867t(this));
        this.f6973f.setOnItemSelectedListener(new C1868u(this));
    }

    /* renamed from: a */
    private int m8981a(C1850c c1850c, String str, Spinner spinner) {
        ArrayAdapter arrayAdapter = (ArrayAdapter) spinner.getAdapter();
        for (int i = 0; i < arrayAdapter.getCount(); i++) {
            if (str.equals(c1850c.m9034b((String) arrayAdapter.getItem(i)))) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8984a(EditText editText, EditText editText2, String str, String str2) {
        if (!m8999f()) {
            C4904y.m18646e("Network not available", getClass().getSimpleName());
            return;
        }
        this.f6978k.show();
        this.f6971d = new AsyncTaskC1848ad(this, editText, editText2, str, str2);
        this.f6971d.execute(new Void[0]);
    }

    /* renamed from: a */
    public void m9002a() {
        Bundle bundle = new Bundle();
        Intent intent = this.f6977j.getIntent();
        String string = this.f6974g.getText().toString();
        String string2 = this.f6975h.getText().toString();
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            bundle.putString("source_text", string);
            bundle.putString("target_text", string2);
            bundle.putString("source_language", this.f6979l);
            bundle.putString("target_language", this.f6980m);
            intent.putExtras(bundle);
            this.f6977j.setResult(-1, intent);
        }
        this.f6977j.finish();
    }

    /* renamed from: e */
    private void m8997e() {
        this.f6977j.setResult(0);
    }

    /* renamed from: b */
    public void m9004b() {
        if (this.f6978k != null && this.f6978k.isShowing()) {
            if (this.f6971d != null) {
                this.f6971d.cancel(true);
            }
            this.f6978k.dismiss();
        } else {
            m8997e();
            this.f6977j.finish();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C4904y.m18646e("onResume", getClass().getSimpleName());
        this.f6977j.setTitle(getText(R.string.translate));
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        ((InputMethodManager) this.f6977j.getSystemService("input_method")).hideSoftInputFromWindow(this.f6975h.getWindowToken(), 0);
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        m9001g();
        super.onDestroy();
        if (this.f6978k != null && this.f6978k.isShowing()) {
            this.f6978k.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8987a(boolean z) {
        this.f6986s.setEnabled(z);
    }

    /* renamed from: f */
    private boolean m8999f() {
        int iM10677a = C2471v.m10677a(this.f6977j);
        if (-3 != iM10677a && -2 != iM10677a) {
            return true;
        }
        C5179v.m19810a(CommonApplication.m18732r(), R.string.popup_no_network_connection, 0).show();
        return false;
    }

    /* renamed from: g */
    private void m9001g() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f6977j.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f6975h.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m9003a(EditText editText, boolean z) {
        editText.setCursorVisible(z);
        editText.setFocusableInTouchMode(z);
        if (z) {
            editText.requestFocus();
        } else {
            ((InputMethodManager) this.f6977j.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 2);
        }
    }
}
