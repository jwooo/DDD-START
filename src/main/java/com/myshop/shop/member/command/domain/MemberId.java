package com.myshop.shop.member.command.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
public class MemberId implements Serializable {

    @Column(name = "member_id")
    private String id;

    protected MemberId() {}
    public MemberId(String id) {
        this.id = id;
    }

}
