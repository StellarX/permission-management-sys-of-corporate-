package spacex.dragon.service;
import spacex.dragon.domain.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll(int page, int size) throws Exception;

    void save(Permission permission) throws Exception;
}
