package com.will.exercisedata.repositories;

import com.will.exercisedata.enums.BodyPartName;
import com.will.exercisedata.models.BodyPartInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyPartInfoRepo extends JpaRepository<BodyPartInfo, BodyPartName> {

}
