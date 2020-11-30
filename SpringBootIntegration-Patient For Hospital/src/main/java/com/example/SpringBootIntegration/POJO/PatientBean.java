package com.example.SpringBootIntegration.POJO;

import java.util.List;

public class PatientBean {
    private List<Patient> patientslist;

    public List<Patient> getPatientslist() {
        return patientslist;
    }

    public void setPatientslist(List<Patient> patientslist) {
        this.patientslist = patientslist;
    }
}

