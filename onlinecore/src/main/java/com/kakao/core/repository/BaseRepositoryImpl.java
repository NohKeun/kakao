package com.kakao.core.repository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@Slf4j
@NoRepositoryBean
public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T,ID> {

    EntityManager entityManager;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        entityManager = em;
    }

    @Override
    public <S extends T> S insert(S entity) throws Exception {
        try {
            //persist로 중복으로 insert하는 경오 오류처리
            entityManager.persist(entity);
        } catch (Exception e) {
            throw new Exception();
        }
        return entity;
    }


    @Override
    public <S extends T> S update(S entity) throws Exception {

        //업데이트 전에 pk조회 후 값이 존재하지 않으면 오류
        Object pk = entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
        T exists = entityManager.find(this.getDomainClass(), pk);

        if (exists == null) {
            throw new Exception();
        }

        entity = entityManager.merge(entity);
        return entity;
    }
}
