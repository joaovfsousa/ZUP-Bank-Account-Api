package com.joaovfsousa.bank_account_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "accounts")
public class Account {

    private @Id @GeneratedValue Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date birthDate;
}