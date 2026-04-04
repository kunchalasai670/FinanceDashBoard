package org.financedashboard.dto;

import org.financedashboard.entity.TransactionEntity;
import org.financedashboard.entity.UserEntity;
import org.financedashboard.model.Transaction;
import org.financedashboard.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDTO {

    UserDTO  INSTANCE = Mappers.getMapper(UserDTO.class);

    UserEntity toUserEntity(User user);

    User toUserModel(UserEntity userEntity);

}
