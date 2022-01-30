package ma.mundiapolis.lims.payload.request;

import lombok.Data;

@Data
public class LoginRequest {
    private boolean googleSignIn;
    private String email;
    private String password;
    private GoogleAuthData googleAuthData;

    @Data
    public static class GoogleAuthData {
        private String firstName;
        private String lastName;
        private String email;
        private String idToken;
        private String accessToken;
        private Long expiresAt;
        private Long expiresIn;
        private Long issuedAt;
        private String tokenType;
    }
}