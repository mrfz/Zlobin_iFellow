package ru.iFellow.dto.rickAndMorty;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Episode {
    public int id;
    public String name;
    public String air_date;
    public String episode;
    public ArrayList<String> characters;
    public String url;
    public Date created;
}
