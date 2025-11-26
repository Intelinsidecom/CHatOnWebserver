package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0647s;
import com.sec.chaton.trunk.p053e.C1592a;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1791w;
import com.sec.chaton.widget.C1805i;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class UserProfileImageView extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        return new UserProfileImageViewFragment();
    }

    public class UserProfileImageViewFragment extends Fragment {

        /* renamed from: B */
        private LinearLayout f6082B;

        /* renamed from: d */
        private Button f6086d;

        /* renamed from: e */
        private Button f6087e;

        /* renamed from: g */
        private ImageView f6089g;

        /* renamed from: h */
        private Uri f6090h;

        /* renamed from: n */
        private ProgressDialog f6096n;

        /* renamed from: o */
        private C0647s f6097o;

        /* renamed from: p */
        private int f6098p;

        /* renamed from: q */
        private int f6099q;

        /* renamed from: r */
        private int f6100r;

        /* renamed from: u */
        private File f6103u;

        /* renamed from: y */
        private Toast f6107y;

        /* renamed from: z */
        private Menu f6108z;

        /* renamed from: b */
        public static final String f6081b = UserProfileImageView.class.getSimpleName();

        /* renamed from: A */
        private static String f6080A = "";

        /* renamed from: f */
        private ProgressDialog f6088f = null;

        /* renamed from: i */
        private final int f6091i = 5;

        /* renamed from: j */
        private final int f6092j = 6;

        /* renamed from: k */
        private boolean f6093k = false;

        /* renamed from: l */
        private boolean f6094l = true;

        /* renamed from: m */
        private boolean f6095m = false;

        /* renamed from: a */
        String f6084a = C1767bw.m6003b();

        /* renamed from: s */
        private File f6101s = new File(this.f6084a + "/profile/");

        /* renamed from: t */
        private File f6102t = GlobalApplication.m3260b().getFilesDir().getAbsoluteFile();

        /* renamed from: v */
        private String f6104v = "";

        /* renamed from: w */
        private boolean f6105w = false;

        /* renamed from: x */
        private boolean f6106x = false;

        /* renamed from: c */
        View.OnClickListener f6085c = new ViewOnClickListenerC1690cm(this);

        /* renamed from: C */
        private Handler f6083C = new HandlerC1692co(this);

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            BaseActivity.m1829b(this, true);
            f6080A = C1789u.m6075a().getString("msisdn", "");
            if (GlobalApplication.m3265f()) {
                getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            C1786r.m6061b("onPrepareOptionMenu...", getClass().getSimpleName());
            menu.clear();
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_edit_cancel, menu);
            this.f6108z = menu;
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case android.R.id.home:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_cancel /* 2131494128 */:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_edit /* 2131494133 */:
                    m5794a();
                    break;
            }
            return true;
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
            View viewInflate = layoutInflater.inflate(R.layout.layout_profile_image_view, viewGroup, false);
            if (!GlobalApplication.m3265f()) {
                this.f6082B = (LinearLayout) viewInflate.findViewById(R.id.layout_profile_image_title);
                this.f6082B.setVisibility(8);
            }
            this.f6096n = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_userprofile_updating);
            this.f6097o = new C0647s(this.f6083C);
            this.f6089g = (ImageView) viewInflate.findViewById(R.id.profile_big_image);
            this.f6086d = (Button) viewInflate.findViewById(R.id.profile_ok);
            this.f6086d.setOnClickListener(this.f6085c);
            this.f6087e = (Button) viewInflate.findViewById(R.id.profile_cancel);
            this.f6087e.setOnClickListener(this.f6085c);
            if (GlobalApplication.m3265f()) {
                getActivity().getWindow().setLayout(-1, -1);
                getActivity().getActionBar().setTitle(getString(R.string.profile_image_photo));
            }
            m5787d();
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
        }

        /* renamed from: d */
        private void m5787d() throws Resources.NotFoundException {
            Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
            C1786r.m6061b("w:" + defaultDisplay.getWidth(), getClass().getSimpleName());
            C1786r.m6061b("h:" + defaultDisplay.getHeight(), getClass().getSimpleName());
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            if (width >= 480 && height >= 600) {
                this.f6098p = 600;
                this.f6099q = 600;
                this.f6100r = 800;
            } else {
                this.f6095m = true;
                this.f6098p = 350;
                this.f6099q = 350;
                this.f6100r = 350;
            }
            m5791f();
        }

        /* renamed from: a */
        public void m5794a() {
            int i;
            int i2;
            try {
                if (!this.f6101s.canRead()) {
                    this.f6101s.mkdirs();
                }
                m5792g();
                this.f6104v = "tmp_" + System.currentTimeMillis() + ".jpeg_";
                this.f6103u = new File(this.f6101s + "/", this.f6104v);
                C1786r.m6061b("[Create File] " + this.f6101s.toString() + this.f6104v + " : " + this.f6103u.createNewFile(), f6081b);
                this.f6090h = Uri.fromFile(this.f6103u);
                if (!m5795b() || !m5796c()) {
                    if (this.f6107y == null) {
                        this.f6107y = Toast.makeText(getActivity(), getString(R.string.toast_sdcard_amount), 1);
                    }
                    this.f6107y.show();
                } else {
                    if (C1789u.m6075a().getString("profile_image_status", "").equals("updated")) {
                        i = R.array.selphoto;
                        i2 = R.string.ams_add_frame_title;
                    } else {
                        i = R.array.selphoto_first;
                        i2 = R.string.mypage_profile_add_photo;
                    }
                    new AlertDialogBuilderC2120a(getActivity()).setTitle(i2).setItems(i, new DialogInterfaceOnClickListenerC1691cn(this)).setNeutralButton(R.string.cancel, (DialogInterface.OnClickListener) null).create().show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
            super.onActivityResult(i, i2, intent);
            System.gc();
            switch (i) {
                case 3:
                    if (i2 == -1) {
                        File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                        if (file.length() <= 0) {
                            C1786r.m6054a("Crop return null!", f6081b);
                            break;
                        } else {
                            try {
                                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C1791w.m6100b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true);
                                C1592a.m5493a(file, this.f6103u);
                                this.f6089g.setImageBitmap(bitmapCreateScaledBitmap);
                                this.f6093k = true;
                                this.f6097o.m2964a(this.f6103u.getPath());
                                this.f6096n.show();
                                break;
                            } catch (Exception e) {
                                C1786r.m6056a(e, getClass().getSimpleName());
                                m5789e();
                                return;
                            }
                        }
                    }
                    break;
                case 5:
                    if (intent == null) {
                        C1786r.m6061b("Crop Return is NULL", getClass().getSimpleName());
                        break;
                    } else {
                        this.f6090h = intent.getData();
                        Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent2.setDataAndType(this.f6090h, "image/*");
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
                        Intent intent3 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent3.setDataAndType(this.f6090h, "image/*");
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

        /* renamed from: e */
        private void m5789e() {
            try {
                this.f6089g.setImageResource(R.drawable.mypage_noimage);
                m5794a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: f */
        private void m5791f() throws Resources.NotFoundException {
            C1786r.m6066e("UserProfile initialize() - img status: " + C1789u.m6075a().getString("profile_image_status", ""), getClass().getSimpleName());
            if (C1789u.m6075a().getString("profile_image_status", "").equals("updated")) {
                File file = new File(this.f6102t, "myprofile.png_");
                C1786r.m6061b("photoFile=" + file, getClass().getSimpleName());
                if (file.exists()) {
                    new AsyncTaskC1693cp(this).execute(new Void[0]);
                    return;
                } else {
                    m5789e();
                    Toast.makeText(getActivity(), R.string.setting_profile_image_not_exist, 1);
                    return;
                }
            }
            m5789e();
        }

        /* renamed from: g */
        private void m5792g() {
            if (!m5795b() || !m5796c()) {
                C1786r.m6054a("[deleteTempFolder] External Storage Is Not Available or Writable!", f6081b);
                if (this.f6107y == null) {
                    this.f6107y = Toast.makeText(getActivity(), getString(R.string.toast_sdcard_amount), 1);
                }
                this.f6107y.show();
                return;
            }
            String strM6003b = C1767bw.m6003b();
            if (strM6003b.length() == 0) {
                this.f6107y.show();
                return;
            }
            try {
                String[] list = new File(strM6003b + "/profile/").list();
                if (list != null) {
                    for (String str : list) {
                        C1786r.m6061b("[Delete File] " + strM6003b + "/profile/" + str + " : " + new File(strM6003b + "/profile/" + str).delete(), f6081b);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: b */
        protected boolean m5795b() {
            m5793h();
            return this.f6105w;
        }

        /* renamed from: c */
        protected boolean m5796c() {
            m5793h();
            return this.f6106x;
        }

        /* renamed from: h */
        private void m5793h() {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted".equals(externalStorageState)) {
                this.f6105w = true;
                this.f6106x = true;
            } else if ("mounted_ro".equals(externalStorageState)) {
                this.f6105w = true;
                this.f6106x = false;
            } else {
                this.f6105w = false;
                this.f6106x = false;
            }
        }
    }
}
