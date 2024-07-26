package com.sakshi.connect.spring.boot.with.redis.controller;

import com.sakshi.connect.spring.boot.with.redis.model.Intern;
import com.sakshi.connect.spring.boot.with.redis.response.ApiResponse;
import com.sakshi.connect.spring.boot.with.redis.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interns")
public class InternController {

    @Autowired
    private InternService internService;

    @PostMapping
    public ResponseEntity<ApiResponse<Intern>> createIntern(@RequestBody Intern intern) {
        ApiResponse<Intern> response = internService.createIntern(intern);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Intern>>> getInternById(@PathVariable String id) {
        ApiResponse<Optional<Intern>> response = internService.getInternById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Intern>> updateIntern(@PathVariable String id, @RequestBody Intern updatedIntern) {
        ApiResponse<Intern> response = internService.updateIntern(id, updatedIntern);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteIntern(@PathVariable String id) {
        ApiResponse<String> response = internService.deleteIntern(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all-interns")
    public ResponseEntity<ApiResponse<List<Intern>>> getAllInterns() {
        ApiResponse<List<Intern>> response = internService.getAllInterns();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/bulk")
    public ResponseEntity<ApiResponse<List<Intern>>> bulkCreateInterns(@RequestBody List<Intern> interns) {
        ApiResponse<List<Intern>> response = internService.bulkCreateInterns(interns);
        return ResponseEntity.ok(response);
    }
}
