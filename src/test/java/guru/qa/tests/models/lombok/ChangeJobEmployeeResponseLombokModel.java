package guru.qa.tests.models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeJobEmployeeResponseLombokModel {
    String changeBodyName;
    String ChangeBodyJob;
}
