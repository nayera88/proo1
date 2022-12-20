package com.example.demo.Repo;


import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {

    @Query ("SELECT s FROM Admin s WHERE s.username=?1 AND s.password=?2")
    Optional<Admin> findAdminByusernameAndpassword(String username ,String password);
}
