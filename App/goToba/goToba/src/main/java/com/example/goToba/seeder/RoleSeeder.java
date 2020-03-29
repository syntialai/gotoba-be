package com.example.goToba.seeder;

import com.example.goToba.model.RoleName;
import com.example.goToba.model.Roles;
import com.example.goToba.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/03/2020.
 */
//Seeder untuk create value di tabel DB secara automatis

@Component
public class RoleSeeder {

    @Autowired
    RoleRepo roleRepo;

    //cek apakah field sudah terdaftar
    public void checkRoleIfExists(RoleName roleName){
        if(!roleRepo.existsByName(roleName)){
            Roles roles=new Roles();
            roles.setName(roleName);
            saveRoles(roles);
        }
    }

    //simpan ke DB jika field belum ada
    public void saveRoles(Roles roles){
        roleRepo.save(roles);
    }

    //pengecekan
    @EventListener
    public void seeder(ContextRefreshedEvent contextRefreshedEvent){
        checkRoleIfExists(RoleName.ROLE_ADMIN);
        checkRoleIfExists(RoleName.ROLE_MERCHANT);
        checkRoleIfExists(RoleName.ROLE_USER);
    }

}
