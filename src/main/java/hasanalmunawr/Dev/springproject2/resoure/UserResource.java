package hasanalmunawr.Dev.springproject2.resoure;

import hasanalmunawr.Dev.springproject2.domain.Response;
import hasanalmunawr.Dev.springproject2.dto.UserRequest;
import hasanalmunawr.Dev.springproject2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static hasanalmunawr.Dev.springproject2.utils.RequestUtils.getResponse;
import static java.util.Collections.emptyMap;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid UserRequest user, HttpServletRequest request) {
      userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
      return ResponseEntity.created(getUri()).body(getResponse(request, emptyMap(), "Account Created. Check your email to enable your account", CREATED));
    }

    private URI getUri() {
        return URI.create("/user");
    }
}
