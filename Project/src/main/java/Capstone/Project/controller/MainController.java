package Capstone.Project.controller;

import Capstone.Project.model.Article;
import Capstone.Project.model.Attendee;
import Capstone.Project.model.User;
import Capstone.Project.service.*;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @Autowired
    ConferenceService service;
    @Autowired
    UserService Uservice;
    @Autowired
    ConferenceSchedulerService scheduleService;
    @Autowired
    ArticleService articleService;



    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView LoginMV = new ModelAndView("/index");
        LoginMV.addObject("Conferences",scheduleService.schedule(service.findAllSession()));
        return LoginMV;
    }


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView mv = new ModelAndView("/signup");
        return mv;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("/participant/register");
        return mv;
    }
    
    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public ModelAndView participantHomepage() {
        ModelAndView mv = new ModelAndView("/participant/index");
        return mv;
    }
    
    @RequestMapping(value = "/homePageSpeaker", method = RequestMethod.GET)
    public ModelAndView speakerHomepage() {
        ModelAndView mv = new ModelAndView("/speaker/index");
        return mv;
    }


    @RequestMapping(value = "/conferences", method = RequestMethod.GET)
    public ModelAndView conferences(){
        ModelAndView mv = new ModelAndView("/participant/conferences");

        return mv;
    }
    @RequestMapping(value = {"/createconf", "/speaker/create.html"} , method = RequestMethod.GET)
    public ModelAndView CreateConf(){
       ModelAndView CreateMV = new ModelAndView("/speaker/create");
        CreateMV.addObject("ArticleInfo", new Article());
        return CreateMV;
    }

    @RequestMapping(value = {"/index", "index.html"} , method = RequestMethod.POST)
    public ModelAndView CreateConfPost(@Valid @ModelAttribute("ArticleInfo") Article article){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ArticleInfo", article);
        mv.addObject("Sessions",service.findAllSession());
        mv.addObject("Conferences",scheduleService.schedule(service.findAllSession()));
        articleService.CreateArticle(article);
        return mv;
    }
    @RequestMapping(value = "/hostconf" , method = RequestMethod.GET)
    public ModelAndView HostConf(){
        ModelAndView HostMV = new ModelAndView("/speaker/conferences");
        return HostMV;
    }

    @RequestMapping(value = "/speakerSign" , method = RequestMethod.GET)
    public ModelAndView SpeakerRegister(){
        ModelAndView SpeakerRegisterMV = new ModelAndView("/speakerSign");
        SpeakerRegisterMV.addObject("Attendee", new Attendee());
        return SpeakerRegisterMV;
    }

    @RequestMapping(value = {"/participantSign", "participantSign.html"} , method = RequestMethod.GET)
    public ModelAndView ParticipantRegister(){
        ModelAndView ParticipantRegisterMV = new ModelAndView("participantSign");
        ParticipantRegisterMV.addObject("ParticipantInfo", new Attendee());
        return ParticipantRegisterMV;
    }
    
    @RequestMapping(value = {"/participantSign", "participantSign.html"} , method = RequestMethod.POST)
    public ModelAndView ParticipantRC(@Valid @ModelAttribute("ParticipantInfo") Attendee attendee){
    	ModelAndView mv = new ModelAndView();
		mv.addObject("ParticipantInfo", attendee);
            Uservice.CreateAttendee(attendee);
        return mv;
    }

}