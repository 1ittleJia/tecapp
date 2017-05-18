package com.ieds.model.bo;

import javax.persistence.*;

/**
 * Created by jia on 2017/5/2.
 */
public class LoginBo {
    private String loginNm;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginNm() {

        return loginNm;
    }

    public void setLoginNm(String loginNm) {
        this.loginNm = loginNm;
    }
}
