package uz.byte11.springsecoauth2.config.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;

@RequiredArgsConstructor
public class OAuth2GooglePrinciple implements OAuth2UserPrinciple{

    private final OAuth2User oauth2User;

    @Override
    public String getProviderId() {
        return "google";
    }

    @Override
    public String getEmail() {
        return oauth2User.getAttribute("email");
    }

    @Override
    public String getUsername() {
        return oauth2User.getAttribute("full_name");
    }

    @Override
    public String imgUrl() {
        return oauth2User.getAttribute("avatar_url");
    }
}
