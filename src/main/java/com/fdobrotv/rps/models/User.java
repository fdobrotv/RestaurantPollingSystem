package com.fdobrotv.rps.models;

/**
 * Created by Fedor Dobrotvorsky on 03.11.2016.
 */
import com.fdobrotv.rps.models.base.AbstractEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends AbstractEntity {

    private String login, fio;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column
    private EmailAddress email;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Length(min = 6)
    private String password;

    public User(String login, String fio) {

        Assert.hasText(login);
        Assert.hasText(fio);

        this.login = login;
        this.fio = fio;
    }

    protected User() {}

    public String getLogin() {
        return login;
    }

    public String getFio() {
        return fio;
    }

    public EmailAddress getEmailAddress() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.email = emailAddress;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getEmail() {
        return email.getValue();
    }
}