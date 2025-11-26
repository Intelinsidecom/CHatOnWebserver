package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.InterfaceC0221al;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.facebook.C0725f;
import com.sec.chaton.facebook.InterfaceC0736q;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.p015d.C0647s;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.settings.SettingActivity;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.widget.C1805i;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/* loaded from: classes.dex */
public class MyPageFragmentTablet extends Fragment implements InterfaceC0221al {

    /* renamed from: a */
    public static boolean f5860a = false;

    /* renamed from: b */
    public static final String f5861b = MyPageFragmentTablet.class.getSimpleName();

    /* renamed from: A */
    private String f5862A;

    /* renamed from: B */
    private boolean f5863B;

    /* renamed from: C */
    private boolean f5864C;

    /* renamed from: D */
    private Uri f5865D;

    /* renamed from: E */
    private File f5866E;

    /* renamed from: F */
    private RelativeLayout f5867F;

    /* renamed from: G */
    private RelativeLayout f5868G;

    /* renamed from: H */
    private Context f5869H;

    /* renamed from: I */
    private View f5870I;

    /* renamed from: J */
    private RelativeLayout f5871J;

    /* renamed from: K */
    private View f5872K;

    /* renamed from: L */
    private View f5873L;

    /* renamed from: M */
    private TextView f5874M;

    /* renamed from: N */
    private C0725f f5875N;

    /* renamed from: O */
    private ProgressDialog f5876O;

    /* renamed from: P */
    private View.OnClickListener f5877P;

    /* renamed from: Q */
    private InterfaceC0736q f5878Q;

    /* renamed from: R */
    private Handler f5879R;

    /* renamed from: c */
    final String f5880c;

    /* renamed from: l */
    private Toast f5889l;

    /* renamed from: n */
    private File f5891n;

    /* renamed from: o */
    private C0647s f5892o;

    /* renamed from: p */
    private ImageView f5893p;

    /* renamed from: q */
    private TextView f5894q;

    /* renamed from: r */
    private TextView f5895r;

    /* renamed from: s */
    private TextView f5896s;

    /* renamed from: t */
    private TextView f5897t;

    /* renamed from: u */
    private String f5898u;

    /* renamed from: v */
    private ProgressDialog f5899v;

    /* renamed from: w */
    private RelativeLayout f5900w;

    /* renamed from: x */
    private ImageButton f5901x;

    /* renamed from: y */
    private String f5902y;

    /* renamed from: z */
    private String f5903z;

    /* renamed from: d */
    private final int f5881d = 0;

    /* renamed from: e */
    private final int f5882e = 1;

    /* renamed from: f */
    private final int f5883f = 2;

    /* renamed from: g */
    private final int f5884g = 3;

    /* renamed from: h */
    private final int f5885h = 5;

    /* renamed from: i */
    private final int f5886i = 6;

    /* renamed from: j */
    private boolean f5887j = false;

    /* renamed from: k */
    private boolean f5888k = false;

    /* renamed from: m */
    private File f5890m = GlobalApplication.m3260b().getFilesDir().getAbsoluteFile();

