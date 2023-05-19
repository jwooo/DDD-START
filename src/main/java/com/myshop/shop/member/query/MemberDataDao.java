package com.myshop.shop.member.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberDataDao extends Repository<MemberData, String> {
    MemberData findById(String memberId);

    Page<MemberData> findByBlocked(boolean blocked, Pageable pageable);
    List<MemberData> findByNameLike(String name, Pageable pageable);

    List<MemberData> findFirst3ByNameLikeOrderByName(String name);
    Optional<MemberData> findFirstByNameLikeOrderByName(String name);
    MemberData findFirstByBlockedOrderById(boolean blocked);
}
