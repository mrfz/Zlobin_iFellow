package ru.iFellow.dto.rickAndMorty;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class SeriesCharacter {
    public long id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Origin origin;
    public Location location;
    public String image;
    public ArrayList<String> episode;
    public String url;
    public Date created;
}
