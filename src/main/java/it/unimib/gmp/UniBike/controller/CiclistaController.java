package it.unimib.gmp.UniBike.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import it.unimib.gmp.UniBike.model.Bici;
import it.unimib.gmp.UniBike.model.Ciclista;
import it.unimib.gmp.UniBike.model.Ciclista.Disciplina;
import it.unimib.gmp.UniBike.model.Percorso;
import it.unimib.gmp.UniBike.repository.BiciRepository;
import it.unimib.gmp.UniBike.repository.CiclistaRepository;
import it.unimib.gmp.UniBike.repository.PercorsoRepository;


@Controller
public class CiclistaController {
	private CiclistaRepository ciclistaRepository;
	private PercorsoRepository percorsoRepository;
	private BiciRepository biciRepository;
	
	public CiclistaController(CiclistaRepository cr, PercorsoRepository pr, BiciRepository br) {
		this.ciclistaRepository = cr;
		this.percorsoRepository = pr;
		this.biciRepository = br;
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
		if(c.isPresent()){
			maw.addObject("ciclista", c.get());
			maw.setViewName("ciclista");
			return maw;
		}
		return null;
	}
	
	@GetMapping("/ciclista/nuovoCiclista")
	public ModelAndView nuovoCiclista() {
		ModelAndView maw = new ModelAndView();
		maw.setViewName("nuovoCiclista");
		return maw;
	}
	
	@PostMapping("/ciclista/nuovoCiclista")
	public RedirectView nuovoCiclistaCreato(Ciclista ciclista) {
		ciclistaRepository.save(ciclista);
		return new RedirectView("/");
	}
	
	@PostMapping("/ciclista/cambiaDisciplina/{idCiclista}")
	public RedirectView cambiaDiscipliina(@PathVariable Long idCiclista, @RequestParam String nuovaDisciplina) {
		Optional<Ciclista> ciclista = this.ciclistaRepository.findById(idCiclista);
		if(ciclista.isPresent()) {
			ciclista.get().setDisciplina(Disciplina.valueOf(nuovaDisciplina));
			ciclistaRepository.save(ciclista.get());
		}
		return new RedirectView("/ciclista/" + idCiclista);
	}
	
	@PostMapping("/ciclista/eliminaSfida/{idCiclista}")
	public RedirectView eliminaSfida(@PathVariable Long idCiclista, @RequestParam Long idSfidante) {
		Optional<Ciclista> ciclista = this.ciclistaRepository.findById(idCiclista);
		Optional<Ciclista> sfidante = this.ciclistaRepository.findById(idSfidante);
		if(ciclista.isPresent() && sfidante.isPresent()) {
			ciclista.get().deleteSfida(sfidante.get());
			ciclistaRepository.save(ciclista.get());
			ciclistaRepository.save(sfidante.get());
		}
		return new RedirectView("/ciclista/" + idCiclista);
		
	}
	
	@PostMapping("/ciclista/eliminaPercorso/{idCiclista}")
	public RedirectView eliminaPercorso(@PathVariable Long idCiclista, @RequestParam Long idPercorso) {
		Optional<Ciclista> ciclista = this.ciclistaRepository.findById(idCiclista);
		Optional<Percorso> percorso = this.percorsoRepository.findById(idPercorso);
		if(ciclista.isPresent() && percorso.isPresent()) {
			ciclista.get().deletePercorso(percorso.get());
			ciclistaRepository.save(ciclista.get());
			percorsoRepository.delete(percorso.get());
		}
		return new RedirectView("/ciclista/" + idCiclista);
	}
	
	@PostMapping("/ciclista/eliminaBici/{idCiclista}")
	public RedirectView eliminaBici(@PathVariable Long idCiclista, @RequestParam Long idBici) {
		Optional<Ciclista> ciclista = this.ciclistaRepository.findById(idCiclista);
		Optional<Bici> bici = this.biciRepository.findById(idBici);
		if(ciclista.isPresent() && bici.isPresent()) {
			ciclista.get().deleteBici(bici.get());
			ciclistaRepository.save(ciclista.get());
			biciRepository.save(bici.get());
		}
		return new RedirectView("/ciclista/" + idCiclista);
	}
	
	@PostMapping("/ciclista/nuovaSfida/{idCiclista}")
	public RedirectView nuovaSfida(@PathVariable Long idCiclista, @RequestParam Long idSfidante) {
		Optional<Ciclista> ciclista = this.ciclistaRepository.findById(idCiclista);
		Optional<Ciclista> sfidante = this.ciclistaRepository.findById(idSfidante);
		if(ciclista.isPresent() && sfidante.isPresent()) {
			ciclista.get().addSfidante(sfidante.get());
			ciclistaRepository.save(ciclista.get());
		}
		return new RedirectView("/ciclista/" + idCiclista);
	}
	
	@GetMapping("/ciclista/nuovaSfida/{idCiclista}")
	public ModelAndView nuovaSfida(@PathVariable("idCiclista") Long idCiclista) {
		ModelAndView maw = new ModelAndView();
		List<Ciclista> ciclisti = ciclistaRepository.findAll();
		Optional<Ciclista> c = this.ciclistaRepository.findById(idCiclista);
		if(c.isPresent()){
			List<Ciclista> s = List.copyOf(c.get().getSfida());
			ciclisti.remove(c.get());
			ciclisti.removeAll(s);
			maw.addObject("ciclisti", ciclisti);
			maw.addObject("ciclista", c.get());
			maw.setViewName("nuovaSfida");
			return maw;
		}
		return null;
	}	
}
