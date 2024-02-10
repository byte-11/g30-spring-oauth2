package uz.byte11.springsecoauth2.config.oauth2;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import uz.byte11.springsecoauth2.dto.OAuth2ResponseDto;

import java.io.IOException;

import static com.nimbusds.common.contenttype.ContentType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        if (authentication instanceof OAuth2AuthenticationToken token) {
            OAuth2User principal = token.getPrincipal();
            token.getPrincipal();
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(APPLICATION_JSON.getBaseType());
            response.getWriter().write(objectMapper.writeValueAsString(
                    new OAuth2ResponseDto(token.getAuthorizedClientRegistrationId(), token)
            ));
            return;
        }
    }

}
