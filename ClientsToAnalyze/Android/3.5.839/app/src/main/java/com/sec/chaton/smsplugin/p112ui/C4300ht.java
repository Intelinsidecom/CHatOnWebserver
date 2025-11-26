package com.sec.chaton.smsplugin.p112ui;

import android.content.ContentUris;
import android.content.Context;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3781b;
import com.sec.chaton.smsplugin.C3805c;
import com.sec.chaton.smsplugin.C3850f;
import com.sec.chaton.smsplugin.C3905j;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5094q;
import com.sec.google.android.p134a.p135a.C5097t;

/* compiled from: SlideEditorActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ht */
/* loaded from: classes.dex */
class C4300ht implements InterfaceC4158cm {

    /* renamed from: a */
    final /* synthetic */ SlideEditorActivity f15694a;

    C4300ht(SlideEditorActivity slideEditorActivity) {
        this.f15694a = slideEditorActivity;
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4158cm
    /* renamed from: a */
    public void mo16448a(C5094q c5094q, boolean z) {
        SlideEditorActivity slideEditorActivity = this.f15694a;
        if (c5094q == null) {
            Toast.makeText(this.f15694a, this.f15694a.m16192b(R.string.failed_to_add_all_media), 0).show();
            return;
        }
        try {
            this.f15694a.f15111j.m16489a(this.f15694a.f15114m, C5097t.m19426a(slideEditorActivity).m19445a(c5094q, ContentUris.parseId(this.f15694a.f15115n)));
            this.f15694a.m16186a(R.string.replace_image);
        } catch (C3781b e) {
            C4149cd.m16410a((Context) this.f15694a, this.f15694a.m16192b(R.string.exceed_message_size_limitation), this.f15694a.m16192b(R.string.failed_to_add_all_media));
        } catch (C3805c e2) {
            C4149cd.m16410a((Context) this.f15694a, this.f15694a.m16192b(R.string.exceed_message_size_limitation), this.f15694a.m16192b(R.string.failed_to_add_all_media));
        } catch (C3850f e3) {
            C4149cd.m16410a((Context) this.f15694a, this.f15694a.m16192b(R.string.failed_to_resize_image), this.f15694a.m16192b(R.string.resize_image_error_information));
        } catch (C3905j e4) {
            C4149cd.m16410a((Context) this.f15694a, this.f15694a.m16192b(R.string.unsupported_media_all_format), this.f15694a.m16192b(R.string.select_different_all_media));
        } catch (C5111c e5) {
            this.f15694a.m16189a("add picture failed");
            Toast.makeText(this.f15694a, this.f15694a.m16192b(R.string.failed_to_add_all_media), 0).show();
        }
    }
}
