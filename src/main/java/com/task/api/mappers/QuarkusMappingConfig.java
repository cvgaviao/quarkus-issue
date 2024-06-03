package com.task.api.mappers;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

@MapperConfig(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuarkusMappingConfig {
}
