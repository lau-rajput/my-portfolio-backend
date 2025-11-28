package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Project;
import com.portfolio.portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    // GET All Projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // ADD Project
    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    // DELETE Project (correct endpoint)
    @DeleteMapping("/delete/{id}")
    public String deleteProject(
            @PathVariable Long id,
            @RequestParam String key) {

        if(!key.equals("KRISHNA_ADMIN_999")) {
            return "Unauthorized";
        }

        projectRepository.deleteById(id);
        return "Project Deleted Successfully";
    }
}
