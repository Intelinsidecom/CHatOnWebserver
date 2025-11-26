package com.sec.chaton.buddy;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0258d;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* loaded from: classes.dex */
public class SpecialBuddyProfileFragment extends Fragment {

    /* renamed from: A */
    private Button f1269A;

    /* renamed from: B */
    private View f1270B;

    /* renamed from: d */
    private C0666j f1274d;

    /* renamed from: e */
    private C0258d f1275e;

    /* renamed from: f */
    private ProgressDialogC1806j f1276f;

    /* renamed from: g */
    private Context f1277g;

    /* renamed from: h */
    private String f1278h;

    /* renamed from: i */
    private String f1279i;

    /* renamed from: m */
    private ImageView f1283m;

    /* renamed from: n */
    private TextView f1284n;

    /* renamed from: o */
    private TextView f1285o;

    /* renamed from: p */
    private CheckBox f1286p;

    /* renamed from: q */
    private ImageView f1287q;

    /* renamed from: r */
    private boolean f1288r;

    /* renamed from: s */
    private TextView f1289s;

    /* renamed from: t */
    private TextView f1290t;

    /* renamed from: u */
    private TextView f1291u;

    /* renamed from: v */
    private TextView f1292v;

    /* renamed from: w */
    private Button f1293w;

    /* renamed from: x */
    private Button f1294x;

    /* renamed from: y */
    private ImageView f1295y;

    /* renamed from: z */
    private TextView f1296z;

    /* renamed from: j */
    private int f1280j = 0;

    /* renamed from: k */
    private long f1281k = 0;

    /* renamed from: l */
    private boolean f1282l = false;

    /* renamed from: a */
    View.OnClickListener f1271a = new ViewOnClickListenerC0410fn(this);

    /* renamed from: b */
    InterfaceC0667k f1272b = new C0411fo(this);

    /* renamed from: c */
    Handler f1273c = new HandlerC0412fp(this);

    /* renamed from: a */
    static /* synthetic */ int m2273a(SpecialBuddyProfileFragment specialBuddyProfileFragment, int i) {
        int i2 = specialBuddyProfileFragment.f1280j + i;
        specialBuddyProfileFragment.f1280j = i2;
        return i2;
    }

