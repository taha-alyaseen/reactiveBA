package com.talyas.bloodBankMVC.repositories;

import com.talyas.bloodBankMVC.entities.models.Seeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface SeekerRepository extends JpaRepository<Seeker, Long> {
  Optional<Seeker> findById(Long id);
  List<Seeker> findAllByBloodBankID(Long id);
}
