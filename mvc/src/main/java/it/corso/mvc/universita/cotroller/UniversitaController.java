package it.corso.mvc.universita.cotroller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	//prova 
	
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
	StudCdlFactory scCdlFactory;

	@RequestMapping(value = "/listacorsi", method = RequestMethod.GET)
	public ModelAndView getCorsi() {
		List<CorsoDiLaurea> cdl = corsiDiLaureaDao.readCdlAll();

		ModelAndView modelAndView = new ModelAndView("cdlView", "corsi", cdl);
		logger.info("lista corsi " + cdl.get(0).getCdlNome());

		return modelAndView;
	}

	@RequestMapping(value = "/corso/{id}", method = RequestMethod.GET)
	public ModelAndView getCorsoById(@PathVariable int id) {
		CorsoDiLaurea cdlbyid = corsiDiLaureaDao.readCdlById(id);

		ModelAndView modelAndView = new ModelAndView("cdlViewById", "corso", cdlbyid);
		return modelAndView;
	}

	@RequestMapping(value = "/stud", method = RequestMethod.GET)
	public ModelAndView getAllStud() {
		List<Studente> stu = studentiDao.readAllStu();

		ModelAndView modelAndView = new ModelAndView("stuView", "stu", stu);
		return modelAndView;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView showForm() {
		ModelAndView modelAndView = new ModelAndView("selectCorsoById", "corso", new CorsoDiLaurea());
		return modelAndView;
	}

	@RequestMapping(value = "/selectCorso", method = RequestMethod.POST)
	public ModelAndView ricercaCorso(@Valid @ModelAttribute("corso") CorsoDiLaurea cdl, BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("selectCorsoById", "corso", cdl);
			return modelAndView;
		}
//ciao
		CorsoDiLaurea risultato = corsiDiLaureaDao.readCdlById(cdl.getCdlId());
		ModelAndView modelAndView = new ModelAndView("selectCorsoById", "corso", risultato);
		return modelAndView;
	}

	@RequestMapping(value = "/formStud", method = RequestMethod.GET)
	public ModelAndView showFormStud() {

		List<CorsoDiLaurea> cdl = corsiDiLaureaDao.readCdlAll();
		scCdlFactory.setCdl(cdl);
		Studente studente = new Studente();
		scCdlFactory.setStu(studente);

		ModelAndView modelAndView = new ModelAndView("insertStudView", "iscrizione", scCdlFactory);
		return modelAndView;
	}

	@RequestMapping(value = "/insertStudente", method = RequestMethod.POST)
	public ModelAndView insertStud(@Valid @ModelAttribute("iscrizione") StudCdlFactory stud, BindingResult result) {

		if (result.hasErrors()) {

			return new ModelAndView("insertStudView", "iscrizione", stud);
		}

		AnnoAccademico aa = new AnnoAccademico(2018);
		CorsoDiLaurea cdl = corsiDiLaureaDao.readCdlById(Integer.valueOf(stud.getId()));

		Studente studres = studentiDao.createStu(stud.getStu().getStuCognome(), stud.getStu().getStuNome(),
				stud.getStu().getStuSesso(), aa, cdl);
		List<CorsoDiLaurea> cdlList = corsiDiLaureaDao.readCdlAll();

		stud.setCdl(cdlList);
		stud.setStu(studres);

		ModelAndView modelAndView = new ModelAndView("insertStudView", "iscrizione", stud);
		return modelAndView;
	}



}
