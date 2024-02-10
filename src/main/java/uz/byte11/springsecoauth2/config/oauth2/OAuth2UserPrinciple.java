package uz.byte11.springsecoauth2.config.oauth2;

public interface OAuth2UserPrinciple {
    String getProviderId();
    String getEmail();
    String getUsername();
    String imgUrl();
}
