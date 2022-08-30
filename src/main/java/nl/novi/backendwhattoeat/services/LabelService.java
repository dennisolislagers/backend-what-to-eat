package nl.novi.backendwhattoeat.services;

import nl.novi.backendwhattoeat.dtos.LabelDto;
import nl.novi.backendwhattoeat.exceptions.RecordNotFoundException;
import nl.novi.backendwhattoeat.models.Label;
import nl.novi.backendwhattoeat.repositories.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LabelService {

    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<LabelDto> getAllLabels() {
        List<Label> labelList = labelRepository.findAll();
        List<LabelDto> labelDtoList = new ArrayList<>();

        for (Label label : labelList) {
            LabelDto dto = transferToDto(label);
            labelDtoList.add(dto);

        }
        return labelDtoList;
    }

    public LabelDto getLabelById(long id) {
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
        var dto = new LabelDto();

        dto.id = label.getId();
        dto.type = label.getType();
        dto.webLabel = label.getWebLabel();
        dto.apiParameter = label.getApiParameter();
        dto.definition = label.getDefinition();

        return dto;
    }
}
