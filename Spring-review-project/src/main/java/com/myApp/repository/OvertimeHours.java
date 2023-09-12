package com.myApp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("OH")
@Component
public class OvertimeHours implements HoursRepository {
    @Override
    public int getHours() {
        return 15;
    }
}
