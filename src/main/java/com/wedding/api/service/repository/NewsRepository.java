package com.wedding.api.service.repository;

import com.wedding.api.service.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> , JpaSpecificationExecutor<NewsEntity> {

}