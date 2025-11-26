package com.sec.vip.amschaton.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C3223ck;
import com.sec.common.CommonApplication;
import com.sec.vip.amschaton.AMSFileListActivity;
import com.sec.vip.amschaton.BaseAMSActivity;
import com.sec.vip.amschaton.C3410al;
import com.sec.widget.C3641ai;
import java.io.File;

/* loaded from: classes.dex */
public class AMSFragment extends Fragment {

    /* renamed from: a */
    private static Toast f12712a;

    /* renamed from: d */
    public static String f12713d;

    /* renamed from: e */
    public static String f12714e;

    /* renamed from: f */
    public static String f12715f;

    /* renamed from: g */
    public static String f12716g;

    /* renamed from: h */
    public static String f12717h;

    /* renamed from: i */
    public static String f12718i;

    /* renamed from: j */
    public static String f12719j;

    /* renamed from: k */
    public static String f12720k;

    /* renamed from: l */
    public static String f12721l;

    static {
        f12713d = (C3223ck.m11327a() ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath()) + "/AMS/";
        f12714e = f12713d + "amsbasicfiles/";
        f12715f = f12713d + "amsuserfiles/";
        f12716g = f12713d + "amssentfiles/";
        f12717h = f12713d + "userstamp/";
        f12718i = f12713d + "temp/";
        f12719j = f12718i + "justTempAMS.jpg";
        f12720k = f12718i + "justTempImage.jpg";
        f12721l = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON/";
        new File(f12713d).mkdirs();
        new File(f12714e).mkdirs();
        new File(f12715f).mkdirs();
        new File(f12716g).mkdirs();
        new File(f12717h).mkdirs();
        new File(f12718i).mkdirs();
        new File(f12721l).mkdirs();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m12523a();
    }

    /* renamed from: a */
    private void m12523a() {
        if (C3410al.m12173a().m12201g() == 0) {
            C3410al.m12173a().m12184a(getActivity(), getActivity().getAssets(), f12717h);
        }
    }

    /* renamed from: a */
    protected void m12524a(int i) {
        if (f12712a == null) {
            f12712a = C3641ai.m13210a(getActivity(), i, 0);
        }
        f12712a.setText(i);
        f12712a.show();
    }

    /* renamed from: a */
    protected void m12525a(String str, int i) {
        Intent intent = new Intent(getActivity(), (Class<?>) BaseAMSActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("AMS_ACTION", 1);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_FILE_TYPE", i);
        intent.putExtra("AMS_DIRECT_PLAY", true);
        ((BaseActivity) getActivity()).mo3084a(intent);
    }

    /* renamed from: b */
    protected void m12528b(String str, int i) {
        Intent intent = new Intent(getActivity(), (Class<?>) BaseAMSActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("AMS_ACTION", 2);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_FILE_TYPE", i);
        intent.putExtra("AMS_DIRECT_PLAY", true);
        ((BaseActivity) getActivity()).mo3084a(intent);
    }

    /* renamed from: d */
    protected void m12529d() {
        Intent intent = new Intent(getActivity(), (Class<?>) BaseAMSActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("AMS_ACTION", 0);
        ((BaseActivity) getActivity()).mo3084a(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public void mo12415c() {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseAMSActivity) {
            Intent intent = new Intent(activity, (Class<?>) BaseAMSActivity.class);
            intent.addFlags(536870912);
            intent.addFlags(67108864);
            intent.putExtra("AMS_ACTION", 5);
            ((BaseActivity) activity).mo3084a(intent);
            return;
        }
        ((InterfaceC3474av) activity).mo11978c();
    }

    /* renamed from: a */
    protected void m12527a(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        Intent intent = new Intent(getActivity(), (Class<?>) BaseAMSActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("AMS_ACTION", 3);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_SAVE_FILE", z);
        intent.putExtra("AMS_SAVE_FLAG", z);
        intent.putExtra("AMS_EDIT_FLAG", z2);
        intent.putExtra("AMS_PEN_STATE_DEFAULT", z4);
        intent.putExtra("AMS_FROM_PLAYER", z3);
        ((BaseActivity) getActivity()).mo3084a(intent);
    }

    /* renamed from: a */
    protected void m12526a(String str, String str2, int i, int i2) {
        Intent intent = new Intent(getActivity(), (Class<?>) AMSFileListActivity.class);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.putExtra("ACTION", 2005);
        intent.putExtra("AMS_FILE_PATH", str);
        intent.putExtra("AMS_FILE_TYPE", i);
        intent.putExtra("IMG_FILE_PATH", str2);
        intent.putExtra("AMS_SEND_METHOD", i2);
        startActivity(intent);
        ((InterfaceC3474av) getActivity()).mo11978c();
    }
}
