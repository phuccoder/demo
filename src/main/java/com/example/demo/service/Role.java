// package com.example.demo.service;

// import java.util.Set;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;
// import javax.persistence.Table;

// @Entity
// @Table(name = "dbo_tbl_roles")
// public class Role {
// 	@Id
// 	@Column(name = "Id")
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private Long id;
// 	@Column(name = "name")
// 	private String name;

//     @OneToMany(mappedBy = "role")
// 	private Set<Role> roleUsers;

//     public Role() {
//     }

//     public Role(Long id, String name, Set<Role> roleUsers) {
//         this.id = id;
//         this.name = name;
//         this.roleUsers = roleUsers;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public Set<Role> getRoleUsers() {
//         return roleUsers;
//     }

//     public void setRoleUsers(Set<Role> roleUsers) {
//         this.roleUsers = roleUsers;
//     }

    
// }