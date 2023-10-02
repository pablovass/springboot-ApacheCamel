package com.pablovass.mapper;
import com.pablovass.model.JsonData;
import com.pablovass.pojo.User;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User jsonToUser(JsonData jsonData);


}