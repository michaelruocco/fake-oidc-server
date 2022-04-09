package uk.co.mruoc.oidc.rest.api;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UrlPathHelper;

@Slf4j
@RestController
@RequestMapping("/auth/realms/fake-realm")
@RequiredArgsConstructor
public class KeycloakController {

    private final UrlPathHelper urlPathHelper;

    public KeycloakController() {
        this(new UrlPathHelper());
    }

    @GetMapping("/.well-known/openid-configuration")
    public OpenIdConfigResponse getOpenIdConfig(HttpServletRequest request) {
        String hostAndPort = extractHostAndPort(request);
        String issuer = String.format("%s/auth/realms/fake-realm", hostAndPort);
        String baseUri = String.format("%s/protocol/openid-connect", issuer);
        return OpenIdConfigResponse.builder()
                .issuer(issuer)
                .authorizationEndpoint(String.format("%s/auth", baseUri))
                .tokenEndpoint(String.format("%s/token", baseUri))
                .introspectionEndpoint(String.format("%s/token/introspect", baseUri))
                .userInfoEndpoint(String.format("%s/userinfo", baseUri))
                .endSessionEndpoint(String.format("%s/logout", baseUri))
                .jwksUri(String.format("%s/certs", baseUri))
                .checkSessionIFrame(String.format("%s/login-status-iframe.html", baseUri))
                .grantTypesSupported(Arrays.asList(
                        "authorization_code",
                        "implicit",
                        "refresh_token",
                        "password",
                        "client_credentials",
                        "urn:ietf:params:oauth:grant-type:device_code",
                        "urn:openid:params:grant-type:ciba"))
                .responseTypesSupported(Arrays.asList(
                        "code",
                        "none",
                        "id_token",
                        "token",
                        "id_token token",
                        "code id_token",
                        "code token",
                        "code id_token token"))
                .subjectTypesSupported(Arrays.asList("public", "pairwise"))
                .build();
    }

    @GetMapping("/protocol/openid-connect/auth")
    public void createAccessCode(
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam String scope,
            @RequestParam("response_type") String responseType,
            @RequestParam(required = false) String state,
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        log.info(
                "create access code client_id={} redirect_uri={} scope={} response_type={} state={}",
                clientId,
                redirectUri,
                scope,
                responseType,
                state);
        String hostAndPort = extractHostAndPort(request);
        response.sendRedirect(String.format("%s/login", hostAndPort));
    }

    @PostMapping("/protocol/openid-connect/token")
    public AccessTokenResponse createAccessToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam(value = "client_secret", required = false) String clientSecret,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam String code) {
        log.info(
                "create access token grant_type{} client_id={} client_secret={} redirect_uri={} code={}",
                grantType,
                clientId,
                clientSecret,
                redirectUri,
                code);
        return AccessTokenResponse.builder()
                .accessToken("fake-access-token")
                .expiresIn(3600)
                .scope("openid")
                .idToken("fake-id-token")
                .build();
    }

    private String extractHostAndPort(HttpServletRequest request) {
        String servletPath = urlPathHelper.getServletPath(request);
        URI requestUri = URI.create(request.getRequestURL().toString());
        return requestUri.toString().replace(servletPath, "");
    }
}
