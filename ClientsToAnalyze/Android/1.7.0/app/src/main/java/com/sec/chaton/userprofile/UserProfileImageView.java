package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0226y;
import com.sec.chaton.trunk.p045d.C1169g;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.C1356c;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class UserProfileImageView extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new UserProfileImageViewFragment();
    }

    public class UserProfileImageViewFragment extends Fragment {

        /* renamed from: b */
        public static final String f4258b = UserProfileImageView.class.getSimpleName();

        /* renamed from: d */
        private ImageView f4261d;

        /* renamed from: e */
        private Uri f4262e;

        /* renamed from: j */
        private ProgressDialog f4267j;

        /* renamed from: k */
        private C0226y f4268k;

        /* renamed from: l */
        private GeneralHeaderView f4269l;

        /* renamed from: o */
        private File f4272o;

        /* renamed from: s */
        private Toast f4276s;

        /* renamed from: t */
        private LinearLayout f4277t;

        /* renamed from: f */
        private final int f4263f = 5;

        /* renamed from: g */
        private final int f4264g = 6;

        /* renamed from: h */
        private boolean f4265h = false;

        /* renamed from: i */
        private boolean f4266i = true;

        /* renamed from: a */
        String f4259a = C1327bw.m4596b();

        /* renamed from: m */
        private File f4270m = new File(this.f4259a + "/profile/");

        /* renamed from: n */
        private File f4271n = GlobalApplication.m3100a().getFilesDir().getAbsoluteFile();

        /* renamed from: p */
        private String f4273p = "";

        /* renamed from: q */
        private boolean f4274q = false;

        /* renamed from: r */
        private boolean f4275r = false;

        /* renamed from: c */
        View.OnClickListener f4260c = new ViewOnClickListenerC1274x(this);

        /* renamed from: u */
        private Handler f4278u = new HandlerC1272v(this);

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            BaseActivity.m2043b(this, true);
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            C1341p.m4658b("onPrepareOptionMenu...", getClass().getSimpleName());
            menu.clear();
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_change_cancel, menu);
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.actionbar_title_cancel /* 2131428237 */:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_change /* 2131428238 */:
                    m4414a();
                    break;
            }
            return true;
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.layout_profile_image_view, viewGroup, false);
            this.f4277t = (LinearLayout) viewInflate.findViewById(R.id.layout_profile_image_title);
            this.f4277t.setVisibility(8);
            this.f4267j = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.dialog_userprofile_updating);
            this.f4268k = new C0226y(this.f4278u);
            this.f4261d = (ImageView) viewInflate.findViewById(R.id.profile_big_image);
            this.f4269l = (GeneralHeaderView) viewInflate.findViewById(R.id.layout_profile_header_view);
            this.f4269l.setButtonClickListener(new ViewOnClickListenerC1275y(this));
            m4409d();
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
        }

        /* renamed from: d */
        private void m4409d() {
            m4411f();
        }

        /* renamed from: a */
        public void m4414a() {
            int i;
            try {
                if (!this.f4270m.canRead()) {
                    this.f4270m.mkdirs();
                }
                m4412g();
                this.f4273p = "tmp_" + System.currentTimeMillis() + ".jpeg_";
                this.f4272o = new File(this.f4270m + "/", this.f4273p);
                C1341p.m4658b("[Create File] " + this.f4270m.toString() + this.f4273p + " : " + this.f4272o.createNewFile(), f4258b);
                this.f4262e = Uri.fromFile(this.f4272o);
                if (!m4415b() || !m4416c()) {
                    if (this.f4276s == null) {
                        this.f4276s = C1619g.m5889a(getActivity(), getString(R.string.toast_sdcard_amount), 1);
                    }
                    this.f4276s.show();
                } else {
                    if (C1323bs.m4575a().getString("profile_image_status", "").equals("updated")) {
                        i = R.array.selphoto;
                    } else {
                        i = R.array.selphoto_first;
                    }
                    new AlertDialogBuilderC1625m(getActivity()).setTitle(R.string.select_photo).setItems(i, new DialogInterfaceOnClickListenerC1273w(this)).create().show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            System.gc();
            switch (i) {
                case 3:
                    if (i2 == -1) {
                        File file = new File(Uri.parse(intent.getExtras().getString("temp_file_path")).getPath());
                        if (file.length() <= 0) {
                            C1341p.m4651a("Crop return null!", f4258b);
                            break;
                        } else {
                            try {
                                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C1294aq.m4512b(getActivity(), Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true);
                                C1169g.m4215a(file, this.f4272o);
                                this.f4261d.setImageBitmap(bitmapCreateScaledBitmap);
                                this.f4265h = true;
                                this.f4268k.m874a(this.f4272o.getPath());
                                this.f4267j.show();
                                break;
                            } catch (Exception e) {
                                C1341p.m4653a(e, getClass().getSimpleName());
                                m4410e();
                                return;
                            }
                        }
                    }
                    break;
                case 5:
                    if (intent == null) {
                        C1341p.m4658b("Crop Return is NULL", getClass().getSimpleName());
                        break;
                    } else {
                        this.f4262e = intent.getData();
                        Intent intent2 = new Intent(getActivity(), (Class<?>) ImageModify.class);
                        intent2.setDataAndType(this.f4262e, "image/*");
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
                        intent3.setDataAndType(this.f4262e, "image/*");
                        intent3.putExtra("outputX", 600);
                        intent3.putExtra("outputY", 600);
                        intent3.putExtra("aspectX", 1);
                        intent3.putExtra("aspectY", 1);
                        intent3.putExtra("return-data", true);
                        startActivityForResult(intent3, 3);
                        break;
                    } else {
                        C1341p.m4658b("Camera Return is NULL", getClass().getSimpleName());
                        break;
                    }
            }
        }

        /* renamed from: e */
        private void m4410e() {
            try {
                this.f4261d.setImageResource(R.drawable.co_default_image_add);
                m4414a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: f */
        private void m4411f() {
            C1341p.m4662e("UserProfile initialize() - img status: " + C1323bs.m4575a().getString("profile_image_status", ""), getClass().getSimpleName());
            if (C1323bs.m4575a().getString("profile_image_status", "").equals("updated")) {
                File file = new File(this.f4271n, "myprofile.png_");
                C1341p.m4658b("photoFile=" + file, getClass().getSimpleName());
                if (file.exists()) {
                    new AsyncTaskC1271u(this, file).execute(new Void[0]);
                    return;
                } else {
                    m4410e();
                    C1619g.m5888a(getActivity(), R.string.setting_profile_image_not_exist, 1);
                    return;
                }
            }
            m4410e();
        }

        /* renamed from: g */
        private void m4412g() {
            if (!m4415b() || !m4416c()) {
                C1341p.m4651a("[deleteTempFolder] External Storage Is Not Available or Writable!", f4258b);
                if (this.f4276s == null) {
                    this.f4276s = C1619g.m5889a(getActivity(), getString(R.string.toast_sdcard_amount), 1);
                }
                this.f4276s.show();
                return;
            }
            String strM4596b = C1327bw.m4596b();
            if (strM4596b.length() == 0) {
                this.f4276s.show();
                return;
            }
            try {
                String[] list = new File(strM4596b + "/profile/").list();
                if (list != null) {
                    for (String str : list) {
                        C1341p.m4658b("[Delete File] " + strM4596b + "/profile/" + str + " : " + new File(strM4596b + "/profile/" + str).delete(), f4258b);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: b */
        protected boolean m4415b() {
            m4413h();
            return this.f4274q;
        }

        /* renamed from: c */
        protected boolean m4416c() {
            m4413h();
            return this.f4275r;
        }

        /* renamed from: h */
        private void m4413h() {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted".equals(externalStorageState)) {
                this.f4274q = true;
                this.f4275r = true;
            } else if ("mounted_ro".equals(externalStorageState)) {
                this.f4274q = true;
                this.f4275r = false;
            } else {
                this.f4274q = false;
                this.f4275r = false;
            }
        }
    }
}
