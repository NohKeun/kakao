package com.kakao.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, Id> extends JpaRepository<T, Id> {

    <S extends T> S insert(S entity) throws Exception;

    <S extends T> S update(S entity) throws Exception;
}
