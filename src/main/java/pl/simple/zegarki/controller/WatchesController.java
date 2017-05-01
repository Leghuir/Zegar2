package pl.simple.zegarki.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.simple.zegarki.services.CollectionServiceBasic;
import pl.simple.zegarki.services.NotificationService;
import pl.simple.zegarki.basic.Watch;
import pl.simple.zegarki.basic.WatchType;
import pl.simple.zegarki.entities.Moneta;
import pl.simple.zegarki.entities.WatchEntity;
import pl.simple.zegarki.entities.WatchHolder;
import pl.simple.zegarki.entities.WorkingWatch;


@Controller
public class WatchesController {

    @Autowired
    // @Qualifier("spring")
    private CollectionServiceBasic WatchService;

    @Autowired
    private NotificationService notifyService;

    @ModelAttribute("typyAll")
    public List<WatchType> populateStatusy() {
        return Arrays.asList(WatchType.ALL);
    }

    @RequestMapping(value = "/watches/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") int id, final ModelMap model) {
        Optional<WatchHolder> result;
        result = WatchService.findById(id);
        if (result.isPresent()) {
            WatchHolder watch = result.get();
            WorkingWatch watch2=watch.reapir();
            model.addAttribute("workingWatch", watch2);
            return "watch";
        } else {
            notifyService.addErrorMessage("Cannot find watch #" + id);
            model.clear();
            return "redirect:/watches";
        }
    }

   /* @RequestMapping(value = "/watches/{id}/json", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<WatchHolder> viewAsJson(@PathVariable("id") int id, final ModelMap model) {
        Optional<WatchHolder> result;
        result = WatchService.findById(id);
        if (result.isPresent()) {
            WatchHolder watch = result.get();
            return new ResponseEntity<WatchHolder>(watch, HttpStatus.OK);
        } else {
            notifyService.addErrorMessage("Cannot find watch #" + id);
            model.clear();
            return new ResponseEntity<WatchHolder>(HttpStatus.NOT_FOUND);
        }
    }*/

    @RequestMapping(value = "/watches", params = { "save" }, method = RequestMethod.POST)
    public String saveMoneta(WorkingWatch watch, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "watch";
        }
        Optional<Watch> result = WatchService.edit(watch);
        if (result.isPresent())
            notifyService.addInfoMessage("Zapis udany");
        else
            notifyService.addErrorMessage("Zapis NIE udany");
        model.clear();
        return "redirect:/watches";
    }

    @RequestMapping(value = "/watches", params = { "create" }, method = RequestMethod.POST)
    public String createMoneta(WorkingWatch watch, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "watch";
        }
        WatchService.create(new WatchHolder(watch));
        model.clear();
        notifyService.addInfoMessage("Zapis nowej udany");
        return "redirect:/watches";
    }

    @RequestMapping(value = "/watches", params = { "remove" }, method = RequestMethod.POST)
    public String removeRow(final WatchHolder watch, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("remove"));
        Optional<Boolean> result = WatchService.deleteById(rowId.intValue());
        return "redirect:/watches";
    }

    @RequestMapping(value = "/watches/create", method = RequestMethod.GET)
    public String showMainPages(final WorkingWatch watch) {
        return "watch";
    }
}