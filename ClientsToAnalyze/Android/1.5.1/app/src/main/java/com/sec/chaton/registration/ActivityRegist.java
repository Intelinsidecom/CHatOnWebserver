package com.sec.chaton.registration;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.control.ContactControl;
import com.sec.chaton.control.GLDControl;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import java.util.HashMap;
import java.util.Map;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class ActivityRegist extends BaseSinglePaneActivity {

    /* renamed from: a */
    public static String f2845a;

    /* renamed from: b */
    public static String f2846b;

    /* renamed from: c */
    public static boolean f2847c;

    public class PhoneNumberAuthFragment extends Fragment {

        /* renamed from: b */
        private static AlertDialog f2848b;

        /* renamed from: e */
        private static String f2849e;

        /* renamed from: h */
        private static View f2850h;

        /* renamed from: a */
        Handler f2851a = new HandlerC0426b(this);

        /* renamed from: c */
        private ProgressDialog f2852c;

        /* renamed from: d */
        private GLDControl f2853d;

        /* renamed from: f */
        private String f2854f;

        /* renamed from: g */
        private boolean f2855g;

        /* renamed from: a */
        private AlertDialog m3070a(String str, String str2) {
            String str3;
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            if (this.f2855g) {
                str3 = ActivityRegist.f2846b + "\n" + String.format(getResources().getString(C0062R.string.settings_selfsms_alert_text), ActivityRegist.f2846b);
            } else {
                String str4 = "+" + str + str2;
                str3 = str4 + "\n" + String.format(getResources().getString(C0062R.string.settings_selfsms_alert_text), str4);
            }
            builder.setMessage(str3).setTitle(C0062R.string.setting_selfsms_alert_title).setCancelable(true).setPositiveButton(C0062R.string.dialog_approve, new DialogInterfaceOnClickListenerC0428d(this, str, str2)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0429e(this));
            return builder.create();
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                f2849e = arguments.getString("country_code");
                this.f2854f = arguments.getString("user_phone_number");
                this.f2855g = arguments.getBoolean("self_sms_auth");
                ChatONLogWriter.m3506b("mCountryCode=" + f2849e + " mPhoneNumber=" + this.f2854f + " isSelfSMSAuth=" + this.f2855g, "PhoneNumberAuthFragment");
                if (!this.f2855g) {
                    this.f2853d = new GLDControl(this.f2851a);
                }
            }
            this.f2852c = new ProgressDialog(getActivity());
            this.f2852c.setMessage(getResources().getString(C0062R.string.dialog_connecting_server));
            f2850h = getActivity().getLayoutInflater().inflate(C0062R.layout.layout_countdown, (ViewGroup) null);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(C0062R.string.please_wait);
            builder.setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0402a(this));
            builder.setOnCancelListener(new DialogInterfaceOnCancelListenerC0427c(this));
            builder.setView(f2850h);
            f2848b = builder.create();
            if (this.f2855g) {
                return;
            }
            m3070a(f2849e, this.f2854f).show();
        }
    }

    public class RegisteFragment extends Fragment implements View.OnClickListener {

        /* renamed from: a */
        PhoneNumberAuthFragment f2856a;

        /* renamed from: f */
        private Map f2861f;

        /* renamed from: g */
        private CharSequence[] f2862g;

        /* renamed from: h */
        private CharSequence[] f2863h;

        /* renamed from: i */
        private String f2864i;

        /* renamed from: j */
        private String f2865j;

        /* renamed from: k */
        private LinearLayout f2866k;

        /* renamed from: l */
        private EditText f2867l;

        /* renamed from: m */
        private TextView f2868m;

        /* renamed from: n */
        private TextView f2869n;

        /* renamed from: o */
        private Button f2870o;

        /* renamed from: p */
        private Button f2871p;

        /* renamed from: q */
        private Button f2872q;

        /* renamed from: r */
        private Button f2873r;

        /* renamed from: t */
        private Context f2875t;

        /* renamed from: w */
        private String f2878w;

        /* renamed from: b */
        final int f2857b = 16;

        /* renamed from: c */
        final int f2858c = 0;

        /* renamed from: s */
        private ProgressDialog f2874s = null;

        /* renamed from: u */
        private int f2876u = 0;

        /* renamed from: v */
        private TextWatcher f2877v = new C0425aw(this);

        /* renamed from: d */
        Handler f2859d = new HandlerC0422at(this);

        /* renamed from: e */
        Handler f2860e = new HandlerC0421as(this);

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public AlertDialog m3074a(String str, String str2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            if (str2.equals("+null")) {
                ChatONLogWriter.m3506b("Server return null , countryCode=" + str + " PhoneNumber = " + ((Object) this.f2867l.getText()), getClass().getSimpleName());
                ActivityRegist.f2846b = "+" + str + ((Object) this.f2867l.getText());
            }
            builder.setMessage(ActivityRegist.f2846b + "\n" + String.format(getResources().getString(C0062R.string.settings_selfsms_alert_text), ActivityRegist.f2846b)).setTitle(C0062R.string.setting_selfsms_alert_title).setCancelable(true).setPositiveButton(C0062R.string.dialog_approve, new DialogInterfaceOnClickListenerC0420ar(this)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0423au(this));
            return builder.create();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3077a() {
            ContactControl contactControl = new ContactControl(this.f2860e);
            String strTrim = this.f2864i != null ? this.f2864i + this.f2867l.getText().toString().trim() : this.f2867l.getText().toString().trim();
            ChatONLogWriter.m3506b("addBuddyInternal orgnum=" + strTrim + ", country code=" + this.f2864i, getClass().getSimpleName());
            contactControl.m1997b(strTrim, this.f2864i != null);
            this.f2878w = (this.f2864i != null ? "+" : "") + strTrim;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3078a(Activity activity, String str) {
            Intent intent = new Intent(activity, (Class<?>) ActivityNonSelfSMS.class);
            intent.putExtra("COUNTRY_CODE", this.f2864i);
            intent.putExtra("PHONE_NUMBER", str);
            intent.putExtra("SMS_PHONE_NUMBER", ActivityRegist.f2846b);
            intent.putExtra("MSISDN", ActivityRegist.f2845a);
            activity.startActivityForResult(intent, 32);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m3081b() {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f2867l.getWindowToken(), 0);
                }
            } catch (Exception e) {
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) throws Resources.NotFoundException {
            super.onActivityCreated(bundle);
            String strM3567d = DeviceInfoUtil.m3567d();
            if (strM3567d != null && strM3567d.length() > 0) {
                CharSequence[] textArray = getResources().getTextArray(C0062R.array.ISO_country_code_Letter2);
                CharSequence[] charSequenceArr = this.f2862g;
                int i = 0;
                while (true) {
                    if (i >= textArray.length) {
                        break;
                    }
                    if (strM3567d.equalsIgnoreCase(textArray[i].toString())) {
                        this.f2865j = String.valueOf(this.f2861f.get(charSequenceArr[i].toString()));
                        if (this.f2876u == 0) {
                            this.f2869n.setText(charSequenceArr[i].toString());
                            this.f2868m.setText(" (+" + this.f2861f.get(charSequenceArr[i].toString()) + ")");
                            this.f2864i = this.f2865j;
                        }
                    } else {
                        i++;
                    }
                }
            }
            if (strM3567d == null || strM3567d.length() <= 0 || this.f2876u != 0) {
                this.f2869n.setText(C0062R.string.layout_regist_no_country_selected);
                this.f2868m.setText("");
                this.f2864i = null;
            }
            this.f2867l.addTextChangedListener(this.f2877v);
            this.f2856a = (PhoneNumberAuthFragment) getFragmentManager().mo5a("auth");
            if (this.f2856a != null) {
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 != -1) {
            }
            switch (i) {
                case 16:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("PARAMS_COUNTRY_NAME");
                    if (string == null) {
                        String string2 = extras.getString("PARAMS_COUNTRY_CODE");
                        this.f2869n.setText("");
                        this.f2864i = string2;
                        this.f2868m.setText(" (+" + string2 + ")");
                        break;
                    } else {
                        this.f2864i = String.valueOf(this.f2861f.get(string));
                        this.f2868m.setText(" (+" + this.f2861f.get(string) + ")");
                        this.f2869n.setText(string);
                        this.f2869n.setTextSize(16.0f);
                        break;
                    }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case C0062R.id.btnCancel /* 2131427489 */:
                    this.f2867l.setText("");
                    break;
                case C0062R.id.btnSelfSMS /* 2131427915 */:
                    if (this.f2867l.getText().length() > 0) {
                        if (this.f2876u != 1) {
                            if (((TelephonyManager) getActivity().getSystemService("phone")).getSimState() == 5 || DeviceInfoUtil.m3569f().booleanValue()) {
                                ActivityRegist.f2847c = true;
                            } else {
                                ActivityRegist.f2847c = false;
                            }
                        }
                        if (this.f2876u != 1) {
                            ChatONLogWriter.m3506b("mCountryCallingCode=" + this.f2864i + " userPhoneNumber=" + this.f2867l.getText().toString(), getClass().getSimpleName());
                            GLDControl gLDControl = new GLDControl(this.f2859d);
                            this.f2874s = ProgressDialog.show(this.f2875t, null, getResources().getString(C0062R.string.dialog_provision_ing), true);
                            gLDControl.m2001a(this.f2864i, this.f2867l.getText().toString());
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("self_sms_auth", true);
                            bundle.putString("country_code", this.f2864i);
                            bundle.putString("user_phone_number", this.f2867l.getText().toString());
                            this.f2856a = new PhoneNumberAuthFragment();
                            this.f2856a.setTargetFragment(this, 0);
                            this.f2856a.setArguments(bundle);
                            getFragmentManager().mo6a().mo14a(this.f2856a, "auth").mo10a();
                            ChatONPref.m3523a("country_name", this.f2869n.getText().toString());
                            break;
                        } else {
                            this.f2874s = ProgressDialog.show(this.f2875t, null, getResources().getString(C0062R.string.buddy_list_progress_dialog_message), true);
                            m3077a();
                            break;
                        }
                    } else {
                        Toast.makeText(getActivity(), C0062R.string.setting_toast_enter_phone_number, 1).show();
                        this.f2871p.setEnabled(false);
                        break;
                    }
                    break;
                case C0062R.id.btnGenerateIMEI /* 2131427916 */:
                    ProvisioningManager.m3008j(getActivity());
                    Toast.makeText(getActivity(), "Random device id is generated.", 1).show();
                    break;
                case C0062R.id.btnNSS /* 2131427917 */:
                    m3078a(getActivity(), this.f2867l.getText().toString());
                    break;
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f2875t = getActivity();
            ChatONLogWriter.m3506b("onCreate..............", getClass().getSimpleName());
            this.f2874s = new ProgressDialog(getActivity());
            this.f2861f = new HashMap();
            this.f2862g = getResources().getTextArray(C0062R.array.country);
            this.f2863h = getResources().getTextArray(C0062R.array.country_code);
            for (int i = 0; i < this.f2862g.length; i++) {
                this.f2861f.put(this.f2862g[i], this.f2863h[i]);
            }
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            ChatONLogWriter.m3506b("onCreateView..............", getClass().getSimpleName());
            View viewInflate = layoutInflater.inflate(C0062R.layout.layout_regist, viewGroup, false);
            this.f2866k = (LinearLayout) viewInflate.findViewById(C0062R.id.newSearch);
            this.f2868m = (TextView) viewInflate.findViewById(C0062R.id.editCountryCode);
            this.f2869n = (TextView) viewInflate.findViewById(C0062R.id.editCountryName);
            this.f2867l = (EditText) viewInflate.findViewById(C0062R.id.editPno);
            this.f2870o = (Button) viewInflate.findViewById(C0062R.id.btnCancel);
            this.f2871p = (Button) viewInflate.findViewById(C0062R.id.btnSelfSMS);
            this.f2872q = (Button) viewInflate.findViewById(C0062R.id.btnGenerateIMEI);
            this.f2873r = (Button) viewInflate.findViewById(C0062R.id.btnNSS);
            this.f2866k.setOnClickListener(new ViewOnClickListenerC0419aq(this));
            this.f2870o.setOnClickListener(this);
            this.f2871p.setOnClickListener(this);
            this.f2872q.setOnClickListener(this);
            this.f2873r.setOnClickListener(this);
            if (getActivity().getIntent() != null) {
                this.f2876u = getActivity().getIntent().getIntExtra(RtspHeaders.Values.MODE, 0);
            }
            if (this.f2876u == 1) {
                ((TextView) viewInflate.findViewById(C0062R.id.txt_title)).setText(C0062R.string.buddy_list_dialog_addbuddy_title);
                ((TextView) viewInflate.findViewById(C0062R.id.txtRegist_1)).setText(C0062R.string.buddy_list_dialog_addbuddy_hint);
                ((TextView) viewInflate.findViewById(C0062R.id.txt_select_country)).setText(C0062R.string.layout_regist_select_country_code_if_differs);
            }
            if (this.f2876u == 0) {
                ChatONLogWriter.m3495a();
                viewInflate.findViewById(C0062R.id.txt_title).setOnClickListener(new ViewOnClickListenerC0424av(this));
            }
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.f2867l.getText().length() > 0) {
                this.f2871p.setEnabled(true);
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 32 && i2 == -1) {
            setResult(-1, new Intent());
            finish();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    protected Fragment onCreatePane() {
        return new RegisteFragment();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
