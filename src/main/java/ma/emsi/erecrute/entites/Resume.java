package ma.emsi.erecrute.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

@Entity
@DiscriminatorValue("RESUME")
public class Resume extends File{
}
