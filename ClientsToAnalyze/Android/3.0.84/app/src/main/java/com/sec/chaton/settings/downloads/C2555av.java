package com.sec.chaton.settings.downloads;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.widget.AlertDialogC3256c;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: DownloadHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.av */
/* loaded from: classes.dex */
public class C2555av {
    /* renamed from: a */
    public static int m9488a(int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            return R.string.popup_no_network_connection;
        }
        return i;
    }

    /* renamed from: a */
    public static ProgressDialog m9489a(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(0);
        progressDialog.setMessage(context.getString(R.string.dialog_connecting_server));
        return progressDialog;
    }

    /* renamed from: b */
    public static AlertDialogC3256c m9490b(Context context) {
        AlertDialogC3256c alertDialogC3256c = new AlertDialogC3256c(context);
        alertDialogC3256c.setTitle(context.getString(R.string.settings_received_message));
        alertDialogC3256c.setMessage(context.getString(R.string.anicon_file_downloading));
        return alertDialogC3256c;
    }

    /* renamed from: c */
    public static AbstractC3271a m9491c(Context context) {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(context);
        abstractC3271aM11494a.mo11500a(context.getString(R.string.toast_error));
        abstractC3271aM11494a.mo11509b(context.getString(R.string.anicon_file_download_fail));
        abstractC3271aM11494a.mo11510b(context.getString(R.string.setting_selfsms_retry), (DialogInterface.OnClickListener) null);
        abstractC3271aM11494a.mo11501a(context.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null);
        return abstractC3271aM11494a;
    }

    /* renamed from: d */
    public static AbstractC3271a m9492d(Context context) {
        return AbstractC3271a.m11494a(context).mo11495a(R.string.anicon_package_uninstall).mo11509b(context.getString(R.string.poll_delete_msg)).mo11515d(R.string.dialog_ok, null).mo11507b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
    }

    /* renamed from: e */
    public static AbstractC3271a m9493e(Context context) {
        return AbstractC3271a.m11494a(context).mo11495a(R.string.download_title).mo11506b(R.string.setting_download_cancel_question).mo11515d(R.string.dialog_ok, null).mo11507b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
    }

    /* renamed from: f */
    public static AbstractC3271a m9494f(Context context) {
        return AbstractC3271a.m11494a(context).mo11495a(R.string.setting_download_all_title).mo11506b(R.string.setting_download_all_question).mo11515d(R.string.dialog_ok, null).mo11507b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
    }

    /* renamed from: g */
    public static Toast m9495g(Context context) {
        return C3641ai.m13210a(context, R.string.download_apply_success, 0);
    }

    /* renamed from: h */
    public static Toast m9496h(Context context) {
        return C3641ai.m13210a(context, R.string.download_apply_fail, 0);
    }

    /* renamed from: a */
    public static int m9487a() {
        return C2646u.m9642a() + C2591cd.m9580e() + C2642q.m9632a(EnumC1327e.Background) + C2642q.m9632a(EnumC1327e.Stamp) + C2642q.m9632a(EnumC1327e.Template) + C2570bj.m9509a() + C2620df.m9592a();
    }
}
