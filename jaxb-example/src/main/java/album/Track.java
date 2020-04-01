package album;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Track {

    @XmlValue
    private String title;

    @XmlAttribute
    private int length;

    public Track() {}

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

}