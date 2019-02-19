package info.kowalczuk.spring.impl.controller;

import info.kowalczuk.spring.api.data.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public String searchAll(Model model){
        model.addAttribute("docs", documentRepository.getAll());
        return "all";
    }
}
