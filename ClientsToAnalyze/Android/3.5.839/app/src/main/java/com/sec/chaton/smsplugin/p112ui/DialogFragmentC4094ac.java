package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p111h.C3878ac;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3897t;

/* compiled from: LinkActionChooserFragment.java */
@TargetApi(14)
/* renamed from: com.sec.chaton.smsplugin.ui.ac */
/* loaded from: classes.dex */
public class DialogFragmentC4094ac extends DialogFragment implements DialogInterface.OnClickListener {

    /* renamed from: a */
    static final AbstractC4102ak f15217a = new C4103al(R.string.send_email);

    /* renamed from: b */
    static final AbstractC4102ak f15218b = new C4103al(R.string.open_url);

    /* renamed from: c */
    static final AbstractC4102ak f15219c = new C4096ae(R.string.menu_call);

    /* renamed from: d */
    static final AbstractC4102ak f15220d = new C4097af(R.string.add_to_bookmark);

    /* renamed from: e */
    static final AbstractC4102ak f15221e = new C4098ag(R.string.copy_message_text);

    /* renamed from: f */
    static final AbstractC4102ak f15222f = new C4099ah(R.string.add_to_contact);

    /* renamed from: g */
    static final AbstractC4102ak f15223g = new C4100ai(R.string.menu_view_contact);

    /* renamed from: h */
    static final AbstractC4102ak f15224h = new C4101aj(R.string.send_message);

    /* renamed from: i */
    private String f15225i;

    /* renamed from: j */
    private String f15226j;

    /* renamed from: k */
    private ArrayAdapter<AbstractC4102ak> f15227k;

    /* renamed from: l */
    private CheckBox f15228l;

    /* renamed from: a */
    public static final DialogFragment m16291a(String str, String str2) {
        DialogFragmentC4094ac dialogFragmentC4094ac = new DialogFragmentC4094ac();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("text", str2);
        dialogFragmentC4094ac.setArguments(bundle);
        return dialogFragmentC4094ac;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = Bundle.EMPTY;
        }
        this.f15225i = arguments.getString("url", "");
        this.f15226j = arguments.getString("text", "");
        this.f15227k = new ArrayAdapter<>(getActivity(), R.layout.msg_select_dialog_item, R.id.msg_select_dialog_text);
        if (this.f15225i.startsWith("mailto:")) {
            this.f15227k.add(f15217a);
            if (C3847e.m14696b() || C3847e.m14705k() != null) {
            }
            C3782a.m14210a();
            C3782a c3782aM14204a = C3782a.m14204a(this.f15226j, true);
            if (c3782aM14204a.m14271m()) {
                this.f15227k.add(f15223g);
            } else if (C4149cd.m16416a(c3782aM14204a)) {
                this.f15227k.add(f15222f);
            }
        } else if (this.f15225i.startsWith("tel:")) {
            if (C3878ac.m14957a(getActivity())) {
                this.f15227k.add(f15219c);
            }
            C3782a.m14210a();
            C3782a c3782aM14204a2 = C3782a.m14204a(this.f15226j, true);
            if (c3782aM14204a2.m14271m()) {
                this.f15227k.add(f15223g);
            } else if (C4149cd.m16416a(c3782aM14204a2) || C4149cd.m16446o(this.f15226j)) {
                this.f15227k.add(f15222f);
            }
        } else {
            this.f15227k.add(f15218b);
            if (!this.f15225i.startsWith("rtsp://") && (C3897t.m15051a(GlobalApplication.m10279a(), "com.android.browser") || C3897t.m15051a(GlobalApplication.m10279a(), "com.sec.android.app.sbrowser"))) {
                this.f15227k.add(f15220d);
            }
        }
        this.f15227k.add(f15221e);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getActivity()).setTitle(this.f15226j).setAdapter(this.f15227k, this).create();
        alertDialogCreate.setCanceledOnTouchOutside(true);
        alertDialogCreate.setOnKeyListener(C4149cd.f15442c);
        return alertDialogCreate;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AbstractC4102ak item = this.f15227k.getItem(i);
        if (item != null) {
            if (C3847e.m14685aq()) {
                if (item.equals(f15218b)) {
                    Boolean bool = true;
                    C3890m.m14996b("Mms/LinkActionChooserFragment", "Unknown URL Link Setting : " + bool);
                    if (bool.booleanValue()) {
                        item.mo16294a(getActivity(), this.f15225i, this.f15226j);
                        return;
                    }
                    m16293a(new DialogInterfaceOnClickListenerC4095ad(this, item, getActivity(), this.f15225i, this.f15226j));
                    return;
                }
                item.mo16294a(getActivity(), this.f15225i, this.f15226j);
                return;
            }
            item.mo16294a(getActivity(), this.f15225i, this.f15226j);
        }
    }

    /* renamed from: a */
    private void m16293a(DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.unknown_url_link_popup_title);
        builder.setCancelable(true);
        builder.setPositiveButton(R.string.yes, onClickListener);
        builder.setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null);
        View viewInflate = View.inflate(getActivity(), R.layout.unknown_urllink_dialog_view, null);
        this.f15228l = (CheckBox) viewInflate.findViewById(R.id.delete_locked);
        builder.setView(viewInflate);
        builder.show();
    }
}
