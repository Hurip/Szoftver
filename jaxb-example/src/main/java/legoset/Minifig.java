package legoset;

import lombok.Data;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Minifig {

    @XmlValue
    private String name;

    @XmlAttribute
    private int count;

    public Minifig(String name, int count) {
        this.name = name;
        this.count = count;
    }
}