package com.AppCha.appCha.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.AppCha.appCha.repository.ProdutoLeituraRepository;


@Controller
public class BuscaController {

    @Autowired
    private ProdutoLeituraRepository pr;


    //GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    //POST
    @RequestMapping(value = "/busca", method = RequestMethod.POST)
    public ModelAndView buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome){

        ModelAndView mv = new ModelAndView("index");
        String mensagem = "Resultados da busca por " + buscar;


        if (nome.equals("nomeProduto")) {

            mv.addObject("produtos", pr.findByNomeProduto(buscar));

        } else if (nome.equals("nomeTipo")) {

            mv.addObject("produtos", pr.findByNomeTipo(buscar));

        } else {

            mv.addObject("produtos", pr.findByNomeTipoOuNomeProduto(buscar));


        }

        mv.addObject("mensagem", mensagem);

        return mv;
    }

}
