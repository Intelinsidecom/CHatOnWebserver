package com.sec.common.actionbar;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ActionBarHelperBase.java */
/* renamed from: com.sec.common.actionbar.h */
/* loaded from: classes.dex */
final class C3291h extends MenuInflater {

    /* renamed from: a */
    final /* synthetic */ C3289f f11925a;

    /* renamed from: b */
    private MenuInflater f11926b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3291h(C3289f c3289f, Context context, MenuInflater menuInflater) {
        super(context);
        this.f11925a = c3289f;
        this.f11926b = menuInflater;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        List<Integer> listM11623a = m11623a(i);
        this.f11926b.inflate(i, menu);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < menu.size()) {
                MenuItemC3304u menuItemC3304u = (MenuItemC3304u) menu.getItem(i3);
                if (listM11623a.contains(Integer.valueOf(menuItemC3304u.getItemId()))) {
                    menuItemC3304u.m11645a(2);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private List<Integer> m11623a(int i) {
        int attributeResourceValue;
        int attributeIntValue;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        XmlResourceParser xml = null;
        try {
            try {
                xml = this.f11925a.f11915a.getResources().getXml(i);
                int eventType = xml.getEventType();
                while (!z) {
                    switch (eventType) {
                        case 1:
                            z = true;
                            break;
                        case 2:
                            if (!xml.getName().equals("item") || (attributeResourceValue = xml.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "id", 0)) == 0 || ((attributeIntValue = xml.getAttributeIntValue("http://schemas.android.com/apk/res/android", "showAsAction", -1)) != 2 && attributeIntValue != 1)) {
                                break;
                            } else {
                                arrayList.add(Integer.valueOf(attributeResourceValue));
                                break;
                            }
                    }
                    eventType = xml.next();
                }
                return arrayList;
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (xml != null) {
                xml.close();
            }
        }
    }
}
