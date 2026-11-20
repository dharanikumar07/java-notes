package com.jobportal.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.jobapp.model.JobPortal;
import com.jobportal.jobapp.repo.JobPortalRepo;

@Service 
public class JobPortalService {

  @Autowired 
  public JobPortalRepo jobPortalRepo;

  public void save(JobPortal jobPortal)
  {
    jobPortalRepo.addJob(jobPortal);
  }

  public List<JobPortal> get()
  {
    return jobPortalRepo.getAllJobs();
  }
}
