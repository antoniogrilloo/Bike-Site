package it.unimib.gmp.UniBike.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import it.unimib.gmp.UniBike.exception.AggiungiBiciFormException;
import it.unimib.gmp.UniBike.model.AggiungiBiciForm;
import it.unimib.gmp.UniBike.model.Bici;
import it.unimib.gmp.UniBike.model.Ciclista;
import it.unimib.gmp.UniBike.repository.BiciRepository;
import it.unimib.gmp.UniBike.repository.CiclistaRepository;

@Controller
public class BiciController {
	
	private BiciRepository bici;
	private CiclistaRepository ciclistaRepository;
	
	public BiciController(BiciRepository bici, CiclistaRepository ciclistaRepository) {
		super();
		this.bici = bici;
		this.ciclistaRepository = ciclistaRepository;
	}

	@GetMapping("/bici")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		List<Bici> b = this.bici.findAll();
		
		mv.addObject("bici", b);
		mv.setViewName("bici");
		return mv;
	}
	
	@GetMapping("/bici/nuovaBici")
	public ModelAndView nuovaBici() {
		return new ModelAndView("nuovaBici");
	}
	
	@PostMapping("/bici/aggiungiBici")
	public RedirectView aggiungiBici(@ModelAttribute AggiungiBiciForm form) {
		try {
			Bici b = form.getBici();
			bici.save(b);
		} catch (AggiungiBiciFormException e) {
			e.printStackTrace();
		}
		return new RedirectView("/bici");
	}
	
	@GetMapping("/associaBici/{idCiclista}")
	public ModelAndView getFormAssociazione(@PathVariable("idCiclista") Long idCiclista) {
		ModelAndView m = new ModelAndView();
		Optional<Ciclista> c = this.ciclistaRepository.findById(idCiclista);
		List<Bici> biciSalvate = this.bici.findAll();
		if(c.isPresent()) {
			biciSalvate.removeAll(c.get().getBici());
			m.addObject("bici", biciSalvate);
			m.addObject("ciclista", c.get());
			m.setViewName("associaBici");
		}
		return m;
	}
	
	@PostMapping("/associaBici/{idCiclista}")
	public RedirectView associaBici(@PathVariable("idCiclista") Long idCiclista, @RequestParam Long idBici) {
		Optional<Ciclista> c = this.ciclistaRepository.findById(idCiclista);
		Optional<Bici> b = bici.findById(idBici);
		if(c.isPresent() && b.isPresent()) {
			c.get().addBici(b.get());
			this.ciclistaRepository.save(c.get());
		}
		return new RedirectView("/ciclista/" + idCiclista);
	}
}

