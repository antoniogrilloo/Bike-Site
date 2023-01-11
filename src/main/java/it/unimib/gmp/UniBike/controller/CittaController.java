package it.unimib.gmp.UniBike.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import it.unimib.gmp.UniBike.model.Citta;
import it.unimib.gmp.UniBike.repository.CittaRepository;


@Controller
public class CittaController {

	private CittaRepository cittaRepository;
	
	public CittaController(CittaRepository cr) {
		this.cittaRepository = cr;
	}
	
	@GetMapping("/gestioneCitta")
	public ModelAndView paginaGestioneCitta() {
		ModelAndView mav = new ModelAndView();
		List<Citta> citta = this.cittaRepository.findAll();
		mav.addObject("citta", citta);
		mav.setViewName("gestioneCitta");
		return mav;
	}
	
	@GetMapping("/gestioneCitta/nuovaCitta")
	public ModelAndView paginaNuovaCitta() {
		return new ModelAndView("nuovaCitta");
	}
	
	@PostMapping("/gestioneCitta/aggiungiCitta")
	public RedirectView aggiuntaCitta(Citta citta) {
		cittaRepository.save(citta);
		return new RedirectView("/gestioneCitta");
	}
	
}
