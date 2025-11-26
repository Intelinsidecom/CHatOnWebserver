package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0512b;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3225cm;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class BuddyGroupProfileFragment extends Fragment implements InterfaceC0598db, InterfaceC0651dp {

    /* renamed from: a */
    public static final String f1908a = BuddyGroupProfileFragment.class.getSimpleName();

    /* renamed from: A */
    private ImageButton f1909A;

    /* renamed from: C */
    private File f1911C;

    /* renamed from: G */
    private Uri f1915G;

    /* renamed from: H */
    private Toast f1916H;

    /* renamed from: J */
    private ProgressDialog f1918J;

    /* renamed from: K */
    private String[] f1919K;

    /* renamed from: L */
    private ImageView f1920L;

    /* renamed from: N */
    private C0045a f1922N;

    /* renamed from: O */
    private Activity f1923O;

    /* renamed from: b */
    public int f1927b;

    /* renamed from: g */
    private C0512b f1932g;

    /* renamed from: n */
    private Context f1939n;

    /* renamed from: o */
    private TextView f1940o;

    /* renamed from: p */
    private ImageButton f1941p;

    /* renamed from: q */
    private Button f1942q;

    /* renamed from: r */
    private View f1943r;

    /* renamed from: s */
    private TextView f1944s;

    /* renamed from: t */
    private View f1945t;

    /* renamed from: u */
    private String f1946u;

    /* renamed from: v */
    private C1377u f1947v;

    /* renamed from: w */
    private Toast f1948w;

    /* renamed from: x */
    private ImageButton f1949x;

    /* renamed from: y */
    private ImageButton f1950y;

    /* renamed from: z */
    private ImageButton f1951z;

    /* renamed from: h */
    private final int f1933h = 0;

    /* renamed from: i */
    private final int f1934i = 1;

    /* renamed from: j */
    private final int f1935j = 2;

    /* renamed from: k */
    private final int f1936k = 3;

    /* renamed from: l */
    private final int f1937l = 4;

    /* renamed from: m */
    private final int f1938m = 5;

    /* renamed from: c */
    String f1928c = C3223ck.m11328b();

    /* renamed from: B */
    private File f1910B = new File(this.f1928c + "/profile/");

    /* renamed from: D */
    private String f1912D = "";

    /* renamed from: E */
    private boolean f1913E = false;

    /* renamed from: F */
    private boolean f1914F = false;

    /* renamed from: I */
    private boolean f1917I = false;

    /* renamed from: M */
    private File f1921M = CommonApplication.m11493l().getFilesDir().getAbsoluteFile();

    /* renamed from: P */
    private boolean f1924P = false;

    /* renamed from: Q */
    private Handler f1925Q = new HandlerC0653dr(this);

    /* renamed from: d */
    InterfaceC1413d f1929d = new C0655dt(this);

    /* renamed from: e */
    View.OnClickListener f1930e = new ViewOnClickListenerC0656du(this);

    /* renamed from: R */
    private View.OnTouchListener f1926R = new ViewOnTouchListenerC0659dx(this);

    /* renamed from: f */
    InterfaceC1378v f1931f = new C0660dy(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1923O = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1923O = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11458g("onCreate()", f1908a);
        if (getArguments() != null) {
            this.f1924P = getArguments().getBoolean("LAUNCH_AS_CHILD", false);
        } else if (this.f1923O.getIntent().getExtras() != null) {
            this.f1924P = this.f1923O.getIntent().getBooleanExtra("LAUNCH_AS_CHILD", false);
        }
        if (!this.f1924P) {
            this.f1923O.setContentView(R.layout.group_info);
            setHasOptionsMenu(true);
        }
        this.f1923O.setTitle(getString(R.string.buddy_list_contextual_menu_group_profile));
        BuddyFragment buddyFragment = new BuddyFragment();
        if (bundle == null) {
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                arguments.putBoolean(BuddyFragment.f1725b, true);
                buddyFragment.setArguments(arguments);
            } else {
                buddyFragment.setArguments(this.f1923O.getIntent().getExtras());
            }
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_controller, buddyFragment, "com.sec.chaton:single_pane_fragment").commit();
        } else {
            String string = bundle.getString("CAPTURE_IMAGE_URI");
            if (!TextUtils.isEmpty(string)) {
                this.f1915G = Uri.parse(string);
            }
            String string2 = bundle.getString("PROFILE_IMAGE_TEMP_FILE_URI");
            if (!TextUtils.isEmpty(string2)) {
                this.f1911C = new File(string2);
            }
        }
        this.f1947v = new C1377u(this.f1923O.getContentResolver(), this.f1931f);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C3225cm.m11337a(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (!this.f1924P) {
            m3481e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0233  */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onCreateView(android.view.LayoutInflater r9, android.view.ViewGroup r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 628
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
        if (this.f1915G != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f1915G.toString());
        }
        if (this.f1911C != null) {
            bundle.putString("PROFILE_IMAGE_TEMP_FILE_URI", this.f1911C.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public BuddyFragment m3478d() {
        return (BuddyFragment) getFragmentManager().findFragmentByTag("com.sec.chaton:single_pane_fragment");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x020a  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m3481e() {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyGroupProfileFragment.m3481e():void");
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        C3250y.m11458g("onCreateOptionsMenu()", f1908a);
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.group_page_menu, menu);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        C3250y.m11458g("onPrepareOptionsMenu()", f1908a);
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2:
            case R.id.group_page_delete_menu /* 2131166613 */:
                AbstractC3271a.m11494a(this.f1923O).mo11500a(getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).mo11509b(getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0652dq(this)).mo11501a(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m3483f() {
        boolean zM55d;
        Exception e;
        try {
            zM55d = this.f1922N.m55d(this.f1939n);
            try {
                C3250y.m11450b("[ChatONV] isReadyToCall : " + zM55d, f1908a);
            } catch (Exception e2) {
                e = e2;
                C3250y.m11450b("[ChatONV] " + e.getMessage() + " : " + zM55d, f1908a);
                C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f1908a);
                return zM55d;
            }
        } catch (Exception e3) {
            zM55d = false;
            e = e3;
        }
        C3250y.m11450b("[ChatONV] isChatONVReadyToCall : " + zM55d, f1908a);
        return zM55d;
    }

    /* renamed from: a */
    public void m3504a() throws IOException {
        int i;
        int i2;
        boolean z = true;
        try {
            if (!this.f1910B.canRead()) {
                this.f1910B.mkdirs();
            }
            m3487h();
            this.f1912D = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f1911C = new File(this.f1910B + "/", this.f1912D);
            C3250y.m11450b("[Create File] " + this.f1910B.toString() + this.f1912D + " : " + this.f1911C.createNewFile(), f1908a);
            this.f1915G = Uri.fromFile(this.f1911C);
            if (!m3507b() || !m3509c()) {
                if (this.f1916H == null) {
                    this.f1916H = C3641ai.m13211a(this.f1923O, getString(R.string.toast_sdcard_amount), 1);
                }
                this.f1916H.show();
                return;
            }
            if (m3506a(this.f1932g.m3962b())) {
                i = R.array.selphoto;
                i2 = R.string.ams_add_frame_title;
            } else {
                i = R.array.selphoto_first;
                i2 = R.string.mypage_profile_add_photo;
                z = false;
            }
            AbstractC3271a abstractC3271aMo11497a = AbstractC3271a.m11494a(this.f1923O).mo11495a(i2).mo11497a(i, new DialogInterfaceOnClickListenerC0657dv(this));
            if (z) {
                abstractC3271aMo11497a.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0658dw(this));
            }
            abstractC3271aMo11497a.mo11505a().show();
            if (this.f1917I) {
                abstractC3271aMo11497a.mo11505a().dismiss();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m3485g() {
        try {
            this.f1920L.setImageResource(R.drawable.contacts_default_group);
            m3504a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m3505a(Bitmap bitmap, String str) throws IOException {
        String simpleName;
        String strEncode = str + "_group_profile.png_";
        try {
            strEncode = URLEncoder.encode(strEncode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        C3250y.m11450b("saveBitmapToFile : fileName", getClass().getSimpleName());
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = CommonApplication.m11493l().openFileOutput(strEncode, 0);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                C3205bt.m11182a(this.f1923O).m11219a(str, false);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e2) {
                        e = e2;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            } catch (FileNotFoundException e3) {
                C3250y.m11443a(e3, getClass().getSimpleName());
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e4) {
                        e = e4;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e5) {
                    C3250y.m11443a(e5, getClass().getSimpleName());
                }
            }
            throw th;
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
                        C3250y.m11442a("Crop return null!", f1908a);
                        break;
                    } else {
                        try {
                            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C3162ad.m11012b(this.f1923O, Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true);
                            C3020a.m10525a(file, this.f1911C);
                            this.f1920L.setImageBitmap(bitmapCreateScaledBitmap);
                            m3505a(bitmapCreateScaledBitmap, this.f1932g.m3962b());
                            break;
                        } catch (Exception e) {
                            C3250y.m11443a(e, getClass().getSimpleName());
                            m3485g();
                            return;
                        }
                    }
                }
                break;
            case 4:
                if (intent == null) {
                    C3250y.m11450b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else if (i2 == -1) {
                    this.f1915G = intent.getData();
                    Intent intent2 = new Intent(this.f1923O, (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f1915G, "image/*");
                    intent2.putExtra("outputX", 600);
                    intent2.putExtra("outputY", 600);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("return-data", true);
                    intent2.putExtra("groupname", this.f1932g.m3962b());
                    intent2.putExtra("isgroup", true);
                    startActivityForResult(intent2, 3);
                    break;
                }
                break;
            case 5:
                if (i2 == -1) {
                    Intent intent3 = new Intent(this.f1923O, (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f1915G, "image/*");
                    intent3.putExtra("outputX", 600);
                    intent3.putExtra("outputY", 600);
                    intent3.putExtra("aspectX", 1);
                    intent3.putExtra("aspectY", 1);
                    intent3.putExtra("return-data", true);
                    intent3.putExtra("groupname", this.f1932g.m3962b());
                    intent3.putExtra("isgroup", true);
                    startActivityForResult(intent3, 3);
                    break;
                } else {
                    C3250y.m11450b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
            case 6:
                if (i2 == -1) {
                    C3250y.m11456e("PROFILE_EDIT_BUDDY_NAME", f1908a);
                    String string = intent.getExtras().getString("PROFILE_GROUP_RENAME");
                    this.f1932g.m3961a(string);
                    this.f1940o.setText(string);
                    break;
                }
                break;
        }
    }

    /* renamed from: h */
    private void m3487h() {
        if (!m3507b() || !m3509c()) {
            C3250y.m11442a("[deleteTempFolder] External Storage Is Not Available or Writable!", f1908a);
            if (this.f1916H == null) {
                this.f1916H = C3641ai.m13211a(this.f1923O, getString(R.string.toast_sdcard_amount), 1);
            }
            this.f1916H.show();
            return;
        }
        String strM11328b = C3223ck.m11328b();
        if (strM11328b.length() == 0) {
            this.f1916H.show();
            return;
        }
        try {
            String[] list = new File(strM11328b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C3250y.m11450b("[Delete File] " + strM11328b + "/profile/" + str + " : " + new File(strM11328b + "/profile/" + str).delete(), f1908a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    protected boolean m3507b() {
        m3488i();
        return this.f1913E;
    }

    /* renamed from: c */
    protected boolean m3509c() {
        m3488i();
        return this.f1914F;
    }

    /* renamed from: i */
    private void m3488i() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f1913E = true;
            this.f1914F = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f1913E = true;
            this.f1914F = false;
        } else {
            this.f1913E = false;
            this.f1914F = false;
        }
    }

    /* renamed from: a */
    public boolean m3506a(String str) {
        File file = new File(this.f1921M, str + "_group_profile.png_");
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: a */
    public void mo3452a(int i) {
    }

    @Override // com.sec.chaton.buddy.InterfaceC0598db
    /* renamed from: b */
    public void mo3453b(int i) {
        this.f1927b = i;
        this.f1944s.setText(getString(R.string.buddy_group_profile_buddy) + " (" + this.f1927b + ")");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a7, code lost:
    
        if (com.coolots.sso.p006a.C0045a.m37b(r8.f1939n) == false) goto L16;
     */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyGroupProfileFragment.onResume():void");
    }

    @Override // com.sec.chaton.buddy.InterfaceC0651dp
    /* renamed from: c */
    public void mo3508c(int i) {
        C3250y.m11458g("mGroup member Count: " + this.f1927b, f1908a);
        this.f1927b = i;
        this.f1944s.setText(getString(R.string.buddy_group_profile_buddy) + " (" + this.f1927b + ")");
    }

    /* renamed from: j */
    private void m3491j() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.f1923O.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public boolean m3493k() {
        boolean z = false;
        try {
            if (C1954g.m7916a().m7918a(this.f1939n, EnumC1955h.ChatONV)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVAvaiable : " + z, f1908a);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public boolean m3495l() {
        boolean z = false;
        try {
            C0045a c0045a = this.f1922N;
            if (C0045a.m37b(this.f1939n)) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3250y.m11450b("[ChatONV] isChatONVInstalled : " + z, f1908a);
        return z;
    }
}
