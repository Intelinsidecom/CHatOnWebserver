package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;

/* compiled from: CursorFilter.java */
/* renamed from: android.support.v4.widget.g */
/* loaded from: classes.dex */
class C0247g extends Filter {

    /* renamed from: a */
    InterfaceC0248h f588a;

    C0247g(InterfaceC0248h interfaceC0248h) {
        this.f588a = interfaceC0248h;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f588a.mo880c((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorMo872a = this.f588a.mo872a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorMo872a != null) {
            filterResults.count = cursorMo872a.getCount();
            filterResults.values = cursorMo872a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorMo871a = this.f588a.mo871a();
        if (filterResults.values != null && filterResults.values != cursorMo871a) {
            this.f588a.mo875a((Cursor) filterResults.values);
        }
    }
}
