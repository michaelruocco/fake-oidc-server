package uk.co.mruoc.oidc.ui;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
@Data
public class LoginForm {

    private final String username;
    private final String password;
}
