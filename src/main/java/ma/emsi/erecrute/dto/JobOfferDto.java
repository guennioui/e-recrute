package ma.emsi.erecrute.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;
import lombok.ToString;
import ma.emsi.erecrute.entites.Candidacy;
import ma.emsi.erecrute.entites.Profession;
import ma.emsi.erecrute.entites.Recruiter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class JobOfferDto {
    private Long jobOfferId;
    private String jobTitle;
    private String jobDescription;
    private String jobType;
    private String requirements;
    private String location;
    private double salary;
    private LocalDate postedDate;
    private LocalDate deadLine;
    private boolean isActive;
    @JsonIgnore
    private List<Candidacy> candidacies = new ArrayList<>();
    @JsonIgnore
    private Recruiter recruiter;
    private Profession profession;
    private String recruiterUsername;
}
