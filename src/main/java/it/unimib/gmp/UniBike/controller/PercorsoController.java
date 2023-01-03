package it.unimib.gmp.UniBike.controller;

import java.util.ArrayList;
import java.util.Collection;
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

import it.unimib.gmp.UniBike.model.Ciclista;
import it.unimib.gmp.UniBike.model.Citta;
import it.unimib.gmp.UniBike.model.Percorso;
import it.unimib.gmp.UniBike.repository.CiclistaRepository;
import it.unimib.gmp.UniBike.repository.CittaRepository;
import it.unimib.gmp.UniBike.repository.PercorsoRepository;

@Controller
public class PercorsoController {
	private PercorsoRepository percorsoRepository;
	private CiclistaRepository ciclistaRepository;
	private CittaRepository cittaRepository;
	
	public PercorsoController(PercorsoRepository pr, CiclistaRepository cr, CittaRepository cittar) {
		this.percorsoRepository = pr;
		this.ciclistaRepository = cr;
		this.cittaRepository = cittar;
	}
	
	public ModelAndView creaMAVRicercaPercorso(List<Percorso> percorsi,
											   List<Citta> citta,
											   List<Ciclista> ciclisti) {
		ModelAndView maw = new ModelAndView();
		maw.addObject("percorsi", percorsi);
		maw.addObject("citta", citta);
		maw.addObject("ciclisti", ciclisti);
		maw.setViewName("ricercaPercorso");
		return maw;
	}
	
	@GetMapping("/ricercaPercorso")
	public ModelAndView paginaRicercaPercorso() {
		List<Percorso> percorsi = percorsoRepository.findAll();
		List<Citta> citta = this.cittaRepository.findAll();
		List<Ciclista> ciclisti = this.ciclistaRepository.findAll();
		return creaMAVRicercaPercorso(percorsi, citta, ciclisti);
	}
	
	@PostMapping("/ricercaPercorso")
	public ModelAndView ricercaPercorso(@RequestParam Ciclista ciclista,
										@RequestParam Citta citta) {
		Collection<Percorso> percorsi = ciclista.getPercorso();
		List<Percorso> outputPercorsi = new ArrayList<>();
		List<Citta> tutteCitta = this.cittaRepository.findAll();
		List<Ciclista> ciclisti = this.ciclistaRepository.findAll();
		for(Percorso p: percorsi) {
			if(p.getPartenza().equals(citta) || p.getArrivo().equals(citta))
				outputPercorsi.add(p);
		}
		return creaMAVRicercaPercorso(outputPercorsi, tutteCitta, ciclisti);
	}
	
	@GetMapping("/ciclista/{id}/nuovoPercorso")
	public ModelAndView paginaNuovoPercorso(@PathVariable("id") Long idCiclista) {
		ModelAndView maw = new ModelAndView();
		Optional<Ciclista> c = this.ciclistaRepository.findById(idCiclista);
		List<Citta> citta = this.cittaRepository.findAll();
		if(c.isPresent()) {
			maw.addObject("citta", citta);
			maw.addObject("ciclista", c.get());
			maw.setViewName("nuovoPercorso");
		}
		return maw;
	}
	
	@PostMapping("/nuovoPercorso")
	public RedirectView aggiungiPercorso(@ModelAttribute Percorso percorso) {
		percorsoRepository.save(percorso);
		return new RedirectView("/ciclista/" + percorso.getCiclista().getId());
	}
	
	@GetMapping("/ciclista/{idCic}/modificaPercorso/{idPerc}")
	public ModelAndView paginaModificaPercorso(@PathVariable("idCic") Ciclista ciclista,
											   @PathVariable("idPerc") Long idVecchioPercorso) {
		ModelAndView maw = new ModelAndView();
		List<Citta> citta = this.cittaRepository.findAll();
		maw.addObject("citta", citta);
		maw.addObject("ciclista", ciclista);
		maw.addObject("idVecchioPerc", idVecchioPercorso);
		maw.addObject("vecchioPerc", percorsoRepository.findById(idVecchioPercorso).get());
		maw.setViewName("modificaPercorso");
		return maw;
	}
	
	@PostMapping("/modificaPercorso/{id}")
	public RedirectView modificaPercorso(@ModelAttribute Percorso nuovoPercorso,
										 @PathVariable("id") Long idVecchioPercorso) {
		nuovoPercorso.setId(idVecchioPercorso);
		percorsoRepository.save(nuovoPercorso);
		return new RedirectView("/ciclista/" + nuovoPercorso.getCiclista().getId());
	}
}
