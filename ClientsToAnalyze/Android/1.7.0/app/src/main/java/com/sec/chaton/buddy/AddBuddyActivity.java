package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p033io.entry.GetBuddyList;
import com.sec.chaton.p033io.entry.inner.Buddy;
import com.sec.chaton.registration.CountryActivity;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1346u;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.GeneralHeaderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class AddBuddyActivity extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new AddBuddyFragment();
    }

    public class AddBuddyFragment extends Fragment implements View.OnClickListener {

        /* renamed from: A */
        private String[] f1058A;

        /* renamed from: B */
        private String f1059B;

        /* renamed from: c */
        private Map f1064c;

        /* renamed from: d */
        private Map f1065d;

        /* renamed from: e */
        private CharSequence[] f1066e;

        /* renamed from: f */
        private CharSequence[] f1067f;

        /* renamed from: g */
        private CharSequence[] f1068g;

        /* renamed from: h */
        private String f1069h;

        /* renamed from: i */
        private EditText f1070i;

        /* renamed from: j */
        private TextView f1071j;

        /* renamed from: k */
        private TextView f1072k;

        /* renamed from: l */
        private EditText f1073l;

        /* renamed from: n */
        private ImageButton f1075n;

        /* renamed from: o */
        private ImageButton f1076o;

        /* renamed from: p */
        private ImageButton f1077p;

        /* renamed from: q */
        private View f1078q;

        /* renamed from: r */
        private View f1079r;

        /* renamed from: s */
        private View f1080s;

        /* renamed from: t */
        private ViewGroup f1081t;

        /* renamed from: u */
        private ViewGroup f1082u;

        /* renamed from: v */
        private ViewGroup f1083v;

        /* renamed from: w */
        private TextView f1084w;

        /* renamed from: x */
        private TextView f1085x;

        /* renamed from: y */
        private TextView f1086y;

        /* renamed from: z */
        private GeneralHeaderView f1087z;

        /* renamed from: a */
        final int f1062a = 16;

        /* renamed from: m */
        private ProgressDialog f1074m = null;

        /* renamed from: b */
        Handler f1063b = new HandlerC0416bx(this);

        /* renamed from: C */
        private TextWatcher f1060C = new C0417by(this);

        /* renamed from: D */
        private TextWatcher f1061D = new C0418bz(this);

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            C1341p.m4658b("onCreate..." + getArguments().get("id"), getClass().getSimpleName());
            if (getArguments().get("id") instanceof String) {
                this.f1058A = new String[]{getArguments().getString("id")};
            } else if (getArguments().get("id") instanceof String[]) {
                this.f1058A = getArguments().getStringArray("id");
            }
            this.f1074m = new ProgressDialogC1354a(getActivity(), false);
            this.f1074m.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
            this.f1064c = new HashMap();
            this.f1065d = new HashMap();
            this.f1066e = getResources().getTextArray(R.array.country);
            this.f1067f = getResources().getTextArray(R.array.country_code);
            this.f1068g = getResources().getTextArray(R.array.ISO_country_code_Letter2);
            for (int i = 0; i < this.f1066e.length; i++) {
                this.f1064c.put(this.f1066e[i], this.f1067f[i]);
                this.f1065d.put(this.f1068g[i], this.f1066e[i]);
            }
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            C1341p.m4658b("onCreateView...", getClass().getSimpleName());
            View viewInflate = layoutInflater.inflate(R.layout.layout_add_buddy, viewGroup, false);
            this.f1087z = (GeneralHeaderView) viewInflate.findViewById(R.id.headerView);
            this.f1087z.findViewById(R.id.header_button1).setVisibility(4);
            this.f1087z.findViewById(R.id.header_separator_right).setVisibility(4);
            this.f1071j = (TextView) viewInflate.findViewById(R.id.editCountryCode);
            this.f1072k = (TextView) viewInflate.findViewById(R.id.editCountryName);
            this.f1070i = (EditText) viewInflate.findViewById(R.id.editPno);
            this.f1073l = (EditText) viewInflate.findViewById(R.id.editId);
            this.f1070i.addTextChangedListener(this.f1060C);
            this.f1073l.addTextChangedListener(this.f1061D);
            this.f1070i.setOnEditorActionListener(new C0411bs(this));
            this.f1070i.setOnKeyListener(new ViewOnKeyListenerC0410br(this));
            this.f1073l.setOnEditorActionListener(new C0409bq(this));
            this.f1073l.setOnKeyListener(new ViewOnKeyListenerC0405bm(this));
            viewInflate.findViewById(R.id.pickCountry).setOnClickListener(this);
            this.f1075n = (ImageButton) viewInflate.findViewById(R.id.tabAddBuddyByPhone);
            this.f1076o = (ImageButton) viewInflate.findViewById(R.id.tabAddBuddyById);
            this.f1075n.setOnClickListener(this);
            this.f1075n.setOnTouchListener(new ViewOnTouchListenerC0406bn(this));
            this.f1076o.setOnClickListener(this);
            this.f1076o.setOnTouchListener(new ViewOnTouchListenerC0407bo(this));
            this.f1078q = viewInflate.findViewById(R.id.layoutAddBuddyByPhone);
            this.f1079r = viewInflate.findViewById(R.id.layoutAddBuddyById);
            this.f1081t = (ViewGroup) viewInflate.findViewById(R.id.layoutResultByPhone);
            this.f1082u = (ViewGroup) viewInflate.findViewById(R.id.layoutResultById);
            this.f1084w = (TextView) viewInflate.findViewById(R.id.selectCountryCodeIfDiffers);
            this.f1085x = (TextView) viewInflate.findViewById(R.id.enterPhoneNumber);
            this.f1086y = (TextView) viewInflate.findViewById(R.id.enterSamsungAccountID);
            this.f1084w.setOnTouchListener(new ViewOnTouchListenerC0408bp(this));
            this.f1085x.setOnTouchListener(new ViewOnTouchListenerC0403bk(this));
            this.f1086y.setOnTouchListener(new ViewOnTouchListenerC0404bl(this));
            if (this.f1076o.getId() == (bundle != null ? bundle.getInt("current_tab") : 0)) {
                m2066a(this.f1076o);
            } else {
                m2066a(this.f1075n);
            }
            if (this.f1058A != null) {
                viewInflate.findViewById(R.id.tabAddBuddyContainer).setVisibility(8);
                viewInflate.findViewById(R.id.inputCountryAndNumberContainer).setVisibility(8);
                m2070a(true);
            }
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("current_tab", m2064a());
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                switch (i) {
                    case 16:
                        Bundle extras = intent.getExtras();
                        String string = extras.getString("PARAMS_COUNTRY_NAME");
                        if (string != null) {
                            String strValueOf = String.valueOf(this.f1065d.get(string));
                            this.f1069h = String.valueOf(this.f1064c.get(strValueOf));
                            if (strValueOf.length() > 21 && strValueOf.length() <= 28) {
                                this.f1072k.setTextSize(18.0f);
                                this.f1071j.setTextSize(18.0f);
                            } else if (strValueOf.length() > 29) {
                                this.f1072k.setTextSize(14.0f);
                                this.f1071j.setTextSize(14.0f);
                            } else {
                                this.f1072k.setTextSize(21.0f);
                                this.f1071j.setTextSize(21.0f);
                            }
                            this.f1071j.setText(" (+" + this.f1069h + ")");
                            this.f1072k.setText(strValueOf);
                            C1341p.m4658b("[addBuddy] mCountryCallingCode : " + this.f1069h + " selectedCountryName : " + strValueOf, getClass().getSimpleName());
                            break;
                        } else {
                            String string2 = extras.getString("PARAMS_COUNTRY_CODE");
                            this.f1072k.setText("");
                            this.f1069h = string2;
                            this.f1071j.setText(" (+" + string2 + ")");
                            break;
                        }
                        break;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m2070a(boolean z) {
            this.f1083v.setVisibility(8);
            if (this.f1058A == null) {
                if (m2064a() == R.id.tabAddBuddyByPhone) {
                    m2073b(z);
                    return;
                } else {
                    m2075c(z);
                    return;
                }
            }
            m2076d(z);
        }

        /* renamed from: b */
        private void m2073b(boolean z) {
            String strTrim;
            if (z && TextUtils.isEmpty(this.f1070i.getText())) {
                C1341p.m4658b("EditText Phone is empty", getClass().getSimpleName());
                return;
            }
            this.f1074m.show();
            C0202ao c0202ao = new C0202ao(this.f1063b);
            if (this.f1069h != null) {
                strTrim = this.f1069h + this.f1070i.getText().toString().trim();
            } else {
                strTrim = this.f1070i.getText().toString().trim();
            }
            C1341p.m4658b("addBuddyInternalByPhone orgnum=" + strTrim + ", country code=" + this.f1069h, getClass().getSimpleName());
            this.f1059B = (this.f1069h != null ? "+" : "") + strTrim;
            if (z) {
                c0202ao.m767c(strTrim, this.f1069h != null);
            } else {
                c0202ao.m765b(strTrim, this.f1069h != null);
            }
        }

        /* renamed from: c */
        private void m2075c(boolean z) {
            if (z && TextUtils.isEmpty(this.f1073l.getText())) {
                C1341p.m4658b("EditText Id is empty", getClass().getSimpleName());
                return;
            }
            this.f1074m.show();
            String strTrim = this.f1073l.getText().toString().trim();
            C0202ao c0202ao = new C0202ao(this.f1063b);
            C1341p.m4658b("addBuddyInternalById orgnum=" + strTrim, getClass().getSimpleName());
            this.f1059B = strTrim;
            if (z) {
                c0202ao.m767c(strTrim, false);
            } else {
                c0202ao.m765b(strTrim, false);
            }
        }

        /* renamed from: d */
        private void m2076d(boolean z) {
            this.f1074m.show();
            String str = this.f1058A[0];
            C0202ao c0202ao = new C0202ao(this.f1063b);
            C1341p.m4658b("addBuddyInternalFromIntent orgnum=" + str + ", country code=" + this.f1069h, getClass().getSimpleName());
            this.f1059B = str;
            if (z) {
                c0202ao.m767c(str, this.f1069h != null);
            } else {
                c0202ao.m765b(str, this.f1069h != null);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!C1346u.m4676a()) {
                switch (view.getId()) {
                    case R.id.btnCancel /* 2131427469 */:
                        this.f1070i.setText("");
                        break;
                    case R.id.listItemButton /* 2131427799 */:
                        m2070a(false);
                        break;
                    case R.id.tabAddBuddyByPhone /* 2131427825 */:
                        m2066a(view);
                        break;
                    case R.id.tabAddBuddyById /* 2131427826 */:
                        this.f1073l.requestFocus();
                        m2066a(view);
                        break;
                    case R.id.pickCountry /* 2131427830 */:
                        startActivityForResult(new Intent(getActivity(), (Class<?>) CountryActivity.class), 16);
                        break;
                }
            }
        }

        /* renamed from: a */
        private int m2064a() {
            if (this.f1075n.isSelected()) {
                return this.f1075n.getId();
            }
            if (this.f1076o.isSelected()) {
                return this.f1076o.getId();
            }
            return 0;
        }

        /* renamed from: a */
        private void m2066a(View view) {
            if (this.f1080s != null) {
                this.f1080s.setVisibility(8);
            }
            if (this.f1077p != null) {
                this.f1077p.setSelected(false);
            }
            if (view.getId() == this.f1075n.getId()) {
                this.f1077p = this.f1075n;
                this.f1080s = this.f1078q;
                this.f1083v = this.f1081t;
            } else {
                this.f1077p = this.f1076o;
                this.f1080s = this.f1079r;
                this.f1083v = this.f1082u;
            }
            this.f1077p.setSelected(true);
            this.f1080s.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m2069a(GetBuddyList getBuddyList) {
            this.f1083v.removeAllViews();
            if (getBuddyList != null && getBuddyList.buddy.size() > 0) {
                ((TextView) getActivity().getLayoutInflater().inflate(R.layout.add_buddy_result_header, this.f1083v, true).findViewById(R.id.subTitleResult)).setOnTouchListener(new ViewOnTouchListenerC0413bu(this));
                Iterator it = getBuddyList.buddy.iterator();
                while (it.hasNext()) {
                    Buddy buddy = (Buddy) it.next();
                    View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.list_item_add_buddy, this.f1083v, false);
                    C1348w.m4685a(getActivity()).m4699a((ImageView) viewInflate.findViewById(R.id.listItemImage), buddy.value);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.listItemText1);
                    textView.setText(buddy.name);
                    textView.setOnTouchListener(new ViewOnTouchListenerC0414bv(this, buddy));
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.listItemButton);
                    imageView.setOnClickListener(this);
                    imageView.setOnTouchListener(new ViewOnTouchListenerC0415bw(this));
                    this.f1083v.addView(viewInflate);
                }
            }
            this.f1083v.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m2071b() {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f1070i.getWindowToken(), 0);
                }
            } catch (Exception e) {
            }
        }
    }
}
