package mate.academy.internetshop.web.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Role;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.UserService;

public class AuthorizationFilter implements Filter {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.internetshop");
    private static final String USER_ID = "user_id";
    private final Map<String, List<Role.RoleName>> protectedUrl = new HashMap<>();
    private final UserService userService = (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        protectedUrl.put("/users/all", List.of(Role.RoleName.ADMIN));
        protectedUrl.put("/orders/all/delete", List.of(Role.RoleName.ADMIN));
        protectedUrl.put("/orders/all", List.of(Role.RoleName.ADMIN));
        protectedUrl.put("/user/delete", List.of(Role.RoleName.ADMIN));
        protectedUrl.put("/product/delete", List.of(Role.RoleName.ADMIN));
        protectedUrl.put("/shopping_cart/complete_order", List.of(Role.RoleName.USER));
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String url = req.getServletPath();
        if (protectedUrl.get(url) == null) {
            filterChain.doFilter(req, resp);
            return;
        }
        Long userId = (Long) req.getSession().getAttribute(USER_ID);
        if (isAuthorized(userService.get(userId), protectedUrl.get(url))) {
            filterChain.doFilter(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/views/accessDenied.jsp").forward(req, resp);
        }

    }

    @Override
    public void destroy() {

    }

    private boolean isAuthorized(User user, List<Role.RoleName> authorizedRoles) {
        for (Role.RoleName authorizedRole : authorizedRoles) {
            for (Role userRole : user.getRoles()) {
                if (authorizedRole.equals(userRole.getRoleName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
