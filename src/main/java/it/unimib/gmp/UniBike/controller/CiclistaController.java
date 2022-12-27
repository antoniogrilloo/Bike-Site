package it.unimib.gmp.UniBike.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import it.unimib.gmp.UniBike.model.Ciclista;
import it.unimib.gmp.UniBike.model.Ciclista.Disciplina;
import it.unimib.gmp.UniBike.repository.CiclistaRepository;


@Controller
public class CiclistaController {
	private CiclistaRepository ciclistaRepository;
	
	public CiclistaController(CiclistaRepository cr) {
		this.ciclistaRepository = cr;
	}
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView maw = new ModelAndView();
		List<Ciclista> ciclisti = ciclistaRepository.findAll();
		
		maw.addObject("ciclisti", ciclisti);
		maw.setViewName("index");
		return maw;
	}
	
	@GetMapping("/ciclista/{idCiclista}")
	public ModelAndView infoCiclista(@PathVariable("idCiclista") Long idCiclista) {
		ModelAndView maw = new ModelAndView();
		Optional<Ciclista> c = this.ciclistaRepository.findById(idCiclista);
		// Eventuali eccezioni o gestione con isPresent
		maw.addObject("ciclista", c.get());
		maw.setViewName("ciclista");
		return maw;
	}
	
	
}
