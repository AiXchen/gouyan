package com.gouyan.framework.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Aixchen
 * @date 2024/1/24 17:42
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
