package uz.byte11.springsecoauth2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OAuth2ResponseDto {
    private String id;
    private Authentication authentication;
}
