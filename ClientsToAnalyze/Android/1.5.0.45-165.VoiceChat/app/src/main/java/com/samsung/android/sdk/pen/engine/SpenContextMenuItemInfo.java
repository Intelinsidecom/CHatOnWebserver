package com.samsung.android.sdk.pen.engine;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class SpenContextMenuItemInfo {
    public Drawable drawableBackgroundNormal;
    public Drawable drawableBackgroundPressed;
    public Drawable drawableDisableItem;
    public Drawable drawableNormalItem;
    public boolean enable;

    /* renamed from: id */
    public int f393id;
    public String name;

    public SpenContextMenuItemInfo() {
        this.f393id = -1;
        this.name = null;
        this.drawableNormalItem = null;
        this.drawableDisableItem = null;
        this.drawableBackgroundNormal = null;
        this.drawableBackgroundPressed = null;
        this.enable = true;
    }

    public SpenContextMenuItemInfo(int id, String name, boolean enable) {
        this.f393id = -1;
        this.name = null;
        this.drawableNormalItem = null;
        this.drawableDisableItem = null;
        this.drawableBackgroundNormal = null;
        this.drawableBackgroundPressed = null;
        this.enable = true;
        this.f393id = id;
        this.name = name;
        this.enable = enable;
    }

    public SpenContextMenuItemInfo(int id, Drawable drawableItem, String name, boolean enable) {
        this.f393id = -1;
        this.name = null;
        this.drawableNormalItem = null;
        this.drawableDisableItem = null;
        this.drawableBackgroundNormal = null;
        this.drawableBackgroundPressed = null;
        this.enable = true;
        this.f393id = id;
        this.drawableNormalItem = drawableItem;
        this.name = name;
        this.enable = enable;
    }

    public SpenContextMenuItemInfo(int id, Drawable drawableItem, Drawable drawableBackgroundNormal, Drawable drawableBackgroundPressed, String name, boolean enable) {
        this.f393id = -1;
        this.name = null;
        this.drawableNormalItem = null;
        this.drawableDisableItem = null;
        this.drawableBackgroundNormal = null;
        this.drawableBackgroundPressed = null;
        this.enable = true;
        this.f393id = id;
        this.drawableNormalItem = drawableItem;
        this.drawableBackgroundNormal = drawableBackgroundNormal;
        this.drawableBackgroundPressed = drawableBackgroundPressed;
        this.name = name;
        this.enable = enable;
    }

    public SpenContextMenuItemInfo(int id, Drawable drawableNormalItem, Drawable drawableDisableItem, Drawable drawableBackgroundNormal, Drawable drawableBackgroundPressed, String name, boolean enable) {
        this.f393id = -1;
        this.name = null;
        this.drawableNormalItem = null;
        this.drawableDisableItem = null;
        this.drawableBackgroundNormal = null;
        this.drawableBackgroundPressed = null;
        this.enable = true;
        this.f393id = id;
        this.drawableNormalItem = drawableNormalItem;
        this.drawableDisableItem = drawableDisableItem;
        this.drawableBackgroundNormal = drawableBackgroundNormal;
        this.drawableBackgroundPressed = drawableBackgroundPressed;
        this.name = name;
        this.enable = enable;
    }
}
