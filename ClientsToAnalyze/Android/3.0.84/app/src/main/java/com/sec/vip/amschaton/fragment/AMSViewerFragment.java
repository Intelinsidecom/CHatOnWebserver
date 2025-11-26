package com.sec.vip.amschaton.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.renren.android.feed.FeedPublishRequestParam;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.C3402ad;
import com.sec.vip.amschaton.C3584q;
import com.sec.vip.amschaton.DialogC3435bj;
import com.sec.vip.amschaton.InterfaceC3444bs;
import com.sec.vip.amschaton.RunnableC3442bq;
import com.sec.vip.amschaton.p071a.C3398f;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class AMSViewerFragment extends AMSFragment {

    /* renamed from: A */
    protected ImageView f12768A;

    /* renamed from: B */
    protected View f12769B;

    /* renamed from: C */
    protected View f12770C;

    /* renamed from: D */
    protected View f12771D;

    /* renamed from: E */
    protected View f12772E;

    /* renamed from: a */
    protected int f12794a;

    /* renamed from: m */
    protected String f12797m;

    /* renamed from: n */
    protected int f12798n;

    /* renamed from: o */
    protected int f12799o;

    /* renamed from: p */
    protected boolean f12800p;

    /* renamed from: q */
    protected boolean f12801q;

    /* renamed from: r */
    protected long f12802r;

    /* renamed from: s */
    protected boolean f12803s;

    /* renamed from: t */
    protected long f12804t;

    /* renamed from: u */
    protected boolean f12805u;

    /* renamed from: v */
    protected boolean f12806v;

    /* renamed from: w */
    protected boolean f12807w;

    /* renamed from: x */
    protected String f12808x;

    /* renamed from: y */
    protected DateFormat f12809y;

    /* renamed from: b */
    protected RunnableC3442bq f12795b = null;

    /* renamed from: c */
    protected LinearLayout f12796c = null;

    /* renamed from: S */
    private boolean f12786S = false;

    /* renamed from: T */
    private boolean f12787T = false;

    /* renamed from: z */
    protected SeekBar f12810z = null;

    /* renamed from: F */
    protected RelativeLayout f12773F = null;

    /* renamed from: G */
    protected LinearLayout f12774G = null;

    /* renamed from: H */
    protected LinearLayout f12775H = null;

    /* renamed from: I */
    protected LinearLayout f12776I = null;

    /* renamed from: J */
    protected RelativeLayout f12777J = null;

    /* renamed from: K */
    protected TextView f12778K = null;

    /* renamed from: L */
    protected ImageView f12779L = null;

    /* renamed from: U */
    private boolean f12788U = true;

    /* renamed from: M */
    protected boolean f12780M = false;

    /* renamed from: N */
    protected boolean f12781N = true;

    /* renamed from: V */
    private boolean f12789V = false;

    /* renamed from: W */
    private boolean f12790W = false;

    /* renamed from: O */
    protected boolean f12782O = false;

    /* renamed from: P */
    protected RelativeLayout f12783P = null;

    /* renamed from: X */
    private Handler f12791X = new Handler();

    /* renamed from: Y */
    private InterfaceC3444bs f12792Y = new C3544dk(this);

    /* renamed from: Q */
    protected View.OnClickListener f12784Q = new ViewOnClickListenerC3551dr(this);

    /* renamed from: Z */
    private Runnable f12793Z = new RunnableC3538de(this);

    /* renamed from: R */
    protected View.OnClickListener f12785R = new ViewOnClickListenerC3539df(this);

    /* renamed from: a */
    protected abstract View mo12582a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* renamed from: a */
    protected abstract boolean mo12583a(View view);

    @Override // com.sec.vip.amschaton.fragment.AMSFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11453c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12797m = arguments.getString("AMS_FILE_PATH");
            this.f12798n = arguments.getInt("VIEWER_MODE", 1002);
            this.f12799o = arguments.getInt("AMS_FILE_TYPE", 2001);
            this.f12800p = arguments.getBoolean("AMS_DIRECT_PLAY", true);
            this.f12801q = arguments.getBoolean("AMS_SAVE_FLAG", false);
            this.f12803s = arguments.getBoolean("AMS_DOWNLOAD_PREVIEW", false);
            this.f12802r = arguments.getLong("AMS_FILE_SIZE", 0L);
            this.f12804t = arguments.getLong("AMS_EXPIRATION_DATE", 0L);
            this.f12805u = arguments.getBoolean("AMS_IS_FAILED_ITEM", false);
            this.f12807w = arguments.getBoolean("AMS_FROM_DOWNLOADS", false);
            this.f12808x = arguments.getString("AMS_ITEM_ID");
        } else {
            C3250y.m11450b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f12797m = "";
        }
        this.f12806v = false;
        this.f12809y = android.text.format.DateFormat.getMediumDateFormat(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalStateException {
        View viewMo12582a = mo12582a(layoutInflater, viewGroup);
        if (!m12684h(this.f12781N)) {
            return null;
        }
        this.f12787T = mo12583a(viewMo12582a);
        m12682h();
        m12663b(this.f12798n);
        m12686i();
        m12665b(this.f12797m);
        return viewMo12582a;
    }

    /* renamed from: a */
    protected void m12696a(int i, boolean z) {
        if (this.f12781N) {
            switch (i) {
                case R.id.btn_edit /* 2131165470 */:
                    this.f12771D.setEnabled(z);
                    break;
                case R.id.btn_delete /* 2131165818 */:
                    this.f12770C.setEnabled(z);
                    break;
                case R.id.btn_send /* 2131165819 */:
                    this.f12772E.setEnabled(z);
                    break;
            }
        }
    }

    /* renamed from: b */
    private void m12665b(String str) throws IllegalStateException {
        if (this.f12795b == null) {
            C3250y.m11450b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        this.f12780M = this.f12795b.m12329a(str, false);
        if (this instanceof AMSPreviewFragment) {
            m12696a(R.id.btn_edit, true);
        }
        if (this.f12780M) {
            ((AMSDrawManager) this.f12795b.m12337h()).setBitmapForAMS(null);
            m12679f(true);
            this.f12810z.setMax(RunnableC3442bq.f12592a);
            this.f12810z.setProgress(0);
            if (this.f12800p) {
                m12689k();
                m12700b(false);
                if (!this.f12781N) {
                    m12698a(false);
                    return;
                }
                return;
            }
            this.f12795b.m12327a(true);
            m12695a();
            m12675e(false);
            if (!this.f12781N && !this.f12789V) {
                m12671d(true);
                return;
            }
            return;
        }
        m12679f(true);
        ((AMSDrawManager) this.f12795b.m12337h()).setBitmapForAMS(str);
        m12690l();
        if (!this.f12781N && !this.f12789V) {
            m12671d(true);
        }
    }

    /* renamed from: a */
    protected void m12695a() {
        if (this.f12795b == null) {
            C3250y.m11450b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        if ((this.f12795b.m12336g() & 1) == 1) {
            ((ImageView) this.f12769B).setImageResource(R.drawable.ams_btn_preview_pause);
        } else {
            ((ImageView) this.f12769B).setImageResource(R.drawable.ams_btn_ic_play_preview);
        }
        if (getActivity() != null) {
            getActivity().supportInvalidateOptionsMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12671d(boolean z) {
    }

    /* renamed from: a */
    protected void m12698a(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12675e(boolean z) {
        this.f12783P.setVisibility(0);
    }

    /* renamed from: b */
    protected void m12700b(boolean z) {
        this.f12783P.setVisibility(8);
    }

    /* renamed from: f */
    private void m12679f(boolean z) {
        this.f12796c.setOnClickListener(z ? this.f12784Q : null);
        m12681g(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12681g(boolean z) {
        if (this.f12796c != null) {
            this.f12796c.setEnabled(z);
        }
    }

    /* renamed from: h */
    private void m12682h() {
        if (this.f12795b == null) {
            C3250y.m11450b("mViewer is null!", getClass().getSimpleName());
        } else {
            this.f12795b.m12326a(this.f12792Y);
            this.f12795b.m12325a(new C3537dd(this));
        }
    }

    /* renamed from: c */
    protected void m12702c(boolean z) {
        this.f12810z.setVisibility(z ? 0 : 4);
    }

    /* renamed from: h */
    private boolean m12684h(boolean z) {
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        if (width >= height) {
            width = height;
        }
        this.f12794a = width;
        C3250y.m11453c("[createViewer] mViewerSize = " + this.f12794a, getClass().getSimpleName());
        this.f12795b = new RunnableC3442bq(getActivity());
        if (this.f12795b.m12328a(this.f12794a)) {
            return m12701b();
        }
        this.f12795b = null;
        return false;
    }

    /* renamed from: b */
    protected boolean m12701b() {
        if (this.f12796c != null) {
            this.f12796c.removeAllViews();
            this.f12796c = null;
        }
        this.f12796c = new LinearLayout(getActivity());
        this.f12796c.setLayoutParams(new ViewGroup.LayoutParams(this.f12794a, this.f12794a));
        if (this.f12795b == null) {
            return false;
        }
        this.f12796c.addView(this.f12795b.m12337h());
        return true;
    }

    /* renamed from: b */
    private void m12663b(int i) {
    }

    /* renamed from: i */
    private void m12686i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m12688j() {
    }

    /* renamed from: e */
    protected void m12703e() throws IllegalStateException {
        if (this.f12795b == null) {
            C3250y.m11450b("mViewer is null!", getClass().getSimpleName());
        } else {
            this.f12795b.m12332c();
            m12695a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m12689k() throws IllegalStateException {
        if (this.f12795b == null) {
            C3250y.m11450b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        boolean zM12038s = ((AMSDrawManager) this.f12795b.m12337h()).m12038s();
        if (this.f12788U && !zM12038s) {
            this.f12790W = false;
            Dialog dialog = new Dialog(getActivity(), R.style.AppTheme_Dialog_Alert);
            dialog.getWindow().requestFeature(1);
            dialog.setContentView(R.layout.ams_ics_layout_attention_dialog);
            CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.checkbox_never_show_again);
            checkBox.setOnClickListener(new ViewOnClickListenerC3545dl(this));
            checkBox.setOnCheckedChangeListener(new C3546dm(this));
            dialog.findViewById(R.id.text_never_show_again).setOnClickListener(new ViewOnClickListenerC3547dn(this));
            dialog.findViewById(R.id.text_never_show_again).setOnTouchListener(new ViewOnTouchListenerC3548do(this, checkBox));
            ((Button) dialog.findViewById(R.id.btn_ok)).setOnClickListener(new ViewOnClickListenerC3549dp(this, dialog));
            dialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC3550dq(this));
            dialog.show();
            return;
        }
        this.f12795b.m12330b();
        m12695a();
    }

    /* renamed from: a */
    protected void m12697a(String str, String str2, int i) {
        this.f12799o = 2002;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(AMSActivity.f12269b)) {
                this.f12799o = 2000;
            } else if (str.startsWith(AMSActivity.f12270c)) {
                this.f12799o = 2001;
            }
        }
        m12526a(str, str2, this.f12799o, i);
    }

    /* renamed from: l */
    private void m12690l() {
        if (this instanceof AMSPreviewFragment) {
            m12696a(R.id.btn_edit, false);
            m12696a(R.id.btn_delete, false);
            m12696a(R.id.btn_send, false);
        }
        this.f12769B.setEnabled(false);
        ((ImageView) this.f12769B).setImageResource(R.drawable.ams_btn_ic_play_preview);
        this.f12783P.setVisibility(8);
    }

    /* renamed from: a */
    protected boolean m12699a(String str) {
        m12669c(str);
        return C3584q.m12778a().m12802a(str);
    }

    /* renamed from: f */
    protected String m12704f() {
        String str = AMSActivity.f12270c + this.f12797m.substring(this.f12797m.lastIndexOf(47) + 1);
        C3250y.m11450b("targetPath     : " + str, getClass().getSimpleName());
        C3250y.m11450b("mTargetFilePath: " + this.f12797m, getClass().getSimpleName());
        File file = new File(str);
        if (file != null && file.exists()) {
            m12524a(R.string.ams_msg_already_saved);
        } else if (("/" + str).equals(this.f12797m)) {
            m12691m();
        } else if (m12662a(this.f12797m, str)) {
            return str;
        }
        return null;
    }

    /* renamed from: g */
    protected void m12705g() throws IllegalStateException {
        if (this.f12795b == null) {
            C3250y.m11450b("mViewer is null!", getClass().getSimpleName());
            return;
        }
        if (this.f12797m == null) {
            this.f12786S = false;
            return;
        }
        String str = null;
        if (this instanceof AMSPlayerFragment) {
            this.f12795b.m12327a(true);
            str = this.f12797m;
        } else if (this instanceof AMSPreviewFragment) {
            C3402ad c3402ad = new C3402ad(getActivity());
            c3402ad.m12171a(0, R.string.ams_send_as_animation, true);
            c3402ad.m12171a(1, R.string.ams_send_as_image, true);
            c3402ad.m12171a(2, R.string.ams_save_and_exit, true);
            c3402ad.m12170a(new C3540dg(this));
            c3402ad.m12172b();
        }
        if (str == null) {
            this.f12786S = false;
        } else {
            m12697a(str, "", 1);
        }
    }

    /* renamed from: c */
    private void m12669c(String str) {
        if (str != null) {
            C3398f c3398f = new C3398f(getActivity());
            c3398f.m12126b();
            c3398f.m12127b(str);
            c3398f.mo12098a();
        }
    }

    /* renamed from: m */
    private boolean m12691m() {
        DialogC3435bj dialogC3435bj = new DialogC3435bj(getActivity(), R.style.AppTheme_Dialog_Alert, 64);
        dialogC3435bj.m12301a(m12657a("A", System.currentTimeMillis(), ""));
        dialogC3435bj.m12303b("\\/:*?\"<>|");
        dialogC3435bj.m12300a(new C3541dh(this, dialogC3435bj));
        dialogC3435bj.show();
        m12658a(dialogC3435bj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m12662a(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.fragment.AMSViewerFragment.m12662a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public String m12685i(boolean z) {
        String str = this.f12797m;
        if (!m12673d(str)) {
            m12524a(R.string.ams_error_ams_file_save);
            return null;
        }
        File file = new File(str);
        if (file.length() < 1048576 || !z) {
            return str;
        }
        file.delete();
        AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_btn_send).mo11509b(String.format("%s\n(%d/%d)", getResources().getString(R.string.ams_msg_exceed_limit), Long.valueOf(file.length()), Integer.valueOf(FeedPublishRequestParam.MESSAGE_TOO_LONG))).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3542di(this)).mo11505a().show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0055 -> B:51:0x0056). Please report as a decompilation issue!!! */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m12692n() throws java.lang.Throwable {
        /*
            r8 = this;
            r2 = 0
            r7 = 480(0x1e0, float:6.73E-43)
            com.sec.vip.amschaton.bq r0 = r8.f12795b
            android.view.View r0 = r0.m12337h()
            com.sec.vip.amschaton.AMSDrawManager r0 = (com.sec.vip.amschaton.AMSDrawManager) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = com.sec.vip.amschaton.AMSActivity.f12271d
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r3 = "I"
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = ".jpg"
            java.lang.String r3 = r8.m12657a(r3, r4, r6)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            boolean r3 = r0.m12026g()
            if (r3 == 0) goto L66
            android.graphics.Bitmap r0 = r0.m12025f()
            if (r0 == 0) goto L80
            r3 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r0, r7, r7, r3)
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.io.FileNotFoundException -> L57 java.io.IOException -> L6e java.lang.Throwable -> L8e
            r3.<init>(r1)     // Catch: java.io.FileNotFoundException -> L57 java.io.IOException -> L6e java.lang.Throwable -> L8e
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L98 java.io.IOException -> L9a java.io.FileNotFoundException -> L9c
            r5 = 80
            r0.compress(r4, r5, r3)     // Catch: java.lang.Throwable -> L98 java.io.IOException -> L9a java.io.FileNotFoundException -> L9c
            r0.recycle()     // Catch: java.lang.Throwable -> L98 java.io.IOException -> L9a java.io.FileNotFoundException -> L9c
            r3.flush()     // Catch: java.lang.Throwable -> L98 java.io.IOException -> L9a java.io.FileNotFoundException -> L9c
            r3.close()     // Catch: java.lang.Throwable -> L98 java.io.IOException -> L9a java.io.FileNotFoundException -> L9c
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.io.IOException -> L96
        L55:
            r0 = r1
        L56:
            return r0
        L57:
            r0 = move-exception
            r3 = r2
        L59:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L98
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.io.IOException -> L62
            goto L55
        L62:
            r0 = move-exception
        L63:
            r0.printStackTrace()
        L66:
            r0 = 2131427562(0x7f0b00ea, float:1.8476744E38)
            r8.m12524a(r0)
            r0 = r2
            goto L56
        L6e:
            r0 = move-exception
            r3 = r2
        L70:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L98
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.io.IOException -> L79
            goto L55
        L79:
            r0 = move-exception
            goto L63
        L7b:
            r1 = move-exception
            r1.printStackTrace()
        L7f:
            throw r0
        L80:
            java.lang.String r0 = "Bitmap main is null"
            java.lang.Class r1 = r8.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.C3250y.m11442a(r0, r1)
            goto L66
        L8e:
            r0 = move-exception
            r3 = r2
        L90:
            if (r3 == 0) goto L7f
            r3.close()     // Catch: java.io.IOException -> L7b
            goto L55
        L96:
            r0 = move-exception
            goto L63
        L98:
            r0 = move-exception
            goto L90
        L9a:
            r0 = move-exception
            goto L70
        L9c:
            r0 = move-exception
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.fragment.AMSViewerFragment.m12692n():java.lang.String");
    }

    /* renamed from: a */
    private String m12657a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m12693o() {
        String str = AMSActivity.f12270c + m12657a("A", System.currentTimeMillis(), "") + ".jpg";
        if (!m12673d(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            m12524a(R.string.ams_error_ams_file_save);
            return;
        }
        m12524a(R.string.ams_msg_saved);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m12694p() {
        Intent intent = new Intent(getActivity(), (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2006);
        startActivity(intent);
        getActivity().finish();
    }

    /* renamed from: a */
    private void m12658a(DialogC3435bj dialogC3435bj) {
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(dialogC3435bj.m12302b(), 2);
        dialogC3435bj.m12302b().setOnFocusChangeListener(new ViewOnFocusChangeListenerC3543dj(this, dialogC3435bj));
    }

    /* renamed from: d */
    private boolean m12673d(String str) {
        if (this.f12795b == null) {
            return false;
        }
        AMSDrawManager aMSDrawManager = (AMSDrawManager) this.f12795b.m12337h();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (aMSDrawManager.m12014a(str, displayMetrics)) {
            return C3584q.m12778a().m12797a(getActivity(), str, 1001);
        }
        return false;
    }
}
