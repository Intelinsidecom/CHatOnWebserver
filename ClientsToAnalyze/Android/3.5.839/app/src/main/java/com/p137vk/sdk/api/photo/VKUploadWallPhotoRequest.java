package com.p137vk.sdk.api.photo;

import com.p137vk.sdk.api.VKApi;
import com.p137vk.sdk.api.VKApiConst;
import com.p137vk.sdk.api.VKParameters;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.util.VKJsonHelper;
import com.p137vk.sdk.util.VKUtil;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VKUploadWallPhotoRequest extends VKUploadPhotoBase {
    private static final long serialVersionUID = 4732771149932923938L;

    public VKUploadWallPhotoRequest(File file, long j, int i) {
        this.mUserId = j;
        this.mGroupId = i;
        this.mImage = file;
    }

    public VKUploadWallPhotoRequest(VKUploadImage vKUploadImage, long j, int i) {
        this.mUserId = j;
        this.mGroupId = i;
        this.mImage = vKUploadImage.getTmpFile();
    }

    @Override // com.p137vk.sdk.api.photo.VKUploadPhotoBase
    protected VKRequest getServerRequest() {
        return this.mGroupId != 0 ? VKApi.photos().getWallUploadServer(this.mGroupId) : VKApi.photos().getWallUploadServer();
    }

    @Override // com.p137vk.sdk.api.photo.VKUploadPhotoBase
    protected VKRequest getSaveRequest(JSONObject jSONObject) {
        try {
            VKRequest vKRequestSaveWallPhoto = VKApi.photos().saveWallPhoto(new VKParameters(VKJsonHelper.toMap(jSONObject)));
            if (this.mUserId != 0) {
                vKRequestSaveWallPhoto.addExtraParameters(VKUtil.paramsFrom("user_id", Long.valueOf(this.mUserId)));
            }
            if (this.mGroupId != 0) {
                vKRequestSaveWallPhoto.addExtraParameters(VKUtil.paramsFrom(VKApiConst.GROUP_ID, Long.valueOf(this.mGroupId)));
                return vKRequestSaveWallPhoto;
            }
            return vKRequestSaveWallPhoto;
        } catch (JSONException e) {
            return null;
        }
    }
}
