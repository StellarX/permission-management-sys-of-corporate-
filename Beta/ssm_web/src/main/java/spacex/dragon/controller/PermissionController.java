package spacex.dragon.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spacex.dragon.domain.Permission;
import spacex.dragon.service.IPermissionService;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv=new ModelAndView();
//        List<Permission> permissionList = permissionService.findAll();
//        mv.addObject("permissionList",permissionList);
//        mv.setViewName("permission-list");
//        return mv;
//    }

    //add paging function
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page", required = true, defaultValue = "1") Integer page, @RequestParam(name="size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList = permissionService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(permissionList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }
}
