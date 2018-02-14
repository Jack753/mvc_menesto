package it.corso.mvc.universita.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.corso.mvc.universita.dao.interfaces.ICorsiDiLaureaDao;
import it.corso.mvc.universita.dao.interfaces.IEsamiDao;
import it.corso.mvc.universita.dao.interfaces.IMaterieDao;
import it.corso.mvc.universita.dao.interfaces.IStudentiDao;
import it.corso.mvc.universita.dao.interfaces.IUtentiDao;
import it.corso.mvc.universita.model.AnnoAccademico;
import it.corso.mvc.universita.model.CorsoDiLaurea;
import it.corso.mvc.universita.model.Studente;
import it.corso.mvc.universita.model.factory.StudCdlFactory;

@Controller
@RequestMapping("/uni")
public class UniversitaController {
	
	private Logger logger = Logger.getLogger(UniversitaController.class);
	@Autowired
	ICorsiDiLaureaDao corsiDiLaureaDao;
	@Autowired
	IEsamiDao esamiDao;
	@Autowired
	IMaterieDao materieDao;
	@Autowired
	IStudentiDao studentiDao;
	@Autowired
	IUtentiDao utentiDao;
	
	@Autowired
	StudCdlFactory sCdlFactory;
	
	// Lista di tutti i Corsi Di Laurea
	@RequestMapping(value = "/listacorsi", method = RequestMethod.GET)
	public ModelAndView getCorsi() {
		List<CorsoDiLaurea> cdl = corsiDiLaureaDao.readCdlAll();
		ModelAndView modelAndView = new ModelAndView("cdlView", "corsi", cdl);
		logger.debug(String.format("Lista di tutti i corsi di laurea %s", cdl.get(0).getCdlNome()
				));
		return modelAndView;
	}
	
	// Vista di un solo Corso di Laurea 
	@RequestMapping(value = "/corso/{id}", method = RequestMethod.GET)
	public ModelAndView getCorsoById(@PathVariable int id) {
		CorsoDiLaurea cdl = corsiDiLaureaDao.readCdlById(id);
		ModelAndView modelAndView = new ModelAndView("cdlViewById", "corso", cdl);
		return modelAndView;
	}

	// Lista di tutti i Studenti
	@RequestMapping(value = "/listastudenti", method = RequestMethod.GET)
	public ModelAndView getStudenti() {
		List<Studente> stus = studentiDao.getStudenti();
		ModelAndView modelAndView = new ModelAndView("stuView", "stu", stus);
		return modelAndView;
	}
	
	// Form Corsi Di Laurea
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView showForm() {
		ModelAndView modelAndView = new ModelAndView("selectCorsoById", "corso", new CorsoDiLaurea());
		return modelAndView;
	}
	
	// Trova il Corso Di Laurea cercato in showForm()
	@RequestMapping(value = "selectCorso", method = RequestMethod.POST)
	public ModelAndView ricercaCorso(@Valid @ModelAttribute("corso") CorsoDiLaurea cdl, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("selectCorsoById", "corso", new CorsoDiLaurea());
		}
		CorsoDiLaurea risultato = corsiDiLaureaDao.readCdlById(cdl.getCdlId());
		ModelAndView modelAndView = new ModelAndView("selectCorsoById", "corso", risultato);
		return modelAndView;
	}
	
	// Crea uno Studente
	@RequestMapping(value = "/form/studente", method = RequestMethod.GET)
	public ModelAndView formStudente() {
		List<CorsoDiLaurea> cdl = corsiDiLaureaDao.readCdlAll();
		sCdlFactory.setCdl(cdl);
		Studente studente = new Studente();
		sCdlFactory.setStu(studente);
		ModelAndView modelAndView = new ModelAndView("insertStudView", "studente", sCdlFactory);
		return modelAndView;
	}
	
	// Stampa lo studente creato dalla form del metodo formStudente()
	@RequestMapping(value = "/form/studenteCreato", method = RequestMethod.POST)
	public ModelAndView creaStudente(@Valid @ModelAttribute("studente") StudCdlFactory stud, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("insertStudView", "studente", stud);
			return modelAndView;
		}
		AnnoAccademico accademico = new AnnoAccademico(2018);
		CorsoDiLaurea corsoDiLaurea = corsiDiLaureaDao.readCdlById(Integer.valueOf(stud.getId()));
		Studente studente = studentiDao.createStu(stud.getStu().getStuCognome(),
				stud.getStu().getStuNome(), stud.getStu().getStuSesso(), accademico, corsoDiLaurea);
		stud.setStu(studente);
		ModelAndView modelAndView = new ModelAndView("insertStudView", "studente", stud);
		return modelAndView;
	}

	// Cancella Corso Di Laurea tramite il metodo getCorsi()
	@RequestMapping(value = "/cancellaCorso/{id}", method = RequestMethod.GET)
	public ModelAndView removeCorsoDiLaurea(@PathVariable int id) {
		CorsoDiLaurea cdl = corsiDiLaureaDao.readCdlById(id);
		corsiDiLaureaDao.removeCdl(cdl);
		ModelAndView modelAndView = new ModelAndView("corsoCancellato", "corso", cdl);
		return modelAndView;
	}
	
	// Lista studenti inscritti ad un certo Corso Di Laurea
	@RequestMapping(value = "/listastudenti/{corso}", method = RequestMethod.GET)
	public ModelAndView getStudentiCorsoDiLaurea(@PathVariable String corso) {
		int id = Integer.valueOf(corso);
		List<Studente> stus = studentiDao.getStudentiCorso(id);
		ModelAndView modelAndView = new ModelAndView("studentiCorso", "studenti", stus);
		return modelAndView;
	}
	
}
