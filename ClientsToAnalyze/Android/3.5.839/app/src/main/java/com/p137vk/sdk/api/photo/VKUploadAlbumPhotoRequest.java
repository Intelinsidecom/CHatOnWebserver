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
public class VKUploadAlbumPhotoRequest extends VKUploadPhotoBase {
    private static final long serialVersionUID = 5439648671595840976L;

    public VKUploadAlbumPhotoRequest(File file, long j, long j2) {
        this.mAlbumId = j;
        this.mGroupId = j2;
        this.mImage = file;
    }

    public VKUploadAlbumPhotoRequest(VKUploadImage vKUploadImage, long j, long j2) {
        this.mAlbumId = j;
        this.mGroupId = j2;
        this.mImage = vKUploadImage.getTmpFile();
    }

    @Override // com.p137vk.sdk.api.photo.VKUploadPhotoBase
    protected VKRequest getServerRequest() {
        return (this.mAlbumId == 0 || this.mGroupId == 0) ? VKApi.photos().getUploadServer(this.mAlbumId) : VKApi.photos().getUploadServer(this.mAlbumId, this.mGroupId);
    }

    @Override // com.p137vk.sdk.api.photo.VKUploadPhotoBase
    protected VKRequest getSaveRequest(JSONObject jSONObject) {
        try {
            VKRequest vKRequestSave = VKApi.photos().save(new VKParameters(VKJsonHelper.toMap(jSONObject)));
            if (this.mAlbumId != 0) {
                vKRequestSave.addExtraParameters(VKUtil.paramsFrom(VKApiConst.ALBUM_ID, Long.valueOf(this.mAlbumId)));
            }
            if (this.mGroupId != 0) {
                vKRequestSave.addExtraParameters(VKUtil.paramsFrom(VKApiConst.GROUP_ID, Long.valueOf(this.mGroupId)));
                return vKRequestSave;
            }
            return vKRequestSave;
        } catch (JSONException e) {
            return null;
        }
    }
}
