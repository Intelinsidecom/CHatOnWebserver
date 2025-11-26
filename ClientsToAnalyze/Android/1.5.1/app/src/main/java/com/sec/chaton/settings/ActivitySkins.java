package com.sec.chaton.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.sec.chaton.C0062R;
import com.sec.chaton.settings.theme.Carousel;
import com.sec.chaton.settings.theme.CarouselAdapter;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class ActivitySkins extends FragmentActivity implements View.OnFocusChangeListener, ViewSwitcher.ViewFactory, CarouselAdapter.OnItemSelectedListener {

    /* renamed from: b */
    Context f3070b;

    /* renamed from: d */
    private TextSwitcher f3072d;

    /* renamed from: e */
    private String f3073e;

    /* renamed from: c */
    private SharedPreferences f3071c = null;

    /* renamed from: a */
    SharedPreferences.Editor f3069a = null;

    /* renamed from: f */
    private Integer[] f3074f = {Integer.valueOf(C0062R.string.settings_theme_item_1), Integer.valueOf(C0062R.string.settings_theme_item_2), Integer.valueOf(C0062R.string.settings_theme_item_3), Integer.valueOf(C0062R.string.settings_theme_item_4), Integer.valueOf(C0062R.string.settings_theme_item_5)};

    @Override // com.sec.chaton.settings.theme.CarouselAdapter.OnItemSelectedListener
    /* renamed from: a */
    public void mo3193a(CarouselAdapter carouselAdapter) {
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter.OnItemSelectedListener
    /* renamed from: a */
    public void mo3194a(CarouselAdapter carouselAdapter, View view, int i, long j) {
        ChatONLogWriter.m3506b("onItemSelected ::: Position = " + i + "::id =" + j, null);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        return new TextView(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3070b = this;
        setContentView(C0062R.layout.layout_setting_skins);
        Carousel carousel = (Carousel) findViewById(C0062R.id.carousel);
        carousel.setOnFocusChangeListener(this);
        carousel.setOnItemSelectedListener(this);
        this.f3071c = ChatONPref.m3519a();
        this.f3069a = this.f3071c.edit();
        this.f3073e = ChatONPref.m3519a().getString("Skin Style", "0");
        ChatONLogWriter.m3508c("SKIN_TYPE = " + this.f3073e, getClass().getSimpleName());
        carousel.setSelection(Integer.parseInt(this.f3073e));
        ((Button) findViewById(C0062R.id.btn_save_skin)).setOnClickListener(new ViewOnClickListenerC0461aj(this));
        this.f3072d = (TextSwitcher) findViewById(C0062R.id.theme_item_switcher);
        this.f3072d.setFactory(this);
        carousel.setOnItemClickListener(new C0462ak(this, carousel));
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        this.f3072d.setText("onFocusChange : Skin " + view.getId());
    }
}
