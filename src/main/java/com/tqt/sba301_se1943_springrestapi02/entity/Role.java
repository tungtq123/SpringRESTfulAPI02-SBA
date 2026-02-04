package com.tqt.sba301_se1943_springrestapi02.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Integer id;
    @Column(name = "role_name", nullable = false, length = 255)
    private String name;
    public Role(String name) {
        this.name = name;
    }
}
