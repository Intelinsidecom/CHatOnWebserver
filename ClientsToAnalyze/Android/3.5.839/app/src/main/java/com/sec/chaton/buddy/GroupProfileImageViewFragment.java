package com.sec.chaton.buddy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.ViewOnTouchListenerC2837av;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.vip.cropimage.ImageModify;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class GroupProfileImageViewFragment extends Fragment {

    /* renamed from: b */
    public static final String f4103b = GroupProfileImageViewFragment.class.getSimpleName();

    /* renamed from: c */
    private ImageView f4105c;

    /* renamed from: d */
    private Uri f4106d;

    /* renamed from: g */
    private int f4109g;

    /* renamed from: h */
    private String f4110h;

    /* renamed from: j */
    private ViewOnTouchListenerC2837av f4112j;

    /* renamed from: k */
    private ViewTreeObserver.OnGlobalLayoutListener f4113k;

    /* renamed from: m */
    private File f4115m;

    /* renamed from: q */
    private Toast f4119q;

    /* renamed from: r */
    private Activity f4120r;

    /* renamed from: s */
    private LinearLayout f4121s;

    /* renamed from: e */
    private final int f4107e = 5;

    /* renamed from: f */
    private final int f4108f = 6;

    /* renamed from: a */
    String f4104a = C4873ck.m18501b();

    /* renamed from: i */
    private File f4111i = new File(this.f4104a + "/profile/");

    /* renamed from: l */
    private File f4114l = GlobalApplication.m18732r().getFilesDir().getAbsoluteFile();

    /* renamed from: n */
    private String f4116n = "";

    /* renamed from: o */
    private boolean f4117o = false;

    /* renamed from: p */
    private boolean f4118p = false;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f4120r = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f4120r = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4120r.setTitle(getString(R.string.mypage_profile_image));
        setHasOptionsMenu(true);
        if (bundle == null) {
            this.f4106d = null;
            return;
        }
        String string = bundle.getString("CAPTURE_IMAGE_URI");
        if (!TextUtils.isEmpty(string)) {
            this.f4106d = Uri.parse(string);
        }
        String string2 = bundle.getString("PROFILE_IMAGE_TEMP_FILE_URI");
        if (!TextUtils.isEmpty(string2)) {
            this.f4115m = new File(string2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws UnsupportedEncodingException {
        View viewInflate = layoutInflater.inflate(R.layout.layout_group_profile_image_view, viewGroup, false);
        this.f4121s = (LinearLayout) viewInflate.findViewById(R.id.layout_profile_image_title);
        this.f4121s.setVisibility(8);
        this.f4105c = (ImageView) viewInflate.findViewById(R.id.profile_big_image);
        this.f4112j = new ViewOnTouchListenerC2837av();
        this.f4105c.setOnTouchListener(this.f4112j);
        this.f4109g = this.f4120r.getIntent().getExtras().getInt("GROUP_PROFILE_ID");
        this.f4110h = this.f4120r.getIntent().getExtras().getString("GROUP_PROFILE_NAME");
        m6937d();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f4105c != null) {
            ViewTreeObserver viewTreeObserver = this.f4105c.getViewTreeObserver();
            this.f4113k = new ViewTreeObserverOnGlobalLayoutListenerC1360hm(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f4113k);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f4105c != null) {
            this.f4105c.getViewTreeObserver().removeGlobalOnLayoutListener(this.f4113k);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        C4904y.m18639b("onCreateOptionsMenu()", f4103b);
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.group_image_page_menu, menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IOException {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.group_image_page_edit_menu /* 2131166704 */:
                m6944a();
                break;
        }
        return true;
    }

    /* renamed from: d */
    private void m6937d() throws UnsupportedEncodingException {
        m6941f();
    }

    /* renamed from: a */
    public boolean m6946a(String str) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
        File file = new File(this.f4114l, strEncode + "_group_profile.png_");
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m6944a() throws IOException {
        int i;
        int i2;
        int i3;
        try {
            if (!this.f4111i.canRead()) {
                this.f4111i.mkdirs();
            }
            m6942g();
            this.f4116n = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f4115m = new File(this.f4111i + "/", this.f4116n);
            C4904y.m18639b("[Create File] " + this.f4111i.toString() + this.f4116n + " : " + this.f4115m.createNewFile(), f4103b);
            this.f4106d = Uri.fromFile(this.f4115m);
            if (!m6947b() || !m6948c()) {
                if (this.f4119q == null) {
                    this.f4119q = C5179v.m19811a(this.f4120r, getString(R.string.toast_sdcard_amount), 1);
                }
                this.f4119q.show();
                return;
            }
            if (m6946a(this.f4110h)) {
                if (C4822an.m18251s()) {
                    i3 = R.array.groupimage_context;
                } else {
                    i3 = R.array.selphoto_first_nocamera;
                }
                i = i3;
                i2 = R.string.ams_add_frame_title;
            } else {
                i = R.array.selphoto_first;
                i2 = R.string.mypage_profile_add_photo;
            }
            AbstractC4932a abstractC4932aMo18736a = AbstractC4932a.m18733a(this.f4120r).mo18734a(i2).mo18736a(i, new DialogInterfaceOnClickListenerC1361hn(this));
            abstractC4932aMo18736a.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1362ho(this));
            abstractC4932aMo18736a.mo18745a().show();
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
                        C4904y.m18634a("Crop return null!", f4103b);
                        break;
                    } else {
                        try {
                            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C4812ad.m18157b(this.f4120r, Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true);
                            C4636a.m17602a(file, this.f4115m);
                            this.f4105c.setImageBitmap(bitmapCreateScaledBitmap);
                            m6945a(bitmapCreateScaledBitmap, this.f4110h);
                            this.f4120r.finish();
                            break;
                        } catch (Exception e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                            m6939e();
                            return;
                        }
                    }
                }
                break;
            case 5:
                if (intent == null) {
                    C4904y.m18639b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    this.f4106d = intent.getData();
                    Intent intent2 = new Intent(this.f4120r, (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f4106d, "image/*");
                    intent2.putExtra("outputX", 600);
                    intent2.putExtra("outputY", 600);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("return-data", true);
                    intent2.putExtra("groupname", this.f4110h);
                    intent2.putExtra("isgroup", true);
                    startActivityForResult(intent2, 3);
                    break;
                }
            case 6:
                if (i2 == -1) {
                    Intent intent3 = new Intent(this.f4120r, (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f4106d, "image/*");
                    intent3.putExtra("outputX", 600);
                    intent3.putExtra("outputY", 600);
                    intent3.putExtra("aspectX", 1);
                    intent3.putExtra("aspectY", 1);
                    intent3.putExtra("return-data", true);
                    intent3.putExtra("groupname", this.f4110h);
                    intent3.putExtra("isgroup", true);
                    startActivityForResult(intent3, 3);
                    break;
                } else {
                    C4904y.m18639b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f4106d != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f4106d.toString());
        }
        if (this.f4115m != null) {
            bundle.putString("PROFILE_IMAGE_TEMP_FILE_URI", this.f4115m.toString());
        }
    }

    /* renamed from: e */
    private void m6939e() {
        try {
            this.f4105c.setImageResource(R.drawable.profile_photo_group_default);
            m6944a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    private void m6941f() throws UnsupportedEncodingException {
        C4904y.m18646e("UserProfile initialize() - img status: " + C4809aa.m18104a().m18121a("profile_image_status", ""), getClass().getSimpleName());
        if (m6946a(this.f4110h)) {
            String strEncode = null;
            try {
                strEncode = URLEncoder.encode(this.f4110h, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, getClass().getSimpleName());
                }
            }
            File file = new File(this.f4114l, strEncode + "_group_profile.png_");
            C4904y.m18639b("photoFile=" + file, getClass().getSimpleName());
            if (file.exists()) {
                new AsyncTaskC1363hp(this, file).execute(new Void[0]);
                return;
            } else {
                m6939e();
                C5179v.m19810a(this.f4120r, R.string.setting_profile_image_not_exist, 1);
                return;
            }
        }
        m6939e();
    }

    /* renamed from: g */
    private void m6942g() {
        if (!m6947b() || !m6948c()) {
            C4904y.m18634a("[deleteTempFolder] External Storage Is Not Available or Writable!", f4103b);
            if (this.f4119q == null) {
                this.f4119q = C5179v.m19811a(this.f4120r, getString(R.string.toast_sdcard_amount), 1);
            }
            this.f4119q.show();
            return;
        }
        String strM18501b = C4873ck.m18501b();
        if (strM18501b.length() == 0) {
            this.f4119q.show();
            return;
        }
        try {
            String[] list = new File(strM18501b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C4904y.m18639b("[Delete File] " + strM18501b + "/profile/" + str + " : " + new File(strM18501b + "/profile/" + str).delete(), f4103b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    protected boolean m6947b() {
        m6943h();
        return this.f4117o;
    }

    /* renamed from: c */
    protected boolean m6948c() {
        m6943h();
        return this.f4118p;
    }

    /* renamed from: a */
    public void m6945a(Bitmap bitmap, String str) throws ExecutionException, InterruptedException {
        try {
            C2496n.m10783c(GlobalApplication.m18732r(), str, bitmap).get();
        } catch (UnsupportedEncodingException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f4103b);
            }
        } catch (IOException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f4103b);
            }
        } catch (InterruptedException e3) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e3, f4103b);
            }
        } catch (ExecutionException e4) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e4, f4103b);
            }
        }
    }

    /* renamed from: h */
    private void m6943h() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f4117o = true;
            this.f4118p = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f4117o = true;
            this.f4118p = false;
        } else {
            this.f4117o = false;
            this.f4118p = false;
        }
    }
}
