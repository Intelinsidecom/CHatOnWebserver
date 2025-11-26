package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber;
import com.sec.chaton.p061g.C2344c;
import com.sec.chaton.util.C4822an;
import com.sec.google.android.p134a.C5111c;
import java.util.ArrayList;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ej */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4209ej implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String[] f15554a;

    /* renamed from: b */
    final /* synthetic */ PluginComposeMessageActivity f15555b;

    DialogInterfaceOnClickListenerC4209ej(PluginComposeMessageActivity pluginComposeMessageActivity, String[] strArr) {
        this.f15555b = pluginComposeMessageActivity;
        this.f15554a = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        for (String str : this.f15554a) {
            try {
                Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(str, C4822an.m18236g().toUpperCase());
                arrayList.add(String.valueOf(phoneNumber.getCountryCode()));
                arrayList2.add(String.valueOf(phoneNumber.getNationalNumber()));
            } catch (NumberParseException e) {
                e.printStackTrace();
            }
        }
        if (arrayList.size() > 0 && arrayList2.size() > 0) {
            try {
                new C2344c(this.f15555b, (String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), new HandlerC4257gd(this.f15555b)).m10266a();
            } catch (C5111c e2) {
                e2.printStackTrace();
            }
        }
    }
}
