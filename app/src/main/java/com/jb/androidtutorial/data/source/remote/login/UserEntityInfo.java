package com.jb.androidtutorial.data.source.remote.login;

/**
 * Created by b on 6/10/17.
 */

public class UserEntityInfo {

    public int userEntityId;
    public int userId;
    public int entityId;
    public String entityName;
    public String parentId;
    public String parentName;
    public String access;

    public int getUserEntityId() {
        return userEntityId;
    }

    public void setUserEntityId(int userEntityId) {
        this.userEntityId = userEntityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
