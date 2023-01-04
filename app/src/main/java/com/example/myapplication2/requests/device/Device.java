package com.example.myapplication2.requests.device;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Device {
    private Long id;
    private String name;
    private String equipmentType;
    private String equipmentDescription;
    private String equipmentModel;
    private String equipmentName;
    private Long energyId;
    private String energyName;
    private Long energyPurposeId;
    private String energyPurposeName;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void setEnergyId(Long energyId) {
        this.energyId = energyId;
    }

    public void setEnergyName(String energyName) {
        this.energyName = energyName;
    }

    public void setEnergyPurposeId(Long energyPurposeId) {
        this.energyPurposeId = energyPurposeId;
    }

    public void setEnergyPurposeName(String energyPurposeName) {
        this.energyPurposeName = energyPurposeName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public Long getEnergyId() {
        return energyId;
    }

    public String getEnergyName() {
        return energyName;
    }

    public Long getEnergyPurposeId() {
        return energyPurposeId;
    }

    public String getEnergyPurposeName() {
        return energyPurposeName;
    }
}
