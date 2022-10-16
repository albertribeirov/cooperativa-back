package br.com.cooperativa.utils;

import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TypeUtils {

    final private ModelMapper modelMapper = new ModelMapper();

    public <T> T parseToEntity(Object dto, Class<T> entity) {
        return modelMapper.map(dto, entity);
    }

    public <T> T parseToDTO(Object entity, Class<T> dto) {
        return modelMapper.map(entity, dto);
    }

    public <T> List<T> parseToDTO(List<?> entity, Class<T> dto) {
        List<T> list = new ArrayList<>();

        entity.forEach(o -> list.add(modelMapper.map(o, dto)));

        return list;
    }

    public <T> List<T> parseToEntity(List<?> dto, Class<T> entity) {
        List<T> list = new ArrayList<>();

        dto.forEach(o -> list.add(modelMapper.map(o, entity)));

        return list;
    }

}
