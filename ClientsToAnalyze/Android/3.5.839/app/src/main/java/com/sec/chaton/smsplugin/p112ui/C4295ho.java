package com.sec.chaton.smsplugin.p112ui;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.SearchRecentSuggestions;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: SearchActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ho */
/* loaded from: classes.dex */
class C4295ho extends AsyncQueryHandler {

    /* renamed from: a */
    final /* synthetic */ String f15681a;

    /* renamed from: b */
    final /* synthetic */ ListView f15682b;

    /* renamed from: c */
    final /* synthetic */ SearchActivity f15683c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4295ho(SearchActivity searchActivity, ContentResolver contentResolver, String str, ListView listView) {
        super(contentResolver);
        this.f15683c = searchActivity;
        this.f15681a = str;
        this.f15682b = listView;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        SearchRecentSuggestions searchRecentSuggestionsM10296k;
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("thread_id");
            int columnIndex2 = cursor.getColumnIndex("address");
            int columnIndex3 = cursor.getColumnIndex("body");
            int columnIndex4 = cursor.getColumnIndex("_id");
            int count = cursor.getCount();
            this.f15683c.setTitle(this.f15683c.getResources().getQuantityString(R.plurals.search_results_title, count, Integer.valueOf(count), this.f15681a));
            this.f15683c.setListAdapter(new C4296hp(this, this.f15683c, cursor, false, columnIndex2, columnIndex3, columnIndex, columnIndex4));
            this.f15682b.setFocusable(true);
            this.f15682b.setFocusableInTouchMode(true);
            this.f15682b.requestFocus();
            if (count > 0 && (searchRecentSuggestionsM10296k = GlobalApplication.m10279a().m10296k()) != null) {
                searchRecentSuggestionsM10296k.saveRecentQuery(this.f15681a, this.f15683c.getString(R.string.search_history, new Object[]{Integer.valueOf(count), this.f15681a}));
            }
        }
    }
}
