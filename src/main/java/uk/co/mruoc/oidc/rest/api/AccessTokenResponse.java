package uk.co.mruoc.oidc.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
@Data
public class AccessTokenResponse {

    @JsonProperty("access_token")
    private final String accessToken;

    @JsonProperty("token_type")
    private final String tokenType;

    @JsonProperty("expires_in")
    private final long expiresIn;

    private final String scope;

    @JsonProperty("id_token")
    private final String idToken;
}
