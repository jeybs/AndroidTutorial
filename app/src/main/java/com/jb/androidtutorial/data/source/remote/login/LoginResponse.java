package com.jb.androidtutorial.data.source.remote.login;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by b on 6/10/17.
 */

public class LoginResponse {

    public String firstName;
    public String middleName;
    public String lastName;
    public String email;
    public String email2;
    public String mobileNo;
    public String mobileNo2;
    public String telephoneNo;
    public String telephoneNo2;
    public String birthDate;
    public String siteName;
    public String position;
    public String address1;
    public String address2;
    public String city;
    public String postalCode;
    public String country;
    public String region;
    public String maritalStatus;
    public String relationship;
    public String age;
    public String userId;
    public String username;
    public String password;
    public String type;
    public String entityType;
    public String status;
    public String isIpFiltered;
    public String transAuthRaw;
    public int periodId;
    public int periodWeekId;
    public String createdBy;
    public String dateCreated;
    public String dateModified;

    private static final String KEY_USER_ENTITY = "userEntityInfo";
    @SerializedName(KEY_USER_ENTITY)
    public List<UserEntityInfo> userEntityInfoList;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMobileNo2() {
        return mobileNo2;
    }

    public void setMobileNo2(String mobileNo2) {
        this.mobileNo2 = mobileNo2;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getTelephoneNo2() {
        return telephoneNo2;
    }

    public void setTelephoneNo2(String telephoneNo2) {
        this.telephoneNo2 = telephoneNo2;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsIpFiltered() {
        return isIpFiltered;
    }

    public void setIsIpFiltered(String isIpFiltered) {
        this.isIpFiltered = isIpFiltered;
    }

    public String getTransAuthRaw() {
        return transAuthRaw;
    }

    public void setTransAuthRaw(String transAuthRaw) {
        this.transAuthRaw = transAuthRaw;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public int getPeriodWeekId() {
        return periodWeekId;
    }

    public void setPeriodWeekId(int periodWeekId) {
        this.periodWeekId = periodWeekId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public List<UserEntityInfo> getUserEntityInfoList() {
        return userEntityInfoList;
    }

    public void setUserEntityInfoList(List<UserEntityInfo> userEntityInfoList) {
        this.userEntityInfoList = userEntityInfoList;
    }
}
