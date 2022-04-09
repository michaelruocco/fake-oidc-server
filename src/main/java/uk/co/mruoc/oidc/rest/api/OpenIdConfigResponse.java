package uk.co.mruoc.oidc.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
@Data
public class OpenIdConfigResponse {

    private final String issuer;

    @JsonProperty("authorization_endpoint")
    private final String authorizationEndpoint;

    @JsonProperty("token_endpoint")
    private final String tokenEndpoint;

    @JsonProperty("introspection_endpoint")
    private final String introspectionEndpoint;

    @JsonProperty("userinfo_endpoint")
    private final String userInfoEndpoint;

    @JsonProperty("end_session_endpoint")
    private final String endSessionEndpoint;

    @JsonProperty("jwks_uri")
    private final String jwksUri;

    @JsonProperty("check_session_iframe")
    private final String checkSessionIFrame;

    @JsonProperty("grant")
    private final Collection<String> grantTypesSupported;

    @JsonProperty("response")
    private final Collection<String> responseTypesSupported;

    @JsonProperty("subject_types_supported")
    private final Collection<String> subjectTypesSupported;
}
