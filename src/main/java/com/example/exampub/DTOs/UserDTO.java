package com.example.exampub.DTOs;

import com.example.exampub.models.User;
import lombok.Data;
import java.time.LocalDate;
import java.time.Period;

@Data
public class UserDTO {
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private Double pocket;

    public UserDTO(User user) {
        this.name = user.getName();
        this.isActive = user.isActive();
        this.isAdult = UserDTO.setIfIsAdult(user.getDateOfBirth());
        this.pocket = user.getPocket();
    }
    private static boolean setIfIsAdult(LocalDate birthdate) {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthdate, currentDate);
        int legalAdultAge = 18;
        return age.getYears() >= legalAdultAge;
    }
}
