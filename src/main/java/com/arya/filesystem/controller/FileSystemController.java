package com.arya.filesystem.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arya.filesystem.model.SearchModel;
import com.arya.filesystem.service.FileSystemService;

@Controller
public class FileSystemController {
	
	@Autowired
    private FileSystemService fileSystemService;

	@GetMapping({"/"})
    public ModelAndView hello() {
        return new ModelAndView("hello", "search", new SearchModel());
    }
	
	@PostMapping({"/search"})
    public ModelAndView search(@Valid @ModelAttribute("search")SearchModel searchModel, BindingResult result, Map<String, Object> model) {
		if (result.hasErrors()) {
			return new ModelAndView("hello", "search", searchModel);
        }
        List<String> entries = fileSystemService.searchName(searchModel.getSearchString().toLowerCase());
        searchModel.setResult(entries);
        model.put("result", entries);
        return new ModelAndView("hello", "search", searchModel);
    }
}