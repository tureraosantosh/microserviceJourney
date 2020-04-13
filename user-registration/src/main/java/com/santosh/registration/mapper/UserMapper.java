package com.santosh.registration.mapper;

import org.springframework.stereotype.Component;

import com.santosh.registration.entity.Users;
import com.santosh.registration.model.CreateUserRequestModel;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.ClassMapBuilder;

@Component
public class UserMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		ClassMapBuilder<CreateUserRequestModel, Users> DtoToEntity = factory.classMap(CreateUserRequestModel.class, Users.class);
		DtoToEntity.byDefault().register();
	}

}
