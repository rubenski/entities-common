package nl.codebase.entities.common.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.codebase.entities.common.FaceterConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Grants {

    private List<FaceterConstants.GRANT> grants = new ArrayList<>();

    public static Grants from(FaceterConstants.GRANT... grants) {
        return new Grants(Arrays.asList(grants));
    }

}
