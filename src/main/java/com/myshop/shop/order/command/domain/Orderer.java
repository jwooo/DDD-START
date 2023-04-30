package com.myshop.shop.order.command.domain;

import com.myshop.shop.member.MemberId;
import lombok.Getter;

import javax.persistence.*;

@Embeddable
@Getter
public class Orderer {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String email;
}
