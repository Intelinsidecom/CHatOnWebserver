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
import com.sec.chaton.multimedia.image.ViewOnTouchListenerC1868as;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
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
public class GroupProfileImageViewFragment extends Fragment {

    /* renamed from: b */
    public static final String f2245b = GroupProfileImageViewFragment.class.getSimpleName();

    /* renamed from: c */
    private ImageView f2247c;

    /* renamed from: d */
    private Uri f2248d;

    /* renamed from: g */
    private int f2251g;

    /* renamed from: h */
    private String f2252h;

    /* renamed from: j */
    private ViewOnTouchListenerC1868as f2254j;

    /* renamed from: k */
    private ViewTreeObserver.OnGlobalLayoutListener f2255k;

    /* renamed from: m */
    private File f2257m;

    /* renamed from: q */
    private Toast f2261q;

    /* renamed from: r */
    private Activity f2262r;

    /* renamed from: s */
    private LinearLayout f2263s;

    /* renamed from: e */
    private final int f2249e = 5;

    /* renamed from: f */
    private final int f2250f = 6;

    /* renamed from: a */
    String f2246a = C3223ck.m11328b();

    /* renamed from: i */
    private File f2253i = new File(this.f2246a + "/profile/");

    /* renamed from: l */
    private File f2256l = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile();

    /* renamed from: n */
    private String f2258n = "";

    /* renamed from: o */
    private boolean f2259o = false;

    /* renamed from: p */
    private boolean f2260p = false;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f2262r = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f2262r = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2262r.setTitle(getString(R.string.profile_image_photo));
        setHasOptionsMenu(true);
        if (bundle == null) {
            this.f2248d = null;
            return;
        }
        String string = bundle.getString("CAPTURE_IMAGE_URI");
        if (!TextUtils.isEmpty(string)) {
            this.f2248d = Uri.parse(string);
        }
        String string2 = bundle.getString("PROFILE_IMAGE_TEMP_FILE_URI");
        if (!TextUtils.isEmpty(string2)) {
            this.f2257m = new File(string2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_group_profile_image_view, viewGroup, false);
        this.f2263s = (LinearLayout) viewInflate.findViewById(R.id.layout_profile_image_title);
        this.f2263s.setVisibility(8);
        this.f2247c = (ImageView) viewInflate.findViewById(R.id.profile_big_image);
        this.f2254j = new ViewOnTouchListenerC1868as();
        this.f2247c.setOnTouchListener(this.f2254j);
        this.f2251g = this.f2262r.getIntent().getExtras().getInt("GROUP_PROFILE_ID");
        this.f2252h = this.f2262r.getIntent().getExtras().getString("GROUP_PROFILE_NAME");
        m3843d();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f2247c != null) {
            ViewTreeObserver viewTreeObserver = this.f2247c.getViewTreeObserver();
            this.f2255k = new ViewTreeObserverOnGlobalLayoutListenerC0750hg(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f2255k);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f2247c != null) {
            this.f2247c.getViewTreeObserver().removeGlobalOnLayoutListener(this.f2255k);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        C3250y.m11458g("onCreateOptionsMenu()", f2245b);
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.group_image_page_menu, menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IOException {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.group_image_page_edit_menu /* 2131166612 */:
                m3850a();
                break;
        }
        return true;
    }

    /* renamed from: d */
    private void m3843d() {
        m3847f();
    }

