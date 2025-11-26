package com.p137vk.sdk.api;

import com.p137vk.sdk.api.methods.VKApiFriends;
import com.p137vk.sdk.api.methods.VKApiPhotos;
import com.p137vk.sdk.api.methods.VKApiUsers;
import com.p137vk.sdk.api.methods.VKApiWall;
import com.p137vk.sdk.api.photo.VKUploadAlbumPhotoRequest;
import com.p137vk.sdk.api.photo.VKUploadImage;
import com.p137vk.sdk.api.photo.VKUploadWallPhotoRequest;
import java.io.File;

/* loaded from: classes.dex */
public class VKApi {
    public static VKApiUsers users() {
        return new VKApiUsers();
    }

    public static VKApiFriends friends() {
        return new VKApiFriends();
    }

    public static VKApiWall wall() {
        return new VKApiWall();
    }

    public static VKApiPhotos photos() {
        return new VKApiPhotos();
    }

    public static VKRequest uploadWallPhotoRequest(File file, long j, int i) {
        return new VKUploadWallPhotoRequest(file, j, i);
    }

    public static VKRequest uploadWallPhotoRequest(VKUploadImage vKUploadImage, long j, int i) {
        return new VKUploadWallPhotoRequest(vKUploadImage, j, i);
    }

    public static VKRequest uploadAlbumPhotoRequest(File file, long j, int i) {
        return new VKUploadAlbumPhotoRequest(file, j, i);
    }

    public static VKRequest uploadAlbumPhotoRequest(VKUploadImage vKUploadImage, long j, int i) {
        return new VKUploadAlbumPhotoRequest(vKUploadImage, j, i);
    }
}
