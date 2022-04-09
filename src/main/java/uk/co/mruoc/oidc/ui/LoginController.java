package uk.co.mruoc.oidc.ui;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final HttpRequestConverter requestConverter;

    public LoginController() {
        this(new HttpRequestConverter());
    }

    @GetMapping
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping
    public ResponseEntity<Void> loginSubmit(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        LoginForm form = requestConverter.toLoginForm(request);
        log.info("login form submitted {}", form);
        if (form.getPassword().equals("welcome")) {
            response.sendRedirect("https://oauth.pstmn.io/v1/callback?code=authorization-code");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