    /* renamed from: a */
    public boolean m3852a(String str) {
        File file = new File(this.f2256l, str + "_group_profile.png_");
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m3850a() throws IOException {
        int i;
        int i2;
        int i3;
        try {
            if (!this.f2253i.canRead()) {
                this.f2253i.mkdirs();
            }
            m3848g();
            this.f2258n = "tmp_" + System.currentTimeMillis() + ".jpeg_";
            this.f2257m = new File(this.f2253i + "/", this.f2258n);
            C3250y.m11450b("[Create File] " + this.f2253i.toString() + this.f2258n + " : " + this.f2257m.createNewFile(), f2245b);
            this.f2248d = Uri.fromFile(this.f2257m);
            if (!m3853b() || !m3854c()) {
                if (this.f2261q == null) {
                    this.f2261q = C3641ai.m13211a(this.f2262r, getString(R.string.toast_sdcard_amount), 1);
                }
                this.f2261q.show();
                return;
            }
            boolean z = false;
            if (m3852a(this.f2252h)) {
                if (C3171am.m11077o()) {
                    i3 = R.array.groupimage_context;
                } else {
                    i3 = R.array.selphoto_first_nocamera;
                }
                i2 = R.string.ams_add_frame_title;
                i = i3;
                z = true;
            } else {
                i = R.array.selphoto_first;
                i2 = R.string.mypage_profile_add_photo;
            }
            AbstractC3271a abstractC3271aMo11497a = AbstractC3271a.m11494a(this.f2262r).mo11495a(i2).mo11497a(i, new DialogInterfaceOnClickListenerC0751hh(this));
            if (z) {
                abstractC3271aMo11497a.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0752hi(this));
            }
            abstractC3271aMo11497a.mo11505a().show();
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
                        C3250y.m11442a("Crop return null!", f2245b);
                        break;
                    } else {
                        try {
                            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(C3162ad.m11012b(this.f2262r, Uri.parse(intent.getExtras().getString("temp_file_path")), 600), 600, 600, true);
                            C3020a.m10525a(file, this.f2257m);
                            this.f2247c.setImageBitmap(bitmapCreateScaledBitmap);
                            m3851a(bitmapCreateScaledBitmap, this.f2252h);
                            this.f2262r.finish();
                            break;
                        } catch (Exception e) {
                            C3250y.m11443a(e, getClass().getSimpleName());
                            m3845e();
                            return;
                        }
                    }
                }
                break;
            case 5:
                if (intent == null) {
                    C3250y.m11450b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    this.f2248d = intent.getData();
                    Intent intent2 = new Intent(this.f2262r, (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f2248d, "image/*");
                    intent2.putExtra("outputX", 600);
                    intent2.putExtra("outputY", 600);
                    intent2.putExtra("aspectX", 1);
                    intent2.putExtra("aspectY", 1);
                    intent2.putExtra("return-data", true);
                    intent2.putExtra("groupname", this.f2252h);
                    intent2.putExtra("isgroup", true);
                    startActivityForResult(intent2, 3);
                    break;
                }
            case 6:
                if (i2 == -1) {
                    Intent intent3 = new Intent(this.f2262r, (Class<?>) ImageModify.class);
                    intent3.setDataAndType(this.f2248d, "image/*");
                    intent3.putExtra("outputX", 600);
                    intent3.putExtra("outputY", 600);
                    intent3.putExtra("aspectX", 1);
                    intent3.putExtra("aspectY", 1);
                    intent3.putExtra("return-data", true);
                    intent3.putExtra("groupname", this.f2252h);
                    intent3.putExtra("isgroup", true);
                    startActivityForResult(intent3, 3);
                    break;
                } else {
                    C3250y.m11450b("Camera Return is NULL", getClass().getSimpleName());
                    break;
                }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f2248d != null) {
            bundle.putString("CAPTURE_IMAGE_URI", this.f2248d.toString());
        }
        if (this.f2257m != null) {
            bundle.putString("PROFILE_IMAGE_TEMP_FILE_URI", this.f2257m.toString());
        }
    }

    /* renamed from: e */
    private void m3845e() {
        try {
            this.f2247c.setImageResource(R.drawable.contacts_default_group);
            m3850a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    private void m3847f() {
        C3250y.m11456e("UserProfile initialize() - img status: " + C3159aa.m10962a().m10979a("profile_image_status", ""), getClass().getSimpleName());
        try {
            this.f2252h = URLEncoder.encode(this.f2252h, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
        if (m3852a(this.f2252h)) {
            File file = new File(this.f2256l, this.f2252h + "_group_profile.png_");
            C3250y.m11450b("photoFile=" + file, getClass().getSimpleName());
            if (file.exists()) {
                new AsyncTaskC0753hj(this, file).execute(new Void[0]);
                return;
            } else {
                m3845e();
                C3641ai.m13210a(this.f2262r, R.string.setting_profile_image_not_exist, 1);
                return;
            }
        }
        m3845e();
    }

    /* renamed from: g */
    private void m3848g() {
        if (!m3853b() || !m3854c()) {
            C3250y.m11442a("[deleteTempFolder] External Storage Is Not Available or Writable!", f2245b);
            if (this.f2261q == null) {
                this.f2261q = C3641ai.m13211a(this.f2262r, getString(R.string.toast_sdcard_amount), 1);
            }
            this.f2261q.show();
            return;
        }
        String strM11328b = C3223ck.m11328b();
        if (strM11328b.length() == 0) {
            this.f2261q.show();
            return;
        }
        try {
            String[] list = new File(strM11328b + "/profile/").list();
            if (list != null) {
                for (String str : list) {
                    C3250y.m11450b("[Delete File] " + strM11328b + "/profile/" + str + " : " + new File(strM11328b + "/profile/" + str).delete(), f2245b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    protected boolean m3853b() {
        m3849h();
        return this.f2259o;
    }

    /* renamed from: c */
    protected boolean m3854c() {
        m3849h();
        return this.f2260p;
    }

    /* renamed from: a */
    public void m3851a(Bitmap bitmap, String str) throws IOException {
        String simpleName;
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = CommonApplication.m11493l().openFileOutput(str + "_group_profile.png_", 0);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                C3205bt.m11182a(this.f2262r).m11219a(str, false);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e) {
                        e = e;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            } catch (FileNotFoundException e2) {
                C3250y.m11443a(e2, getClass().getSimpleName());
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e3) {
                        e = e3;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e4) {
                    C3250y.m11443a(e4, getClass().getSimpleName());
                }
            }
            throw th;
        }
    }

    /* renamed from: h */
    private void m3849h() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f2259o = true;
            this.f2260p = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f2259o = true;
            this.f2260p = false;
        } else {
            this.f2259o = false;
            this.f2260p = false;
        }
    }
}
