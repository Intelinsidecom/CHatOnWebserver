package com.sec.chaton.sharedialog;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShareDialog.java */
/* renamed from: com.sec.chaton.sharedialog.d */
/* loaded from: classes.dex */
public class DialogC3696d extends Dialog {

    /* renamed from: a */
    List<String> f13311a;

    /* renamed from: b */
    private Context f13312b;

    /* renamed from: c */
    private ArrayList<C3695c> f13313c;

    /* renamed from: d */
    private C3698f f13314d;

    /* renamed from: e */
    private SharedPreferences f13315e;

    /* renamed from: f */
    private SharedPreferences.Editor f13316f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC3696d(Context context, ArrayList<C3695c> arrayList) {
        super(context, R.style.AppTheme_Dialog);
        this.f13311a = new ArrayList();
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f13312b = context;
        this.f13313c = arrayList;
        this.f13315e = context.getSharedPreferences("custom share preference", 0);
        this.f13316f = this.f13315e.edit();
        for (int i = 0; i < ShareActivity.f13294a.length; i++) {
            this.f13311a.add(ShareActivity.f13294a[i]);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m13963a();
    }

    /* renamed from: a */
    private void m13963a() {
        setContentView(R.layout.layout_share_dialog);
        GridView gridView = (GridView) findViewById(R.id.gridViewMenu);
        if (this.f13313c != null) {
            this.f13314d = new C3698f(this.f13313c, this.f13312b);
        }
        gridView.invalidateViews();
        gridView.setAdapter((ListAdapter) this.f13314d);
        gridView.setOnItemClickListener(new C3697e(this));
    }
}
