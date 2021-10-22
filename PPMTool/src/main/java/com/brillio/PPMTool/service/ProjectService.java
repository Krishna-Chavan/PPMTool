package com.brillio.PPMTool.service;

import com.brillio.PPMTool.domain.Project;
import com.brillio.PPMTool.exception.ProjectIdException;
import com.brillio.PPMTool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project Id '"+project.getProjectIdentifier().toUpperCase()+"' Already Exists");
        }
    }
}
