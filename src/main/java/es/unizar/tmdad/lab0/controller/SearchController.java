package es.unizar.tmdad.lab0.controller;

import es.unizar.tmdad.lab0.service.TwitterLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class SearchController {

    @Autowired
    TwitterLookupService twitter;

    @RequestMapping("/")
    public String greeting() {
        return "index";
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Tweet> search(@RequestParam String q) {
        //m.addAttribute("res", twitter.search(q));
        //return "search :: content";
        return twitter.search(q).getTweets();
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UncategorizedApiException.class)
    public ResponseEntity handleUncategorizedApiException() {
        //m.addAttribute("res", twitter.emptyAnswer());
        return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
    }
}