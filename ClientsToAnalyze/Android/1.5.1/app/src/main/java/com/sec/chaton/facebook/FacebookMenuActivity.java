package com.sec.chaton.facebook;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.facebook.FacebookManager;

/* loaded from: classes.dex */
public class FacebookMenuActivity extends Activity {

    /* renamed from: a */
    private FacebookManager f1839a;

    /* renamed from: b */
    private View f1840b;

    /* renamed from: c */
    private View f1841c;

    /* renamed from: d */
    private View f1842d;

    /* renamed from: e */
    private int[] f1843e = {C0062R.drawable.facebook_invitation_card_town, C0062R.drawable.facebook_invitation_card_snackcar, C0062R.drawable.facebook_invitation_card_snackcar_s};

    /* renamed from: f */
    private int[] f1844f = {C0062R.drawable.facebook_invitation_card_town, C0062R.drawable.facebook_invitation_card_snackcar};

    /* renamed from: g */
    private View.OnClickListener f1845g = new ViewOnClickListenerC0225g(this);

    /* renamed from: h */
    private FacebookManager.OnResultListener f1846h = new C0220b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2357a() {
        new AlertDialog.Builder(this).setTitle(C0062R.string.logout).setMessage(C0062R.string.facebook_logout_q).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0223e(this)).setNegativeButton(C0062R.string.cancel, new DialogInterfaceOnClickListenerC0224f(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2358a(int i) {
        Toast.makeText(this, i, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2359a(int i, int i2, String str) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(i2);
        new AlertDialog.Builder(this).setTitle(C0062R.string.facebook_header_post).setView(imageView).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0221c(this, i, i2, str)).setNegativeButton(C0062R.string.cancel, new DialogInterfaceOnClickListenerC0222d(this)).show();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f1839a.m2352a(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_facebook_menu);
        this.f1840b = findViewById(C0062R.id.facebook_menu_invitation_card);
        this.f1840b.setOnClickListener(this.f1845g);
        this.f1841c = findViewById(C0062R.id.facebook_menu_chaton_family);
        this.f1841c.setOnClickListener(this.f1845g);
        this.f1842d = findViewById(C0062R.id.facebook_menu_logout);
        this.f1842d.setOnClickListener(this.f1845g);
        if (this.f1839a == null) {
            this.f1839a = new FacebookManager(this, this.f1846h);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage(getString(C0062R.string.facebook_post_wait));
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                return progressDialog;
            case 1:
                ProgressDialog progressDialog2 = new ProgressDialog(this);
                progressDialog2.setMessage(getString(C0062R.string.facebook_logout_wait));
                progressDialog2.setIndeterminate(true);
                progressDialog2.setCancelable(false);
                return progressDialog2;
            default:
                return null;
        }
    }
}
