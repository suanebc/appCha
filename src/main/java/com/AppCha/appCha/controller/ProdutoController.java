package com.AppCha.appCha.controller;


import com.AppCha.appCha.models.ProdutoLeitura;
import com.AppCha.appCha.models.Tipo;
import com.AppCha.appCha.repository.ProdutoLeituraRepository;
import com.AppCha.appCha.repository.TipoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.AppCha.appCha.models.ProdutoEscrita;
import com.AppCha.appCha.repository.ProdutoEscritaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoEscritaRepository produtoEscritaRepository;

    @Autowired
    private ProdutoLeituraRepository produtoLeituraRepository;

    @Autowired
    private TipoRepository tipoRepository;


    public ProdutoController(ProdutoEscritaRepository produtoEscritaRepository, TipoRepository tipoRepository, ProdutoLeituraRepository produtoLeituraRepository) {

        this.produtoEscritaRepository = produtoEscritaRepository;
        this.tipoRepository = tipoRepository;
        this.produtoLeituraRepository = produtoLeituraRepository;
    }

    //CADASTRA PRODUTO
    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("cha/formCha");

        Iterable<Tipo> tipos = tipoRepository.findAll();
        mv.addObject("tipos", tipos);

        return mv;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public String form(@Valid ProdutoEscrita produto, BindingResult result, RedirectAttributes attributes, @RequestParam("fileProduto")MultipartFile file) throws IOException {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastro";
        }
        try {
            produto.setImg(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        produtoEscritaRepository.save(produto);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
        return "redirect:/cadastro";

    }
    // EDITAR
    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public ModelAndView editar(long idproduto) {
        ModelAndView mv = new ModelAndView("cha/formChaEditar");

        Iterable<Tipo> tipos = tipoRepository.findAll();
        mv.addObject("tipos", tipos);

        ProdutoLeitura produtoEditar = produtoLeituraRepository.findById(idproduto).get();
        mv.addObject("produto", produtoEditar);


        return mv;
    }
    @RequestMapping(value = "/salvarEdicao", method = RequestMethod.POST)
    public String salvarEdicao(@Valid ProdutoEscrita produto, BindingResult result, RedirectAttributes attributes, @RequestParam("fileProduto")MultipartFile file) throws IOException {

        attributes.addFlashAttribute("successo", "Vaga alterada com sucesso!");
        try {
            produto.setImg(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        produtoEscritaRepository.save(produto);
        return "redirect:/produtos";
    }


    // LISTAR PRODUTO
    @RequestMapping("/produtos")
    public ModelAndView listaProduto() {
        ModelAndView mv = new ModelAndView("cha/listaCha");
        Iterable<ProdutoLeitura> produtos = produtoLeituraRepository.findAll();
        mv.addObject("produtos", produtos);

        return mv;
    }

    // DELETA PRODUTO
    @RequestMapping("/deletarProduto")
    public String deletarProduto(long idproduto) {
        produtoEscritaRepository.deleteById(idproduto);
        return "redirect:/produtos";
    }

    // CARREGAR IMAGEM
    @GetMapping("/imagem/{idproduto}")
    @ResponseBody
    public byte[] exibirImg(@PathVariable("idproduto") Long idproduto){
        ProdutoEscrita produto = produtoEscritaRepository.findById(idproduto).get();
        return produto.getImg();
    }
}