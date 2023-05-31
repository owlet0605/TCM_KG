package com.example.tcm_kgsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TcmWithBLOBs extends Tcm {
    private String tcmCome;

    private String tcmTraits;

    private String tcmPlant;

    private String tcmDistribution;

    private String tcmProduce;

    private String tcmNote;

    private String tcmFunction;

    private String tcmClinical;

    private String tcmPharmacological;

    private String tcmChemical;
}