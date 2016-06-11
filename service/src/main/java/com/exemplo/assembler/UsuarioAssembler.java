package com.exemplo.assembler;

import com.exemplo.controller.dtos.UsuarioDTO;
import com.exemplo.domain.Usuario;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class UsuarioAssembler {

    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    MapperFacade mapper = mapperFactory.getMapperFacade();

    private void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Usuario.class, UsuarioDTO.class)
                .field("endereco.lougradouro", "endereco")
                .byDefault()
                .register();
    }

    public UsuarioDTO paraDto(Usuario entidade) {
        configure(mapperFactory);
        return mapper.map(entidade, new UsuarioDTO());
    }

}
