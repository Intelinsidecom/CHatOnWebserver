package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber;
import com.sec.chaton.p061g.C2344c;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4822an;
import com.sec.google.android.p134a.C5111c;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1781i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f6684a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f6685b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f6686c;

    DialogInterfaceOnClickListenerC1781i(ChatFragment chatFragment, ArrayList arrayList, ArrayList arrayList2) {
        this.f6686c = chatFragment;
        this.f6684a = arrayList;
        this.f6685b = arrayList2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ArrayList arrayList = new ArrayList();
        this.f6686c.f5589be.addAll(this.f6684a);
        if (this.f6686c.f5590bf != null) {
            this.f6686c.f5590bf.clear();
        }
        this.f6686c.f5590bf.addAll(this.f6685b);
        arrayList.addAll(this.f6685b);
        if (C3847e.m14691aw()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse((String) it.next(), C4822an.m18236g().toUpperCase());
                    arrayList2.add(String.valueOf(phoneNumber.getCountryCode()));
                    arrayList3.add(String.valueOf(phoneNumber.getNationalNumber()));
                } catch (NumberParseException e) {
                    e.printStackTrace();
                }
            }
            if (arrayList2.size() > 0 && arrayList3.size() > 0) {
                try {
                    new C2344c(this.f6686c.f5624cN, (String[]) arrayList2.toArray(new String[0]), (String[]) arrayList3.toArray(new String[0]), new HandlerC1666dt(this.f6686c)).m10266a();
                    return;
                } catch (C5111c e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        this.f6686c.m8274s();
        this.f6686c.f5734em.m9377a(arrayList, EnumC2463n.UI);
    }
}
