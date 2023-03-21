package com.example.demoapi.dto.mapper;

import com.example.demoapi.dto.OrganizationDto;
import com.example.demoapi.entity.Organization;
import org.mapstruct.Mapper;

@Mapper
public interface OrganizationMapper {

    Organization toOrganization(OrganizationDto organizationDto);

    OrganizationDto toOrganizationDto(Organization organization);
}
