package com.sec.common.actionbar;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ActionBarHelperBase.java */
/* renamed from: com.sec.common.actionbar.h */
/* loaded from: classes.dex */
final class C4953h extends MenuInflater {

    /* renamed from: a */
    final /* synthetic */ C4951f f18123a;

    /* renamed from: b */
    private MenuInflater f18124b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4953h(C4951f c4951f, Context context, MenuInflater menuInflater) {
        super(context);
        this.f18123a = c4951f;
        this.f18124b = menuInflater;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        List<Integer> listM18862a = m18862a(i);
        this.f18124b.inflate(i, menu);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < menu.size()) {
                MenuItem item = menu.getItem(i3);
                if (listM18862a.contains(Integer.valueOf(item.getItemId()))) {
                    ((MenuItemC4966u) item).m18884a(2);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private List<Integer> m18862a(int i) {
        int attributeResourceValue;
        int attributeIntValue;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser xml = this.f18123a.f18113a.getResources().getXml(i);
                if (xml == null) {
                    throw new InflateException("Error inflating menu XML");
                }
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
                            break;
                    }
                    eventType = xml.next();
                }
                if (xml != null) {
                    xml.close();
                }
                return arrayList;
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
