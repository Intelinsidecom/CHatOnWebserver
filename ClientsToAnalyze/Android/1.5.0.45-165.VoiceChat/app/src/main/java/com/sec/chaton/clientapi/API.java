package com.sec.chaton.clientapi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface API {
    String description() default "";

    int versionCode();
}
