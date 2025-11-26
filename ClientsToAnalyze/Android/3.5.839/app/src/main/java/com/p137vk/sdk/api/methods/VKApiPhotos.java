package com.p137vk.sdk.api.methods;

import com.p137vk.sdk.api.VKApiConst;
import com.p137vk.sdk.api.VKParameters;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.model.VKPhotoArray;
import com.p137vk.sdk.util.VKUtil;

/* loaded from: classes.dex */
public class VKApiPhotos extends VKApiBase {
    public VKRequest getUploadServer(long j) {
        return prepareRequest("getUploadServer", VKUtil.paramsFrom(VKApiConst.ALBUM_ID, String.valueOf(j)));
    }

    public VKRequest getUploadServer(long j, long j2) {
        return prepareRequest("getUploadServer", VKUtil.paramsFrom(VKApiConst.ALBUM_ID, Long.valueOf(j), VKApiConst.GROUP_ID, Long.valueOf(j2)));
    }

    public VKRequest getWallUploadServer() {
        return prepareRequest("getWallUploadServer", null);
    }

    public VKRequest getWallUploadServer(long j) {
        return prepareRequest("getWallUploadServer", VKUtil.paramsFrom(VKApiConst.GROUP_ID, Long.valueOf(j)));
    }

    public VKRequest saveWallPhoto(VKParameters vKParameters) {
        return prepareRequest("saveWallPhoto", vKParameters, VKRequest.HttpMethod.POST, VKPhotoArray.class);
    }

    public VKRequest save(VKParameters vKParameters) {
        return prepareRequest("save", vKParameters, VKRequest.HttpMethod.POST, VKPhotoArray.class);
    }
}
