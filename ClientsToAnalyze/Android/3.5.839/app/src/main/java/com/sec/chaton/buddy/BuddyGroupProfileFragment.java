package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1105b;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4875cm;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class BuddyGroupProfileFragment extends Fragment implements InterfaceC1261dv, InterfaceC1276ej {

    /* renamed from: a */
    public static final String f3785a = BuddyGroupProfileFragment.class.getSimpleName();

    /* renamed from: A */
    private ImageButton f3786A;

    /* renamed from: B */
    private ImageButton f3787B;

    /* renamed from: D */
    private File f3789D;

    /* renamed from: H */
    private Uri f3793H;

    /* renamed from: I */
    private Toast f3794I;

    /* renamed from: K */
    private ProgressDialog f3796K;

    /* renamed from: L */
    private String[] f3797L;

    /* renamed from: M */
    private ImageView f3798M;

    /* renamed from: O */
    private C0416a f3800O;

    /* renamed from: P */
    private Activity f3801P;

    /* renamed from: b */
    public int f3805b;

    /* renamed from: i */
    private C1105b f3812i;

    /* renamed from: p */
    private Context f3819p;

    /* renamed from: q */
    private TextView f3820q;

    /* renamed from: r */
    private ImageButton f3821r;

    /* renamed from: s */
    private Button f3822s;

    /* renamed from: t */
    private TextView f3823t;

    /* renamed from: u */
    private View f3824u;

    /* renamed from: v */
    private String f3825v;

    /* renamed from: w */
    private C2210x f3826w;

    /* renamed from: x */
    private Toast f3827x;

    /* renamed from: y */
    private ImageButton f3828y;

    /* renamed from: z */
    private ImageButton f3829z;

    /* renamed from: j */
    private final int f3813j = 0;

    /* renamed from: k */
    private final int f3814k = 1;

    /* renamed from: l */
    private final int f3815l = 2;

    /* renamed from: m */
    private final int f3816m = 3;

    /* renamed from: n */
    private final int f3817n = 4;

    /* renamed from: o */
    private final int f3818o = 5;

    /* renamed from: c */
    String f3806c = C4873ck.m18501b();

    /* renamed from: C */
    private File f3788C = new File(this.f3806c + "/profile/");

    /* renamed from: E */
    private String f3790E = "";

    /* renamed from: F */
    private boolean f3791F = false;

    /* renamed from: G */
    private boolean f3792G = false;

    /* renamed from: J */
    private boolean f3795J = false;

    /* renamed from: N */
    private File f3799N = CommonApplication.m18732r().getFilesDir().getAbsoluteFile();

    /* renamed from: Q */
    private boolean f3802Q = false;

    /* renamed from: R */
    private Handler f3803R = new HandlerC1280en(this);

    /* renamed from: d */
    InterfaceC2243d f3807d = new C1282ep(this);

    /* renamed from: e */
    View.OnClickListener f3808e = new ViewOnClickListenerC1283eq(this);

    /* renamed from: S */
    private View.OnTouchListener f3804S = new ViewOnTouchListenerC1287eu(this);

    /* renamed from: f */
    InterfaceC2211y f3809f = new C1288ev(this);

    /* renamed from: g */
    ContentObserver f3810g = new C1278el(this, new Handler());

    /* renamed from: h */
    ContentObserver f3811h = new C1279em(this, new Handler());

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3801P = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3801P = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18639b("onCreate()", f3785a);
        if (getArguments() != null) {
            this.f3802Q = getArguments().getBoolean("LAUNCH_AS_CHILD", false);
        } else if (this.f3801P.getIntent().getExtras() != null) {
            this.f3802Q = this.f3801P.getIntent().getBooleanExtra("LAUNCH_AS_CHILD", false);
        }
        if (!this.f3802Q) {
            this.f3801P.setContentView(R.layout.group_info);
            setHasOptionsMenu(true);
        }
        this.f3801P.setTitle(getString(R.string.buddy_list_contextual_menu_group_profile));
        BuddyFragment buddyFragment = new BuddyFragment();
        if (bundle == null) {
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                arguments.putBoolean(BuddyFragment.f3577b, true);
                buddyFragment.setArguments(arguments);
            } else {
                buddyFragment.setArguments(this.f3801P.getIntent().getExtras());
            }
            getActivity().m50e().mo183a().mo96a(R.id.fragment_controller, buddyFragment, "com.sec.chaton:single_pane_fragment").mo99b();
        } else {
            String string = bundle.getString("CAPTURE_IMAGE_URI");
            if (!TextUtils.isEmpty(string)) {
                this.f3793H = Uri.parse(string);
            }
            String string2 = bundle.getString("PROFILE_IMAGE_TEMP_FILE_URI");
            if (!TextUtils.isEmpty(string2)) {
                this.f3789D = new File(string2);
            }
        }
        this.f3826w = new C2210x(this.f3801P.getContentResolver(), this.f3809f);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C4875cm.m18511a(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (!this.f3802Q) {
            m6636e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x020a  */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onCreateView(android.view.LayoutInflater r9, android.view.ViewGroup r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyGroupProfileFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f3793H != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f3793H.toString());
        }
        if (this.f3789D != null) {
            bundle.putString("PROFILE_IMAGE_TEMP_FILE_URI", this.f3789D.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public BuddyFragment m6633d() {
        return (BuddyFragment) getFragmentManager().mo182a("com.sec.chaton:single_pane_fragment");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x01e7  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m6636e() {
        /*
            Method dump skipped, instructions count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyGroupProfileFragment.m6636e():void");
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        C4904y.m18639b("onCreateOptionsMenu()", f3785a);
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.group_page_menu, menu);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        C4904y.m18639b("onPrepareOptionsMenu()", f3785a);
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case 2:
            case R.id.group_page_delete_menu /* 2131166705 */:
                AbstractC4932a.m18733a(this.f3801P).mo18740a(getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).mo18749b(getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1277ek(this)).mo18741a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m6638f() {
        boolean zM1495d;
        Exception e;
        try {
            zM1495d = this.f3800O.m1495d(this.f3819p);
            try {
                C4904y.m18639b("[ChatONV] isReadyToCall : " + zM1495d, f3785a);
            } catch (Exception e2) {
                e = e2;
                C4904y.m18639b("[ChatONV] " + e.getMessage() + " : " + zM1495d, f3785a);
                C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f3785a);
                return zM1495d;
            }
        } catch (Exception e3) {
            zM1495d = false;
            e = e3;
        }
        C4904y.m18639b("[ChatONV] isChatONVReadyToCall : " + zM1495d, f3785a);
        return zM1495d;
    }

    /* renamed from: a */
    public void m6659a() throws IOException {
        int i;
        int i2;
        boolean z = true;
        try {
            if (!this.f3788C.canRead()) {
                this.f3788C.mkdirs();
            }
            m6642h();
            this.f3790E = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f3789D = new File(this.f3788C + "/", this.f3790E);
            C4904y.m18639b("[Create File] " + this.f3788C.toString() + this.f3790E + " : " + this.f3789D.createNewFile(), f3785a);
            this.f3793H = Uri.fromFile(this.f3789D);
            if (!m6662b() || !m6664c()) {
                if (this.f3794I == null) {
                    this.f3794I = C5179v.m19811a(this.f3801P, getString(R.string.toast_sdcard_amount), 1);
                }
                this.f3794I.show();
                return;
            }
            if (m6661a(this.f3812i.m7036b())) {
                i = R.array.selphoto;
                i2 = R.string.ams_add_frame_title;
            } else {
                i = R.array.selphoto_first;
                i2 = R.string.mypage_profile_add_photo;
                z = false;
            }
            AbstractC4932a abstractC4932aMo18747b = AbstractC4932a.m18733a(this.f3801P).mo18734a(i2).mo18736a(i, new DialogInterfaceOnClickListenerC1285es(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1284er(this));
            if (z) {
                abstractC4932aMo18747b.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1286et(this));
            }
            abstractC4932aMo18747b.mo18745a().show();
            if (this.f3795J) {
                abstractC4932aMo18747b.mo18745a().dismiss();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m6640g() {
        try {
            this.f3798M.setImageResource(R.drawable.profile_photo_group_default);
            m6659a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m6660a(Bitmap bitmap, String str) throws ExecutionException, InterruptedException {
        try {
            C2496n.m10783c(GlobalApplication.m18732r(), str, bitmap).get();
        } catch (UnsupportedEncodingException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f3785a);
            }
        } catch (IOException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f3785a);
            }
        } catch (InterruptedException e3) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e3, f3785a);
            }
        } catch (ExecutionException e4) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e4, f3785a);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 3:
                if (i2 == -1) {
                    File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                    if (file.length() <= 0) {
                        C4904y.m18634a("Crop return null!", f3785a);
                        break;
                    } else {
                        try {
                            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C4812ad.m18157b(this.f3801P, Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true);
                            C4636a.m17602a(file, this.f3789D);
                            this.f3798M.setImageBitmap(bitmapCreateScaledBitmap);
                            m6660a(bitmapCreateScaledBitmap, this.f3812i.m7036b());
                            break;
                        } catch (Exception e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                            m6640g();
                            return;
                        }
                    }
                }
                break;
            case 4:
                if (intent == null) {
                    C4904y.m18639b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else if (i2 == -1) {
                    this.f3793H = intent.getData();
                    Intent intent2 = new Intent(this.f3801P, (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f3793H, "image/*");
                    intent2.putExtra("outputX", 600);
                    intent2.putExtra("outputY", 600);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("return-data", true);
                    intent2.putExtra("groupname", this.f3812i.m7036b());
                    intent2.putExtra("isgroup", true);
                    startActivityForResult(intent2, 3);
                    break;
                }
                break;
            case 5:
                if (i2 == -1) {
                    Intent intent3 = new Intent(this.f3801P, (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f3793H, "image/*");
                    intent3.putExtra("outputX", 600);
                    intent3.putExtra("outputY", 600);
                    intent3.putExtra("aspectX", 1);
                    intent3.putExtra("aspectY", 1);
                    intent3.putExtra("return-data", true);
                    intent3.putExtra("groupname", this.f3812i.m7036b());
                    intent3.putExtra("isgroup", true);
                    startActivityForResult(intent3, 3);
                    break;
                } else {
                    C4904y.m18639b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
            case 6:
                if (i2 == -1) {
                    C4904y.m18646e("PROFILE_EDIT_BUDDY_NAME", f3785a);
                    String string = intent.getExtras().getString("PROFILE_GROUP_RENAME");
                    this.f3812i.m7035a(string);
                    this.f3820q.setText(string);
                    break;
                }
                break;
        }
    }

    /* renamed from: h */
    private void m6642h() {
        if (!m6662b() || !m6664c()) {
            C4904y.m18634a("[deleteTempFolder] External Storage Is Not Available or Writable!", f3785a);
            if (this.f3794I == null) {
                this.f3794I = C5179v.m19811a(this.f3801P, getString(R.string.toast_sdcard_amount), 1);
            }
            this.f3794I.show();
            return;
        }
        String strM18501b = C4873ck.m18501b();
        if (strM18501b.length() == 0) {
            this.f3794I.show();
            return;
        }
        try {
            String[] list = new File(strM18501b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C4904y.m18639b("[Delete File] " + strM18501b + "/profile/" + str + " : " + new File(strM18501b + "/profile/" + str).delete(), f3785a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    protected boolean m6662b() {
        m6643i();
        return this.f3791F;
    }

    /* renamed from: c */
    protected boolean m6664c() {
        m6643i();
        return this.f3792G;
    }

    /* renamed from: i */
    private void m6643i() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f3791F = true;
            this.f3792G = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f3791F = true;
            this.f3792G = false;
        } else {
            this.f3791F = false;
            this.f3792G = false;
        }
    }

    /* renamed from: a */
    public boolean m6661a(String str) {
        File file = new File(this.f3799N, str + "_group_profile.png_");
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: a */
    public void mo6198a(int i) {
    }

    @Override // com.sec.chaton.buddy.InterfaceC1261dv
    /* renamed from: b */
    public void mo6199b(int i) {
        this.f3805b = i;
        this.f3823t.setText(getString(R.string.buddy_select_category_group_member, Integer.valueOf(this.f3805b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0072, code lost:
    
        if (com.coolots.sso.p030a.C0416a.m1477b(r7.f3819p) == false) goto L10;
     */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            r7 = this;
            r6 = 2131429023(0x7f0b069f, float:1.8479707E38)
            r0 = 1
            r5 = 8
            r1 = 0
            super.onResume()
            android.widget.TextView r2 = r7.f3823t
            java.lang.Object[] r3 = new java.lang.Object[r0]
            int r4 = r7.f3805b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r1] = r4
            java.lang.String r3 = r7.getString(r6, r3)
            r2.setText(r3)
            android.widget.ImageView r2 = r7.f3798M
            com.sec.chaton.buddy.a.b r3 = r7.f3812i
            java.lang.String r3 = r3.m7036b()
            com.sec.chaton.l.p r4 = com.sec.chaton.p074l.EnumC2498p.ROUND
            com.sec.chaton.p074l.C2496n.m10777b(r2, r3, r4)
            android.content.Context r2 = com.sec.common.CommonApplication.m18732r()
            android.content.ContentResolver r2 = r2.getContentResolver()
            com.sec.chaton.buddy.a.b r3 = r7.f3812i
            int r3 = r3.m7034a()
            com.sec.chaton.p057e.p058a.C2191e.m9852a(r2, r3)
            android.widget.TextView r2 = r7.f3823t
            java.lang.Object[] r3 = new java.lang.Object[r0]
            int r4 = r7.f3805b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r1] = r4
            java.lang.String r3 = r7.getString(r6, r3)
            r2.setText(r3)
            android.content.Context r2 = com.sec.chaton.global.GlobalApplication.m18732r()
            boolean r2 = com.sec.chaton.plugin.C2923b.m12153h(r2)
            if (r2 == 0) goto Lac
            android.content.Context r2 = r7.f3819p
            if (r2 == 0) goto La1
            com.sec.chaton.plugin.h r2 = com.sec.chaton.plugin.C2948h.m12190a()
            android.content.Context r3 = r7.f3819p
            com.sec.chaton.plugin.i r4 = com.sec.chaton.plugin.EnumC2949i.ChatONV
            boolean r2 = r2.m12192a(r3, r4)
            if (r2 != 0) goto L74
            com.coolots.sso.a.a r2 = r7.f3800O
            android.content.Context r2 = r7.f3819p
            boolean r2 = com.coolots.sso.p030a.C0416a.m1477b(r2)
            if (r2 != 0) goto La1
        L74:
            r2 = r0
            r0 = r1
        L76:
            java.lang.String[] r3 = r7.f3797L
            int r3 = r3.length
            if (r0 >= r3) goto L89
            java.lang.String[] r3 = r7.f3797L
            r3 = r3[r0]
            boolean r3 = com.sec.chaton.buddy.BuddyFragment.m6463b(r3)
            if (r3 != 0) goto L86
            r2 = r1
        L86:
            int r0 = r0 + 1
            goto L76
        L89:
            if (r2 == 0) goto L96
            android.widget.ImageButton r0 = r7.f3786A
            r0.setVisibility(r1)
            android.widget.ImageButton r0 = r7.f3787B
            r0.setVisibility(r1)
        L95:
            return
        L96:
            android.widget.ImageButton r0 = r7.f3786A
            r0.setVisibility(r5)
            android.widget.ImageButton r0 = r7.f3787B
            r0.setVisibility(r5)
            goto L95
        La1:
            android.widget.ImageButton r0 = r7.f3786A
            r0.setVisibility(r5)
            android.widget.ImageButton r0 = r7.f3787B
            r0.setVisibility(r5)
            goto L95
        Lac:
            android.widget.ImageButton r0 = r7.f3786A
            r0.setVisibility(r5)
            android.widget.ImageButton r0 = r7.f3787B
            r0.setVisibility(r5)
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyGroupProfileFragment.onResume():void");
    }

    @Override // com.sec.chaton.buddy.InterfaceC1276ej
    /* renamed from: c */
    public void mo6663c(int i) {
        C4904y.m18639b("mGroup member Count: " + this.f3805b, f3785a);
        this.f3805b = i;
        this.f3823t.setText(getString(R.string.buddy_select_category_group_member, Integer.valueOf(this.f3805b)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public boolean m6646j() {
        boolean z = false;
        try {
            if (C2948h.m12190a().m12192a(this.f3819p, EnumC2949i.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVAvaiable : " + z, f3785a);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public boolean m6648k() {
        boolean z = false;
        try {
            C0416a c0416a = this.f3800O;
            if (C0416a.m1477b(this.f3819p)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4904y.m18639b("[ChatONV] isChatONVInstalled : " + z, f3785a);
        return z;
    }
}
