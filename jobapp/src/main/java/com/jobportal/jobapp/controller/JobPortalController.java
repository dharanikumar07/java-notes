package com.jobportal.jobapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jobportal.jobapp.model.JobPortal;
import com.jobportal.jobapp.service.JobPortalService;

@Controller 
public class JobPortalController {

  @Autowired 
  public JobPortalService jobservice;

  @GetMapping ({"/","/home"})
  public String home()
  {
    System.out.println("home controller");
    return "home";
  }

  @GetMapping ("/viewalljobs")
  public String ViewAllJobs(Model m)
  {
    List<JobPortal> jobPosts = jobservice.get();
    m.addAttribute("jobPosts", jobPosts);

    return "viewalljobs";
  }

  @GetMapping ("/addjob")
  public String AddJob()
  {
    return "addjob";
  }


  @PostMapping ("/handleForm")
  public String success(JobPortal jobPost, Model model)
  {
    jobservice.save(jobPost);
    model.addAttribute("jobPost", jobPost);
    return "success";
  }
}
