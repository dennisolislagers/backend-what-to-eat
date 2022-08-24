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
    public LabelDto getlabel(@PathVariable("id") Long id) {

        LabelDto labelDto = labelService.getLabel(id);

        return labelDto;
    }

    @PostMapping
    public LabelDto addLabel(@RequestBody LabelDto dto) {
        LabelDto labelDto = labelService.addLabel(dto);
        return labelDto;
    }

    @DeleteMapping("{id}")
    public void deleteLabel(@PathVariable("id") Long id) {
        labelService.deleteLabel(id);
    }

    @PutMapping("{id}/{menuId}")
    public void assignMenuToLabel(@PathVariable("id") Long id, @PathVariable("menuId") Long menuId) {
        labelService.assignMenuToLabel(id, menuId);
    }

    @PutMapping("{id}")
    public LabelDto updateLabel(@PathVariable("id") Long id, @RequestBody LabelDto labelDto) {
        labelService.updateLabel(id, labelDto);
        return labelDto;
    }
}