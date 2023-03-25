//package com.example.demoapi.controller.rest;
//
//import com.example.demoapi.dto.OrganizationDto;
//import com.example.demoapi.service.OrganizationService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//import java.util.List;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/v1/organization")
//@Slf4j
//public class OrganizationRestController {
//
//    private final OrganizationService organizationService;
//
//    @GetMapping
//    public List<OrganizationDto> getOrganizationList() {
//        return organizationService.findAll();
//    }
//
//    @GetMapping("/{organizationId}")
//    public ResponseEntity<?> getOrganization(@PathVariable("organizationId") Long id) {
//        OrganizationDto organizationDto;
//        if (id != null) {
//            organizationDto = organizationService.findById(id);
//            if (organizationDto != null) {
//                return new ResponseEntity<>(organizationDto, HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping
//    public ResponseEntity<?> handlePost(@Validated @RequestBody OrganizationDto organizationDto) {
//        OrganizationDto savedOrganizationDto = organizationService.save(organizationDto);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(URI.create("/api/v1/organization/" + savedOrganizationDto.getId()));
//        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{organizationId}")
//    public ResponseEntity<?> handleUpdate(@PathVariable("organizationId") Long id, @Validated @RequestBody OrganizationDto organizationDto) {
//        organizationDto.setId(id);
//        OrganizationDto savedOrganizationDto = organizationService.save(organizationDto);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(URI.create("/api/v1/organization/" + savedOrganizationDto.getId()));
//        return new ResponseEntity<>(httpHeaders, HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping("/{organizationId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteById(@PathVariable("organizationId") Long id) {
//        organizationService.deleteById(id);
//    }
//}
