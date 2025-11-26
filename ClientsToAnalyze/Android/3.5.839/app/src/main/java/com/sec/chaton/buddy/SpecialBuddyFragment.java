package com.sec.chaton.buddy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1107d;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class SpecialBuddyFragment extends Fragment {

    /* renamed from: A */
    private TextView f4122A;

    /* renamed from: B */
    private ImageButton f4123B;

    /* renamed from: C */
    private ImageButton f4124C;

    /* renamed from: D */
    private ImageButton f4125D;

    /* renamed from: E */
    private ImageButton f4126E;

    /* renamed from: F */
    private ImageButton f4127F;

    /* renamed from: G */
    private MenuItem f4128G;

    /* renamed from: H */
    private MenuItem f4129H;

    /* renamed from: I */
    private String f4130I;

    /* renamed from: J */
    private String f4131J;

    /* renamed from: S */
    private boolean f4140S;

    /* renamed from: e */
    private C2210x f4146e;

    /* renamed from: f */
    private ExecutorService f4147f;

    /* renamed from: g */
    private C1107d f4148g;

    /* renamed from: h */
    private ProgressDialog f4149h;

    /* renamed from: i */
    private Toast f4150i;

    /* renamed from: j */
    private Activity f4151j;

    /* renamed from: k */
    private LinearLayout f4152k;

    /* renamed from: l */
    private LinearLayout f4153l;

    /* renamed from: m */
    private View f4154m;

    /* renamed from: n */
    private View f4155n;

    /* renamed from: o */
    private View f4156o;

    /* renamed from: p */
    private View f4157p;

    /* renamed from: q */
    private ViewGroup f4158q;

    /* renamed from: r */
    private ImageView f4159r;

    /* renamed from: s */
    private ImageView f4160s;

    /* renamed from: t */
    private ImageView f4161t;

    /* renamed from: u */
    private TextView f4162u;

    /* renamed from: v */
    private TextView f4163v;

    /* renamed from: w */
    private TextView f4164w;

    /* renamed from: x */
    private TextView f4165x;

    /* renamed from: y */
    private TextView f4166y;

    /* renamed from: z */
    private TextView f4167z;

    /* renamed from: K */
    private int f4132K = 0;

    /* renamed from: L */
    private int f4133L = 0;

    /* renamed from: M */
    private long f4134M = 0;

    /* renamed from: N */
    private boolean f4135N = false;

    /* renamed from: O */
    private boolean f4136O = false;

    /* renamed from: P */
    private boolean f4137P = false;

    /* renamed from: Q */
    private boolean f4138Q = false;

    /* renamed from: R */
    private boolean f4139R = false;

    /* renamed from: T */
    private Bitmap f4141T = null;

    /* renamed from: a */
    View.OnClickListener f4142a = new ViewOnClickListenerC1371hx(this);

    /* renamed from: b */
    InterfaceC2211y f4143b = new C1372hy(this);

    /* renamed from: c */
    Handler f4144c = new HandlerC1373hz(this);

    /* renamed from: d */
    ContentObserver f4145d = new C1376ib(this, new Handler());

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f4151j = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f4151j = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18641c("[LIFE] onCreate, isTaskRoot: " + this.f4151j.isTaskRoot() + ", Task ID: " + this.f4151j.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        if (getArguments() != null) {
            this.f4130I = getArguments().getString("specialuserid");
            this.f4131J = getArguments().getString("speicalusername");
            this.f4139R = getArguments().getBoolean("showProfileViaExternal", false);
            if (getArguments().containsKey("specialBuddyAdded")) {
                this.f4136O = getArguments().getBoolean("specialBuddyAdded");
            }
        } else {
            this.f4130I = this.f4151j.getIntent().getExtras().getString("specialuserid");
            this.f4131J = this.f4151j.getIntent().getExtras().getString("speicalusername");
            this.f4139R = this.f4151j.getIntent().getExtras().getBoolean("showProfileViaExternal", false);
            if (this.f4151j.getIntent().getExtras().containsKey("specialBuddyAdded")) {
                this.f4136O = this.f4151j.getIntent().getExtras().getBoolean("specialBuddyAdded");
            }
        }
        if (this.f4130I == null) {
            this.f4151j.finish();
        }
        this.f4149h = ProgressDialogC4926s.m18731a(this.f4151j, false);
        this.f4149h.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f4150i = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
        this.f4146e = new C2210x(this.f4151j.getContentResolver(), this.f4143b);
        m6986f();
        this.f4146e.startQuery(501, null, C2230ar.f7958a, null, "buddy_no = ? ", new String[]{this.f4130I}, null);
        getActivity().getContentResolver().registerContentObserver(C2230ar.f7958a, true, this.f4145d);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4147f = Executors.newSingleThreadExecutor();
        this.f4152k = new LinearLayout(this.f4151j);
        this.f4152k.setOrientation(1);
        this.f4152k.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        m6976c();
        return this.f4152k;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (m6979c(false)) {
            new C2128i(this.f4144c).m9498a(this.f4130I, -1, -1);
        }
        C4904y.m18641c("[LIFE] onResume, isTaskRoot: " + this.f4151j.isTaskRoot() + ", Task ID: " + this.f4151j.getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        getActivity().getApplicationContext().getContentResolver().unregisterContentObserver(this.f4145d);
        m6989g();
        if (this.f4147f != null && !this.f4147f.isShutdown()) {
            this.f4147f.shutdown();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.livepartner_page_menu, menu);
        this.f4128G = menu.findItem(R.id.livepartenr_menu_like);
        this.f4129H = menu.findItem(R.id.livepartenr_menu_unlike);
        m6973b(this.f4138Q);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        if (m6979c(true)) {
            switch (menuItem.getItemId()) {
                case R.id.livepartenr_menu_like /* 2131166710 */:
                    if (this.f4138Q) {
                        this.f4138Q = this.f4138Q ? false : true;
                        new C2128i(this.f4144c).m9524e(this.f4148g.m7082a());
                        m6966a(true);
                        m6973b(this.f4138Q);
                        break;
                    }
                    break;
                case R.id.livepartenr_menu_unlike /* 2131166711 */:
                    if (!this.f4138Q) {
                        this.f4138Q = this.f4138Q ? false : true;
                        new C2128i(this.f4144c).m9519d(this.f4148g.m7082a());
                        m6966a(true);
                        m6973b(this.f4138Q);
                        break;
                    }
                    break;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    /* renamed from: a */
    public void m6966a(boolean z) {
        if (Build.VERSION.SDK_INT >= 11 && this.f4128G != null && this.f4129H != null) {
            if (z) {
                this.f4128G.setActionView(R.layout.layout_refresh_progressbar);
                this.f4129H.setActionView(R.layout.layout_refresh_progressbar);
            } else {
                this.f4128G.setActionView((View) null);
                this.f4129H.setActionView((View) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6973b(boolean z) {
        if (this.f4151j != null && this.f4128G != null && this.f4129H != null) {
            if (z) {
                this.f4128G.setVisible(true);
                this.f4129H.setVisible(false);
            } else {
                this.f4128G.setVisible(false);
                this.f4129H.setVisible(true);
            }
        }
    }

    /* renamed from: a */
    private void m6965a(String str) {
        if (this.f4151j != null) {
            this.f4162u.setContentDescription(str);
            if (TextUtils.isEmpty(str)) {
                this.f4162u.setVisibility(8);
                return;
            }
            this.f4162u.setVisibility(0);
            this.f4162u.setText(str);
            this.f4162u.setOnClickListener(new ViewOnClickListenerC1366hs(this));
            this.f4162u.setSoundEffectsEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6959a(long j) {
        if (this.f4151j != null) {
            if (j != 0) {
                this.f4164w.setText(getString(R.string.livepartner_body_subscribers_count, Long.valueOf(j)));
                this.f4164w.setVisibility(0);
                this.f4164w.setContentDescription(getString(R.string.livepartner_body_subscribers_count, Long.valueOf(j)));
                this.f4164w.setOnClickListener(new ViewOnClickListenerC1378id(this));
                this.f4164w.setSoundEffectsEnabled(false);
                return;
            }
            this.f4164w.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6958a(int i) {
        if (this.f4151j != null) {
            if (i != 0) {
                this.f4165x.setText(getString(R.string.livepartner_body_likes_count, Integer.valueOf(i)));
                this.f4165x.setVisibility(0);
                this.f4165x.setContentDescription(getString(R.string.livepartner_body_likes_count, Integer.valueOf(i)));
                this.f4165x.setOnClickListener(new ViewOnClickListenerC1379ie(this));
                this.f4165x.setSoundEffectsEnabled(false);
                return;
            }
            this.f4165x.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6962a(C1107d c1107d, boolean z, boolean z2) {
        if (c1107d != null) {
            if (z) {
                setHasOptionsMenu(true);
            } else {
                setHasOptionsMenu(false);
            }
            if (!TextUtils.isEmpty(this.f4131J)) {
                if (this.f4151j != null) {
                    this.f4151j.setTitle(this.f4131J);
                }
            } else if (this.f4151j != null) {
                this.f4151j.setTitle(R.string.live);
            }
            m6965a(c1107d.m7089f());
            if (z) {
                if (this.f4135N) {
                    this.f4158q.setVisibility(0);
                    this.f4158q.setOnClickListener(this.f4142a);
                    this.f4166y.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
                } else {
                    this.f4158q.setVisibility(8);
                    this.f4166y.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            if (c1107d.m7087d() != null && !c1107d.m7087d().equals("null")) {
                this.f4134M = Long.parseLong(c1107d.m7087d());
            } else {
                this.f4134M = 0L;
            }
            m6959a(this.f4134M);
            if (z2) {
                C2496n.m10765a(this.f4159r, c1107d.m7082a(), EnumC2498p.SQUARE);
                C4812ad.m18155a(c1107d.m7082a(), this.f4147f, new C1380if(this));
            }
            if (c1107d.m7088e() != null && !c1107d.m7088e().equals("null")) {
                this.f4132K = Integer.parseInt(c1107d.m7088e());
            } else {
                this.f4132K = 0;
            }
            m6958a(this.f4132K);
            if (c1107d != null && c1107d.m7091h() != null && c1107d.m7091h().length() != 0) {
                this.f4155n.setVisibility(0);
                this.f4122A.setText(c1107d.m7091h().replace(" ", ""));
                this.f4156o.setVisibility(0);
                this.f4122A.setContentDescription(c1107d.m7091h());
                this.f4155n.setOnTouchListener(new ViewOnTouchListenerC1382ih(this));
            } else {
                this.f4155n.setVisibility(8);
                this.f4156o.setVisibility(8);
            }
            this.f4155n.setOnClickListener(new ViewOnClickListenerC1383ii(this, c1107d));
            if (c1107d != null && c1107d.m7092i() != null && c1107d.m7092i().length() != 0) {
                this.f4154m.setVisibility(0);
                this.f4163v.setText(c1107d.m7092i().replace(" ", ""));
                this.f4157p.setVisibility(0);
                this.f4163v.setContentDescription(c1107d.m7092i());
                this.f4154m.setOnTouchListener(new ViewOnTouchListenerC1384ij(this));
                if (BuddyProfileFragment.m6784a(this.f4151j, new Intent("android.intent.action.CALL", Uri.parse("tel:+000")))) {
                    this.f4154m.setOnClickListener(new ViewOnClickListenerC1385ik(this));
                }
            } else {
                this.f4154m.setVisibility(8);
                this.f4157p.setVisibility(8);
            }
            this.f4167z.setText(c1107d.m7086c());
            this.f4167z.setContentDescription(c1107d.m7086c());
            m6957a();
            if (this.f4137P) {
                this.f4153l.setVisibility(0);
            } else {
                this.f4153l.setVisibility(8);
            }
            m6973b(this.f4138Q);
        }
    }

    /* renamed from: a */
    private void m6957a() {
        if (this.f4136O) {
            m6969b();
            this.f4123B.setVisibility(8);
            this.f4127F.setVisibility(0);
            this.f4124C.setVisibility(0);
            return;
        }
        this.f4123B.setVisibility(0);
        this.f4125D.setVisibility(8);
        this.f4126E.setVisibility(8);
        this.f4127F.setVisibility(8);
        this.f4124C.setVisibility(8);
    }

    /* renamed from: b */
    private void m6969b() {
        switch (this.f4148g.m7093j()) {
            case CHAT:
                this.f4125D.setVisibility(0);
                this.f4126E.setVisibility(8);
                break;
            case CONTENTS:
                this.f4125D.setVisibility(8);
                this.f4126E.setVisibility(0);
                break;
            case CHATCONTENTS:
                this.f4125D.setVisibility(0);
                this.f4126E.setVisibility(0);
                break;
            case LIVEGROUP:
                this.f4125D.setVisibility(8);
                this.f4126E.setVisibility(0);
                break;
            case LIVEGROUPCHAT:
                this.f4125D.setVisibility(0);
                this.f4126E.setVisibility(0);
                break;
            case NONE:
                this.f4125D.setVisibility(8);
                this.f4126E.setVisibility(0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6976c() {
        if (this.f4151j != null) {
            View viewInflate = this.f4151j.getLayoutInflater().inflate(R.layout.special_buddy_profile_layout2, (ViewGroup) null);
            viewInflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f4165x = (TextView) viewInflate.findViewById(R.id.specialbuddy_like_count);
            m6958a(this.f4132K);
            this.f4162u = (TextView) viewInflate.findViewById(R.id.specialbuddy_status_msg);
            this.f4162u.setVisibility(0);
            this.f4164w = (TextView) viewInflate.findViewById(R.id.specialbuddy_subscriber_count);
            m6959a(this.f4134M);
            this.f4159r = (ImageView) viewInflate.findViewById(R.id.specialbuddy_profile_image);
            this.f4159r.setContentDescription(getString(R.string.live) + " " + getString(R.string.media_photo));
            this.f4159r.setOnClickListener(this.f4142a);
            this.f4123B = (ImageButton) viewInflate.findViewById(R.id.buddy_add_contact);
            this.f4123B.setOnTouchListener(new ViewOnTouchListenerC1386il(this));
            this.f4123B.setOnClickListener(this.f4142a);
            this.f4126E = (ImageButton) viewInflate.findViewById(R.id.profile_special_contents);
            this.f4126E.setContentDescription(getString(R.string.live) + " " + getString(R.string.dialog_view));
            this.f4126E.setOnTouchListener(new ViewOnTouchListenerC1367ht(this));
            this.f4126E.setOnClickListener(this.f4142a);
            this.f4125D = (ImageButton) viewInflate.findViewById(R.id.profile_special_chat);
            this.f4125D.setOnTouchListener(new ViewOnTouchListenerC1368hu(this));
            this.f4125D.setOnClickListener(this.f4142a);
            this.f4127F = (ImageButton) viewInflate.findViewById(R.id.profile_recommend_special_buddy);
            this.f4127F.setOnTouchListener(new ViewOnTouchListenerC1369hv(this));
            this.f4127F.setOnClickListener(this.f4142a);
            this.f4156o = viewInflate.findViewById(R.id.profile_special_divider1);
            this.f4157p = viewInflate.findViewById(R.id.profile_special_divider2);
            this.f4124C = (ImageButton) viewInflate.findViewById(R.id.profile_unfollow_special_buddy);
            this.f4124C.setOnTouchListener(new ViewOnTouchListenerC1370hw(this));
            this.f4124C.setOnClickListener(this.f4142a);
            this.f4153l = (LinearLayout) viewInflate.findViewById(R.id.specialbuddy_profile_footer_progress);
            this.f4155n = viewInflate.findViewById(R.id.profile_special_url_area);
            this.f4155n.setFocusable(true);
            this.f4155n.findViewById(R.id.button1).setVisibility(8);
            this.f4122A = (TextView) this.f4155n.findViewById(R.id.text1);
            this.f4160s = (ImageView) this.f4155n.findViewById(R.id.image1);
            this.f4160s.setBackgroundResource(R.drawable.livepartner_popup_url);
            this.f4160s.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.live_profile_info_img_size);
            this.f4160s.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.live_profile_info_img_size);
            this.f4160s.setScaleType(ImageView.ScaleType.FIT_XY);
            int paddingLeft = this.f4155n.getPaddingLeft();
            int paddingTop = this.f4155n.getPaddingTop();
            int paddingRight = this.f4155n.getPaddingRight();
            int paddingBottom = this.f4155n.getPaddingBottom();
            this.f4155n.setBackgroundResource(R.drawable.listview_selector);
            this.f4155n.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            this.f4154m = viewInflate.findViewById(R.id.profile_special_tel_area);
            this.f4154m.setFocusable(true);
            this.f4154m.findViewById(R.id.button1).setVisibility(8);
            this.f4163v = (TextView) this.f4154m.findViewById(R.id.text1);
            this.f4161t = (ImageView) this.f4154m.findViewById(R.id.image1);
            this.f4161t = (ImageView) this.f4154m.findViewById(R.id.image1);
            this.f4161t.setBackgroundResource(R.drawable.livepartner_popup_call);
            this.f4161t.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.live_profile_info_img_size);
            this.f4161t.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.live_profile_info_img_size);
            this.f4161t.setScaleType(ImageView.ScaleType.FIT_XY);
            int paddingLeft2 = this.f4154m.getPaddingLeft();
            int paddingTop2 = this.f4154m.getPaddingTop();
            int paddingRight2 = this.f4154m.getPaddingRight();
            int paddingBottom2 = this.f4154m.getPaddingBottom();
            this.f4154m.setBackgroundResource(R.drawable.listview_selector);
            this.f4154m.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
            this.f4167z = (TextView) viewInflate.findViewById(R.id.special_buddy_profile_description);
            this.f4158q = (ViewGroup) viewInflate.findViewById(R.id.list_special_header);
            this.f4166y = (TextView) this.f4158q.findViewById(R.id.text1);
            this.f4166y.setText(getString(R.string.specialbuddy_selected_caterories, 0));
            this.f4152k.removeAllViews();
            this.f4152k.addView(viewInflate);
            this.f4140S = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6981d() {
        new C2128i(this.f4144c).m9511b(this.f4130I, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6984e() {
        new C2128i(this.f4144c).m9516c(this.f4130I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6986f() {
        if (this.f4149h != null && !this.f4151j.isFinishing()) {
            this.f4149h.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6989g() {
        if (this.f4149h != null && this.f4149h.isShowing() && this.f4151j != null && !this.f4151j.isFinishing()) {
            this.f4149h.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Intent m6952a(Context context, EnumC2214ab enumC2214ab, String str, String str2, int i) {
        Intent intent = new Intent(context, (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", enumC2214ab.m10076a());
        if (i > 0) {
            intent.putExtra("ACTIVITY_PURPOSE_ARG2", i);
        }
        if (TextUtils.isEmpty(str2)) {
            intent.putExtra("download_uri", str);
        } else {
            intent.putExtra("download_uri", str2);
            intent.putExtra("sub_content", str);
        }
        intent.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
        intent.putExtra("is_forward_mode", true);
        intent.setFlags(536870912);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m6979c(boolean z) {
        if (C5034k.m19106k()) {
            return true;
        }
        if (z) {
            m6963a(EnumC1387im.Nonetwork);
        }
        return false;
    }

    /* renamed from: a */
    private void m6963a(EnumC1387im enumC1387im) {
        switch (enumC1387im) {
            case Nonetwork:
                m6970b(R.string.popup_no_network_connection);
                break;
            case NetworkErr:
                m6970b(R.string.toast_network_unable);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6964a(CharSequence charSequence) {
        if (this.f4150i != null) {
            this.f4150i.setText(charSequence);
            this.f4150i.setDuration(0);
            this.f4150i.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6970b(int i) {
        if (this.f4150i != null) {
            this.f4150i.setText(i);
            this.f4150i.setDuration(0);
            this.f4150i.show();
        }
    }
}
