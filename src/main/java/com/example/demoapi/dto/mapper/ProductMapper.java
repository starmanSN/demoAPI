package com.example.demoapi.dto.mapper;

import com.example.demoapi.dao.OrganizationDao;
import com.example.demoapi.dto.ProductDto;
import com.example.demoapi.entity.Organization;
import com.example.demoapi.entity.Product;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.NoSuchElementException;

@Mapper(uses = OrganizationMapper.class)
public interface ProductMapper {

    Product toProduct(ProductDto productDto, @Context OrganizationDao organizationDao);

    ProductDto toProductDto(Product product);

    default Organization getOrganization(String organization, @Context OrganizationDao organizationDao) {
        return organizationDao.findByName(organization).orElseThrow(
                () -> new NoSuchElementException("There isn't organization with name " + organization)
        );
    }

    default String getOrganization(Organization organization) {
        return organization.getName();
    }

}
