 package com.example.demo.service;


 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.Table;
 
 @Entity
 @Table(name = "demo_user")
 public class User {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Long id;
 
     @Column(name = "username")
     private String username;
 
     @Column(name = "password")
     private String password;
 
     @Column(name = "role")
     private String role;
 
     public User() {
     }
 
     public User(String username, String password, String role) {
         this.username = username;
         this.password = password;
         this.role = role;
     }
 
     public Long getId() {
         return id;
     }
 
     public void setId(Long id) {
         this.id = id;
     }
 
     public String getUsername() {
         return username;
     }
 
     public void setUsername(String username) {
         this.username = username;
     }
 
     public String getPassword() {
         return password;
     }
 
     public void setPassword(String password) {
         this.password = password;
     }
 
     public String getRole() {
         return role;
     }
 
     public void setRole(String role) {
         this.role = role;
     }
 
     
 }