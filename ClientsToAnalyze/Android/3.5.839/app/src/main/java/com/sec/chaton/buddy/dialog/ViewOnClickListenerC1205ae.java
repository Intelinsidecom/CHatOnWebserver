package com.sec.chaton.buddy.dialog;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import com.sec.chaton.R;
import java.util.HashMap;

/* compiled from: MultipleExpandableDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC1205ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MultipleExpandableDialog f4700a;

    ViewOnClickListenerC1205ae(MultipleExpandableDialog multipleExpandableDialog) {
        this.f4700a = multipleExpandableDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2 /* 2131165822 */:
                if (Build.VERSION.SDK_INT < 11) {
                    if (this.f4700a.f4626A) {
                        Intent intent = new Intent();
                        HashMap map = new HashMap();
                        for (String str : this.f4700a.f4633t.m7499a().keySet()) {
                            map.put(this.f4700a.f4633t.m7499a().get(str), this.f4700a.f4634u.get(str));
                        }
                        intent.putExtra("KEY_SELECTED_RESULT_FOR_COMPOSER", map);
                        this.f4700a.setResult(-1, intent);
                        this.f4700a.finish();
                    } else {
                        this.f4700a.startActivity(this.f4700a.m7326f());
                    }
                }
                this.f4700a.finish();
                break;
            case R.id.button3 /* 2131165823 */:
                if (Build.VERSION.SDK_INT >= 11) {
                    if (this.f4700a.f4626A) {
                        Intent intent2 = new Intent();
                        HashMap map2 = new HashMap();
                        for (String str2 : this.f4700a.f4633t.m7499a().keySet()) {
                            map2.put(this.f4700a.f4633t.m7499a().get(str2), this.f4700a.f4634u.get(str2));
                        }
                        intent2.putExtra("KEY_SELECTED_RESULT_FOR_COMPOSER", map2);
                        this.f4700a.setResult(-1, intent2);
                        this.f4700a.finish();
                        break;
                    } else {
                        this.f4700a.startActivity(this.f4700a.m7326f());
                        this.f4700a.finish();
                        break;
                    }
                } else {
                    this.f4700a.finish();
                    break;
                }
        }
    }
}
