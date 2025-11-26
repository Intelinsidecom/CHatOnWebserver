package com.sec.chaton.trunk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.p053e.EnumC1599h;

/* loaded from: classes.dex */
public class TrunkActivity extends BaseSinglePaneActivity implements InterfaceC1566bo {

    /* renamed from: a */
    private static final String f5432a = TrunkActivity.class.getSimpleName();

    /* renamed from: b */
    private static String f5433b = "sessionId";

    /* renamed from: c */
    private static String f5434c = "inboxNO";

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(5);
        setTitle(R.string.trunk_title);
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        return new TrunkView();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (findViewById(R.id.base_divider) != null) {
            findViewById(R.id.base_divider).setVisibility(0);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1566bo
    /* renamed from: a */
    public void mo5232a(String str, String str2, String str3, String str4, EnumC1599h enumC1599h) {
        ContentActivity.m5220a(this, str, str2, str3, str4, enumC1599h);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1566bo
    /* renamed from: c_ */
    public void mo5233c_() {
        finish();
    }

    /* renamed from: a */
    public static void m5231a(Context context) {
        Intent intent = new Intent();
        intent.setClass(GlobalApplication.m3256a(), TrunkActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        context.startActivity(intent);
    }
}