    public MyPageFragmentTablet() {
        this.f5880c = C1767bw.m6002a() ? GlobalApplication.m3256a().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath();
        this.f5891n = new File(this.f5880c + "/profile/");
        this.f5898u = "";
        this.f5863B = false;
        this.f5864C = true;
        this.f5877P = new ViewOnClickListenerC1715y(this);
        this.f5878Q = new C1716z(this);
        this.f5879R = new HandlerC1628ae(this);
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: a */
    public void mo1821a() {
        f5860a = true;
        C1786r.m6061b("onTabSelected...", getClass().getSimpleName());
        if (this.f5894q != null) {
            if (C1789u.m6075a().getBoolean("show_phone_number_to_all", false)) {
                this.f5894q.setTextColor(getResources().getColor(R.color.ics_main_font_color_2));
            } else {
                this.f5894q.setTextColor(getResources().getColor(R.color.gray2));
            }
        }
        BaseActivity.m1827a(this, true);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyPageBuddiesSay(), "container").commit();
        getActivity().findViewById(R.id.base_divider).setVisibility(0);
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: b */
    public void mo1822b() {
        C1786r.m6061b("onTabUnSelected...", getClass().getSimpleName());
        BaseActivity.m1827a(this, false);
        f5860a = false;
        Fragment fragmentFindFragmentById = getFragmentManager().findFragmentById(R.id.fragment_msg_box);
        if (fragmentFindFragmentById instanceof MsgboxFragment) {
            ((MsgboxFragment) fragmentFindFragmentById).m3533a("");
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeTabletFragment.EmptyFragment(), "container").commitAllowingStateLoss();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5869H = GlobalApplication.m3260b();
        m5629f();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    /* renamed from: f */
    private void m5629f() {
        this.f5892o = new C0647s(this.f5879R);
        this.f5902y = C1789u.m6075a().getString("msisdn", "");
        this.f5903z = C1789u.m6075a().getString("Push Name", "");
        this.f5862A = C1789u.m6075a().getString("status_message", "");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        C1786r.m6061b("onStop...", getClass().getSimpleName());
        this.f5870I = layoutInflater.inflate(R.layout.user_porfile_fragment_header2, (ViewGroup) null);
        this.f5893p = (ImageView) this.f5870I.findViewById(R.id.imgbtnUPPhoto);
        if (this.f5893p != null) {
            this.f5893p.requestFocus();
        }
        this.f5894q = (TextView) this.f5870I.findViewById(R.id.user_Pno);
        this.f5895r = (TextView) this.f5870I.findViewById(R.id.textPersonalMsg);
        this.f5867F = (RelativeLayout) this.f5870I.findViewById(R.id.linear_status_message);
        this.f5868G = (RelativeLayout) this.f5870I.findViewById(R.id.linear_profile_name);
        this.f5896s = (TextView) this.f5870I.findViewById(R.id.textPersonalName);
        this.f5897t = (TextView) this.f5870I.findViewById(R.id.dateDisplay);
        this.f5871J = (RelativeLayout) this.f5870I.findViewById(R.id.rlayoutPhoneNumber);
        this.f5901x = (ImageButton) this.f5870I.findViewById(R.id.userprofile_detail);
        this.f5872K = this.f5870I.findViewById(R.id.rlayout_facebook_account);
        this.f5873L = this.f5870I.findViewById(R.id.user_facebook_account_detail);
        this.f5874M = (TextView) this.f5870I.findViewById(R.id.user_facebook_account_id);
        if (this.f5875N == null) {
            this.f5875N = new C0725f(this, this.f5878Q);
        }
        this.f5900w = (RelativeLayout) this.f5870I.findViewById(R.id.rlayoutBDay);
        this.f5899v = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_userprofile_updating);
        this.f5876O = new ProgressDialogC1806j(getActivity());
        this.f5876O.setMessage(getString(R.string.dialog_connecting_server));
        this.f5876O.setIndeterminate(true);
        this.f5876O.setCancelable(false);
        m5631g();
        m5635i();
        m5633h();
        return this.f5870I;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        C1786r.m6061b("onStop...", getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5623b(String str) {
        if (this.f5875N.m3224c() && str != null) {
            this.f5874M.setText(str);
            this.f5873L.setVisibility(0);
        } else {
            this.f5874M.setText(R.string.login);
            this.f5873L.setVisibility(8);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m5629f();
        m5631g();
        m5623b(this.f5875N.m3221b());
        if (this.f5863B) {
            m5635i();
            this.f5863B = false;
        }
    }

    /* renamed from: g */
    private void m5631g() throws Resources.NotFoundException {
        this.f5894q.setText("+" + this.f5902y);
        this.f5896s.setText(this.f5903z);
        this.f5895r.setText(this.f5862A);
        m5619a(this.f5897t);
        if (C1789u.m6075a().getBoolean("show_phone_number_to_all", false)) {
            this.f5894q.setTextColor(getResources().getColor(R.color.ics_main_font_color_2));
        } else {
            this.f5894q.setTextColor(getResources().getColor(R.color.gray2));
        }
    }

    /* renamed from: h */
    private void m5633h() {
        this.f5893p.setOnClickListener(new ViewOnClickListenerC1624aa(this));
        this.f5901x.setOnClickListener(new ViewOnClickListenerC1625ab(this));
    }

    /* renamed from: a */
    public static void m5619a(TextView textView) throws Resources.NotFoundException {
        String string = C1789u.m6075a().getString("birthday_type", "");
        String string2 = GlobalApplication.m3260b().getResources().getString(R.string.add_your_birthday);
        String string3 = C1789u.m6075a().getString("birthday", string2);
        C1786r.m6061b("pref : birthDayOption :" + string + " birthDay :" + string3, f5861b);
        if (string.equals("FULL")) {
            textView.setText(m5618a(string3));
            return;
        }
        if (string.equals("SHORT")) {
            String[] strArrSplit = string3.split("-");
            textView.setText(m5618a(strArrSplit[1] + "-" + strArrSplit[2]));
            return;
        }
        if (string3.equals(string2)) {
            textView.setText(R.string.add_your_birthday);
            return;
        }
        if (string3 != null && !"".equals(string3)) {
            if (!string3.startsWith("0000")) {
                if (C1789u.m6075a().getBoolean("birthday_year_show", false)) {
                    textView.setText(MyPageFragment.m5579a(string3));
                    return;
                } else {
                    String[] strArrSplit2 = string3.split("-");
                    textView.setText(MyPageFragment.m5579a(strArrSplit2[1] + "-" + strArrSplit2[2]));
                    return;
                }
            }
            textView.setText(R.string.add_your_birthday);
            return;
        }
        textView.setText(R.string.add_your_birthday);
    }

    /* renamed from: a */
    public static String m5618a(String str) throws NumberFormatException {
        String strReplaceAll;
        int i;
        int i2;
        int i3;
        C1786r.m6066e("original birthday str:" + str, f5861b);
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.contains(" ") && (str.contains("-") || str.contains("/") || str.contains(".") || str.contains(","))) {
            strReplaceAll = str.replaceAll("\\s", "");
            C1786r.m6066e("trimmed birthday str:" + strReplaceAll, f5861b);
        } else {
            strReplaceAll = str;
        }
        String[] strArrSplit = strReplaceAll.split("-|\\/|\\s|\\.|\\,");
        if (strReplaceAll.length() == 10) {
            i = Integer.parseInt(strArrSplit[0]) - 1900;
            i2 = Integer.parseInt(strArrSplit[1]) - 1;
            i3 = Integer.parseInt(strArrSplit[2]);
        } else {
            i = 100;
            i2 = Integer.parseInt(strArrSplit[0]) - 1;
            i3 = Integer.parseInt(strArrSplit[1]);
        }
        try {
            String string = DateFormat.getDateFormat(GlobalApplication.m3260b()).format(new Date(i, i2, i3)).toString();
            if (str.length() != 10) {
                if (string.contains(" ") && (string.contains("-") || string.contains("/") || string.contains(".") || string.contains(","))) {
                    string = string.replaceAll("\\s", "");
                }
                String[] strArrSplit2 = string.split("-|\\/|\\s|\\.|\\,");
                if (strArrSplit2[0].length() == 4) {
                    return string.substring(5);
                }
                if (strArrSplit2[2].length() == 4) {
                    return string.substring(0, strArrSplit2[1].length() + strArrSplit2[0].length() + 1);
                }
                return string;
            }
            return string;
        } catch (Exception e) {
            C1786r.m6061b("change date format error", f5861b);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m5635i() {
        C1786r.m6066e("UserProfile initialize() - img status: " + C1789u.m6075a().getString("profile_image_status", ""), f5861b);
        if (C1789u.m6075a().getString("profile_image_status", "").equals("updated")) {
            File file = new File(this.f5890m, "myprofile.png_");
            if (file.exists()) {
                new AsyncTaskC1626ac(this, file).execute(new Void[0]);
                return;
            }
            return;
        }
        m5639l();
    }

    /* renamed from: c */
    public void m5640c() throws IOException {
        int i;
        int i2;
        try {
            if (!this.f5891n.canRead()) {
                this.f5891n.mkdirs();
            }
            m5636j();
            this.f5898u = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f5866E = new File(this.f5891n + "/", this.f5898u);
            this.f5891n.mkdir();
            this.f5866E.createNewFile();
            this.f5865D = Uri.fromFile(this.f5866E);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                Toast.makeText(getActivity(), getString(R.string.toast_sdcard_amount), 1).show();
                return;
            }
            if (C1789u.m6075a().getString("profile_image_status", "").equals("updated")) {
                i = R.array.selphoto;
                i2 = R.string.ams_add_frame_title;
            } else {
                i = R.array.selphoto_first;
                i2 = R.string.mypage_profile_add_photo;
            }
            new AlertDialogBuilderC2120a(getActivity()).setTitle(i2).setItems(i, new DialogInterfaceOnClickListenerC1627ad(this)).setNeutralButton(R.string.cancel, (DialogInterface.OnClickListener) null).create().show();
        } catch (IOException e) {
            C1786r.m6056a(e, f5861b);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (GlobalApplication.m3265f()) {
            this.f5875N.m3218a(i, i2, intent);
        }
        switch (i) {
            case 3:
                if (intent == null) {
                    C1786r.m6061b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    try {
                        C1791w.m6092a(C1791w.m6093a(Bitmap.createScaledBitmap(C1791w.m6100b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true)), "/profile/", this.f5898u);
                        this.f5863B = true;
                        if (this.f5864C && this.f5866E.length() > 1000000) {
                            File fileM6094a = C1791w.m6094a(getActivity(), this.f5866E);
                            if (fileM6094a != null) {
                                this.f5892o.m2964a(fileM6094a.getPath());
                                this.f5899v.show();
                            }
                        } else {
                            this.f5892o.m2964a(this.f5866E.getPath());
                            this.f5899v.show();
                        }
                        break;
                    } catch (Exception e) {
                        C1786r.m6056a(e, getClass().getSimpleName());
                        m5639l();
                        return;
                    }
                }
                break;
            case 5:
                if (intent == null) {
                    C1786r.m6061b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    this.f5865D = intent.getData();
                    Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f5865D, "image/*");
                    intent2.putExtra("outputX", 600);
                    intent2.putExtra("outputY", 600);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 3);
                    break;
                }
            case 6:
                if (i2 == -1) {
                    Intent intent3 = new Intent(this.f5869H, (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f5865D, "image/*");
                    intent3.putExtra("outputX", 600);
                    intent3.putExtra("outputY", 600);
                    intent3.putExtra("aspectX", 1);
                    intent3.putExtra("aspectY", 1);
                    intent3.putExtra("return-data", true);
                    startActivityForResult(intent3, 3);
                    break;
                } else {
                    C1786r.m6061b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
        }
    }

    /* renamed from: j */
    private void m5636j() {
        if (!m5641d() || !m5642e()) {
            C1786r.m6054a("[deleteTempFolder] External Storage Is Not Available or Writable!", f5861b);
            if (this.f5889l == null) {
                this.f5889l = Toast.makeText(this.f5869H, getString(R.string.toast_sdcard_amount), 1);
            }
            this.f5889l.show();
            return;
        }
        String strM6003b = C1767bw.m6003b();
        if (strM6003b.length() == 0) {
            this.f5889l.show();
            return;
        }
        try {
            String[] list = new File(strM6003b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C1786r.m6061b("[Delete File] " + strM6003b + "/profile/" + str + " : " + new File(strM6003b + "/profile/" + str).delete(), f5861b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    protected boolean m5641d() {
        m5638k();
        return this.f5887j;
    }

    /* renamed from: e */
    protected boolean m5642e() {
        m5638k();
        return this.f5888k;
    }

    /* renamed from: k */
    private void m5638k() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f5887j = true;
            this.f5888k = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f5887j = true;
            this.f5888k = false;
        } else {
            this.f5887j = false;
            this.f5888k = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.clear();
        if (C1789u.m6075a().contains("UpdateIsCritical")) {
            menu.addSubMenu(0, 1, 0, getResources().getString(R.string.setting_settings_title)).setIcon(R.drawable.settings_new);
        } else {
            menu.addSubMenu(0, 1, 0, getResources().getString(R.string.setting_settings_title)).setIcon(R.drawable.ic_menu_settings);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                this.f5863B = true;
                startActivity(new Intent(getActivity(), (Class<?>) (GlobalApplication.m3265f() ? SettingActivity.class : ActivitySettings.class)));
            default:
                return true;
        }
    }

    /* renamed from: l */
    private void m5639l() {
        try {
            this.f5893p.setImageBitmap(C1746bb.m5940a(this.f5893p.getContext(), R.drawable.mypage_noimage));
            C1746bb.m5945a(GlobalApplication.m3260b()).m5961a(this.f5902y);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
