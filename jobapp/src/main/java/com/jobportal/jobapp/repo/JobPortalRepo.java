package com.jobportal.jobapp.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.jobapp.model.JobPortal;

@Repository
public class JobPortalRepo {
        // ArrayList to store JobPost objects
        List<JobPortal> jobs = new ArrayList<>(Arrays.asList(

                        new JobPortal(1, "Java Developer", "Must have good experience in core Java and advanced Java",
                                        2,
                                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                        new JobPortal(2, "Frontend Developer",
                                        "Experience in building responsive web applications using React", 3,
                                        List.of("HTML", "CSS", "JavaScript", "React")),

                        new JobPortal(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                                        List.of("Python", "Machine Learning", "Data Analysis")),

                        new JobPortal(4, "Network Engineer",
                                        "Design and implement computer networks for efficient data communication", 5,
                                        List.of("Networking", "Cisco", "Routing", "Switching")),

                        new JobPortal(5, "Mobile App Developer",
                                        "Experience in mobile app development for iOS and Android", 3,
                                        List.of("iOS Development", "Android Development", "Mobile App"))));

        // method to return all JobPosts
        public List<JobPortal> getAllJobs() {
                return jobs;
        }

        // method to save a job post object into arrayList
        public void addJob(JobPortal job) {
                jobs.add(job);
                System.out.println(jobs);
        }
}
