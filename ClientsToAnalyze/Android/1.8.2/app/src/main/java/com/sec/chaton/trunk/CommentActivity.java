package com.sec.chaton.trunk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class CommentActivity extends BaseSinglePaneActivity implements InterfaceC1520af {

    /* renamed from: a */
    private static final String f5430a = CommentActivity.class.getSimpleName();

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.trunk_btn_comment);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        return new TrunkCommentView();
    }

    /* renamed from: a */
    public static void m5216a(Activity activity, int i, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra("sessionId", str);
        intent.putExtra("contentId", str2);
        intent.putExtra("filePath", str3);
        intent.putExtra("isShare", false);
        intent.setClass(activity, CommentActivity.class);
        activity.startActivityForResult(intent, i);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1520af
    /* renamed from: c */
    public void mo5217c() {
        if (C1786r.f6452b) {
            C1786r.m6061b("CommentActivity.onAddCommentCompleted()", f5430a);
        }
        setResult(-1);
        finish();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1520af
    /* renamed from: d */
    public void mo5218d() {
        if (C1786r.f6452b) {
            C1786r.m6061b("CommentActivity.onCanceled()", f5430a);
        }
        setResult(0);
        finish();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1520af
    /* renamed from: e */
    public void mo5219e() {
        if (C1786r.f6452b) {
            C1786r.m6061b("CommentActivity.onTrunkItemDeleted()", f5430a);
        }
        TrunkActivity.m5231a(this);
    }
}
