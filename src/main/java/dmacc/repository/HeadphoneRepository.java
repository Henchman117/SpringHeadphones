package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Headphone;

@Repository
public interface HeadphoneRepository  extends JpaRepository<Headphone, Long>{

}
