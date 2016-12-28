package com.xingyi.amatrix;

/**
 * Created by feilong.guo on 16/12/27.
 */


public class Bankcard {
    //valid_result 0:无效 1:有效
    private int validResult;
    //银行卡类型 0:直联信用卡 1:信用卡快捷 2:储蓄卡快捷
    private int bankcardType;
    //卡种id
    private int cardCategoryId;
    //记录id
    private long cardHistoryId;
    //艺龙卡号
    private String cardNo;
    //银行卡号
    private String bankcardNo;
    // 银行卡持有人
    private String bankcardHolder;
    //银行卡后四位
    private String bankcardListFourNum ;
    //银行卡有效期
    private String bankcardValidDate;
    //证件号码
    private String certificateNo;
    //证件类型( 将IdType 改成int型)
    private String certificateType;
    //持卡人的名字 外卡使用
    private String firstName;
    //持卡人的中间名 外卡使用 一般没有值
    private String middleName;
    //持卡人的姓氏 外卡使用
    private String lastName;
    // 出生日期 外卡使用 格式yyyy-MM-dd
    private String birthday;
    //账单地址1 外卡使用
    private String address1;
    // 账单地址2 外卡使用
    private String address2;
    //身份证 外卡使用
    private String citizenShip;
    //家庭电话 外卡使用
    private String phoneNumber1 ;
    //手机号 外卡使用
    private String phoneNumber2;
    // 性别 外卡使用
    private String gender;
    // 城市 外卡使用
    private String city;
    //省份 外卡使用
    private String province ;
    //国家 外卡使用
    private String country ;
    // 邮政编码 外卡使用
    private String postalCode;
    // 电话 外卡使用
    private String extension;
    // 社保号码 外卡使用
    private String custSsNum ;
    //发卡行 外卡使用
    private String bank;
    //账单国家 外卡使用
    private String billingCountry;
    //银行卡开卡时在银行预留的手机号，用于快捷支付时接收手机验证码
    private String mobile ;
    //邮箱
    private String email;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getValidResult() {
        return validResult;
    }
    public void setValidResult(int validResult) {
        this.validResult = validResult;
    }
    public int getBankcardType() {
        return bankcardType;
    }
    public void setBankcardType(int bankcardType) {
        this.bankcardType = bankcardType;
    }
    public int getCardCategoryId() {
        return cardCategoryId;
    }
    public void setCardCategoryId(int cardCategoryId) {
        this.cardCategoryId = cardCategoryId;
    }
    public long getCardHistoryId() {
        return cardHistoryId;
    }
    public void setCardHistoryId(long cardHistoryId) {
        this.cardHistoryId = cardHistoryId;
    }
    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public String getBankcardNo() {
        return bankcardNo;
    }
    public void setBankcardNo(String bankcardNo) {
        this.bankcardNo = bankcardNo;
    }
    public String getBankcardHolder() {
        return bankcardHolder;
    }
    public void setBankcardHolder(String bankcardHolder) {
        this.bankcardHolder = bankcardHolder;
    }
    public String getBankcardListFourNum() {
        return bankcardListFourNum;
    }
    public void setBankcardListFourNum(String bankcardListFourNum) {
        this.bankcardListFourNum = bankcardListFourNum;
    }
    public String getBankcardValidDate() {
        return bankcardValidDate;
    }
    public void setBankcardValidDate(String bankcardValidDate) {
        this.bankcardValidDate = bankcardValidDate;
    }
    public String getCertificateNo() {
        return certificateNo;
    }
    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }
    public String getCertificateType() {
        return certificateType;
    }
    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }
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
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
    public String getCitizenShip() {
        return citizenShip;
    }
    public void setCitizenShip(String citizenShip) {
        this.citizenShip = citizenShip;
    }
    public String getPhoneNumber1() {
        return phoneNumber1;
    }
    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }
    public String getPhoneNumber2() {
        return phoneNumber2;
    }
    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getCustSsNum() {
        return custSsNum;
    }
    public void setCustSsNum(String custSsNum) {
        this.custSsNum = custSsNum;
    }
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    public String getBillingCountry() {
        return billingCountry;
    }
    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Bankcard{" +
                "validResult=" + validResult +
                ", bankcardType=" + bankcardType +
                ", cardCategoryId=" + cardCategoryId +
                ", cardHistoryId=" + cardHistoryId +
                ", cardNo='" + cardNo + '\'' +
                ", bankcardNo='" + bankcardNo + '\'' +
                ", bankcardHolder='" + bankcardHolder + '\'' +
                ", bankcardListFourNum='" + bankcardListFourNum + '\'' +
                ", bankcardValidDate='" + bankcardValidDate + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", citizenShip='" + citizenShip + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", extension='" + extension + '\'' +
                ", custSsNum='" + custSsNum + '\'' +
                ", bank='" + bank + '\'' +
                ", billingCountry='" + billingCountry + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

