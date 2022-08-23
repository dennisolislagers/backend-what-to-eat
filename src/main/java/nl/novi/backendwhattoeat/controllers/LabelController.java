package nl.novi.backendwhattoeat.controllers;

import nl.novi.backendwhattoeat.dtos.LabelDto;
import nl.novi.backendwhattoeat.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LabelController {
    private final LabelService labelService;

    @Autowired
    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }


    @GetMapping("/labels")
    public List<LabelDto> getAllLabels() {


        List<LabelDto> dtos = labelService.getAllLabels();

        return dtos;
    }

    @GetMapping("/labels/{id}")
    public LabelDto getlabel(@PathVariable("id") Long id) {

        LabelDto labelDto = labelService.getLabel(id);

        return labelDto;
    }

    @PostMapping("/labels")
    public LabelDto addLabel(@RequestBody LabelDto dto) {
        LabelDto labelDto = labelService.addLabel(dto);
        return labelDto;
    }

    @DeleteMapping("/labels/{id}")
    public void deleteLabel(@PathVariable("id") Long id) {
        labelService.deleteLabel(id);
    }

    @PutMapping("/labels/{id}")
    public LabelDto updateLabel(@PathVariable("id") Long id, @RequestBody LabelDto labelDto) {
        labelService.updateLabel(id, labelDto);
        return labelDto;
    }
}