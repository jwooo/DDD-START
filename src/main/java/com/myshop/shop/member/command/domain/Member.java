package com.myshop.shop.member.command.domain;

import com.myshop.shop.common.jpa.EmailSetConverter;
import com.myshop.shop.common.model.Email;
import com.myshop.shop.common.model.EmailSet;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {

    @EmbeddedId
    private MemberId id;

    private String name;

    @Embedded
    private Password password;

    private boolean blocked;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emails;

    protected Member() {}

    public Member(MemberId id, String name) {
        this.id = id;
        this.name = name;
    }

    public MemberId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changeEmails(Set<Email> emails) {
        this.emails = new EmailSet(emails);
    }

    public void block() {
        this.blocked = true;
    }

    public void unblock() {
        this.blocked = false;
    }

    public void changePassword(String oldPw, String newPw) {
        if (!password.match(oldPw)) {
            throw new IdPasswordNotMatchingException();
        }
        this.password = new Password(newPw);
    }

    public boolean isBlocked() {
        return blocked;
    }

    public EmailSet getEmails() {
        return emails;
    }

}
