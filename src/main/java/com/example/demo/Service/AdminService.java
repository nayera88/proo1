package com.example.demo.Service;


import ch.qos.logback.core.status.Status;
import com.example.demo.Repo.AdminRepo;
import com.example.demo.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public List<Admin> getAdmins() {
        return adminRepo.findAll();
    }

    public void signUPAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    public void signIn(Admin admin) {
        Optional<Admin> adminOptional=adminRepo.findAdminByusernameAndpassword(admin.getUsername(),admin.getPassword());
        if(!adminOptional.isPresent()){
         throw new IllegalStateException("try again");
        }
        admin.setLogin(true) ;
        adminRepo.save(admin);
    }



}
