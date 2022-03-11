package com.AppCha.appCha.controller;

import com.AppCha.appCha.repository.TipoRepository;
import org.springframework.stereotype.Controller;


@Controller
public class TipoController {

    private TipoRepository tipoRepository;

    public TipoController(TipoRepository tipoRepository) {

        this.tipoRepository = tipoRepository;
    }

}
