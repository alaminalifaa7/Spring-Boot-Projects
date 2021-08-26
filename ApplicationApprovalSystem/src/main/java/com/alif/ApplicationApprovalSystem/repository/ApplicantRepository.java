package com.alif.ApplicationApprovalSystem.repository;

import com.alif.ApplicationApprovalSystem.model.Applicant;
import com.alif.ApplicationApprovalSystem.model.ApplicantRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
   Optional<Applicant> findByEmail(String email);
  List<Applicant> findApplicantByApplicantRole(ApplicantRole applicantRole);
}
