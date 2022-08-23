package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.LabelDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Label;
import nl.novi.backendwhattoeat.repositories.LabelRepository;
import nl.novi.backendwhattoeat.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LabelService {


    private final LabelRepository labelRepository;

    private final MenuRepository menuRepository;

    private final MenuService menuService;

    public LabelService(LabelRepository labelRepository, MenuRepository menuRepository, MenuService menuService) {
        this.labelRepository = labelRepository;
        this.menuRepository = menuRepository;
        this.menuService = menuService;
    }

    public List<LabelDto> getAllLabels() {
        List<Label> labels = labelRepository.findAll();
        List<LabelDto> dtos = new ArrayList<>();
        for (Label lbl : labels) {
            dtos.add(transferToDto(lbl));
        }
        return dtos;
    }

    public LabelDto getLabel(long id) {
        Optional<Label> label = labelRepository.findById(id);
        if(label.isPresent()) {
            LabelDto lbl = transferToDto(label.get());
            return lbl;
        } else {
            throw new RecordNotFoundException("No label found");
        }
    }

    public LabelDto addLabel(LabelDto labelDto) {
        labelRepository.save(transferToLabel(labelDto));
        return labelDto;
    }

    public void deleteLabel(Long id) {
        labelRepository.deleteById(id);
    }

    public void updateLabel(Long id, LabelDto labelDto) {
        if(!labelRepository.existsById(id)) {
            throw new RecordNotFoundException("No label found");
        }
        Label storedLabel = labelRepository.findById(id).orElse(null);
        storedLabel.setId(labelDto.getId());
        storedLabel.setType(labelDto.getType());
        storedLabel.setWebLabel(labelDto.getWebLabel());
        storedLabel.setApiParameter(labelDto.getApiParameter());
        storedLabel.setDefinition(labelDto.getDefinition());
        labelRepository.save(storedLabel);
    }
    public List<LabelDto> transferLabelListToDtoList(List<Label> labels){
        List<LabelDto> labelDtoList = new ArrayList<>();

        for(Label lbl : labels) {
            LabelDto dto = transferToDto(lbl);
            if(lbl.getMenu() != null){
                dto.setMenuDto(menuService.transferToDto(lbl.getMenu()));
            }

            labelDtoList.add(dto);
        }
        return labelDtoList;
    }
    public void assignLabelToMenu(Long id, Long labelId) {
        var optionalMenu = menuRepository.findById(id);
        var optionalLabel = labelRepository.findById(id);

        if(optionalMenu.isPresent() && optionalLabel.isPresent()) {
            var menu = optionalMenu.get();
            var label = optionalMenu.get();

            menu.setLabels((List<Label>) label);
            menuRepository.save(menu);
        } else {
            throw new RecordNotFoundException();
        }
    }
    public Label transferToLabel(LabelDto dto){
        var label = new Label();

        label.setId(dto.getId());
        label.setType(dto.getType());
        label.setWebLabel(dto.getWebLabel());
        label.setApiParameter(dto.getApiParameter());
        label.setDefinition(dto.getDefinition());

        return label;
    }

    public LabelDto transferToDto(Label label){
        LabelDto dto = new LabelDto();

        dto.setId(label.getId());
        dto.setType(label.getType());
        dto.setWebLabel(label.getWebLabel());
        dto.setApiParameter(label.getApiParameter());
        dto.setDefinition(label.getDefinition());

        return dto;
    }

}
