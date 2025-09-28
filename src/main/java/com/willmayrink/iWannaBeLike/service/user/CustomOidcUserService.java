package com.willmayrink.iWannaBeLike.service.user;

import com.willmayrink.iWannaBeLike.model.user.UserModel;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomOidcUserService extends OidcUserService {

    private final UserService userService;

    public CustomOidcUserService(UserService userService) {
        this.userService = userService;
        System.out.println("Custom OIDC UserService instantiated!");
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) {
        OidcUser oidcUser = super.loadUser(userRequest);
        System.out.println("OIDC user received: " + oidcUser.getEmail());

        String provider = userRequest.getClientRegistration().getRegistrationId();
        String oauthId = oidcUser.getSubject(); // "sub" do Google
        String email = oidcUser.getEmail();
        String realName = oidcUser.getGivenName(); //i fucking hate every single developer on this fugggg planet. oidcUser.getName() returns the OAuth2.0Id zzzzz
        String username = email.split("@")[0];

        // Verifica se o usuário já existe
        Optional<UserModel> existingUser = userService.findByOauthId(oauthId);
        UserModel user;

        if (existingUser.isPresent()) {
            user = existingUser.get();
            user.setEmail(email);
            user.setRealName(realName);
            user.setActive(true);
            userService.save(user);
            System.out.println("We found an existing user!!!! \n This is the Oauth2.0 ID:" + oidcUser.getName()+"\n This is the givenname: "+oidcUser.getGivenName()+"\n This is the fullname: "+oidcUser.getFullName());
        } else {
            user = new UserModel();
            user.setOauthId(oauthId);
            user.setProvider(provider);
            user.setEmail(email);
            user.setUsername(username);
            user.setRealName(realName);
            user.setActive(true);
            userService.save(user);
            System.out.println("We found a new user!!!! \n This is the Oauth2.0 ID:" + oidcUser.getName()+"\n This is the givenname: "+oidcUser.getGivenName()+"\n This is the fullname: "+oidcUser.getFullName());
        }

        return oidcUser;
    }
}
