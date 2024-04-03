package com.javademo.service_user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_user")
    private String tenKH;
    @Column(name = "sdt")
    private String soDT;
    @Column(name = "tuoi")
    private Integer tuoi;
    @OneToOne(mappedBy = "user",cascade =CascadeType.ALL)
    private Account account;

    public User() {
    }
    public User(Integer id, String tenKH, String soDT, Integer tuoi) {
        this.id = id;
        this.tenKH = tenKH;
        this.soDT = soDT;
        this.tuoi = tuoi;
    }
}
