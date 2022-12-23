package it.unimib.gmp.UniBike.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		//ciclisti.add(new Ciclista("Prova", "cognome", "1111111", Disciplina.RIDER));
		//ciclistaRepository.save(ciclisti.get(0));
		//ciclistaRepository.flush();
		//System.out.println(ciclisti.get(0).getSfida());
		
		maw.addObject("ciclisti", ciclisti);
		maw.setViewName("index");
		return maw;
	}
}
