package com.blog.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long oid;

    private String username;

    private String nickname;

    private String password;

    private String userurl;

    private String userrole;

    private String useravatar;

    private String usergithubid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdate;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserurl() {
        return userurl;
    }

    public void setUserurl(String userurl) {
        this.userurl = userurl == null ? null : userurl.trim();
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole == null ? null : userrole.trim();
    }

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar == null ? null : useravatar.trim();
    }

    public String getUsergithubid() {
        return usergithubid;
    }

    public void setUsergithubid(String usergithubid) {
        this.usergithubid = usergithubid == null ? null : usergithubid.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", username=").append(username);
        sb.append(", nickname=").append(nickname);
        sb.append(", password=").append(password);
        sb.append(", userurl=").append(userurl);
        sb.append(", userrole=").append(userrole);
        sb.append(", useravatar=").append(useravatar);
        sb.append(", usergithubid=").append(usergithubid);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}