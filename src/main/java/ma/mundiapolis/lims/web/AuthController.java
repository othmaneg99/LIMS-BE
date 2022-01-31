package ma.mundiapolis.lims.web;

import ma.mundiapolis.lims.dao.UserRepository;
import ma.mundiapolis.lims.entities.ERole;
import ma.mundiapolis.lims.entities.User;
import ma.mundiapolis.lims.payload.request.LoginRequest;
import ma.mundiapolis.lims.payload.response.JwtResponse;
import ma.mundiapolis.lims.payload.response.MessageResponse;
import ma.mundiapolis.lims.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("signin")
    @Transactional
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        User user;
        if (loginRequest.isGoogleSignIn()) {
            LoginRequest.GoogleAuthData googleAuthData = loginRequest.getGoogleAuthData();
            // todo: validate google access token

            if (userRepository.existsByEmail(googleAuthData.getEmail())) {
                user = userRepository.findByEmail(googleAuthData.getEmail());
            } else {
                user = new User();
                user.setEmail(googleAuthData.getEmail());
                user.setFirstName(googleAuthData.getFirstName());
                user.setLastName(googleAuthData.getLastName());
                user.setIsActive(true);
                user.setRole(ERole.USER);
                user = userRepository.save(user);
            }
        } else {
            user = userRepository.findByEmail(loginRequest.getEmail());
            if (user != null) {
                String password = user.getPassword();
                if (!(password.length() > 0 && password.equals(loginRequest.getPassword()))) {
                    return ResponseEntity.badRequest().body(new MessageResponse("error: incorrect-credentials"));
                }
            }
        }

        if (user != null) {
            String jwt = jwtUtils.generateJwtToken(user);
            return ResponseEntity.ok(new JwtResponse(jwt, user.getId(), user.getEmail(), user.getRole().name()));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("error: incorrect-credentials"));
        }
    }
}
