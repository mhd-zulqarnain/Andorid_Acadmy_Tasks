package qee.zee.com.firestoredemo1.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Zul Qarnain on 1/3/2018.
 */

public class UserId {
    public String userId;
    public <T extends UserId> T withID(@NonNull final String id){
        this.userId=id;
        return (T)this;
    }
}
