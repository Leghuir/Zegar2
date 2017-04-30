package pl.simple.zegarki.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.simple.zegarki.services.CollectionServiceBasic;
import pl.simple.zegarki.services.NotificationService;
import pl.simple.zegarki.basic.WatchType;
import pl.simple.zegarki.entities.WatchHolder;



@Controller
public class CollectionController {

    @Autowired
    // @Qualifier("spring")
    private CollectionServiceBasic CollectionService;

    @Autowired
    private NotificationService notificationService;

    @ModelAttribute("typyAll")
    public List<WatchType> populateStatusy() {
        return Arrays.asList(WatchType.ALL);
    }

    @ModelAttribute("watchAll")
    public List<WatchHolder> populateCoins() {
        return this.CollectionService.findAll();
    }

    @ModelAttribute("watchesToSell")
    public List<WatchHolder> populateWatchesToSell() {
        return this.CollectionService.findAllToSell();
    }

    @ModelAttribute("watchLast3")
    public List<WatchHolder> populateLast3Watches() {
        return this.CollectionService.findLatest3();
    }

    @RequestMapping({ "/", "/index" })
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/watches", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        model.addAttribute("MyMessages",  notificationService.getNotificationMessages());
        return "Collection";
    }

    @RequestMapping("/tosell")
    public String showToSellPage() {
        return "tosell";
    }

}
