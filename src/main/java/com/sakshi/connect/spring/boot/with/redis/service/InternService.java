package com.sakshi.connect.spring.boot.with.redis.service;
import com.sakshi.connect.spring.boot.with.redis.response.ApiResponse;
import com.sakshi.connect.spring.boot.with.redis.model.Intern;
import com.sakshi.connect.spring.boot.with.redis.Repository.InternRepository;
import com.sakshi.connect.spring.boot.with.redis.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternService {

    @Autowired
    private InternRepository internRepository;

    public ApiResponse<Intern> createIntern(Intern intern) {
        Intern savedIntern = internRepository.save(intern);
        return new ApiResponse<>(true, "Intern created successfully", savedIntern);
    }

    public ApiResponse<Optional<Intern>> getInternById(String id) {
        Optional<Intern> intern = internRepository.findById(id);
        if (intern.isPresent()) {
            return new ApiResponse<>(true, "Intern found", intern);
        } else {
            return new ApiResponse<>(false, "Intern not found", intern);
        }
    }

    public ApiResponse<Intern> updateIntern(String id, Intern updatedIntern) {
        return internRepository.findById(id)
                .map(intern -> {
                    intern.setName(updatedIntern.getName());
                    intern.setGender(updatedIntern.getGender());
                    Intern savedIntern = internRepository.save(intern);
                    return new ApiResponse<>(true, "Intern updated successfully", savedIntern);
                })
                .orElseGet(() -> {
                    updatedIntern.setId(id);
                    Intern savedIntern = internRepository.save(updatedIntern);
                    return new ApiResponse<>(true, "Intern created successfully", savedIntern);
                });
    }

    public ApiResponse<String> deleteIntern(String id) {
        internRepository.deleteById(id);
        return new ApiResponse<>(true, "Intern deleted successfully", id);
    }

    public ApiResponse<List<Intern>> getAllInterns() {
        List<Intern> interns = (List<Intern>) internRepository.findAll();
        return new ApiResponse<>(true, "List of all interns", interns);
    }

    public ApiResponse<List<Intern>> bulkCreateInterns(List<Intern> interns) {
        List<Intern> savedInterns = (List<Intern>) internRepository.saveAll(interns);
        return new ApiResponse<>(true, "Interns created successfully", savedInterns);
    }
}
