package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.LabelDto;
import nl.novi.backendwhattoeat.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("labels")
public class LabelController {

    private final LabelService labelService;

    @Autowired
    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }


    @GetMapping
    public List<LabelDto> getAllLabels() {


        List<LabelDto> dtos = labelService.getAllLabels();

        return dtos;
    }

    @GetMapping("{id}")
    public LabelDto getLabelById(@PathVariable("id") Long id) {

        LabelDto labelDto = labelService.getLabelById(id);

        return labelDto;
    }

    @PostMapping
    public LabelDto addLabel(@RequestBody LabelDto labelDto) {
        LabelDto newLabel = labelService.addLabel(labelDto);
        return newLabel;
    }

    @DeleteMapping("{id}")
    public void deleteLabel(@PathVariable("id") Long id) {
        labelService.deleteLabel(id);
    }

}