package org.softwaremanager.backoffice.manager.projects.service;

import org.modelmapper.ModelMapper;
import org.softwaremanager.backoffice.auth.domain.User;
import org.softwaremanager.backoffice.auth.web.dto.UserInfoDto;
import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.domain.dto.ProjectDto;
import org.softwaremanager.backoffice.manager.projects.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImp implements ProjectService{
    final private ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public List<ProjectDto> findAll(Pageable pageable) {

        List<Project> projects = projectRepository.findAll(pageable).getContent();
        
        if(projects.isEmpty()){
           return null;
        }else{

            ModelMapper modelMapper = new ModelMapper();
            List<ProjectDto> projectDtoList = new ArrayList<>();

            projects.forEach(project -> {
                ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);

                if(!project.getUsersByProjects().isEmpty()){
                    User user = new User();

                    for(User userReference : project.getUsersByProjects()){
                        user = userReference;
                    }

                    UserInfoDto userInfoDto = modelMapper.map(user, UserInfoDto.class);
                    projectDto.setUserInfo( userInfoDto );
                }

                projectDtoList.add(projectDto);
            });

            return projectDtoList;
        }
    }
}
