package com.example.demoapi.service;

import com.example.demoapi.dao.OrganizationDao;
import com.example.demoapi.dto.OrganizationDto;
import com.example.demoapi.dto.mapper.OrganizationMapper;
import com.example.demoapi.entity.Organization;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationService {

    private final OrganizationDao organizationDao;
    private final OrganizationMapper organizationMapper;

    public OrganizationDto save(OrganizationDto organizationDto) {
        Organization organization = organizationMapper.toOrganization(organizationDto);
        if (organization.getId() != null) {
            organizationDao.findById(organizationDto.getId()).ifPresent(
                    (p) -> organization.setVersion(p.getVersion())
            );
        }
        return organizationMapper.toOrganizationDto(organizationDao.save(organization));
    }

    @Transactional(readOnly = true)
    public OrganizationDto findById(Long id) {
        return organizationMapper.toOrganizationDto(organizationDao.findById(id).orElse(null));
    }

    public List<OrganizationDto> findAll() {
        return organizationDao.findAll().stream()
                .map(organizationMapper::toOrganizationDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        try {
            organizationDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
        }
    }
}
