package tech.artcoded.websitev2.security.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import tech.artcoded.braindead.rest.annotation.SwaggerHeaderAuthentication;

import javax.inject.Inject;
import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UserRepository userRepository;

    @Inject
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/info")
    @SwaggerHeaderAuthentication
    public User info(@ApiIgnore Principal principal) {
        return userRepository.principalToUser(principal);
    }
}