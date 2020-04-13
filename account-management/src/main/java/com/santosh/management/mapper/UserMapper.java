package com.santosh.management.mapper;

import org.springframework.stereotype.Component;

import com.santosh.management.dto.input.UsersDto;
import com.santosh.management.entity.Account;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.ClassMapBuilder;

@Component
public class UserMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		ClassMapBuilder<UsersDto, Account> DtoToEntity = factory.classMap(UsersDto.class, Account.class);
		DtoToEntity.byDefault().register();
	}

}
