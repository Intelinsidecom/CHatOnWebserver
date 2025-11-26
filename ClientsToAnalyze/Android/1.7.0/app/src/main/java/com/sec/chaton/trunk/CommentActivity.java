package com.sec.chaton.trunk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C1341p;

@Deprecated
/* loaded from: classes.dex */
public class CommentActivity extends BaseSinglePaneActivity implements InterfaceC1107ae {

    /* renamed from: a */
    private static final String f3748a = CommentActivity.class.getSimpleName();

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.trunk_btn_comment);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new TrunkCommentView();
    }

    /* renamed from: a */
    public static void m3958a(Activity activity, int i, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra("sessionId", str);
        intent.putExtra("contentId", str2);
        intent.putExtra("filePath", str3);
        intent.putExtra("isShare", false);
        intent.setClass(activity, CommentActivity.class);
        activity.startActivityForResult(intent, i);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1107ae
    /* renamed from: b */
    public void mo3959b() {
        if (C1341p.f4578b) {
            C1341p.m4658b("CommentActivity.onAddCommentCompleted()", f3748a);
        }
        setResult(-1);
        finish();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1107ae
    /* renamed from: c */
    public void mo3960c() {
        if (C1341p.f4578b) {
            C1341p.m4658b("CommentActivity.onCanceled()", f3748a);
        }
        setResult(0);
        finish();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1107ae
    /* renamed from: d */
    public void mo3961d() {
        if (C1341p.f4578b) {
            C1341p.m4658b("CommentActivity.onTrunkItemDeleted()", f3748a);
        }
        TrunkActivity.m3970a(this);
    }
}
