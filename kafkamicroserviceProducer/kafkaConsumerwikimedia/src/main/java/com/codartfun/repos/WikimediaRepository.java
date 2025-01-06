package com.codartfun.repos;

import com.codartfun.model.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaData,Long> {
}
