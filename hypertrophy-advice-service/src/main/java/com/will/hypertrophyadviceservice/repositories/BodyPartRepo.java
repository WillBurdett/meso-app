package com.will.hypertrophyadviceservice.repositories;

import com.will.hypertrophyadviceservice.enums.BodyPartName;
import com.will.hypertrophyadviceservice.models.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyPartRepo extends JpaRepository<BodyPart, BodyPartName> {

}
