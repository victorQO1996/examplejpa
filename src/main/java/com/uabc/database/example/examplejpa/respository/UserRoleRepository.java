package com.uabc.database.example.examplejpa.respository;

import com.uabc.database.example.examplejpa.entity.Contact;
import com.uabc.database.example.examplejpa.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("contactRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Serializable> {
    public abstract UserRole findById(int id);
}
