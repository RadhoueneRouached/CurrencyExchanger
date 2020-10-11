package de.currency.exchanger.klt.web.controller;

import de.currency.exchanger.klt.models.ConverterModel;
import de.currency.exchanger.klt.models.ResponseModel;
import de.currency.exchanger.klt.rest.ConverterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * IndexController
 */
@Controller
public class IndexController {

    @Autowired
    ConverterServiceImpl converterService;

    /**
     * Index endpoint to show the index page
     *
     * @param model Spring's view model
     * @return view name
     */
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Karten&Konten");
        model.addAttribute("welcome", "Welcome to CE");
        model.addAttribute("applicationTitle", "Currency Converter");
        return "index";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public String doConvert(@ModelAttribute ConverterModel cModel, Model model,
                            HttpServletRequest request) {
        HttpStatus status = HttpStatus.OK;
        model.addAttribute("converterModel", cModel);
        model.addAttribute("title", "Karten&Konten KLT");
        ResponseModel responseModel = converterService.getConvertedValue(cModel.getBaseCurrency(), cModel.getTargetCurrency(),
                cModel.getSrcAmount());
        cModel.setTargetAmount(responseModel.getConvertedValue());
        cModel.setBaseCurrency(responseModel.getBaseCurrency());
        cModel.setTargetCurrency(responseModel.getTargetCurrency());
        return "convert";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.GET)
    public String doConvert(Model model) {
        ConverterModel cModel = converterService.getConverterModel();
        model.addAttribute("converterModel", cModel);
        model.addAttribute("title", "Karten&Konten");
        return "convert";
    }
}