    /* renamed from: b */
    static /* synthetic */ int m2278b(SpecialBuddyProfileFragment specialBuddyProfileFragment, int i) {
        int i2 = specialBuddyProfileFragment.f1280j - i;
        specialBuddyProfileFragment.f1280j = i2;
        return i2;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6063c("[LIFE] onCreate, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f1277g = getActivity();
        Bundle arguments = getArguments();
        if (arguments.isEmpty()) {
            arguments = getActivity().getIntent().getExtras();
        }
        this.f1278h = arguments.getString("specialuserid");
        this.f1279i = arguments.getString("speicalusername");
        this.f1282l = arguments.getBoolean("specialBuddyAdded");
        if (this.f1278h == null) {
            getActivity().finish();
        }
        this.f1276f = new ProgressDialogC1806j(getActivity(), false);
        this.f1276f.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f1274d = new C0666j(getActivity().getContentResolver(), this.f1272b);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f1282l) {
            new C0633e(this.f1273c).m2854a(-1, -1);
        }
        if (this.f1282l) {
            this.f1274d.startQuery(1, null, C0704s.f2647a, null, "buddy_no = ? ", new String[]{this.f1278h}, null);
        } else {
            this.f1274d.startQuery(4, null, C0702q.f2645a, null, "buddy_no = ? ", new String[]{this.f1278h}, null);
        }
        C1786r.m6063c("[LIFE] onResume, isTaskRoot: " + getActivity().isTaskRoot() + ", Task ID: " + getActivity().getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f1282l) {
            new C0633e(this.f1273c).m2859a(this.f1278h, -1, -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1270B = LayoutInflater.from(getActivity()).inflate(R.layout.special_buddy_profile_layout, (ViewGroup) null);
        this.f1270B.setPadding(10, 0, 0, 0);
        return this.f1270B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2276a(boolean z) {
        if (isAdded() && this.f1275e != null) {
            this.f1283m = (ImageView) this.f1270B.findViewById(R.id.profile_special_image);
            this.f1283m.setImageResource(R.drawable.contacts_default_special);
            this.f1286p = (CheckBox) this.f1270B.findViewById(R.id.profile_special_is_favorite);
            this.f1287q = (ImageView) this.f1270B.findViewById(R.id.profile_specialButton);
            this.f1289s = (TextView) this.f1270B.findViewById(R.id.profile_special_subcribed);
            if (this.f1275e.m2357d() != null && !this.f1275e.m2357d().equals("null")) {
                this.f1281k = Integer.parseInt(this.f1275e.m2357d());
            }
            this.f1289s.setText(getResources().getString(R.string.buddy_special_buddy_buddies_subscribed, Long.valueOf(this.f1281k)));
            this.f1292v = (TextView) this.f1270B.findViewById(R.id.profile_special_like_count);
            if (this.f1275e.m2358e() != null && !this.f1275e.m2358e().equals("null")) {
                this.f1280j = Integer.parseInt(this.f1275e.m2358e());
            }
            toString();
            this.f1292v.setText(String.valueOf(this.f1280j));
            if (z) {
                this.f1286p.setChecked(this.f1288r);
                this.f1286p.setOnClickListener(this.f1271a);
                this.f1286p.setVisibility(0);
                this.f1287q.setVisibility(8);
            } else {
                this.f1287q.setVisibility(0);
                this.f1286p.setVisibility(8);
                this.f1286p.setClickable(false);
            }
            C1746bb.m5945a(this.f1277g).m5960a(this.f1283m, this.f1275e.m2354a(), 3);
            this.f1284n = (TextView) this.f1270B.findViewById(R.id.profile_special_name);
            this.f1284n.setText(this.f1275e.m2355b());
            this.f1284n.setContentDescription(this.f1275e.m2355b());
            this.f1284n.setOnTouchListener(new ViewOnTouchListenerC0404fh(this));
            this.f1295y = (ImageView) this.f1270B.findViewById(R.id.profile_special_url_image);
            this.f1295y.setOnClickListener(this.f1271a);
            this.f1295y.setVisibility(0);
            this.f1296z = (TextView) this.f1270B.findViewById(R.id.profile_special_url);
            this.f1296z.setAutoLinkMask(1);
            if (this.f1275e != null && this.f1275e.m2362i() != null) {
                this.f1296z.setText(this.f1275e.m2362i().replace(" ", ""));
                this.f1296z.setContentDescription(this.f1275e.m2362i());
                this.f1296z.setOnTouchListener(new ViewOnTouchListenerC0405fi(this));
            }
            this.f1290t = (TextView) this.f1270B.findViewById(R.id.special_selected_category);
            this.f1290t.setText(getString(R.string.calendar_description));
            this.f1291u = (TextView) this.f1270B.findViewById(R.id.special_selected_description);
            this.f1291u.setText(this.f1275e.m2356c());
            this.f1291u.setContentDescription(this.f1275e.m2356c());
            this.f1285o = (TextView) this.f1270B.findViewById(R.id.profile_special_status_message);
            this.f1285o.setContentDescription(this.f1275e.m2359f());
            if (TextUtils.isEmpty(this.f1275e.m2359f())) {
                this.f1285o.setVisibility(8);
            } else {
                this.f1285o.setText(this.f1275e.m2359f());
                this.f1285o.setOnTouchListener(new ViewOnTouchListenerC0406fj(this));
            }
            this.f1293w = (Button) this.f1270B.findViewById(R.id.profile_add_special_buddy);
            this.f1293w.setOnTouchListener(new ViewOnTouchListenerC0407fk(this));
            this.f1293w.setOnClickListener(this.f1271a);
            this.f1294x = (Button) this.f1270B.findViewById(R.id.profile_special_chat);
            this.f1294x.setOnTouchListener(new ViewOnTouchListenerC0408fl(this));
            this.f1294x.setOnClickListener(this.f1271a);
            if (z) {
                this.f1293w.setVisibility(8);
                this.f1294x.setVisibility(0);
            } else {
                this.f1293w.setVisibility(0);
                this.f1294x.setVisibility(8);
            }
            this.f1269A = (Button) this.f1270B.findViewById(R.id.profile_spcial_buddy_see_more_btn);
            this.f1269A.setOnTouchListener(new ViewOnTouchListenerC0409fm(this));
            this.f1269A.setOnClickListener(this.f1271a);
            this.f1269A.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m2294a() {
        this.f1276f.show();
        new C0633e(this.f1273c).m2868b(this.f1278h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2280b() {
        this.f1276f.show();
        new C0632d(this.f1273c).m2847a(this.f1278h, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2284c() {
        this.f1276f.show();
        new C0632d(this.f1273c).m2846a(this.f1278h);
    }
}
