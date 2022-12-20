package com.example.demo.Controller;


import com.example.demo.Service.AdminService;
import com.example.demo.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/admin")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class AdminController {

    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAdmins(){

        return adminService.getAdmins();
    }

    @PostMapping (path = "/signUp")
    public void signUp (@RequestBody Admin admin){
        adminService.signUPAdmin(admin);
    }

  @PostMapping (path = "/signIn")
    public void signIn (@RequestBody Admin admin){

        adminService.signIn(admin);
    }




}
