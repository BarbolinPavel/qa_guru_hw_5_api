package guru.qa.tests.models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddEmloyeeResponseLombokModel {
    String bodyName;
    String bodyJob;
}
