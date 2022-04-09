package uk.co.mruoc.oidc.ui;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestConverter {

    public LoginForm toLoginForm(HttpServletRequest request) {
        return LoginForm.builder()
                .username(request.getParameter("username"))
                .password(request.getParameter("password"))
                .build();
    }
}
