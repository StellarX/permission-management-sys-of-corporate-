package spacex.dragon.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import spacex.dragon.domain.Role;
import spacex.dragon.domain.UserInfo;
import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);
}
