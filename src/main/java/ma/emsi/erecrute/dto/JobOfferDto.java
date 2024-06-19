package ma.emsi.erecrute.dto;

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
    private List<Candidacy> candidacies = new ArrayList<>();
    private Recruiter recruiter;
    private Profession profession;
}
