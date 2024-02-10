package uz.byte11.springsecoauth2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uz.byte11.springsecoauth2.dto.OAuth2ResponseDto;

@RestController
public class OAuth2CallbackController {

//    @GetMapping("")
    public ResponseEntity<?> handleCallback(
            @PathVariable("providerId") String providerId,
            Authentication authentication
    ) {
        return ResponseEntity.ok(new OAuth2ResponseDto(providerId, authentication));
    }
}
